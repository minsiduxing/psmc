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
   last_comment_uuid varchar(32) comment '最后评论id' ,
   image_path varchar(200) comment '信息列表配图'
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


------------------初始化板块信息-----------------
delete from tab_block where block_uuid in ('01','02','03','04','05');
insert into tab_block (block_uuid, block_name, block_key, block_info, last_topic_uuid, last_topic_person_uuid, last_topic_date, block_status, create_person_uuid, create_date) 
        values('01', '跳蚤市场', 'flea_market', '为职工提供微信端的物品交换信息的发布功能，同时支持实名留言讨论。', null, null, null, 1, 'bd474935a3894530af485bea128501ec', NOW());
        
insert into tab_block (block_uuid,block_name,block_key,block_info,last_topic_uuid,last_topic_person_uuid,last_topic_date,block_status,create_person_uuid,create_date) 
        values('02', '曝光台', 'exposure_table','为职工提供微信端的不文明行为上报功能，同时支持实名留言讨论。',null,null,null,1,'bd474935a3894530af485bea128501ec',NOW());
        
insert into tab_block (block_uuid,block_name,block_key,block_info,last_topic_uuid,last_topic_person_uuid,last_topic_date,block_status,create_person_uuid,create_date) 
        values('03', '合理化建议', 'rationalization_proposal','为职工提供微信端的合理化建议上报功能，同时支持实名留言讨论。',null,null,null,1,'bd474935a3894530af485bea128501ec',NOW());
        
insert into tab_block (block_uuid,block_name,block_key,block_info,last_topic_uuid,last_topic_person_uuid,last_topic_date,block_status,create_person_uuid,create_date) 
        values('04', '表扬', 'praise','为职工提供微信端的表扬上报功能，同时支持实名留言讨论。',null,null,null,1,'bd474935a3894530af485bea128501ec',NOW());
        
insert into tab_block (block_uuid,block_name,block_key,block_info,last_topic_uuid,last_topic_person_uuid,last_topic_date,block_status,create_person_uuid,create_date) 
        values('05', '投诉', 'complain','为职工提供微信端的投诉上报功能，同时支持实名留言讨论。',null,null,null,1,'bd474935a3894530af485bea128501ec',NOW());


------------------更新资源信息-------------------
update tab_resource set resource_url = '/website/backstage/tabTopicsController.do?method=toTopicsListPage&blockUuid=01' where uuid = '2108b5f2b4704a1b85ac0b2a596ded97';
update tab_resource set resource_url = '/website/backstage/tabTopicsController.do?method=toTopicsListPage&blockUuid=02' where uuid = '9dcf22db90c74e96b4e6c16da7ed84fd';
update tab_resource set resource_url = '/website/backstage/tabTopicsController.do?method=toTopicsListPage&blockUuid=03' where uuid = '168f11a29d3545df9a74c3bb0f346915';
update tab_resource set resource_url = '/website/backstage/tabTopicsController.do?method=toTopicsListPage&blockUuid=04' where uuid = 'bde250464cdc458ead9472ee9cdfda7f';
update tab_resource set resource_url = '/website/backstage/tabTopicsController.do?method=toTopicsListPage&blockUuid=05' where uuid = '16730e48bc1248c48500f202dfe3f2ab';

