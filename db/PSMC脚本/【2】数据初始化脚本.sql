
delete from tab_acc_role;
delete from tab_person;
delete from tab_accounts;
delete from tab_role_operate;
delete from tab_role_resource;
delete from tab_role;
delete from tab_operate;
delete from tab_resource;
delete from tab_privilege;
DELETE FROM TAB_CITY;
DELETE FROM TAB_DATA_DICT;
DELETE FROM  tab_navigation_bar;

INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('00', '省中心', 'NULL', '', 1, 1);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0001', '西安市', '00', '', 2, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000101', '长安区', '0001', '', 3, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000102', '高陵县', '0001', '', 4, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000103', '户县', '0001', '', 5, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000104', '蓝田县', '0001', '', 6, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000105', '临潼区', '0001', '', 7, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000106', '阎良区', '0001', '', 8, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000107', '周至县', '0001', '', 9, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000108', '杨凌区', '0001', '', 10, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000109', '未央区', '0001', '', 11, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000110', '新城区', '0001', '', 12, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000111', '莲湖区', '0001', '', 13, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000112', '灞桥区', '0001', '', 14, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000113', '雁塔区', '0001', '', 15, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000114', '碑林区', '0001', '', 16, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0002', '宝鸡市', '00', '', 17, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000201', '陈仓区', '0002', '', 18, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000202', '扶风县', '0002', '', 19, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000203', '凤翔县', '0002', '', 20, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000204', '岐山县', '0002', '', 21, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000205', '眉县', '0002', '', 22, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000206', '千阳县', '0002', '', 23, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000207', '陇县', '0002', '', 24, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000208', '太白县', '0002', '', 25, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000209', '凤县', '0002', '', 26, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000210', '麟游县', '0002', '', 27, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000211', '渭滨区', '0002', '', 28, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000212', '金台区', '0002', '', 29, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000213', '高新区', '0002', '', 29, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0003', '咸阳市', '00', '', 30, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000301', '兴平', '0003', '', 31, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000302', '武功', '0003', '', 32, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000303', '三原', '0003', '', 33, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000304', '泾阳', '0003', '', 34, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000305', '礼泉', '0003', '', 35, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000306', '乾县', '0003', '', 36, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000307', '永寿', '0003', '', 37, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000308', '彬县', '0003', '', 38, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000309', '淳化', '0003', '', 39, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000310', '旬邑', '0003', '', 40, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000311', '长武', '0003', '', 41, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000312', '秦都', '0003', '', 42, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000313', '渭城', '0003', '', 43, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0004', '安康市', '00', '', 44, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000401', '平利', '0004', '', 45, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000402', '石泉', '0004', '', 46, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000403', '镇坪', '0004', '', 47, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000404', '汉阴', '0004', '', 48, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000405', '旬阳', '0004', '', 49, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000406', '白河', '0004', '', 50, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000407', '宁陕', '0004', '', 51, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000408', '紫阳', '0004', '', 52, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000409', '岚皋', '0004', '', 53, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000410', '汉滨区', '0004', '', 54, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0005', '汉中市', '00', '', 55, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000501', '城固', '0005', '', 56, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000502', '佛坪', '0005', '', 57, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000503', '留坝', '0005', '', 58, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000504', '略阳', '0005', '', 59, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000505', '勉县', '0005', '', 60, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000506', '南郑', '0005', '', 61, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000507', '洋县', '0005', '', 62, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000508', '镇巴', '0005', '', 63, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000509', '西乡', '0005', '', 64, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000510', '宁强', '0005', '', 65, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000511', '汉台', '0005', '', 66, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0006', '商洛市', '00', '', 67, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000601', '丹凤', '0006', '', 68, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000602', '洛南', '0006', '', 69, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000603', '商南', '0006', '', 70, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000604', '山阳', '0006', '', 71, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000605', '镇安', '0006', '', 72, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000606', '柞水', '0006', '', 73, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000607', '商州', '0006', '', 74, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0007', '铜川市', '00', '', 75, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000701', '宜君', '0007', '', 76, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000702', '耀州', '0007', '', 77, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000703', '王益', '0007', '', 78, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000704', '印台', '0007', '', 79, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000705', '新区', '0007', '', 80, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0008', '渭南市', '00', '', 81, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000801', '韩城', '0008', '', 82, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000802', '华阴', '0008', '', 83, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000803', '华县', '0008', '', 84, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000804', '潼关', '0008', '', 85, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000805', '富平', '0008', '', 86, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000806', '白水', '0008', '', 87, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000807', '蒲城', '0008', '', 88, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000808', '大荔', '0008', '', 89, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000809', '澄城', '0008', '', 90, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000810', '合阳', '0008', '', 91, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000811', '临渭区', '0008', '', 92, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000812', '渭北', '0008', '', 93, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0009', '延安市', '00', '', 94, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000901', '黄龙', '0009', '', 95, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000902', '洛川', '0009', '', 96, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000903', '甘泉', '0009', '', 97, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000904', '志丹', '0009', '', 98, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000905', '子长', '0009', '', 99, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000906', '延长', '0009', '', 100, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000907', '黄陵', '0009', '', 101, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000908', '宜川', '0009', '', 102, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000909', '富县', '0009', '', 103, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000910', '吴旗', '0009', '', 104, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000911', '安塞', '0009', '', 105, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000912', '延川', '0009', '', 106, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000913', '宝塔区', '0009', '', 107, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0010', '榆林市', '00', '', 108, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001001', '米脂', '0010', '', 109, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001002', '绥德', '0010', '', 110, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001003', '定边', '0010', '', 111, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001004', '神木', '0010', '', 112, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001005', '靖边', '0010', '', 113, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001006', '横山', '0010', '', 114, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001007', '府谷', '0010', '', 115, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001008', '佳县', '0010', '', 116, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001009', '吴堡', '0010', '', 117, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001010', '清涧', '0010', '', 118, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001011', '子洲', '0010', '', 119, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001012', '榆阳区', '0010', '', 120, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001013', '高新区', '0010', '', 121, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001014', '锦界', '0010', '', 122, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001015', '大柳塔', '0010', '', 123, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001016', '庙沟门', '0010', '', 124, 3);

