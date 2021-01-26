DROP TABLE gym_member;

create table gym_member(
      m_id number
     , m_name varchar(25)
     , m_gender varchar(25)
     , m_locker number
     , m_age number
     , m_phone varchar(20) 
     , m_mail varchar(100) 
     , m_addr varchar(100)
     , m_regdate varchar(20) 
     , m_expdate varchar(20)
     , m_file varchar(1000)
     , m_pay number
     , primary key(m_id)
);