
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
('bd474935a3894530af485bea128501ec','王笛',1,0,'18691026980','','38ee6b0869c9411a948d4bda69c2d216','00');

insert into tab_role (uuid, role_no, role_name, creator, create_time, remark) 
values('efb74820f0564d02bb68fdf3190a6430','sys_manager','系统管理员','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'系统权限最大的管理者');

insert into tab_acc_role (acc_uuid, role_uuid) values ('38ee6b0869c9411a948d4bda69c2d216','efb74820f0564d02bb68fdf3190a6430');


/*-----------------------------系统菜单-----------------------------*/
insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('e51a8663876f4a3394bb194d89d96735','PSMC系统树根目录',1,'','0','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'子系统',0,1);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('f55580fa321b4d34a172628d5825c4dc','系统管理',2,'','e51a8663876f4a3394bb194d89d96735','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'导航模块',13,1);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('deab504ee54b4f10b65fb17c7615ab9c','用户管理',3,'','f55580fa321b4d34a172628d5825c4dc','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',14,1);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('d4f3b60bfdcc4314baf65448d1284080','账户信息',3,'/jsp/authentication/user/account_list.jsp','deab504ee54b4f10b65fb17c7615ab9c','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',15,1);


insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('74385facee5148cbb0c9d69ecc1b8636','修改密码',3,'/jsp/updatePasswd.jsp','deab504ee54b4f10b65fb17c7615ab9c','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',16,1);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('9563b511d42f4768aa08cc506571de0a','角色管理',3,'','f55580fa321b4d34a172628d5825c4dc','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',17,1);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('a807a90d00fb48c4bdf1d82ab41a9bc0','角色信息',3,'/jsp/authentication/role/role_list.jsp','9563b511d42f4768aa08cc506571de0a','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',18,1);


insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('8d5276afc8444b47a842da1f42aaac34','资源管理',3,'','f55580fa321b4d34a172628d5825c4dc','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',21,1);

insert into tab_resource 
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values 
('1a1a1817883142e7a9c9e06c477360cc','资源信息',3,'/jsp/authentication/resource/sys_resource_tree.jsp','8d5276afc8444b47a842da1f42aaac34','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'菜单',22,1);



insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'e51a8663876f4a3394bb194d89d96735');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'f55580fa321b4d34a172628d5825c4dc');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'deab504ee54b4f10b65fb17c7615ab9c');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'd4f3b60bfdcc4314baf65448d1284080');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '74385facee5148cbb0c9d69ecc1b8636');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '9563b511d42f4768aa08cc506571de0a');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'a807a90d00fb48c4bdf1d82ab41a9bc0');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '8d5276afc8444b47a842da1f42aaac34');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '1a1a1817883142e7a9c9e06c477360cc');



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

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','14a2243153eb483caf3573246148e9cc');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','3a764c1f79294c8b903ebb80abf07220');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','705d01ec02d24d79bf9ea64c0a04385e');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','8dfc1b3b65694a0a8ec7f9f09148f0f2');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','8dfc1b3b65694a0a8ec7f9f09148f0f3');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','14a2243153eb483caf3573246148e93c');



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

INSERT INTO `tab_operate` VALUES ('23ef454491484c7b8665bef3390a0cc9', '1a1a1817883142e7a9c9e06c477360cc', '022a43088dcd46d4b201b43b32d3d85a', 'priv.guochun.psmc.authentication.operate.service.TabOperateService', 'getTabOperatesBusinessMethod', 'RESOURCE_OPERATE', '资源业务操作配置', '', '32');

INSERT INTO `tab_operate` VALUES ('1bf34d6238ec40e4ba59007b2d9e4f10', '1a1a1817883142e7a9c9e06c477360cc', '607e8bc6f9bb4afa9be3cfdc72a1a326', 'priv.guochun.psmc.authentication.operate.service.TabOperateService', 'saveOrUpdateResOperateBusinessMethod', 'OPERATE_ADD', '新增[资源业务操作配置]', '', '33');

