-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 22, 2018 at 06:56 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pia projekat 2017-18 filmovi`
--
CREATE DATABASE IF NOT EXISTS `pia projekat 2017-18 filmovi` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `pia projekat 2017-18 filmovi`;

-- --------------------------------------------------------

--
-- Table structure for table `festival`
--

CREATE TABLE IF NOT EXISTS `festival` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datumPočetka` date NOT NULL,
  `datumKraja` date NOT NULL,
  `opis` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `grad` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `maksUlaznicaPoKorisniku` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `festival`
--

INSERT INTO `festival` (`id`, `naziv`, `datumPočetka`, `datumKraja`, `opis`, `grad`, `maksUlaznicaPoKorisniku`) VALUES
(1, '46. Fest', '2017-12-23', '2018-03-01', 'Prvi FEST pod naslovom Hrabri novi svet otvoren je\r\n9. januara 1971. u Domu Sindikata', 'Beograd', 5),
(2, '70. kanski filmski festival', '2017-05-17', '2017-05-28', 'Kanski filmski festival (franc. Le Festival International du Film de Cannes) se održava svake godine u gradu Kanu na jugu Francuske još od 1946. Najprestižnija nagrada (za najbolji film) je Zlatna palma (Palme d\'Or).', 'Kan', 3);

-- --------------------------------------------------------

--
-- Table structure for table `festivalilokacije`
--

