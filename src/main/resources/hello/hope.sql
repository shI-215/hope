/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : hope

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-03-07 11:12:38
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
INSERT INTO `active_tb` VALUES ('18', 'gd', 'fdfg梵蒂冈到竣工都放假哦功夫都挂机辅导机构都放假哦个机电佛光奇偶的架构的是架构房东架构ofo放大镜欧根纱发动机哦', 'United StatesCaliforniaMountain View', '2020-02-27 16:53:38', '1', '1', '1');
INSERT INTO `active_tb` VALUES ('19', '湖北省', '加油武汉和GIF督公湖梵蒂冈火凤凰故事风格号合肥市搜狗回复更换发的规划法好发过火烦得很过更好地发挥工房东我返回规定合法冠福股份海阔回复讴歌短发韩国飞浪费道格拉斯豆腐干豆腐开个会短发韩国好地方IG地方化工电费规划的法规和地方合格东方红我改好地方规划地方开个会款到发货功夫 地方化工款到发货规划电费个 ', '中国湖北省襄阳市南漳县李庙镇', '2020-02-28 09:12:26', '0', '1', '1');
INSERT INTO `active_tb` VALUES ('20', 'hello湖南', '加油湖南大哥好地方廉洁奉公到df8g方大化工我花覅活动机构的佛房东 打工到国代购东方精工都放假哦个大家佛光东方广东昂地方化工电费个大风歌大分配给ad分配给爱德华歌单复合弓好地方规划答复哈给对方合格地方化工我好地方似乎更单方事故大风歌好 电费更好地佛山个', '中国湖北省襄阳市南漳县李庙镇', '2020-02-28 09:21:10', '0', '1', '1');
INSERT INTO `active_tb` VALUES ('21', '鬼地方个地方大哥大法官', '电费鬼地方个地方答复哈方式发过火飞方式发给发顺丰规划东方广东返回的对方回复对符合法规是否恢复供货商防溺水发的发生过水费是对符合规范食不果腹发送电费鬼地方个地方电费发布到反射光栅', '中国湖北省襄阳市南漳县李庙镇', '2020-02-29 13:56:12', '0', '1', '1');
INSERT INTO `active_tb` VALUES ('22', 'dfdgdfggfdgdf规范大概电饭锅', '打个电话价格很快机会打开似乎哦的哦符合个哦电话费I过后地方客户公开东方航空更好的开发更何况地方机会公开I韩国货到付款韩国看到很快更好的客户关卡对话框更好的看过和I活动看过的个I电话费I过后地方I韩国I电话费过后地方I韩国I皇帝过后地方   和I和I', 'United StatesCaliforniaMountain View', '2020-02-29 21:35:20', '0', '0', '1');

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
INSERT INTO `help_tb` VALUES ('1', '18', '1');
INSERT INTO `help_tb` VALUES ('2', '20', '1');
INSERT INTO `help_tb` VALUES ('3', '18', '4');

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
INSERT INTO `image_tb` VALUES ('7', '/file/1582793558739.png', '1', '18', null);
INSERT INTO `image_tb` VALUES ('8', '/file/1582793567805.png', '2', '18', null);
INSERT INTO `image_tb` VALUES ('9', '/file/1582793567808.png', '2', '18', null);
INSERT INTO `image_tb` VALUES ('10', '/file/1582852317606.png', '1', '19', null);
INSERT INTO `image_tb` VALUES ('11', '/file/1582852326052.png', '2', '19', null);
INSERT INTO `image_tb` VALUES ('12', '/file/1582852326216.png', '2', '19', null);
INSERT INTO `image_tb` VALUES ('13', '/file/1582852843604.jpg', '1', '20', null);
INSERT INTO `image_tb` VALUES ('14', '/file/1582852851428.jpg', '2', '20', null);
INSERT INTO `image_tb` VALUES ('15', '/file/1582852851433.jpg', '2', '20', null);
INSERT INTO `image_tb` VALUES ('16', '/file/1582955725068.jpg', '1', '21', null);
INSERT INTO `image_tb` VALUES ('17', '/file/1582955743211.jpg', '2', '21', null);
INSERT INTO `image_tb` VALUES ('18', '/file/1582983273318.jpg', '1', '22', null);
INSERT INTO `image_tb` VALUES ('19', '/file/1582983277240.jpg', '2', '22', null);

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
INSERT INTO `user_tb` VALUES ('1', null, '', '李四', '17752839142', '17752839142', '湖南省-郴州市-北湖区', '女', '2020-01-28', '这个人很懒，什么也没留下！');
INSERT INTO `user_tb` VALUES ('4', null, null, '19848042156', '19848042156', '19848042156', '湖南省-长沙市-芙蓉区', '男', '2020-01-01', '这个人很懒，什么也没留下！');
