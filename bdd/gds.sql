-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 23 Mai 2017 à 10:24
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gds`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `login` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

CREATE TABLE `entreprise` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `adnum` varchar(255) DEFAULT NULL,
  `adrue` varchar(255) DEFAULT NULL,
  `adville` varchar(255) DEFAULT NULL,
  `adcp` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `siret` varchar(255) DEFAULT NULL,
  `ape` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `entreprise`
--

INSERT INTO `entreprise` (`id`, `nom`, `adnum`, `adrue`, `adville`, `adcp`, `tel`, `mail`, `siret`, `ape`) VALUES
(1, 'qzrgqerg', 'eqrhqerh', 'qerhqerh', 'qerhqerh', 'qerhqerh', 'qerhqerh', 'hqerhqerh', 'qerhqerhhqe', 'rhqerhqewrh'),
(4, 'raison', 'ruenum', 'rue', 'ville', 'cp', 'tel', 'courriel', 'siret', 'ape'),
(5, 'Arcu LLP', '59', '84', 'Amlwch', '59965', '05 57 10 54 61', 'ante.blandit.viverra@dapibus.com', '78SAY5YA', '386218'),
(6, 'Sed Nunc Incorporated', '19', '75', 'Calera de Tango', '08715', '07 89 69 94 48', 'lacinia.Sed.congue@tellus.co.uk', '01AVD8KE', '775767'),
(7, 'Nisi Consulting', '17', '87', 'Waalwijk', '91972', '07 06 12 69 81', 'lorem@vitaepurus.edu', '64XUM9CK', '819912'),
(8, 'Mi Aliquam Inc.', '30', '12', 'Genk', '40258', '07 49 45 48 49', 'Nunc.sollicitudin@egetmollislectus.ca', '49ZAO7BO', '260319'),
(9, 'Vel Inc.', '11', '98', 'Wolfenbüttel', '36344', '09 91 57 87 15', 'placerat@ornare.edu', '55WBP5BP', '984633'),
(10, 'Quis Diam Pellentesque Limited', '98', '8', 'High Level', '80482', '01 19 78 30 96', 'egestas@Aliquamauctor.ca', '75VNF5AY', '359252'),
(11, 'Luctus Et PC', '25', '60', 'Dignano', '93877', '05 89 41 53 47', 'commodo.tincidunt.nibh@convallisin.net', '60DSE2JI', '583372'),
(12, 'Vitae Industries', '53', '32', 'Bomal', '07625', '05 68 14 02 42', 'vulputate.nisi.sem@utmolestiein.com', '87NCH9QH', '320637'),
(13, 'uuuuuu', '07', '83', 'Curitiba', '57180', '03 70 29 46 00', 'id@lacusAliquamrutrum.com', '18WWI8LE', '352003'),
(14, 'Felis Corporation', '60', '41', 'Inveraray', '90474', '05 78 51 78 99', 'vehicula.risus.Nulla@dapibus.edu', '72DHJ1GQ', '113035'),
(15, 'Massa Integer Vitae Foundation', '68', '11', 'Dunoon', '84862', '01 98 48 25 64', 'et.magnis@estNunc.co.uk', '39CVO6XL', '842639'),
(16, 'Magna A Ltd', '30', '44', 'Westmount', '78672', '05 94 16 94 76', 'eget.volutpat@nequeet.net', '66EHE1IT', '094086'),
(17, 'Fringilla Foundation', '57', '31', 'Melbourne', '09021', '03 22 45 46 92', 'enim.commodo@quislectus.com', '41KDA0FG', '880324'),
(18, 'Proin Velit Sed Inc.', '56', '80', 'Bilbo', '86002', '06 12 13 83 54', 'venenatis@Suspendissealiquetsem.org', '13VQC0LH', '301080'),
(19, 'Nunc Risus Varius Institute', '08', '90', 'Lauro de Freitas', '57147', '09 52 35 32 65', 'luctus.felis.purus@vel.org', '46FYX3KK', '144305'),
(20, 'Sed Ltd', '03', '96', 'Kolmont', '98452', '02 94 52 34 32', 'nulla.Integer.urna@egetipsumDonec.co.uk', '06VXC8IR', '537396'),
(21, 'Vivamus Ltd', '94', '83', 'Ongole', '92792', '01 45 55 74 90', 'justo@sedsapien.co.uk', '28HYH4NO', '960181'),
(22, 'Felis Nulla Foundation', '80', '49', 'Ashoknagar-Kalyangarh', '30743', '02 86 52 08 91', 'Nulla.aliquet@congueturpis.ca', '31KIS2YZ', '118348'),
(23, 'Tellus Justo Foundation', '36', '76', 'Campinas', '71037', '08 06 08 14 40', 'Integer@dignissim.net', '17KIL3NP', '705720'),
(24, 'Sagittis Felis Institute', '25', '6', 'Kasur', '11690', '01 65 02 83 24', 'vel@tempor.edu', '31EVH1QJ', '045009');

-- --------------------------------------------------------

--
-- Structure de la table `formateur`
--

CREATE TABLE `formateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `formateur`
--

