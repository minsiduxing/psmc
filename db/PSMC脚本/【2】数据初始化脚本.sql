
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
    ('38ee6b0869c9411a948d4bda69c2d216','admin','MDc4ca4238a0b923820dcc509a6f75849','2');

insert into tab_person (uuid, person_name, sex, age, telephone, email, acc_uuid,city_id) values
    ('bd474935a3894530af485bea128501ec','���',1,0,'13572568827','','38ee6b0869c9411a948d4bda69c2d216','00');

insert into tab_role (uuid, role_no, role_name, creator, create_time, remark)
values('efb74820f0564d02bb68fdf3190a6430','sys_manager','ϵͳ����Ա','admin',str_to_date('2016-8-9','%Y-%m-%d %T'),'ϵͳȨ�����Ĺ�����');

insert into tab_acc_role (acc_uuid, role_uuid) values ('38ee6b0869c9411a948d4bda69c2d216','efb74820f0564d02bb68fdf3190a6430');


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
    ('14a2243153eb483caf3573246148e9cc','d4f3b60bfdcc4314baf65448d1284080','756d6e80c9d74b4389c918ab50ee19c3',
     'priv.guochun.psmc.authentication.user.service.TabAccountService','getTabAccountsBusinessMethod','��ѯ','',1,'');

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
     'priv.guochun.psmc.authentication.user.service.TabAccountService','getTabAccountsBusinessMethod','����','',5,'ACCOUNT_EXPORT');

insert into tab_role_operate (role_uuid, operate_uuid) values ('efb74820f0564d02bb68fdf3190a6430','14a2243153eb483caf3573246148e9cc');
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


