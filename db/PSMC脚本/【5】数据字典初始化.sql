delete from tab_data_dict;
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1', '是', '是否判断', 1, 1, '9d6e75a0d6bc49ffb9838ec940e4b91d', 'IF', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('2', '否', '是否判断', 1, 2, '1a12fc51e9624f8484460c72ce62bcbe', 'IF', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1', '男', '性别', 2, 1, '070bea723992474898137bdb338a4136', 'SEX', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('2', '女', '性别', 2, 2, 'fe212cffedb44dd999b66e1a47dcc780', 'SEX', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('3', '其他', '性别', 2, 3, 'bd5666d655f54b2a9484834019d88043', 'SEX', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1', '工人', '职业身份', 3, 1, '224d23845faf43d99d9705561f851aee', 'ACCUPATION', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('2', '技术人员', '职业身份', 3, 2, '182a8d6e9e704f6d8ac0468762b76b2e', 'ACCUPATION', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('3', '管理者', '职业身份', 3, 3, '21f7706b40c246fb93858980e3b7e13e', 'ACCUPATION', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1', '创新技术、应用新技术成果', '体现形式', 4, 1, '86815bca6b284cf38f0e300602494e2b', 'ACHIEVEMENT_FORM', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('2', '创新工艺、提出新的操作法', '体现形式', 4, 2, '6191f3dcf8504332b4744a284baeef98', 'ACHIEVEMENT_FORM', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('3', '研发新工具、改造老设备', '体现形式', 4, 3, '5075648927ee4fe2ada50932d5793f93', 'ACHIEVEMENT_FORM', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1', '工作流业务', '日志一级分类', 5, 1, 'dd6bde7c6f5c4ae08655e83a41514ffa', 'LOG_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('2', '系统操作', '日志一级分类', 5, 2, 'bf3df0ffea874f59ab7c10a25ee45603', 'LOG_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('3', '接口交互', '日志一级分类', 5, 3, 'a7f90dea0b3942e093422a0920f40229', 'LOG_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1.1', '流程发起', '日志二级分类', 6, 1, 'df6f72bd1f3647fdb06713ec4c453c00', 'LOG_SUB_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('2.1', '登录', '日志二级分类', 6, 2, 'be50e3e3b5a7410087ee971c77b42718', 'LOG_SUB_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('2.2', '登出', '日志二级分类', 6, 3, 'e1a7527006cd42eea78aefd033893278', 'LOG_SUB_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('2.3', '日常操作', '日志二级分类', 6, 4, '0cdb952656f442118c075ee617016b9f', 'LOG_SUB_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('3.1', '短信接口日志', '日志二级分类', 6, 5, '24705edc3882410aac7c858e18e963b3', 'LOG_SUB_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1', '系统', '用户组类型', 7, 1, 'db6ac8edcdc7475db726476882499975', 'TAB_RESOURCE_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('2', '模块', '用户组类型', 7, 2, '5c8844fcc6824d19a3d0acecb87a605a', 'TAB_RESOURCE_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('3', '菜单', '用户组类型', 7, 3, 'bc9e75d40bcd404c881c8c09e77db826', 'TAB_RESOURCE_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1', '根目录', '用户组类型', 8, 1, 'ba9e70f85e894436ae04fb984caa9814', 'USER_GROUP_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('2', '单位', '用户组类型', 8, 2, '30db8befd18d4009b1608f6bf6d044d5', 'USER_GROUP_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('3', '部门', '用户组类型', 8, 3, '7061cfdbf4b84dbda76c2cc43c949603', 'USER_GROUP_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1', '已回复', '困难申报状态', 9, 1, '0b149808275a4db5b5c6bcefc05c0a49', 'REPORT_STAUS', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('2', '已提交', '困难申报状态', 9, 2, '3af0be8349054b2f87801f176187e149', 'REPORT_STAUS', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('3', '处理中', '困难申报状态', 9, 3, '0ece4673b4cf49f6864a8b0be9623b77', 'REPORT_STAUS', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('4', '已受理', '困难申报状态', 9, 4, '39f1cac91c7944969c122646396e2cf1', 'REPORT_STAUS', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('5', '已备案', '困难申报状态', 9, 5, '3933b64c99e1474a81f37a68eb4018ae', 'REPORT_STAUS', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('6', '未发布', '合理化建议状态', 9, 6, '006a216fbc1742de9e2be43c299b9438', 'REPORT_STAUS', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('7', '已发布', '合理化建议状态', 9, 7, '952f856f7471424595f535eb297c50ea', 'REPORT_STAUS', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1401', '美味食谱', '早知道管理分类', 10, 1, '9646569c5d184cb1b2ea204dc9d23fb7', 'INFO_TYPE', 14);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1402', '日常通知', '早知道管理分类', 10, 2, '58c7e84c14fc4ccaa52176b600a836bd', 'INFO_TYPE', 14);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1403', '大院新闻', '早知道管理分类', 10, 3, 'c905dd51b42d4eb794e8dce6622bdfc9', 'INFO_TYPE', 14);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1404', '便民电话', '早知道管理分类', 10, 4, '8a9de41f7e8744588e9da9f862440a59', 'INFO_TYPE', 14);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1405', '政策法律', '早知道管理分类', 10, 5, 'b38247e5b32a4db293b89fef220074d2', 'INFO_TYPE', 14);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1501', '关于介绍', '信息分类', 11, 1, '44e5ced3418c4da6b9dadff4f681acbe', 'INFO_TYPE', 15);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1502', '业务领域', '信息分类', 11, 2, '956254c756804b31836b7d9ae9a831d5', 'INFO_TYPE', 15);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1503', '新闻动态', '信息分类', 11, 3, 'f3cf89473b8749e6972ab0af57106e17', 'INFO_TYPE', 15);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1504', '联系我们', '信息分类', 11, 4, 'cc5f4f4d4de74211a69b1b676a1092b6', 'INFO_TYPE', 15);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1601', '合伙人', '法律人员分类', 12, 1, '39d3f6482e4c4dc9bd037fe22014ead8', 'INFO_TYPE', 16);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1602', '专职律师', '法律人员分类', 12, 2, 'dd4fe57a26d8441c8c13c930ce0d0ec1', 'INFO_TYPE', 16);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1603', '辅助人员', '法律人员分类', 12, 3, '6bdff5b8a78c41a0bfd18c268acb52e6', 'INFO_TYPE', 16);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1', '待评价', '评价状态', 13, 1, '8acba0b27b0947998f2e8ad3f1b960a2', 'EVALUATE_STATUS', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('2', '已评价', '评价状态', 13, 2, '0bb46c22e0274fda9d02610967654597', 'EVALUATE_STATUS', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('4', '发送失败', '评价状态', 13, 4, 'd55a51c743984e8d993c4f3c4231f5b5', 'EVALUATE_STATUS', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('14', '陕测早知道', '陕测早知道', 14, 1, '475346cd45654a6686f59824cf4437c3', 'SC_ZZD', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('15', '律所新闻发布', '律所新闻发布', 15, 2, 'd90a8bf8ab324dfea9a8ce00489dd6a9', 'LS_XWFB', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('16', '律所辅助人员', '律所辅助人员', 16, 3, 'b069f61924c642569dc3cab4d6f4a05c', 'LS_FZRY', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1', '后台系统账户', '账户类型', 17, 1, '008ae3057ba94fff9559488adae87902', 'ACC_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('2', '微信平台账户', '账户类型', 17, 2, 'd22e2984ac134bb2bf2f6b25d68cac30', 'ACC_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('99', '其他类型账户', '账户类型', 17, 3, '7ab6010922a742ec8a6dafbbec890ab8', 'ACC_TYPE', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1', '金额消费', '短信类型', 18, 1, '2dc7018e5fe2471c87e88c0643abaf14', 'NOTICE_TYPE', 19);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('2', '项目消费', '短信类型', 18, 2, '7e08cef82f3c4e5dbba4010c3db2016d', 'NOTICE_TYPE', 19);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('3', '充值', '短信类型', 18, 3, '55e713a386a546f79a023c76f3adfc72', 'NOTICE_TYPE', 19);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('4', '卡余一类', '短信类型', 18, 4, '20db71cb864f4dc48a65e1b4c90210e2', 'NOTICE_TYPE', 20);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('5', '卡余二类', '短信类型', 18, 5, '3ced0ea035214ca782bbbe9f21d246d9', 'NOTICE_TYPE', 20);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('6', '卡余三类', '短信类型', 18, 6, '2fcffa9d1a5a4507b213b0a67be72312', 'NOTICE_TYPE', 20);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('7', '未体验一类', '短信类型', 18, 7, '3f17fd7d2639427081732c48510f3a9f', 'NOTICE_TYPE', 20);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('8', '未体验二类', '短信类型', 18, 8, 'dcce3b0ead7045fdbaa1daa979d82dba', 'NOTICE_TYPE', 20);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('9', '专属福利', '短信类型', 18, 9, '949ad16cd4324e7bb04cc7444cf70d6f', 'NOTICE_TYPE', 20);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('1', '消费类', '花城消费短信类别', 19, 2, 'd90a8bf8ab324dfea9a8ce00489dd6a1', 'HC_XFLSMS', null);
INSERT INTO tab_data_dict (DICT_ID, DICT_NAME, REMARK, DICT_TYPE, ORDERNUM, id, DICT_NO, PARENT_DICT_TYPE) VALUES ('2', '推广类', '花城推广短信类别', 20, 3, 'b069f61924c642569dc3cab4d6f4a051', 'HC_TGLSMS', null);

delete from TAB_DATA_DICT where DICT_NO='BELONG_TO_ZMJ';

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO,PARENT_DICT_TYPE) VALUES('fd2533acfa8d48be9ee1a70774388364','1701','福建省城北鼓楼区烟草专卖局','归属专卖局',21,1,'BELONG_TO_ZMJ',NULL);
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO,PARENT_DICT_TYPE) VALUES('0b06285a8823453487c73ec2fb77b6d8','1702','福建省罗源县烟草专卖局','归属专卖局',21,2,'BELONG_TO_ZMJ',NULL);

delete from TAB_DATA_DICT where DICT_NO='QUESTION_TYPE';

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO,PARENT_DICT_TYPE) VALUES('94d222356f3b42b88be466470e072eab','1','单选','题目类型',22,1,'QUESTION_TYPE',NULL);
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO,PARENT_DICT_TYPE) VALUES('c1eca9ecaaf542dcbfcae283a17ec942','2','多选','题目类型',22,2,'QUESTION_TYPE',NULL);

delete from TAB_DATA_DICT where DICT_NO='PERSON_AUTH_TYPE';

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO,PARENT_DICT_TYPE) VALUES('b2d34276a8384d4586b152e49660576e','1','身份证','实名认证方式',23,1,'PERSON_AUTH_TYPE',NULL);
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO,PARENT_DICT_TYPE) VALUES('badbb69d2f344e4b8697a728cac4c68c','2','其他','实名认证方式',23,2,'PERSON_AUTH_TYPE',NULL);

delete from TAB_DATA_DICT where DICT_NO='RULE_TYPE';

INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO,PARENT_DICT_TYPE) VALUES('4e3c9e85ed974b54a955497303de9610','1','网格总量测算','测算规则',24,1,'RULE_TYPE',NULL);
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO,PARENT_DICT_TYPE) VALUES('9a9b380f6ea547ed9e05c99f17b90a6b','2','最近零售户距离测算','测算规则',24,4,'RULE_TYPE',NULL);
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO,PARENT_DICT_TYPE) VALUES('c337654571864eb98f2cdba89a32fdc3','3','网格容量测算','测算规则',24,5,'RULE_TYPE',NULL);
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO,PARENT_DICT_TYPE) VALUES('c337654571864eb98f2cdba89a32fdc3','4','中小学距离测算','测算规则',24,2,'RULE_TYPE',NULL);
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO,PARENT_DICT_TYPE) VALUES('c337654571864eb98f2cdba89a32fdc3','5','幼儿园距离测算','测算规则',24,3,'RULE_TYPE',NULL);

delete from TAB_DATA_DICT where DICT_NO='LY_KYXWLX';
delete from TAB_DATA_DICT where DICT_NO='INFO_TYPE' AND DICT_ID IN('1505','1506','1507');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO,PARENT_DICT_TYPE) VALUES('b069f61924c642569dc3cab4d6f4a051','3','龙岩勘验新闻类型','龙岩勘验新闻类型',26,3,'LY_KYXWLX',NULL);
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO,PARENT_DICT_TYPE) VALUES('cc5f4f4d4de74211a69b1b676a1092b6','1505','欢迎页','信息分类',25,1,'INFO_TYPE',26);
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO,PARENT_DICT_TYPE) VALUES('d610cecc1d9d421995210d0d31234563','1506','用户服务协议','信息分类',25,2,'INFO_TYPE',26);
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO,PARENT_DICT_TYPE) VALUES('8c3901bbd1be426b98a5f121e87e91b3','1507','预判完毕告知','信息分类',25,3,'INFO_TYPE',26);

