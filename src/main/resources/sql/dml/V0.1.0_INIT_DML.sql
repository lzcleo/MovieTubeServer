-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: movie_tube_db
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Dumping data for table `t_users`
--

LOCK TABLES `t_users` WRITE;
/*!40000 ALTER TABLE `t_users` DISABLE KEYS */;
INSERT INTO `t_users` VALUES (1,'admin','admin@qq.com','男','$2a$10$wMK/YiQKt9c44J2PyP11re8a4le/LEWzQm.VrWV14FmBKzeqUl2S6',1),(2,'test','test@qq.com','男','$2a$10$nvfCAVr0sytkCcyBXgiQsuRNR4iofB14DGFp1jKVRtgvMxB9LQwte',3);
/*!40000 ALTER TABLE `t_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_permission`
--

LOCK TABLES `t_permission` WRITE;
/*!40000 ALTER TABLE `t_permission` DISABLE KEYS */;
INSERT INTO `t_permission` VALUES (1,1,'movie','movie:list','list'),(2,1,'movie','movie:insert','insert'),(3,1,'movie','movie:delete','delete'),(4,1,'movie','movie:update','update'),(5,1,'comment','comment:list','list'),(6,1,'comment','comment:insert','insert'),(7,1,'comment','comment:delete','delete'),(8,1,'comment','comment:update','update'),(9,2,'movie','movie:list','list'),(10,2,'movie','movie:insert','insert'),(11,2,'movie','movie:delete','delete'),(12,2,'movie','movie:update','update'),(13,2,'comment','comment:list','list'),(14,2,'comment','comment:insert','insert'),(15,2,'comment','comment:delete','delete'),(16,2,'comment','comment:update','update'),(17,3,'movie','movie:list','list'),(18,3,'movie','movie:insert','insert'),(19,3,'movie','movie:delete','delete'),(20,3,'movie','movie:update','update'),(21,3,'comment','comment:list','list'),(22,3,'comment','comment:insert','insert'),(23,3,'comment','comment:delete','delete'),(24,3,'comment','comment:update','update');
/*!40000 ALTER TABLE `t_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER'),(3,'ROLE_TEST');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-22 18:33:39