--2、TAB_DATA_DICT表数据初始化
DELETE  FROM TAB_DATA_DICT WHERE DICT_TYPE='1';
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1','是','是否判断',1,1,'IF');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'2','否','是否判断',1,2,'IF');

DELETE  FROM TAB_DATA_DICT WHERE DICT_TYPE='2';
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(3,'1','男','性别',2,1,'SEX');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(4,'2','女','性别',2,2,'SEX');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(5,'3','其他','性别',2,3,'SEX');



/*-----------------------------人员和角色-----------------------------*/
insert into tab_accounts (uuid, account_name, account_pass, is_locked) values 
('38ee6b0869c9411a948d4bda69c2d216','admin','c4ca4238a0b923820dcc509a6f75849b','2');

insert into tab_person (uuid, person_name, sex, age, telephone, email, acc_uuid,city_id) values 
('bd474935a3894530af485bea128501ec','郭纯',1,22,'18392101807','272193530@qq.com','38ee6b0869c9411a948d4bda69c2d216','00');

insert into tab_role (uuid, role_no, role_name, creator, create_time, remark) 
values('5428f3cdbd434934b142354221ed6b16','sys_manager','系统管理员','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'系统权限最大的管理者');

insert into tab_acc_role (acc_uuid, role_uuid) values ('38ee6b0869c9411a948d4bda69c2d216','5428f3cdbd434934b142354221ed6b16');


/*-----------------------------系统菜单-----------------------------*/
insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('e51a8663876f4a3394bb194d89d96735','PSMC系统树根目录',1,'','0','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'子系统',0);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('c4ecb01b62274ab9bc08a826f404b643','电费合同管理',2,'','e51a8663876f4a3394bb194d89d96735','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'导航模块',1);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('ba625cc38233480983f608b74eb697f4','信息管理',3,'','c4ecb01b62274ab9bc08a826f404b643','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',2);


insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('f15cbb06413449b2bffaf61cae8722d6','站点基础信息',3,'/sencondage/tabBaseElectricController.do?method=initBaseElectricityQuery','ba625cc38233480983f608b74eb697f4','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',3);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('abb22fde2c3f4421961ae9aac00dc853','站点电费信息',3,'/sencondage/tabMonthlyElectricController.do?method=initBaseElectricityQuery','ba625cc38233480983f608b74eb697f4','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',4);


insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('8f88c82038774bbe95dbcf74965a6821','电费分析',3,'','c4ecb01b62274ab9bc08a826f404b643','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',5);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('6eee3d7f0a5044d09833ef60500f1cff','超标杆站点TOPN统计',3,'/sencondage/report/electricDataDig.do?method=initTopNQuery','8f88c82038774bbe95dbcf74965a6821','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',6);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('67463ddf203046edae7761215256a45e','单站点电费统计',3,'/sencondage/tabBaseElectricController.do?method=initAloneSitStatisticsQuery','8f88c82038774bbe95dbcf74965a6821','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',7);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('b0a1af0a1a0440b190b813e21ca5c4ac','运营商区县维度电费统计',3,'/sencondage/report/electricDataDig.do?method=initProviderlatitudeQuery','8f88c82038774bbe95dbcf74965a6821','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',8);


insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('38d770a20a6847ec861269893c5154eb','电费结算',3,'','c4ecb01b62274ab9bc08a826f404b643','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',9);


insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('06e86b3b58d942e6bb383cda44e43825','电费结算报表',3,'/sencondage/tabMonthlyElectricController.do?method=initEstimateElectricityQuery','38d770a20a6847ec861269893c5154eb','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',10);


insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('fb67ef15af98450f8d57dd8a1f46b688','合同分析',3,'','c4ecb01b62274ab9bc08a826f404b643','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',11);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('fcd66122137c4ba887024eaee56ae3af','合同数据分析报表',3,'/sencondage/tabBaseElectricController.do?method=initContractReportQuery','fb67ef15af98450f8d57dd8a1f46b688','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',12);


insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('f55580fa321b4d34a172628d5825c4dc','系统管理',2,'','e51a8663876f4a3394bb194d89d96735','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'导航模块',13);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('deab504ee54b4f10b65fb17c7615ab9c','用户管理',3,'','f55580fa321b4d34a172628d5825c4dc','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',14);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('d4f3b60bfdcc4314baf65448d1284080','账户信息',3,'/jsp/authentication/user/account_list.jsp','deab504ee54b4f10b65fb17c7615ab9c','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',15);


insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('74385facee5148cbb0c9d69ecc1b8636','修改密码',3,'/jsp/updatePasswd.jsp','deab504ee54b4f10b65fb17c7615ab9c','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',16);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('9563b511d42f4768aa08cc506571de0a','角色管理',3,'','f55580fa321b4d34a172628d5825c4dc','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',17);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('a807a90d00fb48c4bdf1d82ab41a9bc0','角色信息',3,'/jsp/authentication/role/role_list.jsp','9563b511d42f4768aa08cc506571de0a','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',18);


insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('8d5276afc8444b47a842da1f42aaac34','资源管理',3,'','f55580fa321b4d34a172628d5825c4dc','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',21);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum) values 
('1a1a1817883142e7a9c9e06c477360cc','资源信息',3,'/jsp/authentication/resource/sys_resource_tree.jsp','8d5276afc8444b47a842da1f42aaac34','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',22);





/*-----------------------------给ADMIN赋菜单权限-----------------------------*/
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', 'e51a8663876f4a3394bb194d89d96735');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', 'c4ecb01b62274ab9bc08a826f404b643');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', 'ba625cc38233480983f608b74eb697f4');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', 'f15cbb06413449b2bffaf61cae8722d6');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', 'abb22fde2c3f4421961ae9aac00dc853');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', '8f88c82038774bbe95dbcf74965a6821');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', '6eee3d7f0a5044d09833ef60500f1cff');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', '67463ddf203046edae7761215256a45e');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', 'b0a1af0a1a0440b190b813e21ca5c4ac');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', '38d770a20a6847ec861269893c5154eb');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', '06e86b3b58d942e6bb383cda44e43825');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', 'fb67ef15af98450f8d57dd8a1f46b688');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', 'fcd66122137c4ba887024eaee56ae3af');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', 'f55580fa321b4d34a172628d5825c4dc');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', 'deab504ee54b4f10b65fb17c7615ab9c');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', 'd4f3b60bfdcc4314baf65448d1284080');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', '74385facee5148cbb0c9d69ecc1b8636');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', '9563b511d42f4768aa08cc506571de0a');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', 'a807a90d00fb48c4bdf1d82ab41a9bc0');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', '8d5276afc8444b47a842da1f42aaac34');
insert into tab_role_resource (role_id, resource_id) values ('5428f3cdbd434934b142354221ed6b16', '1a1a1817883142e7a9c9e06c477360cc');



