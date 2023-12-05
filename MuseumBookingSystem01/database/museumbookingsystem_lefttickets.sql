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
INSERT INTO `lefttickets` VALUES ('00001','2023-05-27','上午',0,10000),('00001','2023-05-27','下午',1,9999),('00001','2023-10-21','上午',0,500),('00001','2023-10-22','上午',0,5000),('00001','2023-11-03','上午',0,8000),('00001','2023-11-03','下午',0,8000),('00001','2023-11-05','上午',0,9000),('00001','2023-11-07','上午',0,9000),('00001','2023-11-10','下午',0,8000),('00001','2023-11-17','上午',0,10000),('00001','2023-11-17','下午',0,10000),('00001','2023-11-18','上午',7,9993),('00001','2023-11-18','下午',0,10000),('00001','2023-11-19','上午',0,10000),('00001','2023-11-25','上午',6,9994),('00001','2023-11-25','下午',1,9999),('00001','2023-11-26','上午',17,9983),('00001','2023-11-26','下午',3,9997),('00001','2023-11-28','上午',0,10000),('00001','2023-11-29','上午',0,1000),('00002','2023-05-27','上午',1,999),('00002','2023-05-27','下午',0,1000),('00002','2023-11-06','下午',0,8000),('00002','2023-11-10','下午',0,8000),('00002','2023-11-17','上午',0,1000),('00002','2023-11-17','下午',0,1000),('00002','2023-11-18','上午',5,995),('00002','2023-11-18','下午',0,1000),('00002','2023-11-25','上午',5,995),('00002','2023-11-26','上午',17,9983),('00002','2023-11-26','下午',3,997),('00002','2023-11-27','下午',0,10000),('00002','2023-11-28','下午',0,10000),('00003','2023-05-27','上午',0,1000),('00003','2023-05-27','下午',0,1000),('00003','2023-11-17','上午',0,1000),('00003','2023-11-17','下午',0,1000),('00003','2023-11-18','上午',0,1000),('00003','2023-11-18','下午',0,1000),('00003','2023-11-25','上午',0,1000),('00003','2023-11-25','下午',0,1000),('00003','2023-11-28','上午',0,1000),('00004','2023-05-27','上午',0,500),('00004','2023-05-27','下午',0,500),('00004','2023-11-11','上午',0,200),('00004','2023-11-17','上午',0,500),('00004','2023-11-17','下午',0,500),('00004','2023-11-18','上午',0,500),('00004','2023-11-18','下午',0,500),('00004','2023-11-25','下午',0,1000),('00004','2023-11-26','上午',4,996),('00005','2023-05-27','上午',0,500),('00005','2023-05-27','下午',0,500),('00005','2023-11-17','上午',0,500),('00005','2023-11-17','下午',0,500),('00005','2023-11-18','上午',0,500),('00005','2023-11-18','下午',0,500),('00005','2023-11-26','上午',4,996),('00005','2023-11-26','下午',3,997);
/*!40000 ALTER TABLE `lefttickets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-05  8:24:45
