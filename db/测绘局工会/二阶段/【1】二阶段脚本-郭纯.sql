--增量脚本 解决1、账户、角色操作导出bug、账户增加分类字段


--删除多余账户操作
delete from tab_role_operate  where operate_uuid='14a2243153eb483caf3573246148e93c';
delete from tab_operate where uuid='14a2243153eb483caf3573246148e93c';
update tab_operate set operate_no='ACCOUNT_QUERY' where uuid='14a2243153eb483caf3573246148e9cc';
update tab_operate set fun_method='getAllTabAccountsBusinessMethod' where uuid='8dfc1b3b65694a0a8ec7f9f09148f0f3';
--删除多余角色操作
delete from tab_role_operate  where operate_uuid='dc5648b017404cbb80fcde8947b8cea3';
delete from tab_operate where uuid='dc5648b017404cbb80fcde8947b8cea3';
update tab_operate set operate_no='ROLE_QUERY' where uuid='dc5648b017404cbb80fcde8947b5bea3';
update tab_operate set operate_no='ROLE_EXPORT',ordernum=7,fun_method='getAllRolesListBusinessMethod' where uuid='dc5648b017404cbb80fccf8947b8cea3';

--增加账户分类
alter table tab_accounts drop column account_type;
alter table tab_accounts add column account_type TINYINT;

update tab_accounts t set account_type=2 where t.uuid in(
select uuid from (select a.uuid  from tab_accounts a,tab_person b,tab_group c where a.uuid=b.acc_uuid and b.groupid=c.group_code and c.group_code='1000016') a
);
update tab_accounts t set account_type=1 where account_type<>2 or account_type is null ;


DELETE FROM TAB_DATA_DICT WHERE DICT_NO='ACC_TYPE';
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(1,'1','后台系统账户','账户类型',11,1,'ACC_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(2,'2','微信订阅号账户','账户类型',11,2,'ACC_TYPE');
INSERT INTO TAB_DATA_DICT(ID,DICT_ID,DICT_NAME,REMARK,DICT_TYPE,ORDERNUM,DICT_NO) VALUES(3,'99','其他类型账户','账户类型',11,3,'ACC_TYPE');

