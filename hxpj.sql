/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : hxpj

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 04/03/2021 15:41:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for compute_em_dailydevicerecord
-- ----------------------------
DROP TABLE IF EXISTS `compute_em_dailydevicerecord`;
CREATE TABLE `compute_em_dailydevicerecord`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `scale` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用量',
  `update_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后更新时间',
  `device` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据源',
  `apartment_id` bigint(20) NULL DEFAULT NULL COMMENT '楼号',
  `room_id` bigint(20) NULL DEFAULT NULL COMMENT '房间号',
  `date_day` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日期',
  `firm_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for compute_em_dailyfirmrecord
-- ----------------------------
DROP TABLE IF EXISTS `compute_em_dailyfirmrecord`;
CREATE TABLE `compute_em_dailyfirmrecord`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `scale` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用量',
  `update_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后更新时间',
  `firm_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `date_day` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for compute_em_monthlydevicerecord
-- ----------------------------
DROP TABLE IF EXISTS `compute_em_monthlydevicerecord`;
CREATE TABLE `compute_em_monthlydevicerecord`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `scale` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用量',
  `update_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后更新时间',
  `device` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据源',
  `apartment_id` bigint(20) NULL DEFAULT NULL COMMENT '楼号',
  `room_id` bigint(20) NULL DEFAULT NULL COMMENT '房间号',
  `date_month` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月份',
  `firm_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for compute_em_monthlyfirmrecord
-- ----------------------------
DROP TABLE IF EXISTS `compute_em_monthlyfirmrecord`;
CREATE TABLE `compute_em_monthlyfirmrecord`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `scale` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用量',
  `update_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后更新时间',
  `firm_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `date_month` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for compute_wm_dailydevicerecord
-- ----------------------------
DROP TABLE IF EXISTS `compute_wm_dailydevicerecord`;
CREATE TABLE `compute_wm_dailydevicerecord`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `scale` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用量',
  `update_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后更新时间',
  `device` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据源',
  `apartment_id` bigint(20) NULL DEFAULT NULL COMMENT '楼号',
  `room_id` bigint(20) NULL DEFAULT NULL COMMENT '房间号',
  `firm_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `date_day` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for compute_wm_dailyfirmrecord
-- ----------------------------
DROP TABLE IF EXISTS `compute_wm_dailyfirmrecord`;
CREATE TABLE `compute_wm_dailyfirmrecord`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `scale` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用量',
  `update_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后更新时间',
  `firm_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `date_day` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for compute_wm_monthlydevicerecord
-- ----------------------------
DROP TABLE IF EXISTS `compute_wm_monthlydevicerecord`;
CREATE TABLE `compute_wm_monthlydevicerecord`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `scale` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用量',
  `update_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后更新时间',
  `device` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据源',
  `apartment_id` bigint(20) NULL DEFAULT NULL COMMENT '楼号',
  `room_id` bigint(20) NULL DEFAULT NULL COMMENT '房间号',
  `date_month` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月份',
  `firm_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for compute_wm_monthlyfirmrecord
-- ----------------------------
DROP TABLE IF EXISTS `compute_wm_monthlyfirmrecord`;
CREATE TABLE `compute_wm_monthlyfirmrecord`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `scale` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用量',
  `update_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后更新时间',
  `firm_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `date_month` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for firm_apartmentroom
-- ----------------------------
DROP TABLE IF EXISTS `firm_apartmentroom`;
CREATE TABLE `firm_apartmentroom`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '中间表Id',
  `apartment_id` bigint(20) NULL DEFAULT NULL,
  `room_id` bigint(20) NULL DEFAULT NULL,
  `firm` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for honeycomb_charging_pile
