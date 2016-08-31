/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : schoolbbs

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-02-03 20:15:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  `touid` int(11) NOT NULL,
  `msg` text NOT NULL,
  `isread` int(11) NOT NULL,
  `chattime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `touid` (`touid`),
  KEY `chat_ibfk_2` (`rid`),
  CONSTRAINT `chat_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `chat_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `reply` (`id`),
  CONSTRAINT `chat_ibfk_3` FOREIGN KEY (`touid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO `chat` VALUES ('25', '1', '11', '1', 'asd', '0', '2015-09-20 20:38:40');
INSERT INTO `chat` VALUES ('26', '1', '13', '2', 'asdfsad', '1', '2015-09-20 21:13:58');
INSERT INTO `chat` VALUES ('27', '2', '13', '1', '腻的', '1', '2015-09-20 21:19:38');
INSERT INTO `chat` VALUES ('28', '1', '13', '2', 'adsf', '1', '2015-09-20 21:32:34');
INSERT INTO `chat` VALUES ('29', '1', '13', '2', '爱的色放', '1', '2015-09-20 21:54:47');
INSERT INTO `chat` VALUES ('30', '1', '13', '2', '爱的色放', '1', '2015-09-20 22:35:17');
INSERT INTO `chat` VALUES ('31', '1', '13', '2', '爱的色放阿斯顿发', '1', '2015-09-20 22:41:26');
INSERT INTO `chat` VALUES ('32', '1', '13', '2', '( ⊙ o ⊙ )啊！', '1', '2015-09-20 22:44:15');
INSERT INTO `chat` VALUES ('33', '2', '13', '1', 'gun', '1', '2015-09-20 22:44:30');
INSERT INTO `chat` VALUES ('34', '1', '13', '4', 'afsdfasdf ', '1', '2015-09-21 15:13:38');
INSERT INTO `chat` VALUES ('35', '4', '18', '3', 'gsdgdsgf', '1', '2016-01-13 19:56:54');
INSERT INTO `chat` VALUES ('36', '4', '15', '3', 'sdfgsdfg', '1', '2016-01-13 19:56:57');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `content` text NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('2', 'qqq', 'sadf<br/>s<br/>s<br/>s<br/>s', '2015-09-19 14:45:42');
INSERT INTO `notice` VALUES ('3', 'asdf', 'asdfasdf', '2015-09-19 16:29:56');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `qid` int(11) NOT NULL,
  `replymsg` text NOT NULL,
  `date` datetime NOT NULL,
  `username` varchar(255) NOT NULL,
  `isread` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `qid` (`qid`),
  KEY `username` (`username`),
  CONSTRAINT `reply_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `reply_ibfk_2` FOREIGN KEY (`qid`) REFERENCES `topic` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('8', '1', '4', 'dsfgasdfasdf', '2015-09-19 17:10:37', 'qq', '0');
INSERT INTO `reply` VALUES ('9', '1', '4', 'ewrqwer', '2015-09-19 17:31:03', 'qq', '0');
INSERT INTO `reply` VALUES ('10', '1', '4', '是大法官是大法官是大法官是的', '2015-09-20 18:01:10', 'qq', '0');
INSERT INTO `reply` VALUES ('11', '1', '4', 'adfasdfasdf', '2015-09-20 18:01:50', 'qq', '0');
INSERT INTO `reply` VALUES ('12', '2', '4', 'sdfgsdfgsdfgdsfg', '2015-09-20 20:44:12', '2', '1');
INSERT INTO `reply` VALUES ('13', '2', '4', '是广东省地方', '2015-09-20 21:13:38', '2', '1');
INSERT INTO `reply` VALUES ('14', '3', '4', 'sadfsdfgdgf', '2016-01-13 19:35:26', 'sdg', '0');
INSERT INTO `reply` VALUES ('15', '3', '5', 'adasdfsafd', '2016-01-13 19:46:10', 'sdg', '1');
INSERT INTO `reply` VALUES ('16', '3', '6', 'gfdsgsdgf', '2016-01-13 19:47:56', 'sdg', '0');
INSERT INTO `reply` VALUES ('17', '4', '5', 'fgdsgsdfg', '2016-01-13 19:54:11', '3434', '1');
INSERT INTO `reply` VALUES ('18', '3', '7', 'asdfasdfsadfsadf', '2016-01-13 19:56:22', 'sdg', '1');

-- ----------------------------
-- Table structure for tickling
-- ----------------------------
DROP TABLE IF EXISTS `tickling`;
CREATE TABLE `tickling` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msg` text NOT NULL,
  `isread` int(11) NOT NULL DEFAULT '0',
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tickling
-- ----------------------------
INSERT INTO `tickling` VALUES ('1', 'asdfasdffsdfsdf', '0', '2015-09-19 21:34:42');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `title` varchar(28) NOT NULL,
  `detail` text NOT NULL,
  `reply` bigint(20) NOT NULL DEFAULT '0',
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `topic_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('1', '1', 'qqq', 'qweqweqwfsadf<br/>gfhj', '0', '2015-09-19 14:36:06');
INSERT INTO `topic` VALUES ('2', '1', 'sadf', 'asdfasdfsadf', '0', '2015-09-19 16:36:47');
INSERT INTO `topic` VALUES ('3', '1', 'sasdfsadf', 'asdfasdfasdf', '0', '2015-09-19 17:04:37');
INSERT INTO `topic` VALUES ('4', '1', '你好', '阿什顿发撒旦法手动zxcv', '7', '2015-09-19 17:05:17');
INSERT INTO `topic` VALUES ('5', '4', 'asdf', 'asdfffffffffffffffffffffffffffffffff', '2', '2016-01-13 19:45:24');
INSERT INTO `topic` VALUES ('6', '5', '3434', '3434343434343434', '1', '2016-01-13 19:47:26');
INSERT INTO `topic` VALUES ('7', '4', '3434-44', 'aaasdfasdf', '1', '2016-01-13 19:56:12');

-- ----------------------------
-- Table structure for uploadfiles
-- ----------------------------
DROP TABLE IF EXISTS `uploadfiles`;
CREATE TABLE `uploadfiles` (
  `int` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `uploadtime` datetime DEFAULT NULL,
  PRIMARY KEY (`int`),
  UNIQUE KEY `filename` (`filename`),
  KEY `uid` (`uid`),
  CONSTRAINT `uploadfiles_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of uploadfiles
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1@qq.com', 'qq', '343b1c4a3ea721b2d640fc8700db0f36');
INSERT INTO `user` VALUES ('2', '2@qq.com', '2', '343b1c4a3ea721b2d640fc8700db0f36');
INSERT INTO `user` VALUES ('3', 'sdg@qq.com', 'sdg', 'a2f7a57d35ff48fc7d095821f53d140f');
INSERT INTO `user` VALUES ('4', '3434@qq.com', '3434', '773d1df78f82629fac1ccb6b4121c7de');
INSERT INTO `user` VALUES ('5', '34343434@qq.com', '34343434', '773d1df78f82629fac1ccb6b4121c7de');
DROP TRIGGER IF EXISTS `countreply`;
DELIMITER ;;
CREATE TRIGGER `countreply` AFTER INSERT ON `reply` FOR EACH ROW BEGIN
update topic set reply=reply+1 where id=new.qid;
 END
;;
DELIMITER ;
