/*트레이너 카테고리*/
CREATE TABLE gym_manager(
   order_id NUMBER
   , manager_name varchar(25)
   , manager_age NUMBER(20) 
   , manager_phone VARCHAR(20) 
   , manager_mail VARCHAR(100) 
   , manager_addr VARCHAR(100)
   , manager_file VARCHAR(1000)
   , PRIMARY key(order_id)   
);


CREATE SEQUENCE seq_gym_manager
INCREMENT BY 1
START WITH 1;

/*헬스 프로그램 */
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
CREATE SEQUENCE seq_gym_program
INCREMENT BY 1
START WITH 1;

select * from gym_member inner join gym_program on gym_member.m_id=gym_program.m_id; 

/*맴버 카테고리*/
CREATE TABLE gym_member(
   member_id NUMBER
   , pg_id NUMBER
   , m_name varchar(25)
   , m_age NUMBER(20) 
   , m_gender VARCHAR(20)
   , m_phone VARCHAR(20) 
   , m_mail VARCHAR(100) 
   , m_addr VARCHAR(100)
   , regdate DATE DEFAULT SYSDATE 
   , m_expdate DATE 
   , m_file VARCHAR(1000)
   , PRIMARY key(member_id)
   , CONSTRAINT fk_gym_member FOREIGN KEY (pg_id) 
      REFERENCES gym_program(pg_id)
);
CREATE SEQUENCE seq_gym_member
INCREMENT BY 1
START WITH 1;


/*로그인*/
CREATE TABLE gym_login(
    id number   
   , login_id varchar(20)
   , login_name varchar(25)
   , login_pass varchar(20)
   , login_phone VARCHAR(20) 
   , login_mail VARCHAR(100) 
   , PRIMARY key(id)   
);

CREATE SEQUENCE seq_gym_login
INCREMENT BY 1
START WITH 1;