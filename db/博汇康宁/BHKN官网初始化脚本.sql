--屏蔽用户管理菜单 不给开放
update tab_resource set is_view=2 where uuid='f55580fa321b4d34a172628d5825c4dc';

delete from tab_navigation_bar;

/*
 *根目录
 */
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('10119b6e651647e38a289cd4fc6c8c1b', '博汇康宁', '', null, '1', '根目录', 1, 2, 1);
/*
 *导航栏
 */

INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('8f981a1dbe7f469bb3fa5870b480f904', '首页', 'index.html', '10119b6e651647e38a289cd4fc6c8c1b', '1', '导航栏', 2, 2, 2);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('9cb88c711b8e47d7b4ff1624db13da20', '关于我们', 'aboutus.html', '10119b6e651647e38a289cd4fc6c8c1b', '1', '导航栏', 3, 2, 2);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level)
VALUES ('9cdf2c2c88d44e4c8a26a565e9f0d03c', '选择博汇康宁', 'chooseus.html', '10119b6e651647e38a289cd4fc6c8c1b', '1', '导航栏', 4, 2, 2);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('b15f4a58a5a143338961d7fc0bb7c1fb', '产品一览', 'productlist.html', '10119b6e651647e38a289cd4fc6c8c1b', '1', '导航栏', 5, 2, 2);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('e717c3d4f9464a74931e5a4b5e90ab13', '行情资讯', 'info.html', '10119b6e651647e38a289cd4fc6c8c1b', '1', '导航栏', 6, 2, 2);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level)
VALUES ('b481ab861d6643909db2841e6dff77ae', '会员中心', 'member.html', '10119b6e651647e38a289cd4fc6c8c1b', '1', '导航栏', 7, 2, 2);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('5f62c30f24ed4f5499eb082d055e3841', '团队展示', 'teamshow.html', '10119b6e651647e38a289cd4fc6c8c1b', '1', '导航栏', 8, 2, 2);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('d36c76a19b204cef920a465c691dbeaa', '加入我们', 'recruit.html', '10119b6e651647e38a289cd4fc6c8c1b', '1', '导航栏', 9, 2, 2);




/**
 *关于我们子菜单
 */
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level)
VALUES ('0adaed200eab4dcaaf29023e702ba762', '公司简介', 'aboutus.html#businessculture', '9cb88c711b8e47d7b4ff1624db13da20', '1', '模块菜单', 11, 2, 3);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('4e669c7a8fe44c6db5487e825bb1b2a0', '监管资质', 'aboutus.html#supervise', '9cb88c711b8e47d7b4ff1624db13da20', '1', '模块菜单', 12, 2, 3);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('943a2edac23e40d8a39c3e97afea6b84', '发展历程', 'aboutus.html#companyprocess', '9cb88c711b8e47d7b4ff1624db13da20', '1', '模块菜单', 13, 2, 3);



/**
 *选择博汇康宁子菜单
 */
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('350b83b011594eee8023d98e4ef3d945', '风控体系', 'chooseus.html#riskmanagement', '9cdf2c2c88d44e4c8a26a565e9f0d03c', '1', '模块菜单', 15, 2, 3);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('45015de50581469aa954a8bdf4b6aa69', '我们的优势', 'chooseus.html#ourstrengths', '9cdf2c2c88d44e4c8a26a565e9f0d03c', '1', '模块菜单', 14, 2, 3);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('7a7c83d1953646e4b37c4df903d3900c', '核心团队', 'chooseus.html#coreteam', '9cdf2c2c88d44e4c8a26a565e9f0d03c', '1', '模块菜单', 16, 2, 3);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('c717768f5ac347acb516526e27f00e23', '投资流程', 'chooseus.html#investmentprocess', '9cdf2c2c88d44e4c8a26a565e9f0d03c', '1', '模块菜单', 17, 2, 3);




/**
 *产品一览子菜单
 */
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('5139e22f5c7946b6889265ba75f4829f', '产品一览', 'productlist.html#productview', 'b15f4a58a5a143338961d7fc0bb7c1fb', '1', '模块菜单', 18, 2, 3);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('f34fc7727b314106a5ba44b6b6075cae', '产品线一览', 'productlist.html#productlineview', 'b15f4a58a5a143338961d7fc0bb7c1fb', '1', '模块菜单', 19, 2, 3);


 
 
/**
 *行情资讯子菜单
 */

INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('3b50544383774cf9805e09d060ccccfe', '行业动向', 'info.html#compCuContent', 'e717c3d4f9464a74931e5a4b5e90ab13', '1', '模块菜单', 22, 2, 3);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('81cb0cdb539249baad079d94192b36b9', '实时资讯', 'info.html#compCuContent', 'e717c3d4f9464a74931e5a4b5e90ab13', '1', '模块菜单', 21, 2, 3);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('da4de3037f074465a700d957dbbc935c', '热点新闻', 'info.html#compCuContent', 'e717c3d4f9464a74931e5a4b5e90ab13', '1', '模块菜单', 20, 2, 3);


/**
 *团队展示子菜单
 */

INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('52bb245046c249ec83ac2908dd8ecf46', '核心团队', 'teamshow.html#coreteam', '5f62c30f24ed4f5499eb082d055e3841', '1', '模块菜单', 25, 2, 3);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('7001cecab4dd4418bc09b17d596da1c0', '研究团队', 'teamshow.html#researchteam', '5f62c30f24ed4f5499eb082d055e3841', '1', '模块菜单', 24, 2, 3);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) 
VALUES ('fbb16e0051bc4a7aa02e43ee776cc27b', '创始人', 'teamshow.html#founder', '5f62c30f24ed4f5499eb082d055e3841', '1', '模块菜单', 23, 2, 3);
/**
 *会员登录退出
 */

INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) VALUES ('b482ab861d6643909dc2841e6dff77ae', '登录', 'login.html', '10119b6e651647e38a289cd4fc6c8c1b', '1', '导航栏', 10, 1, 2);
INSERT INTO tab_navigation_bar (menu_uuid, menu_name, menu_url, parent_menu_uuid, open_type, remark, ordernum, is_locked, menu_level) VALUES ('b482ab864d6643909dc2f41e6dff77ae', '退出', '#', '10119b6e651647e38a289cd4fc6c8c1b', '1', '导航栏', 11, 2, 2);


update tab_navigation_bar  t set is_locked='1' where t.menu_name like '%研究团队%';
update tab_navigation_bar  t set menu_name='组织架构' where t.menu_name like '%投资流程%';