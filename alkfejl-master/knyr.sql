-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2016. Ápr 07. 19:13
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `cpvkodok`
--

INSERT INTO `cpvkodok` (`cpvid`, `cpvkod`, `lathato`) VALUES
(1, 11111111, 1),
(2, 22222, 0),
(3, 1234567891, 1),
(4, 111, 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `kozbeszerzesieljarasfajtai`
--

INSERT INTO `kozbeszerzesieljarasfajtai` (`kejid`, `kozbeszerzesieljarasfajtai`, `lathato`) VALUES
(2, 'Nyílt eljárás', 1),
(3, 'Meghívásos', 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `projektek`
--

INSERT INTO `projektek` (`projektid`, `projekt`, `lathato`) VALUES
(2, 'IT beszerzés', 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `szerzodes`
--

INSERT INTO `szerzodes` (`sorszam`, `szerzodesneve`, `szerzodofel`, `szerzodeskotesdatuma`, `szerzodesfajtaja`, `kozbeszerzesieljarasfajta`, `cpvkod`, `projekt`, `szerzodeserteke`, `szerzodestervezettlezarasa`, `megjegyzes`) VALUES
(4, 'besz', 3, '2016-04-04', 2, 3, 1, 2, 345, '2016-04-09', 'ok'),
(8, '??', 3, '2016-04-06', 2, 2, 1, 2, 155, '2016-04-09', 'ok');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `szerzodesfajtai`
--

INSERT INTO `szerzodesfajtai` (`szerzodesfajtaid`, `szerzodesfajta`, `lathato`) VALUES
(2, 'Megbízási szerz?dés', 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `szerzodo_fel`
--

INSERT INTO `szerzodo_fel` (`szfid`, `szerzodofel`, `szekhely-varos`, `szekhely-iranyitoszam`, `szekhely-kozterulet`, `szekhely-hazszam`, `telefonszam`, `faxszam`, `e-mail`, `cegjegyzekszam`, `adoszam`, `kapcsolattarto-neve`, `kapcsolattarto-tel`, `kapcsolattarto-email`) VALUES
(3, 'valaki', 'f', 1111, 'asdhas', 55, '1235678', '234567', 'gggg@hu.lr', '88-88-888888', '12345678-1-12', 'cxvy', '45', 'm@telenor.hu'),
(5, '??', '??', 4444, 'g', 4, '5', '1', 'v@bk.ji', '88-88-999999', '88888888-8-88', '??', '5', 'v@bk.ji');

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
