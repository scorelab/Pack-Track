SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE DATABASE IF NOT EXISTS `pack_track` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `pack_track`;

CREATE TABLE IF NOT EXISTS `category` (
  `catID` int(5) NOT NULL AUTO_INCREMENT,
  `catName` varchar(20) NOT NULL,
  `unitCost` int(5) NOT NULL,
  `addBy` varchar(100) NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`catID`),
  UNIQUE KEY `catID_UNIQUE` (`catID`),
  UNIQUE KEY `catName_UNIQUE` (`catName`),
  KEY `categoryAdmin_idx` (`addBy`),
  KEY `categoryDeleteBy_idx` (`deleteBy`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `customer` (
  `custID` int(6) NOT NULL AUTO_INCREMENT,
  `custName` varchar(30) NOT NULL,
  `custEmail` varchar(30) DEFAULT NULL,
  `custMobile` varchar(10) DEFAULT NULL,
  `custTel` varchar(10) DEFAULT NULL,
  `custAddress` varchar(45) DEFAULT NULL,
  `custNIC` varchar(10) DEFAULT NULL,
  `addBy` varchar(100) NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`custID`),
  UNIQUE KEY `custID_UNIQUE` (`custID`),
  UNIQUE KEY `custNIC_UNIQUE` (`custNIC`),
  UNIQUE KEY `custEmail_UNIQUE` (`custEmail`),
  UNIQUE KEY `custMobile_UNIQUE` (`custMobile`),
  UNIQUE KEY `custTel_UNIQUE` (`custTel`),
  UNIQUE KEY `custAddress_UNIQUE` (`custAddress`),
  KEY `customerAdmin_idx` (`addBy`),
  KEY `custAddUser_idx` (`addBy`),
  KEY `custDeleteBy_idx` (`deleteBy`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `device` (
  `devID` int(11) NOT NULL AUTO_INCREMENT,
  `imei` varchar(15) NOT NULL,
  `assignTo` varchar(100) DEFAULT NULL,
  `addBy` varchar(100) NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`devID`),
  UNIQUE KEY `imei_UNIQUE` (`imei`),
  UNIQUE KEY `devID_UNIQUE` (`devID`),
  KEY `FAdmin_idx` (`addBy`),
  KEY `deviceUser_idx` (`assignTo`),
  KEY `deviceDeleteBy_idx` (`deleteBy`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `parcel` (
  `parcelID` varchar(5) NOT NULL,
  `weight` int(3) NOT NULL,
  `currentStation` int(5) NOT NULL,
  `sender` int(6) NOT NULL,
  `receiver` int(6) NOT NULL,
  `starts` int(5) NOT NULL,
  `destination` int(5) NOT NULL,
  `qr` varchar(45) NOT NULL,
  `totalCost` int(5) NOT NULL,
  `express` varchar(1) NOT NULL,
  `dateReceived` datetime NOT NULL,
  `dateDeliverd` datetime NOT NULL,
  `addBy` varchar(100) NOT NULL,
  `train` int(11) DEFAULT NULL,
  `released` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`parcelID`),
  UNIQUE KEY `parcelID_UNIQUE` (`parcelID`),
  KEY `st_idx` (`starts`),
  KEY `stationFK1_idx` (`starts`),
  KEY `senderFK_idx` (`sender`),
  KEY `receiverFK_idx` (`receiver`),
  KEY `addByUser_idx` (`addBy`),
  KEY `startStation_idx` (`starts`),
  KEY `finish_idx` (`destination`),
  KEY `current_idx` (`currentStation`),
  KEY `assignTrain_idx` (`train`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `station` (
  `stationID` int(5) NOT NULL AUTO_INCREMENT,
  `stationName` varchar(20) NOT NULL,
  `telNo` varchar(10) NOT NULL,
  `addBy` varchar(100) NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`stationID`),
  UNIQUE KEY `stationID_UNIQUE` (`stationID`),
  UNIQUE KEY `telNo_UNIQUE` (`telNo`),
  KEY `stationAdmin_idx` (`addBy`),
  KEY `stationDeleteBy_idx` (`deleteBy`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

INSERT INTO `station` (`stationID`, `stationName`, `telNo`, `addBy`, `deleted`, `deleteBy`) VALUES
(1, 'colombo_fort', '112054468', 'Rand', 0, NULL),
(2, 'kandy', '0112054486', 'Rand', 0, NULL);

CREATE TABLE IF NOT EXISTS `train` (
  `trainID` int(11) NOT NULL AUTO_INCREMENT,
  `trainName` varchar(45) NOT NULL,
  `start` int(5) NOT NULL,
  `finish` int(5) NOT NULL,
  `addBy` varchar(100) NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`trainID`),
  UNIQUE KEY `trainID_UNIQUE` (`trainID`),
  KEY `trainAdmin_idx` (`addBy`),
  KEY `startStation_idx` (`start`),
  KEY `finishStation_idx` (`finish`),
  KEY `trainDeleteBy_idx` (`deleteBy`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

INSERT INTO `train` (`trainID`, `trainName`, `start`, `finish`, `addBy`, `deleted`, `deleteBy`) VALUES
(1, 'Podi_Manike', 1, 2, 'Rand', 0, NULL);

CREATE TABLE IF NOT EXISTS `user` (
  `UserName` varchar(100) NOT NULL DEFAULT '',
  `password` varchar(100) NOT NULL,
  `designation` varchar(100) NOT NULL,
  `role` varchar(100) DEFAULT NULL,
  `home_page` varchar(150) DEFAULT NULL,
  `shed` varchar(40) DEFAULT NULL,
  `sub_dept` varchar(20) DEFAULT NULL,
  `nic_number` varchar(30) DEFAULT NULL,
  `addBy` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`UserName`),
  UNIQUE KEY `UserName` (`UserName`),
  UNIQUE KEY `nic_number` (`nic_number`),
  KEY `userAddBy_idx` (`addBy`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `user` (`UserName`, `password`, `designation`, `role`, `home_page`, `shed`, `sub_dept`, `nic_number`, `addBy`) VALUES
('Lahiru', 'd74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1', 'sith', 'pith', 'gdgd', 'ddd', 'dd', '123456789V', 'Rand'),
('Rand', 'd74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1', 'jil', 'bil', 'gdg', 'gggg', 'gg', '911672375V', 'Rand');

CREATE TABLE IF NOT EXISTS `user_detail` (
  `UserName` varchar(100) NOT NULL,
  `name` varchar(45) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `station` int(5) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`UserName`),
  KEY `userDetail_idx` (`UserName`),
  KEY `userStation_idx` (`station`),
  KEY `deleteByUser_idx` (`deleteBy`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `user_detail` (`UserName`, `name`, `Email`, `station`, `phone`, `deleted`, `deleteBy`) VALUES
('Lahiru', 'Rangana', 'lahiru.rangana54@gmail.com', 2, '754129659', 0, NULL),
('Rand', 'Randika', 'lahiru.rangana77@gmail.com', 1, '713823479', 0, NULL);

CREATE TABLE IF NOT EXISTS `user_privilege` (
  `User_Name` varchar(100) NOT NULL,
  `add_user` tinyint(1) DEFAULT '0',
  `remove_User` tinyint(1) DEFAULT '0',
  `add_station` tinyint(1) DEFAULT '0',
  `remove_station` tinyint(1) DEFAULT '0',
  `add_train` tinyint(1) DEFAULT '0',
  `remove_train` tinyint(1) DEFAULT '0',
  `add_category` tinyint(1) DEFAULT '0',
  `remove_category` tinyint(1) DEFAULT '0',
  `add_customer` tinyint(1) DEFAULT '0',
  `remove_customer` tinyint(1) DEFAULT '0',
  `add_parcel` tinyint(1) DEFAULT '0',
  `release_parcel` tinyint(1) DEFAULT '0',
  `confirm_arrival` tinyint(1) DEFAULT '0',
  `check_upcoming_parcel` tinyint(1) DEFAULT '0',
  `select_train` tinyint(1) DEFAULT '0',
  `add_device` tinyint(1) DEFAULT '0',
  `remove_device` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`User_Name`),
  KEY `userPrivilige_idx` (`User_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `user_privilege` (`User_Name`, `add_user`, `remove_User`, `add_station`, `remove_station`, `add_train`, `remove_train`, `add_category`, `remove_category`, `add_customer`, `remove_customer`, `add_parcel`, `release_parcel`, `confirm_arrival`, `check_upcoming_parcel`, `select_train`, `add_device`, `remove_device`) VALUES
('Lahiru', 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('Rand', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);


ALTER TABLE `category`
  ADD CONSTRAINT `categoryAddBy` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `categoryDeleteBy` FOREIGN KEY (`deleteBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `customer`
  ADD CONSTRAINT `custAddBy` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `custDeleteBy` FOREIGN KEY (`deleteBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `device`
  ADD CONSTRAINT `deviceAddBy` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON UPDATE CASCADE,
  ADD CONSTRAINT `deviceDeleteBy` FOREIGN KEY (`deleteBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `deviceUser` FOREIGN KEY (`assignTo`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `parcel`
  ADD CONSTRAINT `assignTrain` FOREIGN KEY (`train`) REFERENCES `train` (`trainID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `addByUser` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `currentS` FOREIGN KEY (`currentStation`) REFERENCES `station` (`stationID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `finish` FOREIGN KEY (`destination`) REFERENCES `station` (`stationID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `receiverFK` FOREIGN KEY (`receiver`) REFERENCES `customer` (`custID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `senderFK` FOREIGN KEY (`sender`) REFERENCES `customer` (`custID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `starts` FOREIGN KEY (`starts`) REFERENCES `station` (`stationID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `station`
  ADD CONSTRAINT `stationAdmin` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `stationDeleteBy` FOREIGN KEY (`deleteBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `train`
  ADD CONSTRAINT `finishStation` FOREIGN KEY (`finish`) REFERENCES `station` (`stationID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `startStation` FOREIGN KEY (`start`) REFERENCES `station` (`stationID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `trainAdmin` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `trainDeleteBy` FOREIGN KEY (`deleteBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `user`
  ADD CONSTRAINT `userAddBy` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `user_detail`
  ADD CONSTRAINT `deleteByUser` FOREIGN KEY (`deleteBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `userDetail` FOREIGN KEY (`UserName`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `userStation` FOREIGN KEY (`station`) REFERENCES `station` (`stationID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `user_privilege`
  ADD CONSTRAINT `userPrivilige` FOREIGN KEY (`User_Name`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
