DROP sequence TAB_DATA_DICT_SEQ;
create sequence TAB_DATA_DICT_SEQ
minvalue 1
maxvalue 999999999999
start with 1
increment by 1;


DROP TABLE TAB_CITY;
CREATE TABLE TAB_CITY (CITY_ID VARCHAR2(50), CITY_NAME VARCHAR2(50), PARENT_ID VARCHAR2(50), REMARK VARCHAR2(20), ORDERNUM NUMBER, CITY_LAYER NUMBER) tablespace tablespace_business;
delete from TAB_CITY;
insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('00', '省中心', 'NULL', '', 1, 1);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('0001', '西安市', '00', '', 2, 2);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000101', '长安区', '0001', '', 3, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000102', '高陵县', '0001', '', 4, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000103', '户县', '0001', '', 5, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000104', '蓝田县', '0001', '', 6, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000105', '临潼区', '0001', '', 7, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000106', '阎良区', '0001', '', 8, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000107', '周至县', '0001', '', 9, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000108', '杨凌区', '0001', '', 10, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000109', '未央区', '0001', '', 11, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000110', '新城区', '0001', '', 12, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000111', '莲湖区', '0001', '', 13, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000112', '灞桥区', '0001', '', 14, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000113', '雁塔区', '0001', '', 15, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000114', '碑林区', '0001', '', 16, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('0002', '宝鸡市', '00', '', 17, 2);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000201', '陈仓区', '0002', '', 18, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000202', '扶风县', '0002', '', 19, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000203', '凤翔县', '0002', '', 20, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000204', '岐山县', '0002', '', 21, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000205', '眉县', '0002', '', 22, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000206', '千阳县', '0002', '', 23, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000207', '陇县', '0002', '', 24, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000208', '太白县', '0002', '', 25, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000209', '凤县', '0002', '', 26, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000210', '麟游县', '0002', '', 27, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000211', '渭滨区', '0002', '', 28, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000212', '金台区', '0002', '', 29, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000213', '高新区', '0002', '', 29, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('0003', '咸阳市', '00', '', 30, 2);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000301', '兴平', '0003', '', 31, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000302', '武功', '0003', '', 32, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000303', '三原', '0003', '', 33, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000304', '泾阳', '0003', '', 34, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000305', '礼泉', '0003', '', 35, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000306', '乾县', '0003', '', 36, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000307', '永寿', '0003', '', 37, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000308', '彬县', '0003', '', 38, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000309', '淳化', '0003', '', 39, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000310', '旬邑', '0003', '', 40, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000311', '长武', '0003', '', 41, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000312', '秦都', '0003', '', 42, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000313', '渭城', '0003', '', 43, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('0004', '安康市', '00', '', 44, 2);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000401', '平利', '0004', '', 45, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000402', '石泉', '0004', '', 46, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000403', '镇坪', '0004', '', 47, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000404', '汉阴', '0004', '', 48, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000405', '旬阳', '0004', '', 49, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000406', '白河', '0004', '', 50, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000407', '宁陕', '0004', '', 51, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000408', '紫阳', '0004', '', 52, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000409', '岚皋', '0004', '', 53, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000410', '汉滨区', '0004', '', 54, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('0005', '汉中市', '00', '', 55, 2);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000501', '城固', '0005', '', 56, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000502', '佛坪', '0005', '', 57, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000503', '留坝', '0005', '', 58, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000504', '略阳', '0005', '', 59, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000505', '勉县', '0005', '', 60, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000506', '南郑', '0005', '', 61, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000507', '洋县', '0005', '', 62, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000508', '镇巴', '0005', '', 63, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000509', '西乡', '0005', '', 64, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000510', '宁强', '0005', '', 65, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000511', '汉台', '0005', '', 66, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('0006', '商洛市', '00', '', 67, 2);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000601', '丹凤', '0006', '', 68, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000602', '洛南', '0006', '', 69, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000603', '商南', '0006', '', 70, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000604', '山阳', '0006', '', 71, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000605', '镇安', '0006', '', 72, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000606', '柞水', '0006', '', 73, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000607', '商州', '0006', '', 74, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('0007', '铜川市', '00', '', 75, 2);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000701', '宜君', '0007', '', 76, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000702', '耀州', '0007', '', 77, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000703', '王益', '0007', '', 78, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000704', '印台', '0007', '', 79, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000705', '新区', '0007', '', 80, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('0008', '渭南市', '00', '', 81, 2);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000801', '韩城', '0008', '', 82, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000802', '华阴', '0008', '', 83, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000803', '华县', '0008', '', 84, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000804', '潼关', '0008', '', 85, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000805', '富平', '0008', '', 86, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000806', '白水', '0008', '', 87, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000807', '蒲城', '0008', '', 88, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000808', '大荔', '0008', '', 89, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000809', '澄城', '0008', '', 90, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000810', '合阳', '0008', '', 91, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000811', '临渭区', '0008', '', 92, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000812', '渭北', '0008', '', 93, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('0009', '延安市', '00', '', 94, 2);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000901', '黄龙', '0009', '', 95, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000902', '洛川', '0009', '', 96, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000903', '甘泉', '0009', '', 97, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000904', '志丹', '0009', '', 98, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000905', '子长', '0009', '', 99, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000906', '延长', '0009', '', 100, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000907', '黄陵', '0009', '', 101, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000908', '宜川', '0009', '', 102, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000909', '富县', '0009', '', 103, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000910', '吴旗', '0009', '', 104, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000911', '安塞', '0009', '', 105, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000912', '延川', '0009', '', 106, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('000913', '宝塔区', '0009', '', 107, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('0010', '榆林市', '00', '', 108, 2);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('001001', '米脂', '0010', '', 109, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('001002', '绥德', '0010', '', 110, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('001003', '定边', '0010', '', 111, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('001004', '神木', '0010', '', 112, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('001005', '靖边', '0010', '', 113, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('001006', '横山', '0010', '', 114, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('001007', '府谷', '0010', '', 115, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('001008', '佳县', '0010', '', 116, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('001009', '吴堡', '0010', '', 117, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('001010', '清涧', '0010', '', 118, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('001011', '子洲', '0010', '', 119, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('001012', '榆阳区', '0010', '', 120, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('001013', '高新区', '0010', '', 121, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('001014', '锦界', '0010', '', 122, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('001015', '大柳塔', '0010', '', 123, 3);