------------------初始化操作信息-----------------
delete from tab_role_operate where operate_uuid in(select uuid from tab_operate where resource_uuid='2108b5f2b4704a1b85ac0b2a596ded97');
delete from tab_role_operate where operate_uuid in(select uuid from tab_operate where resource_uuid='9dcf22db90c74e96b4e6c16da7ed84fd');
delete from tab_role_operate where operate_uuid in(select uuid from tab_operate where resource_uuid='168f11a29d3545df9a74c3bb0f346915');
delete from tab_role_operate where operate_uuid in(select uuid from tab_operate where resource_uuid='bde250464cdc458ead9472ee9cdfda7f');
delete from tab_role_operate where operate_uuid in(select uuid from tab_operate where resource_uuid='16730e48bc1248c48500f202dfe3f2ab');
delete from tab_operate where resource_uuid='2108b5f2b4704a1b85ac0b2a596ded97';
delete from tab_operate where resource_uuid='9dcf22db90c74e96b4e6c16da7ed84fd';
delete from tab_operate where resource_uuid='168f11a29d3545df9a74c3bb0f346915';
delete from tab_operate where resource_uuid='bde250464cdc458ead9472ee9cdfda7f';
delete from tab_operate where resource_uuid='16730e48bc1248c48500f202dfe3f2ab';
--跳蚤市场
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('a49a6a382cd14c3a872e1fbc3e67d121','2108b5f2b4704a1b85ac0b2a596ded97','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','queryTopicListBusinessMethod','查询','跳蚤市场列表',1  ,'FLEA_MARKET_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('080fbff78c284addbd186ada11c169f0','2108b5f2b4704a1b85ac0b2a596ded97','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','updateTopicsStatusBusinessMethod','删除','删除信息',2  ,'FLEA_MARKET_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('e9e83ae504df4b1ab6847334334df958','2108b5f2b4704a1b85ac0b2a596ded97','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','updateTopicsStatusBusinessMethod','禁止评论','禁止评论',3  ,'FLEA_MARKET_PAUSE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('36853b7e0a5841a0aeffb4faa59e6c36','2108b5f2b4704a1b85ac0b2a596ded97','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','queryTopicsBusinessMethod','查看','查看信息详情',4  ,'FLEA_MARKET_PREVIW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('2169013f6f5f4d83a823d0da2fb40441','2108b5f2b4704a1b85ac0b2a596ded97','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','updateTopicsStatusBusinessMethod','撤销','撤销',5  ,'FLEA_MARKET_UNDO');
--曝光台
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('91b54f3f2ee24ba9a88ee26f0ddabbba','9dcf22db90c74e96b4e6c16da7ed84fd','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','queryTopicListBusinessMethod','查询','曝光台信息列表',1  ,'EXPOSURE_TABLE_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('a598bc0152bb455f8861306be36dc2fd','9dcf22db90c74e96b4e6c16da7ed84fd','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','updateTopicsStatusBusinessMethod','删除','删除信息',2  ,'EXPOSURE_TABLE_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('c4b9fed7e47f4b18845fb38cf9f315b9','9dcf22db90c74e96b4e6c16da7ed84fd','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','updateTopicsStatusBusinessMethod','禁止评论','禁止评论',3  ,'EXPOSURE_TABLE_PAUSE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('a2722891a0f6472e856810193c00b927','9dcf22db90c74e96b4e6c16da7ed84fd','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','queryTopicsBusinessMethod','查看','查看信息详情',4  ,'EXPOSURE_TABLE_PREVIW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('2ba394984e7546868c00d6ce548b7a30','9dcf22db90c74e96b4e6c16da7ed84fd','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','updateTopicsStatusBusinessMethod','撤销','撤销',5  ,'EXPOSURE_TABLE_UNDO');
--合理化建议
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('6b1204573d77417bbe588a361b7bd26b','168f11a29d3545df9a74c3bb0f346915','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','queryTopicListBusinessMethod','查询','合理化建议信息列表',1  ,'RATIONALIZATION_PROPOSAL_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('0436beaf7a044a2a81f57a0d4dbfa1d6','168f11a29d3545df9a74c3bb0f346915','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','updateTopicsStatusBusinessMethod','删除','删除信息',2  ,'RATIONALIZATION_PROPOSAL_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('979c9702a5084ba2918de28bf1f1596b','168f11a29d3545df9a74c3bb0f346915','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','updateTopicsStatusBusinessMethod','禁止评论','禁止评论',3  ,'RATIONALIZATION_PROPOSAL_PAUSE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('228913637f9147478bd178fe1ad0b3d2','168f11a29d3545df9a74c3bb0f346915','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','queryTopicsBusinessMethod','查看','查看信息详情',4  ,'RATIONALIZATION_PROPOSAL_PREVIW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('3182a55304cf4858bbec25fba1415432','168f11a29d3545df9a74c3bb0f346915','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','updateTopicsStatusBusinessMethod','撤销','撤销',5  ,'RATIONALIZATION_PROPOSAL_UNDO');
--表扬
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('2b1d7b4a0b6f41d786d87bb6c68745f7','bde250464cdc458ead9472ee9cdfda7f','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','queryTopicListBusinessMethod','查询','表扬信息列表',1  ,'PRAISE_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('79d1275fb9d44d7988dd0e891c581c0c','bde250464cdc458ead9472ee9cdfda7f','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','updateTopicsStatusBusinessMethod','删除','删除信息',2  ,'PRAISE_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('81404965f2954cf5b3b8c5de6a2de86c','bde250464cdc458ead9472ee9cdfda7f','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','updateTopicsStatusBusinessMethod','禁止评论','禁止评论',3  ,'PRAISE_PAUSE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('5110c883e77941cb9424e059db962bd2','bde250464cdc458ead9472ee9cdfda7f','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','queryTopicsBusinessMethod','查看','查看信息详情',4  ,'PRAISE_PREVIW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('01d23ba564e344b79efb274e6e9c6e16','bde250464cdc458ead9472ee9cdfda7f','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','updateTopicsStatusBusinessMethod','撤销','撤销',5  ,'PRAISE_UNDO');
--投诉
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('8e5857f8cb0b42d98372d85956f28ca1','16730e48bc1248c48500f202dfe3f2ab','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','queryTopicListBusinessMethod','查询','投诉信息列表',1  ,'COMPLAIN_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('1b2c6e963f6143f094746de18486dd8d','16730e48bc1248c48500f202dfe3f2ab','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','updateTopicsStatusBusinessMethod','删除','删除信息',2  ,'COMPLAIN_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('19f6e4e442154458835bcbbdcfc433d3','16730e48bc1248c48500f202dfe3f2ab','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','updateTopicsStatusBusinessMethod','禁止评论','禁止评论',3  ,'COMPLAIN_PAUSE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('67b2d257666a42f6bc22af34e3117656','16730e48bc1248c48500f202dfe3f2ab','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','queryTopicsBusinessMethod','查看','查看信息详情',4  ,'COMPLAIN_PREVIW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('102f230c4c1b42ddbc48c0c075e8e6ea','16730e48bc1248c48500f202dfe3f2ab','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','updateTopicsStatusBusinessMethod','撤销','撤销',5  ,'COMPLAIN_UNDO');

---------------------初始化角色操作---------------------
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'a49a6a382cd14c3a872e1fbc3e67d121');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '080fbff78c284addbd186ada11c169f0');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'e9e83ae504df4b1ab6847334334df958');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '36853b7e0a5841a0aeffb4faa59e6c36');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '2169013f6f5f4d83a823d0da2fb40441');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '91b54f3f2ee24ba9a88ee26f0ddabbba');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'a598bc0152bb455f8861306be36dc2fd');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'c4b9fed7e47f4b18845fb38cf9f315b9');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'a2722891a0f6472e856810193c00b927');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '2ba394984e7546868c00d6ce548b7a30');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '6b1204573d77417bbe588a361b7bd26b');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '0436beaf7a044a2a81f57a0d4dbfa1d6');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '979c9702a5084ba2918de28bf1f1596b');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '228913637f9147478bd178fe1ad0b3d2');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '3182a55304cf4858bbec25fba1415432');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '8e5857f8cb0b42d98372d85956f28ca1');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '1b2c6e963f6143f094746de18486dd8d');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '19f6e4e442154458835bcbbdcfc433d3');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '67b2d257666a42f6bc22af34e3117656');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '102f230c4c1b42ddbc48c0c075e8e6ea');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '2b1d7b4a0b6f41d786d87bb6c68745f7');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '79d1275fb9d44d7988dd0e891c581c0c');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '81404965f2954cf5b3b8c5de6a2de86c');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '5110c883e77941cb9424e059db962bd2');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '01d23ba564e344b79efb274e6e9c6e16');



