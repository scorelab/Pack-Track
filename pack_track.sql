SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE DATABASE IF NOT EXISTS `pack_track` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `pack_track`;

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

INSERT INTO `category` (`catID`, `catName`, `unitCost`, `addBy`, `deleted`, `deleteBy`) VALUES
(1, 'Normal', 1, 'Rand', 0, NULL),
(2, 'Furniture', 5.5, 'Rand', 0, NULL),
(3, 'Flowers', 1.5, 'Rand', 0, NULL);

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
  KEY `customerAdmin_idx` (`addBy`),
  KEY `custAddUser_idx` (`addBy`),
  KEY `custDeleteBy_idx` (`deleteBy`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

INSERT INTO `customer` (`custID`, `custName`, `custEmail`, `custMobile`, `custTel`, `custAddress`, `custNIC`, `addBy`, `deleted`, `deleteBy`) VALUES
(13, 'Rashendra Oshanda', 'lahiru.rangana58@gmail.com', '0714578963', '0112856947', '15, Kadawatha, Kirillawala', '893456752V', 'Thamali', 0, NULL),
(14, 'Nipuna Udara', 'lahiru.rangana54@gmail.com', '0715489632', '0112587431', '25, Pannipitiya, Kottawa.', '811927356V', 'Thamali', 0, NULL),
(15, 'Dinka Mandula', 'lahiru.rangana58@gmail.com', '0719547862', '0115463218', '84, Aluthgama', '905765555V', 'Thamali', 0, NULL);

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

INSERT INTO `device` (`devID`, `imei`, `assignTo`, `addBy`, `deleted`, `deleteBy`) VALUES
(1, '1234567890', 'Rand', 'Rand', 0, NULL);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=65 ;

INSERT INTO `parcel` (`parcelID`, `weight`, `currentStation`, `sender`, `receiver`, `starts`, `destination`, `totalCost`, `express`, `dateReceived`, `dateDelivered`, `addBy`, `train`, `released`, `releaseBy`) VALUES
(45, 10, 21, 13, 14, 7, 21, 3429.8, '0', 1421588082, 0, 'Thamali', NULL, 1, 'Lahiru'),
(46, 15, 13, 13, 15, 7, 17, 658.5, '0', 1421588296, 0, 'Thamali', NULL, 0, NULL),
(47, 20, 4, 14, 15, 4, 28, 2135.6, '0', 1421750265, 0, 'Dilanka', NULL, 0, NULL),
(48, 10, 1, 13, 14, 1, 3, 20.8, '0', 1389790111, 0, 'Rand', NULL, 0, NULL),
(49, 100, 1, 15, 14, 22, 5, 6270, '0', 1421760375, 0, 'Rand', NULL, 0, NULL),
(50, 30, 1, 14, 15, 1, 21, 13279.2, '0', 1413377311, 0, 'Rand', NULL, 0, NULL),
(51, 8, 1, 15, 13, 28, 9, 242.24, '0', 1416055711, 0, 'Rand', NULL, 0, NULL),
(52, 25, 1, 15, 14, 10, 23, 2295, '0', 1421762886, 0, 'Rand', NULL, 0, NULL),
(53, 20, 1, 13, 14, 1, 35, 4756.2, '0', 1419511711, 0, 'Rand', NULL, 0, NULL),
(54, 100, 1, 14, 15, 22, 6, 1629, '0', 1421763125, 0, 'Rand', NULL, 0, NULL),
(55, 10, 1, 15, 14, 13, 30, 1895.4, '0', 1421326111, 0, 'Rand', NULL, 0, NULL),
(56, 10, 1, 13, 14, 1, 5, 627, '0', 1421763371, 0, 'Rand', NULL, 0, NULL),
(57, 35, 1, 15, 13, 22, 28, 4062.8, '0', 1421763541, 0, 'Rand', NULL, 0, NULL),
(58, 2, 1, 13, 14, 1, 28, 348.24, '0', 1414241311, 0, 'Rand', NULL, 0, NULL),
(59, 7, 1, 14, 15, 1, 28, 4469.08, '0', 1421763622, 0, 'Rand', NULL, 0, NULL),
(60, 3, 1, 15, 13, 13, 28, 1915.32, '0', 1410785311, 0, 'Rand', NULL, 0, NULL),
(61, 6, 1, 13, 15, 1, 28, 1044.72, '0', 1418647711, 0, 'Rand', NULL, 0, NULL),
(62, 10, 1, 15, 15, 28, 8, 1265, '0', 1421763806, 0, 'Rand', NULL, 0, NULL),
(63, 30, 1, 15, 14, 22, 26, 3238.8, '0', 1421763854, 0, 'Rand', NULL, 0, NULL),
(64, 40, 1, 14, 14, 1, 33, 5787.2, '0', 1419070867, 0, 'Rand', NULL, 0, NULL);

DROP TABLE IF EXISTS `station_dist`;
CREATE TABLE IF NOT EXISTS `station_dist` (
  `dist` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `station_mapping`;
CREATE TABLE IF NOT EXISTS `station_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `station_code` varchar(10) NOT NULL,
  `station_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `station_code` (`station_code`),
  UNIQUE KEY `station_code_2` (`station_code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=36 ;

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

INSERT INTO `user` (`UserName`, `password`, `designation`, `role`, `home_page`, `shed`, `sub_dept`, `nic_number`, `addBy`) VALUES
('Dilanka', 'd74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1', 'Dilanka_des', 'Dilanka_role', NULL, 'Dilanka_shed', 'Dilanka_sub', '981672375V', 'Rand'),
('Harsha', 'd74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1', 'Hrasha_des', 'Harsha_role', NULL, 'Harsha_shed', 'Harsha_sub', '917435776V', 'Rand'),
('Lahiru', 'd74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1', 'Lahiru_des', 'Lahiru_role', NULL, 'Lahiru_shed', 'Lahiru-sub', '991672375V', 'Rand'),
('Maneesha', '06649db4e8efed4b8d40390f760dce37d912cbba9298a3662d45c1561e996e56', 'Maneesha_des', 'MAneesha_role', NULL, 'Maneesha_shed', 'Maneesha_sub', '961672375V', 'Rand'),
('prabodha', 'fcc5fdcf01f4c8b52b7a63bc992b7549cef6fbe0fe120727aa9a359c82afe3c0', 'Prabodha_des', 'Pabodha_role', NULL, 'Prabodha_shed', 'Prodha_sub', '916250606v', 'Lahiru'),
('Rand', 'd74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1', 'Rand_des', 'Rand_role', 'gdg', 'Rand_shed', 'Rand_sub', '911672375V', 'Rand'),
('Thamali', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'Thamali_des', 'Thamali_role', NULL, 'Thamali_shed', 'Thamali_sub', '947173856V', 'Rand');

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

INSERT INTO `user_detail` (`UserName`, `name`, `Email`, `station`, `phone`, `deleted`, `deleteBy`) VALUES
('Dilanka', 'Dilanka Wagachchi', 'lahiru.rangana58@gmail.com', 4, '0713823479', 0, NULL),
('Harsha', 'Harsha Dulshan', 'lahiru.rangana54@gmail.com', 13, '0112054468', 0, NULL),
('Lahiru', 'Lahiru Rangana', 'lahiru.xmail@gmail.com', 21, '0754129659', 0, NULL),
('Maneesha', 'Maneesha Erandi', 'harith9127@gmail.com', 17, '0713823479', 0, NULL),
('prabodha', 'Prabodha Gamage', 'madhushanikapi@gmail.com', 28, '0116789456', 0, NULL),
('Rand', 'Randika Ayantha', 'lahiru.rangana77@gmail.com', 1, '713823479', 0, NULL),
('Thamali', 'Thamali Ravinga', 'lahiru.rangana56@gmail.com', 7, '0754129659', 0, NULL);

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

INSERT INTO `user_privilege` (`User_Name`, `add_user`, `remove_User`, `add_station`, `remove_station`, `add_train`, `remove_train`, `add_category`, `remove_category`, `add_customer`, `remove_customer`, `add_parcel`, `release_parcel`, `confirm_arrival`, `check_upcoming_parcel`, `select_train`, `add_device`, `remove_device`, `accounts`) VALUES
('Dilanka', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0),
('Harsha', 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0),
('Lahiru', 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0),
('Maneesha', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0),
('prabodha', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0),
('Rand', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
('Thamali', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0);


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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
