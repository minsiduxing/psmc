delete from tab_sys_config;
INSERT INTO tab_sys_config (sys_uuid, sys_code, sys_type, sys_url, sys_method, sys_remark, app_code, column1, column2, ordernum) VALUES ('2b909a0327c14764b053b3a4b232d26f', 'REAL_NAME_AUTHENTICATION', 'http', 'https://idcardcert.market.alicloudapi.com', '/idCardCert', '实名认证接口调用', '8660c15a4c8e43d1849bd63b00cb4e7d', null, null, 1);
INSERT INTO tab_sys_config (sys_uuid, sys_code, sys_type, sys_url, sys_method, sys_remark, app_code, column1, column2, ordernum) VALUES ('7edc6050cbf742cb9a3386092c30e91a', 'getVcode', 'http', '/services/chjgh/weChatService/getVcode', 'get', '获取验证码', '', '{"validate": [{"type": "number","second": 60}]}', '内部对外cxf服务', 2);
INSERT INTO tab_sys_config (sys_uuid, sys_code, sys_type, sys_url, sys_method, sys_remark, app_code, column1, column2, ordernum) VALUES ('244f298c2edc4a41a030a9f58a1cfc41', 'login', 'http', '/services/chjgh/weChatService/login', 'get', '登陆', '', '{"validate": [{"type": "number","second": 20}]}', '内部对外cxf服务', 3);
INSERT INTO tab_sys_config (sys_uuid, sys_code, sys_type, sys_url, sys_method, sys_remark, app_code, column1, column2, ordernum) VALUES ('109c8faedced447a91e8608df0347730', 'register', 'http', '/services/chjgh/weChatService/register', 'post(form-data)', '注册', null, '{"validate": [{"type": "number","second": 20}]}', '内部对外cxf服务', 4);
INSERT INTO tab_sys_config (sys_uuid, sys_code, sys_type, sys_url, sys_method, sys_remark, app_code, column1, column2, ordernum) VALUES ('0f602f1677094c23ae6c686fb982818c', 'getDetailInfo', 'http', '/services/chjgh/weChatService/getDetailInfo', 'post', '得到信息详情', null, '{"validate": [{"type": "number","second": 5}, {"type": "tk"}]}', '内部对外cxf服务', 5);
INSERT INTO tab_sys_config (sys_uuid, sys_code, sys_type, sys_url, sys_method, sys_remark, app_code, column1, column2, ordernum) VALUES ('2a67a6accfda44e48f6a7da509840948', 'getInfoList', 'http', '/services/chjgh/weChatService/getInfoList', 'post', '得到信息列表', null, '{"validate": [{"type": "number","second": 5}, {"type": "tk"}]}', '内部对外cxf服务', 6);
INSERT INTO tab_sys_config (sys_uuid, sys_code, sys_type, sys_url, sys_method, sys_remark, app_code, column1, column2, ordernum) VALUES ('d173baf1214a48bba5d603c351bf0df2', 'getPhoneNo', 'http', '/services/inquest/inquestWechatService/getPhoneNo', 'get', '微信接口获取手机号', null, '{"validate": [{"type": "number","second": 5}, {"type": "tk"}]}', '内部对外cxf服务', 7);
INSERT INTO tab_sys_config (sys_uuid, sys_code, sys_type, sys_url, sys_method, sys_remark, app_code, column1, column2, ordernum) VALUES ('400f06f2cc1f4f359e62f6f350c7a08e', 'codeToSession', 'http', '/services/inquest/inquestWechatService/codeToSession', 'get', '微信接口登陆', null, '{"validate": [{"type": "number","second": 5}, {"type": "tk"}]}', '内部对外cxf服务', 8);
INSERT INTO tab_sys_config (sys_uuid, sys_code, sys_type, sys_url, sys_method, sys_remark, app_code, column1, column2, ordernum) VALUES ('1fa332816e5a4273a437eedbf531f51c', 'findInquestItemList', 'http', '/services/inquest/inquestWechatService/findInquestItemList', 'post(form-data)', '查询勘验题目列表', null, '{"validate": [{"type": "number","second": 5}, {"type": "tk"}]}', '内部对外cxf服务', 9);
INSERT INTO tab_sys_config (sys_uuid, sys_code, sys_type, sys_url, sys_method, sys_remark, app_code, column1, column2, ordernum) VALUES ('27e1e1263b6846bfa680b860b6bb4319', 'saveOrUpdateInquestRecord', 'http', '/services/inquest/inquestWechatService/saveOrUpdateInquestRecord', 'post(form-data)', '保存勘查阶段判定记录', null, '{"validate": [{"type": "number","second": 5}, {"type": "tk"}]}', '内部对外cxf服务', 10);
INSERT INTO tab_sys_config (sys_uuid, sys_code, sys_type, sys_url, sys_method, sys_remark, app_code, column1, column2, ordernum) VALUES ('645b864607c641e2a8cf8c4db95f54bc', 'getDictInfo', 'http', '/services/inquest/inquestWechatService/getDictInfo', 'get', '得到数据字典', null, '{"validate": [{"type": "number","second": 5}, {"type": "tk"}]}', '内部对外cxf服务', 11);
INSERT INTO tab_sys_config (sys_uuid, sys_code, sys_type, sys_url, sys_method, sys_remark, app_code, column1, column2, ordernum) VALUES ('a1396856115b4ffcb5599304b5663622', 'selectStageList', 'http', '/services/inquest/inquestWechatService/selectStageList', 'post(form-data)', '得到勘验阶段列表', null, '{"validate": [{"type": "number","second": 5}, {"type": "tk"}]}', '内部对外cxf服务', 12);
INSERT INTO tab_sys_config (sys_uuid, sys_code, sys_type, sys_url, sys_method, sys_remark, app_code, column1, column2, ordernum) VALUES ('c6d25f94c19f47cc8a77ccb8ed196466', 'selectInquestRecord', 'http', '/services/inquest/inquestWechatService/selectInquestRecord', 'get', '查询一条勘验记录', null, '{"validate": [{"type": "number","second": 5}, {"type": "tk"}]}', '内部对外cxf服务', 13);

