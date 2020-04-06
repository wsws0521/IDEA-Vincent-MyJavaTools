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
-- Table structure for table `vd_a_acct_book`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `vd_a_acct_book` (
  `LESSEE_ID` bigint(20) DEFAULT NULL COMMENT '本实体唯一标识符',
  `BOOK_ID` decimal(16,0) NOT NULL COMMENT '本实体唯一标识',
  `ACCT_ID` decimal(16,0) DEFAULT NULL COMMENT '账号标识，本实体的唯一标识',
  `CHARGE_ID` decimal(16,0) DEFAULT NULL COMMENT '本实体记录唯一标识，产生规则为流水号',
  `BOOK_NAME` varchar(256) DEFAULT NULL COMMENT '账本名称，描述账本的主题',
  `BOOK_SUBJECT` varchar(8) DEFAULT NULL COMMENT '账本的费用科目',
  `SUBJECT_AMT` decimal(18,2) DEFAULT NULL COMMENT '对应科目的金额',
  `BOOK_TIME` datetime DEFAULT NULL COMMENT '记录的时间',
  `BOOK_DESC` varchar(512) DEFAULT NULL COMMENT '记录的说明描述',
  `TV`		DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`BOOK_ID`, `TV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='\n账本\n1）记录用户的账户发生的账务往来，主要包含：账本科目、金额、时间等信息\n'
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

-- Dump completed on 2019-02-22 17:07:51
CALL PR_MOD_COL('VD_A_ACCT_BOOK','add','SETTLEDATE','DATE','NULL','NULL','');
CALL PR_MOD_COL('VD_A_ACCT_BOOK','DROP','SETTLEDATE','','','','');
CALL PR_MOD_IDX_CONS ('VD_A_ACCT_BOOK','ADD','I','IDX_ACCT_BOOK_CHARGE_ID','CHARGE_ID','','', '', '');