INSERT INTO `tab_operate` VALUES ('de3c4bea21644074a5b5798bf0b67826', '1a1a1817883142e7a9c9e06c477360cc', 'fe755fa4bd25475fa1a9d841caa16f44', 'priv.guochun.psmc.authentication.operate.service.TabOperateService', 'saveOrUpdateResOperateBusinessMethod', 'OPERATE_UPDATE', '修改[资源业务操作配置]', '', '34');

INSERT INTO `tab_operate` VALUES ('a3c7dbf3c90a4917862ac036e94ed37c', '1a1a1817883142e7a9c9e06c477360cc', 'dec3b327b8a54d66bd644c544ea65c5e', 'priv.guochun.psmc.authentication.operate.service.TabOperateService', 'deleteOperateBusinessMethod', 'OPERATE_DEL', '删除[资源业务操作配置]', '', '35');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','24d1fd15ba54491982f91ed98f8e8d8c');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','6f0d3821e9cc43be828eeeedc95cf269');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','3408bb85700742e2b9142ee1c69eb21e');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','e5cb125131bf4978a1e166e0bcf631cf');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','97edba427bbd40aea43295595a30cddd');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '14a2243153eb483caf3573246148e9cc');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '1bf34d6238ec40e4ba59007b2d9e4f10');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'de3c4bea21644074a5b5798bf0b67826');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', 'a3c7dbf3c90a4917862ac036e94ed37c');



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


insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','dc5648b017404cbb80fcde8947b5bea3');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','5a06ae4977b6448e89eaba7029bb8286');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','bd1aac73b28448abad87bc82d2b7049a');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','9142c050077d49dabf323d06ac49a3c6');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','a5bf5461a44d4fc9b4531483dffa2192');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','dc5648b017404cbb80fccf8947b8cea3');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','dc5648b017404cbb80fcde8947b8cea3');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','35559c19ed964e37b2fbb0892b13b339');



--------------新闻角色脚本
INSERT INTO tab_role (uuid, role_no, role_name, creator, create_time, remark) VALUES ('447a398c553d446283b030c2a5716a79', 'sys_news_add', '新闻添加人员', 'admin', '2017-09-24 17:05:01', '新闻添加人员');
INSERT INTO tab_role (uuid, role_no, role_name, creator, create_time, remark) VALUES ('60fa2131c09448848f42a29e3b5ab421', 'sys_news_audit', '系统新闻审核', 'admin', '2017-09-08 23:27:47', '审核新闻信息');
INSERT INTO tab_role (uuid, role_no, role_name, creator, create_time, remark) VALUES ('f20d3a2281ef4de29a7c8bc761d83701', 'sys_news_release', '系统新闻发布员', 'admin', '2017-09-08 23:28:39', '发布新闻');
INSERT INTO tab_role (uuid, role_no, role_name, creator, create_time, remark) VALUES ('fcbd8c27372346e198bc2eae52b1643e', 'sys_news_query', '查看权限', 'admin', '2017-09-08 23:28:39', '');


insert into tab_accounts (uuid, account_name, account_pass, is_locked) values 
('a98ea24502694850bc0ac8121a83d97a','query','c4ca4238a0b923820dcc509a6f75849b','2');
insert into tab_person (uuid, person_name, sex, age, telephone, email, acc_uuid,city_id) values 
('07dd3b31b1574bf3b42f6de34ec7e124','外系统查看人员',1,0,'18691026980','','a98ea24502694850bc0ac8121a83d97a','00');
insert into tab_acc_role (acc_uuid, role_uuid) values ('a98ea24502694850bc0ac8121a83d97a','fcbd8c27372346e198bc2eae52b1643e');