insert into TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER)
values ('001016', '庙沟门', '0010', '', 124, 3);



DROP TABLE TAB_DATA_DICT;
CREATE TABLE TAB_DATA_DICT (DICT_ID VARCHAR2(100), DICT_NAME VARCHAR2(100), REMARK VARCHAR2(100), DICT_TYPE NUMBER, ORDERNUM NUMBER,id number(10),DICT_NO VARCHAR2(100))
tablespace tablespace_business;

delete  from TAB_DATA_DICT where dict_type='1';
insert into TAB_DATA_DICT select '1','移动','共享情况',1,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'SHARE' from dual;
insert into TAB_DATA_DICT select '2','联通','共享情况',1,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'SHARE' from dual;
insert into TAB_DATA_DICT select '3','电信','共享情况',1,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'SHARE' from dual;

delete  from TAB_DATA_DICT where dict_type='2';
insert into TAB_DATA_DICT select 'CITYNAME','地市','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'COUNTYNAME','区县','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'FILE_INPUT_DATE','电费数据所属月份','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'SIT_NAME','站点名称','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'SIT_ID_EX','站点编码','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'POWER_USER_NO','供电用户号','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'START_CODE','起码','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'END_CODE','止码','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'ELEC_COST','电价','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'ELEC_AMOUNT','电量','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'OPERATOR_BENCHMARK','运营商标杆','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'GENERAL_TICKET','普票','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'INCREASE_TICKET','增票','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'MAINTAIN_COST','维管费','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'TOTAL_ELEC_COST','电费合计','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
/**
insert into TAB_DATA_DICT select 'PURCHASE_COPY_DATE','购电抄表日期','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'PURCHASE_START_DATE','购电起始日期','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'PURCHASE_END_DATE','购电截止日期','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
**/
insert into TAB_DATA_DICT select 'IS_SHARE','是否共享','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'SHARE_SITUATION_NAME','共享情况','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'SHARE_MOVE','分摊比例(移动)','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'SHARE_MOVE_MONEY','分摊金额(元)(移动)','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'SHARE_UNICOM','分摊比例(联通)','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'SHARE_UNICOM_MONEY','分摊金额(元)(联通)','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'SHARE_TELECOM','分摊比例(电信)','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'SHARE_TELECOM_MONEY','分摊金额(元)(电信)','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'SHARE_START_DATE','共享起始日期','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'CONTRACT_ID','合同编号','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'CONTRACT_NAME','合同名称','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'OWNER_NAME','业主名称','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'CONTRACT_SIGN_DATE','合同签订日期','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'CONTRACT_START_DATE','合同起始日期','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'CONTRACT_END_DATE','合同终止日期','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'CONTRACT_MONEY','合同金额','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'FIELD_PAYMENT_CYCLE','场租支付周期','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'RENTAL_YEAR','年租金','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'CONTRACT_RENEW_DATE','合同续签日期','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'CONTRACT_RENEW_STARTD','续签起始日期','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'CONTRACT_RENEW_ENDD','续签终止日期','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'RENEW_MONEY','续签金额','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'IS_RENAME','是否更名','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'STATENAME','站点状态','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;
insert into TAB_DATA_DICT select 'POWERSUPPLYTYPENAME','供电方式','电费模型字段数据字典',2,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'ELE_MODEL_COLUMN'  from dual;


