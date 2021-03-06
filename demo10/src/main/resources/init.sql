CREATE TABLE `t_permission` (
  `ID` varchar(50) NOT NULL,
  `URL` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `NAME` varchar(64) DEFAULT NULL COMMENT 'url描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO T_PERMISSION VALUES ('1', '/user', 'user:user');
INSERT INTO T_PERMISSION VALUES ('2', '/user/add', 'user:add');
INSERT INTO T_PERMISSION VALUES ('3', '/user/delete', 'user:delete');


CREATE TABLE `t_role` (
  `ID` varchar(50) NOT NULL,
  `NAME` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `MEMO` varchar(32) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO T_ROLE VALUES ('1', 'admin', '超级管理员');
INSERT INTO T_ROLE VALUES ('2', 'test', '测试账户');



CREATE TABLE `t_role_permission` (
  `PID` varchar(50) DEFAULT NULL COMMENT '权限id',
  `RID` varchar(50) DEFAULT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO T_ROLE_PERMISSION VALUES ('1', '2');
INSERT INTO T_ROLE_PERMISSION VALUES ('1', '3');
INSERT INTO T_ROLE_PERMISSION VALUES ('2', '1');
INSERT INTO T_ROLE_PERMISSION VALUES ('1', '1');

CREATE TABLE `t_user` (
  `ID` varchar(50) NOT NULL,
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWD` varchar(50) DEFAULT NULL,
  `CREATE_TIME` date DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO T_USER VALUES ('2', 'tester', '243e29429b340192700677d48c09d992', DATE_FORMAT('2017-12-11 17:20:21', 'YYYY-MM-DD HH:MM:SS'), '1');
INSERT INTO T_USER VALUES ('1', 'mrbird', '42ee25d1e43e9f57119a00d0a39e5250', DATE_FORMAT('2017-12-11 10:52:48', 'YYYY-MM-DD HH:MM:SS'), '1');


CREATE TABLE `t_user_role` (
  `USER_ID` varchar(50) DEFAULT NULL COMMENT '用户id',
  `RID` varchar(50) DEFAULT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO T_USER_ROLE VALUES ('1', '1');
INSERT INTO T_USER_ROLE VALUES ('2', '2');