--------------新闻资源脚本
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum,is_view) VALUES ('da271ee987da4c2d90f91573bd2a7dad', '行情资讯管理', 2, '', 'e51a8663876f4a3394bb194d89d96735', 'admin', '2017-09-15 00:11:07', '行情资讯管理', 30,1);
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum,is_view) VALUES ('90e372f048404a1eac921868b3497d35', '行情资讯列表', 3, '/website/backstage/tabNewsController.do?method=index', 'da271ee987da4c2d90f91573bd2a7dad', 'admin', '2017-09-15 00:29:57', '新闻信息', 25,1);
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum,is_view) VALUES ('aa8386c1771c40d795a53b9ee85ca575', '热点新闻添加', 3, '/jsp/backstage/news/newsaddoredit.jsp?newtype=1', 'da271ee987da4c2d90f91573bd2a7dad', 'admin', '2017-09-14 23:14:15', '热点新闻添加', 26,1);
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum,is_view) VALUES ('123a3b983b3246bb98de2ed39e10ac40', '实时资讯添加', 3, '/jsp/backstage/news/newsaddoredit.jsp?newtype=2', 'da271ee987da4c2d90f91573bd2a7dad', 'admin', '2017-09-14 00:00:00', '实时资讯添加', 29,1);
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum,is_view) VALUES ('097d7b066a66449d86334f48ad972e7a', '行业动向添加', 3, '/jsp/backstage/news/newsaddoredit.jsp?newtype=3', 'da271ee987da4c2d90f91573bd2a7dad', 'admin', '2017-09-14 00:00:00', '行业动向添加', 28,1);
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum, is_view) VALUES ('2df1b11499b64e4ea09d6490d565cf58', '会员新闻添加', 3, '/jsp/backstage/news/newsaddoredit.jsp?newtype=4', 'da271ee987da4c2d90f91573bd2a7dad', 'admin', '2017-11-18 20:58:37', '会员新闻添加', 38, 1);

INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum,is_view) VALUES ('6bc7c75254a840e9880c904973a49e98', '网站配置管理', 2, '', 'e51a8663876f4a3394bb194d89d96735', 'admin', '2017-09-15 00:29:57', '网站配置管理', 30,1);
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum, is_view) VALUES ('7ae04930c73643c8826b81239a2209e8', '用户列表', 3, '/jsp/backstage/webuser/user_list.jsp', '6bc7c75254a840e9880c904973a49e98', 'admin', '2017-11-08 00:00:00', '会员信息添加', 37, 1);


------------------新闻菜单和角色关系
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('efb74820f0564d02bb68fdf3190a6430', '90e372f048404a1eac921868b3497d35');
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('efb74820f0564d02bb68fdf3190a6430', 'aa8386c1771c40d795a53b9ee85ca575');
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('efb74820f0564d02bb68fdf3190a6430', 'da271ee987da4c2d90f91573bd2a7dad');
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('efb74820f0564d02bb68fdf3190a6430', '097d7b066a66449d86334f48ad972e7a');
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('efb74820f0564d02bb68fdf3190a6430', '123a3b983b3246bb98de2ed39e10ac40');
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('efb74820f0564d02bb68fdf3190a6430', '2df1b11499b64e4ea09d6490d565cf58');
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('efb74820f0564d02bb68fdf3190a6430', '6bc7c75254a840e9880c904973a49e98');
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('efb74820f0564d02bb68fdf3190a6430', '7ae04930c73643c8826b81239a2209e8');

INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('60fa2131c09448848f42a29e3b5ab421', '90e372f048404a1eac921868b3497d35');
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('60fa2131c09448848f42a29e3b5ab421', 'da271ee987da4c2d90f91573bd2a7dad');

INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('f20d3a2281ef4de29a7c8bc761d83701', '90e372f048404a1eac921868b3497d35');
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('f20d3a2281ef4de29a7c8bc761d83701', 'da271ee987da4c2d90f91573bd2a7dad');

INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('447a398c553d446283b030c2a5716a79', '90e372f048404a1eac921868b3497d35');
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('447a398c553d446283b030c2a5716a79', 'aa8386c1771c40d795a53b9ee85ca575');
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('447a398c553d446283b030c2a5716a79', 'da271ee987da4c2d90f91573bd2a7dad');
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('447a398c553d446283b030c2a5716a79', '097d7b066a66449d86334f48ad972e7a');
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('447a398c553d446283b030c2a5716a79', '123a3b983b3246bb98de2ed39e10ac40');
INSERT INTO tab_role_resource (role_id, resource_id) VALUES ('447a398c553d446283b030c2a5716a79', '2df1b11499b64e4ea09d6490d565cf58');



