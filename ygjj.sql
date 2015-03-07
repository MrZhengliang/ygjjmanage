/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50508
Source Host           : localhost:3306
Source Database       : ygjj

Target Server Type    : MYSQL
Target Server Version : 50508
File Encoding         : 65001

Date: 2015-03-07 13:38:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `muke_course`
-- ----------------------------
DROP TABLE IF EXISTS `muke_course`;
CREATE TABLE `muke_course` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `create_time` varchar(18) DEFAULT NULL COMMENT '创建时间',
  `img` varchar(255) DEFAULT NULL COMMENT '缩略图',
  `info` varchar(255) DEFAULT NULL COMMENT '简介',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type_id` int(8) NOT NULL COMMENT '课程类型id',
  `sys_user_id` int(8) NOT NULL COMMENT '用户id',
  `video_id` int(8) DEFAULT NULL COMMENT '附件id',
  `status` int(1) NOT NULL COMMENT '状态 0待审核  1已审核  2 已下线 ;默认为0',
  PRIMARY KEY (`id`),
  KEY `FK5014C5F88A5D8984` (`type_id`),
  KEY `FK5014C5F8A83935E6` (`sys_user_id`),
  CONSTRAINT `FK5014C5F88A5D8984` FOREIGN KEY (`type_id`) REFERENCES `muke_course_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of muke_course
-- ----------------------------
INSERT INTO `muke_course` VALUES ('1', '20150204170432', '', '测试1测试1测试1测试1', '测试1', '测试1测试1', '1', '2', null, '0');
INSERT INTO `muke_course` VALUES ('2', '20150205120931', '', 'C语言经典讲解', 'C语言', 'C语言111', '2', '2', null, '0');
INSERT INTO `muke_course` VALUES ('3', '20150205120952', '', 'html实战训练100案例', 'html实战', 'html实战', '3', '2', null, '0');

-- ----------------------------
-- Table structure for `muke_course_type`
-- ----------------------------
DROP TABLE IF EXISTS `muke_course_type`;
CREATE TABLE `muke_course_type` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of muke_course_type
-- ----------------------------
INSERT INTO `muke_course_type` VALUES ('1', 'JAVA', '3', 'java经典教材', null);
INSERT INTO `muke_course_type` VALUES ('2', 'C', '5', 'C语言编程', null);
INSERT INTO `muke_course_type` VALUES ('3', 'html', '2', 'html语法讲解', null);
INSERT INTO `muke_course_type` VALUES ('4', 'css', '6', 'css编程技巧', null);

-- ----------------------------
-- Table structure for `t_oa_acard`
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_acard`;
CREATE TABLE `t_oa_acard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `buy_date` varchar(18) DEFAULT NULL COMMENT '购买日期',
  `pack_date` varchar(100) DEFAULT NULL COMMENT '套餐日期',
  `master_card` varchar(50) DEFAULT NULL COMMENT '主卡  由数字和字母组成，长度不超过10位',
  `username` varchar(50) DEFAULT NULL COMMENT '5）	用户名--字母组成，不超过20',
  `terminal_id` varchar(11) DEFAULT NULL COMMENT '手机号------------数字组成，不超过12位',
  `usetime_limit` int(1) DEFAULT NULL COMMENT '1 长期｜2 短期',
  `amount` double(8,2) DEFAULT NULL COMMENT '充值金额',
  `taobao_id` varchar(40) DEFAULT NULL COMMENT '淘宝ID',
  `weixin_nickname` varchar(40) DEFAULT NULL COMMENT '微信昵称',
  `weixin_code` varchar(40) DEFAULT NULL COMMENT '微信号',
  `deliver_code` varchar(25) DEFAULT NULL COMMENT '快递单号',
  `remark` text COMMENT '13）	备注',
  `operate_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_oa_acard
-- ----------------------------

-- ----------------------------
-- Table structure for `t_oa_bcard`
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_bcard`;
CREATE TABLE `t_oa_bcard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `buy_date` varchar(18) DEFAULT NULL COMMENT '购买日期',
  `pack_date` varchar(100) DEFAULT NULL COMMENT '套餐日期',
  `master_card` varchar(50) DEFAULT NULL COMMENT '主卡  由数字和字母组成，长度不超过10位',
  `username` varchar(50) DEFAULT NULL COMMENT '5）	用户名--字母组成，不超过20',
  `terminal_id` varchar(11) DEFAULT NULL COMMENT '手机号------------数字组成，不超过12位',
  `usetime_limit` int(1) DEFAULT NULL COMMENT '1 长期｜2 短期',
  `amount` double(8,2) DEFAULT NULL COMMENT '充值金额',
  `taobao_id` varchar(40) DEFAULT NULL COMMENT '淘宝ID',
  `weixin_nickname` varchar(40) DEFAULT NULL COMMENT '微信昵称',
  `weixin_code` varchar(40) DEFAULT NULL COMMENT '微信号',
  `deliver_code` varchar(25) DEFAULT NULL COMMENT '快递单号',
  `remark` text COMMENT '13）	备注',
  `operate_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_oa_bcard
