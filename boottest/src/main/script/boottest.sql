/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : boottest

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-19 23:16:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(64) DEFAULT NULL COMMENT '城市名称',
  `CODE` varchar(32) DEFAULT NULL COMMENT '城市编号',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `CREATE_OPER_ID` varchar(32) DEFAULT NULL COMMENT '创建者',
  `UPDATE_OPER_ID` varchar(32) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `IND1_CITY` (`CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='市级信息';

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('3', '北京', '1001', '2018-05-19 17:16:16', null, 'admin', null);
INSERT INTO `city` VALUES ('4', '上海', '1002', '2018-05-19 18:53:40', null, 'admin', null);
INSERT INTO `city` VALUES ('5', '杭州', '1003', '2018-05-19 18:53:40', null, 'admin', null);
INSERT INTO `city` VALUES ('6', '南京', '1004', '2018-05-19 18:53:40', null, 'admin', null);
INSERT INTO `city` VALUES ('7', '深圳', '1005', '2018-05-19 18:53:40', null, 'admin', null);
INSERT INTO `city` VALUES ('8', '香港', '1006', '2018-05-19 18:53:40', null, 'admin', null);
INSERT INTO `city` VALUES ('9', '澳门', '1007', '2018-05-19 18:53:40', null, 'admin', null);
INSERT INTO `city` VALUES ('10', '重庆', '1008', '2018-05-19 18:53:40', null, 'admin', null);
INSERT INTO `city` VALUES ('11', '青岛', '1009', '2018-05-19 18:53:40', null, 'admin', null);
INSERT INTO `city` VALUES ('12', '成都', '1010', '2018-05-19 18:53:40', null, 'admin', null);
INSERT INTO `city` VALUES ('13', '合肥', '1011', '2018-05-19 18:53:40', null, 'admin', null);
INSERT INTO `city` VALUES ('14', '大连', '1012', '2018-05-19 18:55:21', null, 'admin', null);
INSERT INTO `city` VALUES ('15', '福建', '1013', '2018-05-19 18:55:21', null, 'admin', null);
INSERT INTO `city` VALUES ('16', '苏州', '1014', '2018-05-19 19:04:27', null, 'admin', null);
INSERT INTO `city` VALUES ('17', '芜湖', '1015', '2018-05-19 19:05:06', null, 'admin', null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(64) DEFAULT NULL COMMENT '用户名称',
  `PASSWORD` varchar(64) DEFAULT NULL COMMENT '登录密码',
  `MOBILE` varchar(15) DEFAULT NULL COMMENT '用户手机号',
  `CITY_CODE` varchar(32) DEFAULT NULL COMMENT '所在城市编号',
  `CITY_NAME` varchar(64) DEFAULT NULL COMMENT '所在城市名称',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `CREATE_OPER_ID` varchar(32) DEFAULT NULL COMMENT '创建者',
  `UPDATE_OPER_ID` varchar(32) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `IND1_USER` (`MOBILE`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', '张三', 'e99a18c428cb38d5f260853678922e03', '13584061145', '1001', '北京', '2018-05-19 18:58:30', null, 'admin', null);
INSERT INTO `user` VALUES ('4', '阿炳', '99be496ab9ad1cd2b9910cecf142235a', '13584061123', '1004', '南京', '2018-05-19 19:00:16', null, 'admin', null);
INSERT INTO `user` VALUES ('5', '梅西', '4f0ff3f957afdf29e8de66a45ae5f264', '1778406223', '1001', '北京', '2018-05-19 19:06:07', null, 'admin', null);
INSERT INTO `user` VALUES ('6', '保罗', '4f0ff3f957afdf29e8de66a45ae5f264', '13584061178', '1002', '上海', '2018-05-19 19:08:47', null, 'admin', null);
