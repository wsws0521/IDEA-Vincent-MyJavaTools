------------------------------------<queryBalanceDetail>-------------------------------------------
SELECT 	CASE WHEN TYPE_CODE='10' AND BOOK_SUBJECT IN ('13','23') THEN AMI_WEB_GET_P_CODE_VALUE('11','agentChargeType', 'zh_CN')
					ELSE AMI_WEB_GET_P_CODE_VALUE(TYPE_CODE,'agentChargeType', 'zh_CN')
					END AS "type",
        DATE_FORMAT(BOOK_TIME,"%Y-%m-%d %H:%i:%s") AS "time",
        CAST(CASE WHEN BOOK_SUBJECT IN ('13','23') THEN -SUBJECT_AMT ELSE SUBJECT_AMT END
            AS CHAR) AS "amount",
        CASE WHEN BOOK_SUBJECT IN ('13','23') THEN AMI_WEB_GET_P_CODE_VALUE('03','rechargeMethod', 'zh_CN')
                    WHEN TYPE_CODE IN ('11','10') AND (BOOK_SUBJECT <> '13' OR BOOK_SUBJECT <> '23') THEN AMI_WEB_GET_P_CODE_VALUE(SETTLE_MODE,'settleType', 'zh_CN')
                    ELSE AMI_WEB_GET_P_CODE_VALUE(SETTLE_MODE,'rechargeMethod', 'zh_CN')
                    END AS "paymentMethod",
        CASE WHEN BOOK_SUBJECT = '13' THEN NULL ELSE SETTLE_NOTE_NO END AS "paymentNumber",
        CHARGE_REMARK AS "remark",
        (SELECT NAME FROM UAP_USER WHERE ID = CHARGE_OPER) AS "oprator",
        PAS.IMEI, PAS.POS_SCENE, B.CHARGE_ID, TYPE_CODE "agentChargeType"
FROM VD_A_ACCT_BOOK B JOIN vd_a_pay_flow P ON B.CHARGE_ID = P.CHARGE_ID AND B.LESSEE_ID = P.LESSEE_ID
LEFT JOIN VD_POS_AGENT PAG ON P.OBJ_ID = PAG.AGENT_ID AND P.LESSEE_ID = PAG.LESSEE_ID
LEFT JOIN vd_pos_assets PAS ON PAG.IMEI = PAS.IMEI AND PAG.LESSEE_ID = PAS.LESSEE_ID
WHERE B.LESSEE_ID = 2
			AND ACCT_ID = (SELECT ACCT_ID FROM vd_a_account AC, vd_agt_agent AG WHERE AC.ACCT_NO = AG.AGENT_NO AND AG.AGENT_NO = #{})
			AND BOOK_TIME BETWEEN #{} AND #{}
			AND TYPE_CODE IN #{};

------------------------------------sqlserver数据源获取-------------------------------------------

select  c.TE_NAME, -- 代理商名称
        cc.CCL_EVIDENCE, -- 日结单编号，是一个描述字段，有可能找不到日结单记录
        cc.CCL_CASH, -- 充值金额，有可能为负数，和正数处理方式一致
        convert(varchar(19),cc.NEWDATE,120) as createDate, -- 充值时间
        u.USER_ACCOUNT as operator -- Administrator和admin是超级管理员,这2个用户没有迁移，直接使用8.0里的管理员就行
from IPARA_CDUSTATION_CREDITLOG cc
inner join IPARA_CDUSTATION c on cc.TERRITORYID=c.TERRITORYID
left join IAUDIT_USER u on cc.NEWOPERATOR=u.USER_ID
order by cc.NEWDATE

-------------------------------------tmp_hzjl  自动建表语句-----------------------------------------




 ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;