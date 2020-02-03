BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;

	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

	# 开启事务【默认CDUArea都能在单位表找到对应1条记录，否则会报主键为空】
	START TRANSACTION;


	# 清空相关数据（vending序列暂不复位）
	# ----------------------- 清除 【脚本9：还债记录（实收/应收/收费明细表）】
	DELETE FROM VD_A_RCVED_DEBT;
	DELETE FROM VD_A_RCVED_FLOW;

	DELETE FROM VD_A_PAY_FLOW;

	DELETE FROM VD_A_RCVBL_DEBT;
	DELETE FROM VD_A_RCVBL_FLOW;

	DROP TABLE IF EXISTS tmp_hzjl;
	# ----------------------- 清除 【脚本8：操作员】
	DELETE FROM uap_user_role WHERE user_id not in (1, 2, 10000);
	UPDATE uap_sequence SET next_val = 20003 WHERE sequence_name = 'userRoleId';
	DELETE FROM uap_user_favorite_menu WHERE user_id not in (1, 2, 10000);
	DELETE FROM uap_user WHERE id not in (1, 2, 10000);
	UPDATE uap_sequence SET next_val = 20001 WHERE sequence_name = 'userId';

	DROP TABLE IF EXISTS tmp_czy;
	# ----------------------- 清除 【脚本7：代理商】
	DELETE FROM VD_AGT_AGENT_OPERATOR;
	DELETE FROM VD_AGT_CHARGE_LIMT;
	DELETE FROM VD_A_ACCOUNT WHERE ACCT_CATEGOTY IN ('02','03');
	DELETE FROM VD_AGT_AGENT;

	DROP TABLE IF EXISTS tmp_dls;
	# ----------------------- 清除 【脚本6：债务】
	DELETE FROM VD_A_USER_DEBT;
	DELETE FROM VD_A_USER_DEBT_SET;

	DROP TABLE IF EXISTS tmp_zw;
	# ----------------------- 清除 【脚本5.2：累计值】
	DELETE FROM VD_C_CUMU_VALUE;

	DROP TABLE IF EXISTS tmp_ljz;
	# ----------------------- 清除 【脚本5.1：免费额度配置】
	DELETE FROM VD_OFFER_SET;
	DELETE FROM VD_OFFER_SET_DETAIL;
	# ----------------------- 清除 【脚本4：用户 计量点】
	DELETE FROM a_consumer_contacts;

	DELETE FROM A_MP_EQUIPMENT_RELA;
	DELETE FROM a_consumer;
	DELETE FROM a_usagepoint;

	DROP TABLE IF EXISTS tmp_yh;
	# ----------------------- 清除 【脚本3：表计】
	DELETE FROM A_MP_EQUIPMENT_RELA;
	DELETE FROM A_EQUIP_METER_VENDING;
	DELETE FROM A_EQUIP_METER;

	DROP TABLE IF EXISTS tmp_bj;
	# ----------------------- 清除 【手动：费率】暂不清除应该也没影响

	# ----------------------- 清除 【脚本2：站线变】
	DELETE FROM a_grid_line_tf;
	DELETE FROM a_grid_subs_line_rela;
	DELETE FROM a_grid_transformer WHERE tf_no like 'zxb_%';
	DELETE FROM a_grid_line WHERE line_no like 'zxb_%';
	DELETE FROM a_grid_subs WHERE subs_no like 'zxb_%';

	DROP TABLE IF EXISTS tmp_zxb;
	# ----------------------- 清除 【脚本1：单位】
	UPDATE uap_sequence SET next_val = 20000 WHERE sequence_name = 'orgId';
	DELETE FROM vd_p_org_vk_rel;
	DELETE FROM UAP_USER_ORG_MANAGE WHERE org_id <> 10000;
	DELETE FROM UAP_ORGANIZATION WHERE code like 'dw_%';

	DROP TABLE IF EXISTS tmp_dw;
	# ----------------------- 清除 【脚本0：运行时秘钥】暂不清除应该也没影响
	DROP TABLE IF EXISTS tmp_vk;

	# ----------------------- 清除 【手动：角色】暂不清除应该也没影响

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error, msg;
END