/*新增撤销功能脚本*/
delete from tab_operate where uuid in ('c24864b488dc4d3aac34ca5ac310b636', '8598ed7e24524a24afd9e2279bfe4172', '125f4aa5d7084da59b02cc291546b1fa', 
				'91562f3d5fbb47fea580f3613c93dbb6', 'a3f6cb65c0b44efeb5c6eaa2b062c760', '8076d4233c344c15845b3043a939870d');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('c24864b488dc4d3aac34ca5ac310b636','f03a9f0f29d44a1da4376353809eb9e1','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeUndoBusinessMethod','撤销','撤销',8,'EARLY_KNOW_UNDO');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('8598ed7e24524a24afd9e2279bfe4172','1b0cd1d267c948e2886ef98e5a76a578','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeUndoBusinessMethod','撤销','撤销',8,'LEGAL_PROVISIONS_UNDO');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('125f4aa5d7084da59b02cc291546b1fa','cae199e1e01f4bcf80ae2e2976fd15b9','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.activity.service.TabActivityManageService','executeUndoBusinessMethod','撤销','撤销',8,'ACTIVITY_UNDO');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('91562f3d5fbb47fea580f3613c93dbb6','c712464e336d4ae6988bd27ba35f17d4','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService','executeUndoBusinessMethod','撤销','撤销',8,'INNOVATION_UNDO');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('a3f6cb65c0b44efeb5c6eaa2b062c760','bf5cdda0af224da2a2ed33360364b967','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.dept.service.TabDeptService','executeUndoBusinessMethod','撤销','撤销',8,'WORK_ROOM_UNDO');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('8076d4233c344c15845b3043a939870d','7c0f15982df64a8081507bfb1cfce5aa','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.dept.service.TabDeptService','executeUndoBusinessMethod','撤销','撤销',8,'ASSOCIATION_UNDO');