INSERT INTO `formateur` (`id`, `nom`, `prenom`, `mail`, `tel`, `login`, `password`) VALUES
(1, 'gilles', 'dupont', 'gilles.dupont@mail.fr', '88 88 88 88 88', 'gilles', 'bonjour');

-- --------------------------------------------------------

--
-- Structure de la table `periode`
--

CREATE TABLE `periode` (
  `id` int(11) NOT NULL,
  `dateDebut` date DEFAULT NULL,
  `dateFin` date DEFAULT NULL,
  `dateVisite` date DEFAULT NULL,
  `poste` varchar(255) DEFAULT NULL,
  `activite` text,
  `noteFormateur` text,
  `visiteEffectue` tinyint(1) DEFAULT NULL,
  `idFormateur` int(11) DEFAULT NULL,
  `idStagiaire` int(11) NOT NULL,
  `idEntreprise` int(11) DEFAULT NULL,
  `idTuteur` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `periode`
--

INSERT INTO `periode` (`id`, `dateDebut`, `dateFin`, `dateVisite`, `poste`, `activite`, `noteFormateur`, `visiteEffectue`, `idFormateur`, `idStagiaire`, `idEntreprise`, `idTuteur`) VALUES
(1, '2017-05-02', '2017-05-30', NULL, 'developpeur', NULL, NULL, NULL, 1, 1, 1, 2),
(2, '2015-05-12', '2016-05-12', NULL, NULL, NULL, NULL, NULL, NULL, 5, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `stagiaire`
--

CREATE TABLE `stagiaire` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `stagiaire`
--

INSERT INTO `stagiaire` (`id`, `nom`, `prenom`, `mail`, `tel`, `login`, `password`) VALUES
(1, 'Le Cam', 'Alexandre', 'monmail@mail.fr', '99 99 99 99 99', 'alexandre', 'bonjour'),
(3, 'Sharpe', 'Raymond', 'sit.amet@euultricessit.ca', '04 34 47 61 49', 'auctor', 'bonjour'),
(4, 'Foley', 'Ferris', 'orci.lobortis@sapiengravidanon.org', '06 67 56 29 82', 'a', 'bonjour'),
(5, 'Patton', 'Cedric', 'Phasellus.libero@consectetuer.net', '02 45 09 73 03', 'consectetuer', 'bonjour'),
(6, 'Welch', 'Ethan', 'Nunc@Proin.net', '09 43 72 19 37', 'nec', 'bonjour'),
(7, 'Andrews', 'Bevis', 'Vestibulum@dapibusidblandit.net', '09 57 69 66 35', 'Morbi', 'bonjour'),
(8, 'Pugh', 'Lionel', 'sed.dolor.Fusce@Quisquepurussapien.co.uk', '04 05 70 43 34', 'laoreet', 'bonjour'),
(9, 'Weiss', 'Fuller', 'Suspendisse@lorem.co.uk', '07 80 01 84 59', 'sit', 'bonjour'),
(10, 'Forbes', 'Finn', 'bibendum.Donec.felis@senectuset.co.uk', '06 74 35 38 66', 'vulputate,', 'bonjour'),
(11, 'Avila', 'Ross', 'non.lacinia.at@idblandit.net', '09 97 09 54 73', 'tempor', 'bonjour'),
(12, 'Gould', 'Fuller', 'Mauris.non.dui@rhoncusDonecest.org', '02 82 25 41 63', 'dolor', 'bonjour'),
(13, 'Molina', 'Thor', 'rutrum.Fusce@orcisem.org', '07 95 62 26 56', 'Quisque', 'bonjour'),
(14, 'Robles', 'Caesar', 'neque@adlitora.co.uk', '03 89 42 90 02', 'fringilla', 'bonjour'),
(15, 'Oneal', 'Octavius', 'gravida.sit.amet@nonarcu.ca', '01 69 17 06 51', 'id', 'bonjour'),
(16, 'Murray', 'Gil', 'habitant.morbi.tristique@ipsumcursus.org', '07 47 93 13 61', 'mauris.', 'bonjour'),
(17, 'Burks', 'Gary', 'Suspendisse.aliquet@Namporttitorscelerisque.co.uk', '09 95 05 12 74', 'molestie', 'bonjour'),
(18, 'Lott', 'Garrison', 'hendrerit.neque@iaculisodioNam.org', '04 73 80 30 28', 'scelerisque', 'bonjour'),
(19, 'Jacobson', 'Bruce', 'et.libero@diam.net', '08 34 57 72 56', 'adipiscing.', 'bonjour'),
(20, 'Morin', 'Aladdin', 'aliquet.diam@accumsanconvallis.edu', '08 60 47 89 56', 'neque', 'bonjour'),
(21, 'Gonzalez', 'Wayne', 'penatibus@miAliquamgravida.co.uk', '06 15 81 03 09', 'imperdiet', 'bonjour'),
(22, 'Salinas', 'Leo', 'Proin.eget@CurabiturdictumPhasellus.com', '01 89 13 30 12', 'non,', 'bonjour'),
(23, 'Cummings', 'Grady', 'eu.ultrices@luctusetultrices.com', '03 02 35 44 52', 'pretium', 'bonjour'),
(24, 'English', 'Lewis', 'ligula.consectetuer.rhoncus@senectus.net', '07 97 94 72 62', 'ultrices', 'bonjour'),
(25, 'Cervantes', 'Lester', 'tellus.Phasellus.elit@dictumeueleifend.com', '08 39 22 63 33', 'Quisque', 'bonjour'),
(26, 'Boyle', 'Tad', 'sed.pede@consectetuereuismodest.co.uk', '07 15 50 37 34', 'elementum', 'bonjour'),
(27, 'Conway', 'Caesar', 'luctus.vulputate@interdum.org', '07 44 69 14 59', 'dolor', 'bonjour'),
(28, 'Gaines', 'Evan', 'magnis.dis@convallis.ca', '04 52 26 08 47', 'Fusce', 'bonjour'),
(29, 'Solis', 'Barrett', 'ornare.tortor@portaelit.net', '07 98 13 70 16', 'vel,', 'bonjour'),
(30, 'Faulkner', 'Zeph', 'gravida@sitametconsectetuer.ca', '03 44 61 69 94', 'lectus', 'bonjour'),
(31, 'Ramirez', 'Caleb', 'eget.lacus.Mauris@lacinia.co.uk', '07 58 06 77 09', 'porttitor', 'bonjour'),
(32, 'Callahan', 'Bernard', 'Vivamus.nisi@VivamusnisiMauris.co.uk', '04 39 29 15 16', 'Cras', 'bonjour'),
(33, 'Nixon', 'Tad', 'Nunc@lectus.net', '08 57 63 99 38', 'tellus', 'bonjour'),
(34, 'Everett', 'Stewart', 'magna.Ut@sitametultricies.ca', '09 51 59 69 69', 'lorem', 'bonjour'),
(35, 'Thomas', 'John', 'magna@conubianostraper.com', '06 09 78 15 91', 'erat', 'bonjour'),
(36, 'Moon', 'Anthony', 'nunc.risus@disparturientmontes.ca', '03 52 25 50 55', 'urna', 'bonjour'),
(37, 'Smith', 'Castor', 'purus.sapien@consequat.edu', '06 73 52 78 82', 'ut,', 'bonjour'),
(38, 'Craft', 'Ian', 'odio.sagittis.semper@nequenonquam.net', '03 14 92 76 25', 'tortor', 'bonjour'),
(39, 'Black', 'Barclay', 'litora.torquent@vehiculaPellentesquetincidunt.co.uk', '06 97 97 67 29', 'Praesent', 'bonjour'),
(40, 'Fox', 'Kasper', 'adipiscing.non.luctus@velpedeblandit.ca', '08 05 49 79 80', 'sed,', 'bonjour'),
(41, 'Stephenson', 'Wesley', 'eget.nisi@augue.net', '04 99 99 09 80', 'montes,', 'bonjour'),
(42, 'Baker', 'Melvin', 'metus.Aenean.sed@ametmetusAliquam.com', '04 64 39 12 38', 'Maecenas', 'bonjour');

-- --------------------------------------------------------

--
-- Structure de la table `tuteur`
--

CREATE TABLE `tuteur` (
  `id` int(11) NOT NULL,
  `idEntreprise` int(11) DEFAULT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `tel` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tuteur`
--

INSERT INTO `tuteur` (`id`, `idEntreprise`, `nom`, `prenom`, `mail`, `tel`) VALUES
(1, 1, 'marc', 'durant', 'marc.durant@mail.fr', '77 77 77 77 77'),
(2, 4, 'Jean', 'Valmont', 'jean.valmont@mail.fr', '66 66 66 66 66'),
(3, 1, 'Pickett', 'Nigel', 'lacinia@massa.com', '01 93 50 22 81'),
(4, 4, 'Jensen', 'Eaton', 'In.ornare.sagittis@vel.com', '02 85 55 92 15'),
(5, 4, 'Terry', 'Jakeem', 'ante.lectus@metusvitaevelit.co.uk', '06 01 69 42 37'),
(6, 1, 'Becker', 'Levi', 'consectetuer@erateget.org', '03 69 92 42 31'),
(7, 4, 'Mills', 'Wyatt', 'mollis@faucibusleo.co.uk', '08 45 65 32 38'),
(8, 4, 'Schroeder', 'Sylvester', 'auctor.velit@acfeugiatnon.org', '01 70 01 64 60'),
(9, 4, 'Joyce', 'Tate', 'sociosqu@iaculisquis.edu', '04 45 32 60 96'),
(10, 19, 'Rose', 'Aladdin', 'vel.mauris@pede.edu', '06 83 23 52 01'),
(11, 19, 'Lambert', 'Elvis', 'Morbi.quis.urna@idenimCurabitur.org', '02 10 59 73 61'),
(12, 19, 'Maxwell', 'Moses', 'faucibus@ornare.ca', '05 14 34 70 28'),
(13, 19, 'Holloway', 'Barclay', 'lacus.Aliquam@aliquet.co.uk', '05 44 76 37 58'),
(14, 19, 'Adams', 'Victor', 'non.dui.nec@PhasellusornareFusce.edu', '01 91 74 73 46'),
(15, NULL, 'Caldwell', 'Finn', 'arcu.Vivamus@molestie.co.uk', '03 49 03 08 32'),
(16, NULL, 'Spears', 'Honorato', 'adipiscing.lacus@etnetuset.ca', '08 43 60 67 79'),
(17, NULL, 'Olsen', 'Theodore', 'sodales.nisi.magna@dui.co.uk', '07 15 79 20 78'),
(18, NULL, 'Santiago', 'Nathaniel', 'mi@at.ca', '06 59 63 47 84'),
(19, NULL, 'Copeland', 'Dexter', 'hendrerit.Donec.porttitor@duilectus.net', '06 44 83 80 80'),
(20, NULL, 'Ramos', 'Reece', 'ante.ipsum.primis@aliquet.ca', '06 65 51 73 87'),
(21, NULL, 'Mccullough', 'Cyrus', 'cursus.diam@fringillaestMauris.net', '07 21 49 04 10'),
(22, NULL, 'Richards', 'Blake', 'nunc.Quisque@porttitor.net', '02 19 28 50 24');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `entreprise`
--
ALTER TABLE `entreprise`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `formateur`
--
ALTER TABLE `formateur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `periode`
--
ALTER TABLE `periode`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idFormateur` (`idFormateur`),
  ADD KEY `idStagiaire` (`idStagiaire`),
  ADD KEY `idEntreprise` (`idEntreprise`),
  ADD KEY `idFormateur_2` (`idFormateur`),
  ADD KEY `idStagiaire_2` (`idStagiaire`),
  ADD KEY `idEntreprise_2` (`idEntreprise`),
  ADD KEY `idTuteur` (`idTuteur`);

--
-- Index pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `tuteur`
--
ALTER TABLE `tuteur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idEntreprise` (`idEntreprise`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `entreprise`
--
ALTER TABLE `entreprise`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT pour la table `formateur`
--
ALTER TABLE `formateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `periode`
--
ALTER TABLE `periode`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT pour la table `tuteur`
--
ALTER TABLE `tuteur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `periode`
--
ALTER TABLE `periode`
  ADD CONSTRAINT `periode_ibfk_1` FOREIGN KEY (`idFormateur`) REFERENCES `formateur` (`id`),
  ADD CONSTRAINT `periode_ibfk_2` FOREIGN KEY (`idStagiaire`) REFERENCES `stagiaire` (`id`),
  ADD CONSTRAINT `periode_ibfk_3` FOREIGN KEY (`idEntreprise`) REFERENCES `entreprise` (`id`),
  ADD CONSTRAINT `periode_ibfk_4` FOREIGN KEY (`idTuteur`) REFERENCES `tuteur` (`id`);

--
-- Contraintes pour la table `tuteur`
--
ALTER TABLE `tuteur`
  ADD CONSTRAINT `tuteur_ibfk_1` FOREIGN KEY (`idEntreprise`) REFERENCES `entreprise` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
