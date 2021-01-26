DROP TABLE GYM_PROGRAM ;
DROP SEQUENCE seq_gym_program;

CREATE TABLE gym_program(
   pg_id NUMBER
   , order_id number
   , pg_name varchar(30)
   , pg_day varchar(30)
   , pg_start_day varchar(30)
   , pg_end_day varchar(30)
   , pg_price number
   , m_id number
   , pg_file VARCHAR(1000)
   , PRIMARY key(pg_id)
   , CONSTRAINT fk_gym_program FOREIGN KEY (order_id) 
      REFERENCES gym_manager(order_id)
);

CREATE SEQUENCE seq_gym_program
INCREMENT BY 1
START WITH 1;

select * from gym_member inner join gym_program on gym_member.m_id=gym_program.m_id; 
DROP SEQUENCE sep_gym_program;

DROP TABLE gym_program;
CREATE TABLE gym_program(
   pg_id NUMBER
   , order_id number
   , pg_name varchar(30)
   , pg_day varchar(30)
   , pg_start_day varchar(30)
   , pg_end_day varchar(30)
   , pg_time varchar(30)
   , pg_price number
   , m_id number
   , pg_file VARCHAR(1000)
   , PRIMARY key(pg_id)
   , CONSTRAINT fk_gym_program FOREIGN KEY (order_id) 
      REFERENCES gym_manager(order_id)
);