delete from tab_role_operate where operate_uuid in ('c24864b488dc4d3aac34ca5ac310b636', '8598ed7e24524a24afd9e2279bfe4172', '125f4aa5d7084da59b02cc291546b1fa', 
				'91562f3d5fbb47fea580f3613c93dbb6', 'a3f6cb65c0b44efeb5c6eaa2b062c760', '8076d4233c344c15845b3043a939870d');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'c24864b488dc4d3aac34ca5ac310b636');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '8598ed7e24524a24afd9e2279bfe4172');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '125f4aa5d7084da59b02cc291546b1fa');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '91562f3d5fbb47fea580f3613c93dbb6');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'a3f6cb65c0b44efeb5c6eaa2b062c760');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '8076d4233c344c15845b3043a939870d');

delete from tab_data_dict where DICT_NO = 'TOPICS_STATUS';
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('1', '正常', '主题信息状态', 1, 1, 1, 'TOPICS_STATUS');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('2', '禁止评论', '主题信息状态', 2, 2, 2, 'TOPICS_STATUS');

---主题信息增加发布字段
alter table tab_topics add release_status INTEGER comment '发布状态';
alter table tab_topics add release_time TIMESTAMP NULL comment '发布时间';
alter table tab_topics add release_person_uuid varchar(64) comment '发布人id';

delete from tab_role_operate where operate_uuid in(
select uuid from tab_operate where OPERATE_NO in('FLEA_MARKET_RELEASE','FLEA_MARKET_BAN_RELEASE','EXPOSURE_TABLE_RELEASE','EXPOSURE_TABLE_BAN_RELEASE',
'PRAISE_RELEASE','PRAISE_BAN_RELEASE','COMPLAIN_RELEASE','COMPLAIN_BAN_RELEASE')
);

