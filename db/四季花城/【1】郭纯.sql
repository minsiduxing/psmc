

update tab_person set person_name='系统管理员' where uuid='bd474935a3894530af485bea128501ec';
delete from tab_group where group_type=2;
update tab_group set group_name='默认组' where group_code='10000';


update tab_resource set is_view='2';
update tab_resource set is_view='1' where uuid='e51a8663876f4a3394bb194d89d96735';
update tab_resource set is_view='1' where uuid='05c8cface02b44cfbd8f906f791cf775';
update tab_resource set is_view='1' where uuid='fde5fcdbb47c4ad693f26d8d13cb99ce';
update tab_resource set is_view='1',parent_resource_uuid='05c8cface02b44cfbd8f906f791cf775' where uuid='6b5de11e5c0e4a53aad76f74fd6a1df6';
update tab_resource set is_view='1' where uuid='fde5fcdbb47c4ad693f26d8d13cb99ce';



