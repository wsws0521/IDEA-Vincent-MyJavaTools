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
-- Table structure for table `vd_a_rcvbl_details`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `vd_a_rcvbl_details` (
  `LESSEE_ID` bigint(20) DEFAULT NULL COMMENT '本实体唯一标识符',
  `RCVBL_DETAIL_ID` decimal(16,0) NOT NULL COMMENT '本实体记录唯一标识，产生规则为流水号',
  `RCVBL_AMT_ID` decimal(16,0) DEFAULT NULL COMMENT '本实体记录唯一标识，产生规则为流水号',
  `CALC_AMT_ID` decimal(16,0) DEFAULT NULL COMMENT '电费计算详细实体内部唯一标识',
  `ITEM_NAME` varchar(256) DEFAULT NULL COMMENT '计费项的名称',
  `BILL_TYPE` varchar(8) DEFAULT NULL COMMENT '计费类型，采用码表，码表分层级关系，看统计要求，也可以不分级，如：\n											01电量电费\n											0101总电费\n											0111尖峰电费\n											0112峰电费\n											0113平电费\n											0114谷电费\n											0121阶1电费\n											0122阶2电费\n											0123阶3电费\n											02代征电费\n											0201三峡基金（分价内价外，价内的只计算明细，不参与合计）\n											0202市政附加\n											03基本电费\n											0301容量电费\n											0302需量电费\n											04力调电费\n											0401力调奖励\n											0402力调惩罚\n											05税费\n											0501月租费\n											0502增值税\n											06折扣\n											0601折扣1\n											0602折扣2\n											07服务费\n											0701服务费\n											0702固定费',
  `BILL_VALUE` decimal(12,4) DEFAULT NULL COMMENT '客户提供的扣款银行的代码',
  `CALC_VALUE` decimal(18,2) DEFAULT NULL COMMENT '如果计费类型是电量电费或代征费用，此字段放电量值\n											如果计费类型是基本电费，此字段放容量值或需量值\n											如果计费类型是力调电费，此字段放功率因数\n											如果计费类型是税费，此字段放固定值或定比计算值\n											如果计费类型是折扣，此字段放打折前金额',
  `RCVBL_AMT` decimal(18,2) DEFAULT NULL COMMENT '表示实体属性应收金额，如用电费、违约等业务产生的用电客户的费用。',
  `RCVED_AMT` decimal(18,2) DEFAULT NULL COMMENT '实收金额',
  `REMARK` varchar(256) DEFAULT NULL COMMENT '电费说明',
  `ORG_ID` bigint(20) DEFAULT NULL COMMENT '供电单位编号:供电管理单位的代码',
  `ITEM_ID` decimal(16,0) DEFAULT NULL COMMENT 'item id',
  `TV`		DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`RCVBL_DETAIL_ID`, `TV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='1) 记录电费应收过程中各项税费的实收情况\n2)通过收费时记录的电费流水帐，由过程产生。'
PARTITION BY RANGE (TO_DAYS(TV))(PARTITION PMAX VALUES LESS THAN (MAXVALUE));
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
