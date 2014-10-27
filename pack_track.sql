-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 26, 2014 at 07:52 AM
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

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

create database `pack_track`;
use `pack_track`;

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`catID`, `catName`, `unitCost`, `addBy`, `deleted`, `deleteBy`) VALUES
(1, 'Normal', 12, 'Rand', 0, NULL),
(2, 'Food and bev :', 20, 'thamali', 0, NULL),
(3, 'Animals', 50, 'Rand', 0, NULL);

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
  `deleted` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`custID`),
  UNIQUE KEY `custID_UNIQUE` (`custID`),
  UNIQUE KEY `custNIC_UNIQUE` (`custNIC`),
  UNIQUE KEY `custEmail_UNIQUE` (`custEmail`),
  KEY `customerAdmin_idx` (`addBy`),
  KEY `custAddUser_idx` (`addBy`),
  KEY `custDeleteBy_idx` (`deleteBy`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`custID`, `custName`, `custEmail`, `custMobile`, `custTel`, `custAddress`, `custNIC`, `addBy`, `deleted`, `deleteBy`) VALUES
(1, 'boo', 'booo', '456', '456', 'fgghfhdf', 'dfgdfg4', 'Rand', 0, NULL),
(2, 'ghfgh', NULL, '', '', NULL, '564', 'Rand', 0, NULL),
(3, 'poo', NULL, '', '', NULL, '12345', 'Rand', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `device`
--

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `device`
--

INSERT INTO `device` (`devID`, `imei`, `assignTo`, `addBy`, `deleted`, `deleteBy`) VALUES
(1, '1111', 'Rand', 'Lahiru', 0, NULL),
(2, '1212', 'Lahiru', 'Rand', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `parcel`
--

CREATE TABLE IF NOT EXISTS `parcel` (
  `parcelID` int(11) NOT NULL AUTO_INCREMENT,
  `weight` float NOT NULL,
  `currentStation` int(11) NOT NULL,
  `sender` int(6) NOT NULL,
  `receiver` int(6) NOT NULL,
  `starts` int(11) NOT NULL,
  `destination` int(11) NOT NULL,
  `totalCost` float NOT NULL,
  `express` varchar(1) NOT NULL,
  `dateReceived` bigint(20) NOT NULL,
  `dateDelivered` bigint(20) NOT NULL,
  `addBy` varchar(100) NOT NULL,
  `train` varchar(45) DEFAULT NULL,
  `released` tinyint(1) DEFAULT NULL,
  `releaseBy` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`parcelID`),
  UNIQUE KEY `parcelID_UNIQUE` (`parcelID`),
  KEY `stationFK1_idx` (`starts`),
  KEY `senderFK_idx` (`sender`),
  KEY `receiverFK_idx` (`receiver`),
  KEY `addByUser_idx` (`addBy`),
  KEY `startStation_idx` (`starts`),
  KEY `current_idx` (`currentStation`),
  KEY `assignTrain_idx` (`train`),
  KEY `releaseByUser_idx` (`releaseBy`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `parcel`
--

INSERT INTO `parcel` (`parcelID`, `weight`, `currentStation`, `sender`, `receiver`, `starts`, `destination`, `totalCost`, `express`, `dateReceived`, `dateDelivered`, `addBy`, `train`, `released`, `releaseBy`) VALUES
(5, 34.2, 1, 1, 1, 1, 3, 345.8, '0', 20140916000000, 20140918000000, 'Rand', NULL, 0, NULL),
(6, 45, 1, 2, 2, 1, 1, 2700, '0', 1412596130, 0, 'Rand', NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `station_mapping`
--

CREATE TABLE IF NOT EXISTS `station_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `station_code` varchar(10) NOT NULL,
  `station_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `station_code` (`station_code`),
  UNIQUE KEY `station_code_2` (`station_code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=36 ;

--
-- Dumping data for table `station_mapping`
--

INSERT INTO `station_mapping` (`id`, `station_code`, `station_name`) VALUES
(1, 'MDA', 'Maradana'),
(3, 'FOT', 'Colombo Fort'),
(4, 'BPT', 'Bambalapitiya'),
(5, 'WEL', 'Wellawatta'),
(6, 'MLV', 'Mount Lavinia'),
(7, 'RML', 'Ratmalana'),
(8, 'MRT', 'Moratuwa'),
(9, 'PND', 'Panadura'),
(10, 'WDA', 'Wadduwa'),
(13, 'KTN', 'Kalutara North'),
(14, 'KTS', 'Kalutara South'),
(15, 'PGS', 'Payagala South'),
(16, 'BRL', 'Beruwala'),
(17, 'ALT', 'Aluthgama'),
(18, 'BNT', 'Bentota'),
(19, 'IDA', 'Induruwa'),
(20, 'KDA', 'Kosgoda'),
(21, 'BPA', 'Balapitiya'),
(22, 'ABA', 'Ambalangoda'),
(23, 'KWE', 'Kahawa'),
(24, 'HKD', 'Hikkaduwa'),
(25, 'DNA', 'Dodanduwa'),
(26, 'BSH', 'Boossa'),
(27, 'GNT', 'Gintota'),
(28, 'GLE', 'Galle'),
(29, 'KUG', 'Katugoda'),
(30, 'TLP', 'Talpe'),
(31, 'KOG', 'Koggala'),
(32, 'ANM', 'Ahangama'),
(33, 'WLM', 'Weligama'),
(34, 'KMG', 'Kamburugamuwa'),
(35, 'MTR', 'Matara');

-- --------------------------------------------------------

--
-- Table structure for table `train_mapping`
--

CREATE TABLE IF NOT EXISTS `train_mapping` (
  `train_num` varchar(45) NOT NULL,
  `start_station` varchar(45) DEFAULT NULL,
  `destination` varchar(45) DEFAULT NULL,
  `train_type` varchar(45) DEFAULT NULL,
  `train_run` varchar(45) DEFAULT NULL,
  `train_name` varchar(45) DEFAULT NULL,
  `train_direction` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`train_num`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `train_mapping`
--

INSERT INTO `train_mapping` (`train_num`, `start_station`, `destination`, `train_type`, `train_run`, `train_name`, `train_direction`) VALUES
('8039', 'MTR', 'KDT', 'PGR', 'EXP', 'Matara-Kandy Ex', 'UP'),
('8040', 'KDT', 'MTR', 'PGR', 'EXP', 'Kandy-Matara Express', 'DOWN'),
('8050', 'MDA', 'MTR', 'PGR', 'EXP', 'Matara Express', 'DOWN'),
('8051', 'MTR', 'MDA', 'PGR', 'EXP', 'Matara-Maradana Express', 'UP'),
('8056', 'MDA', 'MTR', 'PGR', 'EXP', 'Galu Kumari', 'DOWN'),
('8057', 'MTR', 'MDA', 'PGR', 'EXP', 'Galu Kumari', 'UP'),
('8058', 'MDA', 'MTR', 'PGR', 'EXP', 'Ruhunu Kumari', 'DOWN'),
('8059', 'MTR', 'MDA', 'PGR', 'EXP', 'Ruhunu Kumari', 'UP'),
('8062', 'MDA', 'HKD', 'PGR', 'EXP', 'Maradana-Hikkaduwa Express', 'DOWN'),
('8063', 'HKD', 'MDA', 'PGR', 'EXP', 'Hikkaduwa-Maradana Express', 'UP'),
('8085', 'MTR', 'VNY', 'PNG', 'EXP', 'Rajarata Rajini', 'UP'),
('8086', 'MTR', 'VNY', 'PGR', 'EXP', 'Rajarata Rajini', 'DOWN'),
('8093', 'MTR', 'Pallai', 'PGR', 'EX', 'Matara-Pallai Express', 'UP'),
('8096', 'MDA', 'MTR', 'PGR', 'EXP', 'Sagarika', 'DOWN'),
('8097', 'MTR', 'MDA', 'PGR', 'EXP', 'Sagarika', 'UP'),
('8311', 'GLE', 'MDA', 'PGR', 'EXP', 'Galle-Maradana Mail', 'UP'),
('8320', 'GLE', 'MDA', 'PGR', 'SLW', 'Galle-Maradana Slow', 'UP'),
('8324', 'ALT', 'MDA', 'PGR', 'NEX', 'Aluthgama-Maradana Slow', 'UP'),
('8326', 'KTS', 'MDA', 'PGR', 'EXP', 'Kalutara South-Maradana Express', 'UP'),
('8327', 'GLE', 'MDA', 'PGR', 'EXP', 'Samudra Devi', 'UP'),
('8758', 'MDA', 'ALT', 'PGR', 'NEX', 'Maradana-Aluthgama Slow', 'DOWN'),
('8760', 'MDA', 'GLE', 'PGR', 'EXP', 'Samudra Devi', 'DOWN'),
('8764', 'MDA', 'GLE', 'PGR', 'NEX', 'Maradana-Galle Slow', 'DOWN'),
('8765', 'MDA', 'KTS', 'PGR', 'EXP', 'Maradana-Kalutara South Express', 'DOWN'),
('8766', 'MDA', 'MTR', 'PGR', 'EXP', 'Maradana-Matara Express', 'DOWN');

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

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserName`, `password`, `designation`, `role`, `home_page`, `shed`, `sub_dept`, `nic_number`, `addBy`) VALUES
('Lahiru', 'd74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1', 'sith', 'pith', 'gdgd', 'ddd', 'dd', '123456789V', 'Rand'),
('Rand', 'd74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1', 'jil', 'bil', 'gdg', 'gggg', 'gg', '911672375V', 'Rand'),
('thamali', 'fcba89201226b0bc0feac29ed8a07a20559a62c5ea776042fd15877d4b301387', 'Ms', 'SM', NULL, 'No1', '', '12345v', 'Rand');

-- --------------------------------------------------------

--
-- Table structure for table `user_detail`
--

CREATE TABLE IF NOT EXISTS `user_detail` (
  `UserName` varchar(100) NOT NULL,
  `name` varchar(45) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `station` int(11) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`UserName`),
  KEY `userDetail_idx` (`UserName`),
  KEY `userStation_idx` (`station`),
  KEY `deleteByUser_idx` (`deleteBy`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_detail`
--

INSERT INTO `user_detail` (`UserName`, `name`, `Email`, `station`, `phone`, `deleted`, `deleteBy`) VALUES
('chandu', 'Chanduni', 'chaaz92@gmail.com', 1, '6666', 0, NULL),
('kulani', 'Kulani', 'kulani.s91@gmail.com', 4, '567890', 0, NULL),
('Lahiru', 'Rangana', 'lahiru.rangana54@gmail.com', 1, '754129659', 0, NULL),
('maneesha', 'Maneesha', 'kmerandi25@gmail.com', 8, '1234', 0, NULL),
('Rand', 'Randika', 'lahiru.rangana77@gmail.com', 1, '713823479', 0, NULL),
('thamali', 'Thamali', 'ravingae@gmail.com', 1, '1245', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_privilege`
--

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

--
-- Dumping data for table `user_privilege`
--

INSERT INTO `user_privilege` (`User_Name`, `add_user`, `remove_User`, `add_station`, `remove_station`, `add_train`, `remove_train`, `add_category`, `remove_category`, `add_customer`, `remove_customer`, `add_parcel`, `release_parcel`, `confirm_arrival`, `check_upcoming_parcel`, `select_train`, `add_device`, `remove_device`) VALUES
('Lahiru', 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('Rand', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
('thamali', 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `category`
--

ALTER TABLE `category`
  ADD CONSTRAINT `categoryAddBy` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `categoryDeleteBy` FOREIGN KEY (`deleteBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `customer`
--

ALTER TABLE `customer`
  ADD CONSTRAINT `custAddBy` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `custDeleteBy` FOREIGN KEY (`deleteBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `device`
--

ALTER TABLE `device`
  ADD CONSTRAINT `deviceAddBy` FOREIGN KEY (`addBy`) REFERENCES `user` (`UserName`) ON UPDATE CASCADE,
  ADD CONSTRAINT `deviceDeleteBy` FOREIGN KEY (`deleteBy`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `deviceUser` FOREIGN KEY (`assignTo`) REFERENCES `user` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
