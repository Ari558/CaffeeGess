-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: caffegesse
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `tbl_carrito`
--

DROP TABLE IF EXISTS `tbl_carrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_carrito` (
  `idtbl_carrito` int NOT NULL AUTO_INCREMENT,
  `producto_fk` int NOT NULL,
  `usuario_fk` int NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`idtbl_carrito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_carrito`
--

LOCK TABLES `tbl_carrito` WRITE;
/*!40000 ALTER TABLE `tbl_carrito` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_carrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_detalleorden`
--

DROP TABLE IF EXISTS `tbl_detalleorden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_detalleorden` (
  `idtbl_DetalleOrden` int NOT NULL AUTO_INCREMENT,
  `producto_fk` int NOT NULL,
  `Cantidad` int NOT NULL,
  `PrecioTotal` float NOT NULL,
  `Orden_fk` int NOT NULL,
  PRIMARY KEY (`idtbl_DetalleOrden`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_detalleorden`
--

LOCK TABLES `tbl_detalleorden` WRITE;
/*!40000 ALTER TABLE `tbl_detalleorden` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_detalleorden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_factura`
--

DROP TABLE IF EXISTS `tbl_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_factura` (
  `idtbl_factura` int NOT NULL AUTO_INCREMENT,
  `TipoFactura` varchar(45) NOT NULL,
  PRIMARY KEY (`idtbl_factura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_factura`
--

LOCK TABLES `tbl_factura` WRITE;
/*!40000 ALTER TABLE `tbl_factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_menu`
--

DROP TABLE IF EXISTS `tbl_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_menu` (
  `idtbl_menu` int NOT NULL AUTO_INCREMENT,
  `Comida_fk` varchar(45) NOT NULL,
  `Bebida_fk` varchar(45) NOT NULL,
  `Postres_fk` varchar(45) NOT NULL,
  `Usuario_fk` varchar(45) NOT NULL,
  `Producto_fk` varchar(45) NOT NULL,
  PRIMARY KEY (`idtbl_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_menu`
--

LOCK TABLES `tbl_menu` WRITE;
/*!40000 ALTER TABLE `tbl_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_metodopago`
--

DROP TABLE IF EXISTS `tbl_metodopago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_metodopago` (
  `idtbl_MetodoPago` int NOT NULL AUTO_INCREMENT,
  `NombreMetodo` varchar(45) NOT NULL,
  PRIMARY KEY (`idtbl_MetodoPago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_metodopago`
--

LOCK TABLES `tbl_metodopago` WRITE;
/*!40000 ALTER TABLE `tbl_metodopago` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_metodopago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_orden`
--

DROP TABLE IF EXISTS `tbl_orden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_orden` (
  `idtbl_Orden` int NOT NULL AUTO_INCREMENT,
  `NumOrden` int NOT NULL,
  `Usuario_fk` int NOT NULL,
  `MetodoPago_fk` int NOT NULL,
  `Factura_fk` int NOT NULL,
  `FechaOrden` datetime NOT NULL,
  `EstadoOrden` varchar(45) NOT NULL,
  PRIMARY KEY (`idtbl_Orden`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_orden`
--

LOCK TABLES `tbl_orden` WRITE;
/*!40000 ALTER TABLE `tbl_orden` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_orden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_producto`
--

DROP TABLE IF EXISTS `tbl_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_producto` (
  `idtbl_Producto` int NOT NULL AUTO_INCREMENT,
  `Tipo Producto` varchar(45) NOT NULL,
  `Orden_fk` int NOT NULL,
  PRIMARY KEY (`idtbl_Producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_producto`
--

LOCK TABLES `tbl_producto` WRITE;
/*!40000 ALTER TABLE `tbl_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_registro`
--

DROP TABLE IF EXISTS `tbl_registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_registro` (
  `RegistroId` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `UsuarioId_fk` int NOT NULL,
  `Menu_fk` int NOT NULL,
  PRIMARY KEY (`RegistroId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_registro`
--

LOCK TABLES `tbl_registro` WRITE;
/*!40000 ALTER TABLE `tbl_registro` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_registro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tipoproduct`
--

DROP TABLE IF EXISTS `tbl_tipoproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_tipoproduct` (
  `idtbl_tipoproduct` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `precio` float NOT NULL,
  `tipoproduct` enum('Comidas','Bebidas','Postres') NOT NULL,
  PRIMARY KEY (`idtbl_tipoproduct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tipoproduct`
--

LOCK TABLES `tbl_tipoproduct` WRITE;
/*!40000 ALTER TABLE `tbl_tipoproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_tipoproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario`
--

DROP TABLE IF EXISTS `tbl_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_usuario` (
  `idtbl_usuario` int NOT NULL AUTO_INCREMENT,
  `NombreUsuario` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`idtbl_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario`
--

LOCK TABLES `tbl_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-11 23:05:00