delete from tab_operate where OPERATE_NO in('FLEA_MARKET_RELEASE','FLEA_MARKET_BAN_RELEASE','EXPOSURE_TABLE_RELEASE','EXPOSURE_TABLE_BAN_RELEASE',
'PRAISE_RELEASE','PRAISE_BAN_RELEASE','COMPLAIN_RELEASE','COMPLAIN_BAN_RELEASE');



---新增操作配置（发布和禁止发布）
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('38852cba55c9470eb0ac5634635f66da','2108b5f2b4704a1b85ac0b2a596ded97','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','executeReleaseBusinessMethod','发布','发布',6  ,'FLEA_MARKET_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('ede72221fa2049fd8160377809d9a5df','2108b5f2b4704a1b85ac0b2a596ded97','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','executeBanReleaseBusinessMethod','禁止发布','禁止发布',7  ,'FLEA_MARKET_BAN_RELEASE');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('484cbb067730459ab97cb5ff25fff41d','9dcf22db90c74e96b4e6c16da7ed84fd','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','executeReleaseBusinessMethod','发布','发布',6  ,'EXPOSURE_TABLE_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('242d6d5d66054d33bfdaa349832f5107','9dcf22db90c74e96b4e6c16da7ed84fd','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','executeBanReleaseBusinessMethod','禁止发布','禁止发布',7  ,'EXPOSURE_TABLE_BAN_RELEASE');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('267cabbc9e244b519ccd9bcdddb827be','bde250464cdc458ead9472ee9cdfda7f','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','executeReleaseBusinessMethod','发布','发布',6  ,'PRAISE_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('5a99cebe7a89492d84e2b0df8861ea89','bde250464cdc458ead9472ee9cdfda7f','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','executeBanReleaseBusinessMethod','禁止发布','禁止发布',7  ,'PRAISE_BAN_RELEASE');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('d8a08f951ae8478abc75968f982b37b6','16730e48bc1248c48500f202dfe3f2ab','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','executeReleaseBusinessMethod','发布','发布',6  ,'COMPLAIN_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('3bd3339830854cb3af9d01040ad71f6e','16730e48bc1248c48500f202dfe3f2ab','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService','executeBanReleaseBusinessMethod','禁止发布','禁止发布',7  ,'COMPLAIN_BAN_RELEASE');     

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '38852cba55c9470eb0ac5634635f66da');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'ede72221fa2049fd8160377809d9a5df');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '484cbb067730459ab97cb5ff25fff41d');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '242d6d5d66054d33bfdaa349832f5107');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '267cabbc9e244b519ccd9bcdddb827be');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '5a99cebe7a89492d84e2b0df8861ea89');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'd8a08f951ae8478abc75968f982b37b6');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '3bd3339830854cb3af9d01040ad71f6e');

drop table tab_laud;
---创建点赞表
create table tab_laud
(
   laud_uuid            varchar(100) not null comment '点赞主键',
   module_uuid          varchar(100) comment '点赞模型id',
   laud_date            timestamp comment '点赞时间',
   laud_person_uuid     varchar(64) comment '点赞人id',
   laud_person_name     varchar(100) comment '点赞人姓名',
   primary key (laud_uuid)
);


---------------------------二阶段后期新增脚本--start----------------------------------
--实名认证需新增的字段
alter table tab_person add id_card varchar(18) comment '身份证号';
alter table tab_person add area varchar(100) comment '身份证所在地';
alter table tab_person add province varchar(20) comment '身份证所在省';
alter table tab_person add city varchar(20) comment '身份证所在市';
alter table tab_person add prefecture varchar(20) comment '身份证所在区县';
alter table tab_person add birthday varchar(20) comment '出生年月';
alter table tab_person add addr_code varchar(10) comment '地区代码';
alter table tab_accounts add is_auth integer comment '是否实名认证（1是，2否）';
alter table tab_accounts add auth_type integer comment '实名认证方式（1身份证，2其他）';

