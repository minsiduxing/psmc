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

INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (1, 'sms_enable', 'true', null);
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (2, 'zhongyi_create_url', 'https://vip.veesing.com/mmsApi/create', '彩信群发创建地址');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (3, 'zhongyi_mms_send_url', 'https://vip.veesing.com/mmsApi/send', '彩信群发发送地址');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (4, 'zhongyi_sms_send_url', 'https://vip.veesing.com/smsApi/group', '短信群发调用地址');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (5, 'zhongyi_sms_custom_url', 'https://vip.veesing.com/smsApi/custom', '个性化短信发送地址');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (6, 'zhongyi_mms_balance_url', 'https://vip.veesing.com/mmsApi/getBalance?', '彩信群发余额查询地址');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (7, 'zhongyi_sms_balance_url', 'https://vip.veesing.com/smsApi/group/getBalance?', '短信群发余额查询地址');
INSERT INTO tab_sys_key_info (id, sys_key, sys_value, remark) VALUES (8, 'zhongyi_sms_custom_balance_url', 'https://vip.veesing.com/smsApi/custom/getBalance?', '个性化短信余额查询地址');
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
