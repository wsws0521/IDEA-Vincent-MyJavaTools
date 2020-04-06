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
-- Table structure for table `vd_a_inv`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `vd_a_inv` (
  `LESSEE_ID` bigint(20) DEFAULT NULL COMMENT '本实体唯一标识符',
  `NOTE_ID` decimal(16,0) NOT NULL COMMENT '本实体记录唯一标识，产生规则为流水号',
  `VER_ID` decimal(16,0) NOT NULL COMMENT '本实体记录唯一标识，产生规则为流水号',
  `NOTE_NO` varchar(32) DEFAULT NULL COMMENT '票据号码',
  `NOTE_TYPE_CODE` varchar(8) DEFAULT NULL COMMENT '票据类型：电费发票、电费收据、业务费发票、业务费收据',
  `NOTE_STATUS_CODE` varchar(8) DEFAULT NULL COMMENT '票据状态：库存未用、库存已用、已领用、已作废、已经丢失',
  `STORE_DEPT_NO` bigint(20) DEFAULT NULL COMMENT '票据保管部门，同部门。',
  `KEEPER_NO` bigint(20) DEFAULT NULL COMMENT '票据的保管人员，同操作员。',
  `ORG_ID` bigint(20) DEFAULT NULL COMMENT '用电客户所属的供电所，用于描述属性归属。',
  `TV`		DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`NOTE_ID`, `TV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='\n票据\n1)客户在购买电力产品或接受电力服务的经营活动中开具的收款凭证，包括发票和收据。实体包含的内容：实体包含的内容：票据编号、票据类型、单位编号、票据状态等票据记录内容。\n2)通过发票打印等由过程产生。\n3)该实体主要由发票打印使用。\n'
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

-- Dump completed on 2019-02-22 17:07:52
