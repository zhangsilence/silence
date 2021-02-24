/*
 Navicat Premium Data Transfer

 Source Server         : lemon
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : lemon

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 20/10/2020 15:59:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_age` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_sex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_class` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_desc` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_user` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_user` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_info
-- ----------------------------
INSERT INTO `t_user_info` VALUES (1, 'silence', '25', '1', '7', '最高级别', 'admin', '2020-07-23 00:00:00', '', '2020-08-28 13:43:09');
INSERT INTO `t_user_info` VALUES (2, 'paul', '24', '1', '4', '垃圾', 'admin', '2020-07-23 00:00:00', '', '2020-08-28 13:43:02');
INSERT INTO `t_user_info` VALUES (3, 'kobe', '24', '1', '6', '球星', 'admin', '2020-08-28 13:43:32', '', '2020-08-28 00:00:00');
INSERT INTO `t_user_info` VALUES (4, '郭永胜', '28', '1', '1', '色胚', 'admin', '2020-08-28 13:43:35', '', '2020-08-28 00:00:00');
INSERT INTO `t_user_info` VALUES (5, '李威峙', '26', '1', '1', '渣男', 'admin', '2020-08-28 13:43:39', '', '2020-08-28 00:00:00');
INSERT INTO `t_user_info` VALUES (6, '安丰实', '26', '1', '1', '坑逼', 'admin', '2020-08-28 13:43:42', '', '2020-08-28 00:00:00');
INSERT INTO `t_user_info` VALUES (7, '李海畅', '26', '1', '1', '闷骚', 'admin', '2020-08-28 13:43:45', '', '2020-08-28 00:00:00');
INSERT INTO `t_user_info` VALUES (8, '党红圈', '27', '1', '1', '矫情', 'admin', '2020-08-28 13:43:50', '', '2020-08-28 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : lemon
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : lemon

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 20/10/2020 16:02:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_favorite_dishes
-- ----------------------------
DROP TABLE IF EXISTS `t_favorite_dishes`;
CREATE TABLE `t_favorite_dishes`  (
                                      `food_id` int NOT NULL AUTO_INCREMENT,
                                      `food_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                                      `food_desc` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                                      `food_class` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                                      `create_user` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                                      `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
                                      `update_user` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                                      `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
                                      PRIMARY KEY (`food_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_favorite_dishes
-- ----------------------------
INSERT INTO `t_favorite_dishes` VALUES (1, '荔枝肉', '福州特色菜', '1', 'admin', '2020-09-14 13:28:19', NULL, NULL);
INSERT INTO `t_favorite_dishes` VALUES (2, '糖醋鱼', '哪都有', '1', 'admin', '2020-09-14 13:28:44', NULL, '2020-09-14 13:28:53');

SET FOREIGN_KEY_CHECKS = 1;
