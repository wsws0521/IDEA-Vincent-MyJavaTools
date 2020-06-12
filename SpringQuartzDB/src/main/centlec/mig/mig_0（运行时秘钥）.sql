DROP PROCEDURE IF EXISTS mig_0;
delimiter $$
CREATE PROCEDURE mig_0()

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

	# 1-删除已有数据
	DELETE FROM A_EQUIP_METER_VENDING;

	DELETE FROM VD_P_EBOX_RUN;
	DELETE FROM D_EBOX;
	DELETE FROM VD_P_VK_RUN;
	DELETE FROM vd_p_klf;
	DELETE FROM VD_P_VK;

	# 2-导入加密盒档案(写死ID分别为3、4、5)
	INSERT INTO `d_ebox` (`LESSEE_ID`, `EBOX_ID`, `FACTURER_ID`, `STS`, `EBOX_NO`, `NAME`, `ASSET_NO`, `HARDWARE_ID`, `FIRMWARE_NO`, `BOX_TYPE`, `BAR_CODE`, `MADE_NO`, `MADE_DATE`, `DOC_TYPE_CODE`, `DOC_CREATOR_NO`, `DOC_CREATE_DATE`, `CUR_STATUS_CODE`, `ERP_BATCH_NO`, `REMARK`)
	SELECT '2', '3', '01', '02', '89053508', '192.168.80.3-SM1', '', NULL, NULL, '2', NULL, NULL, NULL, '02', '10000', SYSDATE(), '10', NULL, NULL
	FROM DUAL;
	INSERT INTO `d_ebox` (`LESSEE_ID`, `EBOX_ID`, `FACTURER_ID`, `STS`, `EBOX_NO`, `NAME`, `ASSET_NO`, `HARDWARE_ID`, `FIRMWARE_NO`, `BOX_TYPE`, `BAR_CODE`, `MADE_NO`, `MADE_DATE`, `DOC_TYPE_CODE`, `DOC_CREATOR_NO`, `DOC_CREATE_DATE`, `CUR_STATUS_CODE`, `ERP_BATCH_NO`, `REMARK`)
	SELECT '2', '4', '01', '02', '89053502', '192.168.80.5-SM3', NULL, 'Prism-TSM500-4', 'STS64V10', '2', NULL, NULL, NULL, '02', '10000', SYSDATE(), '10', NULL, NULL
	FROM DUAL;
	INSERT INTO `d_ebox` (`LESSEE_ID`, `EBOX_ID`, `FACTURER_ID`, `STS`, `EBOX_NO`, `NAME`, `ASSET_NO`, `HARDWARE_ID`, `FIRMWARE_NO`, `BOX_TYPE`, `BAR_CODE`, `MADE_NO`, `MADE_DATE`, `DOC_TYPE_CODE`, `DOC_CREATOR_NO`, `DOC_CREATE_DATE`, `CUR_STATUS_CODE`, `ERP_BATCH_NO`, `REMARK`)
	SELECT '2', '5', '01', '02', '89053499', '192.168.80.4-SM2', NULL, NULL, NULL, '2', NULL, NULL, NULL, '02', '10000', SYSDATE(), '10', NULL, NULL
	FROM DUAL;
    SELECT AMI_GET_SEQUENCE('SEQ_D_EBOX');
    SELECT AMI_GET_SEQUENCE('SEQ_D_EBOX');
    SELECT AMI_GET_SEQUENCE('SEQ_D_EBOX');
    SELECT AMI_GET_SEQUENCE('SEQ_D_EBOX');
    SELECT AMI_GET_SEQUENCE('SEQ_D_EBOX');

	# 3-设置运行加密盒(仅开启ID为3的BOX)
	INSERT INTO `vd_p_ebox_run` (`LESSEE_ID`, `EBOX_ID`, `THIRD_PARTY_ID`, `STATUS`, `TOKEN_NUM`, `TOKEN_ALARM`, `VK_ALARM`, `VK_ALARM_UNIT`, `PRIORITY`, `LIC_ALARM`, `LIC_ALARM_UNIT`)
	SELECT '2', '3', '2', '10', NULL, NULL, NULL, NULL, NULL, NULL, NULL
	FROM DUAL;
	INSERT INTO `vd_p_ebox_run` (`LESSEE_ID`, `EBOX_ID`, `THIRD_PARTY_ID`, `STATUS`, `TOKEN_NUM`, `TOKEN_ALARM`, `VK_ALARM`, `VK_ALARM_UNIT`, `PRIORITY`, `LIC_ALARM`, `LIC_ALARM_UNIT`)
	SELECT '2', '4', '2', '20', NULL, NULL, NULL, NULL, NULL, NULL, NULL
	FROM DUAL;
	INSERT INTO `vd_p_ebox_run` (`LESSEE_ID`, `EBOX_ID`, `THIRD_PARTY_ID`, `STATUS`, `TOKEN_NUM`, `TOKEN_ALARM`, `VK_ALARM`, `VK_ALARM_UNIT`, `PRIORITY`, `LIC_ALARM`, `LIC_ALARM_UNIT`)
	SELECT '2', '5', '2', '20', NULL, NULL, NULL, NULL, NULL, NULL, NULL
	FROM DUAL;

	# 4-更新STS2加密服务地址
	UPDATE P_THIRD_PARTY SET INTERFACE_URL = 'http://192.168.81.2:8010/EncrptionService/rest/sts' WHERE BUSINESS_TYPE = '0402';

	# 5-1993-存储vk至 VD_P_VK
    /*现场模式 000397*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'000397',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '000397' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008000*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008000',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008000' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008001*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008001',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008001' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008002*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008002',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008002' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008003*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008003',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008003' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008004*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008004',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008004' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008005*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008005',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008005' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008006*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008006',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008006' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008007*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008007',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008007' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008008*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008008',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008008' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008009*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008009',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008009' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008010*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008010',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008010' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008011*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008011',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008011' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008012*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008012',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008012' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008013*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008013',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008013' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008015*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008015',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008015' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008016*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008016',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008016' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008019*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008019',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008019' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
    /*现场模式 008024*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008024',1,255,'2024-11-24',1993,'10','02','2020-12-20','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008024' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');

	# 6-1993-伪造klf文件记录
    /*KLF信息表（数据模拟）：VD_P_KLF*/
    insert into vd_p_klf(lessee_id, klf_id, kmc_no, status, klf_file)
    select 2, 1, '', '10', null from dual
    where not exists (select * from vd_p_klf where klf_id = 1);
    insert into vd_p_klf(lessee_id, klf_id, kmc_no, status, klf_file)
    select 2, 2, '', '10', null from dual
    where not exists (select * from vd_p_klf where klf_id = 2);
    insert into vd_p_klf(lessee_id, klf_id, kmc_no, status, klf_file)
    select 2, 3, '', '10', null from dual
    where not exists (select * from vd_p_klf where klf_id = 3);

    # 7-1993-插入 运行VK信息表（数据模拟）：VD_P_VK_RUN
    /* For ebox_id=3 */
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '000397' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'1','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008000' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'3','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008001' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'5','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008002' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'7','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008003' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'9','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008004' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'11','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008005' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'13','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008006' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'15','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008007' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'17','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008008' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'19','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008009' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'21','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008010' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'23','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008011' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'25','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008012' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'27','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008013' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'29','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008015' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'31','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008016' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'33','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008019' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'35','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008024' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            1,'37','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    /* For ebox_id=4 */
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '000397' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'1','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008000' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'3','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008001' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'5','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008002' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'7','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008003' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'9','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008004' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'11','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008005' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'13','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008006' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'15','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008007' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'17','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008008' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'19','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008009' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'21','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008010' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'23','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008011' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'25','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008012' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'27','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008013' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'29','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008015' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'31','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008016' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'33','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008019' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'35','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008024' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            2,'37','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    /* For ebox_id=5 */
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '000397' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'1','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008000' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'3','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008001' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'5','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008002' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'7','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008003' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'9','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008004' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'11','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008005' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'13','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008006' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'15','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008007' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'17','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008008' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'19','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008009' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'21','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008010' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'23','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008011' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'25','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008012' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'27','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008013' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'29','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008015' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'31','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008016' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'33','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008019' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'35','','10',null,null,SYSDATE(),'2020-12-20' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008024' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
            3,'37','','10',null,null,SYSDATE(),'2020-12-20' from dual;






    # 5-2014-存储vk至 VD_P_VK
    /* VK（数据模拟）：VD_P_VK */
    /*现场模式 000397*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'000397',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '000397' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008000*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008000',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008000' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008001*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008001',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008001' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008002*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008002',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008002' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008003*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008003',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008003' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008004*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008004',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008004' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008005*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008005',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008005' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008006*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008006',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008006' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008007*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008007',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008007' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008008*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008008',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008008' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008009*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008009',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008009' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008010*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008010',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008010' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008011*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008011',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008011' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008012*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008012',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008012' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008013*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008013',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008013' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008015*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008015',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008015' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008016*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008016',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008016' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008019*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008019',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008019' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');
    /*现场模式 008024*/
    insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
    select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008024',2,255,'2045-11-24',2014,'10','04','2020-12-22','02' from dual
    where not exists (select * from vd_p_vk where sgc = '008024' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02');

    # 6-2014-伪造klf文件记录
    /*KLF信息表（数据模拟）：VD_P_KLF*/
    insert into vd_p_klf(lessee_id, klf_id, kmc_no, status, klf_file)
    select 2, 4, '', '10', null from dual
    where not exists (select * from vd_p_klf where klf_id = 4);
    insert into vd_p_klf(lessee_id, klf_id, kmc_no, status, klf_file)
    select 2, 5, '', '10', null from dual
    where not exists (select * from vd_p_klf where klf_id = 5);
    insert into vd_p_klf(lessee_id, klf_id, kmc_no, status, klf_file)
    select 2, 6, '', '10', null from dual
    where not exists (select * from vd_p_klf where klf_id = 6);

    # 7-2014-插入 运行VK信息表（数据模拟）：VD_P_VK_RUN
    /* For ebox_id=3 */
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '000397' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'2','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008000' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'4','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008001' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'6','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008002' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'8','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008003' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'10','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008004' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'12','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008005' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'14','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008006' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'16','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008007' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'18','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008008' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'20','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008009' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'22','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008010' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'24','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008011' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'26','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008012' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'28','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008013' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'30','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008015' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'32','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008016' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'34','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008019' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'36','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
            (select vk_id from vd_p_vk where sgc = '008024' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            4,'38','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    /* For ebox_id=4 */
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '000397' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'2','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008000' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'4','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008001' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'6','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008002' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'8','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008003' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'10','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008004' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'12','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008005' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'14','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008006' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'16','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008007' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'18','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008008' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'20','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008009' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'22','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008010' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'24','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008011' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'26','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008012' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'28','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008013' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'30','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008015' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'32','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008016' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'34','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008019' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'36','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
            (select vk_id from vd_p_vk where sgc = '008024' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            5,'38','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    /* For ebox_id=5 */
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '000397' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'2','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008000' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'4','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008001' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'6','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008002' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'8','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008003' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'10','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008004' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'12','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008005' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'14','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008006' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'16','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008007' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'18','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008008' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'20','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008009' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'22','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008010' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'24','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008011' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'26','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008012' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'28','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008013' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'30','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008015' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'32','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008016' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'34','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008019' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'36','','10',null,null,SYSDATE(),'2020-12-22' from dual;
    insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
    select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
            (select vk_id from vd_p_vk where sgc = '008024' and krn = 2 and ken = 255 and base_time = 2014 and algorithm = '04' and ms = '02'),
            6,'38','','10',null,null,SYSDATE(),'2020-12-22' from dual;


    IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error, msg;

END
$$
delimiter ;

CALL mig_0();