DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`(
  `id` INT(11) AUTO_INCREMENT,
  `name` VARCHAR(20),
  PRIMARY KEY(`id`)
);

-- 插入初始化数据，只有这一句会被回滚
INSERT INTO `user` (`id`, `name`) VALUES (99, '哈哈');