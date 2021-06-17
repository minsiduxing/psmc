SELECT * FROM tab_group;

delete from tab_group where uuid<>'e30f6d26f09646aaa18460c086a206da';
update tab_group set group_name='默认组';

select * from tab_resource;


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

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1406','关于索骥','信息分类',10,1,'NEWS_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'1407','业务领域','信息分类',10,2,'NEWS_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(3,'1408','新闻动态','信息分类',10,3,'NEWS_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(4,'1409','联系我们','信息分类',10,4,'NEWS_TYPE');



delete from TAB_DATA_DICT where DICT_NO='INFO_TYPE';

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1406','关于索骥','信息分类',11,1,'INFO_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'1407','业务领域','信息分类',11,2,'INFO_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(3,'1408','新闻动态','信息分类',11,3,'INFO_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(4,'1409','联系我们','信息分类',11,4,'INFO_TYPE');

delete from TAB_DATA_DICT where DICT_NO='LEGAL_PERSON_TYPE';

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1','合伙人','法律人员分类',12,1,'LEGAL_PERSON_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'2','专职律师','法律人员分类',12,2,'LEGAL_PERSON_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(3,'3','辅助人员','法律人员分类',12,3,'LEGAL_PERSON_TYPE');


insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values
('8e059c578c204fbbb29086aa72ec88f9','新闻发布',2,'','e51a8663876f4a3394bb194d89d96735','admin',str_to_date('2021-06-08','%Y-%m-%d %T'),'文体协会管理',23,1);

insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values
('0b62d21d1ecd471f958d96b43471dcca','新闻动态',3,'/website/backstage/InfoReleaseController.do?method=infoReleaseList&oneLevelClassify=15','8e059c578c204fbbb29086aa72ec88f9','admin',str_to_date('2021-06-08','%Y-%m-%d %T'),'工作发布菜单',24,1);

insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '8e059c578c204fbbb29086aa72ec88f9');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '0b62d21d1ecd471f958d96b43471dcca');



/**初始化新闻动态（原文体协会)**/
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
('4855162ac2014d3fb5cf5bee17075e28','0b62d21d1ecd471f958d96b43471dcca','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseListBusinessMethod','查询','查询',1,'WORK_RELEASE_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
('392b972ef167498896caa46644221319','0b62d21d1ecd471f958d96b43471dcca','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','deleteInfoReleaseByUuidsBusinessMethod','删除','删除',1,'WORK_RELEASE_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
('5b4bea13b8dc4b6eac9ea7a7f6867456','0b62d21d1ecd471f958d96b43471dcca','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeAuditModuleBusinessMethod','审核','审核',1,'WORK_RELEASE_AUDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
('c3cdc2664df14b07a5994f2b9bc2ca03','0b62d21d1ecd471f958d96b43471dcca','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeReleaseModuleBusinessMethod','发布','发布',1,'WORK_RELEASE_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
('28979cdd48d04f83b5f79abf813e769c','0b62d21d1ecd471f958d96b43471dcca','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','编辑','编辑',1,'WORK_RELEASE_EDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
('1f96c131e4b3436486f7e4c92e8399df','0b62d21d1ecd471f958d96b43471dcca','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseByUuidBusinessMethod','查看','查看',1,'WORK_RELEASE_PREVIEW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
('8615ca6386f340b48e1992c676ee2606','0b62d21d1ecd471f958d96b43471dcca','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','新增','新增',1,'WORK_RELEASE_ADD');



insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '4855162ac2014d3fb5cf5bee17075e28');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '392b972ef167498896caa46644221319');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '5b4bea13b8dc4b6eac9ea7a7f6867456');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'c3cdc2664df14b07a5994f2b9bc2ca03');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '28979cdd48d04f83b5f79abf813e769c');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '1f96c131e4b3436486f7e4c92e8399df');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '8615ca6386f340b48e1992c676ee2606');


delete from tab_sys_key_info where id=24 or id=25;
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (24, 'file_prefix_path', 'E:/export/home/suoji/upload/', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (25, 'system_upload_dir', '/export/home/suoji/upload/', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (26, 'news_image_path', '/export/home/suoji/upload/', null);

