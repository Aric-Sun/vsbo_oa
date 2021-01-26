/*
 Navicat Premium Data Transfer

 Source Server         : MySQL@localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : vsbo_oa

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 27/01/2021 02:56:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `d_id` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`d_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10010 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (10001, '总经理办公室', '十楼');
INSERT INTO `department` VALUES (10002, '财务部', '九楼');
INSERT INTO `department` VALUES (10003, '研发部', '八楼888');
INSERT INTO `department` VALUES (10008, '销售部', '南京市玄武湖');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `e_id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `d_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`e_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1014 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1001, '202CB962AC59075B964B07152D234B70', '刘备', '总经理', 10001);
INSERT INTO `employee` VALUES (1002, '202CB962AC59075B964B07152D234B70', '孙尚香', '财务', 10002);
INSERT INTO `employee` VALUES (1003, '202CB962AC59075B964B07152D234B70', '关羽', '部门经理', 10003);
INSERT INTO `employee` VALUES (1004, '202CB962AC59075B964B07152D234B70', '程咬金', '员工', 10003);
INSERT INTO `employee` VALUES (1010, '202CB962AC59075B964B07152D234B70', '张飞', '员工', 10003);

-- ----------------------------
-- Table structure for expence_account
-- ----------------------------
DROP TABLE IF EXISTS `expence_account`;
CREATE TABLE `expence_account`  (
  `ea_id` int(11) NOT NULL AUTO_INCREMENT,
  `cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `total_money` double NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creater_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `next_handler_id` int(11) NULL DEFAULT NULL COMMENT '下一个处理者',
  PRIMARY KEY (`ea_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of expence_account
-- ----------------------------
INSERT INTO `expence_account` VALUES (1, '出差报销', '2021-01-11 11:12:48', 246, '已打款', 1004, 0);
INSERT INTO `expence_account` VALUES (2, '团建旅游', '2021-01-11 13:33:42', 633, '已终止', 1004, 0);
INSERT INTO `expence_account` VALUES (3, '部门聚餐', '2021-01-11 13:41:10', 700, '已打款', 1004, 0);
INSERT INTO `expence_account` VALUES (4, '租房协议签署', '2021-01-12 11:33:10', 5055, '已打款', 1004, 0);
INSERT INTO `expence_account` VALUES (5, '出境旅游', '2021-01-12 12:11:02', 10000, '已打款', 1004, 0);
INSERT INTO `expence_account` VALUES (6, '出差报销2', '2021-01-12 12:16:29', 500, '已终止', 1004, 0);
INSERT INTO `expence_account` VALUES (7, '出差报销1', '2021-01-12 14:09:23', 700, '已打款', 1004, 0);
INSERT INTO `expence_account` VALUES (8, '出境旅游', '2021-01-12 14:10:00', 5300, '已打款', 1004, 0);
INSERT INTO `expence_account` VALUES (9, '团建旅游', '2021-01-12 14:10:30', 400, '已打款', 1004, 0);
INSERT INTO `expence_account` VALUES (10, '出差报销4', '2021-01-13 10:28:36', 7500, '已打款', 1004, 0);
INSERT INTO `expence_account` VALUES (11, '公司材料', '2021-01-13 10:29:23', 300, '已提交', 1004, 1003);

-- ----------------------------
-- Table structure for expence_detail
-- ----------------------------
DROP TABLE IF EXISTS `expence_detail`;
CREATE TABLE `expence_detail`  (
  `ed_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` double NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ea_id` int(11) NULL DEFAULT NULL COMMENT '报销单主键',
  PRIMARY KEY (`ed_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of expence_detail
-- ----------------------------
INSERT INTO `expence_detail` VALUES (1, '餐饮', 12, '干饭', 1);
INSERT INTO `expence_detail` VALUES (2, '住宿', 200, '宾馆', 1);
INSERT INTO `expence_detail` VALUES (3, '办公', 34, '文印', 1);
INSERT INTO `expence_detail` VALUES (4, '餐饮', 200, '肿块餐饮', 2);
INSERT INTO `expence_detail` VALUES (5, '住宿', 333, '蛋壳', 2);
INSERT INTO `expence_detail` VALUES (6, '交通', 100, '轻轨', 2);
INSERT INTO `expence_detail` VALUES (7, '餐饮', 500, '多伦多', 3);
INSERT INTO `expence_detail` VALUES (8, '交通', 200, '滴滴', 3);
INSERT INTO `expence_detail` VALUES (9, '住宿', 5000, '定金', 4);
INSERT INTO `expence_detail` VALUES (10, '交通', 55, '滴滴打车', 4);
INSERT INTO `expence_detail` VALUES (11, '交通', 6000, '机票', 5);
INSERT INTO `expence_detail` VALUES (12, '住宿', 4000, '四晚', 5);
INSERT INTO `expence_detail` VALUES (13, '餐饮', 500, '干饭123', 6);
INSERT INTO `expence_detail` VALUES (14, '交通', 500, '机票', 7);
INSERT INTO `expence_detail` VALUES (15, '餐饮', 200, '炒饭', 7);
INSERT INTO `expence_detail` VALUES (16, '办公', 300, '复印', 8);
INSERT INTO `expence_detail` VALUES (17, '交通', 5000, '飞机', 8);
INSERT INTO `expence_detail` VALUES (18, '餐饮', 200, '干饭', 9);
INSERT INTO `expence_detail` VALUES (19, '交通', 200, '滴滴', 9);
INSERT INTO `expence_detail` VALUES (20, '餐饮', 500, '干饭4', 10);
INSERT INTO `expence_detail` VALUES (21, '交通', 2000, '高铁', 10);
INSERT INTO `expence_detail` VALUES (22, '住宿', 5000, '三天四晚', 10);
INSERT INTO `expence_detail` VALUES (23, '办公', 300, '文印', 11);

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `record_time` datetime(0) NULL DEFAULT NULL,
  `record_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `record_result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ea_id` int(11) NULL DEFAULT NULL COMMENT '报销单主键',
  `e_id` int(11) NULL DEFAULT NULL COMMENT '员工主键',
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (1, '2021-01-12 10:00:31', '提交', '已提交', '无', 1, 1004);
INSERT INTO `record` VALUES (2, '2021-01-12 11:33:51', '提交', '已提交', '无', 3, 1004);
INSERT INTO `record` VALUES (3, '2021-01-12 11:33:54', '提交', '已提交', '无', 4, 1004);
INSERT INTO `record` VALUES (4, '2021-01-12 11:33:54', '提交', '已提交', '无', 4, 1004);
INSERT INTO `record` VALUES (5, '2021-01-12 11:50:27', '通过', '已审核', NULL, 3, 1003);
INSERT INTO `record` VALUES (6, '2021-01-12 11:50:35', '打回', '已打回', NULL, 1, 1003);
INSERT INTO `record` VALUES (7, '2021-01-12 11:54:22', '通过', '待复审', NULL, 4, 1003);
INSERT INTO `record` VALUES (8, '2021-01-12 11:55:29', '打款', '已打款', NULL, 3, 1002);
INSERT INTO `record` VALUES (9, '2021-01-12 11:56:01', '通过', '已审核', NULL, 4, 1001);
INSERT INTO `record` VALUES (10, '2021-01-12 11:58:29', '提交', '已提交', '无', 1, 1004);
INSERT INTO `record` VALUES (11, '2021-01-12 11:58:34', '提交', '已提交', '无', 1, 1004);
INSERT INTO `record` VALUES (12, '2021-01-12 12:00:10', '打款', '已打款', NULL, 4, 1002);
INSERT INTO `record` VALUES (13, '2021-01-12 12:11:48', '提交', '已提交', '无', 2, 1004);
INSERT INTO `record` VALUES (14, '2021-01-12 12:11:51', '提交', '已提交', '无', 5, 1004);
INSERT INTO `record` VALUES (15, '2021-01-12 12:16:33', '提交', '已提交', '无', 6, 1004);
INSERT INTO `record` VALUES (16, '2021-01-12 12:17:50', '通过', '已审核', NULL, 1, 1003);
INSERT INTO `record` VALUES (17, '2021-01-12 12:17:55', '打回', '已打回', NULL, 2, 1003);
INSERT INTO `record` VALUES (18, '2021-01-12 12:17:59', '拒绝', '已终止', NULL, 6, 1003);
INSERT INTO `record` VALUES (19, '2021-01-12 12:18:02', '通过', '待复审', NULL, 5, 1003);
INSERT INTO `record` VALUES (20, '2021-01-12 12:19:05', '打款', '已打款', NULL, 1, 1002);
INSERT INTO `record` VALUES (21, '2021-01-12 12:19:36', '通过', '已审核', NULL, 5, 1001);
INSERT INTO `record` VALUES (22, '2021-01-12 14:10:54', '提交', '已提交', '无', 2, 1004);
INSERT INTO `record` VALUES (23, '2021-01-12 14:11:10', '提交', '已提交', '无', 7, 1004);
INSERT INTO `record` VALUES (24, '2021-01-12 14:11:12', '提交', '已提交', '无', 8, 1004);
INSERT INTO `record` VALUES (25, '2021-01-12 14:11:14', '提交', '已提交', '无', 9, 1004);
INSERT INTO `record` VALUES (26, '2021-01-12 14:11:34', '拒绝', '已终止', NULL, 2, 1003);
INSERT INTO `record` VALUES (27, '2021-01-12 14:11:39', '通过', '已审核', NULL, 7, 1003);
INSERT INTO `record` VALUES (28, '2021-01-12 14:11:44', '通过', '待复审', NULL, 8, 1003);
INSERT INTO `record` VALUES (29, '2021-01-12 14:11:54', '打回', '已打回', NULL, 9, 1003);
INSERT INTO `record` VALUES (30, '2021-01-12 14:12:37', '打款', '已打款', NULL, 5, 1002);
INSERT INTO `record` VALUES (31, '2021-01-12 14:12:46', '打款', '已打款', NULL, 7, 1002);
INSERT INTO `record` VALUES (32, '2021-01-12 14:13:23', '打回', '已打回', NULL, 8, 1001);
INSERT INTO `record` VALUES (33, '2021-01-12 14:13:44', '提交', '已提交', '无', 8, 1004);
INSERT INTO `record` VALUES (34, '2021-01-12 14:13:55', '提交', '已提交', '无', 9, 1004);
INSERT INTO `record` VALUES (35, '2021-01-12 14:14:31', '通过', '待复审', NULL, 8, 1003);
INSERT INTO `record` VALUES (36, '2021-01-12 14:14:37', '通过', '已审核', NULL, 9, 1003);
INSERT INTO `record` VALUES (37, '2021-01-12 14:14:44', '打款', '已打款', NULL, 9, 1002);
INSERT INTO `record` VALUES (38, '2021-01-12 14:15:05', '通过', '已审核', NULL, 8, 1001);
INSERT INTO `record` VALUES (39, '2021-01-13 11:40:59', '提交', '已提交', '无', 11, 1004);
INSERT INTO `record` VALUES (40, '2021-01-13 11:41:02', '提交', '已提交', '无', 10, 1004);
INSERT INTO `record` VALUES (41, '2021-01-13 11:41:23', '打回', '已打回', NULL, 11, 1003);
INSERT INTO `record` VALUES (42, '2021-01-13 11:41:30', '通过', '待复审', NULL, 10, 1003);
INSERT INTO `record` VALUES (43, '2021-01-13 11:41:54', '通过', '已审核', NULL, 10, 1001);
INSERT INTO `record` VALUES (44, '2021-01-13 11:42:28', '打款', '已打款', NULL, 8, 1002);
INSERT INTO `record` VALUES (45, '2021-01-13 11:42:33', '打款', '已打款', NULL, 10, 1002);
INSERT INTO `record` VALUES (46, '2021-01-13 11:42:45', '提交', '已提交', '无', 11, 1004);

SET FOREIGN_KEY_CHECKS = 1;
