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

-----------------------------------------------------------------------------------------------------
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('1', '金额消费', '消费类型', 12, 1, 1, 'NOTICE_TYPE');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('2', '项目消费', '消费类型', 12, 2, 2, 'NOTICE_TYPE');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('3', '充值', '消费类型', 12, 3, 3, 'NOTICE_TYPE');


INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('1', '待评价', '评价状态', 13, 1, 1, 'EVALUATE_STATUS');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('2', '已评价', '评价状态', 13, 2, 2, 'EVALUATE_STATUS');
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO) VALUES ('4', '发送失败', '评价状态', 13, 4, 4, 'EVALUATE_STATUS');
-----------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('05c8cface02b44cfbd8f906f791cf775','问卷调查',2,'','e51a8663876f4a3394bb194d89d96735','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'问卷调查',31,1);

insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('fde5fcdbb47c4ad693f26d8d13cb99ce','客户消费列表',3,'/website/backstage/EvauateInfoController.do?method=toEvaluateInfoList','05c8cface02b44cfbd8f906f791cf775','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'客户消费列表',1,1);


insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '05c8cface02b44cfbd8f906f791cf775');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'fde5fcdbb47c4ad693f26d8d13cb99ce');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('327a0f58abf24456a78fbb13906aed3a','fde5fcdbb47c4ad693f26d8d13cb99ce','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.questionnaire.service.TabEvaluateInfoService','insertEvaluateInfoBusinessMethod','新增','新增',1  ,'SJHC_ADD_EVALUATE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('8751d3b158fe4c7fb75ea032f23a43f1','fde5fcdbb47c4ad693f26d8d13cb99ce','d3ad7cefb81040ac8c935e7ee5602f5c',
'priv.guochun.psmc.website.backstage.questionnaire.service.TabEvaluateInfoService','saveExcelEvaluateBusinessMethod','导入','导入',2  ,'SJHC_IMPORT_EXCEL');



insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '327a0f58abf24456a78fbb13906aed3a');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '8751d3b158fe4c7fb75ea032f23a43f1');


----------------------------
----------------------------
--初始化问卷题目信息
 insert into tab_questionnaire (questionnaire_uuid, questionnaire_name,  version, is_enable, create_person, create_time)
                                 values ('e8be9919c09242ea928f7e3bdfc6b228', '顾客满意度调查表', 1, 1, '', CURRENT_TIMESTAMP);
                                 
insert into tab_subject_config (subject_uuid, questionnaire_uuid, subject_name,  subject_order, subject_type)
                                values ('99ad2665ff2c409990e17df4c011119c', 'e8be9919c09242ea928f7e3bdfc6b228', '接待人员的服务态度', 1,6);
 insert into tab_subject_config (subject_uuid, questionnaire_uuid, subject_name,  subject_order, subject_type)
                                values ('856861c932374a2d8ed4eba6920c8f41', 'e8be9919c09242ea928f7e3bdfc6b228', '芳疗师的手法及服务', 2, 6);
insert into tab_subject_config (subject_uuid, questionnaire_uuid, subject_name,  subject_order, subject_type)
                                values ('6b4226ac64124781b02208404ff245b0', 'e8be9919c09242ea928f7e3bdfc6b228', '芳疗师的形象气质', 3, 6);
insert into tab_subject_config (subject_uuid, questionnaire_uuid, subject_name,  subject_order, subject_type)
                                values ('65f205463e244242828ac96cc96e31b4', 'e8be9919c09242ea928f7e3bdfc6b228', '环境设施与整体感受', 4, 6);
insert into tab_subject_config (subject_uuid, questionnaire_uuid, subject_name,  subject_order, subject_type)
                                values ('d5690268600b4779be83128e7094cc4e', 'e8be9919c09242ea928f7e3bdfc6b228', '您在做SPA的过程中更希望', 5, 2);
insert into tab_subject_config (subject_uuid, questionnaire_uuid, subject_name,  subject_order, subject_type)
                                values ('0459acf22f7a4ff0a48ba13d93253f54', 'e8be9919c09242ea928f7e3bdfc6b228', '您的意见与建议', 6, 5);

                                
/*问题合并成一个总体评价*/                       
update tab_subject_config set subject_name='总体评价' where subject_uuid='99ad2665ff2c409990e17df4c011119c' and subject_name='接待人员的服务态度';