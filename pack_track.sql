-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 29, 2014 at 04:51 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `pack_track`
--

CREATE DATABASE IF NOT EXISTS `pack_track` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `pack_track`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `adminID` int(5) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(45) NOT NULL,
  `adminAddress` varchar(45) NOT NULL,
  `adminEmail` varchar(30) NOT NULL,
  `addBy` int(5) DEFAULT NULL,
  PRIMARY KEY (`adminID`),
  UNIQUE KEY `adminID_UNIQUE` (`adminID`),
  UNIQUE KEY `adminEmail_UNIQUE` (`adminEmail`),
  KEY `FAdmin_idx` (`addBy`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `catID` int(5) NOT NULL AUTO_INCREMENT,
  `catName` varchar(20) NOT NULL,
  `unitCost` int(5) NOT NULL,
  `addBy` varchar(100) NOT NULL,
  PRIMARY KEY (`catID`),
  UNIQUE KEY `catID_UNIQUE` (`catID`),
  UNIQUE KEY `catName_UNIQUE` (`catName`),
  KEY `categoryAdmin_idx` (`addBy`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `custID` int(6) NOT NULL AUTO_INCREMENT,
  `custName` varchar(30) NOT NULL,
  `custEmail` varchar(30) DEFAULT NULL,
  `custMobile` varchar(10) DEFAULT NULL,
  `custTel` varchar(10) DEFAULT NULL,
  `custAddress` varchar(45) DEFAULT NULL,
  `custNIC` varchar(10) DEFAULT NULL,
  `addBy` varchar(100) NOT NULL,
  PRIMARY KEY (`custID`),
  UNIQUE KEY `custID_UNIQUE` (`custID`),
  UNIQUE KEY `custNIC_UNIQUE` (`custNIC`),
  UNIQUE KEY `custEmail_UNIQUE` (`custEmail`),
  UNIQUE KEY `custMobile_UNIQUE` (`custMobile`),
  UNIQUE KEY `custTel_UNIQUE` (`custTel`),
  UNIQUE KEY `custAddress_UNIQUE` (`custAddress`),
  KEY `customerAdmin_idx` (`addBy`),
  KEY `custAddUser_idx` (`addBy`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `device`
--

CREATE TABLE IF NOT EXISTS `device` (
  `devID` int(11) NOT NULL AUTO_INCREMENT,
  `imei` varchar(15) NOT NULL,
  `brand` varchar(15) DEFAULT NULL,
  `addBy` varchar(100) NOT NULL,
  PRIMARY KEY (`devID`),
  UNIQUE KEY `imei_UNIQUE` (`imei`),
  UNIQUE KEY `devID_UNIQUE` (`devID`),
  KEY `FAdmin_idx` (`addBy`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parcel`
--

CREATE TABLE IF NOT EXISTS `parcel` (
  `parcelID` varchar(5) NOT NULL,
  `weight` int(3) NOT NULL,
  `status` int(5) NOT NULL,
  `sender` int(6) NOT NULL,
  `receiver` int(6) NOT NULL,
  `start` int(5) NOT NULL,
  `destination` int(5) NOT NULL,
  `qr` varchar(45) NOT NULL,
  `totalCost` int(5) NOT NULL,
  `express` varchar(1) NOT NULL,
  `dateReceived` datetime NOT NULL,
  `dateDeliverd` datetime NOT NULL,
  `addBy` varchar(100) NOT NULL,
  PRIMARY KEY (`parcelID`),
  UNIQUE KEY `parcelID_UNIQUE` (`parcelID`),
  KEY `st_idx` (`start`),
  KEY `stationFK1_idx` (`start`),
  KEY `stationFK2_idx` (`destination`),
  KEY `stationFK_idx` (`status`),
  KEY `senderFK_idx` (`sender`),
  KEY `receiverFK_idx` (`receiver`),
  KEY `addByUser_idx` (`addBy`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `station`
--

CREATE TABLE IF NOT EXISTS `station` (
  `stationID` int(5) NOT NULL AUTO_INCREMENT,
  `stationName` varchar(20) NOT NULL,
  `telNo` varchar(10) NOT NULL,
  `addBy` varchar(100) NOT NULL,
  PRIMARY KEY (`stationID`),
  UNIQUE KEY `stationID_UNIQUE` (`stationID`),
  UNIQUE KEY `telNo_UNIQUE` (`telNo`),
  KEY `stationAdmin_idx` (`addBy`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `train`
--

CREATE TABLE IF NOT EXISTS `train` (
  `trainID` int(11) NOT NULL AUTO_INCREMENT,
  `trainName` varchar(45) NOT NULL,
  `start` int(5) NOT NULL,
  `finish` int(5) NOT NULL,
  `addBy` varchar(100) NOT NULL,
  PRIMARY KEY (`trainID`),
  UNIQUE KEY `trainID_UNIQUE` (`trainID`),
  KEY `trainAdmin_idx` (`addBy`),
  KEY `startStation_idx` (`start`),
  KEY `finishStation_idx` (`finish`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

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

-- --------------------------------------------------------

--
-- Table structure for table `user_detail`
--

CREATE TABLE IF NOT EXISTS `user_detail` (
  `UserName` varchar(100) NOT NULL,
  `name` varchar(45) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `station` int(5) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`UserName`),
  KEY `userDetail_idx` (`UserName`),
  KEY `userStation_idx` (`station`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_privilege`
--

CREATE TABLE IF NOT EXISTS `user_privilege` (
  `User_Name` varchar(100) NOT NULL,
  `add_user` int(1) DEFAULT NULL,
  `remove_User` int(1) DEFAULT NULL,
  `add_station` int(1) DEFAULT NULL,
  `remove_station` int(1) DEFAULT NULL,
  `add_train` int(1) DEFAULT NULL,
  `remove_train` int(1) DEFAULT NULL,
  `add_category` int(1) DEFAULT NULL,
  `remove_category` int(1) DEFAULT NULL,
  `add_customer` int(1) DEFAULT NULL,
  `remove_customer` int(1) DEFAULT NULL,
  `add_parcel` int(1) DEFAULT NULL,
  `release_parcel` int(1) DEFAULT NULL,
  `confirm_arrival` int(1) DEFAULT NULL,
  `check_upcoming_parcel` int(1) DEFAULT NULL,
  `select_train` int(1) DEFAULT NULL,
  PRIMARY KEY (`User_Name`),
  KEY `userPrivilige_idx` (`User_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--

ALTER TABLE `admin`
  ADD CONSTRAINT `adminAdmin` FOREIGN KEY (`addBy`) REFERENCES `admin` (`adminID`) ON UPDATE CASCADE;

--
-- Constraints for table `category`
--

ALTER TABLE `category`
  ADD CONSTRAINT `categoryAdmin` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `customer`
--

ALTER TABLE `customer`
  ADD CONSTRAINT `custAddUser` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `device`
--

ALTER TABLE `device`
  ADD CONSTRAINT `deviceAdmin` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON UPDATE CASCADE;

--
-- Constraints for table `parcel`
--

ALTER TABLE `parcel`
  ADD CONSTRAINT `addByUser` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `receiverFK` FOREIGN KEY (`receiver`) REFERENCES `customer` (`custID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `senderFK` FOREIGN KEY (`sender`) REFERENCES `customer` (`custID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `stationFK1` FOREIGN KEY (`start`) REFERENCES `station` (`stationID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `stationFK2` FOREIGN KEY (`destination`) REFERENCES `station` (`stationID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `stationFK3` FOREIGN KEY (`status`) REFERENCES `station` (`stationID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `station`
--

ALTER TABLE `station`
  ADD CONSTRAINT `stationAdmin` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `train`
--

ALTER TABLE `train`
  ADD CONSTRAINT `finishStation` FOREIGN KEY (`finish`) REFERENCES `station` (`stationID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `startStation` FOREIGN KEY (`start`) REFERENCES `station` (`stationID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `trainAdmin` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user`
--

ALTER TABLE `user`
  ADD CONSTRAINT `userAddBy` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_detail`
--

ALTER TABLE `user_detail`
  ADD CONSTRAINT `userDetail` FOREIGN KEY (`UserName`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `userStation` FOREIGN KEY (`station`) REFERENCES `station` (`stationID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_privilege`
--

ALTER TABLE `user_privilege`
  ADD CONSTRAINT `userPrivilige` FOREIGN KEY (`User_Name`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
