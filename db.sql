-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`username` VARCHAR(64) UNIQUE NOT NULL,
		`password` VARCHAR(64) DEFAULT NULL,
		`avatar` VARCHAR(500) DEFAULT NULL COMMENT '头像',
		`email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
		`nickname` VARCHAR(200) DEFAULT NULL COMMENT '昵称',
		`note` VARCHAR(500) DEFAULT NULL COMMENT '备注信息',
		`create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
		`login_time` DATETIME DEFAULT NULL COMMENT '最后登录时间',
		`status` INT(1) DEFAULT 1 COMMENT '账户状态，1正常，0异常',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 密码为qwer1234

INSERT INTO `user` VALUES (1000, 'admin', '$2a$10$gjgGTPEeA7uKN/hrlPtAVeOEMA0u2K27cOS4ZV4upb8bBmOPiXKHu', 'https://tva1.sinaimg.cn/large/0072Vf1pgy1foxkf8h7q7j31hc0u0k55.jpg', '13870869312@163.com', '唐马撸', 'Hello world', '2020-03-23 00:25:08.0', '2020-04-15 15:54:28.0', 1);
INSERT INTO `user` VALUES (1001, 'user', '$2a$10$gjgGTPEeA7uKN/hrlPtAVeOEMA0u2K27cOS4ZV4upb8bBmOPiXKHu', 'https://tva3.sinaimg.cn/large/0072Vf1pgy1foxkfy08umj31kw0w0nng.jpg', '15607942340@163.com', 'pytap', 'Hello world', '2020-03-23 00:25:08.0', '2020-04-15 15:54:28.0', 1);
INSERT INTO `user` VALUES (1002, 'manager', '$2a$10$gjgGTPEeA7uKN/hrlPtAVeOEMA0u2K27cOS4ZV4upb8bBmOPiXKHu', 'http://106.15.200.82/source/1584105924406.jpg', 'ecin520@gmial.com', 'ecin520', 'Hello world', '2020-03-23 00:25:08', '2020-04-15 15:54:28', 1);
INSERT INTO `user` VALUES (1003, 'god', '$2a$10$Fk5R4WpwKcxwkcKPG4mWi.eArJKooA3Bm2pN5kxkVdM1c5VxlcQMG', 'http://106.15.200.82/source/1586595444310.jpg', '123@123.com', 'macos', 'macos', '2020-04-15 14:39:50.634', NULL, 1);
INSERT INTO `user` VALUES (1004, '1234', '$2a$10$shH/cUehmTlfYbHzZ261t.T3J2Mgbpe5RTaCv5pNAsb9tljdWGTb6', 'http://106.15.200.82/source/1586595437749.jpg', 'qwe2', '21', '12', '2020-04-15 14:40:05.066', NULL, 1);
INSERT INTO `user` VALUES (1005, 'ecin520', '$2a$10$c.owgk6b1f33Qpq.Jlz7zOwmXtjtS1EomIWLyHTOlh9BRvVTNoPV2', 'http://106.15.200.82/source/1586595437837.jpg', '936130072@qq.com', 'qq', 'jac', '2020-04-15 14:47:25.79', NULL, 1);
INSERT INTO `user` VALUES (1006, 'EOF', '$2a$10$9nuu1y10825.QGJs1/xFZurcH0SVYlpL7ZdEVworGGOX6ZxPBjeu6', 'http://106.15.200.82/source/1586595057638.jpg', NULL, NULL, NULL, '2020-04-15 14:48:36.845', NULL, 1);

SELECT * FROM `user`;



-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`name` VARCHAR(64) UNIQUE NOT NULL COMMENT '角色名称',
		`description` VARCHAR(500) DEFAULT NULL COMMENT '角色描述',
		`create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='角色表';

INSERT INTO `role` VALUES (1000, 'R_ADMIN', '管理员', '2020-04-15 15:54:28');
INSERT INTO `role` VALUES (1001, 'R_USER', '普通角色', '2020-04-15 15:54:28');
INSERT INTO `role` VALUES (1002, 'R_MANAGER', '项目管理员', '2020-04-15 15:54:28');
INSERT INTO `role` VALUES (1004, 'R_DEVELOPER', '开发人员', '2020-04-18 14:19:32.662');
INSERT INTO `role` VALUES (1005, 'R_TESTER', '测试人员', '2020-04-18 14:21:21.585');

SELECT * FROM `role`;



-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`name` VARCHAR(64) UNIQUE NOT NULL COMMENT '权限名称',
		`description` VARCHAR(500) DEFAULT NULL COMMENT '权限描述',
		`create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='权限表';

INSERT INTO `permission` VALUES(1000, 'P_SUPER', '最高权限', now());

INSERT INTO `permission` VALUES(1001, 'P_NORMAL', '普通权限，基于user的权限', now());

