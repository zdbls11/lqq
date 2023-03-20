/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 50738
 Source Host           : localhost:3306
 Source Schema         : lqq

 Target Server Type    : MySQL
 Target Server Version : 50738
 File Encoding         : 65001

 Date: 20/03/2023 22:15:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `name` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '体育场馆名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '场馆备注',
  `num` int(11) DEFAULT NULL COMMENT '场馆可用人数',
  `is_enable` int(255) DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '场馆信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES (1, 'xx体育馆', 'xxxxxxx', 8, 1);

-- ----------------------------
-- Table structure for area_icon
-- ----------------------------
DROP TABLE IF EXISTS `area_icon`;
CREATE TABLE `area_icon`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `area_id` bigint(20) NOT NULL COMMENT '场馆id',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '场馆图片路径',
  `sort` tinyint(10) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '场馆图片关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of area_icon
-- ----------------------------
INSERT INTO `area_icon` VALUES (998, 1, 'http：xxxxxsss', 2);
INSERT INTO `area_icon` VALUES (999, 1, 'http：xxxxx', 1);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '预约人id',
  `area_id` bigint(20) DEFAULT NULL COMMENT '场馆id',
  `order_date` datetime(0) DEFAULT NULL COMMENT '预约日期',
  `time` int(11) DEFAULT NULL COMMENT '预约时间段(1-8,早8点开始，晚18点结束，12-14点休息，八个数代表八个以小时为单位的时间段)',
  `num` int(11) DEFAULT NULL COMMENT '预约人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '预约信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (656, 1, 6, '2023-03-21 21:03:15', 2, 6);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '密码',
  `is_enable` int(10) DEFAULT 1 COMMENT '是否启用 0 未启用； 1 启用',
  `role` int(10) DEFAULT 1 COMMENT '角色 0 管理员；1 普通用户',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像文件路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1637814373339774978 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'lwp', '111', 1, 1, '', '', NULL);
INSERT INTO `user` VALUES (2, 'lwpw', '222', 1, 1, '', '', NULL);
INSERT INTO `user` VALUES (132722689, '3', '111', 1, 1, '', '', NULL);
INSERT INTO `user` VALUES (1948856322, '1', '111', 1, 1, '', '', NULL);
INSERT INTO `user` VALUES (1631187379897827329, 'htt', '123', 1, 1, 'tin儿tin儿姐', '12345', NULL);

SET FOREIGN_KEY_CHECKS = 1;