-- ----------------------------

-- ----------------------------
-- Table structure for `t_oa_ccard`
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_ccard`;
CREATE TABLE `t_oa_ccard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `buy_date` varchar(18) DEFAULT NULL COMMENT '购买日期',
  `pack_date` varchar(100) DEFAULT NULL COMMENT '套餐日期',
  `master_card` varchar(50) DEFAULT NULL COMMENT '主卡  由数字和字母组成，长度不超过10位',
  `username` varchar(50) DEFAULT NULL COMMENT '5）	用户名--字母组成，不超过20',
  `terminal_id` varchar(11) DEFAULT NULL COMMENT '手机号------------数字组成，不超过12位',
  `usetime_limit` int(1) DEFAULT NULL COMMENT '1 长期｜2 短期',
  `amount` double(8,2) DEFAULT NULL COMMENT '充值金额',
  `taobao_id` varchar(40) DEFAULT NULL COMMENT '淘宝ID',
  `weixin_nickname` varchar(40) DEFAULT NULL COMMENT '微信昵称',
  `weixin_code` varchar(40) DEFAULT NULL COMMENT '微信号',
  `deliver_code` varchar(25) DEFAULT NULL COMMENT '快递单号',
  `remark` text COMMENT '13）	备注',
  `operate_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_oa_ccard
-- ----------------------------

-- ----------------------------
-- Table structure for `t_oa_dcard`
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_dcard`;
CREATE TABLE `t_oa_dcard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `buy_date` varchar(18) DEFAULT NULL COMMENT '购买日期',
  `pack_date` varchar(100) DEFAULT NULL COMMENT '套餐日期',
  `master_card` varchar(50) DEFAULT NULL COMMENT '主卡  由数字和字母组成，长度不超过10位',
  `username` varchar(50) DEFAULT NULL COMMENT '5）	用户名--字母组成，不超过20',
  `terminal_id` varchar(11) DEFAULT NULL COMMENT '手机号------------数字组成，不超过12位',
  `usetime_limit` int(1) DEFAULT NULL COMMENT '1 长期｜2 短期',
  `amount` double(8,2) DEFAULT NULL COMMENT '充值金额',
  `taobao_id` varchar(40) DEFAULT NULL COMMENT '淘宝ID',
  `weixin_nickname` varchar(40) DEFAULT NULL COMMENT '微信昵称',
  `weixin_code` varchar(40) DEFAULT NULL COMMENT '微信号',
  `deliver_code` varchar(25) DEFAULT NULL COMMENT '快递单号',
  `remark` text COMMENT '13）	备注',
  `operate_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_oa_dcard
-- ----------------------------

