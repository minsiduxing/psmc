-- ----------------------------
-- Table structure for tab_message_black
-- ----------------------------
DROP TABLE IF EXISTS `tab_message_black`;
CREATE TABLE `tab_message_black`  (
  `black_uuid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `reason` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '原因',
  `add_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`black_uuid`) USING BTREE
) 

-- ----------------------------
-- Table structure for tab_message_pool
-- ----------------------------
DROP TABLE IF EXISTS `tab_message_pool`;
CREATE TABLE `tab_message_pool`  (
  `msg_uuid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `temp_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模板code',
  `add_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`msg_uuid`) USING BTREE
) 

-- ----------------------------
-- Table structure for tab_message_temp
-- ----------------------------
DROP TABLE IF EXISTS `tab_message_temp`;
CREATE TABLE `tab_message_temp`  (
  `temp_uuid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `temp_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模板code',
  `temp_content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模板内容',
  `type` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型：0短信，1彩信',
  `add_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`temp_uuid`) USING BTREE
) 


---------------------------------------------------------------------------------
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('e2ab21ca3bd14c92b0b9bf158e34a8fc','短彩信推广',2,'','e51a8663876f4a3394bb194d89d96735','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'短彩信推广',31,1);

insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('2613ebd421a945bfa7c9c6630ca189a7','消息池列表',3,'/website/backstage/TabMessagePoolController.do?method=toMessagePoolList','e2ab21ca3bd14c92b0b9bf158e34a8fc','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'消息池列表',1,1);
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('da01ab9c2dc64cd1af63599e4af7684e','短彩信余量查询',3,'/website/backstage/TabMessagePoolController.do?method=getBalance','08d4393d7f73490e95a75bf4bba6b920','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'短彩信余量查询',1,1);
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'da01ab9c2dc64cd1af63599e4af7684e');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'e2ab21ca3bd14c92b0b9bf158e34a8fc');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '2613ebd421a945bfa7c9c6630ca189a7');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('a809c9e8a9654b1c9c460fa94e4ecd1f','2613ebd421a945bfa7c9c6630ca189a7','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.message.service.TabMessagePoolService','insert','新增','新增',1  ,'SJHC_ADD_EVALUATE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('4057fde83d86436db263a4839882f594','2613ebd421a945bfa7c9c6630ca189a7','d3ad7cefb81040ac8c935e7ee5602f5c',
'priv.guochun.psmc.website.backstage.message.service.TabMessagePoolService','saveExcelMessageBusinessMethod','导入','导入',2  ,'SJHC_IMPORT_EXCEL');



insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'a809c9e8a9654b1c9c460fa94e4ecd1f');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '4057fde83d86436db263a4839882f594');


接收短信回复数据
http://localhost:9090/psmc/api/sms/SmsController.do?method=receiveReplies