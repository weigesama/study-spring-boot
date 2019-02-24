drop database if exists jdbc_test1;
create database `jdbc_test1`;
use `jdbc_test1`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
  `id` INT(11) AUTO_INCREMENT,
  `name` VARCHAR(20),
  `age` INT(3),
  PRIMARY KEY(`id`)
);

drop database if exists jdbc_test2;
create database `jdbc_test2`;
use `jdbc_test2`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
  `id` INT(11) AUTO_INCREMENT,
  `name` VARCHAR(20),
  `age` INT(3),
  PRIMARY KEY(`id`)
);