-- ----------------------------
-- Table structure for `t_oa_ecard`
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_ecard`;
CREATE TABLE `t_oa_ecard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `buy_date` varchar(18) DEFAULT NULL COMMENT '购买日期',
  `pack_date` varchar(100) DEFAULT NULL COMMENT '套餐日期',
  `master_card` varchar(50) DEFAULT NULL COMMENT '主卡  由数字和字母组成，长度不超过10位',
  `username` varchar(50) DEFAULT NULL COMMENT '5）	用户名--字母组成，不超过20',
  `terminal_id` varchar(11) DEFAULT NULL COMMENT '手机号------------数字组成，不超过12位',
  `usetime_limit` int(1) DEFAULT NULL COMMENT '1 长期｜2 短期',
  `amount` double(8,2) DEFAULT NULL COMMENT '充值金额',
  `taobao_id` varchar(40) DEFAULT NULL COMMENT '淘宝ID',
  `weixin_nickname` varchar(40) DEFAULT NULL COMMENT '微信昵称',
  `weixin_code` varchar(40) DEFAULT NULL COMMENT '微信号',
  `deliver_code` varchar(25) DEFAULT NULL COMMENT '快递单号',
  `remark` text COMMENT '13）	备注',
  `operate_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_oa_ecard
-- ----------------------------

-- ----------------------------
-- Table structure for `t_oa_giffgaff`
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_giffgaff`;
CREATE TABLE `t_oa_giffgaff` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `buy_date` varchar(18) DEFAULT NULL COMMENT '购买日期',
  `pack_date` varchar(100) DEFAULT NULL COMMENT '套餐日期',
  `master_card` varchar(50) DEFAULT NULL COMMENT '主卡  由数字和字母组成，长度不超过10位',
  `sliver_card` varchar(50) DEFAULT NULL COMMENT '备用卡',
  `username` varchar(50) DEFAULT NULL COMMENT '5）	用户名--字母组成，不超过20',
  `terminal_id` varchar(11) DEFAULT NULL COMMENT '手机号------------数字组成，不超过12位',
  `usetime_limit` int(1) DEFAULT NULL COMMENT '1 长期｜2 短期',
  `amount` double(8,2) DEFAULT NULL COMMENT '充值金额',
  `taobao_id` varchar(40) DEFAULT NULL COMMENT '淘宝ID',
  `weixin_nickname` varchar(40) DEFAULT NULL COMMENT '微信昵称',
  `weixin_code` varchar(40) DEFAULT NULL COMMENT '微信号',
  `deliver_code` varchar(25) DEFAULT NULL COMMENT '快递单号',
  `remark` text COMMENT '13）	备注',
  `operate_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_oa_giffgaff
-- ----------------------------
INSERT INTO `t_oa_giffgaff` VALUES ('1', '20150306', '20151231', 'AA312213', 'CA2131323', 'bruce', '15011112222', '1', '50.00', 'tbx221', '微信001', 'wx001', '11554111111', '测试测试', '2');
INSERT INTO `t_oa_giffgaff` VALUES ('2', '', '', '', '', '测试', '', null, '100.00', 'tb12', null, 'wx12', '', '测试测试测试测试测试测试测试测试测试测试测试测试', '2');
INSERT INTO `t_oa_giffgaff` VALUES ('3', '20150307', '20151231', 'AA0003', 'AA-000322', '李航', '13544441222', null, '60.00', 'tb003', null, 'wx003', '0122321333', '从大处说', '2');
INSERT INTO `t_oa_giffgaff` VALUES ('4', '20150309', '20151231', 'jhm1', 'jhm--1', '遇见', '13866542224', null, '66.00', 'tb005', null, '微信s', 'e21321313213', '啊第三次的第三次撒啊层次的 阿德vdsvdsva ', '2');
INSERT INTO `t_oa_giffgaff` VALUES ('5', '20150307', '20151119', 'jihuo222', 'jihuobeika-222', '小明', '13855131166', null, '55.00', 'ff-123', null, 'ww12231', 'sdd2132321312', '今天maid速度速度萨斯的第三方啊大幅放大岁的萨法 ', '18');
INSERT INTO `t_oa_giffgaff` VALUES ('6', '20150307', '20151226', '测试 002', '测试备卡002', '力宏', '15844442222', null, '55.00', 'tb003', null, 'wx003', 'dsaf213213', '测试爱读书测试爱读书测试爱读书', '18');

-- ----------------------------
-- Table structure for `t_oa_setcar`
-- ----------------------------
DROP TABLE IF EXISTS `t_oa_setcar`;
CREATE TABLE `t_oa_setcar` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `target_date` varchar(18) DEFAULT NULL COMMENT '预定日期--------默认为当天',
  `usecar_date` varchar(18) DEFAULT NULL COMMENT '用车日期------- 默认为空',
  `flight_number` varchar(255) DEFAULT NULL COMMENT '航班号-----------数字和字母，不超过20个',
  `use_type` int(1) DEFAULT NULL COMMENT '下拉项：1 接/2送/3旅游/4包车',
  `customer_name` varchar(50) DEFAULT NULL COMMENT '客人名字',
  `people_number` int(8) DEFAULT NULL COMMENT '人数',
  `telephone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `dest_address` varchar(100) DEFAULT NULL COMMENT '目的地地址',
  `taobao_id` varchar(40) DEFAULT NULL COMMENT '淘宝ID',
  `weixin_code` varchar(40) DEFAULT NULL COMMENT '11）	微信',
  `qq_code` varchar(40) DEFAULT NULL,
  `car_type` varchar(40) DEFAULT NULL COMMENT '所需车型',
  `pick_people` varchar(50) DEFAULT NULL COMMENT '接机人',
  `mem_code` varchar(100) DEFAULT NULL COMMENT '会员编号',
  `total_price` double(8,2) DEFAULT NULL COMMENT '总价',
  `china_pay` double(8,2) DEFAULT NULL,
  `uk_driver_pay` double(8,2) DEFAULT NULL,
  `giffgaff` int(2) DEFAULT NULL,
  `is_smoke` int(1) DEFAULT NULL COMMENT '是否带烟  1是  2否 ',
  `is_send_uk` int(1) DEFAULT NULL COMMENT '是否已发送英国',
  `send_date` varchar(18) DEFAULT NULL COMMENT '发送日期',
  `remark` text COMMENT '备注',
  `operate_id` int(8) DEFAULT NULL COMMENT '操作员id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_oa_setcar
