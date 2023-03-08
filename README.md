# MyBatis-Plus-Example

Spring Boot 整合 MyBatis Plus 实例，持续更新！！！

## 代码生成器

[请点击此处的传送门](https://github.com/fengwenyi/mybatis-plus-code-generator)

## 不再维护

作者尽力有限，此项目不再维护，后续会全部迁移到这里

[demo-spring-boot-mybatis-plus](https://github.com/fengwenyi/spring-boot-demo/tree/main/demo-spring-boot-mybatis-plus)

## 三方框架版本总览

| 名称 | 版本 | 更新时间 |
| --- | --- | --- |
| Spring Boot | 2.4.2 |  2021.02.02 |
| MyBatis-Plus | 3.4.2 |  2021.02.02 |
| swagger | 2.9.2 |  2019.08.27 |

## 项目版本标识说明

BUILD
开发版本：用于标识该版本正在构建或者开发中。

SNAPSHOT
预览版本：开发已经完成，开始进入测试阶段。

RELEASE
稳定版本：已发布到中央仓库。

## 数据库设计

### 提示语表-prompts
| 字段 | 类型 | 说明                    |
| --- | --- |-----------------------|
| id | bigint(20) | 主键ID                  |
| prompt | varchar(1024) | 提示语                   |
| create_user_id | varchar(56)  | 创建人ID                  |
| create_user_name | varchar(56)  | 创建人                  |
| prompt_status | int | 0:待识别 1:识别中 2:识别结束 3:识别失败                    |
| prompt_result | text | 识别结果    |
| create_time | datetime | 创建时间                  |
| update_time | datetime | 更新时间                  |

## 常见问题

### 1、LocalDateTime无法使用的问题

#### 描述

用代码生成器生成的时间类型默认为 `LocalDateTime`, 但是在项目中使用报错。今天在项目上遇到了这个问题，什么原因呢？

#### 分析

首先要明确，如果你的项目都和示例项目配置、依赖、版本都一样，那说明本身是没有问题的。肯定是其他问题导致的。

经过排查，项目引入了 `druid`, 版本比较老，所以无法转换导致的。

#### 解决

升级 `druid` 版本
