
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


INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('00', 'ʡ����', 'NULL', '', 1, 1);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0001', '������', '00', '', 2, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000101', '������', '0001', '', 3, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000102', '������', '0001', '', 4, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000103', '����', '0001', '', 5, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000104', '������', '0001', '', 6, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000105', '������', '0001', '', 7, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000106', '������', '0001', '', 8, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000107', '������', '0001', '', 9, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000108', '������', '0001', '', 10, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000109', 'δ����', '0001', '', 11, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000110', '�³���', '0001', '', 12, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000111', '������', '0001', '', 13, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000112', '�����', '0001', '', 14, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000113', '������', '0001', '', 15, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000114', '������', '0001', '', 16, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0002', '������', '00', '', 17, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000201', '�²���', '0002', '', 18, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000202', '������', '0002', '', 19, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000203', '������', '0002', '', 20, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000204', '�ɽ��', '0002', '', 21, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000205', 'ü��', '0002', '', 22, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000206', 'ǧ����', '0002', '', 23, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000207', '¤��', '0002', '', 24, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000208', '̫����', '0002', '', 25, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000209', '����', '0002', '', 26, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000210', '������', '0002', '', 27, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000211', 'μ����', '0002', '', 28, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000212', '��̨��', '0002', '', 29, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000213', '������', '0002', '', 29, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0003', '������', '00', '', 30, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000301', '��ƽ', '0003', '', 31, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000302', '�书', '0003', '', 32, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000303', '��ԭ', '0003', '', 33, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000304', '����', '0003', '', 34, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000305', '��Ȫ', '0003', '', 35, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000306', 'Ǭ��', '0003', '', 36, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000307', '����', '0003', '', 37, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000308', '����', '0003', '', 38, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000309', '����', '0003', '', 39, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000310', 'Ѯ��', '0003', '', 40, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000311', '����', '0003', '', 41, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000312', '�ض�', '0003', '', 42, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000313', 'μ��', '0003', '', 43, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0004', '������', '00', '', 44, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000401', 'ƽ��', '0004', '', 45, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000402', 'ʯȪ', '0004', '', 46, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000403', '��ƺ', '0004', '', 47, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000404', '����', '0004', '', 48, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000405', 'Ѯ��', '0004', '', 49, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000406', '�׺�', '0004', '', 50, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000407', '����', '0004', '', 51, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000408', '����', '0004', '', 52, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000409', '᰸�', '0004', '', 53, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000410', '������', '0004', '', 54, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0005', '������', '00', '', 55, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000501', '�ǹ�', '0005', '', 56, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000502', '��ƺ', '0005', '', 57, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000503', '����', '0005', '', 58, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000504', '����', '0005', '', 59, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000505', '����', '0005', '', 60, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000506', '��֣', '0005', '', 61, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000507', '����', '0005', '', 62, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000508', '���', '0005', '', 63, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000509', '����', '0005', '', 64, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000510', '��ǿ', '0005', '', 65, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000511', '��̨', '0005', '', 66, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0006', '������', '00', '', 67, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000601', '����', '0006', '', 68, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000602', '����', '0006', '', 69, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000603', '����', '0006', '', 70, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000604', 'ɽ��', '0006', '', 71, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000605', '��', '0006', '', 72, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000606', '��ˮ', '0006', '', 73, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000607', '����', '0006', '', 74, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0007', 'ͭ����', '00', '', 75, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000701', '�˾�', '0007', '', 76, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000702', 'ҫ��', '0007', '', 77, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000703', '����', '0007', '', 78, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000704', 'ӡ̨', '0007', '', 79, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000705', '����', '0007', '', 80, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0008', 'μ����', '00', '', 81, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000801', '����', '0008', '', 82, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000802', '����', '0008', '', 83, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000803', '����', '0008', '', 84, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000804', '����', '0008', '', 85, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000805', '��ƽ', '0008', '', 86, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000806', '��ˮ', '0008', '', 87, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000807', '�ѳ�', '0008', '', 88, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000808', '����', '0008', '', 89, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000809', '�γ�', '0008', '', 90, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000810', '����', '0008', '', 91, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000811', '��μ��', '0008', '', 92, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000812', 'μ��', '0008', '', 93, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0009', '�Ӱ���', '00', '', 94, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000901', '����', '0009', '', 95, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000902', '�崨', '0009', '', 96, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000903', '��Ȫ', '0009', '', 97, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000904', '־��', '0009', '', 98, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000905', '�ӳ�', '0009', '', 99, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000906', '�ӳ�', '0009', '', 100, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000907', '����', '0009', '', 101, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000908', '�˴�', '0009', '', 102, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000909', '����', '0009', '', 103, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000910', '����', '0009', '', 104, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000911', '����', '0009', '', 105, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000912', '�Ӵ�', '0009', '', 106, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('000913', '������', '0009', '', 107, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('0010', '������', '00', '', 108, 2);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001001', '��֬', '0010', '', 109, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001002', '���', '0010', '', 110, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001003', '����', '0010', '', 111, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001004', '��ľ', '0010', '', 112, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001005', '����', '0010', '', 113, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001006', '��ɽ', '0010', '', 114, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001007', '����', '0010', '', 115, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001008', '����', '0010', '', 116, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001009', '�Ɽ', '0010', '', 117, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001010', '�彧', '0010', '', 118, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001011', '����', '0010', '', 119, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001012', '������', '0010', '', 120, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001013', '������', '0010', '', 121, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001014', '����', '0010', '', 122, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001015', '������', '0010', '', 123, 3);
INSERT INTO TAB_CITY (CITY_ID, CITY_NAME, PARENT_ID, REMARK, ORDERNUM, CITY_LAYER) VALUES ('001016', '����', '0010', '', 124, 3);

/**2��TAB_DATA_DICT�����ݳ�ʼ��**/
DELETE  FROM TAB_DATA_DICT WHERE DICT_TYPE='1';
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1','��','�Ƿ��ж�',1,1,'IF');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'2','��','�Ƿ��ж�',1,2,'IF');

DELETE  FROM TAB_DATA_DICT WHERE DICT_TYPE='2';
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(3,'1','��','�Ա�',2,1,'SEX');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(4,'2','Ů','�Ա�',2,2,'SEX');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(5,'3','����','�Ա�',2,3,'SEX');



/*-----------------------------��Ա�ͽ�ɫ-----------------------------*/
insert into tab_accounts (uuid, account_name, account_pass, is_locked) values
    ('38ee6b0869c9411a948d4bda69c2d216','admin','afdd0b4ad2ec172c586e2150770fbf9e','2');

insert into tab_person (uuid, person_name, sex, age, telephone, email, acc_uuid,city_id) values
    ('bd474935a3894530af485bea128501ec','ϵͳ����Ա',1,0,'18392101807','','38ee6b0869c9411a948d4bda69c2d216','00');

insert into tab_role (uuid, role_no, role_name, creator, create_time, remark)
values('efb74820f0564d02bb68fdf3190a6430','sys_manager','ϵͳ����Ա','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'������');

insert into tab_acc_role (acc_uuid, role_uuid) values ('38ee6b0869c9411a948d4bda69c2d216','efb74820f0564d02bb68fdf3190a6430');

update tab_accounts t set account_type=1 where account_type<>2 or account_type is null ;

INSERT INTO tab_group(uuid, group_name, group_type, group_code, parent_group_code, creator_name, create_time, remark, ordernum)
VALUES('e30f6d26f09646aaa18460c086a206da', 'ȱʡ��', 1, '10000', null, 'admin','2018-6-8 00:00:00' , '��Ŀ¼', 1);

/*-----------------------------ϵͳ�˵�-----------------------------*/
insert into tab_resource
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values
    ('e51a8663876f4a3394bb194d89d96735','PSMCϵͳ����Ŀ¼',1,'','0','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'��ϵͳ',0,1);

insert into tab_resource
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values
    ('f55580fa321b4d34a172628d5825c4dc','ϵͳ����',2,'','e51a8663876f4a3394bb194d89d96735','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'����ģ��',13,1);

insert into tab_resource
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values
    ('deab504ee54b4f10b65fb17c7615ab9c','�û�����',3,'','f55580fa321b4d34a172628d5825c4dc','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'�˵�',14,1);

insert into tab_resource
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values
    ('d4f3b60bfdcc4314baf65448d1284080','�˻���Ϣ',3,'/jsp/authentication/user/account_list.jsp','deab504ee54b4f10b65fb17c7615ab9c','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'�˵�',15,1);


insert into tab_resource
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values
    ('74385facee5148cbb0c9d69ecc1b8636','�޸�����',3,'/jsp/updatePasswd.jsp','deab504ee54b4f10b65fb17c7615ab9c','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'�˵�',16,1);

insert into tab_resource
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values
    ('9563b511d42f4768aa08cc506571de0a','��ɫ����',3,'','f55580fa321b4d34a172628d5825c4dc','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'�˵�',17,1);

insert into tab_resource
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values
    ('a807a90d00fb48c4bdf1d82ab41a9bc0','��ɫ��Ϣ',3,'/jsp/authentication/role/role_list.jsp','9563b511d42f4768aa08cc506571de0a','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'�˵�',18,1);


insert into tab_resource
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values
    ('8d5276afc8444b47a842da1f42aaac34','��Դ����',3,'','f55580fa321b4d34a172628d5825c4dc','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'�˵�',21,1);

insert into tab_resource
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values
    ('1a1a1817883142e7a9c9e06c477360cc','��Դ��Ϣ',3,'/jsp/authentication/resource/sys_resource_tree.jsp','8d5276afc8444b47a842da1f42aaac34','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'�˵�',22,1);



insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'e51a8663876f4a3394bb194d89d96735');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'f55580fa321b4d34a172628d5825c4dc');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'deab504ee54b4f10b65fb17c7615ab9c');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'd4f3b60bfdcc4314baf65448d1284080');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '74385facee5148cbb0c9d69ecc1b8636');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '9563b511d42f4768aa08cc506571de0a');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'a807a90d00fb48c4bdf1d82ab41a9bc0');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '8d5276afc8444b47a842da1f42aaac34');
insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '1a1a1817883142e7a9c9e06c477360cc');



/*-----------------------------ϵͳ����Ȩ�޶���-----------------------------*/

insert into tab_privilege (uuid, privilege_id, privilege_name, remark, creator_name, creator_time) values
    ('756d6e80c9d74b4389c918ab50ee19c3','query','��ѯ�б�','','admin',str_to_date('2016-8-9','%Y-%m-%d %T'));

insert into tab_privilege (uuid, privilege_id, privilege_name, remark, creator_name, creator_time) values
    ('607e8bc6f9bb4afa9be3cfdc72a1a326','add','����','','admin',str_to_date('2016-8-9','%Y-%m-%d %T'));

insert into tab_privilege (uuid, privilege_id, privilege_name, remark, creator_name, creator_time) values
    ('fe755fa4bd25475fa1a9d841caa16f44','update','�޸�','','admin',str_to_date('2016-8-9','%Y-%m-%d %T'));

insert into tab_privilege (uuid, privilege_id, privilege_name, remark, creator_name, creator_time) values
    ('dec3b327b8a54d66bd644c544ea65c5e','delete','ɾ��','','admin',str_to_date('2016-8-9','%Y-%m-%d %T'));

insert into tab_privilege (uuid, privilege_id, privilege_name, remark, creator_name, creator_time) values
    ('460283cc3e2c4d0a8b6bbbd75698a339','export','����','','admin',str_to_date('2016-8-9','%Y-%m-%d %T'));

insert into tab_privilege (uuid, privilege_id, privilege_name, remark, creator_name, creator_time) values
    ('d3ad7cefb81040ac8c935e7ee5602f5c','import','����','','admin',str_to_date('2016-8-9','%Y-%m-%d %T'));

insert into tab_privilege (uuid, privilege_id, privilege_name, remark, creator_name, creator_time) values
    ('022a43088dcd46d4b201b43b32d3d85a','deploy','����','','admin',str_to_date('2016-8-9','%Y-%m-%d %T'));

insert into tab_privilege (uuid, privilege_id, privilege_name, remark, creator_name, creator_time) values
    ('cb14b0e3d47647e58da01ab09e0d373c','undo','����','','admin',str_to_date('2021-6-23','%Y-%m-%d %T'));

/*-----------------------------����˵���ҵ�����-----------------------------*/
/*�˵�----[�˻���Ϣ]ҵ�����*/
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('14a2243153eb483caf3573246148e93c','d4f3b60bfdcc4314baf65448d1284080','756d6e80c9d74b4389c918ab50ee19c3',
     'priv.guochun.psmc.authentication.user.service.TabAccountService','getTabAccountsBusinessMethod','��ѯ','',1,'ACCOUNT_QUERY');


insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('3a764c1f79294c8b903ebb80abf07220','d4f3b60bfdcc4314baf65448d1284080','607e8bc6f9bb4afa9be3cfdc72a1a326',
     'priv.guochun.psmc.authentication.user.service.TabAccountService','saveOrUpdateBusinessMethod','����','',2,'ACCOUNT_ADD');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('705d01ec02d24d79bf9ea64c0a04385e','d4f3b60bfdcc4314baf65448d1284080','fe755fa4bd25475fa1a9d841caa16f44',
     'priv.guochun.psmc.authentication.user.service.TabAccountService','saveOrUpdateBusinessMethod','�޸�','',3,'ACCOUNT_UPDATE');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('8dfc1b3b65694a0a8ec7f9f09148f0f2','d4f3b60bfdcc4314baf65448d1284080','dec3b327b8a54d66bd644c544ea65c5e',
     'priv.guochun.psmc.authentication.user.service.TabAccountService','deletesBusinessMethod','ɾ��','',4,'ACCOUNT_DEL');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('8dfc1b3b65694a0a8ec7f9f09148f0f3','d4f3b60bfdcc4314baf65448d1284080','460283cc3e2c4d0a8b6bbbd75698a339',
     'priv.guochun.psmc.authentication.user.service.TabAccountService','getAllTabAccountsBusinessMethod','����','',5,'ACCOUNT_EXPORT');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','14a2243153eb483caf3573246148e93c');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','3a764c1f79294c8b903ebb80abf07220');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','705d01ec02d24d79bf9ea64c0a04385e');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','8dfc1b3b65694a0a8ec7f9f09148f0f2');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','8dfc1b3b65694a0a8ec7f9f09148f0f3');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','14a2243153eb483caf3573246148e93c');



