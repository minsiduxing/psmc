delete from tab_group where uuid<>'e30f6d26f09646aaa18460c086a206da';
update tab_group set group_name='默认组';

delete from tab_data_dict;

DELETE  FROM TAB_DATA_DICT WHERE DICT_TYPE='1';
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1','是','是否判断',1,1,'IF');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'2','否','是否判断',1,2,'IF');

DELETE  FROM TAB_DATA_DICT WHERE DICT_TYPE='2';
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(3,'1','男','性别',2,1,'SEX');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(4,'2','女','性别',2,2,'SEX');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(5,'3','其他','性别',2,3,'SEX');

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1','工作流业务','日志一级分类',5,1,'LOG_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'2','系统操作','日志一级分类',5,2,'LOG_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(3,'3','接口交互','日志一级分类',5,3,'LOG_TYPE');

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1.1','流程发起','日志二级分类',6,1,'LOG_SUB_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'2.1','登录','日志二级分类',6,2,'LOG_SUB_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(3,'2.2','登出','日志二级分类',6,3,'LOG_SUB_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(4,'2.3','日常操作','日志二级分类',6,4,'LOG_SUB_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(5,'3.1','短信接口日志','日志二级分类',6,5,'LOG_SUB_TYPE');


delete from TAB_DATA_DICT where DICT_NO='TAB_RESOURCE_TYPE';

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1','系统','用户组类型',7,1,'TAB_RESOURCE_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'2','模块','用户组类型',7,2,'TAB_RESOURCE_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'3','菜单','用户组类型',7,3,'TAB_RESOURCE_TYPE');


delete from TAB_DATA_DICT where DICT_NO='USER_GROUP_TYPE';

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1','根目录','用户组类型',8,1,'USER_GROUP_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'2','单位','用户组类型',8,1,'USER_GROUP_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'3','部门','用户组类型',8,2,'USER_GROUP_TYPE');


delete from TAB_DATA_DICT where DICT_NO='REPORT_STAUS';

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'6','未发布','合理化建议状态',9,1,'NEWS_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'7','已发布','合理化建议状态',9,2,'NEWS_TYPE');


delete from TAB_DATA_DICT where DICT_NO='NEWS_TYPE';

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1501','关于索骥','信息分类',10,1,'NEWS_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'1502','业务领域','信息分类',10,2,'NEWS_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(3,'1503','新闻动态','信息分类',10,3,'NEWS_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(4,'1504','联系我们','信息分类',10,4,'NEWS_TYPE');


delete from TAB_DATA_DICT where DICT_NO='INFO_TYPE';

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1501','关于介绍','信息分类',11,1,'INFO_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'1502','业务领域','信息分类',11,2,'INFO_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(3,'1503','新闻动态','信息分类',11,3,'INFO_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(4,'1504','联系我们','信息分类',11,4,'INFO_TYPE');


delete from TAB_DATA_DICT where DICT_NO='PRODUCT_TYPE';

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1601','合伙人','法律人员分类',12,1,'PRODUCT_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'1602','专职律师','法律人员分类',12,2,'PRODUCT_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(3,'1603','辅助人员','法律人员分类',12,3,'PRODUCT_TYPE');


delete from tab_role_operate where operate_uuid in(select uuid from tab_operate where resource_uuid in('8e059c578c204fbbb29086aa72ec88f9','0b62d21d1ecd471f958d96b43471dcca'));
delete from tab_operate where resource_uuid in('8e059c578c204fbbb29086aa72ec88f9','0b62d21d1ecd471f958d96b43471dcca');
delete from tab_role_resource where resource_id in('8e059c578c204fbbb29086aa72ec88f9','0b62d21d1ecd471f958d96b43471dcca');
delete from tab_resource where uuid in('8e059c578c204fbbb29086aa72ec88f9','0b62d21d1ecd471f958d96b43471dcca');


insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values
('8e059c578c204fbbb29086aa72ec88f9','信息发布',2,'','e51a8663876f4a3394bb194d89d96735','admin',str_to_date('2021-06-08','%Y-%m-%d %T'),'',23,1);

insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values
('0b62d21d1ecd471f958d96b43471dcca','信息发布',3,'/website/backstage/InfoReleaseController.do?method=infoReleaseList&oneLevelClassify=15','8e059c578c204fbbb29086aa72ec88f9','admin',str_to_date('2021-06-08','%Y-%m-%d %T'),'工作发布菜单',24,1);

insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '8e059c578c204fbbb29086aa72ec88f9');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '0b62d21d1ecd471f958d96b43471dcca');

