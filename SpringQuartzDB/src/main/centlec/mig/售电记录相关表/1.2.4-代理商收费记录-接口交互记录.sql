/*代理商收费记录*/
CREATE TABLE IF NOT EXISTS A_AGENT_PAY_FLOW
(
   LESSEE_ID            BIGINT(20) COMMENT '租户ID',
   AGENT_CHARGE_ID      NUMERIC(16,0) NOT NULL COMMENT '本实体记录唯一标识',
   LOG_ID               NUMERIC(16,0) COMMENT '记录标识',
   CHARGE_ID            NUMERIC(16,0) COMMENT '收费标识',
   CONS_ID              VARCHAR(32) COMMENT '票据号码',
   TV					DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (AGENT_CHARGE_ID, TV)
)ENGINE = INNODB CHARACTER SET = UTF8MB4 COLLATE = UTF8MB4_GENERAL_CI COMMENT = '代理商收费记录'
PARTITION BY RANGE (TO_DAYS(TV))(PARTITION PMAX VALUES LESS THAN (MAXVALUE));

CALL PR_MOD_IDX_CONS ('A_AGENT_PAY_FLOW','ADD','I','IDX_AGT_PAY_FLOW_LOGID','LOG_ID','','', '', '');


-------------------------------------------------------------------------------------------------



/*第三方售电接口交互记录*/
CREATE TABLE IF NOT EXISTS VD_P_THIRD_PARTY_SWAP_LOG
(
   LESSEE_ID            BIGINT(20) COMMENT '租户ID',
   LOG_ID               NUMERIC(16,0) NOT NULL COMMENT '本实体记录唯一标识',
   THIRD_PARTY_ID       NUMERIC(16,0) COMMENT '第三方标识',
   SWAP_WAY             VARCHAR(8),
   SWAP_ID              NUMERIC(16,0),
   MSGID                NUMERIC(20,0),
   METER_NO             VARCHAR(50),
   TREAT_TYPE           VARCHAR(8),
   TREAT_NUM            NUMERIC(5,0),
   AMT                  NUMERIC(18,2),
   TREAT_DATE           DATETIME,
   LOG_TIME             DATETIME,
   TV					DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (LOG_ID, TV)
)ENGINE = INNODB CHARACTER SET = UTF8MB4 COLLATE = UTF8MB4_GENERAL_CI COMMENT = '第三方售电接口交互记录'
PARTITION BY RANGE (TO_DAYS(TV))(PARTITION PMAX VALUES LESS THAN (MAXVALUE));

CALL PR_MOD_IDX_CONS ('VD_P_THIRD_PARTY_SWAP_LOG','ADD','I','VD_TPSL_MSGID','MSGID','','', '', '');