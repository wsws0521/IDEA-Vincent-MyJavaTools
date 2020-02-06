BEGIN

	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;
	# 开启事务
	START TRANSACTION;

	/* 如果发生双轨售电，取得一整月的阶梯累计值放入 tmp_stepcumu
	SELECT 	SUM(OCD_ENERGY) energy,
				m.MT_COMM_ADDR,
				CONVERT(varchar(10),DATEADD(mm, DATEDIFF(mm, 0,o.OD_DATE), 0),120) as LASTVENDDATE,
				ISFREE
	FROM ORDER_trn o inner join IPARA_MTRPOINT m on o.METERID=m.MTRPOINT_ID
	inner join IPARA_RESIDENT r on r.CUSTOMER_ID=m.ACTUAL_CUSTOMER_ID
	where m.ACTUAL_CUSTOMER_ID is not null
				and isnull(o.DELFLAG,0)=0 and o.isfree=0
				and OD_DATE>CONVERT(datetime,'2020-01-01 00:00:00.000',120)
	group by m.MT_COMM_ADDR,ISFREE,DATEADD(mm, DATEDIFF(mm, 0,o.OD_DATE), 0)
	order by m.MT_COMM_ADDR,DATEADD(mm, DATEDIFF(mm, 0,o.OD_DATE), 0),ISFREE
	*/

	# 1-临时表，用来存储本月新老系统都有累计电量的STS1累计值
	CREATE TEMPORARY TABLE temp_stephappy
	SELECT meter.METER_ID, sc.energy
	FROM tmp_stepcumu sc,
	inner join a_equip_meter meter on meter.assetno = sc.mt_comm_addr
	inner join a_mp_equipment_rela rela on meter.METER_ID = rela.EQUIPMENTID AND rela.EQUIPMENTTYPE = '02'
	inner join a_usagepoint point on rela.mp_id = point.mp_id
	inner join a_consumer cons on cons.cons_id = point.cons_id
	WHERE EXISTS (select * from VD_C_CUMU_VALUE cumu where cumu.CUMU_OBJ = '03' and cumu.CUMU_OBJ_ID = cons.cons_id and CUMU_ITEM = '0301'
					and DATE_FORMAT(cumu.START_TIME,'%Y%m') = DATE_FORMAT(str_to_date(sc.vendDate,'%Y-%m-%d'),'%Y%m'));

	# 2-插入次月累计值
	INSERT INTO VD_C_CUMU_VALUE
	 (LESSEE_ID,
		CUMU_ID,
		RULE_ID,
		CUMU_OBJ,
		CUMU_OBJ_ID,
		CUMU_ITEM,
		START_TIME,
		END_TIME,
		CUMU_VALUE,
		VALUE_UNIT)
	SELECT
		2,
		AMI_GET_SEQUENCE('SEQ_VD_C_CUMU_VALUE'),
		NULL,
		'03', -- 累计值所属对象：01用户02计量点03电表
		happy.meter_id,
		'0301', -- 累计数据项 0101免费额度0301累计充值量(资源/钱)0302累计充值金额(实收)
		DATE_ADD(CURDATE(), INTERVAL -DAY(CURDATE()) + 1 DAY), -- 累计开始时间
		LAST_DAY(CURDATE()), -- 累计结束时间
		-- DATE_ADD(DATE_ADD(CURDATE(), INTERVAL -DAY(CURDATE())+1 DAY), INTERVAL 1 MONTH),
		happy.energy,
		'KWH'
	FROM temp_stephappy happy;

	# 3-删除临时表
	DROP TEMPORARY TABLE IF EXISTS temp_stephappy;

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

	SELECT t_error into error_code;
	SELECT msg into error_msg;

END