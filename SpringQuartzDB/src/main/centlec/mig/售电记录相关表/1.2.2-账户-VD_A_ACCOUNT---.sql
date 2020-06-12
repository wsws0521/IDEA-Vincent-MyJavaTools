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
-- Table structure for table `vd_a_account`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `vd_a_account` (
  `LESSEE_ID` bigint(20) DEFAULT NULL COMMENT '本实体唯一标识符',
  `ACCT_ID` decimal(16,0) NOT NULL COMMENT '账号标识，本实体的唯一标识',
  `ACCT_CATEGOTY` varchar(8) DEFAULT NULL COMMENT '账户类别：01用户账户；02代理商账户',
  `ACCT_NO` varchar(50) DEFAULT NULL COMMENT '账号\n            根据账户名类型\n            01用户账户：用户编号\n            02代理商账户：代理商编号',
  `CATEGOTY_ID` varchar(32) DEFAULT NULL COMMENT '账户类别标识',
  `ACCT_TYPE` varchar(8) DEFAULT NULL COMMENT '01 预收账户、02保证金账户、03尾调账户等等',
  `PAY_SEQ` decimal(5,0) DEFAULT NULL COMMENT '支付顺序',
  `FREEZE_AMT` decimal(18,2) DEFAULT NULL COMMENT '冻结金额',
  `AVAILABLE_AMT` decimal(18,2) DEFAULT NULL COMMENT '可用余额',
  `TOTAL_AMT` decimal(18,2) DEFAULT NULL COMMENT '账户总余额=冻结金额+可用余额',
  `CREDIT_AMT` decimal(18,2) DEFAULT NULL COMMENT '可透支额度',
  `ORG_ID` bigint(20) DEFAULT NULL COMMENT '供电单位编号:供电管理单位的代码',
  PRIMARY KEY (`ACCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='\n账户\n1）存储用户的账户信息，一个用户可以存在多种类型的账户\n2）账户中存在可用余额和冻结余额\n3）账户之间可以存在扣费顺序信息\n';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-22 17:07:50
CALL PR_MOD_IDX_CONS ('VD_A_ACCOUNT','ADD','I','IDX_ACCOUNT_AC_CTID','ACCT_CATEGOTY, CATEGOTY_ID','','', '', '');