DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`(
  `id` INT(11) AUTO_INCREMENT,
  `name` VARCHAR(20),
  `age` INT(3),
  PRIMARY KEY(`id`)
);

INSERT INTO `user`(`name`, `age`) VALUES ('x1', 25);
INSERT INTO `user`(`name`, `age`) VALUES ('x2', 25);
INSERT INTO `user`(`name`, `age`) VALUES ('x3', 25);
INSERT INTO `user`(`name`, `age`) VALUES ('x4', 25);
INSERT INTO `user`(`name`, `age`) VALUES ('x5', 25);