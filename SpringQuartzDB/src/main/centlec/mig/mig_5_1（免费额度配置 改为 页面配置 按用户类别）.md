

## 启动主站 》》 Tariff Setting 》》 Discount Setting 》》 add
> 好像只能次日生效，配完去到 VD_OFFER_SET 查看，将EFFECTIVE_DATE改为当天或之前

-----Name: FBE
-----Type: Free Credit
-----Status: Normal
-----Config Object: Category
-----Accumulate: NO
-----Effective Date: Tomorrow
-----Expire Date: NULL
-----File: 201-50

```sql
update VD_OFFER_SET set EFFECTIVE_DATE = current_date();
```

## 关闭主站，先检查表型，再进行一次Navicat备份（mig_5_1.psc）（忽略tmp表）

----------------------------------------------------------------









-- 
-- 
-- 
-- BEGIN
-- 	DECLARE var_confId INTEGER DEFAULT NULL;	/* 优惠配置表主键序列 */
-- 
-- 	DECLARE t_error INTEGER DEFAULT 0;
-- 	DECLARE msg text;
-- 	# 定义SQL异常时将t_error置为1
-- 	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
-- 	begin
-- 		get diagnostics condition 1 msg = message_text;
-- 		set t_error = 1;
-- 	end;
-- 	# 开启事务
-- 	START TRANSACTION;
-- 
-- 	# 清除记录
-- 	DELETE FROM vd_offer_set_detail;
-- 	DELETE FROM vd_offer_set;
-- 	SET var_confId = (select AMI_GET_SEQUENCE('SEQ_VD_OFFER_SET') from dual);
-- 	# 插入1条 优惠配置
-- 	INSERT INTO vd_offer_set
-- 		(lessee_id, conf_id, conf_no, conf_name, effective_date, expiry_date, conf_type, status, remark, upd_cumu, conf_object)
-- 	SELECT
-- 		2, var_confId, CONCAT('PC', LPAD(var_confId, 14, '0')), 'FBE', curdate(), null, '01', '01', 'Centlec vendfree data', 0, '01'
-- 	FROM DUAL;
-- 
-- 	# 插入n条 优惠配置明细
-- 	INSERT INTO vd_offer_set_detail
-- 		(lessee_id, conf_detail_id, conf_id, conf_obj_id, amount)
-- 	SELECT
-- 		2, AMI_GET_SEQUENCE('SEQ_VD_OFFER_SET_DETAIL'), var_confId, b.cons_id, 50.00
-- 	FROM tmp_bj a, a_consumer b
-- 	WHERE a.tariffname IN
-- 		('MANGAUNG-TG1(FBE)','MANTSOPA-TG2(FBE)',
-- 		'NALEDI-TG3(FBE)','MOHOKARE-TG4(FBE)',
-- 		'KOPANONG-TG5(FBE)')
-- 	AND CONCAT('CN_',a.customer_id) = b.cons_no;
-- 
-- 	IF t_error = 1 THEN
-- 		ROLLBACK;
-- 	ELSE
-- 		COMMIT;
-- 	END IF;
-- 	SELECT t_error, msg;
-- END