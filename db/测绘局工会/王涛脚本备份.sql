
------------------------------------------工会订阅号新增初始化脚本-------------------------------------------------
--初始化角色
insert into tab_role (uuid, role_no, role_name, creator, create_time, remark) values ('111234ab9f8349c286c7314d944cec54','sys_innovate_studio_maintain','创新工作室维护人员','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'创新工作室维护人员角色');
insert into tab_role (uuid, role_no, role_name, creator, create_time, remark) values ('80ca03c782964effba241c2112485e1b','sys_union_maintain','工会维护人员','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'工会维护人员角色');
insert into tab_role (uuid, role_no, role_name, creator, create_time, remark) values ('b91d300182804a6eafa85a14698dbcef','sys_literary_form_maintain','文体协会维护人员','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'文体协会维护人员角色');
insert into tab_role (uuid, role_no, role_name, creator, create_time, remark) values ('17b40fc1df514e0d843f5b9a8964460c','sys_Logistics_center_maintain','后勤中心维护人员','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'后勤中心维护人员角色');

-------------------------------------------------------------------------------------------------------------------------
--初始化菜单
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('42a1745009b849c38743a08922da0c4f','创新工作室',2,'','e51a8663876f4a3394bb194d89d96735','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'创新工作室管理',31,1);
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('a365f66231c049169cbcc0d9572043ba','援助帮扶',2,'','e51a8663876f4a3394bb194d89d96735','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'援助帮扶管理',32,1);
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('8e059c578c204fbbb29086aa72ec88f9','文体协会',2,'','e51a8663876f4a3394bb194d89d96735','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'文体协会管理',33,1);
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('769a2c0484dd43749ed12b607102d688','后勤中心',2,'','e51a8663876f4a3394bb194d89d96735','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'后勤中心管理',34,1);
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('6293f053281f459ea4f7402e2f90c365','议事大厅',2,'','e51a8663876f4a3394bb194d89d96735','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'议事大厅管理',35,1);
--初始化菜单(创新工作室)
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('48711882b7e04641a5d8f4994a97ef5f','工作管理信息列表',3,'/website/backstage/InfoReleaseController.do?method=infoReleaseList&oneLevelClassify=11','42a1745009b849c38743a08922da0c4f','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'工作管理菜单',1,1);
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('c712464e336d4ae6988bd27ba35f17d4','优秀创新信息列表',3,'/website/backstage/ExcellentInnovationController.do?method=innovationList','42a1745009b849c38743a08922da0c4f','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'优秀创新菜单',3,1);
--初始化菜单(援助帮扶)
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('1b0cd1d267c948e2886ef98e5a76a578','法条维护信息列表',3,'/website/backstage/InfoReleaseController.do?method=infoReleaseList&oneLevelClassify=12','a365f66231c049169cbcc0d9572043ba','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'法条维护菜单',1,1);
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('aa1cb8b91b504dcfb2f7fa14cc94ac7c','法律援助',3,'','a365f66231c049169cbcc0d9572043ba','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'法律援助菜单',3,1);
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('115132658260463bb6f01b3108d11145','帮扶申报',3,'','a365f66231c049169cbcc0d9572043ba','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'帮扶申报菜单',4,1);
--初始化菜单(文体协会)
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('0b62d21d1ecd471f958d96b43471dcca','工作发布信息列表',3,'/website/backstage/InfoReleaseController.do?method=infoReleaseList&oneLevelClassify=13','8e059c578c204fbbb29086aa72ec88f9','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'工作发布菜单',1,1);
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('cae199e1e01f4bcf80ae2e2976fd15b9','活动管理信息列表',3,'/website/backstage/TabActivityManageController.do?method=activityList','8e059c578c204fbbb29086aa72ec88f9','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'活动管理',3,1);

--初始化菜单(后勤中心)
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('f03a9f0f29d44a1da4376353809eb9e1','早知道信息列表',3,'/website/backstage/InfoReleaseController.do?method=infoReleaseList&oneLevelClassify=14','769a2c0484dd43749ed12b607102d688','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'早知道菜单',1,1);
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('ad705f6bb26948609e1aa55e86330d05','维护报销',3,'','769a2c0484dd43749ed12b607102d688','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'维护报销菜单',7,1);
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('2108b5f2b4704a1b85ac0b2a596ded97','跳蚤市场',3,'','769a2c0484dd43749ed12b607102d688','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'跳蚤市场菜单',8,1);
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('9dcf22db90c74e96b4e6c16da7ed84fd','曝光台',3,'','769a2c0484dd43749ed12b607102d688','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'曝光台菜单',9,1);
--初始化菜单(议事大厅)
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('168f11a29d3545df9a74c3bb0f346915','合理化建议',3,'','6293f053281f459ea4f7402e2f90c365','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'合理化建议菜单',1,1);
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('bde250464cdc458ead9472ee9cdfda7f','表扬',3,'','6293f053281f459ea4f7402e2f90c365','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'表扬菜单',2,1);
insert into tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('16730e48bc1248c48500f202dfe3f2ab','投诉',3,'','6293f053281f459ea4f7402e2f90c365','admin',str_to_date('2018-05-13','%Y-%m-%d %T'),'投诉菜单',3,1);

---------------------------------------------------------------------------------------------------------------------------------------------------------------------
--角色与菜单的关联
----admin用户的菜单
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '42a1745009b849c38743a08922da0c4f');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '48711882b7e04641a5d8f4994a97ef5f');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'c712464e336d4ae6988bd27ba35f17d4');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'a365f66231c049169cbcc0d9572043ba');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '1b0cd1d267c948e2886ef98e5a76a578');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'aa1cb8b91b504dcfb2f7fa14cc94ac7c');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '115132658260463bb6f01b3108d11145');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '8e059c578c204fbbb29086aa72ec88f9');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '0b62d21d1ecd471f958d96b43471dcca');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'cae199e1e01f4bcf80ae2e2976fd15b9');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '769a2c0484dd43749ed12b607102d688');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'f03a9f0f29d44a1da4376353809eb9e1');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'ad705f6bb26948609e1aa55e86330d05');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '2108b5f2b4704a1b85ac0b2a596ded97');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '9dcf22db90c74e96b4e6c16da7ed84fd');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '6293f053281f459ea4f7402e2f90c365');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '168f11a29d3545df9a74c3bb0f346915');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'bde250464cdc458ead9472ee9cdfda7f');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '16730e48bc1248c48500f202dfe3f2ab');

--创新工作管理角色菜单
insert into tab_role_resource (role_id, resource_id) values ('111234ab9f8349c286c7314d944cec54', '42a1745009b849c38743a08922da0c4f');
insert into tab_role_resource (role_id, resource_id) values ('111234ab9f8349c286c7314d944cec54', '48711882b7e04641a5d8f4994a97ef5f');
insert into tab_role_resource (role_id, resource_id) values ('111234ab9f8349c286c7314d944cec54', 'c712464e336d4ae6988bd27ba35f17d4');
insert into tab_role_resource (role_id, resource_id) values ('111234ab9f8349c286c7314d944cec54', 'e51a8663876f4a3394bb194d89d96735');
--工会维护人员角色菜单
insert into tab_role_resource (role_id, resource_id) values ('80ca03c782964effba241c2112485e1b', 'a365f66231c049169cbcc0d9572043ba');
insert into tab_role_resource (role_id, resource_id) values ('80ca03c782964effba241c2112485e1b', '1b0cd1d267c948e2886ef98e5a76a578');
insert into tab_role_resource (role_id, resource_id) values ('80ca03c782964effba241c2112485e1b', 'aa1cb8b91b504dcfb2f7fa14cc94ac7c');
insert into tab_role_resource (role_id, resource_id) values ('80ca03c782964effba241c2112485e1b', '115132658260463bb6f01b3108d11145');
insert into tab_role_resource (role_id, resource_id) values ('80ca03c782964effba241c2112485e1b', 'e51a8663876f4a3394bb194d89d96735');
--文体协会维护人员角色菜单
insert into tab_role_resource (role_id, resource_id) values ('b91d300182804a6eafa85a14698dbcef', '8e059c578c204fbbb29086aa72ec88f9');
insert into tab_role_resource (role_id, resource_id) values ('b91d300182804a6eafa85a14698dbcef', '0b62d21d1ecd471f958d96b43471dcca');
insert into tab_role_resource (role_id, resource_id) values ('b91d300182804a6eafa85a14698dbcef', 'cae199e1e01f4bcf80ae2e2976fd15b9');
insert into tab_role_resource (role_id, resource_id) values ('b91d300182804a6eafa85a14698dbcef', 'e51a8663876f4a3394bb194d89d96735');
--后勤中心维护人员角色菜单
insert into tab_role_resource (role_id, resource_id) values ('17b40fc1df514e0d843f5b9a8964460c', '769a2c0484dd43749ed12b607102d688');
insert into tab_role_resource (role_id, resource_id) values ('17b40fc1df514e0d843f5b9a8964460c', 'f03a9f0f29d44a1da4376353809eb9e1');
insert into tab_role_resource (role_id, resource_id) values ('17b40fc1df514e0d843f5b9a8964460c', 'ad705f6bb26948609e1aa55e86330d05');
insert into tab_role_resource (role_id, resource_id) values ('17b40fc1df514e0d843f5b9a8964460c', '2108b5f2b4704a1b85ac0b2a596ded97');
insert into tab_role_resource (role_id, resource_id) values ('17b40fc1df514e0d843f5b9a8964460c', '9dcf22db90c74e96b4e6c16da7ed84fd');
insert into tab_role_resource (role_id, resource_id) values ('17b40fc1df514e0d843f5b9a8964460c', 'e51a8663876f4a3394bb194d89d96735');


-------------------------------------------------------------------------------------------------------------------------------------------------------------
--初始化操作信息(创新工作室-工作管理)
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('ae26f8acf5954ed5a0bfaa9ddcedeefa','48711882b7e04641a5d8f4994a97ef5f','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseListBusinessMethod','工作管理信息列表','工作管理信息列表',1,'WORK_MANAGER_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('d2b7ca015be7406d9ba6cf6e8320725f','48711882b7e04641a5d8f4994a97ef5f','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','deleteInfoReleaseByUuidsBusinessMethod','工作管理信息删除','工作管理信息删除',1,'WORK_MANAGER_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('d92ef23952da49d5b7483e36692f5bf7','48711882b7e04641a5d8f4994a97ef5f','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeAuditModuleBusinessMethod','工作管理信息审核','工作管理信息审核',1,'WORK_MANAGER_AUDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('ac420384a652446aa88faab1d2fdb94f','48711882b7e04641a5d8f4994a97ef5f','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeReleaseModuleBusinessMethod','工作管理信息发布','工作管理信息发布',1,'WORK_MANAGER_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('075e0149f69e4e93b5c4993dbea831c1','48711882b7e04641a5d8f4994a97ef5f','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','工作管理信息编辑','工作管理信息编辑',1,'WORK_MANAGER_EDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('37c0625ab4764ec78d62d73d122dcfc0','48711882b7e04641a5d8f4994a97ef5f','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseByUuidBusinessMethod','工作管理信息预览','工作管理信息预览',1,'WORK_MANAGER_PREVIEW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('91e05765fe6d495e9bc1d629e7b83c03','48711882b7e04641a5d8f4994a97ef5f','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','工作管理信息添加','工作管理信息添加',1,'WORK_MANAGER_ADD');
--初始化操作信息（创新工作室-优秀创新）
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('78edb8493ef84441b7c630173053d2dc','c712464e336d4ae6988bd27ba35f17d4','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService','getInnovationListBusinessMethod','优秀创新列表','优秀创新列表',1,'INNOVATION_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('7bbc0f222e0f42a597ba5cffce440cbe','c712464e336d4ae6988bd27ba35f17d4','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService','deleteBusinessMethod','优秀创新删除','优秀创新删除',1,'INNOVATION_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('e5273ea7826f4273a4820937d1c31727','c712464e336d4ae6988bd27ba35f17d4','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService','executeAuditBusinessMethod','优秀创新审核','优秀创新审核',1,'INNOVATION_AUDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('b01f1887f07c4588ba63ae253322bea6','c712464e336d4ae6988bd27ba35f17d4','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService','executeReleaseBusinessMethod','优秀创新发布','优秀创新发布',1,'INNOVATION_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('e9b2f5f9829a4272afd8bbeed31b534a','c712464e336d4ae6988bd27ba35f17d4','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService','saveOrUpdateInnovationBusinessMethod','优秀创新编辑','优秀创新编辑',1,'INNOVATION_EDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('f47a460ada924db88ab449ffb4458c76','c712464e336d4ae6988bd27ba35f17d4','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService','getInnovationByUuidBusinessMethod','优秀创新预览','优秀创新预览',1,'INNOVATION_PREVIEW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('40bc6c6434b541de85e170c58a5642d5','c712464e336d4ae6988bd27ba35f17d4','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService','saveOrUpdateInnovationBusinessMethod','优秀创新添加','优秀创新添加',1,'INNOVATION_ADD');

--初始化操作信息(援助帮扶-法条维护)
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('5a9eb8f7483240cc9da4555a10440245','1b0cd1d267c948e2886ef98e5a76a578','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseListBusinessMethod','法条维护信息列表','法条维护信息列表',1,'LEGAL_PROVISIONS_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('3b12648e06924d0897c3fa2cb920e165','1b0cd1d267c948e2886ef98e5a76a578','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','deleteInfoReleaseByUuidsBusinessMethod','法条维护信息删除','法条维护信息删除',1,'LEGAL_PROVISIONS_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('d2ae7226856f4debade44aafb5d0247c','1b0cd1d267c948e2886ef98e5a76a578','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeAuditModuleBusinessMethod','法条维护信息审核','法条维护信息审核',1,'LEGAL_PROVISIONS_AUDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('a0b827d143fa4874909f85cb7de21b23','1b0cd1d267c948e2886ef98e5a76a578','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeReleaseModuleBusinessMethod','法条维护信息发布','法条维护信息发布',1,'LEGAL_PROVISIONS_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('b2124a5d6a2540d7b58ef851c8b198f8','1b0cd1d267c948e2886ef98e5a76a578','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','法条维护信息编辑','法条维护信息编辑',1,'LEGAL_PROVISIONS_EDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('fa25528cca6b41c48048532ae3c5bba5','1b0cd1d267c948e2886ef98e5a76a578','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseByUuidBusinessMethod','法条维护信息预览','法条维护信息预览',1,'LEGAL_PROVISIONS_PREVIEW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('1b4ccd2a2f0a416d9a1bae77c6353e18','1b0cd1d267c948e2886ef98e5a76a578','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','法条维护信息添加','法条维护信息添加',1,'LEGAL_PROVISIONS_ADD');

--初始化操作信息(文体协会-工作发布)
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('4855162ac2014d3fb5cf5bee17075e28','0b62d21d1ecd471f958d96b43471dcca','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseListBusinessMethod','工作发布列表','工作发布列表',1,'WORK_RELEASE_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('392b972ef167498896caa46644221319','0b62d21d1ecd471f958d96b43471dcca','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','deleteInfoReleaseByUuidsBusinessMethod','工作发布信息删除','删除',1,'WORK_RELEASE_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('5b4bea13b8dc4b6eac9ea7a7f6867456','0b62d21d1ecd471f958d96b43471dcca','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeAuditModuleBusinessMethod','工作发布信息审核','审核',1,'WORK_RELEASE_AUDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('c3cdc2664df14b07a5994f2b9bc2ca03','0b62d21d1ecd471f958d96b43471dcca','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeReleaseModuleBusinessMethod','工作发布信息发布','发布',1,'WORK_RELEASE_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('28979cdd48d04f83b5f79abf813e769c','0b62d21d1ecd471f958d96b43471dcca','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','工作发布信息编辑','编辑',1,'WORK_RELEASE_EDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('1f96c131e4b3436486f7e4c92e8399df','0b62d21d1ecd471f958d96b43471dcca','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseByUuidBusinessMethod','工作发布信息预览','预览',1,'WORK_RELEASE_PREVIEW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('8615ca6386f340b48e1992c676ee2606','0b62d21d1ecd471f958d96b43471dcca','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','工作发布信息添加','添加',1,'WORK_RELEASE_ADD');
--初始化操作信息(文体协会-活动管理)
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('d499b27d37764d719c765dc9a0e6f5c1','cae199e1e01f4bcf80ae2e2976fd15b9','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.activity.service.TabActivityManageService','queryActivityList','活动管理信息列表','活动管理信息列表',1,'ACTIVITY_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('06d02a7ff6564dae85cdc48885623cc4','cae199e1e01f4bcf80ae2e2976fd15b9','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.activity.service.TabActivityManageService','deleteActivity','活动管理信息删除','删除',1,'ACTIVITY_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('a0270b1c88174a1090113d8d83f7c6ea','cae199e1e01f4bcf80ae2e2976fd15b9','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.activity.service.TabActivityManageService','executeAudit','活动管理信息审核','审核',1,'ACTIVITY_AUDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('5640c01f7cf1497aadf3a40080a817de','cae199e1e01f4bcf80ae2e2976fd15b9','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.activity.service.TabActivityManageService','executeRelease','活动管理信息发布','发布',1,'ACTIVITY_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('1f63d3e4ad2b4d8aaed19ccf5882cf8e','cae199e1e01f4bcf80ae2e2976fd15b9','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.activity.service.TabActivityManageService','addOrupdateActivity','活动管理信息编辑','编辑',1,'ACTIVITY_EDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('41ce7b762e914acda3c92a7ce31285a6','cae199e1e01f4bcf80ae2e2976fd15b9','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.activity.service.TabActivityManageService','getActivityByUuid','活动管理信息查看','查看',1,'ACTIVITY_PREVIEW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('80cd2c458d52436eb3648a6fde2fc151','cae199e1e01f4bcf80ae2e2976fd15b9','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.activity.service.TabActivityManageService','addOrupdateActivity','活动管理信息添加','添加',1,'ACTIVITY_ADD');


--初始化操作信息(后勤中心-早知道)
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('f0ccd87dbc684eeca5b72a1bedbcb23e','f03a9f0f29d44a1da4376353809eb9e1','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseListBusinessMethod','早知道信息列表','早知道信息列表',1,'EARLY_KNOW_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('8709a43fb0524f1dbce5680ee96f2b19','f03a9f0f29d44a1da4376353809eb9e1','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','deleteInfoReleaseByUuidsBusinessMethod','早知道信息删除','早知道信息删除',1,'EARLY_KNOW_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('c78e811598154da2a34ea7acb5a22b36','f03a9f0f29d44a1da4376353809eb9e1','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeAuditModuleBusinessMethod','早知道信息审核','早知道信息审核',1,'EARLY_KNOW_AUDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('2f540e43e1bc4e1eb096ee0b2efa6b22','f03a9f0f29d44a1da4376353809eb9e1','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeReleaseModuleBusinessMethod','早知道信息发布','早知道信息发布',1,'EARLY_KNOW_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('b8eec2c860944dc68143822868dd1ee1','f03a9f0f29d44a1da4376353809eb9e1','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','早知道信息编辑','早知道信息编辑',1,'EARLY_KNOW_EDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('4c61947d93624a61af01981c46b0b063','f03a9f0f29d44a1da4376353809eb9e1','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseByUuidBusinessMethod','早知道信息预览','早知道信息预览',1,'EARLY_KNOW_PREVIEW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('951d334e32104fb89c408c28319c42e6','f03a9f0f29d44a1da4376353809eb9e1','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','早知道信息添加','早知道信息添加',1,'EARLY_KNOW_ADD');


------------------------------------------------------------------------------------------
----角色操作（创新工作室-工作管理）
insert into tab_role_operate (role_uuid, operate_uuid) values ('111234ab9f8349c286c7314d944cec54', 'ae26f8acf5954ed5a0bfaa9ddcedeefa');
insert into tab_role_operate (role_uuid, operate_uuid) values ('111234ab9f8349c286c7314d944cec54', 'd2b7ca015be7406d9ba6cf6e8320725f');
insert into tab_role_operate (role_uuid, operate_uuid) values ('111234ab9f8349c286c7314d944cec54', 'd92ef23952da49d5b7483e36692f5bf7');
insert into tab_role_operate (role_uuid, operate_uuid) values ('111234ab9f8349c286c7314d944cec54', 'ac420384a652446aa88faab1d2fdb94f');
insert into tab_role_operate (role_uuid, operate_uuid) values ('111234ab9f8349c286c7314d944cec54', '075e0149f69e4e93b5c4993dbea831c1');
insert into tab_role_operate (role_uuid, operate_uuid) values ('111234ab9f8349c286c7314d944cec54', '37c0625ab4764ec78d62d73d122dcfc0');
insert into tab_role_operate (role_uuid, operate_uuid) values ('111234ab9f8349c286c7314d944cec54', '91e05765fe6d495e9bc1d629e7b83c03');
----角色操作(创新工作室-优秀创新)
insert into tab_role_operate (role_uuid, operate_uuid) values ('111234ab9f8349c286c7314d944cec54', '78edb8493ef84441b7c630173053d2dc');
insert into tab_role_operate (role_uuid, operate_uuid) values ('111234ab9f8349c286c7314d944cec54', '7bbc0f222e0f42a597ba5cffce440cbe');
insert into tab_role_operate (role_uuid, operate_uuid) values ('111234ab9f8349c286c7314d944cec54', 'e5273ea7826f4273a4820937d1c31727');
insert into tab_role_operate (role_uuid, operate_uuid) values ('111234ab9f8349c286c7314d944cec54', 'b01f1887f07c4588ba63ae253322bea6');
insert into tab_role_operate (role_uuid, operate_uuid) values ('111234ab9f8349c286c7314d944cec54', 'e9b2f5f9829a4272afd8bbeed31b534a');
insert into tab_role_operate (role_uuid, operate_uuid) values ('111234ab9f8349c286c7314d944cec54', 'f47a460ada924db88ab449ffb4458c76');
insert into tab_role_operate (role_uuid, operate_uuid) values ('111234ab9f8349c286c7314d944cec54', '40bc6c6434b541de85e170c58a5642d5');
----角色操作（援助帮扶-法条维护）
insert into tab_role_operate (role_uuid, operate_uuid) values ('80ca03c782964effba241c2112485e1b', '5a9eb8f7483240cc9da4555a10440245');
insert into tab_role_operate (role_uuid, operate_uuid) values ('80ca03c782964effba241c2112485e1b', '3b12648e06924d0897c3fa2cb920e165');
insert into tab_role_operate (role_uuid, operate_uuid) values ('80ca03c782964effba241c2112485e1b', 'd2ae7226856f4debade44aafb5d0247c');
insert into tab_role_operate (role_uuid, operate_uuid) values ('80ca03c782964effba241c2112485e1b', 'a0b827d143fa4874909f85cb7de21b23');
insert into tab_role_operate (role_uuid, operate_uuid) values ('80ca03c782964effba241c2112485e1b', 'b2124a5d6a2540d7b58ef851c8b198f8');
insert into tab_role_operate (role_uuid, operate_uuid) values ('80ca03c782964effba241c2112485e1b', 'fa25528cca6b41c48048532ae3c5bba5');
insert into tab_role_operate (role_uuid, operate_uuid) values ('80ca03c782964effba241c2112485e1b', '1b4ccd2a2f0a416d9a1bae77c6353e18');

----角色操作（文体协会-工作发布）
insert into tab_role_operate (role_uuid, operate_uuid) values ('b91d300182804a6eafa85a14698dbcef', '4855162ac2014d3fb5cf5bee17075e28');
insert into tab_role_operate (role_uuid, operate_uuid) values ('b91d300182804a6eafa85a14698dbcef', '392b972ef167498896caa46644221319');
insert into tab_role_operate (role_uuid, operate_uuid) values ('b91d300182804a6eafa85a14698dbcef', '5b4bea13b8dc4b6eac9ea7a7f6867456');
insert into tab_role_operate (role_uuid, operate_uuid) values ('b91d300182804a6eafa85a14698dbcef', 'c3cdc2664df14b07a5994f2b9bc2ca03');
insert into tab_role_operate (role_uuid, operate_uuid) values ('b91d300182804a6eafa85a14698dbcef', '28979cdd48d04f83b5f79abf813e769c');
insert into tab_role_operate (role_uuid, operate_uuid) values ('b91d300182804a6eafa85a14698dbcef', '1f96c131e4b3436486f7e4c92e8399df');
insert into tab_role_operate (role_uuid, operate_uuid) values ('b91d300182804a6eafa85a14698dbcef', '8615ca6386f340b48e1992c676ee2606');
----角色操作（文体协会-活动管理）
insert into tab_role_operate (role_uuid, operate_uuid) values ('b91d300182804a6eafa85a14698dbcef', '06d02a7ff6564dae85cdc48885623cc4');
insert into tab_role_operate (role_uuid, operate_uuid) values ('b91d300182804a6eafa85a14698dbcef', 'a0270b1c88174a1090113d8d83f7c6ea');
insert into tab_role_operate (role_uuid, operate_uuid) values ('b91d300182804a6eafa85a14698dbcef', '5640c01f7cf1497aadf3a40080a817de');
insert into tab_role_operate (role_uuid, operate_uuid) values ('b91d300182804a6eafa85a14698dbcef', '1f63d3e4ad2b4d8aaed19ccf5882cf8e');
insert into tab_role_operate (role_uuid, operate_uuid) values ('b91d300182804a6eafa85a14698dbcef', '41ce7b762e914acda3c92a7ce31285a6');
insert into tab_role_operate (role_uuid, operate_uuid) values ('b91d300182804a6eafa85a14698dbcef', '80cd2c458d52436eb3648a6fde2fc151');
insert into tab_role_operate (role_uuid, operate_uuid) values ('b91d300182804a6eafa85a14698dbcef', 'd499b27d37764d719c765dc9a0e6f5c1');

----角色操作（后勤中心-早知道）
insert into tab_role_operate (role_uuid, operate_uuid) values ('17b40fc1df514e0d843f5b9a8964460c', 'f0ccd87dbc684eeca5b72a1bedbcb23e');
insert into tab_role_operate (role_uuid, operate_uuid) values ('17b40fc1df514e0d843f5b9a8964460c', '8709a43fb0524f1dbce5680ee96f2b19');
insert into tab_role_operate (role_uuid, operate_uuid) values ('17b40fc1df514e0d843f5b9a8964460c', 'c78e811598154da2a34ea7acb5a22b36');
insert into tab_role_operate (role_uuid, operate_uuid) values ('17b40fc1df514e0d843f5b9a8964460c', '2f540e43e1bc4e1eb096ee0b2efa6b22');
insert into tab_role_operate (role_uuid, operate_uuid) values ('17b40fc1df514e0d843f5b9a8964460c', 'b8eec2c860944dc68143822868dd1ee1');
insert into tab_role_operate (role_uuid, operate_uuid) values ('17b40fc1df514e0d843f5b9a8964460c', '4c61947d93624a61af01981c46b0b063');
insert into tab_role_operate (role_uuid, operate_uuid) values ('17b40fc1df514e0d843f5b9a8964460c', '951d334e32104fb89c408c28319c42e6');


-----------------------------------------------------------------------------------------------
----初始化字典表
insert into tab_data_dict (DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,id,DICT_NO) values ('1','工人','职业身份','3','1','6','ACCUPATION');
insert into tab_data_dict (DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,id,DICT_NO) values ('2','技术人员','职业身份','3','2','7','ACCUPATION');
insert into tab_data_dict (DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,id,DICT_NO) values ('3','管理者','职业身份','3','3','8','ACCUPATION');
insert into tab_data_dict (DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,id,DICT_NO) values ('1','创新技术、应用新技术成果','体现形式','4','1','9','ACHIEVEMENT_FORM');
insert into tab_data_dict (DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,id,DICT_NO) values ('2','创新工艺、提出新的操作法','体现形式','4','2','10','ACHIEVEMENT_FORM');
insert into tab_data_dict (DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,id,DICT_NO) values ('3','研发新工具、改造老设备','体现形式','4','3','11','ACHIEVEMENT_FORM');
