-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pattachitra
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `box_number` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `house_number` varchar(255) DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `date_of_birth` datetime(6) DEFAULT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_roles`
--

DROP TABLE IF EXISTS `account_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_roles` (
  `account_id` bigint NOT NULL,
  `roles_id` bigint NOT NULL,
  KEY `FK70s9enq5d1oywl7v8vis5ke5w` (`roles_id`),
  KEY `FKtp61eta5i06bug3w1qr6286uf` (`account_id`),
  CONSTRAINT `FK70s9enq5d1oywl7v8vis5ke5w` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKtp61eta5i06bug3w1qr6286uf` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_roles`
--

LOCK TABLES `account_roles` WRITE;
/*!40000 ALTER TABLE `account_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `ad_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `address_line_one` varchar(255) NOT NULL,
  `address_line_two` varchar(255) NOT NULL,
  `city_village` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `landmark` varchar(255) NOT NULL,
  `pe_id` bigint DEFAULT NULL,
  `state` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `zipcode` varchar(255) NOT NULL,
  PRIMARY KEY (`ad_id`),
  KEY `FKkfx142sdliilfsugydhdwxow5` (`pe_id`),
  CONSTRAINT `FKkfx142sdliilfsugydhdwxow5` FOREIGN KEY (`pe_id`) REFERENCES `person` (`pe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_product`
--

DROP TABLE IF EXISTS `admin_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_product` (
  `adpr_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `mrp` float DEFAULT NULL,
  `discount_on_mrp` float DEFAULT NULL,
  `model` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `product_status` varchar(255) NOT NULL,
  `sell_price` float DEFAULT NULL,
  `adprde_id` bigint DEFAULT NULL,
  `adprfe_id` bigint DEFAULT NULL,
  `adprpr_id` bigint DEFAULT NULL,
  `adprsp_id` bigint DEFAULT NULL,
  `adprst_id` bigint DEFAULT NULL,
  PRIMARY KEY (`adpr_id`),
  KEY `FKlrl5vlvroor392i29up3kaqq3` (`adprde_id`),
  KEY `FKt6h0k0xmtecgctj9mdouf7snw` (`adprfe_id`),
  KEY `FKie1kw06j84rb6wbsoxp73to4f` (`adprpr_id`),
  KEY `FK77d0ptqldkxt3ik4uabt037s5` (`adprsp_id`),
  KEY `FKk6vokqcvp04yikv196baxmsrf` (`adprst_id`),
  CONSTRAINT `FK77d0ptqldkxt3ik4uabt037s5` FOREIGN KEY (`adprsp_id`) REFERENCES `admin_product_specification` (`adprsp_id`),
  CONSTRAINT `FKie1kw06j84rb6wbsoxp73to4f` FOREIGN KEY (`adprpr_id`) REFERENCES `admin_product_price` (`adprpr_id`),
  CONSTRAINT `FKk6vokqcvp04yikv196baxmsrf` FOREIGN KEY (`adprst_id`) REFERENCES `admin_product_stock` (`adprst_id`),
  CONSTRAINT `FKlrl5vlvroor392i29up3kaqq3` FOREIGN KEY (`adprde_id`) REFERENCES `admin_product_description` (`adprde_id`),
  CONSTRAINT `FKt6h0k0xmtecgctj9mdouf7snw` FOREIGN KEY (`adprfe_id`) REFERENCES `admin_product_feature` (`adprfe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_product`
--

LOCK TABLES `admin_product` WRITE;
/*!40000 ALTER TABLE `admin_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_product_description`
--

DROP TABLE IF EXISTS `admin_product_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_product_description` (
  `adprde_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `long_desc` longblob,
  `short_desc` longblob,
  PRIMARY KEY (`adprde_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_product_description`
--

LOCK TABLES `admin_product_description` WRITE;
/*!40000 ALTER TABLE `admin_product_description` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_product_description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_product_feature`
--

DROP TABLE IF EXISTS `admin_product_feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_product_feature` (
  `adprfe_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `feature` longblob NOT NULL,
  `highlight` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`adprfe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_product_feature`
--

LOCK TABLES `admin_product_feature` WRITE;
/*!40000 ALTER TABLE `admin_product_feature` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_product_feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_product_filter`
--

DROP TABLE IF EXISTS `admin_product_filter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_product_filter` (
  `adprfi_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `filter` varchar(255) NOT NULL,
  PRIMARY KEY (`adprfi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_product_filter`
--

LOCK TABLES `admin_product_filter` WRITE;
/*!40000 ALTER TABLE `admin_product_filter` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_product_filter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_product_price`
--

DROP TABLE IF EXISTS `admin_product_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_product_price` (
  `adprpr_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `mrp` float DEFAULT NULL,
  `discount_on_mrp` float DEFAULT NULL,
  `sell_price` float DEFAULT NULL,
  PRIMARY KEY (`adprpr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_product_price`
--

LOCK TABLES `admin_product_price` WRITE;
/*!40000 ALTER TABLE `admin_product_price` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_product_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_product_specification`
--

DROP TABLE IF EXISTS `admin_product_specification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_product_specification` (
  `adprsp_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `info` longblob,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adprsp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_product_specification`
--

LOCK TABLES `admin_product_specification` WRITE;
/*!40000 ALTER TABLE `admin_product_specification` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_product_specification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_product_stock`
--

DROP TABLE IF EXISTS `admin_product_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_product_stock` (
  `adprst_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `end_date` datetime(6) NOT NULL,
  `expected_date` datetime(6) NOT NULL,
  `is_available` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `quantity` int NOT NULL,
  `start_date` datetime(6) NOT NULL,
  `stock_status` varchar(255) NOT NULL,
  PRIMARY KEY (`adprst_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_product_stock`
--

LOCK TABLES `admin_product_stock` WRITE;
/*!40000 ALTER TABLE `admin_product_stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_product_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billing_address`
--

DROP TABLE IF EXISTS `billing_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billing_address` (
  `biad_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `address_line_one` varchar(255) DEFAULT NULL,
  `address_line_two` varchar(255) DEFAULT NULL,
  `city_village` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `landmark` varchar(255) DEFAULT NULL,
  `od_id` bigint DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`biad_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billing_address`
--

LOCK TABLES `billing_address` WRITE;
/*!40000 ALTER TABLE `billing_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `billing_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `category_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2rqqpgnve6gu3ar7prin5qm0i` (`isbn`),
  KEY `FKam9riv8y6rjwkua1gapdfew4j` (`category_id`),
  CONSTRAINT `FKam9riv8y6rjwkua1gapdfew4j` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `ca_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `cart_status` varchar(255) NOT NULL,
  `pe_id` bigint NOT NULL,
  PRIMARY KEY (`ca_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery` (
  `de_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `delivery_status` varchar(255) NOT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `expected_date` datetime(6) DEFAULT NULL,
  `is_delivered` bit(1) DEFAULT NULL,
  `packaging_status` varchar(255) DEFAULT NULL,
  `pr_ids` varchar(255) DEFAULT NULL,
  `product_health_status` varchar(255) DEFAULT NULL,
  `sh_id` bigint DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `dead_id` bigint DEFAULT NULL,
  PRIMARY KEY (`de_id`),
  KEY `FKd4boqr4fgj2ixrjbr3v5ktbd9` (`dead_id`),
  CONSTRAINT `FKd4boqr4fgj2ixrjbr3v5ktbd9` FOREIGN KEY (`dead_id`) REFERENCES `delivery_address` (`dead_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_address`
--

DROP TABLE IF EXISTS `delivery_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_address` (
  `dead_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `address_line_one` varchar(255) DEFAULT NULL,
  `address_line_two` varchar(255) DEFAULT NULL,
  `city_village` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `de_id` bigint DEFAULT NULL,
  `landmark` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `zipcode` varchar(255) NOT NULL,
  PRIMARY KEY (`dead_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_address`
--

LOCK TABLES `delivery_address` WRITE;
/*!40000 ALTER TABLE `delivery_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `fe_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `feedback` varchar(255) NOT NULL,
  `or_ids` varchar(255) DEFAULT NULL,
  `pr_id` bigint DEFAULT NULL,
  `rating` varchar(255) NOT NULL,
  `review` varchar(255) NOT NULL,
  PRIMARY KEY (`fe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `in_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `authorized_signature` varchar(255) NOT NULL,
  `cgst` float NOT NULL,
  `cin` varchar(255) NOT NULL,
  `communication_address` varchar(255) NOT NULL,
  `customer_detail` varchar(255) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `discount` float NOT NULL,
  `grand_total` float NOT NULL,
  `gross_amount` float NOT NULL,
  `gstin` varchar(255) NOT NULL,
  `invoice_number` varchar(255) NOT NULL,
  `od_id` bigint NOT NULL,
  `order_start_date` datetime(6) NOT NULL,
  `pan` varchar(255) NOT NULL,
  `pe_id` bigint NOT NULL,
  `pr_id` bigint NOT NULL,
  `product_detail` varchar(255) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `qty` bigint NOT NULL,
  `sgst` float NOT NULL,
  `sh_id` bigint NOT NULL,
  `ship_from_address` varchar(255) NOT NULL,
  `ship_to_address` varchar(255) NOT NULL,
  `start_date` datetime(6) NOT NULL,
  `taxable_amount` float NOT NULL,
  `total_amount` float NOT NULL,
  PRIMARY KEY (`in_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opt`
--

DROP TABLE IF EXISTS `opt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opt` (
  `option_id` bigint NOT NULL AUTO_INCREMENT,
  `option_value` varchar(255) DEFAULT NULL,
  `poll_id` bigint DEFAULT NULL,
  PRIMARY KEY (`option_id`),
  KEY `FKmc600s03k6a9raj0p0kcilmxs` (`poll_id`),
  CONSTRAINT `FKmc600s03k6a9raj0p0kcilmxs` FOREIGN KEY (`poll_id`) REFERENCES `poll` (`poll_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opt`
--

LOCK TABLES `opt` WRITE;
/*!40000 ALTER TABLE `opt` DISABLE KEYS */;
/*!40000 ALTER TABLE `opt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `book_id` bigint NOT NULL,
  `order_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3aceepmpjwpo8pdn7gmjdfckq` (`book_id`),
  KEY `FKrws2q0si6oyd6il8gqe2aennc` (`order_id`),
  CONSTRAINT `FK3aceepmpjwpo8pdn7gmjdfckq` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FKrws2q0si6oyd6il8gqe2aennc` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `billing_box_number` varchar(255) DEFAULT NULL,
  `billing_city` varchar(255) DEFAULT NULL,
  `billing_country` varchar(255) DEFAULT NULL,
  `billing_house_number` varchar(255) DEFAULT NULL,
  `billing_postal_code` varchar(255) DEFAULT NULL,
  `billing_street` varchar(255) DEFAULT NULL,
  `billing_same_as_shipping` bit(1) NOT NULL,
  `delivery_date` datetime(6) DEFAULT NULL,
  `order_date` datetime(6) DEFAULT NULL,
  `shipping_box_number` varchar(255) DEFAULT NULL,
  `shipping_city` varchar(255) DEFAULT NULL,
  `shipping_country` varchar(255) DEFAULT NULL,
  `shipping_house_number` varchar(255) DEFAULT NULL,
  `shipping_postal_code` varchar(255) DEFAULT NULL,
  `shipping_street` varchar(255) DEFAULT NULL,
  `total_order_price` decimal(19,2) DEFAULT NULL,
  `account_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3c7gbsfawn58r27cf5b2km72f` (`account_id`),
  CONSTRAINT `FK3c7gbsfawn58r27cf5b2km72f` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `pa_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `od_id` bigint DEFAULT NULL,
  `offer_percentage` float DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pe_order`
--

DROP TABLE IF EXISTS `pe_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pe_order` (
  `od_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `expected_date` datetime(6) DEFAULT NULL,
  `is_delivered` bit(1) DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `pe_id` bigint DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `biad_id` bigint DEFAULT NULL,
  `pa_id` bigint DEFAULT NULL,
  PRIMARY KEY (`od_id`),
  KEY `FKnn05n66e4p1k98ct23d7warmb` (`biad_id`),
  KEY `FKgxyrgeuqgp8nafd6tl7sempst` (`pa_id`),
  KEY `FK4wrjbyca22i8xgcvhoowfeyvo` (`pe_id`),
  CONSTRAINT `FK4wrjbyca22i8xgcvhoowfeyvo` FOREIGN KEY (`pe_id`) REFERENCES `person` (`pe_id`),
  CONSTRAINT `FKgxyrgeuqgp8nafd6tl7sempst` FOREIGN KEY (`pa_id`) REFERENCES `payment` (`pa_id`),
  CONSTRAINT `FKnn05n66e4p1k98ct23d7warmb` FOREIGN KEY (`biad_id`) REFERENCES `billing_address` (`biad_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pe_order`
--

LOCK TABLES `pe_order` WRITE;
/*!40000 ALTER TABLE `pe_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `pe_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK9kwkevw5na26e6qb4cbcbxaa4` (`permission`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `pe_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `ca_id` bigint DEFAULT NULL,
  `us_id` bigint DEFAULT NULL,
  PRIMARY KEY (`pe_id`),
  KEY `FK3m9h8dnu75f0ue2nqp8456jbl` (`ca_id`),
  KEY `FKdp8n98ams22jyyifgnpslqt6n` (`us_id`),
  CONSTRAINT `FK3m9h8dnu75f0ue2nqp8456jbl` FOREIGN KEY (`ca_id`) REFERENCES `cart` (`ca_id`),
  CONSTRAINT `FKdp8n98ams22jyyifgnpslqt6n` FOREIGN KEY (`us_id`) REFERENCES `user_detail` (`us_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poll`
--

DROP TABLE IF EXISTS `poll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poll` (
  `poll_id` bigint NOT NULL AUTO_INCREMENT,
  `question` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`poll_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poll`
--

LOCK TABLES `poll` WRITE;
/*!40000 ALTER TABLE `poll` DISABLE KEYS */;
/*!40000 ALTER TABLE `poll` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `pr_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `mrp` float DEFAULT NULL,
  `ca_id` bigint DEFAULT NULL,
  `discount_on_mrp` float DEFAULT NULL,
  `is_stock_available` bit(1) NOT NULL,
  `model` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `od_id` bigint DEFAULT NULL,
  `pe_id` bigint DEFAULT NULL,
  `product_status` varchar(255) NOT NULL,
  `sell_price` float DEFAULT NULL,
  `fe_id` bigint DEFAULT NULL,
  `wi_id` bigint DEFAULT NULL,
  PRIMARY KEY (`pr_id`),
  KEY `FKsto6oh2hd0x9xjnyem14csl4k` (`fe_id`),
  KEY `FKojnu4esj76lvwgxxvn6tlkuxn` (`wi_id`),
  KEY `FKeda5kdrr58kw60yyusmxyicvg` (`pe_id`),
  KEY `FKqva1g3pxp6etddtjq3cds6654` (`od_id`),
  KEY `FK60xrjhcxbs1ejh5ly13j680by` (`ca_id`),
  CONSTRAINT `FK60xrjhcxbs1ejh5ly13j680by` FOREIGN KEY (`ca_id`) REFERENCES `cart` (`ca_id`),
  CONSTRAINT `FKeda5kdrr58kw60yyusmxyicvg` FOREIGN KEY (`pe_id`) REFERENCES `person` (`pe_id`),
  CONSTRAINT `FKojnu4esj76lvwgxxvn6tlkuxn` FOREIGN KEY (`wi_id`) REFERENCES `wish_list` (`wi_id`),
  CONSTRAINT `FKqva1g3pxp6etddtjq3cds6654` FOREIGN KEY (`od_id`) REFERENCES `pe_order` (`od_id`),
  CONSTRAINT `FKsto6oh2hd0x9xjnyem14csl4k` FOREIGN KEY (`fe_id`) REFERENCES `feedback` (`fe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt`
--

DROP TABLE IF EXISTS `receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receipt` (
  `re_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`re_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt`
--

LOCK TABLES `receipt` WRITE;
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
/*!40000 ALTER TABLE `receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_address`
--

DROP TABLE IF EXISTS `return_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `return_address` (
  `read_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `address_line_one` varchar(255) DEFAULT NULL,
  `address_line_two` varchar(255) DEFAULT NULL,
  `city_village` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `landmark` varchar(255) DEFAULT NULL,
  `re_id` bigint DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `zipcode` varchar(255) NOT NULL,
  PRIMARY KEY (`read_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_address`
--

LOCK TABLES `return_address` WRITE;
/*!40000 ALTER TABLE `return_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_product`
--

DROP TABLE IF EXISTS `return_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `return_product` (
  `re_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `expected_date` datetime(6) DEFAULT NULL,
  `is_returned` bit(1) DEFAULT NULL,
  `pr_ids` varchar(255) DEFAULT NULL,
  `return_status` varchar(255) NOT NULL,
  `sh_id` bigint DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `read_id` bigint DEFAULT NULL,
  PRIMARY KEY (`re_id`),
  KEY `FKfionvmlkaa5fhmhjeblm8j011` (`read_id`),
  CONSTRAINT `FKfionvmlkaa5fhmhjeblm8j011` FOREIGN KEY (`read_id`) REFERENCES `return_address` (`read_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_product`
--

LOCK TABLES `return_product` WRITE;
/*!40000 ALTER TABLE `return_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKbjxn5ii7v7ygwx39et0wawu0q` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permissions`
--

DROP TABLE IF EXISTS `role_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_permissions` (
  `role_id` bigint NOT NULL,
  `permissions_id` bigint NOT NULL,
  KEY `FKclluu29apreb6osx6ogt4qe16` (`permissions_id`),
  KEY `FKlodb7xh4a2xjv39gc3lsop95n` (`role_id`),
  CONSTRAINT `FKclluu29apreb6osx6ogt4qe16` FOREIGN KEY (`permissions_id`) REFERENCES `permission` (`id`),
  CONSTRAINT `FKlodb7xh4a2xjv39gc3lsop95n` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permissions`
--

LOCK TABLES `role_permissions` WRITE;
/*!40000 ALTER TABLE `role_permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping`
--

DROP TABLE IF EXISTS `shipping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipping` (
  `sh_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `courier_person` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `expected_date` datetime(6) DEFAULT NULL,
  `od_id` bigint DEFAULT NULL,
  `packaging_charge` float DEFAULT NULL,
  `pr_ids` varchar(255) DEFAULT NULL,
  `product_health_status` varchar(255) DEFAULT NULL,
  `shipping_status` varchar(255) NOT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `areturn_re_id` bigint DEFAULT NULL,
  `delivery_de_id` bigint DEFAULT NULL,
  `shad_id` bigint DEFAULT NULL,
  PRIMARY KEY (`sh_id`),
  KEY `FKn9upunen21kg62fcwu4tyloul` (`areturn_re_id`),
  KEY `FK1x7svpgdjp69goy46i5xk85dp` (`delivery_de_id`),
  KEY `FKcsel91x6ift4apgerqa5y1u0a` (`shad_id`),
  KEY `FKrg1qvbla3s0fenugy8nssohst` (`od_id`),
  CONSTRAINT `FK1x7svpgdjp69goy46i5xk85dp` FOREIGN KEY (`delivery_de_id`) REFERENCES `delivery` (`de_id`),
  CONSTRAINT `FKcsel91x6ift4apgerqa5y1u0a` FOREIGN KEY (`shad_id`) REFERENCES `shipping_address` (`shad_id`),
  CONSTRAINT `FKn9upunen21kg62fcwu4tyloul` FOREIGN KEY (`areturn_re_id`) REFERENCES `return_product` (`re_id`),
  CONSTRAINT `FKrg1qvbla3s0fenugy8nssohst` FOREIGN KEY (`od_id`) REFERENCES `pe_order` (`od_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping`
--

LOCK TABLES `shipping` WRITE;
/*!40000 ALTER TABLE `shipping` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping_address`
--

DROP TABLE IF EXISTS `shipping_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipping_address` (
  `shad_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `address_line_one` varchar(255) DEFAULT NULL,
  `address_line_two` varchar(255) DEFAULT NULL,
  `city_village` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `landmark` varchar(255) DEFAULT NULL,
  `sh_id` bigint DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `zipcode` varchar(255) NOT NULL,
  PRIMARY KEY (`shad_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping_address`
--

LOCK TABLES `shipping_address` WRITE;
/*!40000 ALTER TABLE `shipping_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipping_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_detail`
--

DROP TABLE IF EXISTS `user_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_detail` (
  `us_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `dob` datetime(6) NOT NULL,
  `email_id` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `re_password` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`us_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_detail`
--

LOCK TABLES `user_detail` WRITE;
/*!40000 ALTER TABLE `user_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `ur_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`ur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `admin` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vote` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `option_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7e840almsnlpf4u142ecjl3g1` (`option_id`),
  CONSTRAINT `FK7e840almsnlpf4u142ecjl3g1` FOREIGN KEY (`option_id`) REFERENCES `opt` (`option_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote`
--

LOCK TABLES `vote` WRITE;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wish_list`
--

DROP TABLE IF EXISTS `wish_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wish_list` (
  `wi_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_modified_by` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `wish_list_status` varchar(255) NOT NULL,
  PRIMARY KEY (`wi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wish_list`
--

LOCK TABLES `wish_list` WRITE;
/*!40000 ALTER TABLE `wish_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `wish_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-28 19:00:23
