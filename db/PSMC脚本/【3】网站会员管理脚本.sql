/*==============================================================*/
/* 创建网站用户表                                         */
/*==============================================================*/
drop table tab_web_user;
create table tab_web_user
(
   uuid                 varchar(100) not null comment '主键标识',
   user_id              varchar(100) comment '用户名',
   password             varchar(100) comment '密码',
   user_name            varchar(100) comment '用户姓名',
   id_card              varchar(100) comment '身份证号',
   phone                varchar(100) comment '手机号码',
   primary key (uuid)
);

alter table tab_web_user comment '网站用户信息';

/*==============================================================*/
/* 会员信息添加操作配置                                        */
/*==============================================================*/

INSERT INTO tab_operate
VALUES
	(
		'a30b8feb609b4cd1a234ff7c53926ff4',
		'7ae04930c73643c8826b81239a2209e8',
		'607e8bc6f9bb4afa9be3cfdc72a1a326',
		'priv.guochun.psmc.website.backstage.webuser.TabWebUserService',
		'saveOrUpdateTabWebUser',
		'WEB_USER_ADD',
		'会员信息添加',
		'会员信息添加',
		'26'
	);

/*==============================================================*/
/* 会员信息修改操作配置                                         */
/*==============================================================*/

INSERT INTO tab_operate
VALUES
	(
		'754c852f09ed43ccbacdbe1f8af20d4b',
		'7ae04930c73643c8826b81239a2209e8',
		'fe755fa4bd25475fa1a9d841caa16f44',
		'priv.guochun.psmc.website.backstage.webuser.TabWebUserService',
		'saveOrUpdateTabWebUser',
		'WEB_USER_UPDATE',
		'会员信息修改',
		'会员信息修改',
		'28'
	);

/*==============================================================*/
/* 会员信息查询操作配置                                       */
/*==============================================================*/

INSERT INTO tab_operate
VALUES
	(
		'987d61c3dc4b4810978ccc1032183115',
		'7ae04930c73643c8826b81239a2209e8',
		'756d6e80c9d74b4389c918ab50ee19c3',
		'priv.guochun.psmc.website.backstage.webuser.TabWebUserService',
		'getWebUserList',
		'WEB_USER_QUERY',
		'会员信息查询',
		'会员信息查询',
		'29'
	);

/*==============================================================*/
/* 会员信息删除操作配置                                         */
/*==============================================================*/
	
INSERT INTO tab_operate
VALUES
	(
		'141bb03fbac14887a508ec6555c9fbde',
		'7ae04930c73643c8826b81239a2209e8',
		'dec3b327b8a54d66bd644c544ea65c5e',
		'priv.guochun.psmc.website.backstage.webuser.TabWebUserService',
		'deleteWebUsers',
		'WEB_USER_DELETE',
		'会员信息删除',
		'会员信息删除',
		'30'
	);

/*==============================================================*/
/* 会员信息导出操作配置                                         */
/*==============================================================*/

INSERT INTO tab_operate
VALUES
	(
		'72a078e29fbf449faf1d1021b301c0dc',
		'7ae04930c73643c8826b81239a2209e8',
		'460283cc3e2c4d0a8b6bbbd75698a339',
		'priv.guochun.psmc.website.backstage.webuser.TabWebUserService',
		'getWebUserList',
		'WEB_USER_EXPORT',
		'会员信息导出',
		'会员信息导出',
		'31'
	);
	
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', 'a30b8feb609b4cd1a234ff7c53926ff4');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '754c852f09ed43ccbacdbe1f8af20d4b');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '987d61c3dc4b4810978ccc1032183115');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '141bb03fbac14887a508ec6555c9fbde');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '72a078e29fbf449faf1d1021b301c0dc');