/**初始化信息发布（原文体协会)**/
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
('4855162ac2014d3fb5cf5bee17075e28','0b62d21d1ecd471f958d96b43471dcca','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseListBusinessMethod','查询','查询',1,'NEW_WORK_RELEASE_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
('392b972ef167498896caa46644221319','0b62d21d1ecd471f958d96b43471dcca','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','deleteInfoReleaseByUuidsBusinessMethod','删除','删除',1,'NEW_WORK_RELEASE_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
('5b4bea13b8dc4b6eac9ea7a7f6867456','0b62d21d1ecd471f958d96b43471dcca','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeAuditModuleBusinessMethod','审核','审核',1,'NEW_WORK_RELEASE_AUDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
('c3cdc2664df14b07a5994f2b9bc2ca03','0b62d21d1ecd471f958d96b43471dcca','022a43088dcd46d4b201b43b32d3d85a',
-- 'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeReleaseModuleBusinessMethod','发布','发布',1,'NEW_WORK_RELEASE_RELEASE');
-- insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
-- ('28979cdd48d04f83b5f79abf813e769c','0b62d21d1ecd471f958d96b43471dcca','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','编辑','编辑',1,'NEW_WORK_RELEASE_EDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
('1f96c131e4b3436486f7e4c92e8399df','0b62d21d1ecd471f958d96b43471dcca','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseByUuidBusinessMethod','查看','查看',1,'NEW_WORK_RELEASE_PREVIEW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
('8615ca6386f340b48e1992c676ee2606','0b62d21d1ecd471f958d96b43471dcca','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','新增','新增',1,'NEW_WORK_RELEASE_ADD');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
('c24864b488dc4d3aac34ca5ac310b636','0b62d21d1ecd471f958d96b43471dcca','cb14b0e3d47647e58da01ab09e0d373c',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeUndoBusinessMethod','撤销','撤销',1,'NEW_WORK_RELEASE_UNDO');



insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '4855162ac2014d3fb5cf5bee17075e28');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '392b972ef167498896caa46644221319');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '5b4bea13b8dc4b6eac9ea7a7f6867456');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'c3cdc2664df14b07a5994f2b9bc2ca03');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '1f96c131e4b3436486f7e4c92e8399df');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '8615ca6386f340b48e1992c676ee2606');
-- insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '28979cdd48d04f83b5f79abf813e769c');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'c24864b488dc4d3aac34ca5ac310b636');






delete from tab_sys_key_info where id in(24,25,26,27,28,29,30,31,32,33,34,35);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (24, 'file_prefix_path', 'E:/export/home/suoji/upload/', '文件上传后生成的url前缀');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (25, 'system_upload_dir', '/export/home/websit/suoji/upload/', '文件上传后实际保存的服务器地址');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (26, 'news_image_path', 'default/news.png', '新闻缺省配图地址-大院新闻');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (27, 'system_upload_temp_dir', '/log/suoji-temp-upload/', '系统上传临时文件目录');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (28, 'system_download_temp_dir', '/log/suoji-temp-download/', '系统下载临时文件目录');

INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (29, 'system_upload_isremote', 'false', '是否开启ftp远程上传（被动模式）');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (30, 'system_remote_ip', 'ip', '远程主机ip');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (31, 'system_remote_port', 'port', '远程主机port');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (32, 'system_remote_username', '', '主机ftp用户名');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (33, 'system_remote_password', '', '主机ftp密码');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (34, 'system_remote_os', 'linux', '远程主机系统');

INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (35, 'excel_export_length', '10000', '系统导出excel每个sheet页的最大限制');

delete from tab_sys_key_info where id in(36,37,38,39,40,41,42,43,44);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (36, 'mobile_image_path', 'mobile/', '陕测-移动端上传图片自定义路径');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (37, 'activity_custom', 'activity/', '陕测-活动-图片路径');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (38, 'dept_literary_form_custom', 'deptLiteraryForm/', '陕测-文体协会-图片路径');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (39, 'dept_innovation_custom', 'deptInnovation/', '陕测-信息编辑自定义配图路径');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (40, 'logistics_center_custom', 'logisticsCenter/', '陕测-后勤中心-早知道-图片路径');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (41, 'literary_form_custom', 'literaryForm/', '陕测-文体协会-最新活动-图片路径');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (42, 'assistance_custom', 'assistance/', '陕测-援助帮扶-法条维护-图片路径');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (43, 'innovation_custom', 'innovation/', '陕测-创新工作室-图片路径');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (44, 'custom_image_path', 'custom/', '陕测-信息列表自定义配图路径');

delete from tab_sys_key_info where id in(45,46,47,48,49,50,51,52,53);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (45, 'help_declare_image_path', 'default/help_declare.png', '陕测-帮扶申报-默认配图');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (46, 'law_help_image_path', 'default/law_help.png', '陕测-法律援助-默认配图');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (47, 'Legal_provisions_image_path', 'default/Legal_provisions.png', '陕测-法条维护-默认配图');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (48, 'work_manage_image_path', 'default/work_manage.png', '陕测-工作管理-默认配图');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (49, 'work_release_image_path', 'default/work_manage.png', '陕测-工作发布-默认配图');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (50, 'activity_image_path', 'default/activity.png', '陕测-活动管理-默认配图');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (51, 'innovation_image_path', 'default/innovation.png', '陕测-优秀创新-默认配图');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (52, 'recipes_image_path', 'default/recipes.png', '陕测-美味食谱-默认配图');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (53, 'notice_image_path', 'default/notice.png', '陕测-日常通知-默认配图');
