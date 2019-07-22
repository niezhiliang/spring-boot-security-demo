/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : localhost:3306
 Source Schema         : test-security

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 22/07/2019 19:01:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent` int(11) DEFAULT '0',
  `menuName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `pathUrl` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `perms` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES (1, 0, '用户', NULL, NULL);
INSERT INTO `menu` VALUES (2, 0, '角色', NULL, NULL);
INSERT INTO `menu` VALUES (3, 0, '菜单', NULL, NULL);
INSERT INTO `menu` VALUES (4, 0, '信息', NULL, NULL);
INSERT INTO `menu` VALUES (5, 1, '用户添加', 'user/add', 'user:add');
INSERT INTO `menu` VALUES (6, 1, '用户编辑', 'user/update', 'user:update');
INSERT INTO `menu` VALUES (7, 1, '用户删除', 'user/delete', 'user:delete');
INSERT INTO `menu` VALUES (8, 1, '用户列表', 'user/list', 'user:list');
INSERT INTO `menu` VALUES (9, 2, '角色添加', 'role/add', 'role:add');
INSERT INTO `menu` VALUES (10, 2, '角色编辑', 'role/update', 'role:update');
INSERT INTO `menu` VALUES (11, 2, '角色删除', 'role/delete', 'role:delete');
INSERT INTO `menu` VALUES (12, 2, '角色列表', 'role/list', 'role:list');
INSERT INTO `menu` VALUES (13, 3, '菜单添加', 'menu/add', 'menu:add');
INSERT INTO `menu` VALUES (14, 3, '菜单编辑', 'menu/update', 'menu:update');
INSERT INTO `menu` VALUES (15, 3, '菜单删除', 'menu/delete', 'menu:delete');
INSERT INTO `menu` VALUES (16, 3, '菜单列表', 'menu/list', 'menu:list');
INSERT INTO `menu` VALUES (17, 4, '信息添加', 'msg/add', 'msg:add');
INSERT INTO `menu` VALUES (18, 4, '信息编辑', 'msg/update', 'msg:update');
INSERT INTO `menu` VALUES (19, 4, '信息删除', 'msg/delete', 'msg:delete');
INSERT INTO `menu` VALUES (20, 4, ' 信息列表', 'msg/list', 'msg:list');
COMMIT;

-- ----------------------------
-- Table structure for msg
-- ----------------------------
DROP TABLE IF EXISTS `msg`;
CREATE TABLE `msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msg` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `createAt` datetime DEFAULT NULL,
  `updateAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of msg
-- ----------------------------
BEGIN;
INSERT INTO `msg` VALUES (1, '这是第一条信息', '2019-07-19 16:09:09', '2019-07-19 08:30:34');
INSERT INTO `msg` VALUES (3, '这是第二条信息', '2019-07-19 09:03:58', '2019-07-19 09:03:58');
COMMIT;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `series` varchar(64) COLLATE utf8_bin NOT NULL,
  `token` varchar(64) COLLATE utf8_bin NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
BEGIN;
INSERT INTO `persistent_logins` VALUES ('admin', 'sN7vEZV0AfyHLo7W8L3pSw==', '0oi1GljMCj5G6puZ1fAlcw==', '2019-07-22 09:05:49');
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, 'admin');
INSERT INTO `role` VALUES (2, 'test');
INSERT INTO `role` VALUES (3, 'suyu');
COMMIT;

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rId` int(11) DEFAULT NULL,
  `mId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
BEGIN;
INSERT INTO `role_menu` VALUES (1, 1, 1);
INSERT INTO `role_menu` VALUES (2, 1, 2);
INSERT INTO `role_menu` VALUES (3, 1, 3);
INSERT INTO `role_menu` VALUES (4, 1, 4);
INSERT INTO `role_menu` VALUES (5, 1, 5);
INSERT INTO `role_menu` VALUES (6, 1, 6);
INSERT INTO `role_menu` VALUES (7, 1, 7);
INSERT INTO `role_menu` VALUES (8, 1, 8);
INSERT INTO `role_menu` VALUES (9, 1, 9);
INSERT INTO `role_menu` VALUES (10, 1, 10);
INSERT INTO `role_menu` VALUES (11, 1, 11);
INSERT INTO `role_menu` VALUES (12, 1, 12);
INSERT INTO `role_menu` VALUES (13, 1, 13);
INSERT INTO `role_menu` VALUES (14, 1, 14);
INSERT INTO `role_menu` VALUES (15, 1, 15);
INSERT INTO `role_menu` VALUES (16, 1, 16);
INSERT INTO `role_menu` VALUES (17, 1, 17);
INSERT INTO `role_menu` VALUES (18, 1, 18);
INSERT INTO `role_menu` VALUES (19, 1, 19);
INSERT INTO `role_menu` VALUES (20, 1, 20);
INSERT INTO `role_menu` VALUES (21, 2, 1);
INSERT INTO `role_menu` VALUES (22, 2, 2);
INSERT INTO `role_menu` VALUES (23, 2, 3);
INSERT INTO `role_menu` VALUES (24, 2, 4);
INSERT INTO `role_menu` VALUES (25, 2, 8);
INSERT INTO `role_menu` VALUES (26, 2, 9);
INSERT INTO `role_menu` VALUES (27, 2, 10);
INSERT INTO `role_menu` VALUES (28, 2, 12);
INSERT INTO `role_menu` VALUES (29, 2, 13);
INSERT INTO `role_menu` VALUES (30, 2, 14);
INSERT INTO `role_menu` VALUES (31, 2, 15);
INSERT INTO `role_menu` VALUES (32, 2, 16);
INSERT INTO `role_menu` VALUES (33, 2, 17);
INSERT INTO `role_menu` VALUES (34, 2, 18);
INSERT INTO `role_menu` VALUES (35, 2, 19);
INSERT INTO `role_menu` VALUES (36, 2, 20);
INSERT INTO `role_menu` VALUES (37, 3, 4);
INSERT INTO `role_menu` VALUES (38, 3, 17);
INSERT INTO `role_menu` VALUES (39, 3, 18);
INSERT INTO `role_menu` VALUES (40, 3, 19);
INSERT INTO `role_menu` VALUES (41, 3, 20);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(125) COLLATE utf8_bin DEFAULT NULL,
  `isEnable` int(11) DEFAULT '1',
  `createAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'admin', '$2a$10$GMNPdVzIqkZvuvjlj.Wtvuk0txgL4Zb.lTLJIFQm/rznQGwofDmvu', 1, '2019-07-18 11:13:26');
INSERT INTO `user` VALUES (2, 'test', '$2a$10$GMNPdVzIqkZvuvjlj.Wtvuk0txgL4Zb.lTLJIFQm/rznQGwofDmvu', 2, '2019-07-18 11:13:38');
INSERT INTO `user` VALUES (3, 'suyu', '$2a$10$GMNPdVzIqkZvuvjlj.Wtvuk0txgL4Zb.lTLJIFQm/rznQGwofDmvu', 1, '2019-07-18 11:13:55');
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 2);
INSERT INTO `user_role` VALUES (3, 3, 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
