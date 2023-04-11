# ************************************************************
# Sequel Ace SQL dump
# Version 20044
#
# https://sequel-ace.com/
# https://github.com/Sequel-Ace/Sequel-Ace
#
# Host: localhost (MySQL 8.0.29)
# Database: linker_chatgroup
# Generation Time: 2023-04-11 09:41:47 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE='NO_AUTO_VALUE_ON_ZERO', SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table categories
# ------------------------------------------------------------

CREATE DATABASE IF NOT EXISTS linker_chatgroup;


DROP TABLE IF EXISTS `categories`;

CREATE TABLE `categories` (
  `id_category` int NOT NULL AUTO_INCREMENT,
  `name_category` varchar(32) NOT NULL,
  PRIMARY KEY (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;

INSERT INTO `categories` (`id_category`, `name_category`)
VALUES
	(1,'sport'),
	(2,'life'),
	(3,'culture'),
	(4,'food'),
	(5,'technology'),
	(6,'film'),
	(7,'music');

/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table chatgroups
# ------------------------------------------------------------

DROP TABLE IF EXISTS `chatgroups`;

CREATE TABLE `chatgroups` (
  `id_group` int NOT NULL AUTO_INCREMENT,
  `name_g` varchar(64) NOT NULL,
  `date` date NOT NULL,
  `id_owner` int NOT NULL,
  `description` text NOT NULL,
  `id_category` int NOT NULL,
  PRIMARY KEY (`id_group`),
  KEY `group_user_fk` (`id_owner`),
  KEY `group_category` (`id_category`),
  CONSTRAINT `group_category` FOREIGN KEY (`id_category`) REFERENCES `categories` (`id_category`),
  CONSTRAINT `group_user_fk` FOREIGN KEY (`id_owner`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `chatgroups` WRITE;
/*!40000 ALTER TABLE `chatgroups` DISABLE KEYS */;

INSERT INTO `chatgroups` (`id_group`, `name_g`, `date`, `id_owner`, `description`, `id_category`)
VALUES
	(1,'cult movie fan club','2023-03-29',2,'we all love cult movies!',6),
	(2,'kpop lovers','2023-03-27',3,'love kpop~',7),
	(3,'sushi! sushi! suishi!','2023-04-07',2,'We can die for sushi',4),
	(4,'Hayao Miyazaki is the god','2023-04-09',3,'kk',6),
	(5,'Joe Hisaishi fanclub','2023-04-10',2,'King ~~!!!!',7),
	(6,'Basketball team of Sorbonne Universite','2023-04-10',2,'Welcome every student of Sorbonne Universite',1);

/*!40000 ALTER TABLE `chatgroups` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table comments
# ------------------------------------------------------------

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `id_comment` int NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `date` date NOT NULL,
  `id_owner` int NOT NULL,
  `id_post` int NOT NULL,
  `nblike` int NOT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `comment_user_fk` (`id_owner`),
  KEY `comment_post_fk` (`id_post`),
  CONSTRAINT `comment_post_fk` FOREIGN KEY (`id_post`) REFERENCES `posts` (`id_post`),
  CONSTRAINT `comment_user_fk` FOREIGN KEY (`id_owner`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;

INSERT INTO `comments` (`id_comment`, `content`, `date`, `id_owner`, `id_post`, `nblike`)
VALUES
	(1,'Yes, i think so too~','2023-04-04',3,1,2),
	(2,'I watched it like about hundred times!!!!!!!!','2023-04-05',3,1,3),
	(3,'i love Mina:)','2023-04-07',2,5,4),
	(4,'Who do you like the most?','2023-04-07',2,5,2),
	(5,'I also loveeee momo!!!','2023-04-07',2,5,4),
	(6,'Why there is no one answer me :(','2023-04-10',2,7,2),
	(7,'Anyone wanna go???!!!!','2023-04-10',2,8,0);

/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table posts
# ------------------------------------------------------------

DROP TABLE IF EXISTS `posts`;

CREATE TABLE `posts` (
  `id_post` int NOT NULL AUTO_INCREMENT,
  `title` varchar(256) NOT NULL,
  `content` text NOT NULL,
  `date` date NOT NULL,
  `id_owner` int NOT NULL,
  `id_group` int NOT NULL,
  `nblike` int NOT NULL,
  PRIMARY KEY (`id_post`),
  KEY `post_user_fk` (`id_owner`),
  KEY `post_group_fk` (`id_group`),
  CONSTRAINT `post_group_fk` FOREIGN KEY (`id_group`) REFERENCES `chatgroups` (`id_group`),
  CONSTRAINT `post_user_fk` FOREIGN KEY (`id_owner`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;

INSERT INTO `posts` (`id_post`, `title`, `content`, `date`, `id_owner`, `id_group`, `nblike`)
VALUES
	(1,'Have you ever watched EI Topo?','It was great!','2023-03-26',2,1,10),
	(2,'The Rocky Horror Picture Show is the best!','I really really love it!!!!','2023-03-28',2,1,3),
	(5,'Twice is the best!!','They are so pretty~','2023-04-04',3,2,1),
	(6,'There is a new grils group called NewJeans','Did you guys know that?!!','2023-04-07',2,2,4),
	(7,'BlackPink is going to have a concert in Paris!!!','In a few months, anyone wanna go?!','2023-04-07',2,2,3),
	(8,'He will have a concert in Paris sonn!!','wow~','2023-04-10',2,4,0);

/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(256) NOT NULL,
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `firstname` varchar(32) NOT NULL,
  `lastname` varchar(32) NOT NULL,
  `birthday` date NOT NULL,
  `telephone` varchar(32) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`id_user`, `username`, `password`, `email`, `firstname`, `lastname`, `birthday`, `telephone`)
VALUES
	(1,'ma','meme','darr@daar.com','firstname','lastname','1989-10-02','331045203040'),
	(2,'yvo','123456','yvo@gmail.com','yvo','zhang','1998-04-18','0653266985'),
	(3,'yajie','123456','yajie@gmail.com','yajie','liu','1999-01-01','0659611452'),
	(4,'zimeng','$2a$10$otGJaaATxlbzRfI50hxT9.nxAr6W/SAvXuWvlv1v2YIDaKZ7p3W/.','zimeng@gmail.com','zimeng','zhang','2023-04-02','659987435'),
	(5,'dsfds','$2a$10$oC0bN./xktBBMXuWeqZf/.kKyHp13GDbgEVsmY5wAyfuCtN930NgO','dsfsdf','fdsfd','sdfds','2023-04-01','979787665'),
	(6,'dfsd','$2a$10$HGD7Hi6FwfdyDc/xeaZd6OtCV.p0koHybes9h.1KwFkw7v/AnvoVG','sdfds','fsdfsd','sdfsd','2023-03-31','97886');

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users_chatgroups
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users_chatgroups`;

CREATE TABLE `users_chatgroups` (
  `id_user` int NOT NULL,
  `id_group` int NOT NULL,
  PRIMARY KEY (`id_user`,`id_group`),
  KEY `user_group_fk_a` (`id_group`),
  CONSTRAINT `user_group_fk_a` FOREIGN KEY (`id_group`) REFERENCES `chatgroups` (`id_group`),
  CONSTRAINT `user_group_fk_b` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `users_chatgroups` WRITE;
/*!40000 ALTER TABLE `users_chatgroups` DISABLE KEYS */;

INSERT INTO `users_chatgroups` (`id_user`, `id_group`)
VALUES
	(2,1),
	(3,1),
	(2,2),
	(3,2);

/*!40000 ALTER TABLE `users_chatgroups` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