--------------新闻操作
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('4093d626accc44c580e2ea915db4c742', '90e372f048404a1eac921868b3497d35', '756d6e80c9d74b4389c918ab50ee19c3', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'getNewsByConditionBusinessMethod', 'NEWS_LIST', '新闻列表', '新闻列表', 11);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('4af86746772f4c40adac88f4a3ccd70d', '90e372f048404a1eac921868b3497d35', '022a43088dcd46d4b201b43b32d3d85a', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'executeReleaseNewsBusinessMethod', 'NEWS_RELEASE', '新闻发布', '新闻发布', 19);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('5d590288a2904be5a97679e066dca0c1', '90e372f048404a1eac921868b3497d35', 'fe755fa4bd25475fa1a9d841caa16f44', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'saveOrUpdateTabNewsBusinessMethod', 'NEWS_EDIT', '新闻编辑', '新闻编辑', 13);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('618c35390cc04b8a927f7f408f859ca0', '90e372f048404a1eac921868b3497d35', '022a43088dcd46d4b201b43b32d3d85a', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'getNewsByNewsUuid', 'NEWS_PRIVIEW', '预览', '行情资讯预览', 22);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('8083e515b2e84d81a7c891cef8119c74', '90e372f048404a1eac921868b3497d35', '022a43088dcd46d4b201b43b32d3d85a', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'executeAuditNewsBusinessMethod', 'NEWS_AUDIT', '新闻审核', '新闻审核', 18);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('80cbfd5bcbcc4b78ba9abbb1deac53f9', '90e372f048404a1eac921868b3497d35', '460283cc3e2c4d0a8b6bbbd75698a339', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'getNewsListByConditionBusinessMethod', 'NEWS_EXPORT', '新闻导出', '新闻导出功能', 17);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('998ef3e5f0374ca1bf6fb4fe0c51f240', '90e372f048404a1eac921868b3497d35', 'dec3b327b8a54d66bd644c544ea65c5e', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'deleteTabNewsByUuidsBusinessMethod', 'NEWS_DELETE', '新闻删除', '新闻删除', 14);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('28b13f095f204b278c6dfcb724dc2840', 'aa8386c1771c40d795a53b9ee85ca575', '607e8bc6f9bb4afa9be3cfdc72a1a326', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'saveOrUpdateTabNewsBusinessMethod', 'NEWS_ADD', '新闻新增', '新闻新增', 12);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('ca7ef06da4904382b1f3eace2813feea', '2df1b11499b64e4ea09d6490d565cf58', '607e8bc6f9bb4afa9be3cfdc72a1a326', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'saveOrUpdateTabNewsBusinessMethod', 'MEMBERINFO_ADD', '会员新闻添加', '会员新闻添加', 27);

------------------新闻操作和角色关系
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '4093d626accc44c580e2ea915db4c742');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '4af86746772f4c40adac88f4a3ccd70d');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '5d590288a2904be5a97679e066dca0c1');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '618c35390cc04b8a927f7f408f859ca0');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '8083e515b2e84d81a7c891cef8119c74');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '80cbfd5bcbcc4b78ba9abbb1deac53f9');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '998ef3e5f0374ca1bf6fb4fe0c51f240');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '28b13f095f204b278c6dfcb724dc2840');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', 'ca7ef06da4904382b1f3eace2813feea');

INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('60fa2131c09448848f42a29e3b5ab421', '4093d626accc44c580e2ea915db4c742');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('60fa2131c09448848f42a29e3b5ab421', '8083e515b2e84d81a7c891cef8119c74');

INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('f20d3a2281ef4de29a7c8bc761d83701', '8083e515b2e84d81a7c891cef8119c74');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('f20d3a2281ef4de29a7c8bc761d83701', '4093d626accc44c580e2ea915db4c742');

--INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', '118996db35a842ae87eb18398b75b14d');
--INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('efb74820f0564d02bb68fdf3190a6430', 'd4501574a62349a99309b80e1f598299');

INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('447a398c553d446283b030c2a5716a79', '28b13f095f204b278c6dfcb724dc2840');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('447a398c553d446283b030c2a5716a79', '4093d626accc44c580e2ea915db4c742');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('447a398c553d446283b030c2a5716a79', '5d590288a2904be5a97679e066dca0c1');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('447a398c553d446283b030c2a5716a79', '618c35390cc04b8a927f7f408f859ca0');
INSERT INTO tab_role_operate (role_uuid, operate_uuid) VALUES ('447a398c553d446283b030c2a5716a79', '998ef3e5f0374ca1bf6fb4fe0c51f240');



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
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseListBusinessMethod','工作管理信息列表','工作管理信息列表',1,'INFO_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('d2b7ca015be7406d9ba6cf6e8320725f','48711882b7e04641a5d8f4994a97ef5f','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','deleteInfoReleaseByUuidsBusinessMethod','工作管理信息删除','工作管理信息删除',1,'INFO_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('d92ef23952da49d5b7483e36692f5bf7','48711882b7e04641a5d8f4994a97ef5f','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeAuditModuleBusinessMethod','工作管理信息审核','工作管理信息审核',1,'INFO_AUDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('ac420384a652446aa88faab1d2fdb94f','48711882b7e04641a5d8f4994a97ef5f','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeReleaseModuleBusinessMethod','工作管理信息发布','工作管理信息发布',1,'INFO_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('075e0149f69e4e93b5c4993dbea831c1','48711882b7e04641a5d8f4994a97ef5f','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','工作管理信息编辑','工作管理信息编辑',1,'INFO_EDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('37c0625ab4764ec78d62d73d122dcfc0','48711882b7e04641a5d8f4994a97ef5f','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseByUuidBusinessMethod','工作管理信息预览','工作管理信息预览',1,'INFO_PREVIEW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('91e05765fe6d495e9bc1d629e7b83c03','48711882b7e04641a5d8f4994a97ef5f','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','工作管理信息添加','工作管理信息添加',1,'INFO_ADD');
--初始化操作信息（创新工作室-优秀创新）
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('78edb8493ef84441b7c630173053d2dc','c712464e336d4ae6988bd27ba35f17d4','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService','getInnovationListBusinessMethod','优秀创新列表','优秀创新列表',1,'INFO_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('7bbc0f222e0f42a597ba5cffce440cbe','c712464e336d4ae6988bd27ba35f17d4','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService','deleteBusinessMethod','优秀创新删除','优秀创新删除',1,'INFO_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('e5273ea7826f4273a4820937d1c31727','c712464e336d4ae6988bd27ba35f17d4','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService','executeAuditBusinessMethod','优秀创新审核','优秀创新审核',1,'INFO_AUDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('b01f1887f07c4588ba63ae253322bea6','c712464e336d4ae6988bd27ba35f17d4','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService','executeReleaseBusinessMethod','优秀创新发布','优秀创新发布',1,'INFO_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('e9b2f5f9829a4272afd8bbeed31b534a','c712464e336d4ae6988bd27ba35f17d4','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService','saveOrUpdateInnovationBusinessMethod','优秀创新编辑','优秀创新编辑',1,'INFO_EDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('f47a460ada924db88ab449ffb4458c76','c712464e336d4ae6988bd27ba35f17d4','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService','getInnovationByUuidBusinessMethod','优秀创新预览','优秀创新预览',1,'INFO_PREVIEW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('40bc6c6434b541de85e170c58a5642d5','c712464e336d4ae6988bd27ba35f17d4','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService','saveOrUpdateInnovationBusinessMethod','优秀创新添加','优秀创新添加',1,'INFO_ADD');

--初始化操作信息(援助帮扶-法条维护)
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('5a9eb8f7483240cc9da4555a10440245','1b0cd1d267c948e2886ef98e5a76a578','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseListBusinessMethod','法条维护信息列表','法条维护信息列表',1,'INFO_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('3b12648e06924d0897c3fa2cb920e165','1b0cd1d267c948e2886ef98e5a76a578','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','deleteInfoReleaseByUuidsBusinessMethod','法条维护信息删除','法条维护信息删除',1,'INFO_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('d2ae7226856f4debade44aafb5d0247c','1b0cd1d267c948e2886ef98e5a76a578','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeAuditModuleBusinessMethod','法条维护信息审核','法条维护信息审核',1,'INFO_AUDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('a0b827d143fa4874909f85cb7de21b23','1b0cd1d267c948e2886ef98e5a76a578','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeReleaseModuleBusinessMethod','法条维护信息发布','法条维护信息发布',1,'INFO_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('b2124a5d6a2540d7b58ef851c8b198f8','1b0cd1d267c948e2886ef98e5a76a578','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','法条维护信息编辑','法条维护信息编辑',1,'INFO_EDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('fa25528cca6b41c48048532ae3c5bba5','1b0cd1d267c948e2886ef98e5a76a578','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseByUuidBusinessMethod','法条维护信息预览','法条维护信息预览',1,'INFO_PREVIEW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('1b4ccd2a2f0a416d9a1bae77c6353e18','1b0cd1d267c948e2886ef98e5a76a578','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','法条维护信息添加','法条维护信息添加',1,'INFO_ADD');

--初始化操作信息(文体协会-工作发布)
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('4855162ac2014d3fb5cf5bee17075e28','0b62d21d1ecd471f958d96b43471dcca','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseListBusinessMethod','工作发布列表','工作发布列表',1,'INFO_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('392b972ef167498896caa46644221319','0b62d21d1ecd471f958d96b43471dcca','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','deleteInfoReleaseByUuidsBusinessMethod','工作发布信息删除','删除',1,'INFO_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('5b4bea13b8dc4b6eac9ea7a7f6867456','0b62d21d1ecd471f958d96b43471dcca','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeAuditModuleBusinessMethod','工作发布信息审核','审核',1,'INFO_AUDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('c3cdc2664df14b07a5994f2b9bc2ca03','0b62d21d1ecd471f958d96b43471dcca','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeReleaseModuleBusinessMethod','工作发布信息发布','发布',1,'INFO_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('28979cdd48d04f83b5f79abf813e769c','0b62d21d1ecd471f958d96b43471dcca','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','工作发布信息编辑','编辑',1,'INFO_EDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('1f96c131e4b3436486f7e4c92e8399df','0b62d21d1ecd471f958d96b43471dcca','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseByUuidBusinessMethod','工作发布信息预览','预览',1,'INFO_PREVIEW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('8615ca6386f340b48e1992c676ee2606','0b62d21d1ecd471f958d96b43471dcca','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','工作发布信息添加','添加',1,'INFO_ADD');

--初始化操作信息(后勤中心-早知道)
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('f0ccd87dbc684eeca5b72a1bedbcb23e','f03a9f0f29d44a1da4376353809eb9e1','756d6e80c9d74b4389c918ab50ee19c3',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseListBusinessMethod','早知道信息列表','早知道信息列表',1,'INFO_LIST');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('8709a43fb0524f1dbce5680ee96f2b19','f03a9f0f29d44a1da4376353809eb9e1','dec3b327b8a54d66bd644c544ea65c5e',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','deleteInfoReleaseByUuidsBusinessMethod','早知道信息删除','早知道信息删除',1,'INFO_DEL');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('c78e811598154da2a34ea7acb5a22b36','f03a9f0f29d44a1da4376353809eb9e1','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeAuditModuleBusinessMethod','早知道信息审核','早知道信息审核',1,'INFO_AUDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('2f540e43e1bc4e1eb096ee0b2efa6b22','f03a9f0f29d44a1da4376353809eb9e1','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','executeReleaseModuleBusinessMethod','早知道信息发布','早知道信息发布',1,'INFO_RELEASE');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('b8eec2c860944dc68143822868dd1ee1','f03a9f0f29d44a1da4376353809eb9e1','fe755fa4bd25475fa1a9d841caa16f44',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','早知道信息编辑','早知道信息编辑',1,'INFO_EDIT');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('4c61947d93624a61af01981c46b0b063','f03a9f0f29d44a1da4376353809eb9e1','022a43088dcd46d4b201b43b32d3d85a',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','getInfoReleaseByUuidBusinessMethod','早知道信息预览','早知道信息预览',1,'INFO_PREVIEW');
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values 
('951d334e32104fb89c408c28319c42e6','f03a9f0f29d44a1da4376353809eb9e1','607e8bc6f9bb4afa9be3cfdc72a1a326',
'priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService','saveOrUpdateInfoReleaseBusinessMethod','早知道信息添加','早知道信息添加',1,'INFO_ADD');


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


