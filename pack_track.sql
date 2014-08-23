-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 23, 2014 at 09:33 PM
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
  PRIMARY KEY (`UserName`),
  UNIQUE KEY `UserName` (`UserName`),
  UNIQUE KEY `nic_number` (`nic_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