/*�˵�----[��Դ��Ϣ]ҵ�����*/
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('24d1fd15ba54491982f91ed98f8e8d8c','1a1a1817883142e7a9c9e06c477360cc','756d6e80c9d74b4389c918ab50ee19c3',
     'priv.guochun.psmc.authentication.resource.service.TabResourceService','getSystemAllResourcesBusinessMethod','��ѯ','',1,'');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('6f0d3821e9cc43be828eeeedc95cf269','1a1a1817883142e7a9c9e06c477360cc','607e8bc6f9bb4afa9be3cfdc72a1a326',
     'priv.guochun.psmc.authentication.resource.service.TabResourceService','saveOrUpdateTabResourceBusinessMethod','����','',2,'RESOURCE_ADD');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('3408bb85700742e2b9142ee1c69eb21e','1a1a1817883142e7a9c9e06c477360cc','dec3b327b8a54d66bd644c544ea65c5e',
     'priv.guochun.psmc.authentication.resource.service.TabResourceService','deleteTabResourceBusinessMethod','ɾ��','',3,'RESOURCE_DEL');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('e5cb125131bf4978a1e166e0bcf631cf','1a1a1817883142e7a9c9e06c477360cc','fe755fa4bd25475fa1a9d841caa16f44',
     'priv.guochun.psmc.authentication.resource.service.TabResourceService','updateResourceTheParentUuidBusinessMethod','��ק','',4,'RESOURCE_DRAG');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('97edba427bbd40aea43295595a30cddd','1a1a1817883142e7a9c9e06c477360cc','fe755fa4bd25475fa1a9d841caa16f44',
     'priv.guochun.psmc.authentication.resource.service.TabResourceService','updateResourceTheNameBusinessMethod','����','',4,'RESOURCE_UPDATE');

