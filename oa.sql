/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50622
Source Host           : 127.0.0.1:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2020-12-23 17:26:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('10001', '总经理办公室', '十楼');
INSERT INTO `department` VALUES ('10002', '财务部', '九楼');
INSERT INTO `department` VALUES ('10003', '研发部', '八楼888');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `e_id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `ename` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1010 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1001', '11', '刘备', '总经理', '10001');
INSERT INTO `employee` VALUES ('1002', '111111', '孙尚香', '财务', '10002');
INSERT INTO `employee` VALUES ('1003', '111111', '关羽', '部门经理', '10003');
INSERT INTO `employee` VALUES ('1004', '111111', '程咬金', '员工', '10003');

-- ----------------------------
-- Table structure for expence_account
-- ----------------------------
DROP TABLE IF EXISTS `expence_account`;
CREATE TABLE `expence_account` (
  `ea_id` int(11) NOT NULL AUTO_INCREMENT,
  `cause` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `total_money` double DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `creater_id` int(11) DEFAULT NULL COMMENT '创建者id',
  `next_handler_id` int(11) DEFAULT NULL COMMENT '下一个处理者',
  PRIMARY KEY (`ea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expence_account
-- ----------------------------

-- ----------------------------
-- Table structure for expence_detail
-- ----------------------------
DROP TABLE IF EXISTS `expence_detail`;
CREATE TABLE `expence_detail` (
  `ed_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `ea_id` int(11) DEFAULT NULL COMMENT '报销单主键',
  PRIMARY KEY (`ed_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expence_detail
-- ----------------------------

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `record_time` datetime DEFAULT NULL,
  `record_type` varchar(255) DEFAULT NULL,
  `record_result` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `ea_id` int(11) DEFAULT NULL COMMENT '报销单主键',
  `e_id` int(11) DEFAULT NULL COMMENT '员工主键',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
