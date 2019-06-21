-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2019 at 08:21 PM
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
-- Triggers `assessment`
--
DELIMITER $$
CREATE TRIGGER `tg_ass_seq` BEFORE INSERT ON `assessment` FOR EACH ROW BEGIN
  INSERT INTO ass_seq VALUES (NULL);
  SET NEW.assessmentId = CONCAT('AS', LPAD(LAST_INSERT_ID(), 3, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `ass_seq`
--

CREATE TABLE `ass_seq` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

--
-- Triggers `category`
--
DELIMITER $$
CREATE TRIGGER `tg_cat_seq` BEFORE INSERT ON `category` FOR EACH ROW BEGIN
  INSERT INTO cat_seq VALUES (NULL);
  SET NEW.categoryId = CONCAT('CAT', LPAD(LAST_INSERT_ID(), 3, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `cat_seq`
--

CREATE TABLE `cat_seq` (
  `id` int(11) NOT NULL
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
(27, '2cd665f2-d6db-4ddc-8106-6c8dbff68b42', '2019-06-14 00:48:21', 'EMP007');

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
('DEP005', 'MSBU', 'VIL001', NULL, 'false');

--
-- Triggers `department`
--
DELIMITER $$
CREATE TRIGGER `tg_dpt_seq` BEFORE INSERT ON `department` FOR EACH ROW BEGIN
  INSERT INTO dpt_seq VALUES (NULL);
  SET NEW.departmentId = CONCAT('DEP', LPAD(LAST_INSERT_ID(), 3, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `district`
--

CREATE TABLE `district` (
  `districtId` varchar(10) NOT NULL,
  `districtName` varchar(20) DEFAULT NULL,
  `province_id` varchar(10) DEFAULT NULL,
  `isDelete` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `district`
--

INSERT INTO `district` (`districtId`, `districtName`, `province_id`, `isDelete`) VALUES
('DIS001', 'Pasaman', 'PR001', 'false');

--
-- Triggers `district`
--
DELIMITER $$
CREATE TRIGGER `tg_dis_seq` BEFORE INSERT ON `district` FOR EACH ROW BEGIN
  INSERT INTO dis_seq VALUES (NULL);
  SET NEW.districtId = CONCAT('DIS', LPAD(LAST_INSERT_ID(), 3, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `dis_seq`
--

CREATE TABLE `dis_seq` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dis_seq`
--

INSERT INTO `dis_seq` (`id`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `dpt_seq`
--

CREATE TABLE `dpt_seq` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dpt_seq`
--

INSERT INTO `dpt_seq` (`id`) VALUES
(5);

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
  `managerId` varchar(10) DEFAULT NULL,
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
('EMP005', 'Wirda', 'Jalan menuju hatimu', '2019-06-12', '2019-06-05', 'EMP005', '10000', 'Male', '081267546374', 'fredy@gmail.com', '$2y$12$Zk2MRMNQxIhyqyTMkPSOc.1f6da6JTB4D.23q7ZL.D/OjYETeFc8G', 'DEP005', 'JOB001', 'false'),
('EMP006', 'Yosef Hidayat', 'Jalan Kemanggisan Raya No.11 RT 2 RW 15', '1996-08-26', '2019-04-01', 'EMP005', '5000000', 'Male', '081215674637', 'yosefhidayat@gmail.com', '$2y$12$RdwOn1wQZmPJeyAxlqtq6e4H7nUGJyujkUksX.q8hTrr2DhYgG/em', 'DEP005', 'JOB002', 'false'),
('EMP007', 'Freditya', 'Jalan Sudirman No. 24 RT 5 RW 8', '1996-06-04', '2019-04-01', 'EMP006', '5000000', 'Male', '085879885920', 'freditya96@gmail.com', '$2a$10$0KzLjM//Qa5dXAhY6VPAY.n/xACJQmvCKGKR/SDOZlGZWMmplcSWy', 'DEP005', 'JOB003', 'false');

--
-- Triggers `employee`
--
DELIMITER $$
CREATE TRIGGER `tg_emp_seq` BEFORE INSERT ON `employee` FOR EACH ROW BEGIN
  INSERT INTO emp_seq VALUES (NULL);
  SET NEW.employeeId = CONCAT('EMP', LPAD(LAST_INSERT_ID(), 3, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `emp_seq`
--

CREATE TABLE `emp_seq` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emp_seq`
--

INSERT INTO `emp_seq` (`id`) VALUES
(5),
(6),
(7);

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
('EV001', 'Kedisiplinan', 'false');

--
-- Triggers `evaluation_parameter`
--
DELIMITER $$
CREATE TRIGGER `tg_eva_insert` BEFORE INSERT ON `evaluation_parameter` FOR EACH ROW BEGIN
  INSERT INTO eva_seq VALUES (NULL);
  SET NEW.evaluationId = CONCAT('EV', LPAD(LAST_INSERT_ID(), 3, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `eva_seq`
--

CREATE TABLE `eva_seq` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `eva_seq`
--

INSERT INTO `eva_seq` (`id`) VALUES
(1);

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
('JOB001', 'System Analyst', 'true'),
('JOB002', 'Developer', 'false'),
('JOB003', 'Designer', 'false');

--
-- Triggers `job`
--
DELIMITER $$
CREATE TRIGGER `tg_job_seq` BEFORE INSERT ON `job` FOR EACH ROW BEGIN
  INSERT INTO job_seq VALUES (NULL);
  SET NEW.jobId = CONCAT('JOB', LPAD(LAST_INSERT_ID(), 3, '0'));
END
$$
DELIMITER ;

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
-- Table structure for table `job_seq`
--

CREATE TABLE `job_seq` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `job_seq`
--

INSERT INTO `job_seq` (`id`) VALUES
(1),
(2),
(3);

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
('PR001', 'Sumatera Barat', 'false'),
('PR002', 'Yogyakarta', 'false'),
('PR003', 'Banjarnegara', 'true'),
('PR004', 'Lampung', 'false'),
('PR005', 'Sampang', 'true'),
('PR006', 'Kediri ', 'true'),
('PR007', 'Jakarta', 'false'),
('PR008', 'Buton', 'false');

--
-- Triggers `province`
--
DELIMITER $$
CREATE TRIGGER `tg_pro_insert` BEFORE INSERT ON `province` FOR EACH ROW BEGIN
  INSERT INTO pro_seq VALUES (NULL);
  SET NEW.province_id = CONCAT('PR', LPAD(LAST_INSERT_ID(), 3, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `pro_seq`
--

CREATE TABLE `pro_seq` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pro_seq`
--

INSERT INTO `pro_seq` (`id`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8);

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

--
-- Triggers `report_problem`
--
DELIMITER $$
CREATE TRIGGER `tg_rep_insert` BEFORE INSERT ON `report_problem` FOR EACH ROW BEGIN
  INSERT INTO rep_seq VALUES (NULL);
  SET NEW.reportId = CONCAT('REP', LPAD(LAST_INSERT_ID(), 3, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `rep_seq`
--

CREATE TABLE `rep_seq` (
  `id` int(11) NOT NULL
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

--
-- Triggers `respond_problem`
--
DELIMITER $$
CREATE TRIGGER `tg_res_insert` BEFORE INSERT ON `respond_problem` FOR EACH ROW BEGIN
  INSERT INTO res_seq VALUES (NULL);
  SET NEW.respondId = CONCAT('RES', LPAD(LAST_INSERT_ID(), 3, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `res_seq`
--

CREATE TABLE `res_seq` (
  `id` int(11) NOT NULL
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
('ROLE01', 'ADMIN'),
('ROLE02', 'TRAINER'),
('ROLE03', 'USER'),
('ROLE04', 'MANAGER');

--
-- Triggers `role`
--
DELIMITER $$
CREATE TRIGGER `tg_role_insert` BEFORE INSERT ON `role` FOR EACH ROW BEGIN
  INSERT INTO role_seq VALUES (NULL);
  SET NEW.roleId = CONCAT('ROLE', LPAD(LAST_INSERT_ID(), 2, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `role_seq`
--

CREATE TABLE `role_seq` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role_seq`
--

INSERT INTO `role_seq` (`id`) VALUES
(1),
(2),
(3),
(4),
(5);

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
('SCR003', '50', 'EV001', 'false');

--
-- Triggers `score`
--
DELIMITER $$
CREATE TRIGGER `tg_sco_insert` BEFORE INSERT ON `score` FOR EACH ROW BEGIN
  INSERT INTO score_seq VALUES (NULL);
  SET NEW.scoreId = CONCAT('SCR', LPAD(LAST_INSERT_ID(), 3, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `score_seq`
--

CREATE TABLE `score_seq` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `score_seq`
--

INSERT INTO `score_seq` (`id`) VALUES
(3);

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
-- Triggers `site`
--
DELIMITER $$
CREATE TRIGGER `tg_site_insert` BEFORE INSERT ON `site` FOR EACH ROW BEGIN
  INSERT INTO site_seq VALUES (NULL);
  SET NEW.siteId = CONCAT('SITE', LPAD(LAST_INSERT_ID(), 3, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `site_seq`
--

CREATE TABLE `site_seq` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
('SD001', 'Lubuk Sikaping', 'DIS001', 'false'),
('SD004', 'Panti', 'DIS001', 'false');

--
-- Triggers `sub_district`
--
DELIMITER $$
CREATE TRIGGER `tg_sub_insert` BEFORE INSERT ON `sub_district` FOR EACH ROW BEGIN
  INSERT INTO sub_seq VALUES (NULL);
  SET NEW.subDistrictId = CONCAT('SD', LPAD(LAST_INSERT_ID(), 3, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `sub_seq`
--

CREATE TABLE `sub_seq` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sub_seq`
--

INSERT INTO `sub_seq` (`id`) VALUES
(1),
(4);

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
(12, 'EMP007', 'ROLE01', 'false');

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
('VIL001', 'Tanjuang Baringin', 'SD001', 'false');

--
-- Triggers `village`
--
DELIMITER $$
CREATE TRIGGER `tg_vil_insert` BEFORE INSERT ON `village` FOR EACH ROW BEGIN
  INSERT INTO vill_seq VALUES (NULL);
  SET NEW.villageid = CONCAT('VIL', LPAD(LAST_INSERT_ID(), 3, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `vill_seq`
--

CREATE TABLE `vill_seq` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vill_seq`
--

INSERT INTO `vill_seq` (`id`) VALUES
(1);

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
-- Indexes for table `ass_seq`
--
ALTER TABLE `ass_seq`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryId`),
  ADD KEY `assessmentId` (`assessmentId`),
  ADD KEY `evaluationId` (`evaluationId`),
  ADD KEY `employeeId` (`employeeId`);

--
-- Indexes for table `cat_seq`
--
ALTER TABLE `cat_seq`
  ADD PRIMARY KEY (`id`);

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
  ADD KEY `provinceId` (`province_id`);

--
-- Indexes for table `dis_seq`
--
ALTER TABLE `dis_seq`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dpt_seq`
--
ALTER TABLE `dpt_seq`
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `emp_seq`
--
ALTER TABLE `emp_seq`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `evaluation_parameter`
--
ALTER TABLE `evaluation_parameter`
  ADD PRIMARY KEY (`evaluationId`);

--
-- Indexes for table `eva_seq`
--
ALTER TABLE `eva_seq`
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `job_seq`
--
ALTER TABLE `job_seq`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`province_id`);

--
-- Indexes for table `pro_seq`
--
ALTER TABLE `pro_seq`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `report_problem`
--
ALTER TABLE `report_problem`
  ADD PRIMARY KEY (`reportId`),
  ADD KEY `employeeId` (`employeeId`);

--
-- Indexes for table `rep_seq`
--
ALTER TABLE `rep_seq`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `respond_problem`
--
ALTER TABLE `respond_problem`
  ADD PRIMARY KEY (`respondId`),
  ADD KEY `reportId` (`reportId`),
  ADD KEY `employeeId` (`employeeId`);

--
-- Indexes for table `res_seq`
--
ALTER TABLE `res_seq`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`roleId`);

--
-- Indexes for table `role_seq`
--
ALTER TABLE `role_seq`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`scoreId`),
  ADD KEY `evaluationId` (`evaluationId`);

--
-- Indexes for table `score_seq`
--
ALTER TABLE `score_seq`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `site`
--
ALTER TABLE `site`
  ADD PRIMARY KEY (`siteId`),
  ADD KEY `employeeId` (`employeeId`),
  ADD KEY `villageId` (`villageId`);

--
-- Indexes for table `site_seq`
--
ALTER TABLE `site_seq`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sub_district`
--
ALTER TABLE `sub_district`
  ADD PRIMARY KEY (`subDistrictId`),
  ADD KEY `districtId` (`districtId`);

--
-- Indexes for table `sub_seq`
--
ALTER TABLE `sub_seq`
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `vill_seq`
--
ALTER TABLE `vill_seq`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ass_seq`
--
ALTER TABLE `ass_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `cat_seq`
--
ALTER TABLE `cat_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `confirmation_token`
--
ALTER TABLE `confirmation_token`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `dis_seq`
--
ALTER TABLE `dis_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `dpt_seq`
--
ALTER TABLE `dpt_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `emp_seq`
--
ALTER TABLE `emp_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `eva_seq`
--
ALTER TABLE `eva_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `job_seq`
--
ALTER TABLE `job_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `pro_seq`
--
ALTER TABLE `pro_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `rep_seq`
--
ALTER TABLE `rep_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `res_seq`
--
ALTER TABLE `res_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role_seq`
--
ALTER TABLE `role_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `score_seq`
--
ALTER TABLE `score_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `site_seq`
--
ALTER TABLE `site_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `sub_seq`
--
ALTER TABLE `sub_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `vill_seq`
--
ALTER TABLE `vill_seq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
  ADD CONSTRAINT `department_ibfk_1` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`),
  ADD CONSTRAINT `department_ibfk_2` FOREIGN KEY (`villageId`) REFERENCES `village` (`villageId`);

--
-- Constraints for table `district`
--
ALTER TABLE `district`
  ADD CONSTRAINT `district_ibfk_1` FOREIGN KEY (`province_id`) REFERENCES `province` (`province_id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`),
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`jobId`) REFERENCES `job` (`jobId`),
  ADD CONSTRAINT `employee_ibfk_3` FOREIGN KEY (`managerId`) REFERENCES `employee` (`employeeId`);

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

--
-- Constraints for table `village`
--
ALTER TABLE `village`
  ADD CONSTRAINT `village_ibfk_1` FOREIGN KEY (`subDistrictId`) REFERENCES `sub_district` (`subDistrictId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