-- ----------------------------
INSERT INTO `t_oa_setcar` VALUES ('1', '20150305', '20150311', 'NH771', '1', '力宏', '23', '13815612255', '英国伦敦大笨钟', 'ff123', 'feixiang123', null, '2', 'James', null, '160.00', '80.00', '80.00', '3', '2', '1', '20150312', '测试测试', '1');
INSERT INTO `t_oa_setcar` VALUES ('4', '20150307024659', '20150320', 'Ca11', '3', '测试1', '2', '15011112222', null, 'tb01', 'wx01', '111111222', null, '接人1', '测试001', '0.00', '0.00', '0.00', null, null, null, '', '测试1测试1测试1', '2');
INSERT INTO `t_oa_setcar` VALUES ('5', '20150307025133', '20150326', 'CHINA1', '4', '测试的', '1', '13511115555', null, '天天', 'wx5', '21223445', null, 'lucy', '会员1 ', '0.00', '0.00', '0.00', null, null, null, '', '测试的', '2');
INSERT INTO `t_oa_setcar` VALUES ('6', '20150307025233', '20150315', 'CH33', '1', 'ces', '1', '13810112222', null, 'tb11', '微信通', '5567887', null, 'Goden', 'huiyuan', '0.00', '0.00', '0.00', null, null, null, '', 'ces', '2');
INSERT INTO `t_oa_setcar` VALUES ('7', '20150307025339', '20150316', 'UK2', '1', '李刚', '1', '17655112222', null, '淘宝啊', '微信11', '786533322', null, '接机人3', '搜索', '0.00', '0.00', '0.00', null, null, null, '', '测试  测试测试  测试测试  测试测试  测试测试  测试测试  测试测试  测试测试  测试测试  测试测试  测试测试  测试测试  测试测试  测试测试  测试测试  测试', '2');
INSERT INTO `t_oa_setcar` VALUES ('8', '20150307025519', '20150309', 'CH9', '2', '星仔', '1', '15611234567', null, 'jj21', 'wx121', '94994928', null, 'booker', '会员0002', '0.00', '0.00', '0.00', null, null, null, '', '编程语言之Swift的崛起！\r\n\r\n虽然现下Swift几经修改，语法依然不稳定，但其表现却非常强劲。VisionMobile开发语言排行显示，Swift在发布仅四个月后，便已迅速俘获了20%的移动应用开发者的“芳心”，而Google的Go语言却并未能跻身TOP榜，在发布超过五年后，却只占5%的心理份额比，着实惨淡。\r\n此外，有23%的Swift新手并没有使用Objective-C，这也就意味着，Swift为苹果的iOS生态圈出了不少力，成功地吸引了更多的开发者来构建原生的iOS应用。', '2');

