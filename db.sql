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
		`create_time` VARCHAR(50) DEFAULT NULL COMMENT '创建时间',
		`login_time` VARCHAR(50) DEFAULT NULL COMMENT '最后登录时间',
		`status` INT(1) DEFAULT 1 COMMENT '账户状态，1正常，0异常',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 密码为qwer1234

INSERT INTO `user` VALUES( 1000, 'admin', '$10$OzMEUpm8ZXY4JzhxPFDsEuHs9dJX5ludTtk6bg.xQPPT9lte5KmG2', 'http://106.15.200.82/source/1584105924406.jpg', '13870869312@163.com', '唐马撸', 'Hello world', '2020-03-23 00:25:08', now(), 1 );

INSERT INTO `user` VALUES( 1001, 'user', '$10$OzMEUpm8ZXY4JzhxPFDsEuHs9dJX5ludTtk6bg.xQPPT9lte5KmG2', 'http://106.15.200.82/source/1584105924406.jpg', '15607942340@163.com', 'pytap', 'Hello world', '2020-03-23 00:25:08', now(), 1 );

INSERT INTO `user` VALUES( 1002, 'manager', '$10$OzMEUpm8ZXY4JzhxPFDsEuHs9dJX5ludTtk6bg.xQPPT9lte5KmG2', 'http://106.15.200.82/source/1584105924406.jpg', 'ecin520@gmial.com', 'ecin520', 'Hello world', '2020-03-23 00:25:08', now(), 1 );

SELECT * FROM `user`;



-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`name` VARCHAR(64) UNIQUE NOT NULL COMMENT '角色名称',
		`description` VARCHAR(500) DEFAULT NULL COMMENT '角色描述',
		`create_time` VARCHAR(50) DEFAULT NULL COMMENT '创建时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='角色表';

INSERT INTO `role` VALUES(1000, 'R_ADMIN', '管理员', now());

INSERT INTO `role` VALUES(1001, 'R_USER', '普通角色', now());

INSERT INTO `role` VALUES(1002, 'R_MANAGER', '项目管理员', now());

SELECT * FROM `role`;



-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`name` VARCHAR(64) UNIQUE NOT NULL COMMENT '权限名称',
		`description` VARCHAR(500) DEFAULT NULL COMMENT '权限描述',
		`create_time` VARCHAR(50) DEFAULT NULL COMMENT '创建时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='权限表';

INSERT INTO `permission` VALUES(1000, 'P_SUPER', '最高权限', now());

INSERT INTO `permission` VALUES(1001, 'P_NORMAL', '普通权限，基于user的权限', now());

INSERT INTO `permission` VALUES(1002, 'P_MANAGEMENT', '管理权限，项目管理员的权限', now());

SELECT * FROM `permission`;



-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`user_id` BIGINT(20) DEFAULT NULL COMMENT '用户id',
		`role_id` BIGINT(20) DEFAULT NULL COMMENT '角色id',
		`create_time` VARCHAR(50) DEFAULT NULL COMMENT '创建时间',
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
		`create_time` VARCHAR(50) DEFAULT NULL COMMENT '创建时间',
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
		`create_time` VARCHAR(50) DEFAULT NULL COMMENT '创建时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='额外权限表';

INSERT `additional_permission` VALUES(1000, 'AP_1000', '项目1000', NOW());


-- ----------------------------
-- Table structure for user_permission
-- ----------------------------
DROP TABLE IF EXISTS `user_additional_permission`;
CREATE TABLE `user_additional_permission`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`user_id` BIGINT(20) DEFAULT NULL COMMENT '用户id',
		`additional_permission_id` BIGINT(20) DEFAULT NULL COMMENT '权限id',
		`create_time` VARCHAR(50) DEFAULT NULL COMMENT '创建时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='用户额外权限表';

INSERT `user_additional_permission` VALUES(1000, 1001, 1000, NOW());


DROP TABLE IF EXISTS `web_log`;
CREATE TABLE `web_log`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`description` VARCHAR(3600) DEFAULT NULL COMMENT '接口描述',
		`username` VARCHAR(300) DEFAULT NULL COMMENT '操作用户',
		`method` VARCHAR(100) DEFAULT NULL COMMENT '操作方法',
		`spend_time` BIGINT(20) DEFAULT NULL COMMENT '消耗时间',
		`ip` VARCHAR(100) DEFAULT NULL COMMENT '操作ip',
		`result` VARCHAR(3600) DEFAULT NULL COMMENT '操作结果',
		`create_time` VARCHAR(50) DEFAULT NULL COMMENT '操作时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='web日志';

-- 根据用户id查询拥有权限
SELECT p.`id`, p.`name`, p.`description`, p.`create_time` FROM `permission` p, `role_permission` rp, `role` r WHERE p.`id` = rp.`permission_id` AND r.`id` = rp.`role_id` AND r.`id` IN (SELECT r.`id` FROM `role` r, `user` u, `user_role` ur WHERE r.`id` = ur.`role_id` AND u.`id` = ur.`user_id` AND u.`id` = 1001);

-- 根据用户id查询拥有的额外权限
SELECT ap.`name`, ap.description FROM `user` u, `additional_permission` ap, `user_additional_permission` up WHERE ap.`id` = up.`additional_permission_id` AND u.`id` = up.`user_id` AND u.`id` = 1001;


