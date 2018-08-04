--初始化早知道信息分类
delete from tab_data_dict where DICT_NO = 'INFO_TYPE';
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('1401', '美味食谱', '早知道管理分类', 10, 1, 1, 'INFO_TYPE');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('1402', '日常通知', '早知道管理分类', 10, 2, 2, 'INFO_TYPE');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('1403', '大院新闻', '早知道管理分类', 10, 3, 3, 'INFO_TYPE');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('1404', '便民电话', '早知道管理分类', 10, 4, 4, 'INFO_TYPE');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('1405', '政策法律', '早知道管理分类', 10, 5, 5, 'INFO_TYPE');


--初始化操作信息(后勤中心-早知道)
delete from tab_role_operate where operate_uuid in(select uuid from tab_operate where resource_uuid='f03a9f0f29d44a1da4376353809eb9e1');
delete from tab_operate where resource_uuid='f03a9f0f29d44a1da4376353809eb9e1';

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('f0ccd87dbc684eeca5b72a1bedbcb23e','f03a9f0f29d44a1da4376353809eb9e1','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseListBusinessMethod','查看','早知道信息列表',1,'EARLY_KNOW_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('8709a43fb0524f1dbce5680ee96f2b19','f03a9f0f29d44a1da4376353809eb9e1','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','deleteInfoReleaseByUuidsBusinessMethod','删除','早知道信息删除',2,'EARLY_KNOW_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('c78e811598154da2a34ea7acb5a22b36','f03a9f0f29d44a1da4376353809eb9e1','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeAuditModuleBusinessMethod','审核','早知道信息审核',3,'EARLY_KNOW_AUDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('2f540e43e1bc4e1eb096ee0b2efa6b22','f03a9f0f29d44a1da4376353809eb9e1','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeReleaseModuleBusinessMethod','发布','早知道信息发布',4,'EARLY_KNOW_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('b8eec2c860944dc68143822868dd1ee1','f03a9f0f29d44a1da4376353809eb9e1','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','编辑','早知道信息编辑',5,'EARLY_KNOW_EDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('4c61947d93624a61af01981c46b0b063','f03a9f0f29d44a1da4376353809eb9e1','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseByUuidBusinessMethod','查看','早知道信息预览',6,'EARLY_KNOW_PREVIEW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('951d334e32104fb89c408c28319c42e6','f03a9f0f29d44a1da4376353809eb9e1','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','添加','早知道信息添加',7,'EARLY_KNOW_ADD');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'f0ccd87dbc684eeca5b72a1bedbcb23e');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '8709a43fb0524f1dbce5680ee96f2b19');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'c78e811598154da2a34ea7acb5a22b36');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '2f540e43e1bc4e1eb096ee0b2efa6b22');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'b8eec2c860944dc68143822868dd1ee1');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '4c61947d93624a61af01981c46b0b063');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '951d334e32104fb89c408c28319c42e6');

--新增字段
alter table tab_dept drop is_custom;
alter table tab_excellent_innovation drop is_custom;
alter table tab_activity_manage drop is_custom;
alter table tab_news drop is_custom;
alter table tab_dept add is_custom integer comment '是否自定义配图';
alter table tab_excellent_innovation add is_custom integer comment '是否自定义配图';
alter table tab_activity_manage add is_custom integer comment '是否自定义配图';
alter table tab_news add is_custom integer comment '是否自定义配图';

/*==============================================================*/
/* Table: tab_block                                             */
/*==============================================================*/
drop table tab_block;
create table tab_block
(
    block_uuid varchar(32) primary key comment '版块uuid',  
    block_name varchar(100) not null comment '版块名称',
    block_key varchar(100) comment '版块类型key',
    block_info varchar(500) comment '版块介绍',
    last_topic_uuid varchar(32) comment '最后发表主题ID',
    last_topic_person_uuid varchar(100) comment '最后发表人账号id',
    last_topic_date timestamp null comment '最后发表时间',
    block_status integer comment '板块状态(1正常，2暂停，3删除)',
    create_person_uuid varchar(100) comment '创建人id',
    create_date timestamp null comment '创建时间'  
)comment '版块信息表';

/*==============================================================*/
/* Table: tab_topics                                            */
/*==============================================================*/
drop table tab_topics;
create table tab_topics
(
   topic_uuid varchar(32) primary key comment '主题信息ID',
   topic_name varchar(100) comment '主题名称',
   topic_content text COLLATE utf8mb4_general_ci comment'主题内容',
   topic_status integer comment '主题状态(1正常，2暂停，3删除)',
   block_uuid varchar(100) comment '所属版块uuid',
   create_person_uuid varchar(100) comment '创建人id',
   create_person_name varchar(50) comment '创建人姓名',
   telephone varchar(20) comment'联系电话',
   create_date timestamp null comment '创建时间',
   last_comment_person_uuid varchar(100) comment'最后评论人id',
   last_comment_date timestamp null comment '最后评论时间',
   last_comment_uuid varchar(32) comment '最后评论id' 
) comment '主题信息表';

/*==============================================================*/
/* Table: tab_comment                                            */
/*==============================================================*/
drop table tab_comment;
create table tab_comment
(
   comment_uuid varchar(32) primary key comment '评论信息ID',
   topic_uuid varchar(32) not null comment '主题信息ID',
   comment_content varchar(1000) not null comment '评论内容',
   comment_person_uuid varchar(100) comment '评论人id',
   comment_person_name varchar(50) comment '评论人姓名',
   comment_date timestamp null comment '评论时间',
   comment_status integer comment '评论状态(1正常，2屏蔽，3删除)',
   to_person_uuid varchar(100) comment '评论目标用户id',
   to_person_name varchar(50) comment '评论目标用户姓名'
      
)comment '评论信息表';

/*==============================================================*/
/* Table: tab_attachment                                            */
/*==============================================================*/
drop table tab_attachment;
create table tab_attachment
(
   attachment_uuid varchar(32) primary key comment '主键',
   business_uuid varchar(100) comment '关联的业务信息id',
   file_prefix varchar(100) comment '文件前缀',
   file_path varchar(300) comment '文件路径',
   file_name varchar(100) comment '文件名称',
   file_real_name varchar(100) comment '文件真实名称',
   file_suffix varchar(20) comment '文件后缀名',
   upload_acc_uuid varchar(100) comment '上传人accUuid',
   upload_date timestamp null comment '上传时间',
   sort integer comment '排序'
) comment '附件信息表';