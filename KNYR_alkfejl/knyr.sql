-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2016. Ápr 09. 07:40
-- Kiszolgáló verziója: 5.7.9
-- PHP verzió: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `knyr`
--
CREATE DATABASE IF NOT EXISTS `knyr` DEFAULT CHARACTER SET utf8 COLLATE utf8_hungarian_ci;
USE `knyr`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `cpvkodok`
--

DROP TABLE IF EXISTS `cpvkodok`;
CREATE TABLE IF NOT EXISTS `cpvkodok` (
  `cpvid` int(11) NOT NULL AUTO_INCREMENT,
  `cpvkod` int(15) NOT NULL,
  `lathato` tinyint(1) NOT NULL,
  PRIMARY KEY (`cpvid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `cpvkodok`
--

INSERT INTO `cpvkodok` (`cpvid`, `cpvkod`, `lathato`) VALUES
(5, 123456789, 1),
(6, 123123123, 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `kozbeszerzesieljarasfajtai`
--

DROP TABLE IF EXISTS `kozbeszerzesieljarasfajtai`;
CREATE TABLE IF NOT EXISTS `kozbeszerzesieljarasfajtai` (
  `kejid` int(11) NOT NULL AUTO_INCREMENT,
  `kozbeszerzesieljarasfajtai` char(150) COLLATE utf8_hungarian_ci NOT NULL,
  `lathato` tinyint(1) NOT NULL,
  PRIMARY KEY (`kejid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `kozbeszerzesieljarasfajtai`
--

INSERT INTO `kozbeszerzesieljarasfajtai` (`kejid`, `kozbeszerzesieljarasfajtai`, `lathato`) VALUES
(5, 'nyílt eljárás', 1),
(6, 'meghívásos eljárás', 1),
(7, 'tárgyalásos eljárás', 1),
(8, 'versenytárgyalásos eljárás', 1),
(9, 'értékhatár alatti', 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `projektek`
--

DROP TABLE IF EXISTS `projektek`;
CREATE TABLE IF NOT EXISTS `projektek` (
  `projektid` int(11) NOT NULL AUTO_INCREMENT,
  `projekt` char(150) COLLATE utf8_hungarian_ci NOT NULL,
  `lathato` tinyint(1) NOT NULL,
  PRIMARY KEY (`projektid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `projektek`
--

INSERT INTO `projektek` (`projektid`, `projekt`, `lathato`) VALUES
(6, 'Irodaszer', 1),
(7, 'Vas utcai építkezés', 1),
(8, 'Rendszerbevezetés', 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szerzodes`
--

DROP TABLE IF EXISTS `szerzodes`;
CREATE TABLE IF NOT EXISTS `szerzodes` (
  `sorszam` int(11) NOT NULL AUTO_INCREMENT,
  `szerzodesneve` char(100) COLLATE utf8_hungarian_ci NOT NULL,
  `szerzodofel` int(11) NOT NULL,
  `szerzodeskotesdatuma` date NOT NULL,
  `szerzodesfajtaja` int(11) NOT NULL,
  `kozbeszerzesieljarasfajta` int(11) NOT NULL,
  `cpvkod` int(11) NOT NULL,
  `projekt` int(11) NOT NULL,
  `szerzodeserteke` int(11) NOT NULL,
  `szerzodestervezettlezarasa` date NOT NULL,
  `megjegyzes` char(250) COLLATE utf8_hungarian_ci NOT NULL,
  PRIMARY KEY (`sorszam`),
  KEY `szerzodofel` (`szerzodofel`),
  KEY `projekt` (`projekt`),
  KEY `cpvkod` (`cpvkod`),
  KEY `kozbeszerzésieljarasfajta` (`kozbeszerzesieljarasfajta`),
  KEY `szerzodesfajtaja` (`szerzodesfajtaja`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `szerzodes`
--

INSERT INTO `szerzodes` (`sorszam`, `szerzodesneve`, `szerzodofel`, `szerzodeskotesdatuma`, `szerzodesfajtaja`, `kozbeszerzesieljarasfajta`, `cpvkod`, `projekt`, `szerzodeserteke`, `szerzodestervezettlezarasa`, `megjegyzes`) VALUES
(10, 'irodaszer beszerzés', 7, '2016-04-07', 4, 9, 5, 6, 5400000, '2016-04-30', 'ok'),
(11, 'Építés', 8, '2016-03-28', 5, 5, 6, 7, 5800000, '2016-08-31', 'ok'),
(12, 'IT beszerzés', 7, '2016-04-04', 6, 9, 5, 8, 8000, '2016-04-06', 'ok'),
(13, 'Székek', 7, '2016-04-13', 6, 6, 6, 6, 75000, '2016-05-17', 'ok');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szerzodesfajtai`
--

DROP TABLE IF EXISTS `szerzodesfajtai`;
CREATE TABLE IF NOT EXISTS `szerzodesfajtai` (
  `szerzodesfajtaid` int(11) NOT NULL AUTO_INCREMENT,
  `szerzodesfajta` char(150) COLLATE utf8_hungarian_ci NOT NULL,
  `lathato` tinyint(1) NOT NULL,
  PRIMARY KEY (`szerzodesfajtaid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `szerzodesfajtai`
--

INSERT INTO `szerzodesfajtai` (`szerzodesfajtaid`, `szerzodesfajta`, `lathato`) VALUES
(4, 'megbízási szerződés', 1),
(5, 'vállalkozási szerződés', 1),
(6, 'szállítási szerződés', 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szerzodo_fel`
--

DROP TABLE IF EXISTS `szerzodo_fel`;
CREATE TABLE IF NOT EXISTS `szerzodo_fel` (
  `szfid` int(11) NOT NULL AUTO_INCREMENT,
  `szerzodofel` char(100) COLLATE utf8_hungarian_ci NOT NULL,
  `szekhely-varos` char(50) COLLATE utf8_hungarian_ci NOT NULL,
  `szekhely-iranyitoszam` int(11) NOT NULL,
  `szekhely-kozterulet` char(100) COLLATE utf8_hungarian_ci NOT NULL,
  `szekhely-hazszam` int(11) NOT NULL,
  `telefonszam` char(25) COLLATE utf8_hungarian_ci NOT NULL,
  `faxszam` char(25) COLLATE utf8_hungarian_ci NOT NULL,
  `e-mail` char(50) COLLATE utf8_hungarian_ci NOT NULL,
  `cegjegyzekszam` char(15) COLLATE utf8_hungarian_ci NOT NULL,
  `adoszam` char(15) COLLATE utf8_hungarian_ci NOT NULL,
  `kapcsolattarto-neve` char(100) COLLATE utf8_hungarian_ci NOT NULL,
  `kapcsolattarto-tel` char(25) COLLATE utf8_hungarian_ci NOT NULL,
  `kapcsolattarto-email` char(50) COLLATE utf8_hungarian_ci NOT NULL,
  PRIMARY KEY (`szfid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `szerzodo_fel`
--

INSERT INTO `szerzodo_fel` (`szfid`, `szerzodofel`, `szekhely-varos`, `szekhely-iranyitoszam`, `szekhely-kozterulet`, `szekhely-hazszam`, `telefonszam`, `faxszam`, `e-mail`, `cegjegyzekszam`, `adoszam`, `kapcsolattarto-neve`, `kapcsolattarto-tel`, `kapcsolattarto-email`) VALUES
(7, 'Kisker Kft', 'Budapest', 1221, 'Kő utca', 12, '2482457', '4578125', 'valaki@kisker.hu', '15-58-865412', '78945612-2-23', 'Béla', '2482457', 'bela@kisker.hu'),
(8, 'Nagyker Kft.', 'Eger', 2145, 'Ezer köz', 1, '0625487965', '0625487965', 'nagyker@info.hu', '45-45-896523', '01234567-5-88', 'Mari', '0625487965', 'mari@nagyker.hu');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `NEV` varchar(50) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `JELSZO` varchar(50) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `SZERKESZTHET` tinyint(4) NOT NULL,
  `ADMINE` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `user`
--

INSERT INTO `user` (`NEV`, `JELSZO`, `SZERKESZTHET`, `ADMINE`) VALUES
('admin', 'admin', 1, 1);

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `szerzodes`
--
ALTER TABLE `szerzodes`
  ADD CONSTRAINT `szerzodes_ibfk_1` FOREIGN KEY (`szerzodofel`) REFERENCES `szerzodo_fel` (`szfid`),
  ADD CONSTRAINT `szerzodes_ibfk_2` FOREIGN KEY (`projekt`) REFERENCES `projektek` (`projektid`),
  ADD CONSTRAINT `szerzodes_ibfk_3` FOREIGN KEY (`kozbeszerzesieljarasfajta`) REFERENCES `kozbeszerzesieljarasfajtai` (`kejid`),
  ADD CONSTRAINT `szerzodes_ibfk_4` FOREIGN KEY (`cpvkod`) REFERENCES `cpvkodok` (`cpvid`),
  ADD CONSTRAINT `szerzodes_ibfk_5` FOREIGN KEY (`szerzodesfajtaja`) REFERENCES `szerzodesfajtai` (`szerzodesfajtaid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
