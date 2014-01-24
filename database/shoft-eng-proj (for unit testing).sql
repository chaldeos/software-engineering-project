-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Φιλοξενητής: localhost
-- Χρόνος δημιουργίας: 24 Ιαν 2014 στις 22:00:26
-- Έκδοση Διακομιστή: 5.5.23
-- Έκδοση PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Βάση: `shoft-eng-proj`
--

-- --------------------------------------------------------

--
-- Δομή Πίνακα για τον Πίνακα `busses`
--

DROP TABLE IF EXISTS `busses`;
CREATE TABLE IF NOT EXISTS `busses` (
  `bid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `numberplate` varchar(10) NOT NULL,
  `cc` int(10) unsigned NOT NULL,
  `brand` varchar(255) NOT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Άδειασμα δεδομένων του πίνακα `busses`
--

INSERT INTO `busses` (`bid`, `numberplate`, `cc`, `brand`) VALUES
(1, 'AD123D', 1200, 'Volvo'),
(2, 'GF236S', 10000, 'Ferrari');

-- --------------------------------------------------------

--
-- Δομή Πίνακα για τον Πίνακα `busses_users`
--

DROP TABLE IF EXISTS `busses_users`;
CREATE TABLE IF NOT EXISTS `busses_users` (
  `bid` int(10) unsigned NOT NULL,
  `uid` int(10) unsigned NOT NULL,
  KEY `bid` (`bid`),
  KEY `uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `busses_users`
--

INSERT INTO `busses_users` (`bid`, `uid`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Δομή Πίνακα για τον Πίνακα `fuellings`
--

DROP TABLE IF EXISTS `fuellings`;
CREATE TABLE IF NOT EXISTS `fuellings` (
  `fid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bid` int(10) unsigned NOT NULL,
  `litres` float unsigned NOT NULL,
  `km` float unsigned NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comments` varchar(1023) DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `bid` (`bid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Άδειασμα δεδομένων του πίνακα `fuellings`
--

INSERT INTO `fuellings` (`fid`, `bid`, `litres`, `km`, `date`, `comments`) VALUES
(1, 1, 100, 1000, '2014-01-22 21:54:53', 'Σχόλιο'),
(2, 1, 10, 100, '2014-01-22 18:47:41', NULL);

-- --------------------------------------------------------

--
-- Δομή Πίνακα για τον Πίνακα `reports`
--

DROP TABLE IF EXISTS `reports`;
CREATE TABLE IF NOT EXISTS `reports` (
  `rid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bid` int(10) unsigned NOT NULL,
  `uid` int(10) unsigned NOT NULL,
  `report_txt` text NOT NULL,
  PRIMARY KEY (`rid`),
  KEY `uid` (`uid`),
  KEY `bid` (`bid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Άδειασμα δεδομένων του πίνακα `reports`
--

INSERT INTO `reports` (`rid`, `bid`, `uid`, `report_txt`) VALUES
(1, 1, 1, 'Αναφορά');

-- --------------------------------------------------------

--
-- Δομή Πίνακα για τον Πίνακα `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(128) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `tin` varchar(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `sex` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `type` tinyint(3) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Άδειασμα δεδομένων του πίνακα `users`
--

INSERT INTO `users` (`uid`, `username`, `password`, `firstname`, `surname`, `tin`, `address`, `phone`, `sex`, `type`) VALUES
(1, 'driver', 'f822fb532108ebd2b494dd9f475231b12e59cf4dea4b126f0dd27b9a5f0afa45942581403dd6ceb7cd3e84836c90a085ec94e7459a5b8d7bf56035ae81a328d3', 'Νίκος', 'Νικολάου', '123456789', 'Α', '1234567890', 0, 2),
(4, 'admin', 'f822fb532108ebd2b494dd9f475231b12e59cf4dea4b126f0dd27b9a5f0afa45942581403dd6ceb7cd3e84836c90a085ec94e7459a5b8d7bf56035ae81a328d3', 'admin', 'admin', '123456789', '123456', '1234567890', 0, 0),
(5, 'driver_2', 'f822fb532108ebd2b494dd9f475231b12e59cf4dea4b126f0dd27b9a5f0afa45942581403dd6ceb7cd3e84836c90a085ec94e7459a5b8d7bf56035ae81a328d3', 'Γιώργος', 'Γεωργίου', '987654321', 'Β', '9876543210', 0, 2),
(14, 'empl', '71a806f64f136e7ab9fdcb9e6d4a346bd7386f7732a044ea045ac21da9b2a1096f57d704ba86855b72cb634dacde7a7dd4337a0408beac61e8dd40609ee62242', 'Χρηστίνα', 'Χρήστου', '123456789', '123456', '1234567890', 1, 1);

--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `busses_users`
--
ALTER TABLE `busses_users`
  ADD CONSTRAINT `busses_users_ibfk_1` FOREIGN KEY (`bid`) REFERENCES `busses` (`bid`),
  ADD CONSTRAINT `busses_users_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`);

--
-- Περιορισμοί για πίνακα `fuellings`
--
ALTER TABLE `fuellings`
  ADD CONSTRAINT `fuellings_ibfk_1` FOREIGN KEY (`bid`) REFERENCES `busses` (`bid`);

--
-- Περιορισμοί για πίνακα `reports`
--
ALTER TABLE `reports`
  ADD CONSTRAINT `reports_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`),
  ADD CONSTRAINT `reports_ibfk_2` FOREIGN KEY (`bid`) REFERENCES `busses` (`bid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
