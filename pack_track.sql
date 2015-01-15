-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 15, 2015 at 07:02 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `catID` int(5) NOT NULL AUTO_INCREMENT,
  `catName` varchar(20) NOT NULL,
  `unitCost` float NOT NULL,
  `addBy` varchar(100) NOT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `deleteBy` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`catID`),
  UNIQUE KEY `catID_UNIQUE` (`catID`),
  UNIQUE KEY `catName_UNIQUE` (`catName`),
  KEY `categoryAdmin_idx` (`addBy`),
  KEY `categoryDeleteBy_idx` (`deleteBy`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`catID`, `catName`, `unitCost`, `addBy`, `deleted`, `deleteBy`) VALUES
(1, 'Normal', 12, 'Rand', 0, NULL),
(2, 'Furniture', 5.5, 'Rand', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`custID`, `custName`, `custEmail`, `custMobile`, `custTel`, `custAddress`, `custNIC`, `addBy`, `deleted`, `deleteBy`) VALUES
(1, 'boo', 'booo', '456', '456', 'fgghfhdf', 'dfgdfg4', 'Rand', 0, NULL),
(2, 'ghfgh', NULL, '', '', NULL, '564', 'Rand', 0, NULL),
(3, 'poo', NULL, '', '', NULL, '12345', 'Rand', 0, NULL),
(4, 'fgdfgdf', NULL, '', '', NULL, '546546v', 'Rand', 0, NULL),
(5, 'nimal', NULL, '1111', '', NULL, '234', 'Rand', 0, NULL),
(6, 'Ayantha', 'paarandika@gmail.com', '', '', NULL, 'qwe', 'Rand', 0, NULL),
(7, 'Randika', NULL, '', '', NULL, 'asd', 'Rand', 0, NULL),
(8, 'fgrff', NULL, '', '', NULL, '12345667v', 'Rand', 0, NULL),
(9, 'wertdfe', NULL, '', '', NULL, '45334667v', 'Rand', 0, NULL),
(10, 'ertert', NULL, '', '', NULL, '1235b', 'Rand', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `device`
--

INSERT INTO `device` (`devID`, `imei`, `assignTo`, `addBy`, `deleted`, `deleteBy`) VALUES
(1, '1234567890', 'Rand', 'Rand', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `parcel`
--

DROP TABLE IF EXISTS `parcel`;
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=43 ;

--
-- Dumping data for table `parcel`
--

INSERT INTO `parcel` (`parcelID`, `weight`, `currentStation`, `sender`, `receiver`, `starts`, `destination`, `totalCost`, `express`, `dateReceived`, `dateDelivered`, `addBy`, `train`, `released`, `releaseBy`) VALUES
(5, 34.2, 6, 1, 1, 1, 1, 345.8, '0', 20140916000000, 0, 'Rand', NULL, 1, 'Rand'),
(6, 45, 1, 2, 2, 1, 13, 2700, '0', 1412596130, 0, 'Rand', NULL, 0, NULL),
(7, 34, 1, 3, 3, 1, 23, 2040, '1', 1412867498, 0, 'Rand', '8039', 0, NULL),
(8, 2, 1, 5, 3, 1, 28, 120, '0', 1412960861, 0, 'Rand', NULL, 0, NULL),
(9, 456, 1, 2, 2, 1, 22, 27360, '0', 1413358072, 0, 'Rand', NULL, 0, NULL),
(10, 44, 1, 2, 2, 1, 22, 2640, '0', 1413374378, 0, 'Rand', NULL, 0, NULL),
(11, 2, 1, 3, 3, 1, 16, 120, '0', 1413374495, 0, 'Rand', NULL, 0, NULL),
(12, 2, 1, 3, 3, 1, 15, 120, '0', 1413374589, 0, 'Rand', NULL, 0, NULL),
(13, 4, 1, 3, 2, 1, 19, 240, '0', 1413374788, 0, 'Rand', NULL, 0, NULL),
(14, 3, 1, 2, 2, 1, 7, 180, '0', 1413374990, 0, 'Rand', NULL, 0, NULL),
(15, 1, 1, 2, 2, 1, 22, 60, '0', 1413375398, 0, 'Rand', NULL, 0, NULL),
(18, 6, 1, 2, 2, 1, 22, 360, '0', 1413386640, 0, 'Rand', NULL, 0, NULL),
(19, 2, 1, 2, 2, 1, 5, 120, '0', 1413395509, 0, 'Rand', NULL, 0, NULL),
(20, 1, 1, 3, 2, 1, 21, 60, '0', 1413395778, 0, 'Rand', NULL, 0, NULL),
(21, 1, 1, 6, 7, 1, 17, 60, '0', 1413396830, 0, 'Rand', NULL, 0, NULL),
(22, 3, 1, 6, 7, 1, 19, 180, '0', 1413397141, 0, 'Rand', NULL, 0, NULL),
(23, 1, 1, 7, 6, 1, 21, 60, '0', 1413397309, 0, 'Rand', NULL, 0, NULL),
(24, 3, 1, 6, 2, 1, 20, 180, '0', 1413397463, 0, 'Rand', NULL, 0, NULL),
(25, 67, 1, 2, 6, 1, 20, 4020, '0', 1413397601, 0, 'Rand', NULL, 0, NULL),
(39, 1, 1, 3, 3, 1, 5, 0, '0', 1414337630, 0, 'Rand', NULL, 0, NULL),
(40, 1, 1, 3, 3, 1, 5, 136.8, '0', 1414345831, 0, 'Rand', NULL, 0, NULL),
(41, 1.2, 1, 3, 3, 1, 8, 331.2, '0', 1414347964, 0, 'Rand', NULL, 0, NULL),
(42, 23, 1, 3, 2, 1, 4, 2566.8, '0', 1414350430, 0, 'Rand', NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `station_dist`
--

DROP TABLE IF EXISTS `station_dist`;
CREATE TABLE IF NOT EXISTS `station_dist` (
  `dist` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `station_dist`
--

INSERT INTO `station_dist` (`dist`) VALUES
('MDA FOT 2.08'),
('FOT BPT 7.22'),
('BPT WEL 2.10'),
('WEL MLV 4.89'),
('MLV RML 1.83'),
('RML MRT 4.88'),
('MRT PND 7.28'),
('PND WDA 6.16'),
('WDA KTN 7.36'),
('KTN KTS 2.04'),
('KTS PGS 6.14'),
('PGS BRL 5.02'),
('BRL ALT 5.02'),
('ALT BNT 1.26'),
('BNT IDA 4.06'),
('IDA KDA 6.02'),
('KDA BPA 7.12'),
('BPA ABA 4.9'),
('ABA KWE 6.42'),
('KWE HKD 5.52'),
('HKD DNA 6.32'),
('DNA BSH 4.32'),
('BSH GNT 2.42'),
('GNT GLE 5.7'),
('GLE KUG 3.98'),
('KUG TLP 6.3'),
('TLP KOG 4.5'),
('KOG ANM 5.22'),
('ANM WLM 8.6'),
('WLM KMG 8.5'),
('KMG MTR 5.36');

-- --------------------------------------------------------

--
-- Table structure for table `station_mapping`
--

DROP TABLE IF EXISTS `station_mapping`;
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

DROP TABLE IF EXISTS `train_mapping`;
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

DROP TABLE IF EXISTS `user`;
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
('prrr', '243bff0354584bb553af85db244b05ea9ebb7000af821097fb9f59b75a8480cb', 'ert', 'erty', NULL, 'ert', 'fgh', '123456778v', 'Rand'),
('Rand', 'd74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1', 'jil', 'bil', 'gdg', 'gggg', 'gg', '911672375V', 'Rand'),
('randika', '7b7ab5d581741d0cffe4aab3ec359852537568886e1cd8cb0ccd68bd0397561b', 'Mr', 'SM', NULL, 'Col', 'col', '9116723752V', 'Rand'),
('thamali', 'fcba89201226b0bc0feac29ed8a07a20559a62c5ea776042fd15877d4b301387', 'Ms', 'SM', NULL, 'No1', '', '12345v', 'Rand');

-- --------------------------------------------------------

--
-- Table structure for table `user_detail`
--

DROP TABLE IF EXISTS `user_detail`;
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
('Lahiru', 'Rangana', '1ahiru.rangana54@gmail.com', 1, '754129659', 0, NULL),
('prrr', 'prreww', 'acd@bbb.com', 1, '3456', 0, NULL),
('Rand', 'Randika', 'lahiru.rangana77@gmail.com', 22, '713823479', 0, NULL),
('randika', 'rand', 'paarandika@gmail.com', 3, '0716354795', 0, NULL),
('thamali', 'Thamali', 'ravingae@gmail.com', 1, '1245', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_privilege`
--

DROP TABLE IF EXISTS `user_privilege`;
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
  `accounts` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`User_Name`),
  KEY `userPrivilige_idx` (`User_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_privilege`
--

INSERT INTO `user_privilege` (`User_Name`, `add_user`, `remove_User`, `add_station`, `remove_station`, `add_train`, `remove_train`, `add_category`, `remove_category`, `add_customer`, `remove_customer`, `add_parcel`, `release_parcel`, `confirm_arrival`, `check_upcoming_parcel`, `select_train`, `add_device`, `remove_device`, `accounts`) VALUES
('Lahiru', 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('prrr', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('Rand', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
('randika', 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0),
('thamali', 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

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