drop table tab_sys_config;
--系统配置表
create table tab_sys_config
(
    sys_uuid varchar(64) not null comment '系统配置uuid',
    sys_code varchar(100) comment '编码',
    sys_type varchar(10) comment '类型',
    sys_url varchar(500) comment 'url地址',
    sys_method varchar(100) comment '方法',
    sys_remark varchar(500) comment '描述',
    app_code varchar(100) comment '第三方接口调用认证编码',
    column1 varchar(100) comment '备用字段1',
    column2 varchar(100) comment '备用字段2',
    ordernum integer comment '排序码',
    primary key (sys_uuid)
);

---配置实名认证接口
INSERT INTO tab_sys_config (sys_uuid, sys_code, sys_type, sys_url, sys_method, sys_remark, app_code, column1, column2, ordernum) VALUES ('2b909a0327c14764b053b3a4b232d26f', 'REAL_NAME_AUTHENTICATION', '', 'https://idcardcert.market.alicloudapi.com', '/idCardCert', '实名认证接口调用', '8660c15a4c8e43d1849bd63b00cb4e7d', null, null, null);

---申报表增加字段
alter table tab_report add release_status integer comment '发布状态';
alter table tab_report add release_date TIMESTAMP NULL comment '发布时间';
alter table tab_report add release_person_uuid varchar(64) comment '发布人id'; 
--部门表增加字段
alter table tab_dept add cooperation varchar(1000) comment '合作意向';

--字典表申报状态修改
delete from tab_data_dict where DICT_NO = 'REPORT_STAUS' and DICT_ID = '7';
update tab_data_dict set DICT_NAME = '待回复' where DICT_NO = 'REPORT_STAUS' and DICT_ID = '2';
update tab_data_dict set DICT_NAME = '已提交' where DICT_NO = 'REPORT_STAUS' and DICT_ID = '6';

--操作表
update tab_operate set fun_method = 'releaseOrCancelBusinessMethod' where OPERATE_NO in ('INFO_ADVICE_PUBLISH','INFO_ADVICE_PUBLISH_CANCEL');
update tab_operate set OPERATE_NAME = '取消发布' where OPERATE_NO in ('FLEA_MARKET_BAN_RELEASE','EXPOSURE_TABLE_BAN_RELEASE','PRAISE_BAN_RELEASE','COMPLAIN_BAN_RELEASE');
update tab_operate set OPERATE_NAME = '放开评论' where OPERATE_NO in ('FLEA_MARKET_UNDO','EXPOSURE_TABLE_UNDO');
delete from tab_role_operate where operate_uuid in ('81404965f2954cf5b3b8c5de6a2de86c','01d23ba564e344b79efb274e6e9c6e16','19f6e4e442154458835bcbbdcfc433d3','102f230c4c1b42ddbc48c0c075e8e6ea');
delete from tab_operate where uuid in ('81404965f2954cf5b3b8c5de6a2de86c','01d23ba564e344b79efb274e6e9c6e16','19f6e4e442154458835bcbbdcfc433d3','102f230c4c1b42ddbc48c0c075e8e6ea');
---------------------------二阶段后期新增脚本--end----------------------------------

---------------------------2018-09-09-----------------------------------
--合理化建议增加回复操作
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('d59b1aae6112d56739d092e470542c59', '8f78369341404a67a8938b8d7b58abde', 'fe755fa4bd25475fa1a9d841caa16f44', 'priv.guochun.psmc.website.backstage.report.service.ReportService', 'executeReplyReportBusinessMethod', 'INFO_ADVICE_REPLY', '回复', '回复', 45);
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', 'd59b1aae6112d56739d092e470542c59');


---------------------------------------------------2018-09-13---------------------------------------------------
drop table tab_function_explain;
--功能说明表
create table tab_function_explain
(
      explain_uuid varchar(64) not null comment '功能说明uuid',
      function_code varchar(20) comment '功能编码',
      function_name varchar(50) comment '功能名称',
      expain_content varchar(2000) comment '说明内容',
      primary key (explain_uuid)
);

