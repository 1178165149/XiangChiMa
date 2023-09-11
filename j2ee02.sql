/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : legou_2102

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 24/06/2023 15:09:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for xcm_cart
-- ----------------------------
DROP TABLE IF EXISTS `xcm_cart`;
CREATE TABLE `xcm_cart`  (
  `cid` int(0) NOT NULL AUTO_INCREMENT,
  `uid` int(0) NOT NULL,
  `mid` int(0) NOT NULL,
  `cnt` int(0) NOT NULL,
  `opttime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xcm_cart
-- ----------------------------
INSERT INTO `xcm_cart` VALUES (26, 5, 1, 3, '2023-06-23 13:56:24');
INSERT INTO `xcm_cart` VALUES (27, 5, 4, 1, '2023-06-23 14:24:52');

-- ----------------------------
-- Table structure for xcm_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `xcm_evaluate`;
CREATE TABLE `xcm_evaluate`  (
  `eid` int(0) NOT NULL AUTO_INCREMENT,
  `uid` int(0) NULL DEFAULT NULL,
  `mid` int(0) NULL DEFAULT NULL,
  `evaluate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `evaluate_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`eid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xcm_evaluate
-- ----------------------------
INSERT INTO `xcm_evaluate` VALUES (1, 5, 23, '菜很好吃，干净又卫生', '2023-06-23 14:24:52');

-- ----------------------------
-- Table structure for xcm_meal
-- ----------------------------
DROP TABLE IF EXISTS `xcm_meal`;
CREATE TABLE `xcm_meal`  (
  `mid` int(0) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `shop` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '想吃吗私房菜',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '菜品',
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xcm_meal
-- ----------------------------
INSERT INTO `xcm_meal` VALUES (1, '../img/10001.jpg', 23.00, '特色小吃炸鱼', '想吃吗私房菜', '小吃');
INSERT INTO `xcm_meal` VALUES (2, '../img/10002.jpg', 21.00, '特色小吃蘑菇炒豆角', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (3, '../img/10003.jpg', 12.00, '特色小吃绿豆汤', '想吃吗私房菜', '汤羹');
INSERT INTO `xcm_meal` VALUES (4, '../img/10004.jpg', 15.00, '特色小吃杨梅荔枝冰', '想吃吗私房菜', '饮品');
INSERT INTO `xcm_meal` VALUES (5, '../img/10005.jpg', 15.00, '特色小吃角瓜炒蛋', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (6, '../img/10006.jpg', 50.00, '特色小吃虾仁牛油果沙拉', '想吃吗私房菜', '西餐');
INSERT INTO `xcm_meal` VALUES (7, '../img/10007.jpg', 22.00, '特色小吃青菜肉片汤', '想吃吗私房菜', '汤羹');
INSERT INTO `xcm_meal` VALUES (8, '../img/10008.jpg', 12.00, '特色小吃炒青菜', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (9, '../img/10009.jpg', 45.00, '特色小吃竹笋排骨汤', '想吃吗私房菜', '汤羹');
INSERT INTO `xcm_meal` VALUES (10, '../img/10010.jpg', 32.00, '特色小吃红烧鱼', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (11, '../img/10011.jpg', 50.00, '特色小吃捞汁海鲜', '想吃吗私房菜', '泡酱腌菜');
INSERT INTO `xcm_meal` VALUES (12, '../img/10012.jpg', 30.00, '特色小吃可乐鸡翅', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (13, '../img/10013.jpg', 45.00, '特色小吃排骨玉米汤', '想吃吗私房菜', '汤羹');
INSERT INTO `xcm_meal` VALUES (14, '../img/10014.jpg', 42.00, '特色小吃辣炒牛肉', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (15, '../img/10015.jpg', 13.00, '特色小吃拌豆芽', '想吃吗私房菜', '凉菜');
INSERT INTO `xcm_meal` VALUES (16, '../img/10016.jpg', 26.00, '特色小吃柠檬鸭掌', '想吃吗私房菜', '泡酱腌菜');
INSERT INTO `xcm_meal` VALUES (17, '../img/10017.jpg', 10.00, '特色小吃豆腐脑', '想吃吗私房菜', '小吃');
INSERT INTO `xcm_meal` VALUES (18, '../img/10018.jpg', 28.00, '特色小吃爆炒午餐肉', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (19, '../img/10019.jpg', 18.00, '特色小吃凉面', '想吃吗私房菜', '主食');
INSERT INTO `xcm_meal` VALUES (20, '../img/10020.jpg', 10.00, '特色小吃小米粥', '想吃吗私房菜', '主食');
INSERT INTO `xcm_meal` VALUES (21, '../img/10021.jpg', 15.00, '特色小吃烤香肠', '想吃吗私房菜', '小吃');
INSERT INTO `xcm_meal` VALUES (22, '../img/10022.jpg', 10.00, '特色小吃咸蛋黄粽子', '想吃吗私房菜', '主食');
INSERT INTO `xcm_meal` VALUES (23, '../img/10023.jpg', 30.00, '特色小吃烤牛奶', '想吃吗私房菜', '烘焙');
INSERT INTO `xcm_meal` VALUES (24, '../img/10024.jpg', 38.00, '特色小吃水煮鱼', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (25, '../img/10025.jpg', 25.00, '特色小吃椒盐千层饼', '想吃吗私房菜', '烘焙');
INSERT INTO `xcm_meal` VALUES (26, '../img/10026.jpg', 45.00, '特色小吃水煮肥牛', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (27, '../img/10027.jpg', 28.00, '特色小吃泡椒凤爪', '想吃吗私房菜', '泡酱腌菜');
INSERT INTO `xcm_meal` VALUES (28, '../img/10028.jpg', 10.00, '特色小吃绿豆粥', '想吃吗私房菜', '主食');
INSERT INTO `xcm_meal` VALUES (29, '../img/10029.jpg', 10.00, '特色小吃蒸饺', '想吃吗私房菜', '主食');
INSERT INTO `xcm_meal` VALUES (30, '../img/10030.jpg', 56.00, '悠久历史文化清蒸鲍鱼', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (31, '../img/10031.jpg', 45.00, '悠久历史文化红烧肉', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (32, '../img/10032.jpg', 45.00, '悠久历史文化三杯鸡', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (33, '../img/10033.jpg', 29.00, '悠久历史文化宫保鸡丁', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (34, '../img/10034.jpg', 29.00, '悠久历史文化麻辣香锅', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (35, '../img/10035.jpg', 40.00, '悠久历史文化糖醋排骨', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (36, '../img/10036.jpg', 40.00, '悠久历史文化红烧排骨', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (37, '../img/10037.jpg', 26.00, '悠久历史文化鱼香肉丝', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (38, '../img/10038.jpg', 37.00, '悠久历史文化红烧鸡翅', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (39, '../img/10039.jpg', 28.00, '悠久历史文化麻婆豆腐', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (40, '../img/10040.jpg', 258.00, '悠久历史文化佛跳墙', '想吃吗私房菜', '汤羹');
INSERT INTO `xcm_meal` VALUES (41, '../img/10041.jpg', 60.00, '丰富多样的独特魅力水煮肉片', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (42, '../img/10042.jpg', 56.00, '丰富多样的独特魅力红烧鱼', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (43, '../img/10043.jpg', 35.00, '丰富多样的独特魅力水果沙拉', '想吃吗私房菜', '西餐');
INSERT INTO `xcm_meal` VALUES (44, '../img/10044.jpg', 23.00, '丰富多样的独特魅力番茄炒蛋', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (45, '../img/10045.jpg', 55.00, '丰富多样的独特魅力蛋炒饭', '想吃吗私房菜', '主食');
INSERT INTO `xcm_meal` VALUES (46, '../img/10046.jpg', 11.00, '丰富多样的独特魅力玉米鸡蛋饼', '想吃吗私房菜', '主食');
INSERT INTO `xcm_meal` VALUES (47, '../img/10047.jpg', 31.00, '丰富多样的独特魅力口水鸡', '想吃吗私房菜', '凉菜');
INSERT INTO `xcm_meal` VALUES (48, '../img/10048.jpg', 62.00, '丰富多样的独特魅力爆辣水煮鱼片', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (49, '../img/10049.jpg', 43.00, '丰富多样的独特魅力香菇炖鸡', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (50, '../img/10050.jpg', 44.00, '丰富多样的独特魅力麻辣串串香', '想吃吗私房菜', '凉菜');
INSERT INTO `xcm_meal` VALUES (51, '../img/10051.jpg', 33.00, '特色更是居于世界之巅阿胶糕', '想吃吗私房菜', '小吃');
INSERT INTO `xcm_meal` VALUES (52, '../img/10052.jpg', 30.00, '特色更是居于世界之巅红烧风爪', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (53, '../img/10053.jpg', 55.00, '特色更是居于世界之巅红烧鸡块', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (54, '../img/10054.jpg', 44.00, '特色更是居于世界之巅蒜泥白肉', '想吃吗私房菜', '凉菜');
INSERT INTO `xcm_meal` VALUES (55, '../img/10055.jpg', 59.00, '特色更是居于世界之巅烧排骨', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (56, '../img/10056.jpg', 78.00, '特色更是居于世界之巅凉拌牛肚', '想吃吗私房菜', '凉菜');
INSERT INTO `xcm_meal` VALUES (57, '../img/10057.jpg', 65.00, '特色更是居于世界之巅糖醋排骨', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (58, '../img/10058.jpg', 55.00, '特色更是居于世界之巅柠香时蔬烤鸡腿', '想吃吗私房菜', '西餐');
INSERT INTO `xcm_meal` VALUES (59, '../img/10059.jpg', 66.00, '特色更是居于世界之巅干锅肥肠', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (60, '../img/10060.jpg', 67.00, '特色更是居于世界之巅香辣鱼', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (61, '../img/10061.jpg', 123.00, '充满了异域风采麻辣小龙虾', '想吃吗私房菜', '小吃');
INSERT INTO `xcm_meal` VALUES (62, '../img/10062.jpg', 64.00, '充满了异域风采海鲜粥', '想吃吗私房菜', '主食');
INSERT INTO `xcm_meal` VALUES (63, '../img/10063.jpg', 65.00, '充满了异域风采炒花蛤', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (64, '../img/10064.jpg', 65.00, '充满了异域风采辣炒毛蛤蜊', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (65, '../img/10065.jpg', 96.00, '充满了异域风采剁椒鱼头', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (66, '../img/10066.jpg', 45.00, '充满了异域风采椒盐虾', '想吃吗私房菜', '热菜');
INSERT INTO `xcm_meal` VALUES (67, '../img/10067.jpg', 125.00, '充满了异域风采蒜蓉小龙虾', '想吃吗私房菜', '小吃');
INSERT INTO `xcm_meal` VALUES (70, '../img/78e5bc18-f4b9-4bdf-a528-6635aec67add.jpg', 25.00, '充满了异域风采烧蔗炸酱意面', '想吃吗私房菜', '西餐');
INSERT INTO `xcm_meal` VALUES (71, '../img/2ceaab47-628a-4c7f-b183-141983569005.jpg', 18.00, '充满了异域风采馅饼', '想吃吗私房菜', '主食');

-- ----------------------------
-- Table structure for xcm_notice
-- ----------------------------
DROP TABLE IF EXISTS `xcm_notice`;
CREATE TABLE `xcm_notice`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `content` varchar(2000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `times` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xcm_notice
-- ----------------------------
INSERT INTO `xcm_notice` VALUES (6, '新增菜单《糖醋排骨》', '糖醋排骨超级好吃。再挑食的小朋友都无法拒绝酸甜的口味，吃光排骨，再用糖醋汁拌米饭，今天的饭量见长。', '2023-6-23 13:49:40');
INSERT INTO `xcm_notice` VALUES (7, '本店特色《咸菜肉饭》', '记得小时候每每妈妈做咸肉菜饭，我都要吃上二大碗，那个香啊那个好吃啊，真的不知道怎样来形容。吃过的朋友，大家都懂的，呵呵!11', '2023-6-23 13:53:39');

-- ----------------------------
-- Table structure for xcm_user
-- ----------------------------
DROP TABLE IF EXISTS `xcm_user`;
CREATE TABLE `xcm_user`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `regtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xcm_user
-- ----------------------------
INSERT INTO `xcm_user` VALUES (5, 'UZI', 'Xqcj4rX0acL0fJRu6ZgsAojZoGhbH4cMJvEQWw==', '19908882583', NULL, NULL, NULL, '2023-06-22 15:55:04');

SET FOREIGN_KEY_CHECKS = 1;
