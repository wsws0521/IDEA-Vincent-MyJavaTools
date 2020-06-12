## 预付费报表
> Finance
>> Sale Report-----------------（销售统计）
>>> 汇总对象 【销售单位】【代理商】【费率】【表型】【供电单位】：年/月/日

>> Sales Monthly Report--------（月销售报表）
>>> 按-月-查询

>> Transaction Details---------（交易明细）~~免费明细~~
>>> 汇总对象 【交易记录】【FBE】

>> FBE Summary-----------------（免费统计）
>>> 汇总对象 【销售单位】【代理商】：年/月/日

>> Vendor Daily Summary--------（日结统计）
>>> 汇总对象 【销售单位】【代理商】【营业员】：日

>> Agent Deposit Details-------（代理商日结解款明细）
>>> 按-代理商-查询

>> Agent Sales and Recharge----（代理商销售充值总结）
>>> 按-代理商-查询

>> Sale Summary Report---------（销售总结报表）~~
>>> 按-月-查询

>> CDU Charge------------------（代理商充值明细）+++----------------------/VendingReport/financialData/rechargeDetailController------/queryRechargeDetail
>>> 按-代理商-查询

-----
> Management
>> Purchase Trend--------------------（销售趋势）
>>> 汇总对象 【销售单位】【自营·代理商】

>> Transaction Block Statistics------（阶梯销售统计）
>>> 按-月-查询

>> Debt Summary----------------------（债务统计）
>>> 按-月-查询，其实也是按单位汇总，总剩余/总回收/总新建

>> Debt Category Report--------------（债务分类汇总）
>>> 汇总对象 【债务类型】【用户】代理商：日

>> Power Purchase Abnormal Customer--（购电异常用户）
>>> 汇总对象 【正常】【免费】

>> Meter Without Purchase------------（未购电表计）---------cn.hexing.vending.VendingReport.dao.meterWithoutPurchase.MeterWithoutPurchaseDao
>>> 按-时间-单位-查询

>> Token Statistics------------------（Token统计）
>>> 按-Token类型-时间-单位-查询

>> Vendor Operating Time Details-----（工时明细）
>>> 汇总对象 【销售单位】【自营·代理商】

>> Vendor Operating Time Summary-----（工时统计）-----------/VendingReport/workTimeStatistics/WorkTimeStaController-----/queryWorkTimeData -----WorkTimeStatisticsdaoMapper.xml
>>> 汇总对象 【销售单位】【自营·代理商】

>> Charge Correct Details------------（纠正记录）+++国际化
>>> 按-操作员-单位-查询

>> Token Request Details-------------（Token申请明细）+++无权限！
>>> 按-操作员-申请模板-申请时间-查询

-----
> Engineering
>> Meter Management Status---（表计管理状态）--------------/VendingReport/meterStatusReportController------/queryMeterStatusReport------MeterStatusReportMapper.xml
>>> 汇总对象 【管理单位】【厂家】

>> FBE Report----------------（表计免费额度）
>>> 按-单位-查询