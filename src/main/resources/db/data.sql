-- ----------------------------
-- Records of book
-- ----------------------------
DELETE FROM book;

INSERT INTO `book` VALUES (1, '斗破苍穹', '脑残土豆', '玄幻', '起点', '2012-04-06', 20, 1, '无');
INSERT INTO `book` VALUES (2, '武动乾坤', '脑残土豆', '玄幻', '起点', '2012-04-06', 20, 2, '无');
INSERT INTO `book` VALUES (3, '元尊', '脑残土豆', '玄幻', '起点', '2012-04-06', 20, 3, '无');
INSERT INTO `book` VALUES (4, '斗罗大陆', '唐三', '玄幻', '起点', '2012-04-06', 20, 1, '无');
INSERT INTO `book` VALUES (6, '绝世唐门', '唐三', '玄幻', '起点', '2012-04-06', 20, 2, '无');
INSERT INTO `book` VALUES (7, '龙王传说', '唐三', '玄幻', '起点', '2012-04-06', 20, 1, '无');
INSERT INTO `book` VALUES (9, '神墓', '辰东', '玄幻', '起点', '2019-08-14', 23, 1, '无');
INSERT INTO `book` VALUES (10, '盗墓笔记', '南派三叔', '悬疑', '起点', '2019-08-07', 45, 1, '无');
INSERT INTO `book` VALUES (11, '鬼吹灯', '霸唱天下', '悬疑', '起点', '2019-08-07', 45, 1, '无');
INSERT INTO `book` VALUES (12, '图书管理系统源码如何下载运行', '图书管理系统', '互联网IT技术', '数字海南', '2019-09-21', 100, 1, 'szhn.com的图书');

DELETE FROM bmsUser;
DELETE FROM user;
INSERT INTO `user` VALUES (1, 'szhn', 'szhn',1);
INSERT INTO `user` VALUES (2, 'hegx', '123456',2);

DELETE FROM role;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN');
INSERT INTO `role` VALUES (2,'ROLE_USER');

DELETE FROM role_user;
INSERT INTO `role_user` VALUES (1,1);
INSERT INTO `role_user` VALUES (2,2);