INSERT INTO `permission` VALUES(1002, 'P_MANAGER', '管理权限，项目管理员的权限', now());

SELECT * FROM `permission`;



-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`user_id` BIGINT(20) DEFAULT NULL COMMENT '用户id',
		`role_id` BIGINT(20) DEFAULT NULL COMMENT '角色id',
		`create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

INSERT INTO `user_role` VALUES(1000, 1000, 1000, now());

INSERT INTO `user_role` VALUES(1001, 1000, 1001, now());

INSERT INTO `user_role` VALUES(1002, 1000, 1002, now());

INSERT INTO `user_role` VALUES(1003, 1001, 1001, now());

SELECT * FROM `user_role`;



-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`role_id` BIGINT(20) DEFAULT NULL COMMENT '角色id',
		`permission_id` BIGINT(20) DEFAULT NULL COMMENT '权限id',
		`create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

INSERT INTO `role_permission` VALUES(1000, 1000, 1000, now());

INSERT INTO `role_permission` VALUES(1001, 1001, 1001, now());

SELECT * FROM `role_permission`;



-- ----------------------------
-- Table structure for additional_permission
-- ----------------------------
DROP TABLE IF EXISTS `additional_permission`;
CREATE TABLE `additional_permission`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`name` VARCHAR(64) UNIQUE NOT NULL COMMENT '权限名称',
		`description` VARCHAR(500) DEFAULT NULL COMMENT '权限描述',
		`create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='额外权限表';

INSERT `additional_permission` VALUES(1000, 'AP_USER_1000', '用户1000', NOW());
INSERT `additional_permission` VALUES(1001, 'AP_USER_1001', '用户1001', NOW());
INSERT `additional_permission` VALUES(1002, 'AP_USER_1002', '用户1002', NOW());
INSERT `additional_permission` VALUES(1003, 'AP_USER_1003', '用户1003', NOW());
INSERT `additional_permission` VALUES(1004, 'AP_USER_1004', '用户1004', NOW());
INSERT `additional_permission` VALUES(1005, 'AP_USER_1005', '用户1005', NOW());
INSERT `additional_permission` VALUES(1006, 'AP_USER_1006', '用户1006', NOW());


-- ----------------------------
-- Table structure for user_permission
-- ----------------------------
DROP TABLE IF EXISTS `user_additional_permission`;
CREATE TABLE `user_additional_permission`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`user_id` BIGINT(20) DEFAULT NULL COMMENT '用户id',
		`additional_permission_id` BIGINT(20) DEFAULT NULL COMMENT '权限id',
		`create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='用户额外权限表';

INSERT `user_additional_permission` VALUES(1000, 1000, 1000, NOW());
INSERT `user_additional_permission` VALUES(1001, 1001, 1001, NOW());
INSERT `user_additional_permission` VALUES(1002, 1002, 1002, NOW());
INSERT `user_additional_permission` VALUES(1003, 1003, 1003, NOW());
INSERT `user_additional_permission` VALUES(1004, 1004, 1004, NOW());
INSERT `user_additional_permission` VALUES(1005, 1005, 1005, NOW());
INSERT `user_additional_permission` VALUES(1006, 1006, 1006, NOW());

-- ----------------------------
-- Table structure for web_log
-- ----------------------------
DROP TABLE IF EXISTS `web_log`;
CREATE TABLE `web_log`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`message` VARCHAR(3600) DEFAULT NULL COMMENT '接口描述',
		`username` VARCHAR(300) DEFAULT NULL COMMENT '操作用户',
		`param` VARCHAR(300) DEFAULT NULL COMMENT '传入参数',
		`url` VARCHAR(300) DEFAULT NULL COMMENT 'url',
		`method` VARCHAR(100) DEFAULT NULL COMMENT '操作方法',
		`spend_time` BIGINT(20) DEFAULT NULL COMMENT '消耗时间',
		`ip` VARCHAR(100) DEFAULT NULL COMMENT '操作ip',
		`result` VARCHAR(3600) DEFAULT NULL COMMENT '操作结果',
		`create_time` DATETIME DEFAULT NULL COMMENT '操作时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='web日志';


-- ----------------------------
-- Table structure for error_log
-- ----------------------------
DROP TABLE IF EXISTS `error_log`;
CREATE TABLE `web_log`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`message` VARCHAR(3600) DEFAULT NULL COMMENT '描述',
		`username` VARCHAR(300) DEFAULT NULL COMMENT '操作用户',
		`param` VARCHAR(300) DEFAULT NULL COMMENT '传入参数',
		`url` VARCHAR(300) DEFAULT NULL COMMENT 'url',
		`method` VARCHAR(100) DEFAULT NULL COMMENT '操作方法',
		`ip` VARCHAR(100) DEFAULT NULL COMMENT '操作ip',
		`name` VARCHAR(3600) DEFAULT NULL COMMENT '异常类名',
		`create_time` DATETIME DEFAULT NULL COMMENT '操作时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='error日志';