/*-----------------------------系统抽象权限定义-----------------------------*/

insert into tab_privilege (uuid, privilege_id, privilege_name, remark, creator_name, creator_time) values 
('756d6e80c9d74b4389c918ab50ee19c3','query','查询列表','','admin',str_to_date('2016-8-9','%Y-%m-%d %T'));

insert into tab_privilege (uuid, privilege_id, privilege_name, remark, creator_name, creator_time) values 
('607e8bc6f9bb4afa9be3cfdc72a1a326','add','新增','','admin',str_to_date('2016-8-9','%Y-%m-%d %T'));

insert into tab_privilege (uuid, privilege_id, privilege_name, remark, creator_name, creator_time) values 
('fe755fa4bd25475fa1a9d841caa16f44','update','修改','','admin',str_to_date('2016-8-9','%Y-%m-%d %T'));

insert into tab_privilege (uuid, privilege_id, privilege_name, remark, creator_name, creator_time) values 
('dec3b327b8a54d66bd644c544ea65c5e','delete','删除','','admin',str_to_date('2016-8-9','%Y-%m-%d %T'));

insert into tab_privilege (uuid, privilege_id, privilege_name, remark, creator_name, creator_time) values 
('460283cc3e2c4d0a8b6bbbd75698a339','export','导出','','admin',str_to_date('2016-8-9','%Y-%m-%d %T'));

