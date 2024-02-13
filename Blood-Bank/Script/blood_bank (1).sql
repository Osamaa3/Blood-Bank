-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 13, 2024 at 07:47 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `blood bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `blooddonation`
--

CREATE TABLE `blooddonation` (
  `DonationID` int(11) NOT NULL,
  `DonorID` int(11) NOT NULL,
  `DonationDate` varchar(50) NOT NULL,
  `VitalSign` text NOT NULL,
  `MedicalExamination` text NOT NULL,
  `QuantityDonated` int(10) NOT NULL,
  `bloodtype` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `blooddonation`
--

INSERT INTO `blooddonation` (`DonationID`, `DonorID`, `DonationDate`, `VitalSign`, `MedicalExamination`, `QuantityDonated`, `bloodtype`) VALUES
(1, 2, '12-3-20', 'good', 'passed', 500, 'A+'),
(2, 1, '20-2-20', 'good', 'passed', 1000, 'A+');

-- --------------------------------------------------------

--
-- Table structure for table `bloodreceiver`
--

CREATE TABLE `bloodreceiver` (
  `RequestID` int(11) NOT NULL,
  `RequestingUser` varchar(255) NOT NULL,
  `PatientDetails` text NOT NULL,
  `RequiredBloodType` varchar(5) NOT NULL,
  `Criteria` text NOT NULL,
  `DonorID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bloodreceiver`
--

INSERT INTO `bloodreceiver` (`RequestID`, `RequestingUser`, `PatientDetails`, `RequiredBloodType`, `Criteria`, `DonorID`) VALUES
(1, 'medical professioal', 'fawaz,  room 104', 'A+', 'urgent', 0),
(2, 'Talal', 'xyzzz', 'A+', 'urgent', 2),
(3, 'owais', 'xyz', '', 'urgent', 2),
(4, 'owais', 'abc', 'A+', 'not urgent', 2),
(5, '', '', '', '', 0),
(6, 'salman', 'salman room 804', 'O-', 'normal', 1),
(7, '', '', '', '', 0),
(8, 'Salam', 'salman room 804', 'A+', 'normal', 1);

-- --------------------------------------------------------

--
-- Table structure for table `donorregistration`
--

CREATE TABLE `donorregistration` (
  `DonorID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Contact` varchar(255) NOT NULL,
  `Age` int(3) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Address` varchar(500) NOT NULL,
  `BloodType` varchar(5) NOT NULL,
  `MedicalHistory` text NOT NULL,
  `DonationRecord` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donorregistration`
--

INSERT INTO `donorregistration` (`DonorID`, `Name`, `Contact`, `Age`, `Gender`, `Address`, `BloodType`, `MedicalHistory`, `DonationRecord`) VALUES
(1, 'Aliyan Qureshi', '03101134581', 25, 'Male', '123 Main Street, Cityville', 'O+', 'No significant medical history', 'No Previous Donation'),
(2, 'Subhan Azhar', '03136655161', 23, 'Male', '453 Front Street, lahore', 'A+', 'No significant medical history', 'No Previous Donation'),
(3, 'owais', '221312312', 20, 'male', 'abc', 'A+', 'no', 'no'),
(4, 'owais', '9849837361', 19, 'male', '532 main street', 'A+', 'no ', ''),
(5, 'owais', '9849837361', 19, 'male', '532 main street', 'A+', 'no ', 'no'),
(6, 'osama', '12312', 19, 'Male', 'sf sd ', 'A+', '[object History]', 'no');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blooddonation`
--
ALTER TABLE `blooddonation`
  ADD PRIMARY KEY (`DonationID`),
  ADD KEY `blooddonation_ibfk_1` (`DonorID`);

--
-- Indexes for table `bloodreceiver`
--
ALTER TABLE `bloodreceiver`
  ADD PRIMARY KEY (`RequestID`),
  ADD KEY `DonorID` (`DonorID`);

--
-- Indexes for table `donorregistration`
--
ALTER TABLE `donorregistration`
  ADD PRIMARY KEY (`DonorID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blooddonation`
--
ALTER TABLE `blooddonation`
  MODIFY `DonationID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `bloodreceiver`
--
ALTER TABLE `bloodreceiver`
  MODIFY `RequestID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `donorregistration`
--
ALTER TABLE `donorregistration`
  MODIFY `DonorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `blooddonation`
--
ALTER TABLE `blooddonation`
  ADD CONSTRAINT `blooddonation_ibfk_1` FOREIGN KEY (`DonorID`) REFERENCES `donorregistration` (`DonorID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
