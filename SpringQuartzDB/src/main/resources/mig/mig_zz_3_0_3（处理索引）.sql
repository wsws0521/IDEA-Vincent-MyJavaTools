DROP PROCEDURE IF EXISTS mig_zz_3_0_0;
delimiter $$
CREATE PROCEDURE mig_zz_3_0_0()

BEGIN
    # 添加必要索引（先解决字符集的问题）
    # uap_user.no
    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='uap_user' AND index_name='index_uap_user_no') THEN
		ALTER table uap_user ADD INDEX index_uap_user_no(no);
	END IF;
	# VD_AGT_AGENT.AGENT_NAME
    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='VD_AGT_AGENT' AND index_name='index_VD_AGT_AGENT_NAME') THEN
		ALTER table VD_AGT_AGENT ADD INDEX index_VD_AGT_AGENT_NAME(AGENT_NAME);
	END IF;
	# uap_organization.CODE
    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='uap_organization' AND index_name='index_uap_organization_no') THEN
		ALTER table uap_organization ADD INDEX index_uap_organization_no(no);
	END IF;

	ALTER table tmp_sdjl_2015 ADD INDEX tmp_sdjl_2015_delflag(delflag); -- 12293116 记录需要 215s(大量重复，索引效果也不好)
	ALTER table tmp_sdjl_2015 ADD INDEX tmp_sdjl_2015_keytoken1(KEYTOKEN1); -- 12293116 记录需要 245s 分开插秘钥Token正常Token时需要
	ALTER table tmp_sdjl_2015 ADD INDEX tmp_sdjl_2015_isfree(isfree); -- 12293116 记录需要 217s 分开插秘钥Token正常Token时需要(大量重复，索引效果也不好)
-- 	ALTER table tmp_sdjl_2015 ADD INDEX tmp_sdjl_2015_ocdmoney(OCD_MONEY); -- 12293116 记录需要 218 分开插秘钥Token正常Token时需要
    ALTER table tmp_sdjl_2015 ADD INDEX tmp_sdjl_2015_isfree_123(isfree,OCD_MONEY,FP_VAL3,OCD_DEBT);  -- 292 应收实收 需要




END
$$
delimiter ;
