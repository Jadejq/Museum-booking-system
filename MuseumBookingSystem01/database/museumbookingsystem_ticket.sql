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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-05  8:24:45
