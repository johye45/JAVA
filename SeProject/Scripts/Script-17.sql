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