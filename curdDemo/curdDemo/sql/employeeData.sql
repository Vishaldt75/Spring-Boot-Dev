CREATE DATABASE IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee`(
`id` int NOT NULL AUTO_INCREMENT,
`first_name` varchar(45) DEFAULT NULL,
`last_name` varchar(45) DEFAULT NULL,
`email` varchar(45) DEFAULT NULL,
PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `employee` VALUES
(1,'Shraddha','Kapoor','shraddha@gmail.com'),
(1,'Salman','Khan','salman@gmail.com'),
(1,'Virat','Kohli','virat@gmail.com'),
(1,'Niraj','Chopra','niraj@gmail.com'),
(1,'Pradip','Narval','pradip@gmail.com');

