DROP PROCEDURE IF EXISTS syn_7;
delimiter $$
CREATE PROCEDURE syn_7(OUT `error_code` integer, OUT `error_msg` text)

 BEGIN

	DECLARE freeValue decimal(18,2); 			/* 用户免费额度 */
	DECLARE cumuValue decimal(18,2); 			/* 表计累计值 */
	DECLARE currfreeValue decimal(18,2); 			/* 当前用户免费额度 */
	DECLARE meterNo  VARCHAR(64); 		/* 本月是否已经使用免费额度 */
	DECLARE consId VARCHAR(64); 		/* 用户id */
	DECLARE vendDate VARCHAR(64); 		/* 收费日期 */
	DECLARE maxCumuDate VARCHAR(64); 		/* 用户最大累计值时间 */
	declare isFree INT; /* 是否免费的累计值 */
	declare cumuCount INT; /* 周期范围内累计值数量 */
	DECLARE done int DEFAULT 0;

	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;

	# 暂时只管免费额度
	DECLARE cumuList CURSOR FOR SELECT cons.cons_id as consId,ljz.mt_comm_addr as meterNo, ljz.isfree as isFree, ljz.energy as freeValue, ljz.lastvenddate as vendDate
															from tmp_ljz ljz
														  inner join a_equip_meter meter on meter.assetno=ljz.mt_comm_addr
														  inner join a_mp_equipment_rela rela on meter.METER_ID = rela.EQUIPMENTID AND rela.EQUIPMENTTYPE='02'
														  inner join a_usagepoint point on rela.mp_id=point.mp_id
														  inner join a_consumer cons on cons.cons_id=point.cons_id
														  where ljz.isfree=1;

	# 定义循环结束done值改变逻辑
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

	# 开启事务
	START TRANSACTION;

	OPEN cumuList;
	REPEAT
		FETCH cumuList into consId,meterNo,isFree,freeValue,vendDate;
		IF NOT done THEN
				if isFree = 1 then
					#查询新系统对应收费日期周期用户免费值
					/*
					select ifnull(cumu.CUMU_VALUE,0) into currfreeValue
					from VD_C_CUMU_VALUE cumu
					where cumu.cumu_obj='01' and cumu.CUMU_OBJ_ID=consId and cumu.CUMU_ITEM='0101'
						and date_format(cumu.START_TIME,'%Y%m')=date_format(str_to_date(vendDate,'%Y-%m-%d'),'%Y%m');
					*/
					select COUNT(1) into currfreeValue
					from VD_C_CUMU_VALUE cumu
					where cumu.cumu_obj='01' and cumu.CUMU_OBJ_ID=consId and cumu.CUMU_ITEM='0101' and cumu.CUMU_VALUE > 0
						and date_format(cumu.START_TIME,'%Y%m')=date_format(str_to_date(vendDate,'%Y-%m-%d'),'%Y%m');

					if currfreeValue>0 THEN
						#查询用户最大免费累计日期
						select date_format(max(start_time),'%Y-%m-%d') into maxCumuDate
						 from VD_C_CUMU_VALUE
						where cumu_obj='01' AND CUMU_OBJ_ID=consId and CUMU_ITEM='0101' and CUMU_VALUE>0;

						select date_format(GREATEST(CURDATE(),date_add(str_to_date(ifnull(maxCumuDate,CURDATE()),'%Y-%m-%d'),INTERVAL 1 MONTH)),'%Y-%m-%d') into maxCumuDate from dual;

						select count(1) into cumuCount
						from VD_C_CUMU_VALUE
						where CUMU_OBJ_ID=consId AND cumu_obj='01' AND CUMU_ITEM='0101'
							and STR_TO_DATE(date_format(start_time,'%Y-%m-%d'),'%Y-%m-%d')
								= DATE_ADD(STR_TO_DATE(maxCumuDate,'%Y-%m-%d'), INTERVAL -DAY(STR_TO_DATE(maxCumuDate,'%Y-%m-%d')) + 1 DAY);

						if cumuCount >0 then
							update VD_C_CUMU_VALUE
								set CUMU_VALUE=freeValue
							where CUMU_OBJ_ID=consId AND cumu_obj='01' AND CUMU_ITEM='0101'
							and STR_TO_DATE(date_format(start_time,'%Y-%m-%d'),'%Y-%m-%d')
								= DATE_ADD(STR_TO_DATE(maxCumuDate,'%Y-%m-%d'), INTERVAL -DAY(STR_TO_DATE(maxCumuDate,'%Y-%m-%d')) + 1 DAY);
						ELSE
							#免费值放入下月用户免费累计值
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
							select
								2,
								AMI_GET_SEQUENCE('SEQ_VD_C_CUMU_VALUE'),
								NULL,
								'01', # 累计值所属对象：01用户02计量点03电表
								consId,
								'0101', # 累计数据项 0101免费额度0301累计充值量(资源/钱)0302累计充值金额(实收)
								DATE_ADD(STR_TO_DATE(maxCumuDate,'%Y-%m-%d'), INTERVAL -DAY(STR_TO_DATE(maxCumuDate,'%Y-%m-%d')) + 1 DAY), # 累计开始时间
								LAST_DAY(str_to_date(maxCumuDate,'%Y-%m-%d')), # 累计结束时间
								freeValue,
								'KWH'
								from dual;
						end if;
					ELSEIF date_format(str_to_date(vendDate,'%Y-%m-%d'),'%Y%m')=date_format(CURDATE(),'%Y%m') THEN

						#更新用户免费累计值
						update VD_C_CUMU_VALUE cumu
							 set cumu.CUMU_VALUE=freeValue
						where cumu.cumu_obj='01' and cumu.CUMU_OBJ_ID=consId and cumu.CUMU_ITEM='0101'
								and date_format(cumu.START_TIME,'%Y%m')=date_format(str_to_date(vendDate,'%Y-%m-%d'),'%Y%m');

						#购电时间周期内没有用户免费额度数据，则增加
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
						select
							2,
							AMI_GET_SEQUENCE('SEQ_VD_C_CUMU_VALUE'),
							NULL,
							'01', # 累计值所属对象：01用户02计量点03电表
							consId,
							'0101', # 累计数据项 0101免费额度0301累计充值量(资源/钱)0302累计充值金额(实收)
							DATE_ADD(str_to_date(vendDate,'%Y-%m-%d'), INTERVAL -DAY(str_to_date(vendDate,'%Y-%m-%d')) + 1 DAY), # 累计开始时间
							LAST_DAY(str_to_date(vendDate,'%Y-%m-%d')), # 累计结束时间
							freeValue,
							'KWH'
						from dual
						where not exists(
							select cumu.CUMU_OBJ_ID
							 from VD_C_CUMU_VALUE cumu
							where cumu.cumu_obj='01' and cumu.CUMU_OBJ_ID=consId and cumu.CUMU_ITEM='0101'
								and date_format(cumu.START_TIME,'%Y%m')=date_format(str_to_date(vendDate,'%Y-%m-%d'),'%Y%m')
						);
					end if;

				END if;

		END IF;
	UNTIL done END REPEAT;
	CLOSE cumuList;

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

	SELECT t_error into error_code;
	SELECT msg into error_msg;

END
$$
delimiter ;