INSERT INTO tab_operate VALUES ('23ef454491484c7b8665bef3390a0cc9', '1a1a1817883142e7a9c9e06c477360cc', '022a43088dcd46d4b201b43b32d3d85a', 'priv.guochun.psmc.authentication.operate.service.TabOperateService', 'getTabOperatesBusinessMethod', 'RESOURCE_OPERATE', '��Դҵ������', '', '32');

INSERT INTO tab_operate VALUES ('1bf34d6238ec40e4ba59007b2d9e4f10', '1a1a1817883142e7a9c9e06c477360cc', '607e8bc6f9bb4afa9be3cfdc72a1a326', 'priv.guochun.psmc.authentication.operate.service.TabOperateService', 'saveOrUpdateResOperateBusinessMethod', 'OPERATE_ADD', '����[��Դҵ���������]', '', '33');

INSERT INTO tab_operate VALUES ('de3c4bea21644074a5b5798bf0b67826', '1a1a1817883142e7a9c9e06c477360cc', 'fe755fa4bd25475fa1a9d841caa16f44', 'priv.guochun.psmc.authentication.operate.service.TabOperateService', 'saveOrUpdateResOperateBusinessMethod', 'OPERATE_UPDATE', '�޸�[��Դҵ���������]', '', '34');

INSERT INTO tab_operate VALUES ('a3c7dbf3c90a4917862ac036e94ed37c', '1a1a1817883142e7a9c9e06c477360cc', 'dec3b327b8a54d66bd644c544ea65c5e', 'priv.guochun.psmc.authentication.operate.service.TabOperateService', 'deleteOperateBusinessMethod', 'OPERATE_DEL', 'ɾ��[��Դҵ���������]', '', '35');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','24d1fd15ba54491982f91ed98f8e8d8c');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','6f0d3821e9cc43be828eeeedc95cf269');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','3408bb85700742e2b9142ee1c69eb21e');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','e5cb125131bf4978a1e166e0bcf631cf');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','97edba427bbd40aea43295595a30cddd');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','23ef454491484c7b8665bef3390a0cc9');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','1bf34d6238ec40e4ba59007b2d9e4f10');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','de3c4bea21644074a5b5798bf0b67826');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','a3c7dbf3c90a4917862ac036e94ed37c');