delete from tab_sys_key_info;
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (1, 'sms_enable', 'true', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (2, 'zhongyi_create_url', 'https://vip.veesing.com/mmsApi/create', '����Ⱥ��������ַ');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (3, 'zhongyi_mms_send_url', 'https://vip.veesing.com/mmsApi/send', '����Ⱥ�����͵�ַ');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (4, 'zhongyi_sms_send_url', 'https://vip.veesing.com/smsApi/group', '����Ⱥ�����õ�ַ');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (5, 'zhongyi_sms_custom_url', 'https://vip.veesing.com/smsApi/custom', '���Ի����ŷ��͵�ַ');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (6, 'zhongyi_mms_balance_url', 'https://vip.veesing.com/mmsApi/getBalance?', '����Ⱥ������ѯ��ַ');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (7, 'zhongyi_sms_balance_url', 'https://vip.veesing.com/smsApi/group/getBalance?', '����Ⱥ������ѯ��ַ');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (8, 'zhongyi_sms_custom_balance_url', 'https://vip.veesing.com/smsApi/custom/getBalance?', '���Ի���������ѯ��ַ');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (9, 'zhongyi_appid', '79M784I9SQMH', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (10, 'zhongyi_appkey', 'YFUC24KWKBX5CTRC', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (11, 'sms_channel', 'sczgyj', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (12, 'ali_sms_product', 'Dysmsapi', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (13, 'ali_sms_domain', 'dysmsapi.aliyuncs.com', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (14, 'ali_sms_accessKeyId', '', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (15, 'ali_sms_accessKeySecret', '', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (16, 'ali_sms_vcode_signName', '', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (17, 'ali_sms_vcode_templateCode', '', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (18, 'chuangx_url', 'http://dc.28inter.com/v2sms.aspx/v2sms.aspx', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (19, 'chuangx_userid', '1706', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (20, 'chuangx_account', '', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (21, 'chuangx_password', '', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (22, 'questionnaireUrl', 'http://www.xahbjk.cn/psmc/website/backstage/QuestionnaireController.do?method=subjectConfigList', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (23, 'shotUrl', 'http://www.xahbjk.cn/psmc/ru.do?method=url&id=', null);

delete from tab_sys_key_info where id in(24,25,26,27,28,29,30,31,32,33,34,35);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (24, 'file_prefix_path', 'E:/export/home/suoji/upload/', '文件上传后生成的url前缀');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (25, 'system_upload_dir', '/export/home/websit/suoji/upload/', '文件上传后实际保存的服务器地址');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (26, 'news_image_path', 'default/news.png', '新闻缺省配图地址-大院新闻');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (27, 'system_upload_temp_dir', '/log/suoji-temp-upload/', '系统上传临时文件目录');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (28, 'system_download_temp_dir', '/log/suoji-temp-download/', '系统下载临时文件目录');

INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (29, 'system_upload_isremote', 'false', '是否开启ftp远程上传（被动模式）');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (30, 'system_remote_ip', 'ip', '远程主机ip');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (31, 'system_remote_port', 'port', '远程主机port');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (32, 'system_remote_username', '', '主机ftp用户名');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (33, 'system_remote_password', '', '主机ftp密码');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (34, 'system_remote_os', 'linux', '远程主机系统');

INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (35, 'excel_export_length', '10000', '系统导出excel每个sheet页的最大限制');

delete from tab_sys_key_info where id in(36,37,38,39,40,41,42,43,44);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (36, 'mobile_image_path', 'mobile/', '陕测-移动端上传图片自定义路径');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (37, 'activity_custom', 'activity/', '陕测-活动-图片路径');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (38, 'dept_literary_form_custom', 'deptLiteraryForm/', '陕测-文体协会-图片路径');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (39, 'dept_innovation_custom', 'deptInnovation/', '陕测-信息编辑自定义配图路径');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (40, 'logistics_center_custom', 'logisticsCenter/', '陕测-后勤中心-早知道-图片路径');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (41, 'literary_form_custom', 'literaryForm/', '陕测-文体协会-最新活动-图片路径');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (42, 'assistance_custom', 'assistance/', '陕测-援助帮扶-法条维护-图片路径');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (43, 'innovation_custom', 'innovation/', '陕测-创新工作室-图片路径');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (44, 'custom_image_path', 'custom/', '陕测-信息列表自定义配图路径');

delete from tab_sys_key_info where id in(45,46,47,48,49,50,51,52,53);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (45, 'help_declare_image_path', 'default/help_declare.png', '陕测-帮扶申报-默认配图');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (46, 'law_help_image_path', 'default/law_help.png', '陕测-法律援助-默认配图');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (47, 'Legal_provisions_image_path', 'default/Legal_provisions.png', '陕测-法条维护-默认配图');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (48, 'work_manage_image_path', 'default/work_manage.png', '陕测-工作管理-默认配图');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (49, 'work_release_image_path', 'default/work_manage.png', '陕测-工作发布-默认配图');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (50, 'activity_image_path', 'default/activity.png', '陕测-活动管理-默认配图');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (51, 'innovation_image_path', 'default/innovation.png', '陕测-优秀创新-默认配图');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (52, 'recipes_image_path', 'default/recipes.png', '陕测-美味食谱-默认配图');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (53, 'notice_image_path', 'default/notice.png', '陕测-日常通知-默认配图');

delete from tab_sys_key_info where id in(54,55,56,57,58,59,60,61,62,63);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (54, 'wx_getAccessToken_url', 'https://api.weixin.qq.com/cgi-bin/token', '微信getAccessToken接口地址');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (55, 'wx_getuserphonenumber_url', 'https://api.weixin.qq.com/wxa/business/getuserphonenumber', '微信getuserphonenumber接口地址');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (56, 'wx_jscode2session_url', 'https://api.weixin.qq.com/sns/jscode2session', '微信jscode2session接口地址');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (57, 'wx_grant_type', 'authorization_code', '微信使用');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (58, 'default_pass', 'Aa123456', '外网注册用户缺省密码');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (59, 'default_city', '00', '外网注册用户缺省所属地');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (60, 'default_groupid', '10000', '外网注册用户缺省所属组');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (61, 'default_roleid', 'e8d791272c7e437c8f8a72355bb0c231', '外网注册用户缺省所属角色');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (62, 'wx_appid', 'wx591b083250978728', '微信appid');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (63, 'wx_secret', '85e9f4b443190c407e12b46e08464731', '微信secret');
