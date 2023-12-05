-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: museumbookingsystem
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bookticket`
--

DROP TABLE IF EXISTS `bookticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookticket` (
  `Ono` char(20) DEFAULT NULL,
  `Vno` char(20) DEFAULT NULL,
  `Tno` char(5) DEFAULT NULL,
  `state` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookticket`
--

LOCK TABLES `bookticket` WRITE;
/*!40000 ALTER TABLE `bookticket` DISABLE KEYS */;
INSERT INTO `bookticket` VALUES ('00000000000000000001','00000000000000000001','00009',NULL),('00000000000000000002','00000000000000000001','00001',NULL),('4','7','00007',NULL),('6','9','00007',NULL),('6','9','00015','已退'),('6','10','00001','已退'),('6','10','00009',NULL),('111','109','00007','已退'),('111','109','00015','已退'),('111','110','00001','已退'),('111','110','00009','已退'),('112','109','00007',''),('112','109','00015','已退'),('112','110','00001',''),('112','110','00009',''),('113','109','00007',''),('113','109','00015',''),('113','110','00001',''),('113','110','00009',''),('114','111','00007',''),('114','111','00015',''),('114','112','00001','已退'),('114','112','00009','已退');
/*!40000 ALTER TABLE `bookticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `OrderForm_after_insert` AFTER INSERT ON `bookticket` FOR EACH ROW begin           
if (select Ototalprice from OrderForm where Ono=new.Ono) is not null
then
update OrderForm  
set Ototalprice=Ototalprice+(select Tprice from Ticket where Tno=new.Tno)
where Ono=new.Ono;
else
signal sqlstate '45000' set message_text ='错误' ;
end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `LeftTickets_after_insert` AFTER INSERT ON `bookticket` FOR EACH ROW begin
if (select Lleft 
	from LeftTickets 
    where Hno=(select Hno from Ticket where Tno= new.Tno) and 
		  Ldate=(select Ovisitdate from OrderForm where Ono=new.Ono) and  
          Ltime = (select Ovisittime from OrderForm where Ono = new.Ono)
	)>0
then
update LeftTickets  
set Lsale=Lsale+1,Lleft=Lleft-1
where Hno=(select Hno from Ticket where Tno= new.Tno) and 
	  Ldate=(select Ovisitdate from OrderForm where Ono=new.Ono) and 
      Ltime = (select Ovisittime from OrderForm where Ono = new.Ono);
else
signal sqlstate '45000' set message_text ='错误！余票不足' ;
end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `OrderForm_after_update` AFTER UPDATE ON `bookticket` FOR EACH ROW begin
    -- 检查 state 列是否被修改为 '已退'
    if old.state <> new.state and new.state = '已退' then
        if (select Ototalprice from OrderForm where Ono = old.Ono) is not null then
            update OrderForm  
            set actualpayment = actualpayment - (select Tprice from Ticket where Tno = old.Tno)
            where Ono = old.Ono;
        else
            signal sqlstate '45000' set message_text = '错误';
        end if;
    end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `LeftTickets_after_delete` AFTER UPDATE ON `bookticket` FOR EACH ROW begin
if old.state <> new.state and new.state = '已退' then
if (select Lleft 
	from LeftTickets 
    where Hno=(select Hno from Ticket where Tno= old.Tno) and 
		  Ldate=(select Ovisitdate from OrderForm where Ono=old.Ono) and  
          Ltime = (select Ovisittime from OrderForm where Ono = old.Ono)
	)is not null
then
update LeftTickets  
set Lsale=Lsale-1,Lleft=Lleft+1
where Hno=(select Hno from Ticket where Tno= old.Tno) and 
	  Ldate=(select Ovisitdate from OrderForm where Ono=old.Ono) and 
      Ltime = (select Ovisittime from OrderForm where Ono = old.Ono);
else
signal sqlstate '45000' set message_text ='错误！' ;
end if;
end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `Cno` char(15) NOT NULL,
  `Ctel` char(11) NOT NULL,
  PRIMARY KEY (`Cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('10000000001','18810001100'),('10000000002','18812201100'),('10000000003','18813301100'),('10000000004','18910001100'),('10000000005','18810001101'),('10000000006','18810001109'),('10000000007','18810001107'),('100123','1');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `house`
--

DROP TABLE IF EXISTS `house`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `house` (
  `Hno` char(12) NOT NULL,
  `Hname` varchar(30) NOT NULL,
  PRIMARY KEY (`Hno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `house`
--

LOCK TABLES `house` WRITE;
/*!40000 ALTER TABLE `house` DISABLE KEYS */;
INSERT INTO `house` VALUES ('00001','大门票'),('00002','珍宝馆'),('00003','钟表馆'),('00004','午门“祥开万象”展'),('00005','文华殿“譬若香山”展');
/*!40000 ALTER TABLE `house` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lefttickets`
--

DROP TABLE IF EXISTS `lefttickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lefttickets` (
  `Hno` char(12) NOT NULL,
  `Ldate` date NOT NULL,
  `Ltime` enum('上午','下午') NOT NULL,
  `Lsale` smallint NOT NULL DEFAULT '0',
  `Lleft` smallint NOT NULL DEFAULT '0',
  PRIMARY KEY (`Hno`,`Ldate`,`Ltime`),
  KEY `Ldatetime_index` (`Ldate`,`Ltime`),
  CONSTRAINT `lefttickets_chk_1` CHECK ((`Lsale` >= 0)),
  CONSTRAINT `lefttickets_chk_2` CHECK ((`Lleft` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lefttickets`
--

LOCK TABLES `lefttickets` WRITE;
/*!40000 ALTER TABLE `lefttickets` DISABLE KEYS */;
INSERT INTO `lefttickets` VALUES ('00001','2023-05-27','上午',0,10000),('00001','2023-05-27','下午',1,9999),('00001','2023-10-21','上午',0,500),('00001','2023-10-22','上午',0,5000),('00001','2023-11-03','上午',0,8000),('00001','2023-11-03','下午',0,8000),('00001','2023-11-05','上午',0,9000),('00001','2023-11-07','上午',0,9000),('00001','2023-11-10','下午',0,8000),('00001','2023-11-17','上午',0,10000),('00001','2023-11-17','下午',0,10000),('00001','2023-11-18','上午',8,9992),('00001','2023-11-18','下午',0,10000),('00001','2023-11-19','上午',0,10000),('00002','2023-05-27','上午',1,999),('00002','2023-05-27','下午',0,1000),('00002','2023-11-06','下午',0,8000),('00002','2023-11-10','下午',0,8000),('00002','2023-11-17','上午',0,1000),('00002','2023-11-17','下午',0,1000),('00002','2023-11-18','上午',6,994),('00002','2023-11-18','下午',0,1000),('00003','2023-05-27','上午',0,1000),('00003','2023-05-27','下午',0,1000),('00003','2023-11-17','上午',0,1000),('00003','2023-11-17','下午',0,1000),('00003','2023-11-18','上午',0,1000),('00003','2023-11-18','下午',0,1000),('00004','2023-05-27','上午',0,500),('00004','2023-05-27','下午',0,500),('00004','2023-11-11','上午',0,200),('00004','2023-11-17','上午',0,500),('00004','2023-11-17','下午',0,500),('00004','2023-11-18','上午',0,500),('00004','2023-11-18','下午',0,500),('00005','2023-05-27','上午',0,500),('00005','2023-05-27','下午',0,500),('00005','2023-11-17','上午',0,500),('00005','2023-11-17','下午',0,500),('00005','2023-11-18','上午',0,500),('00005','2023-11-18','下午',0,500);
/*!40000 ALTER TABLE `lefttickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manager` (
  `Mno` char(5) NOT NULL,
  `Mpsw` varchar(50) NOT NULL,
  PRIMARY KEY (`Mno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES ('00001','000001'),('00002','000002');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderform`
--

DROP TABLE IF EXISTS `orderform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderform` (
  `Ono` char(20) NOT NULL,
  `Otime` datetime NOT NULL,
  `Ovisitdate` date NOT NULL,
  `Ovisittime` enum('上午','下午') NOT NULL,
  `Ototalprice` smallint DEFAULT NULL,
  `Ostate` enum('待支付','未使用','退款/售后','已使用','已过期') NOT NULL,
  `Cno` char(15) NOT NULL,
  `actualpayment` smallint DEFAULT NULL,
  PRIMARY KEY (`Ono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderform`
--

LOCK TABLES `orderform` WRITE;
/*!40000 ALTER TABLE `orderform` DISABLE KEYS */;
INSERT INTO `orderform` VALUES ('00000000000000000001','2023-05-26 00:00:00','2023-05-27','上午',10,'已过期','10000000001',NULL),('00000000000000000002','2023-05-26 00:00:00','2023-05-27','下午',40,'已过期','10000000002',NULL),('00000000000000000003','2023-05-26 00:00:00','2023-05-27','下午',0,'已过期','10000000003',NULL),('109','2023-11-16 15:39:17','2023-11-18','上午',0,'待支付','10000000003',0),('110','2023-11-16 15:40:34','2023-11-18','上午',0,'待支付','10000000003',0),('111','2023-11-16 15:41:25','2023-11-18','上午',0,'退款/售后','10000000003',20),('112','2023-11-16 16:07:30','2023-11-18','上午',75,'未使用','10000000003',70),('113','2023-11-18 10:32:53','2023-11-18','上午',75,'待支付','100123',0),('114','2023-11-18 10:34:02','2023-11-18','上午',75,'待支付','100123',-50),('4','2023-11-15 14:36:00','2023-11-18','上午',20,'未使用','10000000001',20),('5','2023-11-15 16:45:36','2023-01-10','上午',0,'已过期','10000000003',NULL),('6','2023-11-15 16:46:13','2023-11-18','上午',75,'退款/售后','10000000003',75),('7','2023-11-16 15:26:21','2023-11-18','上午',0,'待支付','10000000003',0),('8','2023-11-16 15:28:14','2023-11-18','上午',0,'待支付','10000000003',0),('9','2023-11-16 15:38:02','2023-11-18','上午',0,'未使用','10000000003',0);
/*!40000 ALTER TABLE `orderform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regularvisitor`
--

DROP TABLE IF EXISTS `regularvisitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `regularvisitor` (
  `Vno` char(20) NOT NULL,
  `Vname` varchar(30) NOT NULL,
  `Vidtype` enum('身份证','港澳居民来往内地通行证','护照','台湾居民来往大陆通行证','港澳台居民居住证','外国人永久居住身份证') NOT NULL,
  `Vidnum` varchar(20) NOT NULL,
  `Cno` char(15) NOT NULL,
  PRIMARY KEY (`Vno`),
  KEY `Vidnum_index` (`Vidnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regularvisitor`
--

LOCK TABLES `regularvisitor` WRITE;
/*!40000 ALTER TABLE `regularvisitor` DISABLE KEYS */;
INSERT INTO `regularvisitor` VALUES ('00000000000000000002','刘冰','身份证','110101200301010101','10000000002'),('00000000000000000003','谢婷','身份证','310101200301010101','10000000003'),('00000000000000000004','张一','身份证','210101200301010103','10000000001'),('00000000000000000005','张二','身份证','110101200301010104','10000000001'),('00000000000000000006','李四','身份证','310101200301010105','10000000003'),('1','王七','台湾居民来往大陆通行证','111111199905060606','10000000001'),('10','jade','外国人永久居住身份证','4646','100123'),('2','张三','身份证','210411200102020123','10000000001'),('3','张三','身份证','210411200102020123','10000000001'),('4','小朱','身份证','210101200101010101','100123'),('5','abc修改','港澳居民来往内地通行证','210116101010101010','100123');
/*!40000 ALTER TABLE `regularvisitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `systemmanager`
--

DROP TABLE IF EXISTS `systemmanager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `systemmanager` (
  `Sno` char(5) NOT NULL,
  `Spsw` varchar(50) NOT NULL,
  PRIMARY KEY (`Sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemmanager`
--

LOCK TABLES `systemmanager` WRITE;
/*!40000 ALTER TABLE `systemmanager` DISABLE KEYS */;
INSERT INTO `systemmanager` VALUES ('00003','000003'),('00004','000004');
/*!40000 ALTER TABLE `systemmanager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `Tno` char(5) NOT NULL,
  `Hno` char(5) DEFAULT NULL,
  `Ttype` enum('标准票','老年人票','未成年人免费票','学生票') NOT NULL,
  `Tseason` enum('淡季','旺季') DEFAULT NULL,
  `Tprice` smallint NOT NULL,
  PRIMARY KEY (`Tno`),
  UNIQUE KEY `Ttype_index` (`Hno`,`Ttype`,`Tseason`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES ('00001','00001','标准票','淡季',40),('00002','00001','标准票','旺季',60),('00003','00001','老年人票','淡季',20),('00004','00001','老年人票','旺季',30),('00005','00001','未成年人免费票','淡季',0),('00006','00001','未成年人免费票','旺季',0),('00007','00001','学生票','淡季',20),('00008','00001','学生票','旺季',20),('00009','00002','标准票','淡季',10),('00010','00002','标准票','旺季',10),('00011','00002','老年人票','淡季',5),('00012','00002','老年人票','旺季',5),('00013','00002','未成年人免费票','淡季',0),('00014','00002','未成年人免费票','旺季',0),('00015','00002','学生票','淡季',5),('00016','00002','学生票','旺季',5),('00017','00003','标准票','淡季',10),('00018','00003','标准票','旺季',10),('00019','00003','老年人票','淡季',5),('00020','00003','老年人票','旺季',5),('00021','00003','未成年人免费票','淡季',0),('00022','00003','未成年人免费票','旺季',0),('00023','00003','学生票','淡季',5),('00024','00003','学生票','旺季',5),('00025','00004','标准票','淡季',0),('00026','00004','标准票','旺季',0),('00027','00004','老年人票','淡季',0),('00028','00004','老年人票','旺季',0),('00029','00004','未成年人免费票','淡季',0),('00030','00004','未成年人免费票','旺季',0),('00031','00004','学生票','淡季',0),('00032','00004','学生票','旺季',0),('00033','00005','标准票','淡季',0),('00034','00005','标准票','旺季',0),('00035','00005','老年人票','淡季',0),('00036','00005','老年人票','旺季',0),('00037','00005','未成年人免费票','淡季',0),('00038','00005','未成年人免费票','旺季',0),('00039','00005','学生票','淡季',0),('00040','00005','学生票','旺季',0);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitor`
--

DROP TABLE IF EXISTS `visitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitor` (
  `Vno` char(20) NOT NULL,
  `Vname` varchar(30) NOT NULL,
  `Vidtype` enum('身份证','港澳居民来往内地通行证','护照','台湾居民来往大陆通行证','港澳台居民居住证','外国人永久居住身份证') NOT NULL,
  `Vidnum` varchar(20) NOT NULL,
  PRIMARY KEY (`Vno`),
  KEY `Vidnum_index` (`Vidnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitor`
--

LOCK TABLES `visitor` WRITE;
/*!40000 ALTER TABLE `visitor` DISABLE KEYS */;
INSERT INTO `visitor` VALUES ('00000000000000000001','李娜','身份证','210101200301010101'),('00000000000000000002','刘冰','身份证','110101200301010101'),('00000000000000000003','谢婷','身份证','310101200301010101'),('10','Jane','身份证','456'),('107','朱朱','身份证','123456789123456788'),('108','朱朱','身份证','123456789123456788'),('109','ab','身份证','123456'),('110','cd','身份证','456789'),('111','张三','身份证','1234567'),('112','李四','身份证','3456789'),('7','liu','身份证','310101200301010108'),('8','朱朱','身份证','123456789123456789'),('9','John','身份证','123');
/*!40000 ALTER TABLE `visitor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-18 17:07:57
