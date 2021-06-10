-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.5.7-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- loginpractice 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `loginpractice` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `loginpractice`;

-- 테이블 loginpractice.membership 구조 내보내기
CREATE TABLE IF NOT EXISTS `membership` (
  `ID` varchar(50) NOT NULL,
  `PW` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Gender` varchar(50) NOT NULL,
  `Birth` varchar(50) NOT NULL DEFAULT '',
  `Email` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 loginpractice.membership:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `membership` DISABLE KEYS */;
INSERT IGNORE INTO `membership` (`ID`, `PW`, `Name`, `Gender`, `Birth`, `Email`, `Phone`) VALUES
	('chodong98', 'hs8877', '추효동', 'Female', '981126', 'hodong98@naver.com', '01066784567'),
	('JHS1119', 'JHS03070911', '장혜선', 'Female', '20031119', 'ladyvampire@naver.com', '01021299480'),
	('jjych072', 'ms03070911', '장혁수', 'Male', '980304', 'jjych072@naver.com', '01047739480');
/*!40000 ALTER TABLE `membership` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
