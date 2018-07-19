alter table tab_person drop column groupid;
/**增加用户所属组ID*/
alter table tab_person add groupid varchar(100) ;

update  TAB_PERSON b set b.groupid='10000'; 


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



/**日志一级分类数据字典*/
delete from TAB_DATA_DICT where DICT_NO='LOG_TYPE' or DICT_NO='LOG_SUB_TYPE';

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1','工作流业务','日志一级分类',5,1,'LOG_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'2','系统操作','日志一级分类',5,2,'LOG_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(3,'3','接口交互','日志一级分类',5,3,'LOG_TYPE');

/**日志二级分类数据字典*/
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1.1','流程发起','日志二级分类',6,1,'LOG_SUB_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'2.1','登录','日志二级分类',6,2,'LOG_SUB_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(3,'2.2','登出','日志二级分类',6,3,'LOG_SUB_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(4,'2.3','日常操作','日志二级分类',6,4,'LOG_SUB_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(5,'3.1','短信接口日志','日志二级分类',6,5,'LOG_SUB_TYPE');




/**日志列表菜单*/
delete from tab_role_resource where resource_id='6b5de11e5c0e4a53aad76f74fd6a1df6';
delete from tab_resource where uuid='6b5de11e5c0e4a53aad76f74fd6a1df6';

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('6b5de11e5c0e4a53aad76f74fd6a1df6','日志列表',3,'/jsp/system/common/log/sysOperLog_list.jsp','f55580fa321b4d34a172628d5825c4dc','admin',str_to_date('2018-6-6','%Y-%m-%d %T'),'菜单',16,1);


insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '6b5de11e5c0e4a53aad76f74fd6a1df6');






/**初始化组织机构*/


DELETE FROM tab_group;

INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('e30f6d26f09646aaa18460c086a206da', '陕西省测绘地理信息局', 1, '10000', null, 'admin','2018-6-8 00:00:00' , '根目录', 1);

INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('c07266dcbdbf4ba3b5ba44bdc2769d71', '陕西省第一测绘工程院', 2, '1000001', '10000', 'admin','2018-6-8 00:00:00' , '单位', 2);

--INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
--    VALUES('a2497358e5874ca3ad6f2c7e969dc778', '大地测量职工创新工作室', 3, '100000101', '1000001', 'admin','2018-6-8 00:00:00' , '部门', 3);


INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('a883e8e647d74b99989294b79f5f2d38', '陕西省第二测绘工程院', 2, '1000002', '10000', 'admin','2018-6-8 00:00:00' , '单位', 4);

--INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
--    VALUES('44c8a26562b1412d8bfc9fdf521eaf05', 'GEO+职工创新工作室', 3, '100000201', '1000002', 'admin','2018-6-8 00:00:00' , '部门', 5);


INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('3440e5df5216443aaff1c5517d5a9de2', '陕西省第三测绘工程院', 2, '1000003', '10000', 'admin','2018-6-8 00:00:00' , '单位', 6);

--INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
--    VALUES('1a319870604f4657b2b64c9301dedfb7', '工程测量职工创新工作室', 3, '100000301', '1000003', 'admin','2018-6-8 00:00:00' , '部门', 7);


INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('54ff62ab2211477a9557bc56551b9e61', '陕西省第四测绘工程院', 2, '1000004', '10000', 'admin','2018-6-8 00:00:00' , '单位', 8);

--INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
--    VALUES('b0675dcd4502457c8b5ed54ec5d64ca0', '大地测量数据处理职工创新工作室', 3, '100000401', '1000004', 'admin','2018-6-8 00:00:00' , '部门', 9);


INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('8c0bbe74086c408cb27d2b52e0bc0c25', '陕西省第五测绘工程院', 2, '1000005', '10000', 'admin','2018-6-8 00:00:00' , '单位', 10);

--INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
--    VALUES('7a816ca0ded34dceb07fcdaa75fac716', '遥感技术应用职工创新工作室', 3, '100000501', '1000005', 'admin','2018-6-8 00:00:00' , '部门', 11);


INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('389479b39cf6431f9c18da5e459ba945', '陕西省第六测绘地理信息工程院', 2, '1000006', '10000', 'admin','2018-6-8 00:00:00' , '单位', 12);

--INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
--    VALUES('1457290efc9f4c9796ffa70a466d420e', '地图科学职工创新工作室', 3, '100000601', '1000006', 'admin','2018-6-8 00:00:00' , '部门', 13);


INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('5a814082143c4c3d8383b350e3e3dba0', '陕西省基础地理信息中心', 2, '1000007', '10000', 'admin','2018-6-8 00:00:00' , '单位', 14);

--INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
--    VALUES('b2e6945a3e184a3b945d373af3567657', '天地图陕西职工创新工作室', 3, '100000701', '1000007', 'admin','2018-6-8 00:00:00' , '部门', 15);


INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('0e4f1b7cc53247859cacf32c28ebc984', '国测测绘标准化研究所', 2, '1000008', '10000', 'admin','2018-6-8 00:00:00' , '单位', 16);


INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('460db5f43b7e46899cff465429c07185', '陕西测绘地理信息局后勤服务中心', 2, '1000009', '10000', 'admin','2018-6-8 00:00:00' , '单位', 17);


INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('001bcc4742ca4a6a96a8630b0b6d9780', '西测绘地理信息局劳动就业服务中心', 2, '1000010', '10000', 'admin','2018-6-8 00:00:00' , '单位', 18);



INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('154ed9e2f5f44cf1bc9b4a75a8697b01', '陕西省测绘产品质量监督检验站', 2, '1000011', '10000', 'admin','2018-6-8 00:00:00' , '单位', 19);

--INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
--    VALUES('0fed2e1ce84f46b2b907e3d430d0b22d', '测绘质检职工创新工作室', 3, '100001101', '1000011', 'admin','2018-6-8 00:00:00' , '部门', 20);


INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('a0478f88ddd14070bb10947bd63d6db8', '西测绘地理信息局测绘开发服务中心', 2, '1000012', '10000', 'admin','2018-6-8 00:00:00' , '单位', 21);

INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('bf33af3542074bdea53b69d962be030c', '西北测绘职工培训中心', 2, '1000013', '10000', 'admin','2018-6-8 00:00:00' , '单位', 22);

INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('d893c1734cc74513b84711a0e69c329f', '西安地图出版社', 2, '1000014', '10000', 'admin','2018-6-8 00:00:00' , '单位', 23);

INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('26259f2cce9d427a9d69744b38fd9882', '陕西测绘地理信息局机关', 2, '1000015', '10000', 'admin','2018-6-8 00:00:00' , '单位', 24);
    
/**订阅号网站用户虚拟组*/

INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum) 
    VALUES('bcd9ba7b601343daa4a0c68c80bd0d57', '用户虚拟组(勿删)', 2, '1000016', '10000', 'admin','2018-6-8 00:00:00' , '单位', 25);


/**用户组列表菜单*/

delete from tab_role_operate where operate_uuid='cf083ec8d0a24a9a94798fe897d1fcf1';
delete from tab_role_operate where operate_uuid='05e5d3c16d054483ab95c4892c33979d';
delete from tab_role_operate where operate_uuid='952197c168944aa19d0930f383eeae5c';
delete from tab_role_operate where operate_uuid='2bc28c4901fc4e169ba1fa10abaf95d1';
delete from tab_role_operate where operate_uuid='f27181121e0f4de6aaac05468a3cff3f';


delete from tab_operate where uuid='cf083ec8d0a24a9a94798fe897d1fcf1';
delete from tab_operate where uuid='05e5d3c16d054483ab95c4892c33979d';
delete from tab_operate where uuid='952197c168944aa19d0930f383eeae5c';
delete from tab_operate where uuid='2bc28c4901fc4e169ba1fa10abaf95d1';
delete from tab_operate where uuid='f27181121e0f4de6aaac05468a3cff3f';


delete from tab_role_resource where resource_id='a75345fa89e5409684a2795eed7f5900';
delete from tab_resource where uuid='a75345fa89e5409684a2795eed7f5900';

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('a75345fa89e5409684a2795eed7f5900','用户组',3,'/jsp/authentication/user/tab_group_tree.jsp','deab504ee54b4f10b65fb17c7615ab9c','admin',str_to_date('2018-6-8','%Y-%m-%d %T'),'菜单',17,1);

insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'a75345fa89e5409684a2795eed7f5900');

/*用户组操作*/

/**查询*/
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('cf083ec8d0a24a9a94798fe897d1fcf1','a75345fa89e5409684a2795eed7f5900','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.authentication.user.service.TabGroupService','getTabGroupsBusinessMethod','[查询]','',1,'USER_GROUP_QUERY');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','cf083ec8d0a24a9a94798fe897d1fcf1');

/**修改名称*/

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('05e5d3c16d054483ab95c4892c33979d','a75345fa89e5409684a2795eed7f5900','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.authentication.user.service.TabGroupService','updateParentGroupCodeBusinessMethod','[归属组修改]','',2,'USER_GROUP_PARENT_UPDATE');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','05e5d3c16d054483ab95c4892c33979d');


/*新增*/
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('952197c168944aa19d0930f383eeae5c','a75345fa89e5409684a2795eed7f5900','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.authentication.user.service.TabGroupService','saveTabGroupBusinessMethod','[新增]','',3,'USER_GROUP_ADD');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','952197c168944aa19d0930f383eeae5c');

/*修改*/
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('2bc28c4901fc4e169ba1fa10abaf95d1','a75345fa89e5409684a2795eed7f5900','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.authentication.user.service.TabGroupService','updateTabGroupBusinessMethod','[修改]','',4,'USER_GROUP_UPDATE');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','2bc28c4901fc4e169ba1fa10abaf95d1');

/*删除*/
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('f27181121e0f4de6aaac05468a3cff3f','a75345fa89e5409684a2795eed7f5900','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.authentication.user.service.TabGroupService','deleteTabGroupBusinessMethod','[删除]','',5,'USER_GROUP_DEL');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','f27181121e0f4de6aaac05468a3cff3f');


/**资源类型数据字典*/
delete from TAB_DATA_DICT where DICT_NO='TAB_RESOURCE_TYPE';

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1','系统','用户组类型',7,1,'TAB_RESOURCE_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'2','模块','用户组类型',7,2,'TAB_RESOURCE_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'3','菜单','用户组类型',7,3,'TAB_RESOURCE_TYPE');


/**用户组类型数据字典*/


delete from TAB_DATA_DICT where DICT_NO='USER_GROUP_TYPE';

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1','根目录','用户组类型',8,1,'USER_GROUP_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'2','单位','用户组类型',8,1,'USER_GROUP_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'3','部门','用户组类型',8,2,'USER_GROUP_TYPE');



/**订阅号网站用户角色*/
delete from tab_role where uuid ='e8d791272c7e437c8f8a72355bb0c231';
insert into tab_role (uuid, role_no, role_name, creator, create_time, remark) 
values('e8d791272c7e437c8f8a72355bb0c231','WECHAT_USER','订阅号网站用户角色','admin',str_to_date('2018-6-10','%Y-%m-%d %T'),'请勿删除');



    
