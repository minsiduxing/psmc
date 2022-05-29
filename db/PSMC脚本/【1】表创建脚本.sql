DROP TABLE tab_count;
 create table tab_count(
        minutes int default 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE tab_role_operate;
DROP TABLE tab_role_resource;
DROP TABLE tab_acc_role;
DROP TABLE tab_person;
DROP TABLE tab_accounts;
DROP TABLE tab_city;
DROP TABLE tab_data_dict;
DROP TABLE tab_operate;
DROP TABLE tab_privilege;
DROP TABLE tab_resource;
DROP TABLE tab_role;
drop table tab_navigation_bar;


CREATE TABLE tab_city (CITY_ID varchar(50), CITY_NAME varchar(50), PARENT_ID varchar(50), REMARK varchar(20), ORDERNUM int, CITY_LAYER int) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE tab_data_dict (DICT_ID varchar(100), DICT_NAME varchar(100), REMARK varchar(100), DICT_TYPE int, ORDERNUM int, id int(10), DICT_NO varchar(100)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE tab_accounts (uuid varchar(100) NOT NULL, account_name varchar(100), account_pass varchar(100), is_locked varchar(10), PRIMARY KEY (uuid), INDEX index_accloginname (account_name)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE tab_person (uuid varchar(100) NOT NULL, person_name varchar(100), sex int(2), age int(3) DEFAULT '0', telephone varchar(100), email varchar(100), acc_uuid varchar(100), city_id varchar(20), PRIMARY KEY (uuid), INDEX fk_tab_pers_fk1_tab_acco (acc_uuid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE tab_role (uuid varchar(100) NOT NULL, role_no varchar(100), role_name varchar(100), creator varchar(100), create_time timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, remark varchar(400), PRIMARY KEY (uuid), INDEX index_roleno (role_no)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE tab_acc_role (acc_uuid varchar(100) NOT NULL, role_uuid varchar(100) NOT NULL, PRIMARY KEY (role_uuid, acc_uuid), INDEX fk_tab_acc__fk2_tab_acco (acc_uuid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE tab_resource (uuid varchar(100) NOT NULL, resource_name varchar(200), resource_type int, resource_url varchar(1000), parent_resource_uuid varchar(100), creator_name varchar(200), create_time timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, remark varchar(400), ordernum int(10), PRIMARY KEY (uuid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE tab_role_resource (role_id varchar(100) NOT NULL, resource_id varchar(100) NOT NULL, PRIMARY KEY (role_id, resource_id), INDEX fk_tab_role_fk9_tab_reso (resource_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE tab_privilege (uuid varchar(100) NOT NULL, privilege_id varchar(200), privilege_name varchar(200), remark varchar(400), creator_name varchar(200), creator_time timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, PRIMARY KEY (uuid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE tab_operate (uuid varchar(100) NOT NULL, resource_uuid varchar(100) NOT NULL, privilege_uuid varchar(100) NOT NULL, fun_class varchar(200), fun_method varchar(200), OPERATE_NO varchar(200) NOT NULL, OPERATE_NAME varchar(200), OPERATE_DESC varchar(400), ORDERNUM int, PRIMARY KEY (uuid), INDEX fk_tab_oper_fk5_tab_reso (resource_uuid), INDEX fk_tab_oper_fk7_tab_priv (privilege_uuid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE tab_role_operate (role_uuid varchar(100) NOT NULL, operate_uuid varchar(100) NOT NULL, PRIMARY KEY (role_uuid, operate_uuid), INDEX fk_tab_role_fk6_tab_oper (operate_uuid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table tab_navigation_bar(menu_uuid varchar(100) not null,menu_name varchar(200),menu_url varchar(400),parent_menu_uuid varchar(100),open_type varchar(20) comment 'window.openwindow.location.href',remark  varchar(400),ordernum   numeric(5,0),is_locked  numeric(1,0) comment '1是   2否',primary key (menu_uuid));





ALTER TABLE tab_acc_role ADD CONSTRAINT fk_tab_acc__fk2_tab_acco FOREIGN KEY (acc_uuid) REFERENCES tab_accounts (uuid) ;
ALTER TABLE tab_acc_role ADD CONSTRAINT fk_tab_acc__fk3_tab_role FOREIGN KEY (role_uuid) REFERENCES tab_role (uuid);
ALTER TABLE tab_operate ADD CONSTRAINT fk_tab_oper_fk5_tab_reso FOREIGN KEY (resource_uuid) REFERENCES tab_resource (uuid) ;
ALTER TABLE tab_operate ADD CONSTRAINT fk_tab_oper_fk7_tab_priv FOREIGN KEY (privilege_uuid) REFERENCES tab_privilege (uuid);
ALTER TABLE tab_person ADD CONSTRAINT fk_tab_pers_fk1_tab_acco FOREIGN KEY (acc_uuid) REFERENCES tab_accounts (uuid);
ALTER TABLE tab_role_operate ADD CONSTRAINT fk_tab_role_fk4_tab_role FOREIGN KEY (role_uuid) REFERENCES tab_role (uuid) ;
ALTER TABLE tab_role_operate ADD CONSTRAINT fk_tab_role_fk6_tab_oper FOREIGN KEY (operate_uuid) REFERENCES tab_operate (uuid);
ALTER TABLE tab_role_resource ADD CONSTRAINT fk_tab_role_fk8_tab_role FOREIGN KEY (role_id) REFERENCES tab_role (uuid) ;
ALTER TABLE tab_role_resource ADD CONSTRAINT fk_tab_role_fk9_tab_reso FOREIGN KEY (resource_id) REFERENCES tab_resource (uuid);


--创建模块相关表
----模块表
DROP TABLE IF EXISTS tab_module;
CREATE TABLE tab_module (
  uuid varchar(100) NOT NULL,
  create_acc_uuid varchar(100) DEFAULT NULL,
  create_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modify_acc_uuid varchar(100) DEFAULT NULL,
  modify_date timestamp NULL DEFAULT NULL,
  audit decimal(10,0) DEFAULT NULL,
  audit_acc_uuid varchar(100) DEFAULT NULL,
  audit_date timestamp NULL DEFAULT NULL,
  release_acc_uuid varchar(100) DEFAULT NULL,
  release_date timestamp NULL DEFAULT NULL,
  one_level_classify varchar(20) DEFAULT NULL COMMENT '参考数据字典one_level classify',
  two_level_classify varchar(20) DEFAULT NULL COMMENT '参考数据字典two_level classify',
  release_status varchar(20) DEFAULT NULL,
  PRIMARY KEY (uuid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
---模块发布表
DROP TABLE IF EXISTS tab_module_publish;
CREATE TABLE tab_module_publish (
  publish_uuid varchar(100) NOT NULL,
  module_uuid varchar(100) DEFAULT NULL,
  publish_date timestamp NULL DEFAULT NULL,
  publish_expire_date timestamp NULL DEFAULT NULL,
  publish_account_uuid varchar(100) DEFAULT NULL,
  PRIMARY KEY (publish_uuid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-----新闻相关表
DROP TABLE IF EXISTS tab_news;
CREATE TABLE tab_news (
  uuid varchar(100) NOT NULL,
  news_title varchar(400) DEFAULT NULL,
  news_subtitle varchar(300) DEFAULT NULL,
  news_content varchar(3000) CHARACTER SET utf8mb4 DEFAULT NULL,
  news_date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  news_author varchar(200) DEFAULT NULL,
  thumbnail_image_url varchar(200) DEFAULT NULL,
  news_abstract varchar(500) DEFAULT NULL,
  image_path varchar(200),
  PRIMARY KEY (uuid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table tab_resource add column is_view integer  comment '是否展示?1是2否';  
alter table tab_news modify column news_content text  CHARACTER SET utf8mb4 DEFAULT NULL;

----优秀创新成果表
drop table tab_excellent_innovation;
create table tab_excellent_innovation 
(
        innovation_uuid varchar(32) not null comment '主键UUID',
        org_name varchar(128) comment '所属单位名称',
        declare_person varchar(100) comment '申报负责人姓名',
        declare_phone varchar(20) comment '申报负责人电话',
        declare_email varchar(100) comment '申报负责人邮箱',
        first_complete_person varchar(100) comment '第一完成人姓名',
        sex int comment '性别',
        education varchar(100) comment '学历',
        job varchar(100) comment '职务',
        dept_name varchar(100) comment '所在部门',
        major varchar(200) comment '专业或特长',
        occupation int comment '职业身份',
        other_complete_person varchar(200) comment '其他完成人',
        achievement_name varchar(200) comment '成果名称',
        achievement_form int comment '体现形式',
        realized_value varchar(1024) comment '实现价值',
        application_generalize varchar(1024) comment '应用推广',
        innovation_date timestamp comment '创新时间',
        achievement_content text COLLATE utf8mb4_general_ci comment '成果内容',
        recommend_remark varchar(200) comment '推荐人意见',
        recommend_date timestamp comment '推荐时间',
        audit_remark varchar(200) comment '审核意见',
        audit_date timestamp comment '审核时间',
        image_path varchar(200) comment '优秀创新配图',
        constraint tab_excellent_innovation primary key (innovation_uuid)
) comment '优秀创新成果申报表';


-- 浏览量记录表
drop table tab_page_view;
create table tab_page_view
(
        uuid varchar(64) not null comment '主键UUID(对应信息ID)',
        nums int comment '浏览量',
        constraint tab_page_view primary key (uuid)
) comment '浏览量记录表';

--活动管理信息表
drop table tab_activity_manage;
create table tab_activity_manage
(
        activity_uuid varchar(32) not null comment '活动管理主键',
        activity_name varchar(100) comment '活动名称',
        activity_content text COLLATE utf8mb4_general_ci comment '活动内容',
        start_date timestamp comment '活动开始时间',
        end_date timestamp comment '活动结束时间',
        create_date timestamp comment '活动创建时间',
        create_person varchar(100) comment '活动创建人',
        sign_up_end_date timestamp comment '报名截止日期',
        image_path varchar(200) comment '活动配图',
        constraint tab_activity_manage primary key (activity_uuid)
) comment '活动管理表';

--报名信息表
drop table tab_sign_up_info;
create table tab_sign_up_info
(
        sign_up_uuid varchar(32) not null comment '报名信息主键',
        activity_uuid varchar(32) not null comment '活动管理主键',
        person_account varchar(100) comment '报名人账号ID',
        person_name varchar(50) comment '报名人姓名',  
        person_mobile varchar(20) comment '报名人电话',
        sign_up_date timestamp  comment '报名时间',
        constraint tab_sign_up_info primary key (sign_up_uuid)
) comment '报名信息表';


alter table tab_data_dict add column PARENT_DICT_TYPE INT(5);

/************************************20220303sjhc增加*********************************************/
alter table tab_evaluate_info add column vaild_date date COMMENT  '有效期';
alter table tab_evaluate_info add column vip_remark varchar(100) COMMENT  '专享描述';
alter table tab_evaluate_info add column butler varchar(100) COMMENT  '管家';
ALTER TABLE tab_evaluate_info modify COLUMN notice_note varchar(500) COMMENT '通知参数';
ALTER TABLE tab_evaluate_info add COLUMN notice_content varchar(500) COMMENT '通知内容';
ALTER TABLE tab_evaluate_info add COLUMN other_remark varchar(500) COMMENT '其余描述';