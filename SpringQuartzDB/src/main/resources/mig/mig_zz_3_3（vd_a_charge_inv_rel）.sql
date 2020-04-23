DROP PROCEDURE IF EXISTS mig_zz_3_3;
delimiter $$
CREATE PROCEDURE mig_zz_3_3()

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	DECLARE start_line int default 0;
	DECLARE offset int default 300000; -- 一次最多插35W，否则就报3100，所以只能分页插，20W耗时59s
	DECLARE total int default 15000000; -- 必须是offset的倍数
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 暂时删除索引
    IF EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='vd_a_charge_inv_rel_2015' AND index_name='IDX_CHARGE_INV_REL_CHARGE_ID') THEN
		ALTER table vd_a_charge_inv_rel_2015 DROP INDEX IDX_CHARGE_INV_REL_CHARGE_ID;
	END IF;

    # 1-循环插入 票据关系 (1h36min)
	while start_line < total do
        SET @strsql = CONCAT('INSERT INTO vd_a_charge_inv_rel_2015
                (`LESSEE_ID`, `REL_ID`, `NOTE_ID`, `CHARGE_ID`, `TV`)
            SELECT
                2,
                AMI_GET_SEQUENCE(''SEQ_VD_A_CHARGE_INV_REL''), -- REL_ID
                inv.NOTE_ID, -- NOTE_ID 票据标识PK
                inv.CHARGEID, -- CHARGE_ID 收费标识
                inv.tv -- 手动插入TV字段，应用于分区（该值不应为空）
            FROM vd_a_inv_2015 inv
            INNER JOIN (SELECT NOTE_ID FROM vd_a_inv_2015 LIMIT ', start_line, ',', offset, ') tmpinv ON inv.NOTE_ID = tmpinv.NOTE_ID;');
        PREPARE stmt FROM @strsql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt; -- 释放
        -- 翻页
        set start_line = start_line + offset;
    end while;

    # 重建索引
    ALTER table vd_a_charge_inv_rel_2015 ADD INDEX IDX_CHARGE_INV_REL_CHARGE_ID(CHARGE_ID); -- 1min

    SELECT t_error, msg;
END
$$
delimiter ;

CALL mig_zz_3_3();
