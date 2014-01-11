-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Φιλοξενητής: localhost
-- Χρόνος δημιουργίας: 07 Ιαν 2014 στις 23:11:16
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

CREATE TABLE IF NOT EXISTS `busses` (
  `bid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `numberplate` varchar(10) NOT NULL,
  `cc` int(10) unsigned NOT NULL,
  `brand` varchar(255) NOT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Δομή Πίνακα για τον Πίνακα `busses_users`
--

CREATE TABLE IF NOT EXISTS `busses_users` (
  `bid` int(10) unsigned NOT NULL,
  `uid` int(10) unsigned NOT NULL,
  KEY `bid` (`bid`),
  KEY `uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Δομή Πίνακα για τον Πίνακα `fuellings`
--

CREATE TABLE IF NOT EXISTS `fuellings` (
  `fid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bid` int(10) unsigned NOT NULL,
  `litres` float unsigned NOT NULL,
  `km` float unsigned NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comments` varchar(1023) DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `bid` (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Δομή Πίνακα για τον Πίνακα `reports`
--

CREATE TABLE IF NOT EXISTS `reports` (
  `rid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bid` int(10) unsigned NOT NULL,
  `uid` int(10) unsigned NOT NULL,
  `report_txt` text NOT NULL,
  PRIMARY KEY (`rid`),
  KEY `uid` (`uid`),
  KEY `bid` (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Δομή Πίνακα για τον Πίνακα `users`
--

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `busses_users`
--
ALTER TABLE `busses_users`
  ADD CONSTRAINT `busses_users_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`),
  ADD CONSTRAINT `busses_users_ibfk_1` FOREIGN KEY (`bid`) REFERENCES `busses` (`bid`);

--
-- Περιορισμοί για πίνακα `fuellings`
--
ALTER TABLE `fuellings`
  ADD CONSTRAINT `fuellings_ibfk_1` FOREIGN KEY (`bid`) REFERENCES `busses` (`bid`);

--
-- Περιορισμοί για πίνακα `reports`
--
ALTER TABLE `reports`
  ADD CONSTRAINT `reports_ibfk_2` FOREIGN KEY (`bid`) REFERENCES `busses` (`bid`),
  ADD CONSTRAINT `reports_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
