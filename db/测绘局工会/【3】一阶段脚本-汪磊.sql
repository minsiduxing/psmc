/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/6/24 21:46:43                           */
/*==============================================================*/


drop table if exists TAB_REPORT;

drop table if exists TAB_REPORT_REPLY;

drop table if exists TAB_REPORT_REPLY_REL;

/*==============================================================*/
/* Table: TAB_REPORT                                            */
/*==============================================================*/
create table TAB_REPORT
(
   REPORT_UUID          varchar(64) not null comment '上报标示',
   REPORT_TITLE         varchar(100) comment '上报标题',
   REPORT_CONTENT       varchar(255) comment '上报内容',
   REPORT_USER_NAME     varchar(255) comment '上报人姓名',
   REPORT_USER_UUID     varchar(64) comment '上报人标示',
   REPORT_TIME          timestamp comment '上报时间',
   REPORT_STAUS         varchar(50) comment '状态',
   REPORT_TYPE          varchar(100) comment '上报类型',
   LAST_MODIFY_TIME     timestamp comment '最后修改时间',
   REPORT_UPDATE_UUID   varchar(64) comment '修改人标示',
   REPORT_TEL           varchar(100) comment '上报人电话',
   IMAGE_PATH           varchar(100) comment '图片路径',
   primary key (REPORT_UUID)
);

alter table TAB_REPORT comment '上报申请表格';

/*==============================================================*/
/* Table: TAB_REPORT_REPLY                                      */
/*==============================================================*/
create table TAB_REPORT_REPLY
(
   REPLY_UUID           varchar(64) not null comment '答复标示',
   REPLY_CONTENT        varchar(255) comment '答复内容',
   REPLY_USER_UUID      varchar(64) comment '答复人标示',
   REPLY_USER_NAME      varchar(100) comment '答复人姓名',
   REPLY_TIME           timestamp comment '答复时间',
   LAST_MODIFY_TIME     timestamp comment '最后修改时间',
   LAST_MODIFY_USER_UUID varchar(64) comment '修改人标示',
   primary key (REPLY_UUID)
);

alter table TAB_REPORT_REPLY comment '上报答复表';

/*==============================================================*/
/* Table: TAB_REPORT_REPLY_REL                                  */
/*==============================================================*/
create table TAB_REPORT_REPLY_REL
(
   REL_UUID             varchar(64) not null comment '关联关系标示',
   REPORT_UUID          varchar(64) comment '上报标示',
   REPLY_UUID           varchar(64) comment '答复标示',
   primary key (REL_UUID)
);

alter table TAB_REPORT_REPLY_REL comment '上报答复关联关系表';




delete from tab_role_operate where operate_uuid in(select uuid from tab_operate where resource_uuid='115132658260463bb6f01b3108d11145');
delete from tab_role_operate where operate_uuid in(select uuid from tab_operate where resource_uuid='aa1cb8b91b504dcfb2f7fa14cc94ac7c');


delete from tab_role_resource where resource_id='115132658260463bb6f01b3108d11145';
delete from tab_role_resource where resource_id='aa1cb8b91b504dcfb2f7fa14cc94ac7c';

delete from tab_operate where resource_uuid='115132658260463bb6f01b3108d11145';
delete from tab_operate where resource_uuid='aa1cb8b91b504dcfb2f7fa14cc94ac7c';

delete from tab_resource where uuid='115132658260463bb6f01b3108d11145';
delete from tab_resource where uuid='aa1cb8b91b504dcfb2f7fa14cc94ac7c';




--帮扶申报资源
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum, is_view) VALUES ('115132658260463bb6f01b3108d11145', '困难申报', 3, '/website/backstage/reportController.do?method=index&type=report', 'a365f66231c049169cbcc0d9572043ba', 'admin', '2018-05-20 00:00:00', '帮扶申报菜单', 4, 1);
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum, is_view) VALUES ('aa1cb8b91b504dcfb2f7fa14cc94ac7c', '法律援助', 3, '/website/backstage/reportController.do?method=index&type=help', 'a365f66231c049169cbcc0d9572043ba', 'admin', '2018-05-20 00:00:00', '法律援助菜单', 3, 1);

