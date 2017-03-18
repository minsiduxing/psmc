DROP sequence TAB_BASE_ELECTRIC_SEQ;
create sequence TAB_BASE_ELECTRIC_SEQ
minvalue 1
maxvalue 999999999999
start with 1
increment by 1;

DROP sequence TAB_MONTHLY_ELECTRIC_seq;
create sequence TAB_MONTHLY_ELECTRIC_seq
minvalue 1
maxvalue 999999999999
start with 1
increment by 1;


drop index tab_base_electric_index1;

drop table tab_base_electric cascade constraints;

/*==============================================================*/
/* Table: tab_base_electric                                     */
/*==============================================================*/
create table tab_base_electric  (
   id                   INT                             not null,
   city_id              VARCHAR(30),
   county_id            VARCHAR(30),
   sit_name             VARCHAR(400),
   sit_id_ex            VARCHAR(400)                    not null,
   power_user_no        VARCHAR(200),
   is_share             VARCHAR(10),
   share_situation_name VARCHAR(200),
   share_move           DECIMAL(15, 4),
   share_unicom         DECIMAL(15, 4),
   share_telecom        DECIMAL(15, 4),
   operator_benchmark   DECIMAL(15, 4),
   share_start_date     TIMESTAMP,
   contract_id          VARCHAR(400),
   contract_name        VARCHAR(400),
   owner_name           VARCHAR(400),
   contract_sign_date   TIMESTAMP,
   contract_start_date  TIMESTAMP,
   contract_end_date    TIMESTAMP,
   contract_money       DECIMAL(15, 4),
   field_payment_cycle  VARCHAR(400),
   rental_year          VARCHAR(400),
   contract_renew_date  TIMESTAMP,
   contract_renew_startd TIMESTAMP,
   contract_renew_endd  TIMESTAMP,
   renew_money          DECIMAL(15, 4),
   is_rename            VARCHAR(10),
   status               NUMBER(2),
   power_supply_type    NUMBER(2),
   constraint PK_TAB_BASE_ELECTRIC primary key (id)
)
tablespace tablespace_business;

/*==============================================================*/
/* Index: tab_base_electric_index1                              */
/*==============================================================*/
create unique index tab_base_electric_index1 on tab_base_electric (
   sit_id_ex ASC
);


drop index tab_monthly_electric_2015_ui1;

drop table tab_monthly_electric_2015 cascade constraints;

/*==============================================================*/
/* Table: tab_monthly_electric_2015                             */
/*==============================================================*/
create table tab_monthly_electric_2015  (
   id                   int                             not null,
   file_input_date      DATE,
   sit_id_ex            VARCHAR(400),
   start_code           DECIMAL(15, 4),
   end_code             DECIMAL(15, 4),
   elec_cost            DECIMAL(15, 4),
   elec_amount          DECIMAL(15, 4),
   operator_benchmark   DECIMAL(15, 4),
   general_ticket       DECIMAL(15, 4),
   increase_ticket      DECIMAL(15, 4),
   maintain_cost        DECIMAL(15, 4),
   total_elec_cost      DECIMAL(15, 4),
   purchase_copy_date   DATE,
   purchase_start_date  DATE,
   purchase_end_date    DATE,
   file_input_account   VARCHAR(40),
   is_share             VARCHAR(10),
   share_situation_name VARCHAR(200),
   share_move           DECIMAL(15, 4),
   share_move_money     DECIMAL(15, 4),
   share_telecom        DECIMAL(15, 4),
   share_telecom_money  DECIMAL(15, 4),
   share_unicom         DECIMAL(15, 4),
   share_unicom_money   DECIMAL(15, 4),
   base_electric_id     INT,
   constraint PK_TAB_MONTHLY_ELECTRIC_2015 primary key (id)
)
tablespace tablespace_business;

/*==============================================================*/
/* Index: tab_monthly_electric_2015_ui1                         */
/*==============================================================*/
create unique index tab_monthly_electric_2015_ui1 on tab_monthly_electric_2015 (
   file_input_date ASC,
   sit_id_ex ASC
);




drop index tab_monthly_electric_2016_ui1;

drop table tab_monthly_electric_2016 cascade constraints;

/*==============================================================*/
/* Table: tab_monthly_electric_2016                             */
/*==============================================================*/
create table tab_monthly_electric_2016  (
   id                   int                             not null,
   file_input_date      DATE,
   sit_id_ex            VARCHAR(400),
   start_code           DECIMAL(15, 4),
   end_code             DECIMAL(15, 4),
   elec_cost            DECIMAL(15, 4),
   elec_amount          DECIMAL(15, 4),
   operator_benchmark   DECIMAL(15, 4),
   general_ticket       DECIMAL(15, 4),
   increase_ticket      DECIMAL(15, 4),
   maintain_cost        DECIMAL(15, 4),
   total_elec_cost      DECIMAL(15, 4),
   purchase_copy_date   DATE,
   purchase_start_date  DATE,
   purchase_end_date    DATE,
   file_input_account   VARCHAR(40),
   is_share             VARCHAR(10),
   share_situation_name VARCHAR(200),
   share_move           DECIMAL(15, 4),
   share_move_money     DECIMAL(15, 4),
   share_telecom        DECIMAL(15, 4),
   share_telecom_money  DECIMAL(15, 4),
   share_unicom         DECIMAL(15, 4),
   share_unicom_money   DECIMAL(15, 4),
   base_electric_id     INT,
   constraint PK_TAB_MONTHLY_ELECTRIC_2016 primary key (id)
)
tablespace tablespace_business;

/*==============================================================*/
/* Index: tab_monthly_electric_2016_ui1                         */
/*==============================================================*/
create unique index tab_monthly_electric_2016_ui1 on tab_monthly_electric_2016 (
   file_input_date ASC,
   sit_id_ex ASC
);




commit;