-- ----------------------------
DROP TABLE IF EXISTS `honeycomb_charging_pile`;
CREATE TABLE `honeycomb_charging_pile`  (
  `device_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备id',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备类型0：电表，1：水表',
  `pid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '未知',
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for honeycomb_cprecord
-- ----------------------------
DROP TABLE IF EXISTS `honeycomb_cprecord`;
CREATE TABLE `honeycomb_cprecord`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '充电桩记录ID',
  `data_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据时间',
  `update_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新时间',
  `scale` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '刻度',
  `device_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for honeycomb_electric_meter
-- ----------------------------
DROP TABLE IF EXISTS `honeycomb_electric_meter`;
CREATE TABLE `honeycomb_electric_meter`  (
  `device_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备ID',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备类型 0：电表1：水表',
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for honeycomb_em_apartmentroom
-- ----------------------------
DROP TABLE IF EXISTS `honeycomb_em_apartmentroom`;
CREATE TABLE `honeycomb_em_apartmentroom`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `apartment_id` bigint(20) NULL DEFAULT NULL COMMENT '楼号',
  `room_id` bigint(20) NULL DEFAULT NULL COMMENT '房间号',
  `device_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for honeycomb_emrecord
-- ----------------------------
DROP TABLE IF EXISTS `honeycomb_emrecord`;
CREATE TABLE `honeycomb_emrecord`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `data_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据时间',
  `update_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新时间',
  `scale` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '刻度',
  `device_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备ID  与Electric_Meter关联',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for honeycomb_eventrecord
-- ----------------------------
DROP TABLE IF EXISTS `honeycomb_eventrecord`;
CREATE TABLE `honeycomb_eventrecord`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `data_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `eventId` bigint(20) NULL DEFAULT NULL COMMENT '事件ID',
  `eventName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事件名称',
  `cid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据项',
  `data` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据内容',
  `device_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据源  与Electric_Meter关联',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for honeycomb_firm_apartmentroom
-- ----------------------------
DROP TABLE IF EXISTS `honeycomb_firm_apartmentroom`;
CREATE TABLE `honeycomb_firm_apartmentroom`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `apartment_id` bigint(20) NULL DEFAULT NULL COMMENT '楼号',
  `room_id` bigint(20) NULL DEFAULT NULL COMMENT '房间号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for honeycomb_firms
-- ----------------------------
DROP TABLE IF EXISTS `honeycomb_firms`;
CREATE TABLE `honeycomb_firms`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `firm` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 104 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for honeycomb_person_apartmentroom
-- ----------------------------
DROP TABLE IF EXISTS `honeycomb_person_apartmentroom`;
CREATE TABLE `honeycomb_person_apartmentroom`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `apartment_id` bigint(20) NULL DEFAULT NULL COMMENT '楼号',
  `room_id` bigint(20) NULL DEFAULT NULL COMMENT '房间号',
  `roomer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住户姓名',
  `phone_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住户联系方式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for honeycomb_water_meter
-- ----------------------------
DROP TABLE IF EXISTS `honeycomb_water_meter`;
CREATE TABLE `honeycomb_water_meter`  (
  `device_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 's设备ID',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0:电表1：水表',
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for honeycomb_wm_apartmentroom
-- ----------------------------
DROP TABLE IF EXISTS `honeycomb_wm_apartmentroom`;
CREATE TABLE `honeycomb_wm_apartmentroom`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `apartment_id` bigint(20) NULL DEFAULT NULL COMMENT '楼号',
  `room_id` bigint(20) NULL DEFAULT NULL COMMENT '房间号',
  `device_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '与Water_Meter关联',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for honeycomb_wmrecord
-- ----------------------------
DROP TABLE IF EXISTS `honeycomb_wmrecord`;
CREATE TABLE `honeycomb_wmrecord`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `data_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scale` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '刻度',
  `device_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '与Water_Meter关联',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_camera
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_camera`;
CREATE TABLE `hxscreen_camera`  (
  `camera_id` bigint(20) NOT NULL COMMENT '摄像头ID',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '摄像头地址',
  PRIMARY KEY (`camera_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_chargerlists
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_chargerlists`;
CREATE TABLE `hxscreen_chargerlists`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pileList1` bigint(20) NULL DEFAULT NULL,
  `pileList2` bigint(20) NULL DEFAULT NULL,
  `pileList3` bigint(20) NULL DEFAULT NULL,
  `pileList4` bigint(20) NULL DEFAULT NULL,
  `pileList5` bigint(20) NULL DEFAULT NULL,
  `pileList6` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_ele_use
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_ele_use`;
CREATE TABLE `hxscreen_ele_use`  (
  `device_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备ID',
  `times` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `building` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `electric` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_ele_yearuse
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_ele_yearuse`;
CREATE TABLE `hxscreen_ele_yearuse`  (
  `device_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `times` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `electric` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `water` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_screen1_1
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_screen1_1`;
CREATE TABLE `hxscreen_screen1_1`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '智能设备情况',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据名称',
  `content` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_screen1_2
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_screen1_2`;
CREATE TABLE `hxscreen_screen1_2`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '收入与入住人数柱形图',
  `months` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月份',
  `incomes` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收入',
  `households` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入住人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_screen2_1
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_screen2_1`;
CREATE TABLE `hxscreen_screen2_1`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '总能耗情况统计表格',
  `times` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `ele_mon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月用电',
  `ele_year` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年用电',
  `water_mon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月用水',
  `water_year` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年用水',
  `content_mon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月综合能耗',
  `content_year` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年综合能耗',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_screen2_2
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_screen2_2`;
CREATE TABLE `hxscreen_screen2_2`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '各大楼能耗饼图',
  `times` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `build1_use` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1号楼耗能',
  `build2_use` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '2号楼耗能',
  `build3_use` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '3号楼耗能',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_screen2_3
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_screen2_3`;
CREATE TABLE `hxscreen_screen2_3`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '近12月耗能柱形图',
  `times` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `water_use` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用水量',
  `ele_use` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用电量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_screen2_4_today
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_screen2_4_today`;
CREATE TABLE `hxscreen_screen2_4_today`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '当天用电量折线图',
  `times` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `today_use` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用电量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_screen2_4_yester
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_screen2_4_yester`;
CREATE TABLE `hxscreen_screen2_4_yester`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '前一天用电量折线图',
  `times` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `yester_use` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用电量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_screen_map
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_screen_map`;
CREATE TABLE `hxscreen_screen_map`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地图显示数据',
  `times` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `build1_use` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1号楼用电量',
  `build2_use` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '2号楼用电量',
  `build3_use` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '3号楼用电量',
  `build1_wateruse` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1号楼用水量',
  `build2_wateruse` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '2号楼用水量',
  `build3_wateruse` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '3号楼用水量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_warninginfo
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_warninginfo`;
CREATE TABLE `hxscreen_warninginfo`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '报警信息',
  `time` datetime(6) NULL DEFAULT NULL COMMENT '时间',
  `device` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `content` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报警内容',
  `status` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否解决',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_water_dailyuse
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_water_dailyuse`;
CREATE TABLE `hxscreen_water_dailyuse`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `update_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `building1_use` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `building2_use` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `building3_use` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_water_monthlyuse
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_water_monthlyuse`;
CREATE TABLE `hxscreen_water_monthlyuse`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `update_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `building1_use` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `building2_use` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `building3_use` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_window1
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_window1`;
CREATE TABLE `hxscreen_window1`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '1号窗口摄像头',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '摄像头地址',
  `camera_id` bigint(20) NULL DEFAULT NULL COMMENT '摄像头IDhxscreen.camera',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_window2
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_window2`;
CREATE TABLE `hxscreen_window2`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '2号窗口摄像头',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '摄像头地址',
  `camera_id` bigint(20) NULL DEFAULT NULL COMMENT 'hxscreen.camera_id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_window3
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_window3`;
CREATE TABLE `hxscreen_window3`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `camera_id_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hxscreen_window4
-- ----------------------------
DROP TABLE IF EXISTS `hxscreen_window4`;
CREATE TABLE `hxscreen_window4`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `camera_id_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for person_scale
-- ----------------------------
DROP TABLE IF EXISTS `person_scale`;
CREATE TABLE `person_scale`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `em_state` bit(1) NULL DEFAULT NULL,
  `wm_state` bit(1) NULL DEFAULT NULL,
  `person_id` bigint(20) NULL DEFAULT NULL COMMENT '住户ID和honey_person_apartment表关联',
  `data_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缴费时间',
  `em_scale` decimal(12, 5) NULL DEFAULT NULL COMMENT '应缴电费',
  `wm_scale` decimal(12, 5) NULL DEFAULT NULL COMMENT '应缴水费',
  `em_paid` decimal(12, 5) NULL DEFAULT NULL COMMENT '已缴电费',
  `wm_paid` decimal(12, 5) NULL DEFAULT NULL COMMENT '已缴水费',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `sys_user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户表ID',
  `sys_user_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `sys_user_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `sys_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `sys_user_phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `sys_user_email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `sys_user_role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户权限1:admin 2:editor 3:visitor',
  PRIMARY KEY (`sys_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for total_em_daily
-- ----------------------------
DROP TABLE IF EXISTS `total_em_daily`;
CREATE TABLE `total_em_daily`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_day` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `data_scale` decimal(12, 5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for total_em_hour
-- ----------------------------
DROP TABLE IF EXISTS `total_em_hour`;
CREATE TABLE `total_em_hour`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_hour` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据时间',
  `data_scale` decimal(12, 5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for total_wm_daily
-- ----------------------------
DROP TABLE IF EXISTS `total_wm_daily`;
CREATE TABLE `total_wm_daily`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_day` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `data_scale` decimal(12, 5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for total_wm_hour
-- ----------------------------
DROP TABLE IF EXISTS `total_wm_hour`;
CREATE TABLE `total_wm_hour`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_hour` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `data_scale` decimal(12, 5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
