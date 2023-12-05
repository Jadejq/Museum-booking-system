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
INSERT INTO `visitor` VALUES ('00000000000000000001','李娜','身份证','210101200301010101'),('00000000000000000002','刘冰','身份证','110101200301010101'),('00000000000000000003','谢婷','身份证','310101200301010101'),('10','Jane','身份证','456'),('107','朱朱','身份证','123456789123456788'),('108','朱朱','身份证','123456789123456788'),('109','ab','身份证','123456'),('110','cd','身份证','456789'),('111','张三','身份证','1234567'),('112','李四','身份证','3456789'),('113','张三','身份证','12345678'),('114','李四','身份证','34567890'),('115','jade','外国人永久居住身份证','4646'),('116','小朱','身份证','210101200101010101'),('117','李娜','身份证','101010200101010401'),('118','abc修改','港澳居民来往内地通行证','210116101010101010'),('119','啊啊积分','身份证','34154546688866544'),('120','嘻嘻','身份证','101010199901010202'),('121','余弦','身份证','101010199901020202'),('122','时钟','身份证','101010199901020203'),('123','观众3','身份证','120120198803020603'),('124','观众1','身份证','120120198803020601'),('125','观众2','身份证','120120198803020602'),('126','观众123','身份证','1345467878979'),('127','观众124','身份证','1345467878978'),('128','testupdate','护照','1588978786'),('129','test2','外国人永久居住身份证','15465454'),('7','liu','身份证','310101200301010108'),('8','朱朱','身份证','123456789123456789'),('9','John','身份证','123');
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

-- Dump completed on 2023-12-05  8:24:44
