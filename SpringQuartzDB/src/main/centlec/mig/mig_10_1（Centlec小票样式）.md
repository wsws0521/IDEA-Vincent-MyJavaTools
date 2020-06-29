## [手动]
### ① 清空 vd_pre_model；
```sql
DELETE FROM vd_pre_model;
```
### ② 手动跑 V2_0_104__VD_PRE_MODEL_DATA.sql 脚本；


### ③ 开启所有模板：
```sql
UPDATE VD_PRE_MODEL SET STATUS='01';
```
### ④ 还原为模板默认状态：
```sql
UPDATE VD_PRE_MODEL a SET STATUS='00' WHERE a.model_id IN (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19);
```









## [如果工具不识别脚本中的特殊字符，可以尝试自动执行]
### ① 清空 vd_pre_model；
### ② 删除flyway脚本执行记录；
DELETE FROM BIZ_SYS_SCHEMA_VERSION WHERE SCRIPT = ‘V2_0_104__ VD_PRE_MODEL_DATA.sql’;
### ③ 重启Tomcat会自动执行；



> V2_0_104__VD_PRE_MODEL_DATA.sql
-- -------------------
```sql
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,1,'01','Template One',STR_TO_DATE('2019-03-08 10:03:19','%Y-%m-%d %T'),NULL,'00','Template one - sale ticket','<table class="ke-zeroborder" style="width: 97.8189%; height: 252px; font-size: 12px;" border="0" cellspacing="0" cellpadding="0">
<tbody>
<tr style="height: 95px;">
<td style="font-size: 15px; font-weight: bold; width: 99.7413%; height: 11px;" colspan="2" align="center">
<div align="center">ELECTRICITY TOKEN <br />TAX INVOICE 4250211721<br />Batch Credit Token</div>
</td>
</tr>
<tr style="height: 16px;">
<td style="width: 99.7413%; height: 16px;" colspan="2" align="left"><hr /></td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right" width="60%">BATCH NO.:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{batchNo}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px; text-align: right;">BATCH TYPE:</td>
<td style="width: 39.7413%; height: 18px; text-align: right;">#{batchType}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">CUSTOMER NO.:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{clientNo}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">CUSTOMER NAME:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{clientName}</td>
</tr>
<tr style="height: 18px;">
<td style="width: 60%; height: 18px;" align="right">OPERATOR:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{operator}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; text-align: right; height: 18px;">OPERATOR UNIT:</td>
<td style="width: 39.7413%; text-align: right; height: 18px;">#{operDept}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px; text-align: right;">ORGANIZATION:</td>
<td style="width: 39.7413%; text-align: right; height: 18px;">#{orgId}</td>
</tr>
<tr style="height: 18px;">
<td style="width: 60%; height: 18px;" align="right">&nbsp;</td>
<td style="width: 39.7413%; height: 18px;" align="right">===========</td>
</tr>
<tr style="height: 18px;">
<td style="width: 60%; height: 18px;" align="right">TOTAL AMOUT:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{ttlAmt}</td>
</tr>
<tr style="height: 16px;">
<td style="width: 99.7413%; height: 16px;" colspan="2" align="left"><hr /></td>
</tr>
<tr style="height: 23px; display: table-row;">
<td style="font-size: 18px; font-weight: bolder; background-color: #f1f1f1; width: 99.7413%; height: 23px;" colspan="2" align="center">#{meterVendInfo}</td>
</tr>
<tr style="height: 24px;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 24px;" colspan="2" align="left"><hr />Note:Use keypad to input the 20 digits token,<br />for support contact 051 409 2334</td>
</tr>
</tbody>
</table>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 1);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,2,'02','Template Two',STR_TO_DATE('2019-03-08 10:03:19','%Y-%m-%d %T'),NULL,'00','Template two - sale ticket','<table class="ke-zeroborder" style="width: 97.8189%; height: 551px; font-size: 12px;" border="0" cellspacing="0" cellpadding="0">
<tbody>
<tr style="height: 95px; display: table-row;">
<td style="font-size: 15px; font-weight: bold; width: 99.7413%; height: 95px;" colspan="2" align="center">
<div align="center">ELECTRICITY TOKEN <br />TAX INVOICE 4250211721<br />Credit Token<br />Receipt No.: #{noteNo}</div>
</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 99.7413%; height: 18px;" colspan="2" align="left">Date:#{chargeDate}</td>
</tr>
<tr style="height: 16px;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 16px;" colspan="2" align="left"><hr /></td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 18px;" colspan="2" align="left">CUSTOMER:#{accountName}(#{accountNo})</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 99.7413%; height: 18px;" colspan="2" align="left">ADDRESS:#{accountAddress}</td>
</tr>
<tr style="height: 21px;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 21px;" colspan="2" align="left">Meter No.:#{meterNo}</td>
</tr>
<tr style="height: 18px;">
<td style="width: 99.7413%; height: 18px;" colspan="2" align="left">LAST PURCHASE DATE:#{lastChargeDate}</td>
</tr>
<tr style="height: 16px;">
<td style="width: 99.7413%; height: 16px;" colspan="2" align="left"><hr /></td>
</tr>
<tr style="height: 23px; display: table-row;">
<td style="font-size: 18px; font-weight: bolder; background-color: #f1f1f1; width: 99.7413%; height: 23px;" colspan="2" align="center">#{tokenInfo}</td>
</tr>
<tr style="height: 16px;">
<td style="width: 99.7413%; height: 16px;" colspan="2" align="left"><hr /></td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right" width="60%">UNITS:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{energy}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px; text-align: right;">UNITS COST:</td>
<td style="width: 39.7413%; height: 18px; text-align: right;">#{energyAmt}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">UNITS DETAILS:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{energyAmtInfo}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">TAX DETAILS:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{chargeAmtInfo}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">DEBT DETAILS:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{debtAmtInfo}</td>
</tr>
<tr style="height: 18px;">
<td style="width: 60%; height: 18px;" align="right">&nbsp;</td>
<td style="width: 39.7413%; height: 18px;" align="right">===========</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">TOTAL COST:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{ttlAmt}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">FREE ENERGY:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{freeCharge}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">&nbsp;</td>
<td style="width: 39.7413%; height: 18px;" align="right">&nbsp;</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">PAY METHOD:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{settleMode}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; text-align: right;">ACCOUNT PAYMENT AMOUNT:</td>
<td style="width: 39.7413%; text-align: right;">#{accountPayAmt}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">TENDERED AMOUNT:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{rcvAmt}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">CHANGE:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{changeAmt}</td>
</tr>
<tr style="height: 16px;">
<td style="width: 99.7413%; height: 16px;" colspan="2" align="left"><hr /></td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 99.7413%; height: 18px;" colspan="2" align="left">VENDOR:#{loginOptVendor}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 99.7413%; height: 18px;" colspan="2" align="left">OPERATOR:#{loginOper}</td>
</tr>
<tr style="height: 24px;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 24px;" colspan="2" align="left"><hr />Note:Use keypad to input the 20 digits token,<br />for support contact 051 409 2334</td>
</tr>
</tbody>
</table>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 2);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,3,'03','Template Three',STR_TO_DATE('2019-03-08 10:03:19','%Y-%m-%d %T'),NULL,'00','Template three - charge ticket','<table class="ke-zeroborder" style="width: 97.8189%; height: 451px; font-size: 12px;" border="0" cellspacing="0" cellpadding="0">
<tbody>
<tr style="height: 95px; display: table-row;">
<td style="font-size: 15px; font-weight: bold; width: 99.7413%; height: 52px;" colspan="2" align="center">
<div align="center">TAX INVOICE 4250211721<br />Receipt No.: #{noteNo}</div>
</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 99.7413%; height: 18px;" colspan="2" align="left">Date:#{chargeDate}</td>
</tr>
<tr style="height: 16px;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 16px;" colspan="2" align="left"><hr /></td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 18px;" colspan="2" align="left">CUSTOMER:#{accountName}(#{accountNo})</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 99.7413%; height: 18px;" colspan="2" align="left">ADDRESS:#{accountAddress}</td>
</tr>
<tr style="height: 21px; display: table-row;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 21px;" colspan="2" align="left">Meter No.:#{meterNo}</td>
</tr>
<tr style="height: 16px;">
<td style="width: 99.7413%; height: 16px;" colspan="2" align="left"><hr /></td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">CHARGE DETAILS:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{rcvAmtInfo}</td>
</tr>
<tr style="height: 18px;">
<td style="width: 60%; height: 18px;" align="right">&nbsp;</td>
<td style="width: 39.7413%; height: 18px;" align="right">===========</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">TOTAL COST:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{ttlAmt}</td>
</tr>
<tr style="height: 18px;">
<td style="width: 60%; height: 18px;" align="right">&nbsp;</td>
<td style="width: 39.7413%; height: 18px;" align="right">&nbsp;</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">PAY METHOD:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{settleMode}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; text-align: right;">ACCOUNT PAYMENT AMOUNT:</td>
<td style="width: 39.7413%; text-align: right;">#{accountPayAmt}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">TENDERED AMOUNT:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{rcvAmt}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">CHANGE:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{changeAmt}</td>
</tr>
<tr style="height: 16px;">
<td style="width: 99.7413%; height: 16px;" colspan="2" align="left"><hr /></td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 99.7413%; height: 18px;" colspan="2" align="left">VENDOR:#{loginOptVendor}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 99.7413%; height: 18px;" colspan="2" align="left">OPERATOR:#{loginOper}</td>
</tr>
<tr style="height: 24px;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 24px;" colspan="2" align="left"><hr />Note:<br />for support contact 051 409 2334</td>
</tr>
</tbody>
</table>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 3);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,4,'04','Template Four',STR_TO_DATE('2019-03-08 10:03:19','%Y-%m-%d %T'),NULL,'00','Template four-token business ticket','<table class="ke-zeroborder" style="width: 97.8189%; height: 405px; font-size: 12px;" border="0" cellspacing="0" cellpadding="0">
<tbody>
<tr style="height: 95px;">
<td style="font-size: 15px; font-weight: bold; width: 99.7413%; height: 19px;" colspan="2" align="center">&nbsp;</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 99.7413%; height: 18px;" colspan="2" align="left">Date:#{currentDate}</td>
</tr>
<tr style="height: 16px;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 16px;" colspan="2" align="left"><hr /></td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 18px;" colspan="2">REQUEST NO.:#{applyNo}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="font-size: 14px; font-weight: bolder; height: 18px;" colspan="2" align="left">CUSTOMER:#{accountName}(#{accountNo})</td>
</tr>
<tr style="height: 18px;">
<td style="width: 99.7413%; height: 18px;" colspan="2" align="left">ADDRESS:#{accountAddress}</td>
</tr>
<tr style="height: 21px; display: table-row;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 21px;" colspan="2" align="left">Meter No.:#{meterNo}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 99.7413%; height: 18px;" colspan="2" align="left"><strong>BUSINESS TYPE:#{businessType}</strong></td>
</tr>
<tr style="height: 16px;">
<td style="width: 99.7413%; height: 16px;" colspan="2" align="left"><hr /></td>
</tr>
<tr style="height: 23px; display: table-row;">
<td style="font-size: 18px; font-weight: bolder; background-color: #f1f1f1; width: 99.7413%; height: 23px;" colspan="2" align="center">#{tokenInfo}</td>
</tr>
<tr style="height: 16px;">
<td style="width: 99.7413%; height: 16px;" colspan="2" align="left"><hr /></td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right" width="60%"><span lang="EN-US" style="font-size: 9pt; font-family: Verdana, sans-serif;">ORIGINAL METER REMAINING RESOURCE</span>:</td>
<td style="width: 39.7413%; height: 18px;" align="right">$[resourceRemian]</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px; text-align: right;"><span style="font-family: Verdana, sans-serif; font-size: 12px;">ORIGINAL METER REMAINING RESOURCE AMOUNT</span>:</td>
<td style="width: 39.7413%; height: 18px; text-align: right;">$[resourceAmtRemian]</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">NEW METER NO.:</td>
<td style="width: 39.7413%; height: 18px;" align="right">$[newMeterNo]</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right"><span lang="EN-US" style="font-size: 9pt; font-family: Verdana, sans-serif;">NEW METER PRESET RESOURCE</span>:</td>
<td style="width: 39.7413%; height: 18px;" align="right">$[presetResource]</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right"><span style="font-family: Verdana, sans-serif; font-size: 12px;">NEW METER PRESET RESOURCE AMOUNT</span>:</td>
<td style="width: 39.7413%; height: 18px;" align="right">$[presetResourceAmt]</td>
</tr>
<tr style="height: 18px;">
<td style="width: 60%; height: 18px;" align="right">&nbsp;</td>
<td style="width: 39.7413%; height: 18px;" align="right">&nbsp;</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right"><span lang="EN-US" style="font-size: 9pt; font-family: Verdana, sans-serif;">REASON FOR CHANGING METER</span>:</td>
<td style="width: 39.7413%; height: 18px;" align="right">$[changeReason]</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right"><span lang="EN-US" style="font-size: 9pt; font-family: Verdana, sans-serif;">CAUSE OF DANAMGE</span>:</td>
<td style="width: 39.7413%; height: 18px;" align="right">$[damageReason]</td>
</tr>
<tr style="height: 18px;">
<td style="width: 60%; height: 18px;" align="right">&nbsp;</td>
<td style="width: 39.7413%; height: 18px;" align="right">&nbsp;</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right"><span lang="EN-US" style="font-size: 9pt; font-family: Verdana, sans-serif;">TOTAL AMOUNT RECEIVABLE</span>:</td>
<td style="width: 39.7413%; height: 18px;" align="right">$[ttlRcvblAmt]</td>
</tr>
<tr style="height: 24px;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 24px;" colspan="2" align="left"><hr />Note:Use keypad to input the 20 digits token,<br />for support contact 051 409 2334</td>
</tr>
</tbody>
</table>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 4);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,5,'05','Template Five',STR_TO_DATE('2019-04-25 18:14:36','%Y-%m-%d %T'),NULL,'00','Template five - tariff launch ticket','<table class="ke-zeroborder" style="width: 97.8189%; height: 234px; font-size: 12px;" border="0" cellspacing="0" cellpadding="0">
<tbody>
<tr style="height: 95px;">
<td style="font-size: 15px; font-weight: bold; width: 99.7413%; height: 10px;" colspan="2" align="center">
<div align="center">Tairff Issue Token</div>
</td>
</tr>
<tr style="height: 16px;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 16px;" colspan="2" align="left"><hr /></td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 18px;" colspan="2" align="left">CUSTOMER:#{accountName}(#{accountNo})</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 99.7413%; height: 18px;" colspan="2" align="left">ADDRESS:#{accountAddress}</td>
</tr>
<tr style="height: 21px; display: table-row;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 21px;" colspan="2" align="left">Meter No.:#{meterNo}</td>
</tr>
<tr style="height: 16px;">
<td style="width: 99.7413%; height: 16px;" colspan="2" align="left"><hr /></td>
</tr>
<tr style="height: 23px; display: table-row;">
<td style="font-size: 18px; font-weight: bolder; background-color: #f1f1f1; width: 99.7413%; height: 23px;" colspan="2" align="center">#{tokenInfo}</td>
</tr>
<tr style="height: 16px;">
<td style="width: 99.7413%; height: 16px;" colspan="2" align="left"><hr /></td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right" width="60%">TARIFF SCHEMES:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{pkgName}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px; text-align: right;">TARIFF VERSION:</td>
<td style="width: 39.7413%; height: 18px; text-align: right;">#{verName}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">VERSION EFFECTIVE DATE:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{activeDate}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">VERSION LAUNCH DATE:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{issueDate}</td>
</tr>
<tr style="height: 24px;">
<td style="font-size: 14px; font-weight: bolder; width: 99.7413%; height: 24px;" colspan="2" align="left"><hr />Note:Use keypad to input the 20 digits token,<br />for support contact 051 409 2334</td>
</tr>
</tbody>
</table>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 5);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,6,'06','Template Six',STR_TO_DATE('2019-07-03 11:27:54','%Y-%m-%d %T'),NULL,'00','Template Six -Token issued a result notification','<p class="MsoNormal">Customer #{accountName}（#{accountNo}）meter #{meterNo}, the result of token sent:#{tokenResultInfo}</p>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 6);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,7,'07','Template Seven',STR_TO_DATE('2019-07-03 11:27:54','%Y-%m-%d %T'),NULL,'00','Template Seven - Send bill notification','<p class="MsoNormal">Customer #{accountName}（#{accountNo}）meter #{meterNo}，purchase #{energyAmt}，debt repayment #{debtAmt}，charge #{chargeAmt}，account payment #{accountPayAmt}，total charge #{rcvAmt}，change #{changeAmt}，token：#{tokenInfo}</p>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 7);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,8,'08','Template Eight',STR_TO_DATE('2019-07-03 11:27:54','%Y-%m-%d %T'),NULL,'00','Template Eight - Meter notification','<p>Meter #{meterNo} be disconnected at #{happenTime}，the reason of disconnect：#{happenReason}</p>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 8);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,9,'09','Template Nine',STR_TO_DATE('2019-07-03 11:27:55','%Y-%m-%d %T'),NULL,'00','Template Nine - Rate issued reminder','<p class="MsoNormal">The version #{verName} of tariff program #{pkgName} under supplier address #{orgId} be effectived at #{activeDate}, please execute the send operation in Tariff Settings page!</p>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 9);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,10,'10','Template Ten',STR_TO_DATE('2019-07-03 11:27:55','%Y-%m-%d %T'),NULL,'00','Template Ten - Low balance warning','<p class="MsoNormal">Customer #{accountName}（#{accountNo}）meter #{meterNo}，the meter balance(#{balance})（data time:#{balanceDataTime}） less than #{alarmValue}, please recharge as soon as possible, avoid meter disconnect to causing power failure!</p>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 10);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,11,'11','Template Eleven',STR_TO_DATE('2019-07-03 11:27:55','%Y-%m-%d %T'),NULL,'00','Template Eleven - Agent balance warning','<p class="MsoNormal">Agent #{agentName}（#{agentNo}） balance(#{balance}) less than #{alarmValue}, please recharge as soon as possible, avoid affecting selling electricity!</p>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 11);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,12,'12','Template Twelve',STR_TO_DATE('2019-07-03 11:27:55','%Y-%m-%d %T'),NULL,'00','Template Twelve - License expired warning','<p class="MsoNormal">Encryption box #{boxName}（#{boxNo}）, the license file be overdue at #{expDate}, and the number of electricity sales is #{vdTimesRemain}（#{alarmRel} #{alarmValue}）, please update as soon as possible, avoid affecting selling electricity!</p>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 12);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,13,'13','Template Thirteen ',STR_TO_DATE('2019-07-03 11:27:55','%Y-%m-%d %T'),NULL,'00','Template Thirteen - Key expired warning','<p class="MsoNormal">The key of encryption box #{boxName}（#{boxNo}） be overdue at #{expDate}, please update as soon as possible, avoid affecting selling electricity!</p>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 13);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,14,'14','Template Fourteen',STR_TO_DATE('2019-07-03 11:27:55','%Y-%m-%d %T'),NULL,'00','Template Fourteen - Regular power purchase abnormal notification','<p class="MsoNormal">Abnormalities in batches #{batchNo}, the total number of selling electricity is #{saleTotal}, the number of selling electricity failure is #{saleFailTotal}, the number of selling electricity successful is #{saleSuccessTotal}, the number of send token failure is #{tokenSendFailTotal}, the number of send token successful is #{tokenSendSuccesslTotal}, please check in Energy Batch Selling page!</p>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 14);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,15,'15','Template Fifteen',STR_TO_DATE('2019-07-03 11:27:55','%Y-%m-%d %T'),NULL,'00','Template Fifteen - Encryption service exception notification','<p class="MsoNormal">Encryption service #{serviceName}：#{serviceAddr}, happened #{abnormalType}, please process as soon as possible, avoid affecting power purchase!</p>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 15);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,16,'16','Template Sixteen',STR_TO_DATE('2019-10-19 16:09:55','%Y-%m-%d %T'),NULL,'00','Template Sixteen - Transaction settlement ticket','<table class="ke-zeroborder" style="width: 97.8189%; height: 260px; font-size: 12px;" border="0" cellspacing="0" cellpadding="0">
<tbody>
<tr style="height: 95px; display: table-row;">
<td style="font-size: 15px; font-weight: bold; width: 99.7413%; height: 10px;" colspan="2" align="center">
<div align="center">DAILY SETTLEMENT<br />Settlement No.: #{noteNo}</div>
</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 99.7413%; height: 18px;" colspan="2">Start Time:#{startDate}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="height: 18px; width: 99.7413%;" colspan="2">End Time:#{endDate}</td>
</tr>
<tr style="height: 16px;">
<td style="width: 99.7413%; height: 16px;" colspan="2" align="left"><hr /></td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; text-align: right; height: 18px;">TRANSACTION QUANTITY:</td>
<td style="width: 39.7413%; text-align: right; height: 18px;">#{saleTotal}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; text-align: right; height: 18px;">ENERGY:</td>
<td style="width: 39.7413%; text-align: right; height: 18px;">#{energy}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; text-align: right; height: 18px;">DEBT AMOUNT:</td>
<td style="width: 39.7413%; text-align: right; height: 18px;">#{debtAmt}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">PAID AMONT:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{rcvdAmt}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">PAID AMOUNT DATAIL:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{rcvdAmtDetail}</td>
</tr>
<tr style="height: 18px;">
<td style="width: 60%; height: 18px;" align="right">&nbsp;</td>
<td style="width: 39.7413%; height: 18px;" align="right">&nbsp;</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">FBE QUANTITY:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{freeNo}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;" align="right">REVERSED QUANTITY:</td>
<td style="width: 39.7413%; height: 18px;" align="right">#{reversedNo}</td>
</tr>
<tr style="height: 18px;">
<td style="width: 60%; height: 18px;" colspan="2"><hr /></td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;">VENDOR:#{chargeDept}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;">OPERATOR:#{chargeOper}</td>
</tr>
<tr style="height: 18px; display: table-row;">
<td style="width: 60%; height: 18px;">DATE:#{currentDate}</td>
</tr>
</tbody>
</table>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 16);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,17,'17','Template Seventeen',STR_TO_DATE('2019-12-17 08:34:36','%Y-%m-%d %T'),NULL,'00','Template Seventeen - POS selling electricity ticket','<p style="text-align: center;"><strong><span lang="EN-US" style="font-size: 12.0pt; mso-fareast-font-family: 宋体; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN; mso-bidi-language: AR;">EDUMBE MUNICIPALITY</span></strong></p>
<p class="MsoNormal" style="text-align: center; mso-pagination: widow-orphan;" align="center"><strong style="mso-bidi-font-weight: normal;"><span lang="EN-US" style="font-size: 12.0pt; font-family: ''Times New Roman'',serif; mso-fareast-font-family: 宋体; mso-font-kerning: 0pt; mso-bidi-language: AR;">EDUMBE</span></strong></p>
<p style="text-align: center;">#{chargeDate}</p>
<p style="text-align: center;">No:#{noteNo}</p>
<p style="text-align: left;"><span style="font-size: 10pt;"><strong><span lang="EN-US">Meter No.:</span></strong><span lang="EN-US">#{meterNo}</span></span></p>
<p style="text-align: left;"><span style="font-size: 10pt;"><strong><span lang="EN-US">Customer No.:</span></strong><span lang="EN-US">#{accountNo}</span></span></p>
<p style="text-align: left;"><span style="font-size: 10pt;"><strong><span lang="EN-US">Customer Name:</span></strong><span lang="EN-US">#{accountName}</span></span></p>
<hr style="text-align: center;" align="center" size="2" width="100%" />
<p style="text-align: left;"><span style="font-size: 10pt;"><strong><span lang="EN-US">kW.h:</span></strong><span lang="EN-US">#{energy}</span></span></p>
<p style="text-align: left;"><span lang="EN-US" style="font-size: 10pt;"><strong><span lang="EN-US">kW.h AMT:</span></strong><span lang="EN-US">#{energyAmt}</span></span></p>
<hr style="text-align: center;" align="center" size="2" width="100%" />
<p style="text-align: left;"><strong style="serif; font-size: 10pt;"><span lang="EN-US">Debt AMT:</span></strong><span lang="EN-US" style="font-size: 10pt;">#{debtAmt}</span></p>
<p style="text-align: left;"><span lang="EN-US" style="font-size: 10pt;">#{chargeAmtInfo}</span></p>
<p style="text-align: left;"><strong><span lang="EN-US" style="font-size: 10pt;">Paid Amount:</span></strong><span lang="EN-US" style="font-size: 10pt;">#{rcvdAmt}</span></p>
<p style="text-align: left;"><strong><span lang="EN-US" style="font-size: 10pt;">Cashier:</span></strong><span lang="EN-US" style="font-size: 10pt;">#{agentNo}</span></p>
<hr style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 14px; text-align: center;" align="center" size="2" width="100%" />
<p style="text-align: center;"><strong><span lang="EN-US"><span lang="EN-US">#{tokenInfo}</span></span></strong></p>
<p style="text-align: center;"><span lang="EN-US"><span lang="EN-US">#{barCode_meterNo}</span></span></p>
<p style="text-align: center;"><span lang="EN-US"><span lang="EN-US"><strong><span lang="EN-US" style="font-size: 12.0pt; mso-fareast-font-family: 宋体; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN; mso-bidi-language: AR;">Please press Enter after each 20-digits Token,then continue to another new Token.</span></strong></span></span></p>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 17);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,18,'18','Template Eighteen',STR_TO_DATE('2019-12-17 08:34:42','%Y-%m-%d %T'),NULL,'00','Template Eighteen - IC card business ticket','<p style="text-align: center;"><strong><span lang="EN-US" style="font-size: 12.0pt; font-family: ''Times New Roman'',serif; mso-fareast-font-family: 宋体; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN; mso-bidi-language: AR;">EDUMBE MUNICIPALITY</span></strong></p>
<p class="MsoNormal" style="text-align: center; mso-pagination: widow-orphan;" align="center"><strong style="mso-bidi-font-weight: normal;"><span lang="EN-US" style="font-size: 12.0pt; font-family: ''Times New Roman'',serif; mso-fareast-font-family: 宋体; mso-font-kerning: 0pt; mso-bidi-language: AR;">EDUMBE</span></strong></p>
<p style="text-align: center;"><span lang="EN-US" style="font-size: 12.0pt; font-family: ''Times New Roman'',serif; mso-fareast-font-family: 宋体; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN; mso-bidi-language: AR;">#{currentDate}</span></p>
<p style="text-align: left;"><span style="font-size: 10pt;"><strong><span lang="EN-US" style="font-family: ''Times New Roman'', serif;">Business No.:</span></strong><span lang="EN-US" style="font-family: ''Times New Roman'', serif;">#{businessNo}</span></span></p>
<p style="text-align: left;"><span lang="EN-US" style="font-size: 10pt; font-family: ''Times New Roman'', serif;"><strong><span lang="EN-US">Business Type:</span></strong><span lang="EN-US">#{businessType}</span></span></p>
<p style="text-align: left;"><span lang="EN-US" style="font-size: 10pt; font-family: ''Times New Roman'', serif;"><span lang="EN-US"><strong><span lang="EN-US">POS IMEI:</span></strong><span lang="EN-US">#{posImei}</span></span></span></p>
<p style="text-align: left;"><span lang="EN-US" style="font-size: 10pt; font-family: ''Times New Roman'', serif;"><span lang="EN-US"><span lang="EN-US"><strong><span lang="EN-US">Agent:</span></strong><span lang="EN-US">#{agentName}</span></span></span></span></p>
<p style="text-align: left;"><span lang="EN-US" style="font-size: 10pt; font-family: ''Times New Roman'', serif;"><span lang="EN-US"><span lang="EN-US"><span lang="EN-US"><strong><span lang="EN-US">Old POS IMEI:</span></strong><span lang="EN-US">#{oldPosImei}</span></span></span></span></span></p>
<p style="text-align: left;"><span lang="EN-US" style="font-size: 10pt; font-family: ''Times New Roman'', serif;"><span lang="EN-US"><span lang="EN-US"><span lang="EN-US"><span lang="EN-US"><strong><span lang="EN-US">Original POS Balance:</span></strong><span lang="EN-US">#{oldPosBalance}</span></span></span></span></span></span></p>
<p style="text-align: left;"><span lang="EN-US" style="font-size: 10pt; font-family: ''Times New Roman'', serif;"><span lang="EN-US"><span lang="EN-US"><span lang="EN-US"><span lang="EN-US"><span lang="EN-US"><strong><span lang="EN-US">New POS IMEI:</span></strong><span lang="EN-US">#{newPosImei}</span></span></span></span></span></span></span></p>
<p style="text-align: left;"><span lang="EN-US" style="font-size: 10pt; font-family: ''Times New Roman'', serif;"><span lang="EN-US"><span lang="EN-US"><span lang="EN-US"><span lang="EN-US"><span lang="EN-US"><span lang="EN-US"><strong><span lang="EN-US">New POS Deposit Token Amounts:</span></strong><span lang="EN-US">#{depositTokenAmt}</span></span></span></span></span></span></span></span></p>
<p style="text-align: left;"><span lang="EN-US" style="font-size: 10pt; font-family: ''Times New Roman'', serif;"><span lang="EN-US"><span lang="EN-US"><span lang="EN-US"><span lang="EN-US"><span lang="EN-US"><span lang="EN-US"><span lang="EN-US"><strong><span lang="EN-US">Refund Amount:</span></strong><span lang="EN-US">#{refundAmount}</span></span></span></span></span></span></span></span></span></p>
<hr style="text-align: center;" align="center" size="2" width="100%" />
<p style="text-align: center;"><strong>#{depositToken}</strong></p>
<p style="text-align: center;">#{qrCode_depositToken}</p>
<p style="text-align: center;">#{barCode_depositToken}</p>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 18);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,19,'19','Template Nineteen',STR_TO_DATE('2019-12-17 08:34:57','%Y-%m-%d %T'),NULL,'00','Template Nineteen - Agent deposit recharge ticket','<p style="text-align: center;"><strong><span lang="EN-US" style="font-size: 12.0pt; font-family: ''Times New Roman'',serif; mso-fareast-font-family: 宋体; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN; mso-bidi-language: AR;">EDUMBE MUNICIPALITY</span></strong></p>
<p class="MsoNormal" style="text-align: center; mso-pagination: widow-orphan;" align="center"><strong style="mso-bidi-font-weight: normal;"><span lang="EN-US" style="font-size: 12.0pt; font-family: ''Times New Roman'',serif; mso-fareast-font-family: 宋体; mso-font-kerning: 0pt; mso-bidi-language: AR;">EDUMBE</span></strong></p>
<p style="text-align: center;"><span lang="EN-US" style="font-size: 12.0pt; font-family: ''Times New Roman'',serif; mso-fareast-font-family: 宋体; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN; mso-bidi-language: AR;">#{rechargeDate}</span></p>
<p style="text-align: center;"><span lang="EN-US" style="font-size: 12.0pt; font-family: ''Times New Roman'',serif; mso-fareast-font-family: 宋体; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN; mso-bidi-language: AR;">#{rechargeNo}</span></p>
<p style="text-align: left;"><span lang="EN-US" style="font-size: 10pt; font-family: ''Times New Roman'', serif;"><strong><span lang="EN-US">Agent No.</span></strong><span lang="EN-US">:#{agentNo}</span></span></p>
<p style="text-align: left;"><span lang="EN-US" style="font-size: 10pt;"><span lang="EN-US"><strong><span lang="EN-US"><span style="font-family: Times New Roman, serif;">Agent Name</span><span style="font-family: 宋体;">:</span></span></strong><span lang="EN-US"><span style="font-family: 宋体;">#{agentName}</span></span></span></span></p>
<p style="text-align: left;"><span lang="EN-US" style="font-size: 10pt;"><span lang="EN-US"><span lang="EN-US"><strong><span lang="EN-US" style="font-family: ''Times New Roman'', serif;">POS IMEI:</span></strong><span lang="EN-US" style="font-family: ''Times New Roman'', serif;">#{posImei}</span></span></span></span></p>
<hr style="text-align: center;" align="center" size="1" width="100%" />
<p><strong style="font-size: 10pt;"><span lang="EN-US" style="font-family: ''Times New Roman'', serif;">Recharge Amount:</span></strong><span lang="EN-US" style="font-family: ''Times New Roman'', serif;">#{rechargeAmt}</span></p>
<p><span lang="EN-US" style="font-size: 10pt; font-family: ''Times New Roman'', serif;"><strong><span lang="EN-US">Payment Method:</span></strong><span lang="EN-US">#{settleMode}</span></span></p>
<p><span lang="EN-US" style="font-size: 10pt; font-family: ''Times New Roman'', serif;"><span lang="EN-US"><strong><span lang="EN-US">Document no.:</span></strong><span lang="EN-US">#{settleNoteNo}</span></span></span></p>
<hr style="text-align: center;" align="center" size="2" width="100%" />
<p><span style="font-size: 10pt;"><strong><span lang="EN-US" style="font-family: ''Times New Roman'', serif;">Cashier:</span></strong><span lang="EN-US" style="font-family: ''Times New Roman'', serif;">#{chargeOper}</span></span></p>
<p><span lang="EN-US" style="font-size: 10pt; font-family: ''Times New Roman'', serif;"><strong><span lang="EN-US">Cashier Unit:</span></strong><span lang="EN-US">#{chargeDept}</span></span></p>
<hr style="text-align: center;" align="center" size="2" width="100%" />
<p style="text-align: center;"><strong>#{depositToken}</strong></p>
<p style="text-align: center;">#{barCode_depositToken}</p>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 19);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,20,'20','Template Twenty',STR_TO_DATE('2020-05-22 15:00:00','%Y-%m-%d %T'),NULL,'01','Template Twenty - Received','<p class="MsoNormal">Dear customer #{customerName}：the question you submitted #{problemNumber}, the current status is #{problemStatus}, please follow up!</p>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 20);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,21,'21','Template Twenty One',STR_TO_DATE('2020-05-22 15:00:00','%Y-%m-%d %T'),NULL,'01','Template Twenty One - Accepting','<p class="MsoNormal">Dear customer #{customerName}：the question you submitted #{problemNumber}, the current status is #{problemStatus}, please follow up!</p>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 21);
INSERT INTO VD_PRE_MODEL(LESSEE_ID,MODEL_ID,MODEL_TYPE,MODEL_NAME,CREATE_DATE,CREATE_CZY,STATUS,REMARKS,BILL_MODEL_HTML)
SELECT 2,22,'22','Template Twenty Two',STR_TO_DATE('2020-05-22 15:00:00','%Y-%m-%d %T'),NULL,'01','Template Twenty Two - Processed','<p class="MsoNormal">Dear customer #{customerName}：the question you submitted #{problemNumber}, the current status is #{problemStatus}, please follow up!</p>'
FROM DUAL WHERE NOT EXISTS (SELECT * FROM VD_PRE_MODEL WHERE MODEL_ID = 22);
```