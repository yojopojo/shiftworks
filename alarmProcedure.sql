-- 프로시저 생성
CREATE OR REPLACE PROCEDURE clean_alarm AS 
BEGIN 
    DELETE alarm WHERE date_created < sysdate - 7;
END clean_alarm;
-- 프로시저 삭제
DROP PROCEDURE clean_alarm;

-- job 생성
BEGIN
DBMS_SCHEDULER.CREATE_JOB (
            job_name => '"SHIFTWORKS"."JOB_CLEAN_ALARM"',
            job_type => 'STORED_PROCEDURE',
            job_action => 'SHIFTWORKS.CLEAN_ALARM',
            number_of_arguments => 0,
            start_date => NULL,
            repeat_interval => 'FREQ=HOURLY;INTERVAL=24',
            end_date => NULL,
            enabled => FALSE,
            auto_drop => FALSE,
            comments => '지난 알림 삭제');
END;
-- job 삭제
BEGIN
    DBMS_SCHEDULER.DROP_JOB(job_name => '"SHIFTWORKS"."JOB_CLEAN_ALARM"',
                                defer => false,
                                force => false);
END;

-- job 가동
BEGIN
  DBMS_SCHEDULER.enable(name=>'"SHIFTWORKS"."JOB_CLEAN_ALARM"');
END;
-- job 중지
BEGIN
	DBMS_SCHEDULER.disable(name=>'"SHIFTWORKS"."JOB_CLEAN_ALARM"', force => TRUE);
END;

-- 보유한 job 목록 확인
SELECT * FROM user_scheduler_jobs;

-- job 실행내역 확인
SELECT * FROM user_scheduler_job_log;
SELECT * FROM user_scheduler_job_run_details;
