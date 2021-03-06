SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `navigator_db` DEFAULT CHARACTER SET utf8 ;
USE `navigator_db` ;

CREATE TABLE IF NOT EXISTS `navigator_db`.`nodes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `navigator_db`.`vertices` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `distance` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `navigator_db`.`vertex_connect_nodes` (
  `nodes_id` INT NOT NULL,
  `vertices_id` INT NOT NULL,
  PRIMARY KEY (`nodes_id`, `vertices_id`),
  INDEX `fk_vertex_connect_nodes_vertices1_idx` (`vertices_id` ASC) VISIBLE,
  INDEX `fk_vertex_connect_nodes_nodes1_idx` (`nodes_id` ASC) VISIBLE,
  CONSTRAINT `fk_vertex_connect_nodes_nodes1`
    FOREIGN KEY (`nodes_id`)
    REFERENCES `navigator_db`.`nodes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vertex_connect_nodes_vertices1`
    FOREIGN KEY (`vertices_id`)
    REFERENCES `navigator_db`.`vertices` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