insert into tab_privilege (uuid, privilege_id, privilege_name, remark, creator_name, creator_time) values 
('d3ad7cefb81040ac8c935e7ee5602f5c','import','导入','','admin',str_to_date('2016-8-9','%Y-%m-%d %T'));

insert into tab_privilege (uuid, privilege_id, privilege_name, remark, creator_name, creator_time) values 
('022a43088dcd46d4b201b43b32d3d85a','deploy','配置','','admin',str_to_date('2016-8-9','%Y-%m-%d %T'));


/*-----------------------------定义菜单的业务操作-----------------------------*/
/*菜单----[账户信息]业务操作*/
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('14a2243153eb483caf3573246148e9cc','d4f3b60bfdcc4314baf65448d1284080','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.authentication.user.service.TabAccountService','getTabAccountsBusinessMethod','[账户列表]','',1,'');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('14a2243153eb483caf3573246148e93c','d4f3b60bfdcc4314baf65448d1284080','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.authentication.user.service.TabAccountService','getTabAccountsBusinessMethod','账户列表查询','',1,'ACCOUNT_QUERY');


insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('3a764c1f79294c8b903ebb80abf07220','d4f3b60bfdcc4314baf65448d1284080','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.authentication.user.service.TabAccountService','saveOrUpdateBusinessMethod','新增账户','',2,'ACCOUNT_ADD');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('705d01ec02d24d79bf9ea64c0a04385e','d4f3b60bfdcc4314baf65448d1284080','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.authentication.user.service.TabAccountService','saveOrUpdateBusinessMethod','修改账户','',3,'ACCOUNT_UPDATE');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('8dfc1b3b65694a0a8ec7f9f09148f0f2','d4f3b60bfdcc4314baf65448d1284080','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.authentication.user.service.TabAccountService','deletesBusinessMethod','删除账户','',4,'ACCOUNT_DEL');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('8dfc1b3b65694a0a8ec7f9f09148f0f3','d4f3b60bfdcc4314baf65448d1284080','460283cc3e2c4d0a8b6bbbd75698a339',
'priv.guochun.psmc.authentication.user.service.TabAccountService','getTabAccountsBusinessMethod','导出[账户列表]','',5,'ACCOUNT_EXPORT');

insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','14a2243153eb483caf3573246148e9cc');
insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','3a764c1f79294c8b903ebb80abf07220');
insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','705d01ec02d24d79bf9ea64c0a04385e');
insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','8dfc1b3b65694a0a8ec7f9f09148f0f2');
insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','8dfc1b3b65694a0a8ec7f9f09148f0f3');
insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','14a2243153eb483caf3573246148e93c');



