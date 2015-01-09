-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sujet2
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sujet2` ;

-- -----------------------------------------------------
-- Schema sujet2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sujet2` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `sujet2` ;

-- -----------------------------------------------------
-- Table `sujet2`.`Member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sujet2`.`Member` ;

CREATE TABLE IF NOT EXISTS `sujet2`.`Member` (
  `memberId` INT(11) NOT NULL AUTO_INCREMENT,
  `memberEmail` VARCHAR(45) NOT NULL,
  `memberLogin` VARCHAR(45) NOT NULL,
  `memberPassword` VARCHAR(45) NOT NULL,
  `memberIsAdmin` TINYINT(1) NULL,
  `memberJoiningDate` DATE NOT NULL,
  `memberLastname` VARCHAR(45) NOT NULL,
  `memberFirstname` VARCHAR(45) NOT NULL,
  `memberBirthday` DATE NOT NULL,
  `memberNationality` VARCHAR(45) NOT NULL,
  `memberAddress` VARCHAR(255) NULL,
  `memberSex` VARCHAR(45) NULL,
  `memberProfession` VARCHAR(45) NULL,
  `memberIsSuppressed` TINYINT(1) NULL,
  PRIMARY KEY (`memberId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sujet2`.`ProjectCategory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sujet2`.`ProjectCategory` ;

CREATE TABLE IF NOT EXISTS `sujet2`.`ProjectCategory` (
  `categoryId` INT(11) NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(255) NOT NULL,
  `categoryDescription` VARCHAR(45) NULL,
  PRIMARY KEY (`categoryId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sujet2`.`Project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sujet2`.`Project` ;

CREATE TABLE IF NOT EXISTS `sujet2`.`Project` (
  `projectId` INT(11) NOT NULL AUTO_INCREMENT,
  `ProjectTitle` VARCHAR(45) NOT NULL,
  `projectFundingGoal` INT(11) NOT NULL,
  `projectCreationDate` DATE NOT NULL,
  `projectEndDate` DATE NOT NULL,
  `projectDescription` VARCHAR(2000) NOT NULL,
  `projectCategory` INT(11) NOT NULL,
  `projectIsSuppressed` TINYINT(1) NULL,
  `projectIsClosed` TINYINT(1) NULL,
  PRIMARY KEY (`projectId`),
  INDEX `fk_Project_ProjectCategory1_idx` (`projectCategory` ASC),
  CONSTRAINT `fk_Project_ProjectCategory1`
    FOREIGN KEY (`projectCategory`)
    REFERENCES `sujet2`.`ProjectCategory` (`categoryId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sujet2`.`Media`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sujet2`.`Media` ;

CREATE TABLE IF NOT EXISTS `sujet2`.`Media` (
  `mediaId` INT(11) NOT NULL AUTO_INCREMENT,
  `mediaURL` VARCHAR(255) NOT NULL,
  `mediaName` VARCHAR(45) NULL,
  `mediaDescription` VARCHAR(45) NULL,
  `Project_projectId` INT(11) NOT NULL,
  PRIMARY KEY (`mediaId`),
  INDEX `fk_Media_Project1_idx` (`Project_projectId` ASC),
  CONSTRAINT `fk_Media_Project1`
    FOREIGN KEY (`Project_projectId`)
    REFERENCES `sujet2`.`Project` (`projectId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sujet2`.`Reward`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sujet2`.`Reward` ;

CREATE TABLE IF NOT EXISTS `sujet2`.`Reward` (
  `rewardId` INT(11) NOT NULL AUTO_INCREMENT,
  `rewardName` VARCHAR(45) NOT NULL,
  `rewardDescription` VARCHAR(45) NOT NULL,
  `rewardMinPrice` INT(11) NULL,
  `Project_projectId` INT(11) NULL,
  PRIMARY KEY (`rewardId`),
  INDEX `fk_Reward_Project1_idx` (`Project_projectId` ASC),
  CONSTRAINT `fk_Reward_Project1`
    FOREIGN KEY (`Project_projectId`)
    REFERENCES `sujet2`.`Project` (`projectId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sujet2`.`PaymentData`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sujet2`.`PaymentData` ;

CREATE TABLE IF NOT EXISTS `sujet2`.`PaymentData` (
  `paymentDataID` INT(11) NOT NULL AUTO_INCREMENT,
  `paypalAuthorization` VARCHAR(45) NULL,
  `creditcard` VARCHAR(45) NULL,
  PRIMARY KEY (`paymentDataID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sujet2`.`Member_backs_Project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sujet2`.`Member_backs_Project` ;

CREATE TABLE IF NOT EXISTS `sujet2`.`Member_backs_Project` (
  `backerId` INT(11) NOT NULL,
  `projectId` INT(11) NULL,
  `Reward_rewardId` INT(11) NULL,
  `pledgedEuros` INT(11) NOT NULL,
  `backingDate` DATE NOT NULL,
  PRIMARY KEY (`backerId`, `projectId`, `Reward_rewardId`),
  INDEX `fk_Member_has_Project1_Project1_idx` (`projectId` ASC),
  INDEX `fk_Member_has_Project1_Member1_idx` (`backerId` ASC),
  INDEX `fk_Member_backs_Project_Reward1_idx` (`Reward_rewardId` ASC),
  CONSTRAINT `fk_Member_has_Project1_Member1`
    FOREIGN KEY (`backerId`)
    REFERENCES `sujet2`.`Member` (`memberId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Member_has_Project1_Project1`
    FOREIGN KEY (`projectId`)
    REFERENCES `sujet2`.`Project` (`projectId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Member_backs_Project_Reward1`
    FOREIGN KEY (`Reward_rewardId`)
    REFERENCES `sujet2`.`Reward` (`rewardId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sujet2`.`Member_creates_Project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sujet2`.`Member_creates_Project` ;

CREATE TABLE IF NOT EXISTS `sujet2`.`Member_creates_Project` (
  `creatorId` INT(11) NOT NULL,
  `projectId` INT(11) NULL,
  PRIMARY KEY (`creatorId`, `projectId`),
  INDEX `fk_Member_has_Project_Project1_idx` (`projectId` ASC),
  INDEX `fk_Member_has_Project_Member1_idx` (`creatorId` ASC),
  CONSTRAINT `fk_Member_has_Project_Member1`
    FOREIGN KEY (`creatorId`)
    REFERENCES `sujet2`.`Member` (`memberId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Member_has_Project_Project1`
    FOREIGN KEY (`projectId`)
    REFERENCES `sujet2`.`Project` (`projectId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
