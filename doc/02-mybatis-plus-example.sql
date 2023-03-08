/*
 Navicat Premium Data Transfer

 Source Server         : localhost.01-192.168.16.128
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 192.168.16.128:3306
 Source Schema         : mybatis-plus-example

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 07/03/2021 18:15:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for prompts
-- ----------------------------
create table if not exists openai.prompts
(
    id               bigint auto_increment
        primary key,
    prompt           varchar(1024)                      not null comment '提示语',
    create_user_id   varchar(56)                        null comment '创建人ID',
    create_user_name varchar(56)                        null comment '创建人',
    prompt_status    int      default 0                 null comment '0:待识别 1:识别中 2:识别结束 3:识别失败',
    prompt_result    text                               null comment '识别结果',
    create_time      datetime default CURRENT_TIMESTAMP not null,
    update_time      datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
);

