-- ----------------------------
-- Table structure for T_USER
-- ----------------------------
CREATE TABLE `t_user` (
  `ID` varchar(50) NOT NULL,
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWD` varchar(50) DEFAULT NULL,
  `CREATE_TIME` date DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of T_USER
-- ----------------------------
INSERT INTO T_USER VALUES ('2', 'test', '7a38c13ec5e9310aed731de58bbc4214', DATE_FORMAT('2017-11-19 17:20:21','YYYY-MM-DD HH24:MI:SS'), '0');
INSERT INTO T_USER VALUES ('1', 'mrbird', '42ee25d1e43e9f57119a00d0a39e5250', DATE_FORMAT('2017-11-19 10:52:48','YYYY-MM-DD HH24:MI:SS'), '1');
-- ----------------------------
-- Primary Key structure for table T_USER
-- ----------------------------
