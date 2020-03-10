DROP PROCEDURE IF EXISTS syn_5_1;
delimiter $$
CREATE PROCEDURE syn_5_1(OUT `error_code` integer, OUT `error_msg` text)

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

	# 0-索引
	ALTER table a_grid_line ADD INDEX index_a_grid_line_lineno(line_no);
	ALTER table a_grid_transformer ADD INDEX index_a_grid_transformer_tfno(tf_no);
	ALTER table a_grid_subs ADD INDEX index_a_grid_subs_subsno(subs_no);
	ALTER table vd_e_bill_package ADD INDEX index_vd_e_bill_package_pkgname(pkg_name);

	IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='tmp_bj' AND index_name='index_bj_customerid') THEN
		ALTER TABLE tmp_bj ADD INDEX index_bj_customerid(customer_id);
	END IF;

	# 开启事务
	START TRANSACTION;

	# 1-插入计量点档案
	INSERT INTO a_usagepoint
		(mp_id, mp_no, mp_name, location, org_no, type_code, usage_type_code, side_code, cons_id, line_id, tf_id, tf_line_id, mp_grade, is_load_c, is_calc_loss, main_standby, basevoltage, wiringmode, measuremode, ct, pt, STATUS, out_no, load_grade, subs_id, mdc_id, pkg_id)
	SELECT 	AMI_GET_SEQUENCE('S_AMI_FILE'),			-- 计量点标识
		CONCAT('mp_',a.cons_id,'_',b.mt_comm_addr), -- 计量点编号
		CONCAT('mp_',a.cons_id,'_',b.mt_comm_addr), -- 计量点名称
		a.elec_addr, -- 计量点地址
		a.org_no, -- 所属单位(取用户单位，默认表计单位同用户单位)
		'04', -- jldfl计量点分类：02线路关口03配变04用电客户05虚拟计量点
		NULL, -- zyyt主要用途：01结算02考核
		NULL, -- ljdssc计量点所属侧：01高压侧02中压侧03低压侧04变电站内05变电站外
		a.cons_id, -- 所属用户
		c.line_id, -- 所属线路标识
		d.tf_id, -- 所属变压器标识
		NULL, -- 所属变压器分线
		NULL, -- MP_GRADE计量点级别：10-1,20-2,30-3
		NULL, -- 是否安装负控
		NULL, -- 是否参与线损计算
		NULL, -- 主备标志
		'AC00101', -- 电压等级：交流10kV...
		NULL, -- 接线方式：单项、三相三线、三相四线
		NULL, -- 计量方式
		'1/1', -- CT
		'1/1', -- PT
		'02', -- 状态：01设立02在用03注销
		NULL, -- 外部标识
		NULL, -- 负荷等级
		subs.subs_id, -- subs_id 所属变电站标识
		NULL, -- mdc_id ？
		e.pkg_id -- pkg_id 费率方案标识
	FROM a_consumer a
	INNER JOIN tmp_bj b ON a.cons_no = CONCAT('CN_', b.customer_id)
	LEFT JOIN a_grid_line c ON CONCAT('SLT_',b.line_id) = c.line_no
	LEFT JOIN a_grid_transformer d ON CONCAT('SLT_',b.suburb_id) = d.tf_no
	LEFT JOIN a_grid_subs subs ON CONCAT('SLT_',b.station_id) = subs.subs_no
	LEFT JOIN VD_E_BILL_Package e ON b.tariffname = e.pkg_name
	WHERE NOT EXISTS(SELECT f.mp_no FROM a_usagepoint f WHERE f.mp_no = CONCAT('mp_',a.cons_id,'_',b.mt_comm_addr));

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

	# 删除索引
	ALTER table a_grid_line DROP INDEX index_a_grid_line_lineno;
	ALTER table a_grid_transformer DROP INDEX index_a_grid_transformer_tfno;
	ALTER table a_grid_subs DROP INDEX index_a_grid_subs_subsno;
	ALTER table vd_e_bill_package DROP INDEX index_vd_e_bill_package_pkgname;

	SELECT t_error into error_code;
	SELECT msg into error_msg;
END;
$$
delimiter ;