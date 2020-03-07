/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : hope

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-03-07 11:27:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for active_tb
-- ----------------------------
DROP TABLE IF EXISTS `active_tb`;
CREATE TABLE `active_tb` (
  `act_id` int(11) NOT NULL AUTO_INCREMENT,
  `act_name` varchar(20) NOT NULL,
  `act_describe` varchar(255) NOT NULL,
  `act_address` varchar(50) NOT NULL,
  `act_start` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `act_status` int(5) NOT NULL DEFAULT '0',
  `act_ok` int(5) NOT NULL DEFAULT '0',
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`act_id`),
  KEY `act_user_id_fk` (`user_id`),
  CONSTRAINT `act_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user_tb` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of active_tb
-- ----------------------------

-- ----------------------------
-- Table structure for attestation_tb
-- ----------------------------
DROP TABLE IF EXISTS `attestation_tb`;
CREATE TABLE `attestation_tb` (
  `att_id` int(11) NOT NULL AUTO_INCREMENT,
  `act_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `att_explain` varchar(255) NOT NULL DEFAULT '0',
  `att_help` int(5) NOT NULL,
  PRIMARY KEY (`att_id`),
  KEY `att_act_id_fk` (`act_id`),
  KEY `att_user_id_fk` (`user_id`),
  CONSTRAINT `att_act_id_fk` FOREIGN KEY (`act_id`) REFERENCES `active_tb` (`act_id`),
  CONSTRAINT `att_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user_tb` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of attestation_tb
-- ----------------------------

-- ----------------------------
-- Table structure for help_tb
-- ----------------------------
DROP TABLE IF EXISTS `help_tb`;
CREATE TABLE `help_tb` (
  `help_id` int(11) NOT NULL AUTO_INCREMENT,
  `act_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`help_id`),
  KEY `help_act_id_fk` (`act_id`),
  KEY `help_user_id_fk` (`user_id`),
  CONSTRAINT `help_act_id_fk` FOREIGN KEY (`act_id`) REFERENCES `active_tb` (`act_id`),
  CONSTRAINT `help_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user_tb` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of help_tb
-- ----------------------------

-- ----------------------------
-- Table structure for image_tb
-- ----------------------------
DROP TABLE IF EXISTS `image_tb`;
CREATE TABLE `image_tb` (
  `img_id` int(11) NOT NULL AUTO_INCREMENT,
  `img_path` varchar(255) NOT NULL,
  `img_type` int(5) NOT NULL,
  `act_id` int(11) DEFAULT NULL,
  `att_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`img_id`),
  KEY `img_act_id_fk` (`act_id`),
  KEY `img_att_id_fk` (`att_id`),
  CONSTRAINT `img_act_id_fk` FOREIGN KEY (`act_id`) REFERENCES `active_tb` (`act_id`),
  CONSTRAINT `img_att_id_fk` FOREIGN KEY (`att_id`) REFERENCES `attestation_tb` (`att_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of image_tb
-- ----------------------------

-- ----------------------------
-- Table structure for user_tb
-- ----------------------------
DROP TABLE IF EXISTS `user_tb`;
CREATE TABLE `user_tb` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `registrationID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_picture` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_tel` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '湖南省-长沙市-芙蓉区',
  `user_sex` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '男',
  `user_birthday` date NOT NULL DEFAULT '2020-01-01',
  `user_autograph` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '这个人很懒，什么也没留下！',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_tb
-- ----------------------------