--角色操作权限
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('efb74820f0564d02bb68fdf3190a6430', '115132658260463bb6f01b3108d11145');
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('efb74820f0564d02bb68fdf3190a6430', 'aa1cb8b91b504dcfb2f7fa14cc94ac7c');

--法律援助操作
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('043e42a525e242fcb37595a5b07ffa75', 'aa1cb8b91b504dcfb2f7fa14cc94ac7c', '756d6e80c9d74b4389c918ab50ee19c3', 'priv.guochun.psmc.website.backstage.report.service.ReportService', 'findReportByUuidBusinessMethod', '', '查询', '查询明细信息', 39);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('14dd01a1dad34c91a849762436509f98', 'aa1cb8b91b504dcfb2f7fa14cc94ac7c', '607e8bc6f9bb4afa9be3cfdc72a1a326', 'priv.guochun.psmc.website.backstage.report.service.ReportService', 'executeReplyReportBusinessMethod', 'INFO_HELP_REPLY', '回复', '回复', 38);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('4820df18ecdc4ac4b88207b1009291ea', 'aa1cb8b91b504dcfb2f7fa14cc94ac7c', '756d6e80c9d74b4389c918ab50ee19c3', 'priv.guochun.psmc.website.backstage.report.service.ReportService', 'findReportPageBusinessMethod', 'INFO_HELP_LIST', '查询', '查询列表', 36);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('7c8adc0a99104f4a9b2091fc2006af90', 'aa1cb8b91b504dcfb2f7fa14cc94ac7c', 'dec3b327b8a54d66bd644c544ea65c5e', 'priv.guochun.psmc.website.backstage.report.service.ReportService', 'deleteReportBusinessMethod', 'INFO_HELP_DELETE', '删除', '删除', 37);
--困难申报操作
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('043e42a525e242fcb37595a5b07ffa7e', '115132658260463bb6f01b3108d11145', '756d6e80c9d74b4389c918ab50ee19c3', 'priv.guochun.psmc.website.backstage.report.service.ReportService', 'findReportByUuidBusinessMethod', '', '查询', '查询明细信息', 39);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('14dd01a1dad34c91a849762436509498', '115132658260463bb6f01b3108d11145', '607e8bc6f9bb4afa9be3cfdc72a1a326', 'priv.guochun.psmc.website.backstage.report.service.ReportService', 'executeReplyReportBusinessMethod', 'INFO_REPORT_REPLY', '回复', '回复', 38);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('4820df18ecdc4ac4b88207b10092914a', '115132658260463bb6f01b3108d11145', '756d6e80c9d74b4389c918ab50ee19c3', 'priv.guochun.psmc.website.backstage.report.service.ReportService', 'findReportPageBusinessMethod', 'INFO_REPORT_LIST', '查询', '查询列表', 36);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('7c8adc0a99104f4a9b2091fc2006af96', '115132658260463bb6f01b3108d11145', 'dec3b327b8a54d66bd644c544ea65c5e', 'priv.guochun.psmc.website.backstage.report.service.ReportService', 'deleteReportBusinessMethod', 'INFO_REPORT_DELETE', '删除', '删除', 37);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('14dd01a1dad34c91a845762436509498', '115132658260463bb6f01b3108d11145', '607e8bc6f9bb4afa9be3cfdc72a1a326', 'priv.guochun.psmc.website.backstage.report.service.ReportService', 'dealReportBusinessMethod', 'INFO_REPORT_DEAL', '处理', '处理', 39);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('4820df18ecdc4ac4b88607b10092914a', '115132658260463bb6f01b3108d11145', '756d6e80c9d74b4389c918ab50ee19c3', 'priv.guochun.psmc.website.backstage.report.service.ReportService', 'dealReportBusinessMethod', 'INFO_REPORT_ACCEPT', '受理', '受理', 40);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('7c8adc0a99104f4a9b4091fc2006af96', '115132658260463bb6f01b3108d11145', 'dec3b327b8a54d66bd644c544ea65c5e', 'priv.guochun.psmc.website.backstage.report.service.ReportService', 'dealReportBusinessMethod', 'INFO_REPORT_RECORD', '备案', '备案', 41);


