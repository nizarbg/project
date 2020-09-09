-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 09 sep. 2020 à 22:31
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `locationdb`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `Id` int(11) NOT NULL,
  `nationalite` varchar(254) NOT NULL,
  `profession` varchar(254) DEFAULT NULL,
  `codepostal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`Id`, `nationalite`, `profession`, `codepostal`) VALUES
(3, 'Tunisienne', 'Medecin', 1023);

-- --------------------------------------------------------

--
-- Structure de la table `contrat`
--

CREATE TABLE `contrat` (
  `Id` int(11) NOT NULL,
  `Id_Reservation` int(11) NOT NULL,
  `numContrat` int(11) NOT NULL,
  `prixHt` float NOT NULL,
  `tva` float NOT NULL,
  `prixTT` float NOT NULL,
  `modePaiement` varchar(254) NOT NULL,
  `acompte` float NOT NULL,
  `caution` int(11) NOT NULL,
  `dureeRetard` int(11) DEFAULT NULL,
  `dateProlongation` date NOT NULL,
  `dateSignature` date NOT NULL,
  `penaliteJour` float DEFAULT NULL,
  `dateAjout` datetime NOT NULL,
  `dateSupp` datetime DEFAULT NULL,
  `dateMiseajour` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `contrat`
--

INSERT INTO `contrat` (`Id`, `Id_Reservation`, `numContrat`, `prixHt`, `tva`, `prixTT`, `modePaiement`, `acompte`, `caution`, `dureeRetard`, `dateProlongation`, `dateSignature`, `penaliteJour`, `dateAjout`, `dateSupp`, `dateMiseajour`) VALUES
(1, 1, 1526, 100, 50, 100, 'Espece', 12, 10, NULL, '2019-01-05', '2019-11-08', NULL, '2020-08-25 15:18:59', NULL, NULL),
(2, 2, 1528, 120, 12, 155, 'Cheque', 10, 11, NULL, '2019-01-08', '2019-01-10', NULL, '2020-08-25 15:34:38', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `document`
--

CREATE TABLE `document` (
  `Id` int(11) NOT NULL,
  `Id_Voiture` int(11) NOT NULL,
  `type_document` varchar(254) DEFAULT NULL,
  `Date_document` date NOT NULL,
  `date_ajout` datetime NOT NULL,
  `Date_supp` datetime DEFAULT NULL,
  `Date_miseajour` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `document`
--

INSERT INTO `document` (`Id`, `Id_Voiture`, `type_document`, `Date_document`, `date_ajout`, `Date_supp`, `Date_miseajour`) VALUES
(1, 1, 'Carte Grise', '2015-12-05', '2020-08-25 09:37:54', NULL, NULL),
(2, 1, 'Certificat assurance', '2015-12-07', '2020-08-25 09:38:32', NULL, NULL),
(3, 1, 'Vignette', '2015-12-08', '2020-08-25 09:40:15', NULL, NULL),
(4, 2, 'Carte Grise', '2016-05-05', '2020-08-25 09:43:17', NULL, NULL),
(5, 2, 'Certificat assurance', '2016-05-25', '2020-08-25 09:46:10', NULL, NULL),
(6, 2, 'Vignette', '2016-05-26', '2020-08-25 10:18:19', NULL, NULL),
(7, 3, 'Carte Grise', '2016-05-13', '2020-08-25 10:30:20', NULL, NULL),
(8, 3, 'Certificat Assurance', '2016-05-20', '2020-08-25 10:34:52', NULL, NULL),
(9, 3, 'Vignette', '2015-11-07', '2020-08-25 10:40:29', NULL, NULL),
(10, 4, 'Carte grise', '2015-11-01', '2020-08-25 10:42:51', NULL, NULL),
(11, 4, 'Certificat Assurance', '2016-02-02', '2020-08-25 10:54:21', NULL, NULL),
(12, 4, 'Certificat assurance', '2016-05-21', '2020-08-25 14:14:08', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
  `Id` int(11) NOT NULL,
  `role` varchar(254) NOT NULL,
  `dateEmbauch` date NOT NULL,
  `salaire` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`Id`, `role`, `dateEmbauch`, `salaire`) VALUES
(1, 'Responsable commercial', '2020-08-20', 400),
(2, 'Secretaire', '2020-08-21', 300);

-- --------------------------------------------------------

--
-- Structure de la table `entretient`
--

CREATE TABLE `entretient` (
  `Id` int(11) NOT NULL,
  `Id_Voiture` int(11) NOT NULL,
  `Id_Employe` int(11) NOT NULL,
  `nom` varchar(254) NOT NULL,
  `type_entretient` varchar(254) NOT NULL,
  `dateEntre` date NOT NULL,
  `dateSortie` date NOT NULL,
  `dateAjout` datetime NOT NULL,
  `dateSupp` datetime DEFAULT NULL,
  `dateMiseajour` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `entretient`
--

INSERT INTO `entretient` (`Id`, `Id_Voiture`, `Id_Employe`, `nom`, `type_entretient`, `dateEntre`, `dateSortie`, `dateAjout`, `dateSupp`, `dateMiseajour`) VALUES
(1, 1, 1, 'Vidange 10000 km', 'Vidange', '2019-12-02', '2020-01-03', '2020-08-25 16:39:25', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `image`
--

CREATE TABLE `image` (
  `Id` int(11) NOT NULL,
  `type_image` varchar(254) NOT NULL,
  `photo` longblob DEFAULT NULL,
  `date_Ajout` datetime NOT NULL,
  `date_supp` datetime DEFAULT NULL,
  `date_miseajour` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `image`
--

INSERT INTO `image` (`Id`, `type_image`, `photo`, `date_Ajout`, `date_supp`, `date_miseajour`) VALUES
(1, 'Employe', NULL, '2020-08-19 17:02:13', NULL, NULL),
(2, 'Client', NULL, '2020-08-19 17:03:12', NULL, NULL),
(3, 'Employe', NULL, '2020-08-19 17:39:50', NULL, NULL),
(4, 'Modele', NULL, '2020-08-19 17:41:19', NULL, NULL),
(5, 'Modele', NULL, '2020-08-19 17:43:32', NULL, NULL),
(6, 'Modele', NULL, '2020-08-19 17:44:46', NULL, NULL),
(7, 'Voiture', NULL, '2020-08-20 14:18:52', NULL, NULL),
(8, 'Voiture', NULL, '2020-08-20 14:19:31', NULL, NULL),
(9, 'Voiture', NULL, '2020-08-20 14:19:47', NULL, NULL),
(10, 'Voiture', NULL, '2020-08-20 14:20:02', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `modele`
--

CREATE TABLE `modele` (
  `Id` int(11) NOT NULL,
  `Id_Image` int(11) NOT NULL,
  `nom` varchar(254) NOT NULL,
  `marque` varchar(254) NOT NULL,
  `carburant` varchar(254) NOT NULL,
  `puissance` float NOT NULL,
  `nbPortes` int(11) NOT NULL,
  `nbPlaces` int(11) NOT NULL,
  `prixLocation` float NOT NULL,
  `boite` varchar(254) DEFAULT NULL,
  `cylindre` float NOT NULL,
  `nbcylindres` int(11) NOT NULL,
  `transmission` varchar(254) NOT NULL,
  `dateSortie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `modele`