/*�˵�----[��ɫ��Ϣ]ҵ�����*/
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('dc5648b017404cbb80fcde8947b5bea3','a807a90d00fb48c4bdf1d82ab41a9bc0','756d6e80c9d74b4389c918ab50ee19c3',
     'priv.guochun.psmc.authentication.role.service.TabRoleService','getRolesListBusinessMethod','��ѯ','',1,'');


insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('5a06ae4977b6448e89eaba7029bb8286','a807a90d00fb48c4bdf1d82ab41a9bc0','607e8bc6f9bb4afa9be3cfdc72a1a326',
     'priv.guochun.psmc.authentication.role.service.TabRoleService','saveOrUpdateRoleBusinessMethod','����','',2,'ROLE_ADD');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('bd1aac73b28448abad87bc82d2b7049a','a807a90d00fb48c4bdf1d82ab41a9bc0','fe755fa4bd25475fa1a9d841caa16f44',
     'priv.guochun.psmc.authentication.role.service.TabRoleService','saveOrUpdateRoleBusinessMethod','�޸�','',3,'ROLE_UPDATE');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('9142c050077d49dabf323d06ac49a3c6','a807a90d00fb48c4bdf1d82ab41a9bc0','dec3b327b8a54d66bd644c544ea65c5e',
     'priv.guochun.psmc.authentication.role.service.TabRoleService','deletesRoleByUuidsBusinessMethod','ɾ��','',4,'ROLE_DEL');


insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('a5bf5461a44d4fc9b4531483dffa2192','a807a90d00fb48c4bdf1d82ab41a9bc0','022a43088dcd46d4b201b43b32d3d85a',
     'priv.guochun.psmc.authentication.resource.service.TabResourceService','saveOrUpateResourceRoleRelationBusinessMethod','��Դ��������','',5,'ROLE_HAVE_RESOURCE');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('35559c19ed964e37b2fbb0892b13b339','a807a90d00fb48c4bdf1d82ab41a9bc0','022a43088dcd46d4b201b43b32d3d85a',
     'priv.guochun.psmc.authentication.resource.service.TabResourceService','saveRoleResourceOperateRelationsBusinessMethod','ҵ���������','',6,'ROLE_HAVE_OPERATE');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('dc5648b017404cbb80fcde8947b8cea3','a807a90d00fb48c4bdf1d82ab41a9bc0','756d6e80c9d74b4389c918ab50ee19c3',
     'priv.guochun.psmc.authentication.role.service.TabRoleService','getRolesListBusinessMethod','��ѯ','',1,'');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('dc5648b017404cbb80fccf8947b8cea3','a807a90d00fb48c4bdf1d82ab41a9bc0','756d6e80c9d74b4389c918ab50ee19c3',
     'priv.guochun.psmc.authentication.role.service.TabRoleService','getRolesListBusinessMethod','����','',1,'');


insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','dc5648b017404cbb80fcde8947b5bea3');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','5a06ae4977b6448e89eaba7029bb8286');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','bd1aac73b28448abad87bc82d2b7049a');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','9142c050077d49dabf323d06ac49a3c6');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','a5bf5461a44d4fc9b4531483dffa2192');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','dc5648b017404cbb80fccf8947b8cea3');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','dc5648b017404cbb80fcde8947b8cea3');
insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','35559c19ed964e37b2fbb0892b13b339');



delete from tab_role_resource where resource_id='a75345fa89e5409684a2795eed7f5900';
delete from tab_resource where uuid='a75345fa89e5409684a2795eed7f5900';

insert into tab_resource
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values
    ('a75345fa89e5409684a2795eed7f5900','�û���',3,'/jsp/authentication/user/tab_group_tree.jsp','deab504ee54b4f10b65fb17c7615ab9c','admin',str_to_date('2018-6-8','%Y-%m-%d %T'),'�˵�',17,1);

insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', 'a75345fa89e5409684a2795eed7f5900');

/*�û������*/

/**��ѯ*/
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('cf083ec8d0a24a9a94798fe897d1fcf1','a75345fa89e5409684a2795eed7f5900','756d6e80c9d74b4389c918ab50ee19c3',
     'priv.guochun.psmc.authentication.user.service.TabGroupService','getTabGroupsBusinessMethod','[��ѯ]','',1,'USER_GROUP_QUERY');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','cf083ec8d0a24a9a94798fe897d1fcf1');

/**�޸�����*/

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('05e5d3c16d054483ab95c4892c33979d','a75345fa89e5409684a2795eed7f5900','fe755fa4bd25475fa1a9d841caa16f44',
     'priv.guochun.psmc.authentication.user.service.TabGroupService','updateParentGroupCodeBusinessMethod','[�������޸�]','',2,'USER_GROUP_PARENT_UPDATE');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','05e5d3c16d054483ab95c4892c33979d');


/*����*/
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('952197c168944aa19d0930f383eeae5c','a75345fa89e5409684a2795eed7f5900','607e8bc6f9bb4afa9be3cfdc72a1a326',
     'priv.guochun.psmc.authentication.user.service.TabGroupService','saveTabGroupBusinessMethod','[����]','',3,'USER_GROUP_ADD');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','952197c168944aa19d0930f383eeae5c');

/*�޸�*/
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('2bc28c4901fc4e169ba1fa10abaf95d1','a75345fa89e5409684a2795eed7f5900','fe755fa4bd25475fa1a9d841caa16f44',
     'priv.guochun.psmc.authentication.user.service.TabGroupService','updateTabGroupBusinessMethod','[�޸�]','',4,'USER_GROUP_UPDATE');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','2bc28c4901fc4e169ba1fa10abaf95d1');

