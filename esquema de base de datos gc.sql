-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema programacion3
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `programacion3` ;

-- -----------------------------------------------------
-- Schema programacion3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `programacion3` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `programacion3` ;

-- -----------------------------------------------------
-- Table `programacion3`.`tbl_bebida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `programacion3`.`tbl_bebida` (
  `idtbl_bebida` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Precio` FLOAT NOT NULL,
  PRIMARY KEY (`idtbl_bebida`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `programacion3`.`tbl_carrito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `programacion3`.`tbl_carrito` (
  `idtbl_carrito` INT NOT NULL AUTO_INCREMENT,
  `usuario_fk` INT NOT NULL,
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`idtbl_carrito`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `programacion3`.`tbl_clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `programacion3`.`tbl_clientes` (
  `id_clientes` INT NOT NULL AUTO_INCREMENT,
  `Nombre_Cliente` VARCHAR(45) NULL DEFAULT NULL,
  `Apellido_Cliente` VARCHAR(45) NULL DEFAULT NULL,
  `Numero_telefono` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`id_clientes`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `programacion3`.`tbl_comida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `programacion3`.`tbl_comida` (
  `idtbl_comida` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Precio` FLOAT NOT NULL,
  PRIMARY KEY (`idtbl_comida`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `programacion3`.`tbl_postres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `programacion3`.`tbl_postres` (
  `idtbl_postres` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Precio` FLOAT NOT NULL,
  PRIMARY KEY (`idtbl_postres`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `programacion3`.`tbl_orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `programacion3`.`tbl_orden` (
  `idtbl_Orden` INT NOT NULL AUTO_INCREMENT,
  `NumOrden` INT NOT NULL,
  `cliente_fk` INT NOT NULL,
  `bebida_fk` INT NULL DEFAULT NULL,
  `postres_fk` INT NULL DEFAULT NULL,
  `comida_fk` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idtbl_Orden`),
  INDEX `fk_tbl_orden_tbl_clientes1_idx` (`cliente_fk` ASC) VISIBLE,
  INDEX `fk_tbl_orden_tbl_bebida1_idx` (`bebida_fk` ASC) VISIBLE,
  INDEX `fk_tbl_orden_tbl_comida1_idx` (`comida_fk` ASC) VISIBLE,
  INDEX `fk_tbl_orden_tbl_postres1_idx` (`postres_fk` ASC) VISIBLE,
  CONSTRAINT `fk_tbl_orden_tbl_clientes1`
    FOREIGN KEY (`cliente_fk`)
    REFERENCES `programacion3`.`tbl_clientes` (`id_clientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_orden_tbl_postres1`
    FOREIGN KEY (`postres_fk`)
    REFERENCES `programacion3`.`tbl_postres` (`idtbl_postres`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_orden_tbl_comida1`
    FOREIGN KEY (`comida_fk`)
    REFERENCES `programacion3`.`tbl_comida` (`idtbl_comida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_orden_tbl_bebida1`
    FOREIGN KEY (`bebida_fk`)
    REFERENCES `programacion3`.`tbl_bebida` (`idtbl_bebida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `programacion3`.`tbl_detalleorden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `programacion3`.`tbl_detalleorden` (
  `idtbl_DetalleOrden` INT NOT NULL AUTO_INCREMENT,
  `orden_fk` INT NULL DEFAULT NULL,
  `Cantidad` INT NOT NULL,
  `PrecioTotal` FLOAT NOT NULL,
  `forma_pago` ENUM('efectivo', 'tarjeta credito') NULL DEFAULT NULL,
  `tipo_factura` ENUM('CreditoFiscal', 'FacturaComercial') CHARACTER SET 'cp1251' NULL DEFAULT NULL,
  PRIMARY KEY (`idtbl_DetalleOrden`),
  INDEX `fk_tbl_detalleorden_tbl_orden1_idx` (`orden_fk` ASC) VISIBLE,
  CONSTRAINT `fk_tbl_detalleorden_tbl_orden1`
    FOREIGN KEY (`orden_fk`)
    REFERENCES `programacion3`.`tbl_orden` (`idtbl_Orden`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `programacion3`.`tbl_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `programacion3`.`tbl_usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `NombreUsuario` VARCHAR(45) NOT NULL,
  `Pasword` VARCHAR(45) NOT NULL,
  `rol` ENUM('admin', 'usuario') NULL DEFAULT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `programacion3` ;

-- -----------------------------------------------------
-- procedure SP_I_BEBIDA
-- -----------------------------------------------------

DELIMITER $$
USE `programacion3`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_I_BEBIDA`(PNOmbre varchar(50), PPrecio float)
BEGIN
insert into tbl_bebida(Nombre,Precio) values (PNombre,PPrecio);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_I_COMIDA
-- -----------------------------------------------------

DELIMITER $$
USE `programacion3`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_I_COMIDA`(PNombre varchar(50),PPrecio float)
BEGIN
insert into tbl_comida(Nombre,Precio) values (PNombre,PPrecio);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_I_POSTRES
-- -----------------------------------------------------

DELIMITER $$
USE `programacion3`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_I_POSTRES`(PNombre varchar(50), PPrecio float)
BEGIN
insert into tbl_postres (Nombre,Precio) values (PNombre,PPrecio);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_I_USUARIO
-- -----------------------------------------------------

DELIMITER $$
USE `programacion3`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_I_USUARIO`(pusuario varchar(45),Ppassword varchar(45),prol int)
BEGIN
insert into tbl_usuario (NombreUsuario, Pasword,rol) values (pusuario,md5(Ppassword),prol );
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_S_USUARIO
-- -----------------------------------------------------

DELIMITER $$
USE `programacion3`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_S_USUARIO`(pusuario varchar(45),Ppassword varchar(45))
BEGIN
select * from tbl_usuario x where x.NombreUsuario = pusuario and x.Pasword = md5(Ppassword);
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
