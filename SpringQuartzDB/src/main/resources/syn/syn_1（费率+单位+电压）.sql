DROP PROCEDURE IF EXISTS syn_1;
delimiter $$
CREATE PROCEDURE syn_1(OUT `error_code` integer, OUT `error_msg` text)

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

	#1-索引
	ALTER table vd_e_bill_package ADD INDEX index_vd_e_bill_package_pkgname(pkg_name);

	IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='tmp_yh' AND index_name='index_yh_tariffname') THEN
		ALTER TABLE tmp_yh ADD INDEX index_yh_tariffname(tariffname);
	END IF;

	IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='tmp_yh1' AND index_name='index_yh_tariffname') THEN
		ALTER TABLE tmp_yh1 ADD INDEX index_yh_tariffname(tariffname);
	END IF;

    # 开启事务
	START TRANSACTION;
	# 临时表
	CREATE TEMPORARY TABLE temp_yh SELECT yh.*,yh1.tariffname AS tariffnameold
			FROM tmp_yh yh INNER JOIN tmp_yh1 yh1 ON yh.customer_id = yh1.customer_id AND yh.tariffname!=yh1.tariffname;

	/*1-更新计量点关联费率方案*/
	UPDATE a_usagepoint pointmain INNER JOIN (
		SELECT yh.tariffname,point.mp_id
			FROM temp_yh yh
			INNER JOIN a_consumer cons ON CONCAT('CN_',yh.customer_id) = cons.CONS_NO
			INNER JOIN a_usagepoint POINT ON point.cons_id = cons.cons_id
			LEFT JOIN VD_E_BILL_Package pkgcurr ON pkgcurr.pkg_id=point.pkg_id
			WHERE IFNULL(pkgcurr.pkg_name,'')=IFNULL(yh.tariffnameold,'')
		) tb ON pointmain.mp_id = tb.mp_id
	SET pointmain.pkg_id = (SELECT pkg.pkg_id FROM VD_E_BILL_Package pkg WHERE pkg.pkg_name = tb.tariffname);

	/*2-更新用户电压等级*/
	UPDATE a_consumer cons INNER JOIN (SELECT (CASE
							WHEN yh.tariffname LIKE '%(BUS)' THEN '02' -- 工商业用户
							ELSE '04' -- 低压居民
						 END) AS sort_code,conscurr.CONS_ID
			FROM temp_yh yh
			INNER JOIN a_consumer conscurr ON CONCAT('CN_',yh.customer_id) = conscurr.CONS_NO
			WHERE (CASE
					WHEN yh.tariffnameold LIKE '%(BUS)' THEN '02' -- 工商业用户
					ELSE '04' -- 低压居民
				 END) = conscurr.CONS_SORT_CODE) tb ON cons.CONS_ID = tb.CONS_ID
	SET cons.CONS_SORT_CODE = tb.sort_code;

	# 临时表
	DROP TEMPORARY TABLE IF EXISTS temp_yh;
	CREATE TEMPORARY TABLE temp_yh SELECT yh.*,yh1.station_id AS station_idold
			FROM tmp_yh yh INNER JOIN tmp_yh1 yh1 ON yh.customer_id = yh1.customer_id AND yh1.station_id!=yh.station_id;

	/*3-更新计量点管理单位*/
	UPDATE a_usagepoint POINT INNER JOIN (SELECT org2.no,conscurr.cons_id
			FROM temp_yh yh
			INNER JOIN a_consumer conscurr ON conscurr.cons_no = CONCAT('CN_',yh.customer_id)
			LEFT JOIN uap_organization org1 ON CONCAT('ORG_',yh.station_idold) = org1.CODE
			LEFT JOIN uap_organization org2 ON CONCAT('ORG_',yh.station_id) = org2.CODE
			WHERE conscurr.org_no = org1.no) tb ON tb.cons_id = point.cons_id
	SET point.ORG_NO = tb.no;

	/*4-更新表计管理单位*/
	UPDATE a_equip_meter meter INNER JOIN (SELECT org2.no,bj.mt_comm_addr
			FROM tmp_bj bj
			INNER JOIN temp_yh yh ON bj.customer_id = yh.customer_id
			INNER JOIN a_consumer conscurr ON conscurr.cons_no = CONCAT('CN_',yh.customer_id)
			LEFT JOIN uap_organization org1 ON CONCAT('ORG_',yh.station_idold) = org1.CODE
			LEFT JOIN uap_organization org2 ON CONCAT('ORG_',yh.station_id) = org2.CODE
			WHERE conscurr.org_no = org1.no) tb ON meter.assetno = tb.mt_comm_addr
	SET meter.ORG_NO = tb.no;

	/*5-更新计量点关联战线变*/
	UPDATE a_usagepoint point
	INNER JOIN(
		SELECT c.line_id,d.tf_id,pointmain.mp_id,subs.subs_id
		FROM a_consumer a
		INNER JOIN temp_yh yh ON CONCAT('CN_',yh.customer_id) = a.cons_no
		INNER JOIN a_usagepoint pointmain ON a.cons_id=pointmain.cons_id
		INNER JOIN a_mp_equipment_rela rela ON pointmain.mp_id=rela.mp_id
		INNER JOIN a_equip_meter meter ON meter.METER_ID=rela.EQUIPMENTID AND rela.EQUIPMENTTYPE='02'
		INNER JOIN tmp_bj b ON meter.ASSETNO=b.mt_comm_addr
		LEFT JOIN uap_organization org ON CONCAT('ORG_',yh.station_idold) = org.CODE
		LEFT JOIN a_grid_line c ON CONCAT('SLT_',b.line_id) = c.line_no
		LEFT JOIN a_grid_transformer d ON CONCAT('SLT_',b.suburb_id) = d.tf_no
		LEFT JOIN a_grid_subs subs ON CONCAT('SLT_',b.station_id) = subs.subs_no
		WHERE a.org_no = org.no
	) AS line_transformer ON line_transformer.mp_id = point.mp_id
	SET point.line_id = line_transformer.line_id,
	    point.tf_id = line_transformer.tf_id,
	    point.subs_id = line_transformer.subs_id;

	/*6-更新用户管理单位*/
	update a_consumer cons inner join (select org2.no,conscurr.cons_no
			from temp_yh yh
			inner join a_consumer conscurr on CONCAT('CN_',yh.customer_id) = conscurr.CONS_NO
			left join uap_organization org1 ON CONCAT('ORG_',yh.station_idold) = org1.CODE
			left join uap_organization org2 ON CONCAT('ORG_',yh.station_id) = org2.CODE
			where conscurr.org_no = org1.no) tb on cons.cons_no = tb.cons_no
	set cons.ORG_NO = tb.no;

	DROP TEMPORARY TABLE IF EXISTS temp_yh;

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

	# 删除索引
	ALTER table vd_e_bill_package DROP INDEX index_vd_e_bill_package_pkgname;

	SELECT t_error into error_code;
	SELECT msg into error_msg;
END;
$$
delimiter ;