/*ɾ��*/
insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('f27181121e0f4de6aaac05468a3cff3f','a75345fa89e5409684a2795eed7f5900','dec3b327b8a54d66bd644c544ea65c5e',
     'priv.guochun.psmc.authentication.user.service.TabGroupService','deleteTabGroupBusinessMethod','[ɾ��]','',5,'USER_GROUP_DEL');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','f27181121e0f4de6aaac05468a3cff3f');

/**��־�б�˵�*/
delete from tab_role_resource where resource_id='6b5de11e5c0e4a53aad76f74fd6a1df6';
delete from tab_resource where uuid='6b5de11e5c0e4a53aad76f74fd6a1df6';

insert into tab_resource
(uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark,ordernum,is_view) values
    ('6b5de11e5c0e4a53aad76f74fd6a1df6','��־�б�',3,'/jsp/system/common/log/sysOperLog_list.jsp','f55580fa321b4d34a172628d5825c4dc','admin',str_to_date('2018-6-6','%Y-%m-%d %T'),'�˵�',16,1);


insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '6b5de11e5c0e4a53aad76f74fd6a1df6');

/*�����ֵ�*/
delete from tab_role_operate where operate_uuid in(select uuid from tab_operate where resource_uuid in('5a5ea8abd5fd4e09822c4b7261e8bca3'));
delete from tab_operate where resource_uuid in('5a5ea8abd5fd4e09822c4b7261e8bca3');
delete from tab_role_resource where resource_id in('5a5ea8abd5fd4e09822c4b7261e8bca3');
delete  from tab_resource where uuid  in('5a5ea8abd5fd4e09822c4b7261e8bca3');

INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum, is_view)
VALUES ('5a5ea8abd5fd4e09822c4b7261e8bca3', '�ֵ����', 3, '/jsp/system/common/dict/dict.jsp', 'f55580fa321b4d34a172628d5825c4dc', 'admin', '2022-09-01 15:14:13', '�˵�', 30, 1);

insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '5a5ea8abd5fd4e09822c4b7261e8bca3');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('7495dbcf320946bfa898a8760f4e4f11','5a5ea8abd5fd4e09822c4b7261e8bca3','756d6e80c9d74b4389c918ab50ee19c3',
     'priv.guochun.psmc.system.common.dict.service.TabDataDictService','getDictDataListBusinessMethod','[��ѯ]','[��ѯ]',1,'FLOW_WAIT_RECEIVE_TASKS_LIST');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '7495dbcf320946bfa898a8760f4e4f11');

/*���ù���*/
delete from tab_role_operate where operate_uuid in(select uuid from tab_operate where resource_uuid in('839ba576c57047e8bd1ddc9a3c9fedbc'));
delete from tab_operate where resource_uuid in('839ba576c57047e8bd1ddc9a3c9fedbc');
delete from tab_role_resource where resource_id in('839ba576c57047e8bd1ddc9a3c9fedbc');
delete  from tab_resource where uuid  in('839ba576c57047e8bd1ddc9a3c9fedbc');

INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum, is_view) VALUES
    ('839ba576c57047e8bd1ddc9a3c9fedbc', '���ù���', 3, '/jsp/system/common/sysconfig/sysKeylist.jsp', 'f55580fa321b4d34a172628d5825c4dc', 'admin', '2022-09-01 15:14:13', '�˵�', 31, 1);

insert into tab_role_resource (role_id, resource_id) values ('efb74820f0564d02bb68fdf3190a6430', '839ba576c57047e8bd1ddc9a3c9fedbc');

insert into tab_operate (uuid, resource_uuid, privilege_uuid,fun_class,fun_method,operate_name,operate_desc,ordernum,OPERATE_NO) values
    ('2c4806c8d9b84f47b4e4b778e2f61e8f','839ba576c57047e8bd1ddc9a3c9fedbc','756d6e80c9d74b4389c918ab50ee19c3',
     'priv.guochun.psmc.system.common.sysConfig.service.TabSysKeyInfoService','selectAllSysKeyInfosBusinessMethod','[��ѯ]','[��ѯ]',1,'FLOW_WAIT_RECEIVE_TASKS_LIST');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430', '2c4806c8d9b84f47b4e4b778e2f61e8f');
