delete from tab_data_dict where dict_no='SMS_BUSNIESS_TYPE';
delete from tab_data_dict where dict_no='NOTICE_TYPE';


INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO,PARENT_DICT_TYPE) VALUES ('1', '消费类', '花城短信分类', 13, 1, 1, 'SMS_BUSNIESS_TYPE1',null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO,PARENT_DICT_TYPE) VALUES ('2', '推广类', '花城短信分类', 14, 2, 2, 'SMS_BUSNIESS_TYPE2',null);


INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO,PARENT_DICT_TYPE) VALUES ('1', '金额消费', '短信类型', 12, 1, 1, 'NOTICE_TYPE',13);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO,PARENT_DICT_TYPE) VALUES ('2', '项目消费', '短信类型', 12, 2, 2, 'NOTICE_TYPE',13);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO,PARENT_DICT_TYPE) VALUES ('3', '充值', '短信类型', 12, 3, 3, 'NOTICE_TYPE',13);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO,PARENT_DICT_TYPE) VALUES ('4', '卡余一类', '短信类型', 12, 4, 4, 'NOTICE_TYPE',14);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO,PARENT_DICT_TYPE) VALUES ('5', '卡余二类', '短信类型', 12, 5, 5, 'NOTICE_TYPE',14);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO,PARENT_DICT_TYPE) VALUES ('6', '卡余三类', '短信类型', 12, 6, 6, 'NOTICE_TYPE',14);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO,PARENT_DICT_TYPE) VALUES ('7', '未体验一类', '短信类型', 12, 7, 7, 'NOTICE_TYPE',14);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO,PARENT_DICT_TYPE) VALUES ('8', '未体验二类', '短信类型', 12, 8, 8, 'NOTICE_TYPE',14);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO,PARENT_DICT_TYPE) VALUES ('9', '专属福利', '短信类型', 12, 9, 9, 'NOTICE_TYPE',14);

insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values
('1080b68d54eb45e1b547dc0e5b26d418','卡余体验列表',3,'/website/backstage/EvauateInfoController.do?method=toEvaluateInfoList&smsBusniessType=14','e2ab21ca3bd14c92b0b9bf158e34a8fc','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'消息池列表',1,1);

insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '1080b68d54eb45e1b547dc0e5b26d418');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
('b12e459543e243b5a4eb93783b0f9c7d','1080b68d54eb45e1b547dc0e5b26d418','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.questionnaire.service.TabEvaluateInfoService','insertEvaluateInfoBusinessMethod','新增','新增',1  ,'SJHC_ADD_EVALUATE');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
('d551812af0c945978e2d0be1643e5709','1080b68d54eb45e1b547dc0e5b26d418','d3ad7cefb81040ac8c935e7ee5602f5c',
'priv.guochun.psmc.website.backstage.questionnaire.service.TabEvaluateInfoService','saveExcelEvaluateBusinessMethod','导入','导入',2  ,'SJHC_IMPORT_EXCEL');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'b12e459543e243b5a4eb93783b0f9c7d');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'd551812af0c945978e2d0be1643e5709');

