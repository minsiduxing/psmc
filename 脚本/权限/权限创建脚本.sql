/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     2016/8/24 21:07:44                           */
/*==============================================================*/


alter table tab_acc_role drop constraint fk_tab_acc__fk2_tab_acco;

alter table tab_acc_role drop constraint fk_tab_acc__fk3_tab_role;

alter table tab_operate drop constraint fk_tab_oper_fk5_tab_reso;

alter table tab_operate drop constraint fk_tab_oper_fk7_tab_priv;

alter table tab_person drop constraint fk_tab_pers_fk1_tab_acco;

alter table tab_role_operate drop constraint fk_tab_role_fk4_tab_role;

alter table tab_role_operate drop constraint fk_tab_role_fk6_tab_oper;

alter table tab_role_resource drop constraint fk_tab_role_fk8_tab_role;

alter table tab_role_resource drop constraint fk_tab_role_fk9_tab_reso;

drop table tab_acc_role cascade constraints;

drop index index_accloginname;

drop table tab_accounts cascade constraints;

drop table tab_operate cascade constraints;

drop table tab_person cascade constraints;

drop table tab_privilege cascade constraints;

drop table tab_resource cascade constraints;

drop index index_roleno;

drop table tab_role cascade constraints;

drop table tab_role_operate cascade constraints;

drop table tab_role_resource cascade constraints;

/*==============================================================*/
/* Table: tab_acc_role                                          */
/*==============================================================*/
create table tab_acc_role  (
   acc_uuid             varchar(100)                    not null,
   role_uuid            varchar(100)                    not null,
   constraint pk_tab_acc_role primary key (role_uuid, acc_uuid)
)
tablespace tablespace_auth;

/*==============================================================*/
/* Table: tab_accounts                                          */
/*==============================================================*/
create table tab_accounts  (
   uuid                 varchar2(100)                   not null,
   account_name         varchar2(100),
   account_pass         varchar2(100),
   is_locked            varchar2(10),
   constraint pk_tab_accounts primary key (uuid)
)
tablespace tablespace_auth;

comment on column tab_accounts.is_locked is
'是/否';

/*==============================================================*/
/* Index: index_accloginname                                    */
/*==============================================================*/
create index index_accloginname on tab_accounts (
   account_name asc
);

/*==============================================================*/
/* Table: tab_operate                                           */
/*==============================================================*/
create table tab_operate  (
   uuid                 varchar(100)                    not null,
   resource_uuid        varchar(100)                    not null,
   privilege_uuid       varchar(100)                    not null,
   fun_class            varchar(200),
   fun_method           varchar(100),
   OPERATE_NAME  	VARCHAR2(200) NULL,
   OPERATE_DESC  	VARCHAR2(400) NULL,
   ORDERNUM      	NUMBER(10,0) NULL,
   constraint pk_tab_operate primary key (uuid)
)
tablespace tablespace_auth;

/*==============================================================*/
/* Table: tab_person                                            */
/*==============================================================*/
create table tab_person  (
   uuid                 varchar(100)                    not null,
   person_name          varchar(100),
   sex                  number(2),
   age                  number(3)                      default 0,
   telephone            varchar(100),
   email                varchar(100),
   acc_uuid             varchar(100),
   city_id             varchar(20),
   constraint pk_tab_person primary key (uuid)
)
tablespace tablespace_auth;

/*==============================================================*/
/* Table: tab_privilege                                         */
/*==============================================================*/
create table tab_privilege  (
   uuid                 varchar2(100)                   not null,
   privilege_id         varchar2(200),
   privilege_name       varchar2(200),
   remark               varchar2(400),
   creator_name         varchar2(200),
   creator_time         timestamp,
   constraint pk_tab_privilege primary key (uuid)
)
tablespace tablespace_auth;

/*==============================================================*/
/* Table: tab_resource                                          */
/*==============================================================*/
create table tab_resource  (
   uuid                 varchar(100)                    not null,
   resource_name        varchar(200),
   resource_type        int,
   resource_url         varchar(1000),
   parent_resource_uuid varchar(100),
   creator_name         varchar(200),
   create_time          timestamp,
   remark               varchar(400),
   ordernum             number(10),
   constraint pk_tab_resource primary key (uuid)
)
tablespace tablespace_auth;

comment on column tab_resource.resource_type is
'1子系统 2导航栏模块 3菜单';

/*==============================================================*/
/* Table: tab_role                                              */
/*==============================================================*/
create table tab_role  (
   uuid                 varchar(100)                    not null,
   role_no              varchar(100),
   role_name            varchar(100),
   creator              varchar(100),
   create_time          timestamp,
   remark               varchar(400),
   constraint pk_tab_role primary key (uuid)
)
tablespace tablespace_auth;

/*==============================================================*/
/* Index: index_roleno                                          */
/*==============================================================*/
create index index_roleno on tab_role (
   role_no asc
);

/*==============================================================*/
/* Table: tab_role_operate                                      */
/*==============================================================*/
create table tab_role_operate  (
   role_uuid            varchar(100)                    not null,
   operate_uuid         varchar(100)                    not null,
   constraint pk_tab_role_operate primary key (role_uuid, operate_uuid)
)
tablespace tablespace_auth;

/*==============================================================*/
/* Table: tab_role_resource                                     */
/*==============================================================*/
create table tab_role_resource  (
   role_id              varchar(100)                    not null,
   resource_id          varchar(100)                    not null,
   constraint pk_tab_role_resource primary key (role_id, resource_id)
);

alter table tab_acc_role
   add constraint fk_tab_acc__fk2_tab_acco foreign key (acc_uuid)
      references tab_accounts (uuid);

alter table tab_acc_role
   add constraint fk_tab_acc__fk3_tab_role foreign key (role_uuid)
      references tab_role (uuid);

alter table tab_operate
   add constraint fk_tab_oper_fk5_tab_reso foreign key (resource_uuid)
      references tab_resource (uuid);

alter table tab_operate
   add constraint fk_tab_oper_fk7_tab_priv foreign key (privilege_uuid)
      references tab_privilege (uuid);

alter table tab_person
   add constraint fk_tab_pers_fk1_tab_acco foreign key (acc_uuid)
      references tab_accounts (uuid);

alter table tab_role_operate
   add constraint fk_tab_role_fk4_tab_role foreign key (role_uuid)
      references tab_role (uuid);

alter table tab_role_operate
   add constraint fk_tab_role_fk6_tab_oper foreign key (operate_uuid)
      references tab_operate (uuid);

alter table tab_role_resource
   add constraint fk_tab_role_fk8_tab_role foreign key (role_id)
      references tab_role (uuid);

alter table tab_role_resource
   add constraint fk_tab_role_fk9_tab_reso foreign key (resource_id)
      references tab_resource (uuid);