/*菜单----[资源信息]业务操作*/
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('24d1fd15ba54491982f91ed98f8e8d8c','1a1a1817883142e7a9c9e06c477360cc','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.authentication.resource.service.TabResourceService','getSystemAllResourcesBusinessMethod','查询[资源树信息]','',1,'');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('6f0d3821e9cc43be828eeeedc95cf269','1a1a1817883142e7a9c9e06c477360cc','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.authentication.resource.service.TabResourceService','saveOrUpdateTabResourceBusinessMethod','新增[资源项信息]','',2,'RESOURCE_ADD');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('3408bb85700742e2b9142ee1c69eb21e','1a1a1817883142e7a9c9e06c477360cc','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.authentication.resource.service.TabResourceService','deleteTabResourceBusinessMethod','删除[资源项信息]','',3,'RESOURCE_DEL');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('e5cb125131bf4978a1e166e0bcf631cf','1a1a1817883142e7a9c9e06c477360cc','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.authentication.resource.service.TabResourceService','updateResourceTheParentUuidBusinessMethod','拖拽[资源项信息]','',4,'RESOURCE_DRAG');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('97edba427bbd40aea43295595a30cddd','1a1a1817883142e7a9c9e06c477360cc','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.authentication.resource.service.TabResourceService','updateResourceTheNameBusinessMethod','更新[资源项名称]','',4,'RESOURCE_UPDATE');


insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','24d1fd15ba54491982f91ed98f8e8d8c');
insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','6f0d3821e9cc43be828eeeedc95cf269');
insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','3408bb85700742e2b9142ee1c69eb21e');
insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','e5cb125131bf4978a1e166e0bcf631cf');
insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','97edba427bbd40aea43295595a30cddd');





/*菜单----[角色信息]业务操作*/
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('dc5648b017404cbb80fcde8947b5bea3','a807a90d00fb48c4bdf1d82ab41a9bc0','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.authentication.role.service.TabRoleService','getRolesListBusinessMethod','角色列表','',1,'');


insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('5a06ae4977b6448e89eaba7029bb8286','a807a90d00fb48c4bdf1d82ab41a9bc0','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.authentication.role.service.TabRoleService','saveOrUpdateRoleBusinessMethod','新增角色','',2,'ROLE_ADD');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('bd1aac73b28448abad87bc82d2b7049a','a807a90d00fb48c4bdf1d82ab41a9bc0','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.authentication.role.service.TabRoleService','saveOrUpdateRoleBusinessMethod','修改角色','',3,'ROLE_UPDATE');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('9142c050077d49dabf323d06ac49a3c6','a807a90d00fb48c4bdf1d82ab41a9bc0','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.authentication.role.service.TabRoleService','deletesRoleByUuidsBusinessMethod','删除角色','',4,'ROLE_DEL');


insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('a5bf5461a44d4fc9b4531483dffa2192','a807a90d00fb48c4bdf1d82ab41a9bc0','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.authentication.resource.service.TabResourceService','saveOrUpateResourceRoleRelationBusinessMethod','资源归属配置[角色列表]','',5,'ROLE_HAVE_RESOURCE');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('35559c19ed964e37b2fbb0892b13b339','a807a90d00fb48c4bdf1d82ab41a9bc0','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.authentication.resource.service.TabResourceService','saveRoleResourceOperateRelationsBusinessMethod','业务操作配置[角色列表]','',6,'ROLE_HAVE_OPERATE');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('dc5648b017404cbb80fcde8947b8cea3','a807a90d00fb48c4bdf1d82ab41a9bc0','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.authentication.role.service.TabRoleService','getRolesListBusinessMethod','查询角色列表','',1,'');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('dc5648b017404cbb80fccf8947b8cea3','a807a90d00fb48c4bdf1d82ab41a9bc0','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.authentication.role.service.TabRoleService','getRolesListBusinessMethod','导出角色信息','',1,'');


insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','dc5648b017404cbb80fcde8947b5bea3');
insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','5a06ae4977b6448e89eaba7029bb8286');
insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','bd1aac73b28448abad87bc82d2b7049a');
insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','9142c050077d49dabf323d06ac49a3c6');
insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','a5bf5461a44d4fc9b4531483dffa2192');
insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','dc5648b017404cbb80fccf8947b8cea3');
insert into tab_role_operate (role_uuid, operate_uuid) values ('5428f3cdbd434934b142354221ed6b16','dc5648b017404cbb80fcde8947b8cea3');







/**------------------------测试数据---------------

insert into tab_accounts (uuid, account_name, account_pass, is_locked) values 
('6e166767e6d144e48690aeaa3dbe5904','test1','test1','否');


insert into tab_person (uuid, person_name, sex, age, telephone, email, acc_uuid,city_id) values 
('359785266594451d90b5ed2f4ff09f4e','测试1',2,12,'18392101807','272193530@qq.com','6e166767e6d144e48690aeaa3dbe5904','0001');

**/