/**
--------------���Ž�ɫ�ű�
INSERT INTO tab_role (uuid, role_no, role_name, creator, create_time, remark) VALUES ('447a398c553d446283b030c2a5716a79', 'sys_news_add', '���������Ա', 'admin', '2017-09-24 17:05:01', '���������Ա');
INSERT INTO tab_role (uuid, role_no, role_name, creator, create_time, remark) VALUES ('60fa2131c09448848f42a29e3b5ab421', 'sys_news_audit', 'ϵͳ�������', 'admin', '2017-09-08 23:27:47', '���������Ϣ');
INSERT INTO tab_role (uuid, role_no, role_name, creator, create_time, remark) VALUES ('f20d3a2281ef4de29a7c8bc761d83701', 'sys_news_release', 'ϵͳ���ŷ���Ա', 'admin', '2017-09-08 23:28:39', '��������');
INSERT INTO tab_role (uuid, role_no, role_name, creator, create_time, remark) VALUES ('fcbd8c27372346e198bc2eae52b1643e', 'sys_news_query', '�鿴Ȩ��', 'admin', '2017-09-08 23:28:39', '');


insert into tab_accounts (uuid, account_name, account_pass, is_locked) values 
('a98ea24502694850bc0ac8121a83d97a','query','c4ca4238a0b923820dcc509a6f75849b','2');
insert into tab_person (uuid, person_name, sex, age, telephone, email, acc_uuid,city_id) values 
('07dd3b31b1574bf3b42f6de34ec7e124','��ϵͳ�鿴��Ա',1,0,'18691026980','','a98ea24502694850bc0ac8121a83d97a','00');
insert into tab_acc_role (acc_uuid, role_uuid) values ('a98ea24502694850bc0ac8121a83d97a','fcbd8c27372346e198bc2eae52b1643e');



--------------������Դ�ű�
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum,is_view) VALUES ('da271ee987da4c2d90f91573bd2a7dad', '������Ѷ����', 2, '', 'e51a8663876f4a3394bb194d89d96735', 'admin', '2017-09-15 00:11:07', '������Ѷ����', 30,1);
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum,is_view) VALUES ('90e372f048404a1eac921868b3497d35', '������Ѷ�б�', 3, '/website/backstage/tabNewsController.do?method=index', 'da271ee987da4c2d90f91573bd2a7dad', 'admin', '2017-09-15 00:29:57', '������Ϣ', 25,1);
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum,is_view) VALUES ('aa8386c1771c40d795a53b9ee85ca575', '�ȵ��������', 3, '/jsp/backstage/news/newsaddoredit.jsp?newtype=1', 'da271ee987da4c2d90f91573bd2a7dad', 'admin', '2017-09-14 23:14:15', '�ȵ��������', 26,1);
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum,is_view) VALUES ('123a3b983b3246bb98de2ed39e10ac40', 'ʵʱ��Ѷ���', 3, '/jsp/backstage/news/newsaddoredit.jsp?newtype=2', 'da271ee987da4c2d90f91573bd2a7dad', 'admin', '2017-09-14 00:00:00', 'ʵʱ��Ѷ���', 29,1);
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum,is_view) VALUES ('097d7b066a66449d86334f48ad972e7a', '��ҵ�������', 3, '/jsp/backstage/news/newsaddoredit.jsp?newtype=3', 'da271ee987da4c2d90f91573bd2a7dad', 'admin', '2017-09-14 00:00:00', '��ҵ�������', 28,1);
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum, is_view) VALUES ('2df1b11499b64e4ea09d6490d565cf58', '��Ա�������', 3, '/jsp/backstage/news/newsaddoredit.jsp?newtype=4', 'da271ee987da4c2d90f91573bd2a7dad', 'admin', '2017-11-18 20:58:37', '��Ա�������', 38, 1);

INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum,is_view) VALUES ('6bc7c75254a840e9880c904973a49e98', '��վ���ù���', 2, '', 'e51a8663876f4a3394bb194d89d96735', 'admin', '2017-09-15 00:29:57', '��վ���ù���', 30,1);
INSERT INTO tab_resource (uuid, resource_name, resource_type, resource_url, parent_resource_uuid, creator_name, create_time, remark, ordernum, is_view) VALUES ('7ae04930c73643c8826b81239a2209e8', '�û��б�', 3, '/jsp/backstage/webuser/user_list.jsp', '6bc7c75254a840e9880c904973a49e98', 'admin', '2017-11-08 00:00:00', '��Ա��Ϣ���', 37, 1);


------------------���Ų˵��ͽ�ɫ��ϵ
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



--------------���Ų���
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('4093d626accc44c580e2ea915db4c742', '90e372f048404a1eac921868b3497d35', '756d6e80c9d74b4389c918ab50ee19c3', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'getNewsByConditionBusinessMethod', 'NEWS_LIST', '�����б�', '�����б�', 11);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('4af86746772f4c40adac88f4a3ccd70d', '90e372f048404a1eac921868b3497d35', '022a43088dcd46d4b201b43b32d3d85a', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'executeReleaseNewsBusinessMethod', 'NEWS_RELEASE', '���ŷ���', '���ŷ���', 19);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('5d590288a2904be5a97679e066dca0c1', '90e372f048404a1eac921868b3497d35', 'fe755fa4bd25475fa1a9d841caa16f44', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'saveOrUpdateTabNewsBusinessMethod', 'NEWS_EDIT', '���ű༭', '���ű༭', 13);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('618c35390cc04b8a927f7f408f859ca0', '90e372f048404a1eac921868b3497d35', '022a43088dcd46d4b201b43b32d3d85a', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'getNewsByNewsUuid', 'NEWS_PRIVIEW', 'Ԥ��', '������ѶԤ��', 22);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('8083e515b2e84d81a7c891cef8119c74', '90e372f048404a1eac921868b3497d35', '022a43088dcd46d4b201b43b32d3d85a', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'executeAuditNewsBusinessMethod', 'NEWS_AUDIT', '�������', '�������', 18);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('80cbfd5bcbcc4b78ba9abbb1deac53f9', '90e372f048404a1eac921868b3497d35', '460283cc3e2c4d0a8b6bbbd75698a339', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'getNewsListByConditionBusinessMethod', 'NEWS_EXPORT', '���ŵ���', '���ŵ�������', 17);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('998ef3e5f0374ca1bf6fb4fe0c51f240', '90e372f048404a1eac921868b3497d35', 'dec3b327b8a54d66bd644c544ea65c5e', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'deleteTabNewsByUuidsBusinessMethod', 'NEWS_DELETE', '����ɾ��', '����ɾ��', 14);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('28b13f095f204b278c6dfcb724dc2840', 'aa8386c1771c40d795a53b9ee85ca575', '607e8bc6f9bb4afa9be3cfdc72a1a326', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'saveOrUpdateTabNewsBusinessMethod', 'NEWS_ADD', '��������', '��������', 12);
INSERT INTO tab_operate (uuid, resource_uuid, privilege_uuid, fun_class, fun_method, OPERATE_NO, OPERATE_NAME, OPERATE_DESC, ORDERNUM) VALUES ('ca7ef06da4904382b1f3eace2813feea', '2df1b11499b64e4ea09d6490d565cf58', '607e8bc6f9bb4afa9be3cfdc72a1a326', 'priv.guochun.psmc.website.backstage.news.service.TabNewsService', 'saveOrUpdateTabNewsBusinessMethod', 'MEMBERINFO_ADD', '��Ա�������', '��Ա�������', 27);

------------------���Ų����ͽ�ɫ��ϵ
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

**/



