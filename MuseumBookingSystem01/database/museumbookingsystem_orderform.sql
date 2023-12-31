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
INSERT INTO `orderform` VALUES ('00000000000000000001','2023-05-26 00:00:00','2023-05-27','上午',10,'已过期','10000000001',NULL),('00000000000000000002','2023-05-26 00:00:00','2023-05-27','下午',40,'已过期','10000000002',NULL),('00000000000000000003','2023-05-26 00:00:00','2023-05-27','下午',0,'已过期','10000000003',NULL),('109','2023-11-16 15:39:17','2023-11-18','上午',0,'待支付','10000000003',0),('110','2023-11-16 15:40:34','2023-11-18','上午',0,'待支付','10000000003',0),('111','2023-11-16 15:41:25','2023-11-18','上午',0,'退款/售后','10000000003',20),('112','2023-11-16 16:07:30','2023-11-18','上午',75,'未使用','10000000003',70),('113','2023-11-18 10:32:53','2023-11-18','上午',75,'未使用','100123',25),('114','2023-11-18 10:34:02','2023-11-18','上午',75,'退款/售后','100123',-50),('115','2023-11-19 21:21:13','2023-11-25','上午',75,'未使用','100123',50),('116','2023-11-19 23:37:15','2023-11-26','上午',75,'未使用','100123',75),('117','2023-11-19 23:55:06','2023-11-27','上午',0,'未使用','100123',0),('118','2023-11-19 23:55:58','2023-11-27','上午',0,'未使用','100123',0),('119','2023-11-19 23:56:04','2023-11-26','上午',75,'未使用','100123',75),('120','2023-11-21 19:28:02','2023-11-26','上午',75,'未使用','100123',75),('121','2023-11-21 23:17:58','2023-11-26','上午',50,'待支付','100123',0),('122','2023-11-21 23:18:16','2023-11-26','上午',50,'待支付','100123',0),('123','2023-11-22 17:55:15','2023-11-25','下午',20,'待支付','10000000004',0),('124','2023-11-22 18:04:31','2023-11-25','上午',95,'待支付','100123',0),('125','2023-11-22 19:56:12','2023-11-25','上午',50,'待支付','10000000005',0),('126','2023-11-22 19:57:54','2023-11-26','上午',75,'待支付','10000000005',0),('127','2023-11-22 20:13:41','2023-11-26','下午',100,'待支付','10000000006',0),('128','2023-11-22 20:17:45','2023-11-26','上午',50,'待支付','10000000007',0),('129','2023-11-23 00:48:33','2023-11-26','上午',25,'未使用','10000000008',25),('4','2023-11-15 14:36:00','2023-11-18','上午',20,'未使用','10000000001',20),('5','2023-11-15 16:45:36','2023-01-10','上午',0,'已过期','10000000003',NULL),('6','2023-11-15 16:46:13','2023-11-18','上午',75,'退款/售后','10000000003',75),('7','2023-11-16 15:26:21','2023-11-18','上午',0,'待支付','10000000003',0),('8','2023-11-16 15:28:14','2023-11-18','上午',0,'待支付','10000000003',0),('9','2023-11-16 15:38:02','2023-11-18','上午',0,'未使用','10000000003',0);
/*!40000 ALTER TABLE `orderform` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-05  8:24:44
