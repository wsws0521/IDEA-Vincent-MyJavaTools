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
-- Table structure for table `vd_a_rcvbl_flow`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `vd_a_rcvbl_flow` (
  `LESSEE_ID` bigint(20) DEFAULT NULL COMMENT '本实体唯一标识符',
  `RCVBL_AMT_ID` decimal(16,0) NOT NULL COMMENT '本实体记录唯一标识，产生规则为流水号',
  `CALC_ID` decimal(16,0) DEFAULT NULL COMMENT '电费计算标识，来源于电费计算过程',
  `AMT_TYPE` varchar(8) DEFAULT NULL COMMENT '按产生应收的来源分类，包括01 电费 11 债务 21 佣金 31 费率费用 41 业务费',
  `RCVBL_YM` varchar(6) DEFAULT NULL COMMENT '表示电费应收发生费用的年月。',
  `OBJ_TYPE` varchar(8) DEFAULT NULL COMMENT '对象类型:01客户、02用户03代理商04加密盒03表计厂商',
  `OBJ_ID` varchar(32) DEFAULT NULL COMMENT '对象标识:用户标识；代理商标识',
  `OBJ_NO` varchar(50) NOT NULL COMMENT '对象编号：用户编号；代理商编号',
  `METER_ID` varchar(32) DEFAULT NULL COMMENT '表计标识',
  `METER_NO` varchar(50) DEFAULT NULL COMMENT '表计编号',
  `RCVBL_AMT` decimal(18,2) DEFAULT NULL COMMENT '表示实体属性应收金额，如用电费、违约等业务产生的用电客户的费用。',
  `RCVED_AMT` decimal(18,2) DEFAULT NULL COMMENT '实收金额',
  `RCVBL_PENALTY` decimal(18,2) DEFAULT NULL COMMENT '应收违约金:应收违约金，根据欠费金额及收费日期计算出的违约金总额。',
  `RCVED_PENALTY` decimal(18,2) DEFAULT NULL COMMENT '实收违约金',
  `STATUS_CODE` varchar(8) DEFAULT NULL COMMENT '费用收取过程的状态，包括非锁定、锁定(代扣在途)、锁定(走收在途)、锁定(托收在途)。',
  `SETTLE_FLAG` varchar(8) DEFAULT NULL COMMENT '电费结清的标志：欠费、部分结清、全部结清、坏账核销。',
  `PENALTY_BGN_DATE` date DEFAULT NULL COMMENT '违约金起算日期',
  `RELEASE_DATE` varchar(8) DEFAULT NULL COMMENT '描述电费发行日期',
  `RELATE_ID` decimal(16,0) DEFAULT NULL COMMENT '存放关联收费记录的主键，如债务记录关联的被电费记录ID',
  `RELATE_FLAG` varchar(8) DEFAULT NULL COMMENT '关联标志，用于关联记录的费用收取，如合并收费或单独收费等',
  `SRC` varchar(8) DEFAULT NULL COMMENT '数据来源：01Billing、02Vending、其它待定',
  `RES_QUAN` decimal(18,2) DEFAULT NULL COMMENT '资源量',
  `ORG_ID` bigint(20) DEFAULT NULL COMMENT '供电单位编号:供电管理单位的代码',
  `BUS_FROM_OBJ` varchar(8) DEFAULT NULL COMMENT '字典表：01token申请（VD_T_APPLY） 02注销和换表（VD_T_APPLY_CNL）',
  `BUS_FROM_OBJ_ID` decimal(16,0) DEFAULT NULL,
  `TV`		DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`RCVBL_AMT_ID`, `TV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='1) 用于记录电费应收数据。实体包含的内容：应收电费类别、应收年月、应收金额、实收金额等应收信息。'
PARTITION BY RANGE (TO_DAYS(TV))(PARTITION PMAX VALUES LESS THAN (MAXVALUE));
CALL PR_MOD_IDX_CONS('VD_A_RCVBL_FLOW','ADD','I','IDX_RCVBL_FLOW_OBJ_ID','OBJ_ID,METER_ID,SETTLE_FLAG','','','','');
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-22 17:07:53