--初始化功能名称到字典表
delete from tab_data_dict where DICT_NO = 'FUNCTION_NAME';
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('1', '留言报修', '功能名称', 12, 1, 1, 'FUNCTION_NAME');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('2', '我要建议', '功能名称', 12, 2, 2, 'FUNCTION_NAME');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('3', '我要投诉', '功能名称', 12, 3, 3, 'FUNCTION_NAME');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('4', '我要表扬', '功能名称', 12, 4, 4, 'FUNCTION_NAME');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('5', '创新工作室', '功能名称', 12, 5, 5, 'FUNCTION_NAME');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('6', '文体协会', '功能名称', 12, 6, 6, 'FUNCTION_NAME');

--增加菜单
delete from tab_role_resource where resource_id = '1fd48b934d5d4976bc23fbf904840d78';
delete from tab_resource where uuid = '1fd48b934d5d4976bc23fbf904840d78';
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum, is_view) VALUES ('1fd48b934d5d4976bc23fbf904840d78', '功能提示管理', 3, '/jsp/system/common/explain/functionExplain.jsp', 'f55580fa321b4d34a172628d5825c4dc', 'admin', '2018-09-13 23:30:08', '菜单', 17, 1);
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('efb74820f0564d02bb68fdf3190a6430', '1fd48b934d5d4976bc23fbf904840d78');


update tab_resource set resource_name='大院文明角' where uuid='9dcf22db90c74e96b4e6c16da7ed84fd';
update tab_operate set operate_desc='信息列表' where uuid='91b54f3f2ee24ba9a88ee26f0ddabbba';
update tab_resource set resource_name='后勤服务中心' where uuid='769a2c0484dd43749ed12b607102d688';
update tab_resource set resource_name='意见建议' where uuid='6293f053281f459ea4f7402e2f90c365';
update tab_resource set resource_name='大院早知道' where uuid='f03a9f0f29d44a1da4376353809eb9e1';


update tab_block set tab_block='大院文明角' where block_uuid='02';

--曝光台增加操作按钮
delete from tab_role_operate where operate_uuid in ('82b0459bd3044f4794ff579afc250442', 'a708045dcd454491b847bf5b3e48de0a');
delete from tab_operate where uuid in ('82b0459bd3044f4794ff579afc250442', 'a708045dcd454491b847bf5b3e48de0a');
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('82b0459bd3044f4794ff579afc250442', '9dcf22db90c74e96b4e6c16da7ed84fd', 'fe755fa4bd25475fa1a9d841caa16f44', 'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService', 'saveOrUpdateBusinessMethod', 'EXPOSURE_TABLE_UPDATE', '修改', '修改', 8);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('a708045dcd454491b847bf5b3e48de0a', '9dcf22db90c74e96b4e6c16da7ed84fd', '607e8bc6f9bb4afa9be3cfdc72a1a326', 'priv.guochun.psmc.website.backstage.topics.service.TabTopicsService', 'saveOrUpdateBusinessMethod', 'EXPOSURE_TABLE_ADD', '新增', '新增', 9);
INSERT INTO tab_role_operate(role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '82b0459bd3044f4794ff579afc250442');
INSERT INTO tab_role_operate(role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', 'a708045dcd454491b847bf5b3e48de0a');

alter table tab_dept add latest_news varchar(5000) comment '最新消息'; 
alter table tab_function_explain add explain_title varchar(500) comment '标题名称'; 
delete from tab_data_dict where DICT_ID='1404' and DICT_NO='INFO_TYPE';

--维护报修 查看详细功能脚本
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('cb8f490b3efa4779bafc043e3291b025', 'ad705f6bb26948609e1aa55e86330d05', '756d6e80c9d74b4389c918ab50ee19c3', 'priv.guochun.psmc.website.backstage.report.service.ReportService', 'findReportByUuidBusinessMethod', '', '查询查询明细', '查询明细信息', 39);
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', 'cb8f490b3efa4779bafc043e3291b025');


INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('1406', '转载', '早知道管理分类', 10, 6, 6, 'INFO_TYPE');