-- ----------------------------
-- Table structure for `t_sh_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_sh_user`;
CREATE TABLE `t_sh_user` (
  `auid` int(8) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `terminal_id` varchar(20) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `group_id` varchar(8) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `start_date` varchar(20) DEFAULT NULL,
  `end_date` varchar(20) DEFAULT NULL,
  `last_login_ip` varchar(100) DEFAULT NULL,
  `groupName` varchar(255) DEFAULT NULL,
  `limit_year` int(3) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`auid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sh_user
-- ----------------------------
INSERT INTO `t_sh_user` VALUES ('1', '981233589@qq.com', '啥的', '123', '13511112222', '测试1', '6', '1', '20141120', '20141231', '128.0.0.1', null, null, null);
INSERT INTO `t_sh_user` VALUES ('2', '981233589@qq.com', '小k', '123', '13866553333', 'u007', '6', '1', '20141120', '20141231', '127.0.0.1', null, null, null);
INSERT INTO `t_sh_user` VALUES ('5', '222111@163.com', 'TT', '123', '18677729388', 'au7', '9', '1', '20140521', '20141230', '128.0.2.5', null, null, null);
INSERT INTO `t_sh_user` VALUES ('8', '二恶额@qq.com', '测试2', '123', '13855554444', '测试2', '6', '1', '2014-11-01', '2014-12-31', null, null, '3', '测试第二个');
INSERT INTO `t_sh_user` VALUES ('9', '1@11.com', '', '', '13811112222', '', '0', '9', '', '', null, null, null, '');
INSERT INTO `t_sh_user` VALUES ('10', '123123@123.com', '刚刚', '', '15010001000', '小刚', '8', '1', '20140520', '20141231', null, null, '5', '测试');
INSERT INTO `t_sh_user` VALUES ('11', '', '刚刚', '', '', '', '8', '9', '20140520', '20141231', null, null, null, '');
INSERT INTO `t_sh_user` VALUES ('12', '130@139.com', '初级的', '123', '13011112222', '测试ceshi', '6', '1', '20141201', '20141231', null, null, '3', '测试ceshi');

-- ----------------------------
-- Table structure for `t_sys_attachment`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_attachment`;
CREATE TABLE `t_sys_attachment` (
  `aid` mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '附件id',
  `type` tinyint(2) DEFAULT NULL COMMENT '附件类型  1头像图片 2大图 3 文件  4  音乐  5  视频',
  `uid` mediumint(8) DEFAULT NULL COMMENT '会员id；添加人员id',
  `downloads` mediumint(8) DEFAULT NULL COMMENT '下载次数',
  `filename` varchar(100) DEFAULT NULL COMMENT '文件原名称',
  `newfilename` varchar(100) DEFAULT NULL COMMENT '上传的文件新名称',
  `filepath` varchar(100) DEFAULT NULL COMMENT '文件保存路径',
  `uploadtime` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8 COMMENT='附件信息表';

-- ----------------------------
-- Records of t_sys_attachment
-- ----------------------------
INSERT INTO `t_sys_attachment` VALUES ('66', '1', '2', null, 'Desert.jpg', 'Desert.jpg', '/splatform-s3h4-m/res/Desert.jpg', '2015-02-04 12:37:57');
INSERT INTO `t_sys_attachment` VALUES ('67', '1', '2', null, 'Hydrangeas.jpg', 'Hydrangeas.jpg', '/splatform-s3h4-m/res/Hydrangeas.jpg', '2015-02-04 12:40:00');
INSERT INTO `t_sys_attachment` VALUES ('68', '1', '2', null, 'Chrysanthemum.jpg', 'Chrysanthemum.jpg', '/splatform-s3h4-m/res/Chrysanthemum.jpg', '2015-02-04 12:41:53');
INSERT INTO `t_sys_attachment` VALUES ('69', '1', '2', null, '519b59626b555.jpg', '519b59626b555.jpg', '/splatform-s3h4-m/res/519b59626b555.jpg', '2015-02-04 12:44:15');
INSERT INTO `t_sys_attachment` VALUES ('70', '1', '2', null, '491738.jpg', '491738.jpg', '/splatform-s3h4-m/res/491738.jpg', '2015-02-04 12:44:54');
INSERT INTO `t_sys_attachment` VALUES ('71', '1', '2', null, '11223133_095309330335_2.jpg', '11223133_095309330335_2.jpg', '/splatform-s3h4-m/res/11223133_095309330335_2.jpg', '2015-02-04 12:49:23');
INSERT INTO `t_sys_attachment` VALUES ('72', '1', '2', null, '519b59626b555.jpg', '519b59626b555.jpg', '/splatform-s3h4-m/res/519b59626b555.jpg', '2015-02-04 14:17:26');
INSERT INTO `t_sys_attachment` VALUES ('73', '1', '2', null, '491738.jpg', '491738.jpg', '/splatform-s3h4-m/res/491738.jpg', '2015-02-04 14:47:47');
INSERT INTO `t_sys_attachment` VALUES ('74', '1', '2', null, '519b59626b555.jpg', '519b59626b555.jpg', '/splatform-s3h4-m/res/519b59626b555.jpg', '2015-02-04 15:02:46');
INSERT INTO `t_sys_attachment` VALUES ('75', '1', '2', null, '491738.jpg', '491738.jpg', '/splatform-s3h4-m/res/491738.jpg', '2015-02-04 15:05:37');
INSERT INTO `t_sys_attachment` VALUES ('76', '1', '2', null, '519b59626b555.jpg', '519b59626b555.jpg', '/splatform-s3h4-m/res/519b59626b555.jpg', '2015-02-04 15:07:37');
INSERT INTO `t_sys_attachment` VALUES ('77', '1', '2', null, '491738.jpg', '491738.jpg', '/splatform-s3h4-m/res/491738.jpg', '2015-02-04 15:13:40');
INSERT INTO `t_sys_attachment` VALUES ('78', '1', '2', null, '11223133_095309330335_2.jpg', '11223133_095309330335_2.jpg', '/splatform-s3h4-m/res/11223133_095309330335_2.jpg', '2015-02-04 15:14:58');
INSERT INTO `t_sys_attachment` VALUES ('79', '1', '2', null, 'QQ图片20141118083214.jpg', 'QQ图片20141118083214.jpg', '/splatform-s3h4-m/res/QQ图片20141118083214.jpg', '2015-02-04 15:15:10');
INSERT INTO `t_sys_attachment` VALUES ('80', '1', '2', null, 'QQ20141118083214.jpg', 'QQ20141118083214.jpg', '/splatform-s3h4-m/res/QQ20141118083214.jpg', '2015-02-04 15:15:40');
INSERT INTO `t_sys_attachment` VALUES ('81', '1', null, null, '11223133_095309330335_2.jpg', '11223133_095309330335_2.jpg', '/splatform-s3h4-m/res/11223133_095309330335_2.jpg', '2015-02-04 16:16:23');
INSERT INTO `t_sys_attachment` VALUES ('82', '1', '2', null, '11223133_095309330335_2.jpg', '11223133_095309330335_2.jpg', '/splatform-s3h4-m/res/11223133_095309330335_2.jpg', '2015-02-04 16:18:43');
INSERT INTO `t_sys_attachment` VALUES ('83', '5', '2', null, 'Wildlife.wmv', 'Wildlife.wmv', '/splatform-s3h4-m/res/Wildlife.wmv', '2015-02-04 16:40:52');
INSERT INTO `t_sys_attachment` VALUES ('84', '5', '2', null, 'Wildlife.wmv', 'Wildlife.wmv', '/splatform-s3h4-m/res/Wildlife.wmv', '2015-02-04 16:50:45');
INSERT INTO `t_sys_attachment` VALUES ('85', '1', '13', null, '519b59626b555.jpg', '519b59626b555.jpg', '/splatform-s3h4-m/res/519b59626b555.jpg', '2015-03-06 16:52:07');
INSERT INTO `t_sys_attachment` VALUES ('86', '1', '13', null, 'Lighthouse.jpg', 'Lighthouse.jpg', '/splatform-s3h4-m/res/Lighthouse.jpg', '2015-03-06 16:55:12');
INSERT INTO `t_sys_attachment` VALUES ('87', '1', '17', null, 'Penguins.jpg', 'Penguins.jpg', '/splatform-s3h4-m/res/Penguins.jpg', '2015-03-06 17:31:34');

-- ----------------------------
-- Table structure for `t_sys_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dictionary`;
CREATE TABLE `t_sys_dictionary` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `dic_name` varchar(50) DEFAULT NULL,
  `dic_info` varchar(255) DEFAULT NULL,
  `parent_id` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_group`;
CREATE TABLE `t_sys_group` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(18) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  `group_desc` varchar(50) DEFAULT NULL,
  `menu_btn` varchar(30) DEFAULT NULL,
  `menu_code` varchar(14) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_sys_group
-- ----------------------------
INSERT INTO `t_sys_group` VALUES ('1', '系统管理组2', '20150131204906', '测试的', null, null, null);
INSERT INTO `t_sys_group` VALUES ('2', '客服A组', '20150307130611', '客服A组的111', null, null, null);
INSERT INTO `t_sys_group` VALUES ('3', '客服B组', '20150201035924', '客服B组', null, null, null);

-- ----------------------------
-- Table structure for `t_sys_group_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_group_role`;
CREATE TABLE `t_sys_group_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `group_id` int(8) DEFAULT NULL,
  `role_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAD532673105BF75B` (`group_id`),
  KEY `FKAD5326738330C7D9` (`role_id`),
  CONSTRAINT `FKAD532673105BF75B` FOREIGN KEY (`group_id`) REFERENCES `t_sys_group` (`id`),
  CONSTRAINT `FKAD5326738330C7D9` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_group_role
-- ----------------------------
INSERT INTO `t_sys_group_role` VALUES ('94', '2', '33');

-- ----------------------------
-- Table structure for `t_sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(20) DEFAULT NULL,
  `menu_code` varchar(20) DEFAULT NULL,
  `menu_pid` int(8) DEFAULT NULL,
  `menu_url` varchar(50) DEFAULT NULL,
  `leaf_yn` int(1) DEFAULT NULL,
  `menu_btns` varchar(50) DEFAULT NULL,
  `icon_tag` varchar(20) DEFAULT NULL,
  `has_child` tinyint(1) DEFAULT NULL COMMENT '是否有子菜单,1有  0没有',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_menu
-- ----------------------------
INSERT INTO `t_sys_menu` VALUES ('2', '系统管理', 'sys_menu', '0', '', '0', '', 'icon-tasks', '1');
INSERT INTO `t_sys_menu` VALUES ('4', '组织管理', 'group_menu', '2', 'gmanage.do', '1', 'add_btn,edit_btn,del_btn,audit_btn', null, '0');
INSERT INTO `t_sys_menu` VALUES ('5', '角色管理', 'role_menu', '2', 'romanage.do', '1', 'add_btn,edit_btn,del_btn,audit_btn', null, '0');
INSERT INTO `t_sys_menu` VALUES ('6', '用户管理', 'user_menu', '2', 'umanage.do', '1', 'add_btn,edit_btn,del_btn,audit_btn', null, '0');
INSERT INTO `t_sys_menu` VALUES ('8', '客服管理', 'oakf_menu', '0', '', '0', null, 'icon-table', '1');
INSERT INTO `t_sys_menu` VALUES ('9', '定车记录', 'kf_menu', '8', 'oakfmanage.do', '1', null, null, '0');
INSERT INTO `t_sys_menu` VALUES ('10', '激活码管理', 'jhm_menu', '8', 'oajhmmanage.do', '1', null, '', '0');
INSERT INTO `t_sys_menu` VALUES ('11', 'A卡记录', 'acard_menu', '8', 'oaacardmanage.do', '1', null, null, '0');
INSERT INTO `t_sys_menu` VALUES ('12', 'B卡记录', 'bcard_menu', '8', 'oabcardmanage.do', '1', null, null, '0');
INSERT INTO `t_sys_menu` VALUES ('13', 'C卡记录', 'ccard_menu', '8', 'oaccardmanage.do', '1', null, null, '0');
INSERT INTO `t_sys_menu` VALUES ('16', 'D卡记录', 'dcard_menu', '8', 'oadcardmanage.do', '1', null, '', '0');
INSERT INTO `t_sys_menu` VALUES ('19', 'E卡记录', 'ecard_menu', '8', 'oaecardmanage.do', '1', null, null, '0');

-- ----------------------------
-- Table structure for `t_sys_operate`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_operate`;
CREATE TABLE `t_sys_operate` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `operate_code` varchar(30) DEFAULT NULL,
  `operate_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_operate
-- ----------------------------
INSERT INTO `t_sys_operate` VALUES ('1', 'add_btn', '添加');
INSERT INTO `t_sys_operate` VALUES ('2', 'del_btn', '删除');
INSERT INTO `t_sys_operate` VALUES ('3', 'query_btn', '查询');
INSERT INTO `t_sys_operate` VALUES ('4', 'edit_btn', '修改');

-- ----------------------------
-- Table structure for `t_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(18) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `operate_id` int(8) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  `group_id` int(8) DEFAULT NULL,
  `checked` tinyint(1) NOT NULL,
  `operateName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD28DE253105BF75B` (`group_id`),
  KEY `FKD28DE2534F4DA930` (`group_id`),
  CONSTRAINT `FKD28DE253105BF75B` FOREIGN KEY (`group_id`) REFERENCES `t_sys_group` (`id`),
  CONSTRAINT `FKD28DE2534F4DA930` FOREIGN KEY (`group_id`) REFERENCES `t_sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', '超级管理员', '超级管理员', '1', '20150520120015', '1', '0', null);
INSERT INTO `t_sys_role` VALUES ('33', '客服权限1', '客服权限1', '2', '20150307130603', null, '0', null);

-- ----------------------------
-- Table structure for `t_sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_menu`;
CREATE TABLE `t_sys_role_menu` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(8) NOT NULL,
  `menu_id` int(8) NOT NULL,
  `menu_btn` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKEE8E7C0B69C23339` (`menu_id`),
  KEY `FKEE8E7C0B8330C7D9` (`role_id`),
  CONSTRAINT `FKEE8E7C0B69C23339` FOREIGN KEY (`menu_id`) REFERENCES `t_sys_menu` (`id`),
  CONSTRAINT `FKEE8E7C0B8330C7D9` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role_menu
-- ----------------------------
INSERT INTO `t_sys_role_menu` VALUES ('34', '33', '8', null);
INSERT INTO `t_sys_role_menu` VALUES ('35', '33', '9', null);
INSERT INTO `t_sys_role_menu` VALUES ('36', '33', '10', null);
INSERT INTO `t_sys_role_menu` VALUES ('37', '33', '11', null);
INSERT INTO `t_sys_role_menu` VALUES ('38', '33', '12', null);
INSERT INTO `t_sys_role_menu` VALUES ('39', '33', '13', null);
INSERT INTO `t_sys_role_menu` VALUES ('40', '33', '16', null);
INSERT INTO `t_sys_role_menu` VALUES ('41', '33', '19', null);

-- ----------------------------
-- Table structure for `t_sys_role_operate`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_operate`;
CREATE TABLE `t_sys_role_operate` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `role_id` int(8) DEFAULT NULL,
  `operate_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK932813588330C7D9` (`role_id`),
  KEY `FK93281358C046E0FB` (`operate_id`),
  CONSTRAINT `FK932813588330C7D9` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`),
  CONSTRAINT `FK93281358C046E0FB` FOREIGN KEY (`operate_id`) REFERENCES `t_sys_operate` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_sys_role_operate
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_settings`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_settings`;
CREATE TABLE `t_sys_settings` (
  `key` varchar(200) NOT NULL COMMENT '设置键名',
  `value` text NOT NULL COMMENT '设置内容，大量数据将序列化',
  PRIMARY KEY (`key`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_settings
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `uid` int(8) NOT NULL AUTO_INCREMENT,
  `usercode` varchar(32) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `terminal_id` varchar(20) DEFAULT NULL,
  `valid_time` varchar(14) DEFAULT NULL,
  `create_time` varchar(14) DEFAULT NULL,
  `change_pwd_time` varchar(14) DEFAULT NULL,
  `lock_status` int(1) DEFAULT NULL COMMENT '0 未锁定',
  `status` int(1) DEFAULT NULL,
  `last_login_time` varchar(14) DEFAULT NULL,
  `last_login_ip` varchar(100) DEFAULT NULL,
  `group_id` int(8) DEFAULT NULL,
  `faceimg_aid` int(8) DEFAULT NULL COMMENT '头像id，对应attach表aid',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', 'ceshi1', '123', '981233555@qq.com', 'admin', '10210005555', null, null, null, '0', '1', null, null, '1', null);
INSERT INTO `t_sys_user` VALUES ('2', 'admin', '123', '981233555@qq.com', '超级管理员', '11110000111', '20141203', '20141202', null, '0', '1', '20150307133659', '127.0.0.1', '1', '82');
INSERT INTO `t_sys_user` VALUES ('18', 'kf001', '123', '658844@qq.com', '客服001', '15011112222', '20151231', '20150307', null, '0', '1', '20150307130716', '127.0.0.1', '2', null);

-- ----------------------------
-- Table structure for `t_sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `user_id` int(8) DEFAULT NULL,
  `role_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKEEC648ED8330C7D9` (`role_id`),
  KEY `FKEEC648ED285B8BB9` (`user_id`),
  CONSTRAINT `FKEEC648ED285B8BB9` FOREIGN KEY (`user_id`) REFERENCES `t_sys_user` (`uid`),
  CONSTRAINT `FKEEC648ED8330C7D9` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user_role
-- ----------------------------
INSERT INTO `t_sys_user_role` VALUES ('29', '2', '1');