--法律援助角色操作
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '043e42a525e242fcb37595a5b07ffa75');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '14dd01a1dad34c91a849762436509f98');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '4820df18ecdc4ac4b88207b1009291ea');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '7c8adc0a99104f4a9b2091fc2006af90');


--困难申报角色操作
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '043e42a525e242fcb37595a5b07ffa7e');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '14dd01a1dad34c91a849762436509498');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '4820df18ecdc4ac4b88207b10092914a');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '7c8adc0a99104f4a9b2091fc2006af96');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '14dd01a1dad34c91a845762436509498');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '4820df18ecdc4ac4b88607b10092914a');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '7c8adc0a99104f4a9b4091fc2006af96');

delete from tab_data_dict where DICT_NO='REPORT_STAUS';
--申报状态
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('1', '已回复', '困难申报状态', 9, 1, 12, 'REPORT_STAUS');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('2', '已提交', '困难申报状态', 9, 2, 13, 'REPORT_STAUS');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('3', '处理中', '困难申报状态', 9, 3, 14, 'REPORT_STAUS');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('4', '已受理', '困难申报状态', 9, 4, 15, 'REPORT_STAUS');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('5', '已备案', '困难申报状态', 9, 5, 16, 'REPORT_STAUS');


--维护报修
delete from tab_role_operate where operate_uuid in(
select uuid from tab_operate where resource_uuid='ad705f6bb26948609e1aa55e86330d05'
);
delete from tab_operate where resource_uuid='ad705f6bb26948609e1aa55e86330d05';
delete from tab_role_resource where resource_id='ad705f6bb26948609e1aa55e86330d05';
delete from tab_resource where uuid='ad705f6bb26948609e1aa55e86330d05';


INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum, is_view) VALUES ('ad705f6bb26948609e1aa55e86330d05', '维护报修', 3, '/website/backstage/reportController.do?method=index&type=repair', '769a2c0484dd43749ed12b607102d688', 'admin', '2018-05-13 00:00:00', '维护报修菜单', 7, 1);
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('efb74820f0564d02bb68fdf3190a6430', 'ad705f6bb26948609e1aa55e86330d05');

--操作
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('863c2be59f01456a9341d1405793e309', 'ad705f6bb26948609e1aa55e86330d05', 'dec3b327b8a54d66bd644c544ea65c5e', 'deleteReportBusinessMethod', 'deleteReportBusinessMethod', 'INFO_REPAIR_DELETE', '删除', '删除', 43);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('b8a561c0601d4cf4a691c363e73b525e', 'ad705f6bb26948609e1aa55e86330d05', 'fe755fa4bd25475fa1a9d841caa16f44', 'priv.guochun.psmc.website.backstage.report.service.ReportService', 'executeReplyReportBusinessMethod', 'INFO_REPAIR_REPLY', '回复', '回复', 42);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('c5fb1aae61104d439d092e470542c6d3', 'ad705f6bb26948609e1aa55e86330d05', '756d6e80c9d74b4389c918ab50ee19c3', 'priv.guochun.psmc.website.backstage.report.service.ReportService', 'findReportPageBusinessMethod', '', '查询', '查询明细信息', 44);

--角色操作
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '863c2be59f01456a9341d1405793e309');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', 'b8a561c0601d4cf4a691c363e73b525e');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', 'c5fb1aae61104d439d092e470542c6d3');