delete  from TAB_DATA_DICT where dict_type='3';
insert into TAB_DATA_DICT select '1','即将超期未续签','站点状态',3,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'SIT_STATE' from dual;
insert into TAB_DATA_DICT select '2','即将超期已续签','站点状态',3,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'SIT_STATE' from dual;
insert into TAB_DATA_DICT select '3','已超期未续签','站点状态',3,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'SIT_STATE' from dual;


delete  from TAB_DATA_DICT where dict_type='4';
insert into TAB_DATA_DICT select '15','15%','超标杆百分比',4,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'EXCEED_EXAMPLE' from dual;
insert into TAB_DATA_DICT select '20','20%','超标杆百分比',4,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'EXCEED_EXAMPLE' from dual;
insert into TAB_DATA_DICT select '40','40%','超标杆百分比',4,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'EXCEED_EXAMPLE' from dual;
insert into TAB_DATA_DICT select '60','60%','超标杆百分比',4,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'EXCEED_EXAMPLE' from dual;
insert into TAB_DATA_DICT select '80','80%','超标杆百分比',4,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'EXCEED_EXAMPLE' from dual;

delete  from TAB_DATA_DICT where dict_type='5';
insert into TAB_DATA_DICT select '10','10','TOPN',5,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'TOPN' from dual;
insert into TAB_DATA_DICT select '20','20','TOPN',5,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'TOPN' from dual;
insert into TAB_DATA_DICT select '50','50','TOPN',5,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'TOPN' from dual;
insert into TAB_DATA_DICT select '100','100','TOPN',5,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'TOPN' from dual;
insert into TAB_DATA_DICT select '200','200','TOPN',5,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'TOPN' from dual;

delete  from TAB_DATA_DICT where dict_type='6';
insert into TAB_DATA_DICT select '1','直供电','供电方式',6,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'FEED_POWER_TYPE' from dual;
insert into TAB_DATA_DICT select '2','转供电','供电方式',6,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'FEED_POWER_TYPE' from dual;

delete  from TAB_DATA_DICT where dict_type='7';
insert into TAB_DATA_DICT select '是','是','是否判断',7,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'IF' from dual;
insert into TAB_DATA_DICT select '否','否','是否判断',7,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'IF' from dual;

delete  from TAB_DATA_DICT where dict_type='8';
insert into TAB_DATA_DICT select '1','男','性别',8,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'SEX' from dual;
insert into TAB_DATA_DICT select '2','女','性别',8,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'SEX' from dual;
insert into TAB_DATA_DICT select '3','其他','性别',8,TAB_DATA_DICT_SEQ.currval,TAB_DATA_DICT_SEQ.nextval,'SEX' from dual;


commit;