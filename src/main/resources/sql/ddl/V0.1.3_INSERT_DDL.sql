DROP TABLE IF EXISTS `t_rate_statistic`;
CREATE TABLE `t_rate_statistic` (
  `movie_id` int(11) NOT NULL,
  `total_rate` int(11) NOT NULL,
  `total_count` int(11) NOT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_rate_detail`;
CREATE TABLE `t_rate_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `movie_id` int(11) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;