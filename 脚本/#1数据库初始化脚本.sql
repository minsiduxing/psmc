create temporary tablespace user_temp 
tempfile 'D:\oracle\product\10.2.0\oradata\orcl\user_temp.dbf' 
size 50m 
autoextend on 
next 50m maxsize 20480m 
extent management local; 


create tablespace  tablespace_auth
logging 
datafile 'D:\oracle\product\10.2.0\oradata\orcl\tablespace_auth.dbf' 
size 50m 
autoextend on 
next 50m maxsize 20480m 
extent management local; 

create tablespace  tablespace_business
logging 
datafile 'D:\oracle\product\10.2.0\oradata\orcl\tablespace_business.dbf' 
size 50m 
autoextend on 
next 50m maxsize 20480m 
extent management local; 

create user tablequerymanager identified by mypassword123 
default tablespace tablespace_business
temporary tablespace user_temp; 

grant connect,resource,dba to tablequerymanager; 

commit;
