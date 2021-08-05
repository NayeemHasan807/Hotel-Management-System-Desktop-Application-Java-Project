-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2019 at 04:41 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `g04`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerId` varchar(16) NOT NULL,
  `Name` varchar(16) NOT NULL,
  `RoomNumber` int(3) NOT NULL,
  `CheckInTime` varchar(10) NOT NULL,
  `CheckOutTime` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerId`, `Name`, `RoomNumber`, `CheckInTime`, `CheckOutTime`) VALUES
('c1', 'kalam', 110, '12:30pm 22', '10:30am 23');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `EmployeeId` varchar(16) NOT NULL,
  `Name` varchar(16) NOT NULL,
  `JobCategory` varchar(16) NOT NULL,
  `Salary` int(8) NOT NULL,
  `Phone` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmployeeId`, `Name`, `JobCategory`, `Salary`, `Phone`) VALUES
('m1', 'Khairul', 'Manager', 80000, 96754318),
('m2', 'Bulbul', 'Manager', 60000, 87625678),
('r1', 'Nafia', 'Receptionist', 20000, 11122211),
('r2', 'Mosrin', 'Cashier', 12000, 98765431),
('rc1', 'Mow', 'Room Cleaner', 7000, 98101010);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `RoomNumber` int(3) NOT NULL,
  `Availability` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`RoomNumber`, `Availability`) VALUES
(101, 0),
(102, 1),
(103, 2),
(104, 1),
(105, 0),
(106, 1),
(107, 2),
(108, 1),
(109, 1),
(110, 0),
(201, 1),
(202, 1),
(203, 1),
(204, 1),
(205, 1),
(206, 1),
(207, 1),
(208, 1),
(209, 1),
(210, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `uId` varchar(16) NOT NULL,
  `uPassword` varchar(16) NOT NULL,
  `uStatus` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uId`, `uPassword`, `uStatus`) VALUES
('m1', '1234', 1),
('m2', '15054254', 1),
('r1', '9999', 2),
('r2', '13826539', 3),
('rc1', '9191', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerId`),
  ADD UNIQUE KEY `UNIQUE` (`RoomNumber`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EmployeeId`),
  ADD UNIQUE KEY `UNIQUE` (`Phone`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`RoomNumber`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
