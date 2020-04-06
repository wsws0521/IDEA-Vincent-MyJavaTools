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
-- Table structure for table `vd_p_token`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `vd_p_token` (
  `LESSEE_ID` bigint(20) DEFAULT NULL COMMENT '本实体唯一标识符',
  `TOKEN_ID` decimal(16,0) NOT NULL COMMENT 'TOKEN标识',
  `KEY_CHG_ID` decimal(16,0) DEFAULT NULL COMMENT '本实体记录唯一标识，产生规则为流水号,',
  `LOGOFFCHANGE_ID` decimal(16,0) DEFAULT NULL,
  `BUSINESS_TYPE` varchar(8) DEFAULT NULL COMMENT '对象类型:01售电02低压开户03高压开户',
  `APP_ID` decimal(16,0) DEFAULT NULL COMMENT '对象类型确定申请的标识，与业务类型合并使用，如：售电时使用收费明细标识',
  `ACCOUNT_NO` varchar(50) DEFAULT NULL COMMENT '用户编号',
  `ACCOUNT_ID` varchar(32) DEFAULT NULL COMMENT '客户标识',
  `METER_ID` varchar(32) DEFAULT NULL COMMENT '表计标识',
  `METER_NO` varchar(50) DEFAULT NULL COMMENT '表计编号',
  `TOKEN_TYPE` varchar(8) DEFAULT NULL COMMENT '参考vending类型',
  `TOKEN` varchar(256) DEFAULT NULL COMMENT 'TOKEN数据，多条逗号分隔',
  `RTN_TOKEN` varchar(256) DEFAULT NULL COMMENT '注销返回码',
  `SORT` decimal(5,0) DEFAULT NULL COMMENT 'token顺序，默认1',
  `EXECUTE_STATUS` varchar(8) DEFAULT NULL COMMENT 'token执行状态：未知、执行成功、执行失败、超时、撤销',
  `RECHARGE_AMOUNT` decimal(18,2) DEFAULT NULL COMMENT '一次侧充值量',
  `TOKEN_AMOUNT` decimal(18,2) DEFAULT NULL COMMENT '二次侧充值量',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT 'TOKEN的生成时间',
  `ORG_ID` bigint(20) DEFAULT NULL COMMENT '供电单位编号:供电管理单位的代码',
  `TOKEN_DATEIL_ID` decimal(16,0) DEFAULT NULL,
  `STS_VERSION_ID` decimal(16,0) DEFAULT NULL COMMENT '密钥版本标识',
  `TI` decimal(5,0) DEFAULT NULL COMMENT 'TI值',
  `SEQ` decimal(5,0) DEFAULT NULL COMMENT '孟加拉软加密所需的加密因子，1~255，超过255后重新从1开始',
  `KEYNO` decimal(5,0) DEFAULT NULL COMMENT '孟加拉软加密所需的加密因子，当SEQ超过255后累加1',
  `TID` decimal(15,0) DEFAULT NULL COMMENT '适配孟加拉KFW现场STS协议，用于零充值token功能生成，使用原充值token的TID生成token，撤销原充值token',
  `CARD_WF` varchar(8) DEFAULT NULL COMMENT '写卡标识 00：成功',
  `TV`		DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`TOKEN_ID`, `TV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='1)订单相关token信息记录'
PARTITION BY RANGE (TO_DAYS(TV))(PARTITION PMAX VALUES LESS THAN (MAXVALUE));
CALL PR_MOD_COL('vd_p_token','add','VER_ID','decimal(16,0)','NULL','NULL','');
CALL PR_MOD_COL('VD_P_TOKEN','ADD','BARL','decimal(5,0)','','','');

/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-22 17:08:12
CALL PR_MOD_IDX_CONS ('vd_p_token','ADD','I','VD_TOKEN_APPID','APP_ID','','', '', '');