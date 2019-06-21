-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 12, 2019 at 06:09 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `etracer2`
--

-- --------------------------------------------------------

--
-- Table structure for table `assessment`
--

CREATE TABLE `assessment` (
  `assessmentId` varchar(10) NOT NULL,
  `assessmentName` varchar(30) NOT NULL,
  `employeeId` varchar(10) NOT NULL,
  `isDelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assessment`
--

INSERT INTO `assessment` (`assessmentId`, `assessmentName`, `employeeId`, `isDelete`) VALUES
('ASS01', 'coba 1x', 'EMP01', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `categoryId` varchar(10) NOT NULL,
  `assessmentId` varchar(10) NOT NULL,
  `evaluationId` varchar(10) NOT NULL,
  `employeeId` varchar(10) NOT NULL,
  `isDelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `confirmation_token`
--

CREATE TABLE `confirmation_token` (
  `id` int(11) NOT NULL,
  `token` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL,
  `employeeId` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `confirmation_token`
--

INSERT INTO `confirmation_token` (`id`, `token`, `create_date`, `employeeId`) VALUES
(4, 'c16c6cff-0e23-42a5-8bac-aa741ec8b27f', '2019-06-11 22:48:18', 'EMP06'),
(5, '2c0c7e89-7299-4a9f-baa2-7f533fdd9eca', '2019-06-11 23:56:06', 'EMP07'),
(7, '6907c416-2605-43e2-8d2b-4924eeb5c243', '2019-06-12 00:16:24', 'EMP10'),
(14, 'c7d3628b-1758-4eb4-9bca-90ab9bfa47c1', '2019-06-12 11:22:00', 'EMP11'),
(15, '546c8ee1-3c18-4179-a4ab-342f6c3370a0', '2019-06-12 16:44:00', 'EMP11'),
(16, '7a81bbf7-4f07-4396-b41d-b87cb2c13475', '2019-06-12 16:53:05', 'EMP11'),
(18, '7d762e12-8197-478e-a96d-201d298e3638', '2019-06-12 23:05:47', 'EMP13');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `departmentId` varchar(10) NOT NULL,
  `departmentName` varchar(30) NOT NULL,
  `villageId` varchar(10) NOT NULL,
  `employeeId` varchar(10) DEFAULT NULL,
  `isDelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`departmentId`, `departmentName`, `villageId`, `employeeId`, `isDelete`) VALUES
('DP001', 'ADD 1', 'VL01', NULL, 'false'),
('DP002', 'MSBU', 'VL01', NULL, 'false');

-- --------------------------------------------------------

--
-- Table structure for table `district`
--

CREATE TABLE `district` (
  `districtId` varchar(10) NOT NULL,
  `districtName` varchar(20) DEFAULT NULL,
  `provinceId` varchar(10) DEFAULT NULL,
  `isDelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `district`
--

INSERT INTO `district` (`districtId`, `districtName`, `provinceId`, `isDelete`) VALUES
('DI01', 'Kulon Progo', 'PR01', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employeeId` varchar(10) NOT NULL,
  `employeeName` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `dateOfJoin` date NOT NULL,
  `managerId` varchar(10) NOT NULL,
  `salary` varchar(20) NOT NULL,
  `gender` enum('Male','Female') NOT NULL,
  `phone` varchar(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(150) NOT NULL,
  `departmentId` varchar(10) NOT NULL,
  `jobId` varchar(10) NOT NULL,
  `isDelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employeeId`, `employeeName`, `address`, `dateOfBirth`, `dateOfJoin`, `managerId`, `salary`, `gender`, `phone`, `email`, `password`, `departmentId`, `jobId`, `isDelete`) VALUES
('EMP01', 'Septyani', 'jalan kesana kesini', '2019-05-02', '2019-05-03', 'EMP01', '4000000', 'Male', '086785463860', 'saya@gmail.com', '$2a$10$ZN1cKomg8V579aLY2jZwUedKsZcKOfYNFY16ippnnJ9v94FlRqyeW', 'DP001', 'JB001', 'false'),
('EMP02', 'Freditya', 'Jalan menuju hatimu', '2019-06-05', '2019-06-19', 'EMP01', '10000000', 'Male', '089876865', 'freditya@gmail.com', '$2a$10$dyoDWnhaxGvwY8db88kQUO5WFbCRqsSTpQOUXFNFR05aIn0VHuWNm', 'DP001', 'JB001', 'false'),
('EMP03', 'Falika', 'Cilacap', '2019-01-15', '2020-01-30', 'EMP02', '300000', 'Female', '858798', 'ab@gmail.com', '123', 'DP001', 'JB001', 'false'),
('EMP04', 'Falikaaa', 'asas', '2019-01-31', '2020-01-01', 'EMP03', '300000', 'Female', '112', 'bagus@abid.com', '123', 'DP002', 'JB002', 'false'),
('EMP05', 'Wirda', 'jogja', '2019-01-02', '2020-01-01', 'EMP04', '123121', 'Male', '12345', 'a@gmail.com', '$2a$10$oJdHxL4oeRuGQn7ZAbuGie3A4aViFh8mXk2p9p0rJfCuxp1H23YwC', 'DP001', 'JB002', 'false'),
('EMP06', 'Regita', 'salatiga', '2017-12-31', '2019-12-31', 'EMP02', '123121', 'Female', '0878767677', 'upnormal.bootcamp@gmail.com', '$2a$10$oJdHxL4oeRuGQn7ZAbuGie3A4aViFh8mXk2p9p0rJfCuxp1H23YwC', 'DP002', 'JB001', 'false'),
('EMP07', 'Rosalia', 'Lampung', '2019-12-31', '2021-01-01', 'EMP02', '100000', 'Female', '09898987', 'rosa@gmail.com', '$2a$10$MJ6.Aoxo3OhoAg.M7RavBOtO.mGaHIXndPZ.IaOpsC.V8gIhAumTe', 'DP001', 'JB002', 'false'),
('EMP10', 'Sagita', 'jombang', '2019-12-31', '2020-01-01', 'EMP02', '123121', 'Female', '111', 'samber12@gmail.com', '$2a$10$ZU5SzsJ3wT8mIhmfwJ8S3umuR50D2juFbzjwgv0A2DDgnnZ7qdEZ2', 'DP002', 'JB002', 'false'),
('EMP11', 'Remi', 'Batak', '2019-12-31', '2020-01-01', 'EMP01', '300000', 'Male', '123', 'freditya99@gmail.com', '$2a$10$ck8aGNHiRDB9JtjeLmMlSuMBJSdBLOQAkrGf4YeSf0ZX2QmwhEe5O', 'DP002', 'JB002', 'false'),
('EMP13', 'lala', 'jakarta', '2019-01-01', '2019-12-31', 'EMP01', '300000', 'Female', '12345', 'freditya12@gmail.com', '$2a$10$p9mFGIvswc36EII48RaCcupXkNkwDOOxAmZAn4OaQKR89btzsx47e', 'DP001', 'JB002', 'true');

-- --------------------------------------------------------

--
-- Table structure for table `evaluation_parameter`
--

CREATE TABLE `evaluation_parameter` (
  `evaluationId` varchar(10) NOT NULL,
  `evaluationName` varchar(30) NOT NULL,
  `isDelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `evaluation_parameter`
--

INSERT INTO `evaluation_parameter` (`evaluationId`, `evaluationName`, `isDelete`) VALUES
('EV001', 'CRUDD', 'true');

-- --------------------------------------------------------

--
-- Table structure for table `job`
--

CREATE TABLE `job` (
  `jobId` varchar(10) NOT NULL,
  `jobName` varchar(20) NOT NULL,
  `isDelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `job`
--

INSERT INTO `job` (`jobId`, `jobName`, `isDelete`) VALUES
('JB001', 'Developer', 'false'),
('JB002', 'Designer', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `job_history`
--

CREATE TABLE `job_history` (
  `jobHistoryId` varchar(10) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `departmentId` varchar(10) NOT NULL,
  `jobId` varchar(10) NOT NULL,
  `employeeId` varchar(10) NOT NULL,
  `isDelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  `province_id` varchar(10) NOT NULL,
  `province_name` varchar(30) NOT NULL,
  `is_delete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `province`
--

INSERT INTO `province` (`province_id`, `province_name`, `is_delete`) VALUES
('PR01', 'Yogyakarta', 'false'),
('PR02', 'Banjarnegara', 'true'),
('PR03', 'Lampung', 'false'),
('PR04', 'Lampung', 'false'),
('PR05', 'Sampang', 'true'),
('PR06', 'Kediri ', 'true'),
('PR07', 'Jakarta', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `report_problem`
--

CREATE TABLE `report_problem` (
  `reportId` varchar(10) NOT NULL,
  `reportMessage` varchar(50) NOT NULL,
  `reportDate` datetime NOT NULL,
  `employeeId` varchar(10) NOT NULL,
  `isDelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `respond_problem`
--

CREATE TABLE `respond_problem` (
  `respondId` varchar(10) NOT NULL,
  `respondMessage` varchar(50) NOT NULL,
  `reportId` varchar(10) NOT NULL,
  `employeeId` varchar(10) NOT NULL,
  `isDelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `roleId` varchar(10) NOT NULL,
  `roleName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`roleId`, `roleName`) VALUES
('Role01', 'ADMIN'),
('Role02', 'TRAINER'),
('Role03', 'USER'),
('Role04', 'MANAGER');

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

CREATE TABLE `score` (
  `scoreId` varchar(10) NOT NULL,
  `score` varchar(10) NOT NULL,
  `evaluationId` varchar(10) NOT NULL,
  `isDelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `score`
--

INSERT INTO `score` (`scoreId`, `score`, `evaluationId`, `isDelete`) VALUES
('SC0001', '85', 'EV001', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `site`
--

CREATE TABLE `site` (
  `siteId` varchar(10) NOT NULL,
  `siteName` varchar(30) NOT NULL,
  `villageId` varchar(10) NOT NULL,
  `employeeId` varchar(10) NOT NULL,
  `isDelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `site`
--

INSERT INTO `site` (`siteId`, `siteName`, `villageId`, `employeeId`, `isDelete`) VALUES
('SITE001', 'BNI', 'VL01', 'EMP01', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `sub_district`
--

CREATE TABLE `sub_district` (
  `subDistrictId` varchar(10) NOT NULL,
  `subDistrictName` varchar(20) NOT NULL,
  `districtId` varchar(10) NOT NULL,
  `isDelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sub_district`
--

INSERT INTO `sub_district` (`subDistrictId`, `subDistrictName`, `districtId`, `isDelete`) VALUES
('SD01', 'Samigaluh', 'DI01', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL,
  `employeeId` varchar(10) NOT NULL,
  `roleId` varchar(10) NOT NULL,
  `is_delete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`id`, `employeeId`, `roleId`, `is_delete`) VALUES
(1, 'EMP01', 'Role02', 'false'),
(3, 'EMP05', 'Role01', 'false'),
(4, 'EMP04', 'Role03', 'false'),
(5, 'EMP03', 'Role03', 'false'),
(6, 'EMP06', 'Role01', 'false'),
(7, 'EMP07', 'Role03', 'false'),
(8, 'EMP10', 'Role04', 'false'),
(10, 'EMP11', 'Role04', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `village`
--

CREATE TABLE `village` (
  `villageId` varchar(10) NOT NULL,
  `villageName` varchar(30) NOT NULL,
  `subDistrictId` varchar(10) NOT NULL,
  `isDelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `village`
--

INSERT INTO `village` (`villageId`, `villageName`, `subDistrictId`, `isDelete`) VALUES
('VL01', 'Banjar Sari', 'SD01', 'false');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assessment`
--
ALTER TABLE `assessment`
  ADD PRIMARY KEY (`assessmentId`),
  ADD KEY `employeeId` (`employeeId`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryId`),
  ADD KEY `assessmentId` (`assessmentId`),
  ADD KEY `evaluationId` (`evaluationId`),
  ADD KEY `employeeId` (`employeeId`);

--
-- Indexes for table `confirmation_token`
--
ALTER TABLE `confirmation_token`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employeeId` (`employeeId`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`departmentId`),
  ADD KEY `villageId` (`villageId`),
  ADD KEY `employeeId` (`employeeId`);

--
-- Indexes for table `district`
--
ALTER TABLE `district`
  ADD PRIMARY KEY (`districtId`),
  ADD KEY `provinceId` (`provinceId`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employeeId`),
  ADD KEY `departmentId` (`departmentId`),
  ADD KEY `jobId` (`jobId`),
  ADD KEY `managerId` (`managerId`),
  ADD KEY `departmentId_2` (`departmentId`),
  ADD KEY `jobId_2` (`jobId`);

--
-- Indexes for table `evaluation_parameter`
--
ALTER TABLE `evaluation_parameter`
  ADD PRIMARY KEY (`evaluationId`);

--
-- Indexes for table `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`jobId`);

--
-- Indexes for table `job_history`
--
ALTER TABLE `job_history`
  ADD PRIMARY KEY (`jobHistoryId`),
  ADD KEY `departmentId` (`departmentId`),
  ADD KEY `employeeId` (`employeeId`),
  ADD KEY `jobId` (`jobId`);

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`province_id`);

--
-- Indexes for table `report_problem`
--
ALTER TABLE `report_problem`
  ADD PRIMARY KEY (`reportId`),
  ADD KEY `employeeId` (`employeeId`);

--
-- Indexes for table `respond_problem`
--
ALTER TABLE `respond_problem`
  ADD PRIMARY KEY (`respondId`),
  ADD KEY `reportId` (`reportId`),
  ADD KEY `employeeId` (`employeeId`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`roleId`);

--
-- Indexes for table `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`scoreId`),
  ADD KEY `evaluationId` (`evaluationId`);

--
-- Indexes for table `site`
--
ALTER TABLE `site`
  ADD PRIMARY KEY (`siteId`),
  ADD KEY `employeeId` (`employeeId`),
  ADD KEY `villageId` (`villageId`);

--
-- Indexes for table `sub_district`
--
ALTER TABLE `sub_district`
  ADD PRIMARY KEY (`subDistrictId`),
  ADD KEY `districtId` (`districtId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employeeId` (`employeeId`),
  ADD KEY `roleId` (`roleId`);

--
-- Indexes for table `village`
--
ALTER TABLE `village`
  ADD PRIMARY KEY (`villageId`),
  ADD KEY `subDistrictId` (`subDistrictId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `confirmation_token`
--
ALTER TABLE `confirmation_token`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assessment`
--
ALTER TABLE `assessment`
  ADD CONSTRAINT `assessment_ibfk_1` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`);

--
-- Constraints for table `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `category_ibfk_1` FOREIGN KEY (`assessmentId`) REFERENCES `assessment` (`assessmentId`),
  ADD CONSTRAINT `category_ibfk_2` FOREIGN KEY (`evaluationId`) REFERENCES `evaluation_parameter` (`evaluationId`),
  ADD CONSTRAINT `category_ibfk_3` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`);

--
-- Constraints for table `confirmation_token`
--
ALTER TABLE `confirmation_token`
  ADD CONSTRAINT `confirmation_token_ibfk_1` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `department_ibfk_1` FOREIGN KEY (`villageId`) REFERENCES `village` (`villageId`),
  ADD CONSTRAINT `department_ibfk_2` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_4` FOREIGN KEY (`managerId`) REFERENCES `employee` (`employeeId`),
  ADD CONSTRAINT `employee_ibfk_5` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`),
  ADD CONSTRAINT `employee_ibfk_6` FOREIGN KEY (`jobId`) REFERENCES `job` (`jobId`);

--
-- Constraints for table `job_history`
--
ALTER TABLE `job_history`
  ADD CONSTRAINT `job_history_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`),
  ADD CONSTRAINT `job_history_ibfk_2` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`),
  ADD CONSTRAINT `job_history_ibfk_3` FOREIGN KEY (`jobId`) REFERENCES `job` (`jobId`);

--
-- Constraints for table `report_problem`
--
ALTER TABLE `report_problem`
  ADD CONSTRAINT `report_problem_ibfk_1` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`);

--
-- Constraints for table `respond_problem`
--
ALTER TABLE `respond_problem`
  ADD CONSTRAINT `respond_problem_ibfk_1` FOREIGN KEY (`reportId`) REFERENCES `report_problem` (`reportId`),
  ADD CONSTRAINT `respond_problem_ibfk_2` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`);

--
-- Constraints for table `score`
--
ALTER TABLE `score`
  ADD CONSTRAINT `score_ibfk_1` FOREIGN KEY (`evaluationId`) REFERENCES `evaluation_parameter` (`evaluationId`);

--
-- Constraints for table `site`
--
ALTER TABLE `site`
  ADD CONSTRAINT `site_ibfk_1` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`),
  ADD CONSTRAINT `site_ibfk_2` FOREIGN KEY (`villageId`) REFERENCES `village` (`villageId`);

--
-- Constraints for table `sub_district`
--
ALTER TABLE `sub_district`
  ADD CONSTRAINT `sub_district_ibfk_1` FOREIGN KEY (`districtId`) REFERENCES `district` (`districtId`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`),
  ADD CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
