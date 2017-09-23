delete from tab_navigation_bar;

/*
 *根目录
 */
insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('10119b6e651647e38a289cd4fc6c8c1b','博汇康宁','',null,'1','根目录',1,2,1);

/*
 *导航栏
 */
insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('8f981a1dbe7f469bb3fa5870b480f904','首页','/index.html','10119b6e651647e38a289cd4fc6c8c1b','1',
'导航栏',2,2,2);

insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('9cb88c711b8e47d7b4ff1624db13da20','关于我们','/aboutus.html','10119b6e651647e38a289cd4fc6c8c1b','1',
'导航栏',3,2,2);


insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('9cdf2c2c88d44e4c8a26a565e9f0d03c','选择博汇康宁','/chooseus.html','10119b6e651647e38a289cd4fc6c8c1b','1',
'导航栏',4,2,2);


insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('b15f4a58a5a143338961d7fc0bb7c1fb','产品一览','/productlist.html','10119b6e651647e38a289cd4fc6c8c1b','1',
'导航栏',5,2,2);


insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('e717c3d4f9464a74931e5a4b5e90ab13','行情资讯','/info.html','10119b6e651647e38a289cd4fc6c8c1b','1',
'导航栏',6,2,2);

insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('b481ab861d6643909db2841e6dff77ae','会员中心','/member.html','10119b6e651647e38a289cd4fc6c8c1b','1',
'导航栏',7,2,2);


insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('5f62c30f24ed4f5499eb082d055e3841','团队展示','/teamshow.html','10119b6e651647e38a289cd4fc6c8c1b','1',
'导航栏',8,2,2);

insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('d36c76a19b204cef920a465c691dbeaa','加入我们','/recruit.html','10119b6e651647e38a289cd4fc6c8c1b','1',
'导航栏',9,2,2);




/**
 *关于我们子菜单
 */
insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('0adaed200eab4dcaaf29023e702ba762','公司简介','/aboutus.html','9cb88c711b8e47d7b4ff1624db13da20','1',
'模块菜单',11,2,3);

insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('4e669c7a8fe44c6db5487e825bb1b2a0','监管资质','/aboutus.html','9cb88c711b8e47d7b4ff1624db13da20','1',
'模块菜单',12,2,3);

insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('943a2edac23e40d8a39c3e97afea6b84','发展历程','/aboutus.html','9cb88c711b8e47d7b4ff1624db13da20','1',
'模块菜单',13,2,3);




/**
 *选择博汇康宁子菜单
 */
insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('45015de50581469aa954a8bdf4b6aa69','我们的优势','/chooseus.html','9cdf2c2c88d44e4c8a26a565e9f0d03c','1',
'模块菜单',14,2,3);

insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('350b83b011594eee8023d98e4ef3d945','风控体系','/chooseus.html','9cdf2c2c88d44e4c8a26a565e9f0d03c','1',
'模块菜单',15,2,3);

insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('7a7c83d1953646e4b37c4df903d3900c','核心团队','/chooseus.html','9cdf2c2c88d44e4c8a26a565e9f0d03c','1',
'模块菜单',16,2,3);

insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('c717768f5ac347acb516526e27f00e23','投资流程','/chooseus.html','9cdf2c2c88d44e4c8a26a565e9f0d03c','1',
'模块菜单',17,2,3);




/**
 *产品一览子菜单
 */
insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('5139e22f5c7946b6889265ba75f4829f','产品一览','/productlist.html','b15f4a58a5a143338961d7fc0bb7c1fb','1',
'模块菜单',18,2,3);

insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('f34fc7727b314106a5ba44b6b6075cae','产品线一览','/productlist.html','b15f4a58a5a143338961d7fc0bb7c1fb','1',
'模块菜单',19,2,3);


 
 
/**
 *行情资讯子菜单
 */


insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('da4de3037f074465a700d957dbbc935c','热点新闻','/info.html','e717c3d4f9464a74931e5a4b5e90ab13','1',
'模块菜单',20,2,3);

insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('81cb0cdb539249baad079d94192b36b9','实时资讯','/info.html','e717c3d4f9464a74931e5a4b5e90ab13','1',
'模块菜单',21,2,3);


insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('3b50544383774cf9805e09d060ccccfe','行业动向','/info.html','e717c3d4f9464a74931e5a4b5e90ab13','1',
'模块菜单',22,2,3);



/**
 *团队展示子菜单
 */


insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('fbb16e0051bc4a7aa02e43ee776cc27b','创始人','/teamshow.html','5f62c30f24ed4f5499eb082d055e3841','1',
'模块菜单',23,2,3);

insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('7001cecab4dd4418bc09b17d596da1c0','研究团队','/teamshow.html','5f62c30f24ed4f5499eb082d055e3841','1',
'模块菜单',24,2,3);

insert into tab_navigation_bar(menu_uuid,menu_name,menu_url,parent_menu_uuid,open_type,
remark,ordernum,is_locked,menu_level) values('52bb245046c249ec83ac2908dd8ecf46','核心团队','/teamshow.html','5f62c30f24ed4f5499eb082d055e3841','1',
'模块菜单',25,2,3);
