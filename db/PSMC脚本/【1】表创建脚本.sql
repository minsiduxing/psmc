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


/**创建模块相关表**/
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
/**模块发布表**/
DROP TABLE IF EXISTS tab_module_publish;
CREATE TABLE tab_module_publish (
                                    publish_uuid varchar(100) NOT NULL,
                                    module_uuid varchar(100) DEFAULT NULL,
                                    publish_date timestamp NULL DEFAULT NULL,
                                    publish_expire_date timestamp NULL DEFAULT NULL,
                                    publish_account_uuid varchar(100) DEFAULT NULL,
                                    PRIMARY KEY (publish_uuid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/**新闻相关表**/
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

/**优秀创新成果表**/
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


/**浏览量记录表**/
drop table tab_page_view;
create table tab_page_view
(
    uuid varchar(64) not null comment '主键UUID(对应信息ID)',
    nums int comment '浏览量',
    constraint tab_page_view primary key (uuid)
) comment '浏览量记录表';

/**活动管理信息表**/
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

/**报名信息表**/
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


drop table if exists tab_questionnaire;

/*==============================================================*/
/* Table: table_questionnaire                                   */
/*==============================================================*/
create table tab_questionnaire
(
    questionnaire_uuid   varchar(100) comment '问卷uuid',
    questionnaire_name   varchar(200) comment '问卷名称',
    version              smallint comment '问卷版本',
    is_enable            smallint comment '是否启用',
    create_person        varchar(200) comment '创建人',
    create_time          timestamp comment '创建时间',
    primary key (questionnaire_uuid)
);


drop table if exists tab_subject_config;

/*==============================================================*/
/* Table: tab_subject_config                                    */
/*==============================================================*/
create table tab_subject_config
(
    subject_uuid         varchar(100) not null comment '主键',
    questionnaire_uuid   varchar(100) comment '问卷id',
    subject_name         varchar(500) comment '题目名称',
    subject_order        smallint comment '题目排序',
    subject_type         smallint comment '数据字典：SUBJECT_TYPE:
            1、输入框
            2、单选框
            3、多选框
            4、下拉框
            5、文本框
            6、星级',
    primary key (subject_uuid)
);


drop table if exists tab_evaluate_info;

/*==============================================================*/
/* Table: tab_evaluate_info                                     */
/*==============================================================*/
CREATE TABLE
    tab_evaluate_info
(
    evaluate_info_uuid VARCHAR(100) NOT NULL COMMENT '主键',
    questionnaire_uuid VARCHAR(100) COMMENT '问卷id',
    evaluate_name VARCHAR(20) COMMENT '客户姓名',
    evaluate_phone VARCHAR(11) COMMENT '客户电话',
    evaluate_nick_name VARCHAR(20) COMMENT '客户昵称',
    consumption_date DATE COMMENT '消费时间',
    consumption_amount DECIMAL COMMENT '消费金额',
    surplus_amount DECIMAL COMMENT '剩余金额',
    surplus_score INT COMMENT '剩余积分',
    surplus_number INT COMMENT '剩余次数',
    recharge_amount DECIMAL COMMENT '充值金额',
    consumption_item VARCHAR(100) COMMENT '消费项目',
    evaluate_notice_type SMALLINT COMMENT '通知类型(1：消费金额，2：消费项目，3：充值)',
    input_acc_uuid VARCHAR(100) COMMENT '信息录入人',
    input_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON
        UPDATE
        CURRENT_TIMESTAMP COMMENT '信息录入时间',
    visit_url VARCHAR(500) COMMENT '回访页面url',
    visit_short_url VARCHAR(50) COMMENT '回访页面短链接url',
    notice_note VARCHAR(500) COMMENT '通知内容',
    is_enable_notice SMALLINT COMMENT '是否启动通知',
    notice_time DATETIME COMMENT '启动通知时间',
    evaluate_status SMALLINT COMMENT
        '数据字典：
1、待评价
2、已评价
3、无
4、发送失败',
    effective_end_date DATETIME COMMENT '回访截止时间',
    evaluate_time DATETIME COMMENT '评价时间',
    PRIMARY KEY (evaluate_info_uuid)
);



drop table if exists tab_subject_options;

/*==============================================================*/
/* Table: table_subject_options                                 */
/*==============================================================*/
create table tab_subject_options
(
    options_uuid         varchar(100) not null comment '主键',
    subject_uuid         varchar(100) comment '题目id',
    options_value        varchar(10) comment '选项值',
    options_name         varchar(200) comment '选项名称',
    primary key (options_uuid)
);


drop table if exists tab_subject_result;

/*==============================================================*/
/* Table: table_subject_result                                  */
/*==============================================================*/
create table tab_subject_result
(
    result_uuid          varchar(100) not null,
    subject_uuid         varchar(100) comment '题目id',
    evaluate_info_uuid   varchar(100) comment '评价信息id',
    result_value         varchar(1000) comment '提交的答案',
    primary key (result_uuid)
);


drop table tab_real_url;

CREATE TABLE
    tab_real_url
(
    id INT  auto_increment  NOT NULL,
    real_url VARCHAR(500) NOT NULL,
    PRIMARY KEY (id)
);


/************************************20220303sjhc增加*********************************************/
alter table tab_evaluate_info add column vaild_date date COMMENT  '有效期';
alter table tab_evaluate_info add column vip_remark varchar(100) COMMENT  '专享描述';
alter table tab_evaluate_info add column butler varchar(100) COMMENT  '管家';
ALTER TABLE tab_evaluate_info modify COLUMN notice_note varchar(500) COMMENT '通知参数';
ALTER TABLE tab_evaluate_info add COLUMN notice_content varchar(500) COMMENT '通知内容';
ALTER TABLE tab_evaluate_info add COLUMN other_remark varchar(500) COMMENT '其余描述';





DROP TABLE IF EXISTS `tab_message_black`;
CREATE TABLE `tab_message_black`  (
                                      `black_uuid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
                                      `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
                                      `reason` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '原因',
                                      `add_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
                                      PRIMARY KEY (`black_uuid`) USING BTREE
) ;


DROP TABLE IF EXISTS `tab_message_pool`;
CREATE TABLE `tab_message_pool`  (
                                     `msg_uuid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
                                     `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
                                     `temp_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模板code',
                                     `add_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
                                     PRIMARY KEY (`msg_uuid`) USING BTREE
) ;


DROP TABLE IF EXISTS `tab_message_temp`;
CREATE TABLE `tab_message_temp`  (
                                     `temp_uuid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
                                     `temp_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模板code',
                                     `temp_content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模板内容',
                                     `type` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型：0短信，1彩信',
                                     `add_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
                                     PRIMARY KEY (`temp_uuid`) USING BTREE
) ;


drop table tab_dept;
create table tab_dept(
                         dept_uuid varchar(32) not null comment '部门uuid',
                         dept_name varchar(100) not null comment '部门名称',
                         dept_introduction varchar(1000) comment '部门简介',
                         dept_regulation text COLLATE utf8mb4_general_ci comment '规范管理办法',
                         elegant_demeanour text COLLATE utf8mb4_general_ci comment '风采展示',
                         dept_type integer comment '部门类型（1创新工作室，2问题协会）',
                         create_person varchar(100) comment '创建人',
                         create_date timestamp  comment '创建时间',
                         last_modify_time timestamp comment '最后修改时间',
                         last_modify_person varchar(100) comment '最后修改人',
                         image_path VARCHAR(200) COMMENT '部门信息配图',
                         constraint tab_dept primary key (dept_uuid)
) comment '部门信息表';


alter table tab_activity_manage drop column dept_uuid;
alter table tab_excellent_innovation drop column dept_uuid;

alter table tab_activity_manage add dept_uuid varchar(32) comment '部门ID';
alter table tab_excellent_innovation add dept_uuid varchar(32) comment '部门ID';


alter table tab_person drop column groupid;
/**增加用户所属组ID*/
alter table tab_person add groupid varchar(100) ;

update  TAB_PERSON b set b.groupid='10000';
update tab_accounts t set t.account_pass='c4ca4238a0b923820dcc509a6f75849b';

/**系统日志表*/
drop table if exists t_sys_oper_log;

CREATE TABLE t_sys_oper_log (
                                uuid             	varchar(100) NULL,
                                log_sub_type_name	varchar(100) NULL,
                                log_sub_type     	decimal(5,2) NULL,
                                log_type_name    	varchar(100) NULL,
                                log_type         	decimal(5,2) NULL,
                                bussiness_uuid   	varchar(100) NULL,
                                operid           	varchar(64) NULL,
                                opername         	varchar(30) NULL,
                                oper_date        	timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                oper_input       	varchar(500) NULL,
                                oper_output      	varchar(500) NULL,
                                oper_result_desc 	varchar(100) NULL,
                                oper_result      	decimal(1,0) NULL
)
;



drop table if exists tab_verification_code;

/*==============================================================*/
/* Table: tab_verification_code                                 */
/*==============================================================*/
create table tab_verification_code
(
    uuid                 varchar(64) not null,
    type                 numeric,
    state                numeric comment '1、未使用
            2、已使用
            3、已过期',
    code                 varchar(100),
    create_time          timestamp,
    effective_time       numeric,
    phone varchar(15),
    primary key (uuid)
);


/**用户组*/
drop table if exists tab_group;

/*==============================================================*/
/* Table: tab_group                                             */
/*==============================================================*/
create table tab_group
(
    uuid                 varchar(100) not null,
    group_name           varchar(200),
    group_type           int comment '1、根目录。2、单位。3、部门',
    group_code           varchar(100),
    parent_group_code    varchar(100),
    creator_name         varchar(200),
    create_time          timestamp,
    remark               varchar(400),
    ordernum             numeric(10,0),
    primary key (uuid)
);

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

--增加账户分类
alter table tab_accounts drop column account_type;
alter table tab_accounts add column account_type TINYINT;

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

/**主题信息增加发布字段**/
alter table tab_topics add release_status INTEGER comment '发布状态';
alter table tab_topics add release_time TIMESTAMP NULL comment '发布时间';
alter table tab_topics add release_person_uuid varchar(64) comment '发布人id';

drop table tab_laud;
/**创建点赞表**/
create table tab_laud
(
    laud_uuid            varchar(100) not null comment '点赞主键',
    module_uuid          varchar(100) comment '点赞模型id',
    laud_date            timestamp comment '点赞时间',
    laud_person_uuid     varchar(64) comment '点赞人id',
    laud_person_name     varchar(100) comment '点赞人姓名',
    primary key (laud_uuid)
);

/**实名认证需新增的字段**/
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
CREATE TABLE
    tab_sys_key_info
(
    id INT NOT NULL,
    sys_key VARCHAR(255),
    sys_value VARCHAR(1000),
    remark VARCHAR(200),
    PRIMARY KEY (id)
)
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 DEFAULT COLLATE=utf8mb4_general_ci;

/*增加账户分类*/
alter table tab_accounts drop column account_type;
alter table tab_accounts add column account_type TINYINT;


/*新增字段*/
alter table tab_dept drop is_custom;
alter table tab_excellent_innovation drop is_custom;
alter table tab_activity_manage drop is_custom;
alter table tab_news drop is_custom;
alter table tab_dept add is_custom integer comment '是否自定义配图';
alter table tab_excellent_innovation add is_custom integer comment '是否自定义配图';
alter table tab_activity_manage add is_custom integer comment '是否自定义配图';
alter table tab_news add is_custom integer comment '是否自定义配图';
