
/*member ���� */
CREATE TABLE board_member(
member_id NUMBER PRIMARY KEY 
,m_id varchar(20)
,m_pass varchar(20)
,m_name varchar(20)
,regdate DATE DEFAULT sysdate
);

/*������ �����Ѵ�*/
CREATE SEQUENCE seq_board_member
INCREMENT BY 1
START WITH 1;

/*board ���̺� ����� , �Խ��� ���̺�!*/
create table board(
board_id number primary key
,title	varchar(100)	
,writer	varchar(20)	
,content clob
, regdate date default sysdate
, hit	number default 0
);

create sequence seq_board
increment by 1
start with 1;

