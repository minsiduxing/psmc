

select * from t_sys_oper_log t order by t.oper_date desc

delete from qrtz_triggers;
delete from qrtz_cron_triggers;
delete from qrtz_locks;
delete from qrtz_job_details;


select * from qrtz_triggers;
select * from qrtz_job_details;