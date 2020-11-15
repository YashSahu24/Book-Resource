CREATE DATABASE  IF NOT EXISTS `book-resource`;
USE `book-resource`;
DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bid` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `price` int(10) DEFAULT NULL,
  `country` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `book` VALUES 
	(1,'2 states','Chetan Bhagat','Male','500','India'),
	(2,'To Kill a Mockingbird','Harper Lee','Female','1000','USA'),
	(3,'Harry Potter','J.K. Rowling','Female','1500','England'),
	(4,'The Monk Who Sold His Ferrari',' Robin Sharma','Male','1200','Canada'),
	(5,'Train to Pakistan','Khushwant Singh','Male','900','India'),
    (6,'East of Eden','John Steinbeck','Male','900','USA'),
    (7,'Rang ka Patta','Amrita Pritam','Female','1100','India'),
    (8,'The 3 Mistakes of My Life','Chetan Bhagat','Male','850','India');
