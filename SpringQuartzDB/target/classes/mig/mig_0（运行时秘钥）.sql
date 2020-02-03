BEGIN



	# 1-删除已有数据
	DELETE FROM A_EQUIP_METER_VENDING;
	DELETE FROM D_EBOX;
	DELETE FROM VD_P_EBOX_RUN;
	DELETE FROM vd_p_klf;
	DELETE FROM VD_P_VK_RUN;
	DELETE FROM VD_P_VK;
	# 2-导入加密盒档案
	INSERT INTO D_EBOX(LESSEE_ID, EBOX_ID, FACTURER_ID, STS, EBOX_NO,  NAME,   ASSET_NO,  HARDWARE_ID, FIRMWARE_NO, BOX_TYPE,
											BAR_CODE, MADE_NO,  MADE_DATE, DOC_TYPE_CODE, DOC_CREATOR_NO, DOC_CREATE_DATE, CUR_STATUS_CODE, ERP_BATCH_NO, REMARK)
	SELECT 			          2,		  1,       '01',       '01', eboxNo,  'STS1', '00000001',  '00000001',   '00000001', '1',
											NULL,  '00000001',SYSDATE(),'02',           1,              SYSDATE(),       '10',            NULL,        'Centlec-sts1'
	FROM DUAL;
	# 3-设置运行加密盒
	INSERT INTO VD_P_EBOX_RUN(LESSEE_ID, EBOX_ID, THIRD_PARTY_ID, STATUS)
	SELECT 					              2,		 1, 	    1, 			        '10'
	FROM DUAL;
	# 4-更新STS1加密服务地址
	UPDATE P_THIRD_PARTY SET INTERFACE_URL = thirdUrl WHERE BUSINESS_TYPE = '0401';



	----------------------------------------------------------------------------------------------------------------------------------------------------

	/*# 5-转存tmp_vk数据至VK表
	INSERT INTO VD_P_VK
		(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, STATUS, ALGORITHM, vk_expiration, ms)
	SELECT
		2, AMI_GET_SEQUENCE('seq_vd_p_vk'), a.SGC, a.KEYVERSIONID, a.SE_EXPIRY,
		DATE_FORMAT(a.SE_EXPIRYDATE,'%Y-%m-%d'), 1993, '10', '02', '2024-10-10', '02'
	FROM tmp_vk a;*/

	# 5-存储新申请的vk至 VD_P_VK
	select AMI_GET_SEQUENCE('SEQ_VD_P_VK');
	select AMI_GET_SEQUENCE('SEQ_VD_P_VK');
	select AMI_GET_SEQUENCE('SEQ_VD_P_VK');
	select AMI_GET_SEQUENCE('SEQ_VD_P_VK');
	/* VK（数据模拟）：VD_P_VK */
	/*现场模式 000397*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'000397',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '000397' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008000*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008000',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008000' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008001*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008001',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008001' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008002*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008002',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008002' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008003*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008003',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008003' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008004*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008004',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008004' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008005*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008005',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008005' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008006*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008006',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008006' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008007*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008007',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008007' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008008*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008008',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008008' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008009*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008009',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008009' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008010*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008010',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008010' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008011*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008011',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008011' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008012*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008012',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008012' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008013*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008013',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008013' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008015*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008015',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008015' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008016*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008016',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008016' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008019*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008019',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008019' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');
	/*现场模式 008024*/
	insert into vd_p_vk(lessee_id, vk_id, sgc, krn, ken, expire_date, base_time, status, algorithm, vk_expiration, ms)
	select 2, AMI_GET_SEQUENCE('SEQ_VD_P_VK'),'008024',1,255,'2024-11-24',1993,'10','02','2020-12-03','02' from dual
	where not exists (select * from vd_p_vk where sgc = '008024' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02');

	# 6伪造klf文件记录
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

	# 7设置运行VK
	select AMI_GET_SEQUENCE('VD_P_VK_RUN');
	select AMI_GET_SEQUENCE('VD_P_VK_RUN');
	select AMI_GET_SEQUENCE('VD_P_VK_RUN');
	select AMI_GET_SEQUENCE('VD_P_VK_RUN');
	/*运行VK信息表（数据模拟）：VD_P_VK_RUN*/
	delete from VD_P_VK_RUN;
	/*STS2运行vk-------ebox_id=3 */
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '000397' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008000' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008001' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008002' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008003' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008004' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008005' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008006' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008007' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008008' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008009' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008010' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008011' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008012' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008013' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008015' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008016' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008019' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),3,
			(select vk_id from vd_p_vk where sgc = '008024' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			1,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	/*STS2运行vk-------ebox_id=4 */
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '000397' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008000' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008001' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008002' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008003' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008004' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008005' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008006' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008007' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008008' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008009' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008010' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008011' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008012' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008013' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008015' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008016' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008019' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),4,
			(select vk_id from vd_p_vk where sgc = '008024' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			2,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	/*STS2运行vk-------ebox_id=5 */
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '000397' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008000' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008001' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008002' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008003' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008004' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008005' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008006' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008007' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008008' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008009' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008010' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008011' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008012' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008013' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008015' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008016' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008019' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;
	insert into VD_P_VK_RUN(LESSEE_ID, VK_RUN_ID, EBOX_ID, VK_ID, KLF_ID, VK_NO, INTERFACE_URL, STATUS, ULM, CLM, ACTIVE_DATE, VK_EXPIRATION)
	select 	2,AMI_GET_SEQUENCE('VD_P_VK_RUN'),5,
			(select vk_id from vd_p_vk where sgc = '008024' and krn = 1 and ken = 255 and base_time = 1993 and algorithm = '02' and ms = '02'),
			3,'1','','10',null,null,SYSDATE(),'2020-12-03' from dual;









END