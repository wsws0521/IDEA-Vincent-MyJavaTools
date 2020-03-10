## 页面为MDCAdmin赋予所有单位权限
MDCAdmin登录主站>>组织体系管理>>管理单位配置>>点根单位，
选择MDCAdmin>>添加单位访问权限（UAP_USER_ORG_MANAGE）>>添加全部单位；

## ① 手动创建：计费项（Value = 0.15）
INDIGENT(VAT15%)
COMMON(VAT15%)
BUSINESS(VAT15%)
MANGAUNGNON PROFIT(VAT15%)

## ② 手动创建：费率方案、版本、审核，并添加对应的VAT，版本生效时间一个为当前，一个为2020.6.1。
为每个Tariff选择相应的[计费项]

## ③ 将所有费率版本ti更新为1（前提是确认老系统的费率ti都是1）
老系统确认：
Select ti from TARIFF_INDEX group by ti;
Select ti from TARIFF_TABLE group by ti;
新系统执行：
Update vd_e_bill_pkg_ver set ti = 1; -- 15个winter被更新

## ④ 注意配置定时任务，如果着急版本生效
新系统执行：
Update vd_e_bill_pkg_ver set STATUS = '05' where STATUS = '03';  -- 15个summer+2个非盈利=17个被更新

## 注意：
0、所有费率方案均可挂在根单位下，
暂时统一选居民=低压居民，商业=非居民
1、版本-单次充值上限500，不做限制，代理商那边有限制
2、对于2个阶梯单价相同的，无需合并成一个阶梯
3、不存在特殊阶梯