CREATE TABLE IF NOT EXISTS `festivalilokacije` (
  `idFestivala` int(11) NOT NULL,
  `idLokacije` int(11) NOT NULL,
  PRIMARY KEY (`idFestivala`,`idLokacije`),
  UNIQUE KEY `idFestivala` (`idFestivala`,`idLokacije`),
  UNIQUE KEY `idFestivala_2` (`idFestivala`,`idLokacije`),
  KEY `FestivaliLokacije2` (`idLokacije`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `festivalilokacije`
--

INSERT INTO `festivalilokacije` (`idFestivala`, `idLokacije`) VALUES
(1, 1),
(1, 2),
(2, 5);

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE IF NOT EXISTS `film` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazivSrpski` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nazivOriginal` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `poster` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `godina` int(11) DEFAULT NULL,
  `opis` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reditelj` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `glavniGlumci` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `trajanje` int(11) DEFAULT NULL,
  `zemlja` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `linkIMDB` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `linkRT` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `linkYoutube` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`id`, `nazivSrpski`, `nazivOriginal`, `poster`, `godina`, `opis`, `reditelj`, `glavniGlumci`, `trajanje`, `zemlja`, `linkIMDB`, `linkRT`, `linkYoutube`) VALUES
(1, 'Ničije dete', 'No one’s child', 'resources/images/posteri/1.jpg', 2014, 'At late eighties, a boy has been found in mountains of Bosnia\nand Herzegovina. Nobody found out how he came in wild, nor if animals fed and\nraised him.', 'Vuk Rsumovic', 'Denis Muric, Milos Timotijevic, Pavle Cemerikic', 95, 'Serbia,Croatia', 'http://www.imdb.com/title/tt3059656', 'https://www.rottentomatoes.com/m/nicije_dete', NULL),
(2, 'Kvadrat', 'The Square', 'resources/images/posteri/2.jpg', 2017, 'The Square is a poignant satirical drama reflecting our times - about the sense of community, moral courage and the affluent person\'s need for egocentricity in an increasingly uncertain world.', 'Ruben Östlund', 'Claes Bang, Elisabeth Moss, Dominic West', 142, 'Sweden, Germany, France, Denmark', 'http://www.imdb.com/title/tt4995790', 'https://www.rottentomatoes.com/m/the_square_2017', 'https://www.youtube.com/v/zKDPrpJEGBY'),
(3, 'Ko to tamo peva', 'Ko to tamo peva', NULL, 1980, 'Vozi, Miško!', 'Slobodan Šijan', 'Pavle Vuisić, Dragan Nikolić, Danilo Bata Stojković, Aleksandar Berček, Neda Arnerić, Milivoje Tomić', 86, 'Jugoslavija', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE IF NOT EXISTS `korisnik` (
  `korisničko_ime` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `lozinka` varbinary(255) NOT NULL,
  `ime` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `telefon` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `e-mail` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `tip` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `odobren` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`korisničko_ime`),
  UNIQUE KEY `e-mail` (`e-mail`),
  UNIQUE KEY `korisničko_ime` (`korisničko_ime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`korisničko_ime`, `lozinka`, `ime`, `prezime`, `telefon`, `e-mail`, `tip`, `odobren`) VALUES
('Administrator', 0x4171776531323321, 'Aleksandar', 'Plahćinski', '061/2345678', 'a.plahcinski@gmail.com', 'administrator', 1),
('DjordjeDj', 0x4171776531323321, 'Djordje', 'Djordjevic', '011/4848484', 'djdjordjevic1989@gmail.com', 'gledalac', 1),
('drasko', 0x4171776531323321, 'Dražen', 'Drašković', '011/3218-392', 'drazen.draskovic@etf.bg.ac.rs', 'gledalac', 1),
('Jason_73', 0x3f3f3f3f3f3f3f3f3f3f, 'Milan', 'Dragutinović', '0657483920', 'jasonforever73@gmail.com', 'gledalac', 1),
('JovanJ', 0x4171776531323321, 'Jovan', 'Jovanović', '064/3333333', 'jovanjovanovic72@gmail.com', 'prodavac', 1),
('KataL', 0x4171776531323321, 'Katarina', 'Lazić', '069/9876543', 'lazicstjuardesa@gmail.com', 'gledalac', 1),
('markom', 0x4171776531323321, 'Marko', 'Mišić', NULL, 'marko.misic@etf.bg.ac.rs', 'gledalac', 0),
('micko', 0x4171776531323321, 'Marko', 'Mićović', NULL, 'micko@etf.bg.ac.rs', 'prodavac', 1),
('Pata', 0x4171776531323321, 'Sabina', 'Pataković', NULL, 'sabina.friedrich@gmail.com', 'gledalac', 0),
('sanja', 0x4171776531323321, 'Sanja', 'Delčev', '011/3218-392', 'sanjad@etf.bg.ac.rs', 'gledalac', 1),
('sasa', 0x4171776531323321, 'Sasa', 'Stojanovic', '011/3218-385', 'stojsasa@etf.bg.ac.rs', 'gledalac', 0),
('ZlataT', 0x646464, 'Zlata', 'Tadić', '065/4444888', 'zlata.tadic@gmail.com', 'prodavac', 1);

-- --------------------------------------------------------

--
-- Table structure for table `lokacija`
--

CREATE TABLE IF NOT EXISTS `lokacija` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `grad` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `lokacija`
--

INSERT INTO `lokacija` (`id`, `naziv`, `grad`) VALUES
(1, 'Sava Centar,Velika sala', 'Beograd'),
(2, 'Dom sindikata', 'Beograd'),
(3, 'Kanli kula', 'Herceg Novi'),
(4, 'Forte mare', 'Herceg Novi'),
(5, 'Palais des Festivals', 'Kan');

-- --------------------------------------------------------

--
-- Table structure for table `ocena`
--

CREATE TABLE IF NOT EXISTS `ocena` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `korisnik` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idFilma` int(11) NOT NULL,
  `vrednost` int(11) NOT NULL,
  `komentar` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `korisnik` (`korisnik`,`idFilma`),
  KEY `OcenaFilm` (`idFilma`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ocena`
--

INSERT INTO `ocena` (`id`, `korisnik`, `idFilma`, `vrednost`, `komentar`) VALUES
(1, 'drasko', 1, 10, 'Ma super je!'),
(2, 'sanja', 2, 7, NULL),
(3, 'KataL', 2, 5, 'Saw it at Hamptons film festival. A little strange a way too long. There really wasn\'t a buzz afterwards.');

-- --------------------------------------------------------

--
-- Table structure for table `projekcija`
--

CREATE TABLE IF NOT EXISTS `projekcija` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idFestivala` int(11) NOT NULL,
  `idFilma` int(11) NOT NULL,
  `idLokacije` int(11) NOT NULL,
  `vreme` datetime NOT NULL,
  `otkazana` int(11) NOT NULL DEFAULT '0',
  `cena` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idFestivala` (`idFestivala`,`idFilma`,`idLokacije`,`vreme`),
  KEY `ProjekcijaFilm` (`idFilma`),
  KEY `ProjekcijaLokacija` (`idLokacije`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

--
-- Dumping data for table `projekcija`
--

INSERT INTO `projekcija` (`id`, `idFestivala`, `idFilma`, `idLokacije`, `vreme`, `otkazana`, `cena`) VALUES
(1, 2, 2, 5, '2017-05-20 11:30:00', 0, 100),
(2, 2, 2, 5, '2017-05-20 22:00:00', 0, 200),
(3, 2, 2, 5, '2017-05-28 13:45:00', 0, 150),
(4, 1, 1, 2, '2018-03-01 20:30:00', 0, 100),
(5, 1, 3, 1, '2018-03-02 18:50:27', 0, 200);

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE IF NOT EXISTS `rezervacija` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kod` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `brojUlaznica` int(11) NOT NULL,
  `vremeRezervacije` datetime NOT NULL,
  `kupljena` int(11) NOT NULL DEFAULT '0',
  `korisnik` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idProjekcije` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `kodJedinstvenIndeks` (`kod`),
  KEY `RezervacijaKorisnik` (`korisnik`),
  KEY `RezervacijaProjekcija` (`idProjekcije`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`id`, `kod`, `brojUlaznica`, `vremeRezervacije`, `kupljena`, `korisnik`, `idProjekcije`) VALUES
(1, 'ABCDEFGHIJ', 1, '2017-04-19 15:33:59', 1, 'sanja', 1),
(2, 'ABCDEFGHIK', 3, '2017-03-05 02:12:24', 0, 'KataL', 2),
(3, 'JYYMJREMOG', 2, '2018-02-21 20:45:37', 1, 'drasko', 5),
(4, 'OMBPMVCTGS', 1, '2018-02-21 22:46:11', 0, 'sasa', 5),
(5, 'QHIXJQWQMR', 5, '2018-02-21 22:49:37', 0, 'Jason_73', 5),
(6, 'FPXEAXOASW', 20, '2018-02-22 00:01:16', 1, 'Jason_73', 5);

-- --------------------------------------------------------

--
-- Table structure for table `slika`
--

CREATE TABLE IF NOT EXISTS `slika` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idFilma` int(11) NOT NULL,
  `putanja` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFilm` (`idFilma`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `slika`
--

INSERT INTO `slika` (`id`, `idFilma`, `putanja`) VALUES
(1, 1, 'resources/images/galerija/1/1.jpg'),
(2, 1, 'resources/images/galerija/1/2.jpg'),
(3, 1, 'resources/images/galerija/1/3.jpg'),
(4, 2, 'resources/images/galerija/2/1.jpg'),
(5, 2, 'resources/images/galerija/2/2.jpg'),
(6, 2, 'resources/images/galerija/2/3.jpg'),
(7, 2, 'resources/images/galerija/2/4.jpg');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `festivalilokacije`
--
ALTER TABLE `festivalilokacije`
  ADD CONSTRAINT `FestivaliLokacije1` FOREIGN KEY (`idFestivala`) REFERENCES `festival` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FestivaliLokacije2` FOREIGN KEY (`idLokacije`) REFERENCES `lokacija` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `ocena`
--
ALTER TABLE `ocena`
  ADD CONSTRAINT `OcenaFilm` FOREIGN KEY (`idFilma`) REFERENCES `film` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `OcenaKorisnik` FOREIGN KEY (`korisnik`) REFERENCES `korisnik` (`korisničko_ime`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `projekcija`
--
ALTER TABLE `projekcija`
  ADD CONSTRAINT `ProjekcijaFestival` FOREIGN KEY (`idFestivala`) REFERENCES `festival` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ProjekcijaFilm` FOREIGN KEY (`idFilma`) REFERENCES `film` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ProjekcijaLokacija` FOREIGN KEY (`idLokacije`) REFERENCES `lokacija` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD CONSTRAINT `RezervacijaKorisnik` FOREIGN KEY (`korisnik`) REFERENCES `korisnik` (`korisničko_ime`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `RezervacijaProjekcija` FOREIGN KEY (`idProjekcije`) REFERENCES `projekcija` (`id`);

--
-- Constraints for table `slika`
--
ALTER TABLE `slika`
  ADD CONSTRAINT `FKFilm` FOREIGN KEY (`idFilma`) REFERENCES `film` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
