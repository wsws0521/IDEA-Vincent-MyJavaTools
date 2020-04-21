DROP PROCEDURE IF EXISTS mig_zz_3_999;
delimiter $$
CREATE PROCEDURE mig_zz_3_999()

BEGIN

	# 删除辅助索引
    ALTER table uap_user DROP INDEX index_uap_user_no;
    ALTER table VD_AGT_AGENT DROP INDEX index_VD_AGT_AGENT_NAME;
    ALTER table uap_organization DROP INDEX index_uap_organization_no;

END
$$
delimiter ;
