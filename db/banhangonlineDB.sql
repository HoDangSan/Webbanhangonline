CREATE DATABASE  IF NOT EXISTS `banhangonlinedb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `banhangonlinedb`;
-- MySQL dump 10.16  Distrib 10.1.36-MariaDB, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: banhangonlinedb
-- ------------------------------------------------------
-- Server version	10.1.36-MariaDB

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
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `idbill` int(11) NOT NULL AUTO_INCREMENT,
  `billNumber` int(11) NOT NULL,
  `dateSale` date NOT NULL,
  `idemployees` int(11) NOT NULL,
  `idcustomer` int(11) NOT NULL,
  `totalMoney` int(11) NOT NULL,
  `vat` int(11) NOT NULL,
  `intoMoney` int(11) NOT NULL,
  `idbilldetails` int(11) NOT NULL,
  PRIMARY KEY (`idbill`),
  KEY `FK_bill_customer` (`idcustomer`),
  KEY `FK_bill_employees` (`idemployees`),
  CONSTRAINT `FK_bill_billdetail` FOREIGN KEY (`idbill`) REFERENCES `billdetails` (`idbilldetails`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_bill_customer` FOREIGN KEY (`idcustomer`) REFERENCES `customer` (`idcustomer`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_bill_employees` FOREIGN KEY (`idemployees`) REFERENCES `employees` (`idemployees`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billdetails`
--

DROP TABLE IF EXISTS `billdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billdetails` (
  `idbilldetails` int(11) NOT NULL,
  `idproduct` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `peice` int(11) NOT NULL,
  PRIMARY KEY (`idbilldetails`),
  KEY `FK_billdetails_product` (`idproduct`),
  CONSTRAINT `FK_billdetails_product` FOREIGN KEY (`idproduct`) REFERENCES `product` (`idproduct`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billdetails`
--

LOCK TABLES `billdetails` WRITE;
/*!40000 ALTER TABLE `billdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `billdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `idcustomer` int(11) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `iduser` int(11) NOT NULL,
  PRIMARY KEY (`idcustomer`),
  KEY `FK_customer_user` (`iduser`),
  CONSTRAINT `FK_customer_user` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Nguy?n Lê Qu?nh Anh','N?','0906895049',1),(2,'Nguy?n V?n H?i ??c','Nam','0396758976',2),(3,'Lê Th? Thùy Trang','N?','0905787998',3);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `idemployees` int(11) NOT NULL AUTO_INCREMENT,
  `employeesName` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `position` varchar(45) NOT NULL,
  `salary` int(11) NOT NULL,
  `revenueTargets` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  PRIMARY KEY (`idemployees`),
  KEY `FK_employees_user` (`iduser`),
  CONSTRAINT `FK_employees_user` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producer`
--

DROP TABLE IF EXISTS `producer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producer` (
  `idproducer` int(11) NOT NULL,
  `producerName` varchar(45) NOT NULL,
  PRIMARY KEY (`idproducer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producer`
--

LOCK TABLES `producer` WRITE;
/*!40000 ALTER TABLE `producer` DISABLE KEYS */;
/*!40000 ALTER TABLE `producer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `idproduct` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `importPrice` int(11) NOT NULL,
  `importDate` date NOT NULL,
  `idproductType` int(11) NOT NULL,
  `idproductdesign` int(11) NOT NULL,
  `idproducer` int(11) NOT NULL,
  PRIMARY KEY (`idproduct`),
  KEY `FK_product_type` (`idproductType`),
  KEY `FK_product_design` (`idproductdesign`),
  KEY `FK_product_producer` (`idproducer`),
  CONSTRAINT `FK_product_design` FOREIGN KEY (`idproductdesign`) REFERENCES `productdesign` (`idproductdesign`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_product_producer` FOREIGN KEY (`idproducer`) REFERENCES `producer` (`idproducer`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_product_type` FOREIGN KEY (`idproductType`) REFERENCES `producttype` (`idproductType`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productdesign`
--

DROP TABLE IF EXISTS `productdesign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productdesign` (
  `idproductdesign` int(11) NOT NULL,
  `productdesignName` varchar(45) NOT NULL,
  PRIMARY KEY (`idproductdesign`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productdesign`
--

LOCK TABLES `productdesign` WRITE;
/*!40000 ALTER TABLE `productdesign` DISABLE KEYS */;
/*!40000 ALTER TABLE `productdesign` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producttype`
--

DROP TABLE IF EXISTS `producttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producttype` (
  `idproductType` int(11) NOT NULL,
  `productTypeName` varchar(45) NOT NULL,
  PRIMARY KEY (`idproductType`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producttype`
--

LOCK TABLES `producttype` WRITE;
/*!40000 ALTER TABLE `producttype` DISABLE KEYS */;
/*!40000 ALTER TABLE `producttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'nguyenlequynhanh','123456','1'),(2,'nguyenvanhaiduc','123456','2'),(3,'lethithuytrang','123456','2');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'banhangonlinedb'
--

--
-- Dumping routines for database 'banhangonlinedb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-20 17:23:55
