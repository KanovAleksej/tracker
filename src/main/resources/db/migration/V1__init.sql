CREATE SCHEMA `workout_planner`;
USE `workout_planner`;
SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `exercise`
(
    `exerciseId`         INT          NOT NULL AUTO_INCREMENT,
    `exercise_name`      VARCHAR(128) NOT NULL,
    `rep_count`          INT DEFAULT NULL,
    `previous_rep_count` INT DEFAULT NULL,
    PRIMARY KEY (`exerciseId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;