-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`creater` BIGINT(20) NOT NULL COMMENT '创建者id',
		`image` VARCHAR(500) NOT NULL COMMENT '展示图片',
		`name` VARCHAR(500) NOT NULL COMMENT '项目名称',
		`type` VARCHAR(100) DEFAULT NULL COMMENT '项目类型',
		`explanation` TEXT DEFAULT NULL COMMENT '项目说明',
		`status` SMALLINT DEFAULT NULL COMMENT '项目状态',
		`create_time` DATETIME DEFAULT NULL COMMENT '操作时间',
		PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='项目表';


-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project_type`;
CREATE TABLE `project_type`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`name` VARCHAR(500) NOT NULL COMMENT '类型名称',
		`create_time` DATETIME DEFAULT NULL COMMENT '操作时间',
		PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='项目类型表';

INSERT `project_type` VALUES(1000, '普通项目', NOW());
INSERT `project_type` VALUES(1001, '企业项目', NOW());
INSERT `project_type` VALUES(1002, '个人项目', NOW());
INSERT `project_type` VALUES(1003, '其他项目', NOW());


-- ----------------------------
-- Table structure for project_manager
-- ----------------------------
DROP TABLE IF EXISTS `project_manager`;
CREATE TABLE `project_manager`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`project_id` BIGINT(20) NOT NULL COMMENT '项目id',
		`manager_id` BIGINT(20) NOT NULL COMMENT '管理者id',
		`create_time` DATETIME DEFAULT NULL COMMENT '操作时间',
		PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='项目与管理者关系表';


-- ----------------------------
-- Table structure for project_developer
-- ----------------------------
DROP TABLE IF EXISTS `project_developer`;
CREATE TABLE `project_developer`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`project_id` BIGINT(20) NOT NULL COMMENT '项目id',
		`developer_id` BIGINT(20) NOT NULL COMMENT '开发者id',
		`create_time` DATETIME DEFAULT NULL COMMENT '操作时间',
		PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='项目与开发者关系表';


-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`project_id` BIGINT(20) NOT NULL COMMENT '项目id',
		`executor` BIGINT(20) NOT NULL COMMENT '任务执行者',
		`initiator` BIGINT(20) NOT NULL COMMENT '任务发起人',
		`name` VARCHAR(100) DEFAULT NULL COMMENT '任务名称',
		`type` VARCHAR(100) DEFAULT NULL COMMENT '任务类型',
		`explanation` TEXT DEFAULT NULL COMMENT '任务说明',
		`starting_time` DATETIME DEFAULT NULL COMMENT '开始时间',
		`deadline` DATETIME DEFAULT NULL COMMENT '截至时间',
		`status` SMALLINT DEFAULT NULL COMMENT '任务状态',
		`content` TEXT DEFAULT NULL COMMENT '提交内容',
		`priority` SMALLINT DEFAULT NULL COMMENT '优先级',
		`create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
		PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='任务表';


-- ----------------------------
-- Table structure for task_type
-- ----------------------------
DROP TABLE IF EXISTS `task_type`;
CREATE TABLE `task_type`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`name` VARCHAR(500) NOT NULL COMMENT '类型名称',
		`create_time` DATETIME DEFAULT NULL COMMENT '操作时间',
		PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='任务类型表';

INSERT `task_type` VALUES(1000, '普通任务', NOW());
INSERT `task_type` VALUES(1001, '开发任务', NOW());
INSERT `task_type` VALUES(1002, '测试任务', NOW());
INSERT `task_type` VALUES(1003, '临时任务', NOW());


-- ----------------------------
-- Table structure for project_verification
-- ----------------------------
DROP TABLE IF EXISTS `project_verification`;
CREATE TABLE `project_verification`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`send_id` BIGINT(20) NOT NULL COMMENT '发送id',
		`receive_id` BIGINT(20) NOT NULL COMMENT '接收者id',
		`project_id` BIGINT(20) NOT NULL COMMENT '项目id',
		`type` VARCHAR(500) NOT NULL COMMENT '验证类型 manager or developer',
		`status` SMALLINT DEFAULT NULL COMMENT '验证状态',
		PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='项目人员认证表';


-- ----------------------------
-- Table structure for annex
-- ----------------------------
DROP TABLE IF EXISTS `annex`;
CREATE TABLE `annex`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`name` VARCHAR(500) NOT NULL COMMENT '附件名称',
		`url` VARCHAR(500) NOT NULL COMMENT '附件地址',
		`task_id` BIGINT(20) NOT NULL COMMENT '任务id',
		`create_time` DATETIME DEFAULT NULL COMMENT '操作时间',
		PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='附件表';