--

INSERT INTO `modele` (`Id`, `Id_Image`, `nom`, `marque`, `carburant`, `puissance`, `nbPortes`, `nbPlaces`, `prixLocation`, `boite`, `cylindre`, `nbcylindres`, `transmission`, `dateSortie`) VALUES
(1, 4, 'Audi Q5', 'Audi ', 'diesem', 8, 4, 5, 50, 'automatique', 2, 10, 'Automatique', 2008),
(2, 5, 'lotus exige s', 'lotus', 'diesel', 8, 2, 5, 50, 'automatique', 2, 16, 'automatique', 2009),
(3, 6, 'peugeot 308 cc', 'peugeot', 'essence', 16, 4, 5, 50, 'manuel', 5, 13, 'automatique', 2005);

-- --------------------------------------------------------

--
-- Structure de la table `piece`
--

CREATE TABLE `piece` (
  `Id` int(11) NOT NULL,
  `Id_Voiture` int(11) NOT NULL,
  `Id_Employe` int(11) NOT NULL,
  `reference` varchar(254) NOT NULL,
  `nom` varchar(254) NOT NULL,
  `marque` varchar(254) NOT NULL,
  `prix` float NOT NULL,
  `dateAchat` date NOT NULL,
  `dateAjout` datetime NOT NULL,
  `dateSupp` datetime DEFAULT NULL,
  `dateMiseajour` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `piece`
--

INSERT INTO `piece` (`Id`, `Id_Voiture`, `Id_Employe`, `reference`, `nom`, `marque`, `prix`, `dateAchat`, `dateAjout`, `dateSupp`, `dateMiseajour`) VALUES
(1, 1, 1, '5052 NH', 'Amortisseur', 'xiy', 52, '2019-08-05', '2020-08-25 16:03:09', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `Id` int(11) NOT NULL,
  `Id_Client` int(11) NOT NULL,
  `Id_Voiture` int(11) NOT NULL,
  `Id_Employe` int(11) NOT NULL,
  `dateDebut` datetime NOT NULL,
  `lieuPrise` varchar(254) NOT NULL,
  `dateFin` datetime NOT NULL,
  `lieuRetour` varchar(254) NOT NULL,
  `description` varchar(254) NOT NULL,
  `dateAjout` datetime NOT NULL,
  `dateSupp` datetime DEFAULT NULL,
  `dateMiseajour` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`Id`, `Id_Client`, `Id_Voiture`, `Id_Employe`, `dateDebut`, `lieuPrise`, `dateFin`, `lieuRetour`, `description`, `dateAjout`, `dateSupp`, `dateMiseajour`) VALUES
(1, 3, 3, 1, '2019-12-10 15:00:00', 'Montplaisir', '2019-12-20 00:00:00', 'Montplaisir', '', '2020-08-25 15:09:28', NULL, NULL),
(2, 3, 4, 1, '2020-05-15 13:10:00', 'Centre Ville', '2020-05-18 13:10:00', 'Mourouj', '', '2020-08-25 15:15:51', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `Id` int(11) NOT NULL,
  `Id_Image` int(11) NOT NULL,
  `numCin` int(11) NOT NULL,
  `dateCin` date NOT NULL,
  `nom` varchar(254) NOT NULL,
  `prenom` varchar(254) NOT NULL,
  `motDePasse` varchar(254) NOT NULL,
  `numTel` int(11) NOT NULL,
  `email` varchar(254) NOT NULL,
  `adresse` varchar(254) NOT NULL,
  `numPermis` int(11) NOT NULL,
  `datePermis` date NOT NULL,
  `dateAjout` datetime NOT NULL,
  `dateSupp` datetime DEFAULT NULL,
  `dateMiseajour` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`Id`, `Id_Image`, `numCin`, `dateCin`, `nom`, `prenom`, `motDePasse`, `numTel`, `email`, `adresse`, `numPermis`, `datePermis`, `dateAjout`, `dateSupp`, `dateMiseajour`) VALUES
(1, 3, 16874533, '2015-12-10', 'Ben Yaghlen', 'Abdelrhim', '4646548', 23687456, 'BYABDELRHIM@yahoo.fr', 'immeuble 18 rue 255 borj el cedria', 155992, '2016-03-09', '2020-08-20 15:12:00', NULL, NULL),
(2, 1, 18795472, '2013-12-04', 'Ettriki', 'Sofien', 'tyuio87', 55489614, 'Sofftriki@gmail.com', '31 rue 45 Mourouj', 48123, '2016-05-29', '2020-08-20 15:18:57', NULL, NULL),
(3, 2, 17069856, '2013-10-04', 'Othmani', 'Emna', 'ompo89', 58975221, 'Othemna@yahoo.fr', '8 rue tadhamon ariana', 23321, '2017-11-09', '2020-08-20 15:45:34', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `voiture`
--

CREATE TABLE `voiture` (
  `Id` int(11) NOT NULL,
  `Id_Modele` int(11) NOT NULL,
  `Id_Image` int(11) NOT NULL,
  `matricule` varchar(254) NOT NULL,
  `kilometrage` int(11) NOT NULL,
  `couleur` varchar(254) NOT NULL,
  `prixAchat` float NOT NULL,
  `etat` varchar(100) NOT NULL,
  `dateAjout` datetime NOT NULL,
  `dateSupp` datetime DEFAULT NULL,
  `dateMiseajour` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `voiture`
--

INSERT INTO `voiture` (`Id`, `Id_Modele`, `Id_Image`, `matricule`, `kilometrage`, `couleur`, `prixAchat`, `etat`, `dateAjout`, `dateSupp`, `dateMiseajour`) VALUES
(1, 1, 7, '130 Tunis 3333', 100, 'noir', 50000, 'Prete pour location', '2020-08-21 14:58:40', NULL, NULL),
(2, 2, 8, '140 Tunis 3685', 100, 'Rouge', 160, 'Pret pour location', '2020-08-21 15:23:15', NULL, NULL),
(3, 2, 9, '148 Tunis 3587', 100, 'Gris Charbon', 160, 'en circulation', '2020-08-21 15:24:11', NULL, NULL),
(4, 3, 10, '198 Tunis 1987', 200, 'Gris', 80, 'en circulation', '2020-08-21 15:30:46', NULL, NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`Id`);

--
-- Index pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `numContrat` (`numContrat`),
  ADD UNIQUE KEY `Id_Reservation` (`Id_Reservation`);

--
-- Index pour la table `document`
--
ALTER TABLE `document`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_Document_Voiture` (`Id_Voiture`);

--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`Id`);

--
-- Index pour la table `entretient`
--
ALTER TABLE `entretient`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_Entretient` (`Id_Voiture`),
  ADD UNIQUE KEY `Id_Employe` (`Id_Employe`);

--
-- Index pour la table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`Id`);

--
-- Index pour la table `modele`
--
ALTER TABLE `modele`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_Modele_Image` (`Id_Image`);

--
-- Index pour la table `piece`
--
ALTER TABLE `piece`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `reference` (`reference`),
  ADD KEY `FK_Piece_Voiture` (`Id_Voiture`),
  ADD KEY `FK_Piece_employe` (`Id_Employe`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_Reservation_Voiture` (`Id_Voiture`),
  ADD KEY `FK_Reservation_Client` (`Id_Client`),
  ADD KEY `FK_Reservation_employe` (`Id_Employe`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `numCin` (`numCin`),
  ADD UNIQUE KEY `numPermis` (`numPermis`),
  ADD UNIQUE KEY `numTel` (`numTel`),
  ADD UNIQUE KEY `Id_Image` (`Id_Image`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `voiture`
--
ALTER TABLE `voiture`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `matricule` (`matricule`),
  ADD UNIQUE KEY `Id_Image` (`Id_Image`),
  ADD KEY `FK_Voiture_Modele` (`Id_Modele`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `contrat`
--
ALTER TABLE `contrat`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `document`
--
ALTER TABLE `document`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `entretient`
--
ALTER TABLE `entretient`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `image`
--
ALTER TABLE `image`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT pour la table `modele`
--
ALTER TABLE `modele`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `piece`
--
ALTER TABLE `piece`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `voiture`
--
ALTER TABLE `voiture`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK_Client_Utilisateur` FOREIGN KEY (`Id`) REFERENCES `utilisateur` (`Id`);

--
-- Contraintes pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD CONSTRAINT `FK_Contrat_Reservation` FOREIGN KEY (`Id_Reservation`) REFERENCES `reservation` (`Id`);

--
-- Contraintes pour la table `document`
--
ALTER TABLE `document`
  ADD CONSTRAINT `FK_Document_Voiture` FOREIGN KEY (`Id_Voiture`) REFERENCES `voiture` (`Id`);

--
-- Contraintes pour la table `employe`
--
ALTER TABLE `employe`
  ADD CONSTRAINT `FK_Employe_Utilisateur` FOREIGN KEY (`Id`) REFERENCES `utilisateur` (`Id`);

--
-- Contraintes pour la table `entretient`
--
ALTER TABLE `entretient`
  ADD CONSTRAINT `FK_Entretient_Employe` FOREIGN KEY (`Id_Employe`) REFERENCES `employe` (`Id`),
  ADD CONSTRAINT `FK_Entretient_Voiture` FOREIGN KEY (`Id_Voiture`) REFERENCES `voiture` (`Id`);

--
-- Contraintes pour la table `modele`
--
ALTER TABLE `modele`
  ADD CONSTRAINT `FK_Modele_Image` FOREIGN KEY (`Id_Image`) REFERENCES `image` (`Id`);

--
-- Contraintes pour la table `piece`
--
ALTER TABLE `piece`
  ADD CONSTRAINT `FK_Piece_Voiture` FOREIGN KEY (`Id_Voiture`) REFERENCES `voiture` (`Id`),
  ADD CONSTRAINT `FK_Piece_employe` FOREIGN KEY (`Id_Employe`) REFERENCES `employe` (`Id`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FK_Reservation_Client` FOREIGN KEY (`Id_Client`) REFERENCES `client` (`Id`),
  ADD CONSTRAINT `FK_Reservation_Voiture` FOREIGN KEY (`Id_Voiture`) REFERENCES `voiture` (`Id`),
  ADD CONSTRAINT `FK_Reservation_employe` FOREIGN KEY (`Id_Employe`) REFERENCES `employe` (`Id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK_Utilisateur_Image` FOREIGN KEY (`Id_Image`) REFERENCES `image` (`Id`);

--
-- Contraintes pour la table `voiture`
--
ALTER TABLE `voiture`
  ADD CONSTRAINT `FK_Voiture_Image` FOREIGN KEY (`Id_Image`) REFERENCES `image` (`Id`),
  ADD CONSTRAINT `FK_Voiture_Modele` FOREIGN KEY (`Id_Modele`) REFERENCES `modele` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
