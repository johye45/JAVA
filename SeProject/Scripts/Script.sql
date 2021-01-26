create table board(
board_id number primary key
,title	varchar(100)	
,writer	varchar(20)	
,content clob
, regdate date default sysdate
, hit	number default 0
);
