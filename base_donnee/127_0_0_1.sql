-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 08 août 2019 à 10:14
-- Version du serveur :  10.3.16-MariaDB
-- Version de PHP :  7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `base_association`
--
CREATE DATABASE IF NOT EXISTS `base_association` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_association`;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `libelle` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `libelle`) VALUES
(1, 'Boucherie'),
(2, 'epicerie'),
(3, 'Céréales');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` int(11) NOT NULL,
  `date_commande` date NOT NULL,
  `nom_client` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `date_commande`, `nom_client`) VALUES
(1, '2019-08-02', 'Bob Eponge'),
(2, '2019-07-24', 'Patrick Etoile');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prix` double NOT NULL,
  `stock` int(11) NOT NULL,
  `categorie_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `nom`, `prix`, `stock`, `categorie_id`) VALUES
(1, 'Steack de lama', 29.99, 10, 1),
(2, 'tofu tofu', 15.99, 3, 2),
(3, 'Escalope d\'autruche', 24.99, 15, 1),
(4, 'Miel des capathes', 8.99, 7, 2),
(5, 'Biéres aux algues', 4.99, 25, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `produit_commande`
--

CREATE TABLE `produit_commande` (
  `produit_id` int(11) NOT NULL,
  `commande_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit_commande`
--

INSERT INTO `produit_commande` (`produit_id`, `commande_id`) VALUES
(1, 1),
(2, 2),
(3, 2),
(4, 1),
(4, 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categorie_produit` (`categorie_id`);

--
-- Index pour la table `produit_commande`
--
ALTER TABLE `produit_commande`
  ADD PRIMARY KEY (`produit_id`,`commande_id`),
  ADD KEY `cp_categorie` (`commande_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `categorie_produit` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`);

--
-- Contraintes pour la table `produit_commande`
--
ALTER TABLE `produit_commande`
  ADD CONSTRAINT `cp_categorie` FOREIGN KEY (`commande_id`) REFERENCES `commande` (`id`),
  ADD CONSTRAINT `cp_produit` FOREIGN KEY (`produit_id`) REFERENCES `produit` (`id`);
--
-- Base de données :  `base_associationsmapping`
--
CREATE DATABASE IF NOT EXISTS `base_associationsmapping` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_associationsmapping`;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `libelle`) VALUES
(1, 'Boucherie'),
(2, 'Epicerie'),
(3, 'Céréales');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` int(11) NOT NULL,
  `dateCommande` date DEFAULT NULL,
  `nomClient` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `dateCommande`, `nomClient`) VALUES
(1, '2017-10-10', 'Bob Eponge'),
(2, '2018-11-11', 'Patrick Etoile');

-- --------------------------------------------------------

--
-- Structure de la table `commande_produit`
--

CREATE TABLE `commande_produit` (
  `commandes_id` int(11) NOT NULL,
  `produits_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commande_produit`
--

INSERT INTO `commande_produit` (`commandes_id`, `produits_id`) VALUES
(1, 1),
(1, 2),
(1, 4),
(2, 1),
(2, 3),
(2, 5);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prix` double NOT NULL,
  `stock` int(11) NOT NULL,
  `categorie_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `nom`, `prix`, `stock`, `categorie_id`) VALUES
(1, 'Steack de lamas', 29.99, 10, 1),
(2, 'Tofu tofu', 8.99, 4, 2),
(3, 'Escalope d\'autruche', 24.99, 25, 1),
(4, 'Miel des carpathes', 5.99, 7, 2),
(5, 'Biéres aux algues', 4.99, 12, NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commande_produit`
--
ALTER TABLE `commande_produit`
  ADD PRIMARY KEY (`commandes_id`,`produits_id`),
  ADD KEY `FK7177t2pnnp1fe6kfi4llqke4c` (`produits_id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKejxvy5dl65jihv1v5k6v9vqd6` (`categorie_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande_produit`
--
ALTER TABLE `commande_produit`
  ADD CONSTRAINT `FK7177t2pnnp1fe6kfi4llqke4c` FOREIGN KEY (`produits_id`) REFERENCES `produit` (`id`),
  ADD CONSTRAINT `FKqibf284ssrpy9m3ols4oirviq` FOREIGN KEY (`commandes_id`) REFERENCES `commande` (`id`);

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `FKejxvy5dl65jihv1v5k6v9vqd6` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`);
--
-- Base de données :  `base_basicmapping`
--
CREATE DATABASE IF NOT EXISTS `base_basicmapping` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_basicmapping`;
--
-- Base de données :  `base_exercicejpa`
--
CREATE DATABASE IF NOT EXISTS `base_exercicejpa` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_exercicejpa`;

-- --------------------------------------------------------

--
-- Structure de la table `achat`
--

CREATE TABLE `achat` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `poids` double NOT NULL,
  `prix` double NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `achat`
--

INSERT INTO `achat` (`id`, `nom`, `poids`, `prix`, `stock`) VALUES
(1, 'Sac', 1.23, 2.99, 56),
(2, 'Livre', 2.23, 4.99, 6),
(4, 'Casque', 2.01, 72.99, 12);

-- --------------------------------------------------------

--
-- Structure de la table `achats`
--

CREATE TABLE `achats` (
  `id` int(11) NOT NULL,
  `nom_prod` varchar(150) DEFAULT NULL,
  `poids` double NOT NULL,
  `prix` double NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `achat`
--
ALTER TABLE `achat`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `achats`
--
ALTER TABLE `achats`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `achat`
--
ALTER TABLE `achat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `achats`
--
ALTER TABLE `achats`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Base de données :  `base_exercicejpa2`
--
CREATE DATABASE IF NOT EXISTS `base_exercicejpa2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_exercicejpa2`;

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

CREATE TABLE `film` (
  `id` int(11) NOT NULL,
  `dateSortie` date DEFAULT NULL,
  `duree` int(11) NOT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `producteur_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `film`
--

INSERT INTO `film` (`id`, `dateSortie`, `duree`, `titre`, `producteur_id`) VALUES
(1, '2015-06-25', 156, 'Web de l\'horreur', 1),
(2, '2018-05-25', 227, 'jumanji', 2),
(3, '2017-12-17', 184, 'L\'arraigné', 1),
(4, '2005-02-01', 178, 'Jumelle', 3),
(5, '2006-04-29', 263, 'Lourde', 3),
(6, '2009-11-10', 103, 'Capitaux', 2),
(7, '2014-10-03', 132, 'Les 7 ', 1),
(8, '2012-09-05', 198, 'L\'envie', 2),
(9, '1985-08-10', 166, 'La joie', 3),
(10, '1655-12-12', 178, 'L\'intrigue', 1);

-- --------------------------------------------------------

--
-- Structure de la table `producteur`
--

CREATE TABLE `producteur` (
  `id` int(11) NOT NULL,
  `dateNaissance` date DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `producteur`
--

INSERT INTO `producteur` (`id`, `dateNaissance`, `nom`) VALUES
(1, '1985-08-15', 'Travel'),
(2, '1978-05-26', 'Marcel'),
(3, '1965-03-02', 'Roumanoff'),
(4, '1985-08-15', 'Travel'),
(5, '1978-05-26', 'Marcel'),
(6, '1965-03-02', 'Roumanoff');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK80x49sqbwsk58ha5ulvj220hw` (`producteur_id`);

--
-- Index pour la table `producteur`
--
ALTER TABLE `producteur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `film`
--
ALTER TABLE `film`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `producteur`
--
ALTER TABLE `producteur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `FK80x49sqbwsk58ha5ulvj220hw` FOREIGN KEY (`producteur_id`) REFERENCES `producteur` (`id`);
--
-- Base de données :  `base_exercicejpaavance`
--
CREATE DATABASE IF NOT EXISTS `base_exercicejpaavance` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_exercicejpaavance`;

-- --------------------------------------------------------

--
-- Structure de la table `contenu`
--

CREATE TABLE `contenu` (
  `id` int(11) NOT NULL,
  `dateCreation` date DEFAULT NULL,
  `dateEdition` date DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `contenu`
--

INSERT INTO `contenu` (`id`, `dateCreation`, `dateEdition`, `nom`) VALUES
(1, '2018-05-14', '2019-02-18', 'Galerie1'),
(2, '2018-07-14', '2019-08-01', 'Galerie2'),
(3, '2018-08-14', '2019-05-15', 'Galerie3'),
(4, '2019-01-05', '2019-06-05', 'Img1'),
(5, '2019-01-05', '2019-06-05', NULL),
(6, '2019-04-05', '2019-09-05', 'Img2'),
(7, '2019-03-05', '2019-08-05', NULL),
(8, '2019-01-05', '2019-09-05', 'Img3'),
(9, '2019-04-05', '2019-09-05', NULL),
(10, '2019-04-05', '2019-08-05', 'Img4'),
(11, '2019-03-05', '2019-08-05', NULL),
(12, '2019-03-05', '2019-07-05', 'Img5'),
(13, '2019-04-05', '2019-09-05', NULL),
(14, '2019-01-05', '2019-06-05', 'Img6'),
(15, '2019-04-05', '2019-07-05', NULL),
(16, '2019-01-05', '2019-09-05', 'Img7'),
(17, '2019-02-05', '2019-08-05', NULL),
(18, '2019-04-05', '2019-06-05', 'Img8'),
(19, '2019-03-05', '2019-07-05', NULL),
(20, '2019-04-05', '2019-07-05', 'Img9'),
(21, '2019-01-05', '2019-09-05', NULL),
(22, '2019-01-05', '2019-07-05', 'Img10'),
(23, '2019-04-05', '2019-06-05', NULL),
(24, '2019-02-05', '2019-06-05', 'Img11'),
(25, '2019-01-05', '2019-09-05', NULL),
(26, '2019-03-05', '2019-07-05', 'Img12'),
(27, '2019-02-05', '2019-07-05', NULL),
(28, '2019-01-05', '2019-06-05', 'Img13'),
(29, '2019-02-05', '2019-08-05', NULL),
(30, '2019-03-05', '2019-08-05', 'Img14'),
(31, '2019-01-05', '2019-07-05', NULL),
(32, '2019-04-05', '2019-07-05', 'Img15'),
(33, '2019-04-05', '2019-08-05', NULL),
(34, '2019-03-05', '2019-08-05', 'Img16'),
(35, '2019-01-05', '2019-09-05', NULL),
(36, '2019-02-05', '2019-07-05', 'Img17'),
(37, '2019-01-05', '2019-09-05', NULL),
(38, '2019-01-05', '2019-06-05', 'Img18'),
(39, '2019-01-05', '2019-09-05', NULL),
(40, '2019-01-05', '2019-06-05', 'Img19'),
(41, '2019-01-05', '2019-06-05', NULL),
(42, '2019-03-05', '2019-08-05', 'Img20'),
(43, '2019-01-05', '2019-08-05', NULL),
(44, '2019-01-05', '2019-08-05', 'Img21'),
(45, '2019-04-05', '2019-06-05', NULL),
(46, '2019-02-05', '2019-07-05', 'Img22'),
(47, '2019-01-05', '2019-06-05', NULL),
(48, '2019-01-05', '2019-09-05', 'Img23'),
(49, '2019-02-05', '2019-08-05', NULL),
(50, '2019-02-05', '2019-09-05', 'Img24'),
(51, '2019-04-05', '2019-08-05', NULL),
(52, '2019-02-05', '2019-06-05', 'Img25'),
(53, '2019-04-05', '2019-06-05', NULL),
(54, '2019-03-05', '2019-06-05', 'Img26'),
(55, '2019-02-05', '2019-09-05', NULL),
(56, '2019-01-05', '2019-09-05', 'Img27'),
(57, '2019-03-05', '2019-07-05', NULL),
(58, '2019-03-05', '2019-06-05', 'Img28'),
(59, '2019-02-05', '2019-09-05', NULL),
(60, '2019-04-05', '2019-07-05', 'Img29'),
(61, '2019-02-05', '2019-06-05', NULL),
(62, '2019-04-05', '2019-09-05', 'Img30'),
(63, '2019-04-05', '2019-08-05', NULL),
(64, '2019-01-05', '2019-09-05', 'Img31'),
(65, '2019-02-05', '2019-07-05', NULL),
(66, '2019-01-05', '2019-09-05', 'Img32'),
(67, '2019-04-05', '2019-08-05', NULL),
(68, '2019-01-05', '2019-06-05', 'Img33'),
(69, '2019-02-05', '2019-07-05', NULL),
(70, '2019-01-05', '2019-08-05', 'Img34'),
(71, '2019-01-05', '2019-09-05', NULL),
(72, '2019-04-05', '2019-08-05', 'Img35'),
(73, '2019-02-05', '2019-06-05', NULL),
(74, '2019-01-05', '2019-06-05', 'Img36'),
(75, '2019-04-05', '2019-09-05', NULL),
(76, '2019-04-05', '2019-07-05', 'Img37'),
(77, '2019-03-05', '2019-07-05', NULL),
(78, '2019-01-05', '2019-08-05', 'Img38'),
(79, '2019-02-05', '2019-07-05', NULL),
(80, '2019-03-05', '2019-07-05', 'Img39'),
(81, '2019-01-05', '2019-08-05', NULL),
(82, '2019-03-05', '2019-09-05', 'Img40'),
(83, '2019-01-05', '2019-07-05', NULL),
(84, '2019-03-05', '2019-07-05', 'Img41'),
(85, '2019-04-05', '2019-07-05', NULL),
(86, '2019-04-05', '2019-08-05', 'Img42'),
(87, '2019-03-05', '2019-07-05', NULL),
(88, '2019-04-05', '2019-08-05', 'Img43'),
(89, '2019-02-05', '2019-06-05', NULL),
(90, '2019-01-05', '2019-08-05', 'Img44'),
(91, '2019-04-05', '2019-06-05', NULL),
(92, '2019-01-05', '2019-06-05', 'Img45'),
(93, '2019-02-05', '2019-06-05', NULL),
(94, '2019-02-05', '2019-09-05', 'Img46'),
(95, '2019-01-05', '2019-07-05', NULL),
(96, '2019-03-05', '2019-08-05', 'Img47'),
(97, '2019-04-05', '2019-09-05', NULL),
(98, '2019-04-05', '2019-08-05', 'Img48'),
(99, '2019-04-05', '2019-08-05', NULL),
(100, '2019-03-05', '2019-06-05', 'Img49'),
(101, '2019-02-05', '2019-06-05', NULL),
(102, '2019-03-05', '2019-07-05', 'Img50'),
(103, '2019-04-05', '2019-09-05', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `contenu_tag`
--

CREATE TABLE `contenu_tag` (
  `contenus_id` int(11) NOT NULL,
  `tags_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `contenu_tag`
--

INSERT INTO `contenu_tag` (`contenus_id`, `tags_id`) VALUES
(4, 2),
(4, 5),
(5, 1),
(5, 3),
(8, 1),
(8, 3),
(8, 5),
(10, 2),
(11, 2),
(11, 3),
(11, 4),
(14, 3),
(14, 4),
(14, 5),
(15, 2),
(16, 2),
(18, 2),
(19, 2),
(21, 4),
(22, 1),
(22, 3),
(22, 5),
(23, 1),
(23, 3),
(26, 2),
(27, 4),
(30, 3),
(31, 5),
(32, 2),
(32, 5),
(36, 2),
(36, 4),
(37, 1),
(37, 3),
(38, 3),
(38, 4),
(38, 5),
(39, 1),
(39, 4),
(42, 2),
(45, 2),
(45, 3),
(45, 4),
(45, 5),
(46, 4),
(47, 1),
(47, 2),
(47, 3),
(48, 3),
(50, 5),
(51, 1),
(51, 2),
(51, 3),
(52, 1),
(54, 2),
(55, 2),
(56, 3),
(56, 5),
(57, 3),
(59, 1),
(59, 3),
(59, 4),
(60, 2),
(60, 3),
(60, 4),
(61, 1),
(62, 5),
(65, 3),
(67, 3),
(68, 4),
(69, 2),
(69, 3),
(69, 5),
(71, 2),
(74, 3),
(75, 1),
(75, 5),
(77, 5),
(79, 1),
(79, 2),
(82, 1),
(83, 5),
(86, 4),
(86, 5),
(87, 4),
(89, 2),
(90, 2),
(90, 4),
(91, 2),
(91, 4),
(92, 5),
(95, 3),
(95, 4),
(96, 4),
(97, 5),
(99, 5),
(100, 3),
(101, 3),
(102, 1),
(103, 3);

-- --------------------------------------------------------

--
-- Structure de la table `documentpdf`
--

CREATE TABLE `documentpdf` (
  `nomAuteur` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `documentpdf`
--

INSERT INTO `documentpdf` (`nomAuteur`, `id`) VALUES
('Melo1', 5),
('Melo2', 7),
('Melo3', 9),
('Melo4', 11),
('Melo5', 13),
('Melo6', 15),
('Melo7', 17),
('Melo8', 19),
('Melo9', 21),
('Melo10', 23),
('Melo11', 25),
('Melo12', 27),
('Melo13', 29),
('Melo14', 31),
('Melo15', 33),
('Melo16', 35),
('Melo17', 37),
('Melo18', 39),
('Melo19', 41),
('Melo20', 43),
('Melo21', 45),
('Melo22', 47),
('Melo23', 49),
('Melo24', 51),
('Melo25', 53),
('Melo26', 55),
('Melo27', 57),
('Melo28', 59),
('Melo29', 61),
('Melo30', 63),
('Melo31', 65),
('Melo32', 67),
('Melo33', 69),
('Melo34', 71),
('Melo35', 73),
('Melo36', 75),
('Melo37', 77),
('Melo38', 79),
('Melo39', 81),
('Melo40', 83),
('Melo41', 85),
('Melo42', 87),
('Melo43', 89),
('Melo44', 91),
('Melo45', 93),
('Melo46', 95),
('Melo47', 97),
('Melo48', 99),
('Melo49', 101),
('Melo50', 103);

-- --------------------------------------------------------

--
-- Structure de la table `galerie`
--

CREATE TABLE `galerie` (
  `titre` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `galerie`
--

INSERT INTO `galerie` (`titre`, `id`) VALUES
('galerie1', 1),
('galerie2', 2),
('galerie3', 3);

-- --------------------------------------------------------

--
-- Structure de la table `image`
--

CREATE TABLE `image` (
  `fileName` varchar(255) DEFAULT NULL,
  `nomAuteur` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `galerie_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `image`
--

INSERT INTO `image` (`fileName`, `nomAuteur`, `id`, `galerie_id`) VALUES
('image1', 'Jenny1', 4, NULL),
('image2', 'Jenny2', 6, 2),
('image3', 'Jenny3', 8, NULL),
('image4', 'Jenny4', 10, 3),
('image5', 'Jenny5', 12, NULL),
('image6', 'Jenny6', 14, NULL),
('image7', 'Jenny7', 16, 2),
('image8', 'Jenny8', 18, NULL),
('image9', 'Jenny9', 20, NULL),
('image10', 'Jenny10', 22, 2),
('image11', 'Jenny11', 24, 1),
('image12', 'Jenny12', 26, NULL),
('image13', 'Jenny13', 28, NULL),
('image14', 'Jenny14', 30, NULL),
('image15', 'Jenny15', 32, NULL),
('image16', 'Jenny16', 34, NULL),
('image17', 'Jenny17', 36, 3),
('image18', 'Jenny18', 38, 2),
('image19', 'Jenny19', 40, 2),
('image20', 'Jenny20', 42, NULL),
('image21', 'Jenny21', 44, NULL),
('image22', 'Jenny22', 46, 2),
('image23', 'Jenny23', 48, NULL),
('image24', 'Jenny24', 50, NULL),
('image25', 'Jenny25', 52, 1),
('image26', 'Jenny26', 54, 3),
('image27', 'Jenny27', 56, NULL),
('image28', 'Jenny28', 58, 2),
('image29', 'Jenny29', 60, NULL),
('image30', 'Jenny30', 62, 1),
('image31', 'Jenny31', 64, NULL),
('image32', 'Jenny32', 66, 2),
('image33', 'Jenny33', 68, 2),
('image34', 'Jenny34', 70, 2),
('image35', 'Jenny35', 72, NULL),
('image36', 'Jenny36', 74, NULL),
('image37', 'Jenny37', 76, NULL),
('image38', 'Jenny38', 78, NULL),
('image39', 'Jenny39', 80, NULL),
('image40', 'Jenny40', 82, NULL),
('image41', 'Jenny41', 84, NULL),
('image42', 'Jenny42', 86, NULL),
('image43', 'Jenny43', 88, NULL),
('image44', 'Jenny44', 90, 1),
('image45', 'Jenny45', 92, NULL),
('image46', 'Jenny46', 94, 2),
('image47', 'Jenny47', 96, NULL),
('image48', 'Jenny48', 98, 3),
('image49', 'Jenny49', 100, NULL),
('image50', 'Jenny50', 102, 3);

-- --------------------------------------------------------

--
-- Structure de la table `tag`
--

CREATE TABLE `tag` (
  `id` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tag`
--

INSERT INTO `tag` (`id`, `libelle`) VALUES
(1, 'Tag 1'),
(2, 'Tag 2'),
(3, 'Tag 3'),
(4, 'Tag 4'),
(5, 'Tag 5');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `contenu`
--
ALTER TABLE `contenu`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `contenu_tag`
--
ALTER TABLE `contenu_tag`
  ADD PRIMARY KEY (`contenus_id`,`tags_id`),
  ADD KEY `FKtgjpqxawyu4wpp0f1aykbd2lu` (`tags_id`);

--
-- Index pour la table `documentpdf`
--
ALTER TABLE `documentpdf`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `galerie`
--
ALTER TABLE `galerie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK899n9h6yfpo0sy0kis5kf4u3d` (`galerie_id`);

--
-- Index pour la table `tag`
--
ALTER TABLE `tag`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `contenu`
--
ALTER TABLE `contenu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;

--
-- AUTO_INCREMENT pour la table `tag`
--
ALTER TABLE `tag`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `contenu_tag`
--
ALTER TABLE `contenu_tag`
  ADD CONSTRAINT `FKpdnx6aa62y82nuikpd51raxt3` FOREIGN KEY (`contenus_id`) REFERENCES `contenu` (`id`),
  ADD CONSTRAINT `FKtgjpqxawyu4wpp0f1aykbd2lu` FOREIGN KEY (`tags_id`) REFERENCES `tag` (`id`);

--
-- Contraintes pour la table `documentpdf`
--
ALTER TABLE `documentpdf`
  ADD CONSTRAINT `FKpr1bhqux8k4g2aj4d7wn0u2en` FOREIGN KEY (`id`) REFERENCES `contenu` (`id`);

--
-- Contraintes pour la table `galerie`
--
ALTER TABLE `galerie`
  ADD CONSTRAINT `FKolxppi2wykcnl6kd2jq9o1vgw` FOREIGN KEY (`id`) REFERENCES `contenu` (`id`);

--
-- Contraintes pour la table `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `FK899n9h6yfpo0sy0kis5kf4u3d` FOREIGN KEY (`galerie_id`) REFERENCES `galerie` (`id`),
  ADD CONSTRAINT `FKlgdhf3b7yik5h674kkujim67q` FOREIGN KEY (`id`) REFERENCES `contenu` (`id`);
--
-- Base de données :  `base_exerciceuniversitejpa`
--
CREATE DATABASE IF NOT EXISTS `base_exerciceuniversitejpa` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_exerciceuniversitejpa`;
--
-- Base de données :  `base_intro`
--
CREATE DATABASE IF NOT EXISTS `base_intro` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_intro`;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prix` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `description`, `nom`, `prix`) VALUES
(1, 'navet cuillit equitablement', 'navet equitable', 10),
(2, 'jolie et pas cher', 'poireaux', 2),
(3, 'bonne et onctueuse', 'puree de carotte', 52.3);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Base de données :  `base_java1`
--
CREATE DATABASE IF NOT EXISTS `base_java1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_java1`;

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

CREATE TABLE `contact` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `contact`
--

INSERT INTO `contact` (`id`, `nom`, `prenom`, `email`) VALUES
(1, 'schwarzenegger', 'arnold', 'arni@governetor.com'),
(2, 'jolie', 'angelina', 'angie@hollywood.com'),
(3, 'willis', 'bruce', 'bruce@hollywood'),
(4, 'reeves', 'keanu', 'reeves@matrixReloaded.com'),
(6, 'Stalonne', 'sylvester', 'sylvester@rambo.com'),
(7, 'Hamilton', 'smith', 'hamilton@f1.com'),
(8, 'Robin', 'william', 'robie@rien.com'),
(9, 'Portman', 'nathalie', 'portman@starwars.com'),
(11, 'Hamilton', 'Lewis', 'hamilton@f1.com');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `contact`
--
ALTER TABLE `contact`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Base de données :  `base_java2`
--
CREATE DATABASE IF NOT EXISTS `base_java2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_java2`;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prix` double NOT NULL,
  `poids` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `nom`, `prix`, `poids`) VALUES
(1, 'Chaussure', 25, 3),
(2, 'pull', 6, 2),
(3, 'short', 6, 1),
(4, 'maillot ', 18, 2),
(5, 'bottes', 52, 7);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Base de données :  `base_jpaheritagejointable`
--
CREATE DATABASE IF NOT EXISTS `base_jpaheritagejointable` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_jpaheritagejointable`;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `email` varchar(255) NOT NULL,
  `soldeCompte` double NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`email`, `soldeCompte`, `id`) VALUES
('arnie@governator', 15000, 11),
('sylv@rambo', 12000, 12),
('jodie@gmail.com', 11000, 13),
('kean@gmail.com', 18000, 14),
('jean@france.fr', 7000, 15);

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
  `poste` varchar(255) DEFAULT NULL,
  `salaire` double NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`poste`, `salaire`, `id`) VALUES
('Entretien', 1500, 6),
('Accueil', 1700, 7),
('Marketing', 1650, 8),
('CEO', 2650, 9),
('Vente', 1850, 10);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`) VALUES
(1, 'Eponge', 'Bob'),
(2, 'Etoile', 'Patrick'),
(3, 'Poulpe', 'Carlo'),
(4, 'Ecureil', 'Sandy'),
(5, 'Crabs', 'Capitaine'),
(6, 'Potter', 'Harry'),
(7, 'Granger', 'Hermione'),
(8, 'Weysley', 'Ron'),
(9, 'Dumbledore', 'Albus'),
(10, 'Rogue', 'Severus'),
(11, 'Swcharzenegger', 'Arnold'),
(12, 'Stalone', 'Sylverster'),
(13, 'Foster', 'Jodie'),
(14, 'Reeves', 'keanu'),
(15, 'Dujardin', 'Jean');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FKc3qeuiptc0xb9jh3t1pmgsm99` FOREIGN KEY (`id`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `employe`
--
ALTER TABLE `employe`
  ADD CONSTRAINT `FKhos0pussp4yn0kfu3hwjp9poo` FOREIGN KEY (`id`) REFERENCES `personne` (`id`);
--
-- Base de données :  `base_jpaheritagesingletable`
--
CREATE DATABASE IF NOT EXISTS `base_jpaheritagesingletable` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_jpaheritagesingletable`;
--
-- Base de données :  `base_jpaheritagetableperclass`
--
CREATE DATABASE IF NOT EXISTS `base_jpaheritagetableperclass` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_jpaheritagetableperclass`;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `soldeCompte` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `prenom`, `email`, `soldeCompte`) VALUES
(11, 'Swcharzenegger', 'Arnold', 'arnie@governator', 15000),
(12, 'Stalone', 'Sylverster', 'sylv@rambo', 12000),
(13, 'Foster', 'Jodie', 'jodie@gmail.com', 11000),
(14, 'Reeves', 'keanu', 'kean@gmail.com', 18000),
(15, 'Dujardin', 'Jean', 'jean@france.fr', 7000),
(62, 'Swcharzenegger', 'Arnold', 'arnie@governator', 15000),
(63, 'Stalone', 'Sylverster', 'sylv@rambo', 12000),
(64, 'Foster', 'Jodie', 'jodie@gmail.com', 11000),
(65, 'Reeves', 'keanu', 'kean@gmail.com', 18000),
(66, 'Dujardin', 'Jean', 'jean@france.fr', 7000),
(112, 'Swcharzenegger', 'Arnold', 'arnie@governator', 15000),
(113, 'Stalone', 'Sylverster', 'sylv@rambo', 12000),
(114, 'Foster', 'Jodie', 'jodie@gmail.com', 11000),
(115, 'Reeves', 'keanu', 'kean@gmail.com', 18000),
(116, 'Dujardin', 'Jean', 'jean@france.fr', 7000);

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `poste` varchar(255) DEFAULT NULL,
  `salaire` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`id`, `nom`, `prenom`, `poste`, `salaire`) VALUES
(6, 'Potter', 'Harry', 'Entretien', 1500),
(7, 'Granger', 'Hermione', 'Accueil', 1700),
(8, 'Weysley', 'Ron', 'Marketing', 1650),
(9, 'Dumbledore', 'Albus', 'CEO', 2650),
(10, 'Rogue', 'Severus', 'Vente', 1850),
(57, 'Potter', 'Harry', 'Entretien', 1500),
(58, 'Granger', 'Hermione', 'Accueil', 1700),
(59, 'Weysley', 'Ron', 'Marketing', 1650),
(60, 'Dumbledore', 'Albus', 'CEO', 2650),
(61, 'Rogue', 'Severus', 'Vente', 1850),
(107, 'Potter', 'Harry', 'Entretien', 1500),
(108, 'Granger', 'Hermione', 'Accueil', 1700),
(109, 'Weysley', 'Ron', 'Marketing', 1650),
(110, 'Dumbledore', 'Albus', 'CEO', 2650),
(111, 'Rogue', 'Severus', 'Vente', 1850);

-- --------------------------------------------------------

--
-- Structure de la table `mes_sequences`
--

CREATE TABLE `mes_sequences` (
  `mes_sequences` varchar(255) NOT NULL,
  `valeur_sequence` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `mes_sequences`
--

INSERT INTO `mes_sequences` (`mes_sequences`, `valeur_sequence`) VALUES
('personne', 201);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`) VALUES
(1, 'Eponge', 'Bob'),
(2, 'Etoile', 'Patrick'),
(3, 'Poulpe', 'Carlo'),
(4, 'Ecureil', 'Sandy'),
(5, 'Crabs', 'Capitaine'),
(52, 'Eponge', 'Bob'),
(53, 'Etoile', 'Patrick'),
(54, 'Poulpe', 'Carlo'),
(55, 'Ecureil', 'Sandy'),
(56, 'Crabs', 'Capitaine'),
(102, 'Eponge', 'Bob'),
(103, 'Etoile', 'Patrick'),
(104, 'Poulpe', 'Carlo'),
(105, 'Ecureil', 'Sandy'),
(106, 'Crabs', 'Capitaine');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `mes_sequences`
--
ALTER TABLE `mes_sequences`
  ADD PRIMARY KEY (`mes_sequences`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id`);
--
-- Base de données :  `base_maven`
--
CREATE DATABASE IF NOT EXISTS `base_maven` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_maven`;

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE `livre` (
  `id` int(11) NOT NULL,
  `titre` varchar(100) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `nbPages` int(11) NOT NULL,
  `auteur` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`id`, `titre`, `isbn`, `nbPages`, `auteur`) VALUES
(3, 'harry potter', '1236486513', 565, 'tortue'),
(12, 'star wars', '1236416455612', 1456, 'Mathieu'),
(13, 'Bully', '1236416455612', 365, 'Hiyoko5'),
(14, 'Level26', '85641354', 698, 'Ameri');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `livre`
--
ALTER TABLE `livre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- Base de données :  `base_premierjpa`
--
CREATE DATABASE IF NOT EXISTS `base_premierjpa` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_premierjpa`;
--
-- Base de données :  `base_uml`
--
CREATE DATABASE IF NOT EXISTS `base_uml` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_uml`;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `libelle` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `libelle`) VALUES
(1, 'legumes'),
(2, 'epicerie');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` int(11) NOT NULL,
  `dateCommande` date NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `dateCommande`, `total`) VALUES
(1, '2019-07-02', 140);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prix` double NOT NULL,
  `poids` double NOT NULL,
  `categorieId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `nom`, `prix`, `poids`, `categorieId`) VALUES
(1, 'quinoa des andes', 29.99, 1.5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `produit_commande`
--

CREATE TABLE `produit_commande` (
  `produitId` int(11) NOT NULL,
  `commandeId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit_commande`
--

INSERT INTO `produit_commande` (`produitId`, `commandeId`) VALUES
(1, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `produit_categorie` (`categorieId`);

--
-- Index pour la table `produit_commande`
--
ALTER TABLE `produit_commande`
  ADD PRIMARY KEY (`produitId`,`commandeId`),
  ADD KEY `pc_commande` (`commandeId`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `produit_categorie` FOREIGN KEY (`categorieId`) REFERENCES `categorie` (`id`);

--
-- Contraintes pour la table `produit_commande`
--
ALTER TABLE `produit_commande`
  ADD CONSTRAINT `pc_commande` FOREIGN KEY (`commandeId`) REFERENCES `commande` (`id`),
  ADD CONSTRAINT `pc_produit` FOREIGN KEY (`produitId`) REFERENCES `produit` (`id`);
--
-- Base de données :  `base_web1`
--
CREATE DATABASE IF NOT EXISTS `base_web1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_web1`;

-- --------------------------------------------------------

--
-- Structure de la table `films`
--

CREATE TABLE `films` (
  `id` int(11) NOT NULL,
  `titre` varchar(100) NOT NULL,
  `longueur` int(11) NOT NULL,
  `annee` int(11) NOT NULL,
  `genre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `films`
--

INSERT INTO `films` (`id`, `titre`, `longueur`, `annee`, `genre`) VALUES
(2, 'Blade runner', 180, 1982, 'Science Fiction'),
(3, 'Conan le barbare', 126, 1983, 'Fantasy'),
(7, 'star wars', 125, 1985, 'Science Fiction'),
(8, 'harry potter', 250, 2015, 'Science Fiction'),
(9, 'Shazam', 256, 2019, 'Fantastique'),
(11, 'Bully', 152, 1966, 'Science Fiction'),
(12, 'Chuky', 152, 1999, 'Horreur'),
(13, 'Chuky', 152, 1999, 'Horreur'),
(14, 'Chuky', 152, 1999, 'Horreur'),
(15, 'Chuky', 152, 1999, 'Horreur'),
(16, 'Chuky', 152, 1999, 'Horreur'),
(17, 'Chuky', 152, 1999, 'Horreur'),
(18, 'Fifa2020', 152, 152, 'Science Fiction'),
(19, 'Annabelle', 152, 2019, 'Horeur');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `films`
--
ALTER TABLE `films`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `films`
--
ALTER TABLE `films`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- Base de données :  `base_web2`
--
CREATE DATABASE IF NOT EXISTS `base_web2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `base_web2`;

-- --------------------------------------------------------

--
-- Structure de la table `jeux`
--

CREATE TABLE `jeux` (
  `id` int(11) NOT NULL,
  `titre` varchar(100) NOT NULL,
  `description` varchar(200) NOT NULL,
  `plateforme` varchar(100) NOT NULL,
  `anneeSortie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `jeux`
--

INSERT INTO `jeux` (`id`, `titre`, `description`, `plateforme`, `anneeSortie`) VALUES
(3, 'Gta', 'jeu', 'xbox', 2011),
(4, 'star wars', 'Eviter', 'ps4', 2010),
(5, 'Bully', 'Excellent', 'xbox', 2009),
(7, 'Fifa2020', 'Null', 'ps4', 2020),
(8, 'age of empire', 'recommander', 'pc', 2005),
(9, 'Hélicoptère', 'Eviter', 'pc', 1966);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `jeux`
--
ALTER TABLE `jeux`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `jeux`
--
ALTER TABLE `jeux`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Base de données :  `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Structure de la table `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(10) UNSIGNED NOT NULL,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- Structure de la table `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_length` text COLLATE utf8_bin DEFAULT NULL,
  `col_collation` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) COLLATE utf8_bin DEFAULT '',
  `col_default` text COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Central list of columns';

-- --------------------------------------------------------

--
-- Structure de la table `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Structure de la table `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `settings_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Settings related to Designer';

--
-- Déchargement des données de la table `pma__designer_settings`
--

INSERT INTO `pma__designer_settings` (`username`, `settings_data`) VALUES
('root', '{\"angular_direct\":\"direct\",\"snap_to_grid\":\"off\",\"relation_lines\":\"true\"}');

-- --------------------------------------------------------

--
-- Structure de la table `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `export_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `template_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `template_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved export templates';

-- --------------------------------------------------------

--
-- Structure de la table `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- Structure de la table `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp(),
  `sqlquery` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Structure de la table `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hidden items of navigation tree';

--
-- Déchargement des données de la table `pma__navigationhiding`
--

INSERT INTO `pma__navigationhiding` (`username`, `item_name`, `item_type`, `db_name`, `table_name`) VALUES
('root', 'film', 'table', 'base_exercicejpa2', '');

-- --------------------------------------------------------

--
-- Structure de la table `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

--
-- Déchargement des données de la table `pma__pdf_pages`
--

INSERT INTO `pma__pdf_pages` (`db_name`, `page_nr`, `page_descr`) VALUES
('base_uml', 1, 'produit');

-- --------------------------------------------------------

--
-- Structure de la table `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Déchargement des données de la table `pma__recent`
--

INSERT INTO `pma__recent` (`username`, `tables`) VALUES
('root', '[{\"db\":\"base_exercicejpaavance\",\"table\":\"contenu_tag\"},{\"db\":\"base_exercicejpaavance\",\"table\":\"image\"},{\"db\":\"base_exercicejpaavance\",\"table\":\"tag\"},{\"db\":\"base_exercicejpaavance\",\"table\":\"galerie\"},{\"db\":\"base_exercicejpaavance\",\"table\":\"contenu\"},{\"db\":\"base_exercicejpaavance\",\"table\":\"documentpdf\"},{\"db\":\"base_jpaheritagesingletable\",\"table\":\"personne\"},{\"db\":\"base_jpaheritagetableperclass\",\"table\":\"mes_sequences\"},{\"db\":\"base_jpaheritagetableperclass\",\"table\":\"employe\"},{\"db\":\"base_jpaheritagetableperclass\",\"table\":\"client\"}]');

-- --------------------------------------------------------

--
-- Structure de la table `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Structure de la table `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved searches';

-- --------------------------------------------------------

--
-- Structure de la table `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT 0,
  `x` float UNSIGNED NOT NULL DEFAULT 0,
  `y` float UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

--
-- Déchargement des données de la table `pma__table_coords`
--

INSERT INTO `pma__table_coords` (`db_name`, `table_name`, `pdf_page_number`, `x`, `y`) VALUES
('base_uml', 'categorie', 1, 554, 85),
('base_uml', 'commande', 1, 224, 359),
('base_uml', 'produit', 1, 223, 20),
('base_uml', 'produit_commande', 1, 225, 202);

-- --------------------------------------------------------

--
-- Structure de la table `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

--
-- Déchargement des données de la table `pma__table_info`
--

INSERT INTO `pma__table_info` (`db_name`, `table_name`, `display_field`) VALUES
('base_association', 'produit', 'nom'),
('base_uml', 'produit', 'nom');

-- --------------------------------------------------------

--
-- Structure de la table `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `prefs` text COLLATE utf8_bin NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

--
-- Déchargement des données de la table `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'base_association', 'produit', '[]', '2019-08-05 08:23:50'),
('root', 'base_association', 'produit_commande', '{\"sorted_col\":\"`produit_commande`.`commande_id` ASC\"}', '2019-08-05 09:19:28'),
('root', 'base_exerciceuniversitejpa', 'cours_etudiant', '{\"sorted_col\":\"`cours_etudiant`.`etudiants_id` ASC\"}', '2019-08-06 14:37:23');

-- --------------------------------------------------------

--
-- Structure de la table `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_bin NOT NULL,
  `schema_sql` text COLLATE utf8_bin DEFAULT NULL,
  `data_sql` longtext COLLATE utf8_bin DEFAULT NULL,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_bin DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Structure de la table `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `config_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Déchargement des données de la table `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2019-08-08 07:58:08', '{\"Console\\/Mode\":\"collapse\",\"lang\":\"fr\",\"NavigationWidth\":251}');

-- --------------------------------------------------------

--
-- Structure de la table `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL,
  `tab` varchar(64) COLLATE utf8_bin NOT NULL,
  `allowed` enum('Y','N') COLLATE utf8_bin NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- Structure de la table `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and their assignments to user groups';

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Index pour la table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Index pour la table `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Index pour la table `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Index pour la table `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Index pour la table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Index pour la table `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Index pour la table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Index pour la table `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Index pour la table `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Index pour la table `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Index pour la table `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Index pour la table `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Index pour la table `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Base de données :  `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
