-- MySQL dump 10.13  Distrib 5.7.12, for Linux (x86_64)
--
-- Host: 172.30.12.203    Database: mdc20190221
-- ------------------------------------------------------
-- Server version	5.7.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `vd_a_pay_flow`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `vd_a_pay_flow` (
  `LESSEE_ID` bigint(20) DEFAULT NULL COMMENT '本实体唯一标识符',
  `CHARGE_ID` decimal(16,0) NOT NULL COMMENT '本实体记录唯一标识，产生规则为流水号',
  `DS_ID` decimal(16,0) DEFAULT NULL COMMENT '本实体记录唯一标识，产生规则为流水号',
  `OBJ_TYPE` varchar(8) DEFAULT NULL COMMENT '对象类型:01客户、02用户03代理商04加密盒03表计厂商',
  `OBJ_ID` varchar(32) DEFAULT NULL COMMENT '对象标识:用户标识；代理商标识',
  `OBJ_NO` varchar(50) NOT NULL COMMENT '对象编号：用户编号；代理商编号',
  `METER_ID` varchar(32) DEFAULT NULL COMMENT '表计标识',
  `METER_NO` varchar(50) DEFAULT NULL COMMENT '表计编号',
  `CHARGE_YM` varchar(6) DEFAULT NULL COMMENT '收费年月。',
  `CHARGE_DATE` datetime DEFAULT NULL COMMENT '收费日期。',
  `ACCT_YM` varchar(6) DEFAULT NULL COMMENT '记账年月:用于描述帐务记帐年月',
  `TYPE_CODE` varchar(8) DEFAULT NULL COMMENT '收费类型代码规则改为3级，第3级可自定义，1级分收费、退款、转账，1、2级代码如下：\n            10 收费 分类用\n            11 收电费\n            1101... 自定义\n            12 收业务费\n            13 收电费与业务费\n            14 代理商充值\n            20 退款 分类用\n            21 退电费\n            22 退业务费\n            23 退预收费\n            30 转帐 分类用\n            31佣金结转\n            3001 ... 自定义\n            40代理商调账',
  `RCV_AMT` decimal(18,2) DEFAULT NULL COMMENT '收费金额，描述收取客户的总金额。',
  `CHANGE_AMT` decimal(18,2) DEFAULT NULL COMMENT '找零金额',
  `RCVD_AMT` decimal(18,2) DEFAULT NULL COMMENT '实收金额：收费金额-找零金额',
  `CHARGE_OPER` bigint(20) DEFAULT NULL COMMENT '收费人员',
  `SETTLE_MODE` varchar(8) DEFAULT NULL COMMENT '结算方式：现金、转账支票、本票、承兑汇票、pos刷卡、充值卡、坏账核销、列账单、转账、内部转账',
  `SETTLE_NOTE_NO` varchar(32) DEFAULT NULL COMMENT '结算票据号码：转账支票、本票、承兑汇票的原始票据号码',
  `SETTLE_BANK_CODE` varchar(8) DEFAULT NULL COMMENT '结算票据银行',
  `DEPT_ID` bigint(20) DEFAULT NULL COMMENT '用于操作员所在部门',
  `RCV_ORG_ID` bigint(20) DEFAULT NULL COMMENT '用于记录收款动作单位',
  `CHARGE_REMARK` varchar(256) DEFAULT NULL COMMENT '收费备注。可以对特殊的收费记录备注信息。如冲正原因等',
  `RELATE_ID` decimal(16,0) DEFAULT NULL COMMENT '存放关联收费记录的主键，如退费记录关联的被退费记录ID',
  `SRC` varchar(8) DEFAULT NULL COMMENT '数据来源：01Billing、02Vending、其它待定',
  `ORG_ID` bigint(20) DEFAULT NULL COMMENT '供电单位编号:供电管理单位的代码',
  `PAY_BANK_ACC` varchar(32) DEFAULT NULL,
  `RCV_BANK` varchar(8) DEFAULT NULL,
  `RCV_BANK_ACC` varchar(32) DEFAULT NULL,
  `TV`		DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`CHARGE_ID`, `TV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='1) 收取客户费用、内部转帐的流水账，收费、支票退票、预收结转、退款、转预收等，对于具有委托缴费关系的用电客户，收费记录'
PARTITION BY RANGE (TO_DAYS(TV))(PARTITION PMAX VALUES LESS THAN (MAXVALUE));
CALL PR_MOD_IDX_CONS('VD_A_PAY_FLOW','ADD','I','IDX_PAY_FLOW_METER_ID','METER_ID','','','','');
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-22 17:07:52
CALL PR_MOD_COL('VD_A_PAY_FLOW','add','CHANNEL','VARCHAR(8)','NULL','NULL','');
CALL PR_MOD_IDX_CONS ('VD_A_PAY_FLOW','ADD','I','IDX_PAY_FLOW_DS_ID','DS_ID','','', '', '');
CALL PR_MOD_IDX_CONS ('VD_A_PAY_FLOW','ADD','I','IDX_PAY_FLOW_ORG_ID','ORG_ID','','', '', '');
CALL PR_MOD_IDX_CONS ('VD_A_PAY_FLOW','ADD','I','IDX_PAY_FLOW_OBJ_ID','OBJ_ID','','', '', '');