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
(2,'Salman','Khan','salman@gmail.com'),
(3,'Virat','Kohli','virat@gmail.com'),
(4,'Niraj','Chopra','niraj@gmail.com'),
(5,'Pradip','Narval','pradip@gmail.com');

CREATE TABLE `authorities`(
`username` varchar(45) NOT NULL,
`authority` varchar(45) NOT NULL,
unique key `authority_idx_1` (`username`,`authority`),
constraint `authority_ibfk_1` foreign key (`username`) references `users`(`username`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `members`(
`user_id` varchar(45) NOT NULL,
`pass` char(64) NOT NULL,
`active` tinyint NOT NULL,
PRIMARY KEY(`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `authorities`
values ('john','ROLE_EMPLOYEE'),
 ('merry','ROLE_EMPLOYEE'),
 ('merry','ROLE_MANAGER'),
 ('susan','ROLE_EMPLOYEE'),
 ('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN');
