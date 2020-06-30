-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: financial_analitics
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currency` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES (2,'KZT'),(1,'RUB'),(3,'USD');
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency_exchange_rate`
--

DROP TABLE IF EXISTS `currency_exchange_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currency_exchange_rate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `currency_id` int NOT NULL,
  `exchange_rate` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `date_UNIQUE` (`date`,`currency_id`),
  KEY `currency_exchange_rate_currency_idx` (`currency_id`),
  CONSTRAINT `currency_exchange_rate_currency` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency_exchange_rate`
--

LOCK TABLES `currency_exchange_rate` WRITE;
/*!40000 ALTER TABLE `currency_exchange_rate` DISABLE KEYS */;
INSERT INTO `currency_exchange_rate` VALUES (1,'2018-01-01',1,1),(2,'2018-01-01',2,5.7713),(3,'2018-01-01',3,326.0675),(4,'2018-02-01',1,1),(5,'2018-02-01',2,5.6686),(6,'2018-02-01',3,322.0145),(7,'2019-01-01',3,374.8711),(8,'2019-01-01',1,1),(9,'2019-01-01',2,5.6361),(10,'2019-02-01',1,1),(11,'2019-02-01',3,377.8444),(12,'2019-02-01',2,5.7414);
/*!40000 ALTER TABLE `currency_exchange_rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_info`
--

DROP TABLE IF EXISTS `expense_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `organization_unit_id` int NOT NULL,
  `expense_type_id` int NOT NULL,
  `currency_id` int NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `date_UNIQUE` (`date`,`organization_unit_id`,`expense_type_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `expense_info_currency_idx` (`currency_id`),
  KEY `expense_info_expense_type_idx` (`expense_type_id`),
  KEY `expense_info_organization_unit_idx` (`organization_unit_id`),
  CONSTRAINT `expense_info_currency` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`id`),
  CONSTRAINT `expense_info_expense_type` FOREIGN KEY (`expense_type_id`) REFERENCES `expense_type` (`id`),
  CONSTRAINT `expense_info_organization_unit` FOREIGN KEY (`organization_unit_id`) REFERENCES `organization_unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=290 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_info`
--

LOCK TABLES `expense_info` WRITE;
/*!40000 ALTER TABLE `expense_info` DISABLE KEYS */;
INSERT INTO `expense_info` VALUES (1,'2018-01-01',1,1,1,3916987),(2,'2018-01-01',1,2,1,1552752),(3,'2018-01-01',1,3,1,357785),(4,'2018-01-01',1,4,1,115055),(5,'2018-01-01',1,5,1,0),(6,'2018-01-01',1,6,1,406993),(7,'2018-01-01',1,7,1,156431),(8,'2018-01-01',1,8,1,66337),(9,'2018-01-01',1,9,1,75023),(10,'2018-01-01',1,10,1,1818),(11,'2018-01-01',2,1,1,1304802),(12,'2018-01-01',2,2,1,23253),(13,'2018-01-01',2,3,1,1228493),(14,'2018-01-01',2,4,1,-95330),(15,'2018-01-01',2,5,1,106874),(16,'2018-01-01',2,6,1,188981),(17,'2018-01-01',2,7,1,13400),(18,'2018-01-01',2,8,1,0),(19,'2018-01-01',2,9,1,-5354),(20,'2018-01-01',2,10,1,3405),(21,'2018-01-01',3,1,1,286198),(22,'2018-01-01',3,2,1,0),(23,'2018-01-01',3,3,1,1001854),(24,'2018-01-01',3,4,1,0),(25,'2018-01-01',3,5,1,447867),(26,'2018-01-01',3,6,1,40231),(27,'2018-01-01',3,7,1,13340),(28,'2018-01-01',3,8,1,16102),(29,'2018-01-01',3,9,1,0),(30,'2018-01-01',3,10,1,96),(31,'2018-01-01',4,1,1,345618),(32,'2018-01-01',4,2,1,8490),(33,'2018-01-01',4,3,1,51635),(34,'2018-01-01',4,4,1,0),(35,'2018-01-01',4,5,1,206641),(36,'2018-01-01',4,6,1,16515),(37,'2018-01-01',4,7,1,27312),(38,'2018-01-01',4,8,1,0),(39,'2018-01-01',4,9,1,0),(40,'2018-01-01',4,10,1,0),(41,'2018-01-01',5,1,1,114716),(42,'2018-01-01',5,2,1,1213),(43,'2018-01-01',5,3,1,147280),(44,'2018-01-01',5,4,1,0),(45,'2018-01-01',5,5,1,77140),(46,'2018-01-01',5,6,1,12373),(47,'2018-01-01',5,7,1,12231),(48,'2018-01-01',5,8,1,0),(49,'2018-01-01',5,9,1,0),(50,'2018-01-01',5,10,1,0),(51,'2018-01-01',6,1,1,212554),(52,'2018-01-01',6,2,1,2408),(53,'2018-01-01',6,3,1,369449),(54,'2018-01-01',6,4,1,0),(55,'2018-01-01',6,5,1,0),(56,'2018-01-01',6,6,1,11368),(57,'2018-01-01',6,7,1,0),(58,'2018-01-01',6,8,1,472),(59,'2018-01-01',6,9,1,5198),(60,'2018-01-01',6,10,1,0),(61,'2018-01-01',7,1,1,539111),(62,'2018-01-01',7,2,1,13435),(63,'2018-01-01',7,3,1,682607),(64,'2018-01-01',7,4,1,0),(65,'2018-01-01',7,5,1,72869),(66,'2018-01-01',7,6,1,9185),(67,'2018-01-01',7,7,1,13789),(68,'2018-01-01',7,8,1,11263),(69,'2018-01-01',7,9,1,0),(70,'2018-01-01',7,10,1,0),(71,'2018-02-01',1,1,1,4781926),(72,'2018-02-01',1,2,1,920194),(73,'2018-02-01',1,3,1,1106634),(74,'2018-02-01',1,4,1,156786),(75,'2018-02-01',1,5,1,0),(76,'2018-02-01',1,6,1,408840),(77,'2018-02-01',1,7,1,128887),(78,'2018-02-01',1,8,1,179919),(79,'2018-02-01',1,9,1,728030),(80,'2018-02-01',1,10,1,607),(81,'2018-02-01',2,1,1,1539045),(82,'2018-02-01',2,2,1,13283),(83,'2018-02-01',2,3,1,-1392619),(84,'2018-02-01',2,4,1,-63964),(85,'2018-02-01',2,5,1,1043033),(86,'2018-02-01',2,6,1,31648),(87,'2018-02-01',2,7,1,14421),(88,'2018-02-01',2,8,1,0),(89,'2018-02-01',2,9,1,1411),(90,'2018-02-01',2,10,1,6252),(91,'2018-02-01',3,1,1,369723),(92,'2018-02-01',3,2,1,0),(93,'2018-02-01',3,3,1,215044),(94,'2018-02-01',3,4,1,-36058),(95,'2018-02-01',3,5,1,457230),(96,'2018-02-01',3,6,1,873),(97,'2018-02-01',3,7,1,14441),(98,'2018-02-01',3,8,1,1764),(99,'2018-02-01',3,9,1,52835),(100,'2018-02-01',3,10,1,38),(101,'2018-02-01',4,1,1,287132),(102,'2018-02-01',4,2,1,4103),(103,'2018-02-01',4,3,1,-70564),(104,'2018-02-01',4,4,1,-16603),(105,'2018-02-01',4,5,1,255795),(106,'2018-02-01',4,6,1,5292),(107,'2018-02-01',4,7,1,26870),(108,'2018-02-01',4,8,1,0),(109,'2018-02-01',4,9,1,0),(110,'2018-02-01',4,10,1,0),(111,'2018-02-01',5,1,1,155535),(112,'2018-02-01',5,2,1,23924),(113,'2018-02-01',5,3,1,0),(114,'2018-02-01',5,4,1,-4268),(115,'2018-02-01',5,5,1,95413),(116,'2018-02-01',5,6,1,12617),(117,'2018-02-01',5,7,1,12718),(118,'2018-02-01',5,8,1,0),(119,'2018-02-01',5,9,1,0),(120,'2018-02-01',5,10,1,0),(121,'2018-02-01',6,1,1,639129),(122,'2018-02-01',6,2,1,3863),(123,'2018-02-01',6,3,1,245503),(124,'2018-02-01',6,4,1,-63457),(125,'2018-02-01',6,5,1,165128),(126,'2018-02-01',6,6,1,0),(127,'2018-02-01',6,7,1,0),(128,'2018-02-01',6,8,1,4216),(129,'2018-02-01',6,9,1,0),(130,'2018-02-01',6,10,1,0),(131,'2018-02-01',7,1,1,451787),(132,'2018-02-01',7,2,1,5575),(133,'2018-02-01',7,3,1,-608792),(134,'2018-02-01',7,4,1,-90401),(135,'2018-02-01',7,5,1,453911),(136,'2018-02-01',7,6,1,3793),(137,'2018-02-01',7,7,1,13227),(138,'2018-02-01',7,8,1,6704),(139,'2018-02-01',7,9,1,0),(140,'2018-02-01',7,10,1,0),(141,'2019-01-01',1,1,1,4170550),(142,'2019-01-01',1,2,1,583034),(143,'2019-01-01',1,3,1,525199),(144,'2019-01-01',1,4,1,-285630),(145,'2019-01-01',1,5,1,0),(146,'2019-01-01',1,6,1,216572),(147,'2019-01-01',1,7,1,86987),(148,'2019-01-01',1,8,1,22355),(149,'2019-01-01',1,9,1,44799),(150,'2019-01-01',1,10,1,2170),(151,'2019-01-01',2,1,1,1319885),(152,'2019-01-01',2,2,1,20423),(153,'2019-01-01',2,3,1,90488),(154,'2019-01-01',2,4,1,0),(155,'2019-01-01',2,5,1,1203641),(156,'2019-01-01',2,6,1,958),(157,'2019-01-01',2,7,1,26408),(158,'2019-01-01',2,8,1,29264),(159,'2019-01-01',2,9,1,0),(160,'2019-01-01',2,10,1,1586),(161,'2019-01-01',3,1,1,270359),(162,'2019-01-01',3,2,1,0),(163,'2019-01-01',3,3,1,76294),(164,'2019-01-01',3,4,1,0),(165,'2019-01-01',3,5,1,0),(166,'2019-01-01',3,6,1,0),(167,'2019-01-01',3,7,1,18270),(168,'2019-01-01',3,8,1,31024),(169,'2019-01-01',3,9,1,0),(170,'2019-01-01',3,10,1,0),(171,'2019-01-01',4,1,1,324175),(172,'2019-01-01',4,2,1,5971),(173,'2019-01-01',4,3,1,-3903),(174,'2019-01-01',4,4,1,0),(175,'2019-01-01',4,5,1,109651),(176,'2019-01-01',4,6,1,6898),(177,'2019-01-01',4,7,1,28801),(178,'2019-01-01',4,8,1,0),(179,'2019-01-01',4,9,1,0),(180,'2019-01-01',4,10,1,245),(181,'2019-01-01',5,1,1,152351),(182,'2019-01-01',5,2,1,6015),(183,'2019-01-01',5,3,1,207177),(184,'2019-01-01',5,4,1,0),(185,'2019-01-01',5,5,1,0),(186,'2019-01-01',5,6,1,177),(187,'2019-01-01',5,7,1,12563),(188,'2019-01-01',5,8,1,18079),(189,'2019-01-01',5,9,1,0),(190,'2019-01-01',5,10,1,0),(191,'2019-01-01',6,1,1,462426),(192,'2019-01-01',6,2,1,2466),(193,'2019-01-01',6,3,1,134455),(194,'2019-01-01',6,4,1,0),(195,'2019-01-01',6,5,1,13609),(196,'2019-01-01',6,6,1,1065),(197,'2019-01-01',6,7,1,14609),(198,'2019-01-01',6,8,1,13497),(199,'2019-01-01',6,9,1,0),(200,'2019-01-01',7,1,1,329410),(201,'2019-01-01',7,2,1,10734),(202,'2019-01-01',7,3,1,438246),(203,'2019-01-01',7,4,1,0),(204,'2019-01-01',7,5,1,305527),(205,'2019-01-01',7,6,1,0),(206,'2019-01-01',7,7,1,9990),(207,'2019-01-01',7,8,1,4830),(208,'2019-01-01',7,9,1,94001),(209,'2019-01-01',7,10,1,0),(210,'2019-02-01',1,1,1,4071850),(211,'2019-02-01',1,2,1,777224),(212,'2019-02-01',1,3,1,918698),(213,'2019-02-01',1,4,1,-572464),(214,'2019-02-01',1,5,1,0),(215,'2019-02-01',1,6,1,125832),(216,'2019-02-01',1,7,1,96639),(217,'2019-02-01',1,8,1,77910),(218,'2019-02-01',1,9,1,650081),(219,'2019-02-01',1,10,1,1359),(220,'2019-02-01',2,1,1,1442194),(221,'2019-02-01',2,2,1,18414),(222,'2019-02-01',2,3,1,46191),(223,'2019-02-01',2,4,1,0),(224,'2019-02-01',2,5,1,1180756),(225,'2019-02-01',2,6,1,28462),(226,'2019-02-01',2,7,1,22392),(227,'2019-02-01',2,8,1,0),(228,'2019-02-01',2,9,1,1176),(229,'2019-02-01',2,10,1,2402),(230,'2019-02-01',3,1,1,233801),(231,'2019-02-01',3,2,1,5405),(232,'2019-02-01',3,3,1,78378),(233,'2019-02-01',3,4,1,0),(234,'2019-02-01',3,5,1,897413),(235,'2019-02-01',3,6,1,17052),(236,'2019-02-01',3,7,1,16609),(237,'2019-02-01',3,8,1,0),(238,'2019-02-01',3,9,1,0),(239,'2019-02-01',3,10,1,0),(240,'2019-02-01',4,1,1,455653),(241,'2019-02-01',4,2,1,54665),(242,'2019-02-01',4,3,1,-19925),(243,'2019-02-01',4,4,1,0),(244,'2019-02-01',4,5,1,239428),(245,'2019-02-01',4,6,1,4426),(246,'2019-02-01',4,7,1,0),(247,'2019-02-01',4,8,1,25301),(248,'2019-02-01',4,9,1,0),(249,'2019-02-01',4,10,1,0),(250,'2019-02-01',5,1,1,244154),(251,'2019-02-01',5,2,1,418156),(252,'2019-02-01',5,3,1,50510),(253,'2019-02-01',5,4,1,0),(254,'2019-02-01',5,5,1,1464),(255,'2019-02-01',5,6,1,1045),(256,'2019-02-01',5,7,1,10358),(257,'2019-02-01',5,8,1,0),(258,'2019-02-01',5,9,1,0),(259,'2019-02-01',5,10,1,0),(260,'2019-02-01',6,1,1,312127),(261,'2019-02-01',6,2,1,4833),(262,'2019-02-01',6,3,1,-16324),(263,'2019-02-01',6,4,1,0),(264,'2019-02-01',6,5,1,186710),(265,'2019-02-01',6,6,1,4473),(266,'2019-02-01',6,7,1,12213),(267,'2019-02-01',6,8,1,0),(268,'2019-02-01',6,9,1,0),(269,'2019-02-01',6,10,1,2178),(270,'2019-02-01',7,1,1,356316),(271,'2019-02-01',7,2,1,2456),(272,'2019-02-01',7,3,1,585920),(273,'2019-02-01',7,4,1,0),(274,'2019-02-01',7,5,1,316312),(275,'2019-02-01',7,6,1,1367),(276,'2019-02-01',7,7,1,2933),(277,'2019-02-01',7,8,1,0),(278,'2019-02-01',7,9,1,112307),(279,'2019-02-01',7,10,1,473);
/*!40000 ALTER TABLE `expense_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_type`
--

DROP TABLE IF EXISTS `expense_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_type`
--

LOCK TABLES `expense_type` WRITE;
/*!40000 ALTER TABLE `expense_type` DISABLE KEYS */;
INSERT INTO `expense_type` VALUES (10,'Acquiring'),(9,'Advertisement'),(8,'BusinessTrip'),(2,'Factory'),(6,'Other'),(4,'Package'),(7,'Phone'),(5,'Rent'),(1,'Salary'),(3,'Transport');
/*!40000 ALTER TABLE `expense_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `labour_cost`
--

DROP TABLE IF EXISTS `labour_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `labour_cost` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `organization_unit_id` int NOT NULL,
  `currency_id` int NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `date_UNIQUE` (`date`,`organization_unit_id`),
  KEY `labour_year_id_idx` (`date`),
  KEY `labour_cost_currency_idx` (`currency_id`),
  KEY `labour_cost_organization_unit_idx` (`organization_unit_id`),
  CONSTRAINT `labour_cost_currency` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`id`),
  CONSTRAINT `labour_cost_organization_unit` FOREIGN KEY (`organization_unit_id`) REFERENCES `organization_unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `labour_cost`
--

LOCK TABLES `labour_cost` WRITE;
/*!40000 ALTER TABLE `labour_cost` DISABLE KEYS */;
INSERT INTO `labour_cost` VALUES (1,'2018-01-01',1,1,4045324),(2,'2018-01-01',2,1,1284601),(3,'2018-01-01',3,1,288723),(4,'2018-01-01',4,1,332250),(5,'2018-01-01',5,1,110808),(6,'2018-01-01',6,1,228135),(7,'2018-01-01',7,1,565959),(8,'2018-02-01',1,1,5016566),(9,'2018-02-01',2,1,1543562),(10,'2018-02-01',3,1,390077),(11,'2018-02-01',4,1,289303),(12,'2018-02-01',5,1,156770),(13,'2018-02-01',6,1,645289),(14,'2018-02-01',7,1,469962),(15,'2019-01-01',1,1,4242740),(16,'2019-01-01',2,1,1336268),(17,'2019-01-01',3,1,297599),(18,'2019-01-01',4,1,331316),(19,'2019-01-01',5,1,170708),(20,'2019-01-01',6,1,480822),(21,'2019-01-01',7,1,326902),(22,'2019-02-01',2,1,1454327),(23,'2019-02-01',3,1,234714),(24,'2019-02-01',4,1,463206),(25,'2019-02-01',5,1,247810),(26,'2019-02-01',6,1,315199),(27,'2019-02-01',1,1,4143440),(28,'2019-02-01',7,1,367095);
/*!40000 ALTER TABLE `labour_cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `language` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` VALUES (2,'EN'),(1,'RU');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `margin_sum`
--

DROP TABLE IF EXISTS `margin_sum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `margin_sum` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `organization_unit_id` int NOT NULL,
  `currency_id` int NOT NULL,
  `product_group_id` int NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `date_UNIQUE` (`date`,`organization_unit_id`,`product_group_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `margin_currency_idx` (`currency_id`),
  KEY `margin_organization_unit_idx` (`organization_unit_id`),
  KEY `margin_product_group_idx` (`product_group_id`),
  CONSTRAINT `margin_currency` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`id`),
  CONSTRAINT `margin_organization_unit` FOREIGN KEY (`organization_unit_id`) REFERENCES `organization_unit` (`id`),
  CONSTRAINT `margin_product_group` FOREIGN KEY (`product_group_id`) REFERENCES `product_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=279 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `margin_sum`
--

LOCK TABLES `margin_sum` WRITE;
/*!40000 ALTER TABLE `margin_sum` DISABLE KEYS */;
INSERT INTO `margin_sum` VALUES (1,'2018-01-01',1,1,1,703243),(2,'2018-01-01',1,1,2,575883),(3,'2018-01-01',1,1,3,83799),(4,'2018-01-01',1,1,4,141579),(5,'2018-01-01',1,1,5,56489),(6,'2018-01-01',1,1,6,27168),(7,'2018-01-01',1,1,7,0),(8,'2018-01-01',1,1,8,247589),(9,'2018-01-01',1,1,9,15190),(10,'2018-01-01',1,1,10,234162),(11,'2018-01-01',2,1,1,859377),(12,'2018-01-01',2,1,2,4223103),(13,'2018-01-01',2,1,3,116449),(14,'2018-01-01',2,1,4,223957),(15,'2018-01-01',2,1,5,38519),(16,'2018-01-01',2,1,6,24490),(17,'2018-01-01',2,1,7,0),(18,'2018-01-01',2,1,8,78434),(19,'2018-01-01',2,1,9,0),(20,'2018-01-01',2,1,10,79709),(21,'2018-01-01',3,1,1,-88903),(22,'2018-01-01',3,1,2,0),(23,'2018-01-01',3,1,3,153427),(24,'2018-01-01',3,1,4,124518),(25,'2018-01-01',3,1,5,15520),(26,'2018-01-01',3,1,6,15665),(27,'2018-01-01',3,1,7,0),(28,'2018-01-01',3,1,8,0),(29,'2018-01-01',3,1,9,0),(30,'2018-01-01',3,1,10,22404),(31,'2018-01-01',4,1,1,221978),(32,'2018-01-01',4,1,2,0),(33,'2018-01-01',4,1,3,324120),(34,'2018-01-01',4,1,4,55657),(35,'2018-01-01',4,1,5,5885),(36,'2018-01-01',4,1,6,0),(37,'2018-01-01',4,1,7,0),(38,'2018-01-01',4,1,8,0),(39,'2018-01-01',4,1,9,0),(40,'2018-01-01',4,1,10,91111),(41,'2018-01-01',5,1,1,89846),(42,'2018-01-01',5,1,2,0),(43,'2018-01-01',5,1,3,17397),(44,'2018-01-01',5,1,4,6019),(45,'2018-01-01',5,1,5,11858),(46,'2018-01-01',5,1,6,418),(47,'2018-01-01',5,1,7,0),(48,'2018-01-01',5,1,8,0),(49,'2018-01-01',5,1,9,0),(50,'2018-01-01',5,1,10,11717),(51,'2018-01-01',6,1,1,444837),(52,'2018-01-01',6,1,2,565818),(53,'2018-01-01',6,1,3,18406),(54,'2018-01-01',6,1,4,26783),(55,'2018-01-01',6,1,5,35389),(56,'2018-01-01',6,1,6,38104),(57,'2018-01-01',6,1,7,0),(58,'2018-01-01',6,1,8,125096),(59,'2018-01-01',6,1,9,12356),(60,'2018-01-01',7,1,1,462221),(61,'2018-01-01',7,1,2,0),(62,'2018-01-01',7,1,3,193965),(63,'2018-01-01',7,1,4,58152),(64,'2018-01-01',7,1,5,62410),(65,'2018-01-01',7,1,6,14506),(66,'2018-01-01',7,1,7,0),(67,'2018-01-01',7,1,8,0),(68,'2018-01-01',7,1,9,23907),(69,'2018-01-01',7,1,10,40739),(70,'2018-02-01',1,1,1,1090313),(71,'2018-02-01',1,1,2,3199520),(72,'2018-02-01',1,1,3,465177),(73,'2018-02-01',1,1,4,268892),(74,'2018-02-01',1,1,5,148415),(75,'2018-02-01',1,1,6,29085),(76,'2018-02-01',1,1,7,0),(77,'2018-02-01',1,1,8,155335),(78,'2018-02-01',1,1,9,123953),(79,'2018-02-01',1,1,10,279589),(80,'2018-02-01',2,1,1,582553),(81,'2018-02-01',2,1,2,3447764),(82,'2018-02-01',2,1,3,219994),(83,'2018-02-01',2,1,4,215656),(84,'2018-02-01',2,1,5,58202),(85,'2018-02-01',2,1,6,1143),(86,'2018-02-01',2,1,7,0),(87,'2018-02-01',2,1,8,512540),(88,'2018-02-01',2,1,9,0),(89,'2018-02-01',2,1,10,36503),(90,'2018-02-01',3,1,1,184252),(91,'2018-02-01',3,1,2,0),(92,'2018-02-01',3,1,3,111192),(93,'2018-02-01',3,1,4,31193),(94,'2018-02-01',3,1,5,14619),(95,'2018-02-01',3,1,6,11654),(96,'2018-02-01',3,1,7,0),(97,'2018-02-01',3,1,8,0),(98,'2018-02-01',3,1,9,0),(99,'2018-02-01',3,1,10,43249),(100,'2018-02-01',4,1,1,387565),(101,'2018-02-01',4,1,2,197885),(102,'2018-02-01',4,1,3,29512),(103,'2018-02-01',4,1,4,214370),(104,'2018-02-01',4,1,5,8624),(105,'2018-02-01',4,1,6,25851),(106,'2018-02-01',4,1,7,0),(107,'2018-02-01',4,1,8,153946),(108,'2018-02-01',4,1,9,0),(109,'2018-02-01',4,1,10,96840),(110,'2018-02-01',5,1,1,64485),(111,'2018-02-01',5,1,2,0),(112,'2018-02-01',5,1,3,92948),(113,'2018-02-01',5,1,4,50464),(114,'2018-02-01',5,1,5,15481),(115,'2018-02-01',5,1,6,382),(116,'2018-02-01',5,1,7,0),(117,'2018-02-01',5,1,8,5508),(118,'2018-02-01',5,1,9,0),(119,'2018-02-01',6,1,1,317361),(120,'2018-02-01',6,1,2,1115934),(121,'2018-02-01',6,1,3,331),(122,'2018-02-01',6,1,4,70694),(123,'2018-02-01',6,1,5,138302),(124,'2018-02-01',6,1,6,15676),(125,'2018-02-01',6,1,7,0),(126,'2018-02-01',6,1,8,255887),(127,'2018-02-01',6,1,9,0),(128,'2018-02-01',6,1,10,109480),(129,'2018-02-01',7,1,1,1104751),(130,'2018-02-01',7,1,2,1794263),(131,'2018-02-01',7,1,3,506339),(132,'2018-02-01',7,1,4,215871),(133,'2018-02-01',7,1,5,21523),(134,'2018-02-01',7,1,6,21189),(135,'2018-02-01',7,1,7,0),(136,'2018-02-01',7,1,8,0),(137,'2018-02-01',7,1,9,61288),(138,'2018-02-01',7,1,10,94881),(139,'2019-01-01',1,1,1,1134454),(140,'2019-01-01',1,1,2,1487728),(141,'2019-01-01',1,1,3,161980),(142,'2019-01-01',1,1,4,284629),(143,'2019-01-01',1,1,5,456422),(144,'2019-01-01',1,1,6,22455),(145,'2019-01-01',1,1,7,61820),(146,'2019-01-01',1,1,8,654991),(147,'2019-01-01',1,1,9,111156),(148,'2019-01-01',1,1,10,248208),(149,'2019-01-01',2,1,1,721901),(150,'2019-01-01',2,1,2,110125),(151,'2019-01-01',2,1,3,159283),(152,'2019-01-01',2,1,4,271901),(153,'2019-01-01',2,1,5,8808),(154,'2019-01-01',2,1,6,18593),(155,'2019-01-01',2,1,7,0),(156,'2019-01-01',2,1,8,0),(157,'2019-01-01',2,1,9,6162),(158,'2019-01-01',2,1,10,16389),(159,'2019-01-01',3,1,1,194878),(160,'2019-01-01',3,1,2,0),(161,'2019-01-01',3,1,3,72882),(162,'2019-01-01',3,1,4,33562),(163,'2019-01-01',3,1,5,0),(164,'2019-01-01',3,1,6,13997),(165,'2019-01-01',3,1,7,0),(166,'2019-01-01',3,1,8,0),(167,'2019-01-01',3,1,9,0),(168,'2019-01-01',3,1,10,55246),(169,'2019-01-01',4,1,1,165566),(170,'2019-01-01',4,1,2,535103),(171,'2019-01-01',4,1,3,115261),(172,'2019-01-01',4,1,4,56694),(173,'2019-01-01',4,1,5,50164),(174,'2019-01-01',4,1,6,1872),(175,'2019-01-01',4,1,7,0),(176,'2019-01-01',4,1,8,12771),(177,'2019-01-01',4,1,9,30855),(178,'2019-01-01',4,1,10,28957),(179,'2019-01-01',5,1,1,353891),(180,'2019-01-01',5,1,2,642297),(181,'2019-01-01',5,1,3,140989),(182,'2019-01-01',5,1,4,55529),(183,'2019-01-01',5,1,5,457245),(184,'2019-01-01',5,1,6,14939),(185,'2019-01-01',5,1,7,0),(186,'2019-01-01',5,1,8,79726),(187,'2019-01-01',5,1,9,87566),(188,'2019-01-01',5,1,10,243567),(189,'2019-01-01',6,1,1,209521),(190,'2019-01-01',6,1,2,235234),(191,'2019-01-01',6,1,3,2820),(192,'2019-01-01',6,1,4,36592),(193,'2019-01-01',6,1,5,19493),(194,'2019-01-01',6,1,6,3374),(195,'2019-01-01',6,1,7,0),(196,'2019-01-01',6,1,8,0),(197,'2019-01-01',6,1,9,0),(198,'2019-01-01',6,1,10,64656),(199,'2019-01-01',7,1,1,1140452),(200,'2019-01-01',7,1,2,415668),(201,'2019-01-01',7,1,3,452060),(202,'2019-01-01',7,1,4,43321),(203,'2019-01-01',7,1,5,19271),(204,'2019-01-01',7,1,6,16300),(205,'2019-01-01',7,1,7,0),(206,'2019-01-01',7,1,8,0),(207,'2019-01-01',7,1,9,0),(208,'2019-01-01',7,1,10,17869),(209,'2019-02-01',1,1,1,1060351),(210,'2019-02-01',1,1,2,3065334),(211,'2019-02-01',1,1,3,240550),(212,'2019-02-01',1,1,4,187106),(213,'2019-02-01',1,1,5,98674),(214,'2019-02-01',1,1,6,38892),(215,'2019-02-01',1,1,7,0),(216,'2019-02-01',1,1,8,251287),(217,'2019-02-01',1,1,9,135017),(218,'2019-02-01',1,1,10,215446),(219,'2019-02-01',2,1,1,758731),(220,'2019-02-01',2,1,2,2071198),(221,'2019-02-01',2,1,3,188503),(222,'2019-02-01',2,1,4,213795),(223,'2019-02-01',2,1,5,975),(224,'2019-02-01',2,1,6,11610),(225,'2019-02-01',2,1,7,0),(226,'2019-02-01',2,1,8,447644),(227,'2019-02-01',2,1,9,30738),(228,'2019-02-01',2,1,10,34841),(229,'2019-02-01',3,1,1,248596),(230,'2019-02-01',3,1,2,276963),(231,'2019-02-01',3,1,3,74627),(232,'2019-02-01',3,1,4,47369),(233,'2019-02-01',3,1,5,653),(234,'2019-02-01',3,1,6,0),(235,'2019-02-01',3,1,7,0),(236,'2019-02-01',3,1,8,0),(237,'2019-02-01',3,1,9,0),(238,'2019-02-01',3,1,10,24148),(239,'2019-02-01',4,1,1,390674),(240,'2019-02-01',4,1,2,1425371),(241,'2019-02-01',4,1,3,35580),(242,'2019-02-01',4,1,4,76784),(243,'2019-02-01',4,1,5,49667),(244,'2019-02-01',4,1,6,1941),(245,'2019-02-01',4,1,7,0),(246,'2019-02-01',4,1,8,18086),(247,'2019-02-01',4,1,9,11268),(248,'2019-02-01',4,1,10,59727),(249,'2019-02-01',5,1,1,470990),(250,'2019-02-01',5,1,2,0),(251,'2019-02-01',5,1,3,-107),(252,'2019-02-01',5,1,4,118157),(253,'2019-02-01',5,1,5,16926),(254,'2019-02-01',5,1,6,0),(255,'2019-02-01',5,1,7,0),(256,'2019-02-01',5,1,8,0),(257,'2019-02-01',5,1,9,0),(258,'2019-02-01',5,1,10,2023),(259,'2019-02-01',6,1,1,285294),(260,'2019-02-01',6,1,2,1591132),(261,'2019-02-01',6,1,3,6155),(262,'2019-02-01',6,1,4,16582),(263,'2019-02-01',6,1,5,21837),(264,'2019-02-01',6,1,6,9730),(265,'2019-02-01',6,1,7,0),(266,'2019-02-01',6,1,8,0),(267,'2019-02-01',6,1,9,0),(268,'2019-02-01',6,1,10,19683),(269,'2019-02-01',7,1,1,2231878),(270,'2019-02-01',7,1,2,0),(271,'2019-02-01',7,1,3,543133),(272,'2019-02-01',7,1,4,118725),(273,'2019-02-01',7,1,5,-2864),(274,'2019-02-01',7,1,6,22685),(275,'2019-02-01',7,1,7,0),(276,'2019-02-01',7,1,8,0),(277,'2019-02-01',7,1,9,1246),(278,'2019-02-01',7,1,10,98274);
/*!40000 ALTER TABLE `margin_sum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metal_processing`
--

DROP TABLE IF EXISTS `metal_processing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `metal_processing` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `organization_unit_id` int NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `date_UNIQUE` (`date`,`organization_unit_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `metall_processing_organization_unit_idx` (`organization_unit_id`),
  CONSTRAINT `metall_processing_organization_unit` FOREIGN KEY (`organization_unit_id`) REFERENCES `organization_unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metal_processing`
--

LOCK TABLES `metal_processing` WRITE;
/*!40000 ALTER TABLE `metal_processing` DISABLE KEYS */;
INSERT INTO `metal_processing` VALUES (1,'2018-01-01',1,550),(2,'2018-01-01',2,119),(3,'2018-02-01',1,792),(4,'2018-02-01',2,205),(5,'2019-01-01',1,497),(6,'2019-01-01',2,223),(7,'2019-02-01',1,859),(8,'2019-02-01',2,271);
/*!40000 ALTER TABLE `metal_processing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `number_of_stuff`
--

DROP TABLE IF EXISTS `number_of_stuff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `number_of_stuff` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `organization_unit_id` int NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `organization_unit_id_UNIQUE` (`organization_unit_id`,`date`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `number_of_stuff_organization_unit_idx` (`organization_unit_id`),
  CONSTRAINT `number_of_stuff_organization_unit` FOREIGN KEY (`organization_unit_id`) REFERENCES `organization_unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `number_of_stuff`
--

LOCK TABLES `number_of_stuff` WRITE;
/*!40000 ALTER TABLE `number_of_stuff` DISABLE KEYS */;
INSERT INTO `number_of_stuff` VALUES (1,'2018-01-01',1,124),(2,'2018-02-01',1,127),(3,'2019-01-01',1,121),(4,'2019-02-01',1,127),(5,'2018-01-01',2,52),(6,'2018-02-01',2,52),(7,'2019-01-01',2,48),(8,'2019-02-01',2,48),(9,'2018-01-01',3,12),(10,'2018-02-01',3,13),(11,'2019-01-01',3,11),(12,'2019-02-01',3,11),(13,'2018-01-01',4,9),(14,'2018-02-01',4,9),(15,'2019-01-01',4,12),(16,'2019-02-01',4,13),(17,'2018-01-01',5,6),(18,'2018-02-01',5,7),(19,'2019-01-01',5,7),(20,'2019-02-01',5,7),(21,'2018-01-01',6,10),(22,'2018-02-01',6,10),(23,'2019-01-01',6,11),(24,'2019-02-01',6,11),(25,'2018-01-01',7,17),(26,'2018-02-01',7,17),(27,'2019-01-01',7,14),(28,'2019-02-01',7,15);
/*!40000 ALTER TABLE `number_of_stuff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization_unit`
--

DROP TABLE IF EXISTS `organization_unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization_unit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization_unit`
--

LOCK TABLES `organization_unit` WRITE;
/*!40000 ALTER TABLE `organization_unit` DISABLE KEYS */;
INSERT INTO `organization_unit` VALUES (5,'Aktobe'),(2,'Almaty'),(4,'Astana'),(3,'Atyrau'),(1,'Karaganda'),(6,'Oskemen'),(7,'Shymkent');
/*!40000 ALTER TABLE `organization_unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_group`
--

DROP TABLE IF EXISTS `product_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_group` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_group`
--

LOCK TABLES `product_group` WRITE;
/*!40000 ALTER TABLE `product_group` DISABLE KEYS */;
INSERT INTO `product_group` VALUES (6,'EBK'),(5,'ENK'),(8,'FK'),(10,'Goods'),(9,'Other'),(1,'OVP'),(4,'SEO'),(7,'SPPS'),(2,'TSP'),(3,'VS');
/*!40000 ALTER TABLE `product_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revenue`
--

DROP TABLE IF EXISTS `revenue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `revenue` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `organization_unit_id` int NOT NULL,
  `currency_id` int NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `date_UNIQUE` (`date`,`organization_unit_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `revenue_currency_idx` (`currency_id`),
  KEY `revenue_organization_unit_idx` (`organization_unit_id`),
  CONSTRAINT `revenue_currency` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`id`),
  CONSTRAINT `revenue_organization_unit` FOREIGN KEY (`organization_unit_id`) REFERENCES `organization_unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revenue`
--

LOCK TABLES `revenue` WRITE;
/*!40000 ALTER TABLE `revenue` DISABLE KEYS */;
INSERT INTO `revenue` VALUES (1,'2018-01-01',1,1,15218481),(2,'2018-01-01',2,1,23278568),(3,'2018-01-01',3,1,5376863),(4,'2018-01-01',4,1,2977325),(5,'2018-01-01',5,1,2106890),(6,'2018-01-01',6,1,9758668),(7,'2018-01-01',7,1,18161622),(8,'2018-02-01',1,1,28098355),(9,'2018-02-01',2,1,21145069),(10,'2018-02-01',3,1,4476568),(11,'2018-02-01',4,1,14822243),(12,'2018-02-01',5,1,9300319),(13,'2018-02-01',6,1,9829326),(14,'2018-02-01',7,1,10569688),(15,'2019-01-01',1,1,21758192),(16,'2019-01-01',2,1,20574910),(17,'2019-01-01',3,1,4104306),(18,'2019-01-01',4,1,8915065),(19,'2019-01-01',5,1,1823916),(20,'2019-01-01',6,1,3746610),(21,'2019-01-01',7,1,19396923),(22,'2019-02-01',1,1,40561488),(23,'2019-02-01',2,1,23771756),(24,'2019-02-01',3,1,4995831),(25,'2019-02-01',4,1,12054933),(26,'2019-02-01',5,1,6198568),(27,'2019-02-01',6,1,7549940),(28,'2019-02-01',7,1,22863863);
/*!40000 ALTER TABLE `revenue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `role_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin'),(2,'Director'),(7,'Head of Department of Aktobe'),(4,'Head of Department of Almaty'),(6,'Head of Department of Astana'),(5,'Head of Department of Atyrau'),(3,'Head of Department of Karaganda'),(8,'Head of Department of Oskemen'),(9,'Head of Department of Shymkent');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_of_square_metres`
--

DROP TABLE IF EXISTS `sales_of_square_metres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_of_square_metres` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `organization_unit_id` int NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `date_UNIQUE` (`date`,`organization_unit_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `sales_year_id_idx` (`date`),
  KEY `sales_of_square_metres_and_tonns_organization_unit_idx` (`organization_unit_id`),
  CONSTRAINT `sales_of_square_metres_and_tonns_organization_unit` FOREIGN KEY (`organization_unit_id`) REFERENCES `organization_unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_of_square_metres`
--

LOCK TABLES `sales_of_square_metres` WRITE;
/*!40000 ALTER TABLE `sales_of_square_metres` DISABLE KEYS */;
INSERT INTO `sales_of_square_metres` VALUES (1,'2018-01-01',1,51867),(2,'2018-01-01',2,65164),(3,'2018-01-01',3,19925),(4,'2018-01-01',4,10514),(5,'2018-01-01',5,4600),(6,'2018-01-01',6,21426),(7,'2018-01-01',7,32470),(8,'2018-02-01',1,92508),(9,'2018-02-01',2,69038),(10,'2018-02-01',3,23767),(11,'2018-02-01',4,13179),(12,'2018-02-01',5,38545),(13,'2018-02-01',6,33630),(14,'2018-02-01',7,75888),(15,'2019-01-01',1,86342),(16,'2019-01-01',2,35561),(17,'2019-01-01',3,7761),(18,'2019-01-01',4,14656),(19,'2019-01-01',5,14812),(20,'2019-01-01',6,13566),(21,'2019-01-01',7,59879),(22,'2019-02-01',1,85639),(23,'2019-02-01',2,68904),(24,'2019-02-01',3,12919),(25,'2019-02-01',4,37103),(26,'2019-02-01',5,12826),(27,'2019-02-01',6,27207),(28,'2019-02-01',7,75531);
/*!40000 ALTER TABLE `sales_of_square_metres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_of_tons`
--

DROP TABLE IF EXISTS `sales_of_tons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_of_tons` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `organization_unit_id` int NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `date_UNIQUE` (`date`,`organization_unit_id`),
  KEY `sales_of_tonnes_organization_unit_idx` (`organization_unit_id`),
  CONSTRAINT `sales_of_tonnes_organization_unit` FOREIGN KEY (`organization_unit_id`) REFERENCES `organization_unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_of_tons`
--

LOCK TABLES `sales_of_tons` WRITE;
/*!40000 ALTER TABLE `sales_of_tons` DISABLE KEYS */;
INSERT INTO `sales_of_tons` VALUES (1,'2018-01-01',1,181),(2,'2018-01-01',2,271),(3,'2018-01-01',3,58),(4,'2018-01-01',4,38),(5,'2018-01-01',5,17),(6,'2018-01-01',6,81),(7,'2018-01-01',7,102),(8,'2018-02-01',1,330),(9,'2018-02-01',2,270),(10,'2018-02-01',3,86),(11,'2018-02-01',4,54),(12,'2018-02-01',5,80),(13,'2018-02-01',6,146),(14,'2018-02-01',7,249),(15,'2019-01-01',1,349),(16,'2019-01-01',2,121),(17,'2019-01-01',3,26),(18,'2019-01-01',4,53),(19,'2019-01-01',5,56),(20,'2019-01-01',6,52),(21,'2019-01-01',7,184),(22,'2019-02-01',1,298),(23,'2019-02-01',2,261),(24,'2019-02-01',3,44),(25,'2019-02-01',4,134),(26,'2019-02-01',5,40),(27,'2019-02-01',6,105),(28,'2019-02-01',7,224);
/*!40000 ALTER TABLE `sales_of_tons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_sum`
--

DROP TABLE IF EXISTS `sales_sum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_sum` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `organization_unit_id` int NOT NULL,
  `currency_id` int NOT NULL,
  `product_group_id` int NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `date_UNIQUE` (`date`,`organization_unit_id`,`product_group_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `sales_currency_idx` (`currency_id`),
  KEY `sales_organization_unit_idx` (`organization_unit_id`),
  KEY `sales_product_group_idx` (`product_group_id`),
  CONSTRAINT `sales_currency` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`id`),
  CONSTRAINT `sales_organization_unit` FOREIGN KEY (`organization_unit_id`) REFERENCES `organization_unit` (`id`),
  CONSTRAINT `sales_product_group` FOREIGN KEY (`product_group_id`) REFERENCES `product_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=279 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_sum`
--

LOCK TABLES `sales_sum` WRITE;
/*!40000 ALTER TABLE `sales_sum` DISABLE KEYS */;
INSERT INTO `sales_sum` VALUES (1,'2018-01-01',1,1,1,9718247),(2,'2018-01-01',1,1,2,2597391),(3,'2018-01-01',1,1,3,191904),(4,'2018-01-01',1,1,4,317511),(5,'2018-01-01',1,1,5,270473),(6,'2018-01-01',1,1,6,62685),(7,'2018-01-01',1,1,7,0),(8,'2018-01-01',1,1,8,635895),(9,'2018-01-01',1,1,9,31903),(10,'2018-01-01',1,1,10,664720),(11,'2018-01-01',2,1,1,8998601),(12,'2018-01-01',2,1,2,15667829),(13,'2018-01-01',2,1,3,281467),(14,'2018-01-01',2,1,4,504587),(15,'2018-01-01',2,1,5,386872),(16,'2018-01-01',2,1,6,60212),(17,'2018-01-01',2,1,7,0),(18,'2018-01-01',2,1,8,243338),(19,'2018-01-01',2,1,9,0),(20,'2018-01-01',2,1,10,203659),(21,'2018-01-01',3,1,1,2601128),(22,'2018-01-01',3,1,2,0),(23,'2018-01-01',3,1,3,373542),(24,'2018-01-01',3,1,4,219629),(25,'2018-01-01',3,1,5,48069),(26,'2018-01-01',3,1,6,31877),(27,'2018-01-01',3,1,7,0),(28,'2018-01-01',3,1,8,0),(29,'2018-01-01',3,1,9,0),(30,'2018-01-01',3,1,10,80642),(31,'2018-01-01',4,1,1,2283935),(32,'2018-01-01',4,1,2,0),(33,'2018-01-01',4,1,3,662255),(34,'2018-01-01',4,1,4,158143),(35,'2018-01-01',4,1,5,23926),(36,'2018-01-01',4,1,6,0),(37,'2018-01-01',4,1,7,0),(38,'2018-01-01',4,1,8,0),(39,'2018-01-01',4,1,9,0),(40,'2018-01-01',4,1,10,296247),(41,'2018-01-01',5,1,1,1073197),(42,'2018-01-01',5,1,2,0),(43,'2018-01-01',5,1,3,31539),(44,'2018-01-01',5,1,4,11692),(45,'2018-01-01',5,1,5,49543),(46,'2018-01-01',5,1,6,957),(47,'2018-01-01',5,1,7,0),(48,'2018-01-01',5,1,8,0),(49,'2018-01-01',5,1,9,0),(50,'2018-01-01',5,1,10,71059),(51,'2018-01-01',6,1,1,4383175),(52,'2018-01-01',6,1,2,2138646),(53,'2018-01-01',6,1,3,33668),(54,'2018-01-01',6,1,4,51035),(55,'2018-01-01',6,1,5,113326),(56,'2018-01-01',6,1,6,76096),(57,'2018-01-01',6,1,7,0),(58,'2018-01-01',6,1,8,342850),(59,'2018-01-01',6,1,9,24337),(60,'2018-01-01',7,1,1,6560610),(61,'2018-01-01',7,1,2,0),(62,'2018-01-01',7,1,3,695409),(63,'2018-01-01',7,1,4,125185),(64,'2018-01-01',7,1,5,355494),(65,'2018-01-01',7,1,6,40856),(66,'2018-01-01',7,1,7,0),(67,'2018-01-01',7,1,8,0),(68,'2018-01-01',7,1,9,61273),(69,'2018-01-01',7,1,10,174917),(70,'2018-02-01',1,1,1,16160077),(71,'2018-02-01',1,1,2,11828045),(72,'2018-02-01',1,1,3,1088728),(73,'2018-02-01',1,1,4,762090),(74,'2018-02-01',1,1,5,799286),(75,'2018-02-01',1,1,6,55719),(76,'2018-02-01',1,1,7,0),(77,'2018-02-01',1,1,8,414130),(78,'2018-02-01',1,1,9,278463),(79,'2018-02-01',1,1,10,954400),(80,'2018-02-01',2,1,1,9191062),(81,'2018-02-01',2,1,2,14266202),(82,'2018-02-01',2,1,3,576814),(83,'2018-02-01',2,1,4,655011),(84,'2018-02-01',2,1,5,354089),(85,'2018-02-01',2,1,6,5491),(86,'2018-02-01',2,1,7,0),(87,'2018-02-01',2,1,8,1518864),(88,'2018-02-01',2,1,9,0),(89,'2018-02-01',2,1,10,137982),(90,'2018-02-01',3,1,1,5307341),(91,'2018-02-01',3,1,2,0),(92,'2018-02-01',3,1,3,206832),(93,'2018-02-01',3,1,4,149657),(94,'2018-02-01',3,1,5,77610),(95,'2018-02-01',3,1,6,25363),(96,'2018-02-01',3,1,7,0),(97,'2018-02-01',3,1,8,0),(98,'2018-02-01',3,1,9,0),(99,'2018-02-01',3,1,10,216647),(100,'2018-02-01',4,1,1,2965197),(101,'2018-02-01',4,1,2,638112),(102,'2018-02-01',4,1,3,75154),(103,'2018-02-01',4,1,4,514030),(104,'2018-02-01',4,1,5,84453),(105,'2018-02-01',4,1,6,52223),(106,'2018-02-01',4,1,7,0),(107,'2018-02-01',4,1,8,352053),(108,'2018-02-01',4,1,9,0),(109,'2018-02-01',4,1,10,287164),(110,'2018-02-01',5,1,1,5373229),(111,'2018-02-01',5,1,2,0),(112,'2018-02-01',5,1,3,195992),(113,'2018-02-01',5,1,4,162694),(114,'2018-02-01',5,1,5,65404),(115,'2018-02-01',5,1,6,695),(116,'2018-02-01',5,1,7,0),(117,'2018-02-01',5,1,8,17343),(118,'2018-02-01',5,1,9,0),(119,'2018-02-01',6,1,1,6506545),(120,'2018-02-01',6,1,2,4842345),(121,'2018-02-01',6,1,3,696),(122,'2018-02-01',6,1,4,143346),(123,'2018-02-01',6,1,5,1252052),(124,'2018-02-01',6,1,6,28670),(125,'2018-02-01',6,1,7,0),(126,'2018-02-01',6,1,8,656972),(127,'2018-02-01',6,1,9,0),(128,'2018-02-01',6,1,10,339371),(129,'2018-02-01',7,1,1,13947394),(130,'2018-02-01',7,1,2,6559742),(131,'2018-02-01',7,1,3,1533012),(132,'2018-02-01',7,1,4,663607),(133,'2018-02-01',7,1,5,160841),(134,'2018-02-01',7,1,6,58714),(135,'2018-02-01',7,1,7,0),(136,'2018-02-01',7,1,8,0),(137,'2018-02-01',7,1,9,157155),(138,'2018-02-01',7,1,10,332431),(139,'2019-01-01',1,1,1,15470063),(140,'2019-01-01',1,1,2,7146890),(141,'2019-01-01',1,1,3,581572),(142,'2019-01-01',1,1,4,648089),(143,'2019-01-01',1,1,5,3870716),(144,'2019-01-01',1,1,6,79686),(145,'2019-01-01',1,1,7,366577),(146,'2019-01-01',1,1,8,2034291),(147,'2019-01-01',1,1,9,339267),(148,'2019-01-01',1,1,10,942803),(149,'2019-01-01',2,1,1,8231115),(150,'2019-01-01',2,1,2,592848),(151,'2019-01-01',2,1,3,438011),(152,'2019-01-01',2,1,4,726554),(153,'2019-01-01',2,1,5,67588),(154,'2019-01-01',2,1,6,57889),(155,'2019-01-01',2,1,7,0),(156,'2019-01-01',2,1,8,0),(157,'2019-01-01',2,1,9,13005),(158,'2019-01-01',2,1,10,84917),(159,'2019-01-01',3,1,1,1951452),(160,'2019-01-01',3,1,2,0),(161,'2019-01-01',3,1,3,206101),(162,'2019-01-01',3,1,4,85889),(163,'2019-01-01',3,1,5,0),(164,'2019-01-01',3,1,6,37258),(165,'2019-01-01',3,1,7,0),(166,'2019-01-01',3,1,8,0),(167,'2019-01-01',3,1,9,0),(168,'2019-01-01',3,1,10,157296),(169,'2019-01-01',4,1,1,2013906),(170,'2019-01-01',4,1,2,3079815),(171,'2019-01-01',4,1,3,297594),(172,'2019-01-01',4,1,4,171788),(173,'2019-01-01',4,1,5,280314),(174,'2019-01-01',4,1,6,10197),(175,'2019-01-01',4,1,7,0),(176,'2019-01-01',4,1,8,33274),(177,'2019-01-01',4,1,9,66293),(178,'2019-01-01',4,1,10,149565),(179,'2019-01-01',5,1,1,1775897),(180,'2019-01-01',5,1,2,2826975),(181,'2019-01-01',5,1,3,293485),(182,'2019-01-01',5,1,4,119369),(183,'2019-01-01',5,1,5,1598272),(184,'2019-01-01',5,1,6,36234),(185,'2019-01-01',5,1,7,0),(186,'2019-01-01',5,1,8,198141),(187,'2019-01-01',5,1,9,190174),(188,'2019-01-01',5,1,10,725983),(189,'2019-01-01',6,1,1,3156637),(190,'2019-01-01',6,1,2,1132896),(191,'2019-01-01',6,1,3,5032),(192,'2019-01-01',6,1,4,77340),(193,'2019-01-01',6,1,5,258397),(194,'2019-01-01',6,1,6,11788),(195,'2019-01-01',6,1,7,0),(196,'2019-01-01',6,1,8,0),(197,'2019-01-01',6,1,9,0),(198,'2019-01-01',6,1,10,157122),(199,'2019-01-01',7,1,1,11566006),(200,'2019-01-01',7,1,2,3548416),(201,'2019-01-01',7,1,3,1425870),(202,'2019-01-01',7,1,4,320021),(203,'2019-01-01',7,1,5,110256),(204,'2019-01-01',7,1,6,58206),(205,'2019-01-01',7,1,7,0),(206,'2019-01-01',7,1,8,0),(207,'2019-01-01',7,1,9,0),(208,'2019-01-01',7,1,10,89530),(209,'2019-02-01',1,1,1,13229574),(210,'2019-02-01',1,1,2,14874324),(211,'2019-02-01',1,1,3,771463),(212,'2019-02-01',1,1,4,484674),(213,'2019-02-01',1,1,5,891604),(214,'2019-02-01',1,1,6,129591),(215,'2019-02-01',1,1,7,0),(216,'2019-02-01',1,1,8,685781),(217,'2019-02-01',1,1,9,378435),(218,'2019-02-01',1,1,10,965049),(219,'2019-02-01',2,1,1,12679141),(220,'2019-02-01',2,1,2,8404291),(221,'2019-02-01',2,1,3,522323),(222,'2019-02-01',2,1,4,618766),(223,'2019-02-01',2,1,5,44070),(224,'2019-02-01',2,1,6,39979),(225,'2019-02-01',2,1,7,0),(226,'2019-02-01',2,1,8,1186576),(227,'2019-02-01',2,1,9,97181),(228,'2019-02-01',2,1,10,123408),(229,'2019-02-01',3,1,1,2734001),(230,'2019-02-01',3,1,2,1049736),(231,'2019-02-01',3,1,3,287681),(232,'2019-02-01',3,1,4,95987),(233,'2019-02-01',3,1,5,2753),(234,'2019-02-01',3,1,6,0),(235,'2019-02-01',3,1,7,0),(236,'2019-02-01',3,1,8,0),(237,'2019-02-01',3,1,9,0),(238,'2019-02-01',3,1,10,87973),(239,'2019-02-01',4,1,1,4683104),(240,'2019-02-01',4,1,2,9156862),(241,'2019-02-01',4,1,3,87154),(242,'2019-02-01',4,1,4,263955),(243,'2019-02-01',4,1,5,457641),(244,'2019-02-01',4,1,6,13008),(245,'2019-02-01',4,1,7,0),(246,'2019-02-01',4,1,8,36833),(247,'2019-02-01',4,1,9,21522),(248,'2019-02-01',4,1,10,227631),(249,'2019-02-01',5,1,1,3120390),(250,'2019-02-01',5,1,2,0),(251,'2019-02-01',5,1,3,-951),(252,'2019-02-01',5,1,4,250210),(253,'2019-02-01',5,1,5,53440),(254,'2019-02-01',5,1,6,0),(255,'2019-02-01',5,1,7,0),(256,'2019-02-01',5,1,8,0),(257,'2019-02-01',5,1,9,0),(258,'2019-02-01',5,1,10,6027),(259,'2019-02-01',6,1,1,4340094),(260,'2019-02-01',6,1,2,6549211),(261,'2019-02-01',6,1,3,21862),(262,'2019-02-01',6,1,4,41087),(263,'2019-02-01',6,1,5,290272),(264,'2019-02-01',6,1,6,31605),(265,'2019-02-01',6,1,7,0),(266,'2019-02-01',6,1,8,0),(267,'2019-02-01',6,1,9,0),(268,'2019-02-01',6,1,10,77785),(269,'2019-02-01',7,1,1,17888276),(270,'2019-02-01',7,1,2,0),(271,'2019-02-01',7,1,3,2091608),(272,'2019-02-01',7,1,4,380825),(273,'2019-02-01',7,1,5,82757),(274,'2019-02-01',7,1,6,79559),(275,'2019-02-01',7,1,7,0),(276,'2019-02-01',7,1,8,0),(277,'2019-02-01',7,1,9,4761),(278,'2019-02-01',7,1,10,496200);
/*!40000 ALTER TABLE `sales_sum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `login` varchar(30) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(45) NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `role_id_key_idx` (`role_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Калошина Елена Витальевна','kaloshina.ev','670b1b45a4cf3db03a72106e6f91734b','kaloshina.ev@metallprofil.ru',1),(2,'Епанешникова Елена Владимировна','epaneshnikova.ev','123456789','epaneshnikova.ev@metallprofill.ru',1),(3,'Масленников Андрей Николаевич','maslennikov.an','123456789','maslennikov.an@metallprofill.ru',2),(4,'Губин Максим Николаевич','gubin.mn','25f9e794323b453885f5181f1b624d0b','gubin.mn@metallprofil.ru',4),(5,'Калошина Ярина Кириловна','kaloshina.yk','0b5de470bdace90bd6cfb2541eb79f99','yarinakaloshina@gmail.com',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `value_added_tax_sum`
--

DROP TABLE IF EXISTS `value_added_tax_sum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `value_added_tax_sum` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `organization_unit_id` int NOT NULL,
  `currency_id` int NOT NULL,
  `product_group_id` int NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `date_UNIQUE` (`date`,`organization_unit_id`,`product_group_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `vat_currency_idx` (`currency_id`),
  KEY `vat_organization_unit_idx` (`organization_unit_id`),
  KEY `vat_product_group_idx` (`product_group_id`),
  CONSTRAINT `vat_currency` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`id`),
  CONSTRAINT `vat_organization_unit` FOREIGN KEY (`organization_unit_id`) REFERENCES `organization_unit` (`id`),
  CONSTRAINT `vat_product_group` FOREIGN KEY (`product_group_id`) REFERENCES `product_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=279 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `value_added_tax_sum`
--

LOCK TABLES `value_added_tax_sum` WRITE;
/*!40000 ALTER TABLE `value_added_tax_sum` DISABLE KEYS */;
INSERT INTO `value_added_tax_sum` VALUES (1,'2018-01-01',1,1,1,1041241),(2,'2018-01-01',1,1,2,278292),(3,'2018-01-01',1,1,3,20561),(4,'2018-01-01',1,1,4,34019),(5,'2018-01-01',1,1,5,28979),(6,'2018-01-01',1,1,6,6716),(7,'2018-01-01',1,1,7,0),(8,'2018-01-01',1,1,8,68132),(9,'2018-01-01',1,1,9,3418),(10,'2018-01-01',1,1,10,71220),(11,'2018-01-01',2,1,1,964136),(12,'2018-01-01',2,1,2,1300933),(13,'2018-01-01',2,1,3,30157),(14,'2018-01-01',2,1,4,54063),(15,'2018-01-01',2,1,5,41451),(16,'2018-01-01',2,1,6,6451),(17,'2018-01-01',2,1,7,0),(18,'2018-01-01',2,1,8,26072),(19,'2018-01-01',2,1,9,0),(20,'2018-01-01',2,1,10,21821),(21,'2018-01-01',3,1,1,278692),(22,'2018-01-01',3,1,2,0),(23,'2018-01-01',3,1,3,40022),(24,'2018-01-01',3,1,4,23532),(25,'2018-01-01',3,1,5,5150),(26,'2018-01-01',3,1,6,3415),(27,'2018-01-01',3,1,7,0),(28,'2018-01-01',3,1,8,0),(29,'2018-01-01',3,1,9,0),(30,'2018-01-01',3,1,10,8640),(31,'2018-01-01',4,1,1,244707),(32,'2018-01-01',4,1,2,0),(33,'2018-01-01',4,1,3,70956),(34,'2018-01-01',4,1,4,16944),(35,'2018-01-01',4,1,5,2563),(36,'2018-01-01',4,1,6,0),(37,'2018-01-01',4,1,7,0),(38,'2018-01-01',4,1,8,0),(39,'2018-01-01',4,1,9,0),(40,'2018-01-01',4,1,10,31741),(41,'2018-01-01',5,1,1,114985),(42,'2018-01-01',5,1,2,0),(43,'2018-01-01',5,1,3,3379),(44,'2018-01-01',5,1,4,1253),(45,'2018-01-01',5,1,5,5308),(46,'2018-01-01',5,1,6,103),(47,'2018-01-01',5,1,7,0),(48,'2018-01-01',5,1,8,0),(49,'2018-01-01',5,1,9,0),(50,'2018-01-01',5,1,10,7613),(51,'2018-01-01',6,1,1,469626),(52,'2018-01-01',6,1,2,229141),(53,'2018-01-01',6,1,3,3607),(54,'2018-01-01',6,1,4,5468),(55,'2018-01-01',6,1,5,12142),(56,'2018-01-01',6,1,6,8153),(57,'2018-01-01',6,1,7,0),(58,'2018-01-01',6,1,8,36734),(59,'2018-01-01',6,1,9,2607),(60,'2018-01-01',7,1,1,702922),(61,'2018-01-01',7,1,2,0),(62,'2018-01-01',7,1,3,74508),(63,'2018-01-01',7,1,4,13413),(64,'2018-01-01',7,1,5,38089),(65,'2018-01-01',7,1,6,4377),(66,'2018-01-01',7,1,7,0),(67,'2018-01-01',7,1,8,0),(68,'2018-01-01',7,1,9,6565),(69,'2018-01-01',7,1,10,18741),(70,'2018-02-01',1,1,1,1599910),(71,'2018-02-01',1,1,2,1267291),(72,'2018-02-01',1,1,3,116649),(73,'2018-02-01',1,1,4,81652),(74,'2018-02-01',1,1,5,85638),(75,'2018-02-01',1,1,6,5970),(76,'2018-02-01',1,1,7,0),(77,'2018-02-01',1,1,8,44371),(78,'2018-02-01',1,1,9,29835),(79,'2018-02-01',1,1,10,102257),(80,'2018-02-01',2,1,1,984757),(81,'2018-02-01',2,1,2,1528522),(82,'2018-02-01',2,1,3,61802),(83,'2018-02-01',2,1,4,70180),(84,'2018-02-01',2,1,5,37938),(85,'2018-02-01',2,1,6,588),(86,'2018-02-01',2,1,7,0),(87,'2018-02-01',2,1,8,162735),(88,'2018-02-01',2,1,9,0),(89,'2018-02-01',2,1,10,14784),(90,'2018-02-01',3,1,1,568644),(91,'2018-02-01',3,1,2,0),(92,'2018-02-01',3,1,3,22161),(93,'2018-02-01',3,1,4,16035),(94,'2018-02-01',3,1,5,8315),(95,'2018-02-01',3,1,6,2717),(96,'2018-02-01',3,1,7,0),(97,'2018-02-01',3,1,8,0),(98,'2018-02-01',3,1,9,0),(99,'2018-02-01',3,1,10,23212),(100,'2018-02-01',4,1,1,317700),(101,'2018-02-01',4,1,2,68369),(102,'2018-02-01',4,1,3,8052),(103,'2018-02-01',4,1,4,55075),(104,'2018-02-01',4,1,5,9049),(105,'2018-02-01',4,1,6,5596),(106,'2018-02-01',4,1,7,0),(107,'2018-02-01',4,1,8,37720),(108,'2018-02-01',4,1,9,0),(109,'2018-02-01',4,1,10,30768),(110,'2018-02-01',5,1,1,575703),(111,'2018-02-01',5,1,2,0),(112,'2018-02-01',5,1,3,20999),(113,'2018-02-01',5,1,4,17431),(114,'2018-02-01',5,1,5,7008),(115,'2018-02-01',5,1,6,74),(116,'2018-02-01',5,1,7,0),(117,'2018-02-01',5,1,8,1858),(118,'2018-02-01',5,1,9,0),(119,'2018-02-01',6,1,1,697130),(120,'2018-02-01',6,1,2,518823),(121,'2018-02-01',6,1,3,75),(122,'2018-02-01',6,1,4,15359),(123,'2018-02-01',6,1,5,134148),(124,'2018-02-01',6,1,6,3072),(125,'2018-02-01',6,1,7,0),(126,'2018-02-01',6,1,8,70390),(127,'2018-02-01',6,1,9,0),(128,'2018-02-01',6,1,10,36361),(129,'2018-02-01',7,1,1,1494364),(130,'2018-02-01',7,1,2,702830),(131,'2018-02-01',7,1,3,164251),(132,'2018-02-01',7,1,4,71101),(133,'2018-02-01',7,1,5,17233),(134,'2018-02-01',7,1,6,6291),(135,'2018-02-01',7,1,7,0),(136,'2018-02-01',7,1,8,0),(137,'2018-02-01',7,1,9,16838),(138,'2018-02-01',7,1,10,35618),(139,'2019-01-01',1,1,1,1657507),(140,'2019-01-01',1,1,2,765738),(141,'2019-01-01',1,1,3,62311),(142,'2019-01-01',1,1,4,69438),(143,'2019-01-01',1,1,5,414720),(144,'2019-01-01',1,1,6,8538),(145,'2019-01-01',1,1,7,39276),(146,'2019-01-01',1,1,8,217960),(147,'2019-01-01',1,1,9,36350),(148,'2019-01-01',1,1,10,101015),(149,'2019-01-01',2,1,1,881905),(150,'2019-01-01',2,1,2,63519),(151,'2019-01-01',2,1,3,46930),(152,'2019-01-01',2,1,4,77845),(153,'2019-01-01',2,1,5,7242),(154,'2019-01-01',2,1,6,6202),(155,'2019-01-01',2,1,7,0),(156,'2019-01-01',2,1,8,0),(157,'2019-01-01',2,1,9,1393),(158,'2019-01-01',2,1,10,9098),(159,'2019-01-01',3,1,1,209084),(160,'2019-01-01',3,1,2,0),(161,'2019-01-01',3,1,3,22082),(162,'2019-01-01',3,1,4,9202),(163,'2019-01-01',3,1,5,0),(164,'2019-01-01',3,1,6,3992),(165,'2019-01-01',3,1,7,0),(166,'2019-01-01',3,1,8,0),(167,'2019-01-01',3,1,9,0),(168,'2019-01-01',3,1,10,16853),(169,'2019-01-01',4,1,1,215776),(170,'2019-01-01',4,1,2,329980),(171,'2019-01-01',4,1,3,31885),(172,'2019-01-01',4,1,4,18406),(173,'2019-01-01',4,1,5,30034),(174,'2019-01-01',4,1,6,1093),(175,'2019-01-01',4,1,7,0),(176,'2019-01-01',4,1,8,3565),(177,'2019-01-01',4,1,9,7103),(178,'2019-01-01',4,1,10,16025),(179,'2019-01-01',5,1,1,190275),(180,'2019-01-01',5,1,2,302890),(181,'2019-01-01',5,1,3,31445),(182,'2019-01-01',5,1,4,12790),(183,'2019-01-01',5,1,5,171243),(184,'2019-01-01',5,1,6,3882),(185,'2019-01-01',5,1,7,0),(186,'2019-01-01',5,1,8,21229),(187,'2019-01-01',5,1,9,20376),(188,'2019-01-01',5,1,10,77784),(189,'2019-01-01',6,1,1,338211),(190,'2019-01-01',6,1,2,121382),(191,'2019-01-01',6,1,3,539),(192,'2019-01-01',6,1,4,8286),(193,'2019-01-01',6,1,5,27685),(194,'2019-01-01',6,1,6,1236),(195,'2019-01-01',6,1,7,0),(196,'2019-01-01',6,1,8,0),(197,'2019-01-01',6,1,9,0),(198,'2019-01-01',6,1,10,16835),(199,'2019-01-01',7,1,1,1239215),(200,'2019-01-01',7,1,2,380187),(201,'2019-01-01',7,1,3,152772),(202,'2019-01-01',7,1,4,34288),(203,'2019-01-01',7,1,5,11813),(204,'2019-01-01',7,1,6,6236),(205,'2019-01-01',7,1,7,0),(206,'2019-01-01',7,1,8,0),(207,'2019-01-01',7,1,9,0),(208,'2019-01-01',7,1,10,9593),(209,'2019-02-01',1,1,1,1417454),(210,'2019-02-01',1,1,2,1593678),(211,'2019-02-01',1,1,3,82657),(212,'2019-02-01',1,1,4,51929),(213,'2019-02-01',1,1,5,95529),(214,'2019-02-01',1,1,6,13885),(215,'2019-02-01',1,1,7,0),(216,'2019-02-01',1,1,8,73477),(217,'2019-02-01',1,1,9,40547),(218,'2019-02-01',1,1,10,103398),(219,'2019-02-01',2,1,1,1358479),(220,'2019-02-01',2,1,2,900460),(221,'2019-02-01',2,1,3,55963),(222,'2019-02-01',2,1,4,66296),(223,'2019-02-01',2,1,5,4722),(224,'2019-02-01',2,1,6,4283),(225,'2019-02-01',2,1,7,0),(226,'2019-02-01',2,1,8,127133),(227,'2019-02-01',2,1,9,10412),(228,'2019-02-01',2,1,10,13222),(229,'2019-02-01',3,1,1,292929),(230,'2019-02-01',3,1,2,112472),(231,'2019-02-01',3,1,3,30823),(232,'2019-02-01',3,1,4,10284),(233,'2019-02-01',3,1,5,295),(234,'2019-02-01',3,1,6,0),(235,'2019-02-01',3,1,7,0),(236,'2019-02-01',3,1,8,0),(237,'2019-02-01',3,1,9,0),(238,'2019-02-01',3,1,10,9426),(239,'2019-02-01',4,1,1,501761),(240,'2019-02-01',4,1,2,981092),(241,'2019-02-01',4,1,3,9338),(242,'2019-02-01',4,1,4,28281),(243,'2019-02-01',4,1,5,49033),(244,'2019-02-01',4,1,6,1394),(245,'2019-02-01',4,1,7,0),(246,'2019-02-01',4,1,8,3946),(247,'2019-02-01',4,1,9,2306),(248,'2019-02-01',4,1,10,24389),(249,'2019-02-01',5,1,1,334328),(250,'2019-02-01',5,1,2,0),(251,'2019-02-01',5,1,3,-102),(252,'2019-02-01',5,1,4,26808),(253,'2019-02-01',5,1,5,5726),(254,'2019-02-01',5,1,6,0),(255,'2019-02-01',5,1,7,0),(256,'2019-02-01',5,1,8,0),(257,'2019-02-01',5,1,9,0),(258,'2019-02-01',5,1,10,646),(259,'2019-02-01',6,1,1,465010),(260,'2019-02-01',6,1,2,701701),(261,'2019-02-01',6,1,3,2342),(262,'2019-02-01',6,1,4,4402),(263,'2019-02-01',6,1,5,31101),(264,'2019-02-01',6,1,6,3386),(265,'2019-02-01',6,1,7,0),(266,'2019-02-01',6,1,8,0),(267,'2019-02-01',6,1,9,0),(268,'2019-02-01',6,1,10,8334),(269,'2019-02-01',7,1,1,1916601),(270,'2019-02-01',7,1,2,0),(271,'2019-02-01',7,1,3,224101),(272,'2019-02-01',7,1,4,40803),(273,'2019-02-01',7,1,5,8867),(274,'2019-02-01',7,1,6,8524),(275,'2019-02-01',7,1,7,0),(276,'2019-02-01',7,1,8,0),(277,'2019-02-01',7,1,9,510),(278,'2019-02-01',7,1,10,53164);
/*!40000 ALTER TABLE `value_added_tax_sum` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-30 22:44:05