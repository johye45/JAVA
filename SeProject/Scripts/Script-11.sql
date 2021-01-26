DROP TABLE gym_member;
DROP SEQUENCE seq_gym_member;

create table gym_member(
   m_id number
     ,m_name varchar(25)
     ,m_gender varchar(25)
     ,m_locker number unique
     ,m_pay number
     , m_age number
     , m_phone varchar(20) 
     , m_mail varchar(100) 
     , m_addr varchar(100)
     , m_regdate varchar(20) 
     , m_expdate varchar(20)
     , m_file varchar(1000)
     , primary key(m_id)
);

CREATE SEQUENCE seq_gym_member
INCREMENT BY 1
START WITH 1;