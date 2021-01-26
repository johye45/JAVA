/*�ֻ��� ī�װ�*/
CREATE TABLE topcategory(
	topcategory_id NUMBER
	,name varchar(25)
	,PRIMARY KEY(topcategory_id)
);

CREATE SEQUENCE seq_topcategory
INCREMENT BY 1
START WITH 1;

/*���� ī�װ�*/
CREATE TABLE subcategory(
subcategory_id NUMBER
,topcategory_id number
,name varchar(25)
,PRIMARY KEY(subcategory_id)
,CONSTRAINT fk_topcategory FOREIGN KEY(topcategory_id)
 REFERENCES topcategory(topcategory_id)
);

CREATE SEQUENCE seq_subcategory
INCREMENT BY 1
START WITH 1;

/*������ �ֱ�*/
INSERT INTO TOPCATEGORY (TOPCATEGORY_ID,NAME) values(seq_topcategory.nextval,'����');
INSERT INTO TOPCATEGORY (TOPCATEGORY_ID,NAME) values(seq_topcategory.nextval,'����');
INSERT INTO TOPCATEGORY (TOPCATEGORY_ID,NAME) values(seq_topcategory.nextval,'�׼�����');
INSERT INTO TOPCATEGORY (TOPCATEGORY_ID,NAME) values(seq_topcategory.nextval,'�Ź�');

SELECT * FROM TOPCATEGORY ;


/*���� ī�װ��� ������ �ֱ�*/
INSERT INTO SUBCATEGORY (SUBCATEGORY_ID,TOPCATEGORY_ID ,NAME) values(seq_subcategory.nextval,1,'�����'); 
INSERT INTO SUBCATEGORY (SUBCATEGORY_ID,TOPCATEGORY_ID ,NAME) values(seq_subcategory.nextval,1,'����'); 
INSERT INTO SUBCATEGORY (SUBCATEGORY_ID,TOPCATEGORY_ID ,NAME) values(seq_subcategory.nextval,1,'Ƽ����'); 
INSERT INTO SUBCATEGORY (SUBCATEGORY_ID,TOPCATEGORY_ID ,NAME) values(seq_subcategory.nextval,1,'��Ʈ'); 

INSERT INTO SUBCATEGORY (SUBCATEGORY_ID,TOPCATEGORY_ID ,NAME) values(seq_subcategory.nextval,2,'û����'); 
INSERT INTO SUBCATEGORY (SUBCATEGORY_ID,TOPCATEGORY_ID ,NAME) values(seq_subcategory.nextval,2,'ġ��'); 
INSERT INTO SUBCATEGORY (SUBCATEGORY_ID,TOPCATEGORY_ID ,NAME) values(seq_subcategory.nextval,2,'������'); 
INSERT INTO SUBCATEGORY (SUBCATEGORY_ID,TOPCATEGORY_ID ,NAME) values(seq_subcategory.nextval,2,'�����'); 

INSERT INTO SUBCATEGORY (SUBCATEGORY_ID,TOPCATEGORY_ID ,NAME) values(seq_subcategory.nextval,3,'�Ͱ���'); 
INSERT INTO SUBCATEGORY (SUBCATEGORY_ID,TOPCATEGORY_ID ,NAME) values(seq_subcategory.nextval,3,'����'); 
INSERT INTO SUBCATEGORY (SUBCATEGORY_ID,TOPCATEGORY_ID ,NAME) values(seq_subcategory.nextval,3,'�����'); 
INSERT INTO SUBCATEGORY (SUBCATEGORY_ID,TOPCATEGORY_ID ,NAME) values(seq_subcategory.nextval,3,'����'); 

INSERT INTO SUBCATEGORY (SUBCATEGORY_ID,TOPCATEGORY_ID ,NAME) values(seq_subcategory.nextval,4,'����'); 
INSERT INTO SUBCATEGORY (SUBCATEGORY_ID,TOPCATEGORY_ID ,NAME) values(seq_subcategory.nextval,4,'����'); 
INSERT INTO SUBCATEGORY (SUBCATEGORY_ID,TOPCATEGORY_ID ,NAME) values(seq_subcategory.nextval,4,'������'); 
INSERT INTO SUBCATEGORY (SUBCATEGORY_ID,TOPCATEGORY_ID ,NAME) values(seq_subcategory.nextval,4,'�ȭ'); 

SELECT * FROM SUBCATEGORY ;


/*��ǰ�� ��ϵ� ���̺�*/
CREATE TABLE product(
product_id NUMBER
,subcategory_id NUMBER
,product_name varchar(30)
,brand varchar(20)
,price NUMBER DEFAULT 0
,filename varchar(20)
,PRIMARY KEY(product_id)
,CONSTRAINT fk_subcategory FOREIGN KEY(subcategory_id)
 REFERENCES subcategory(subcategory_id)
);

CREATE SEQUENCE seq_product
INCREMENT BY 1
START WITH 1;




SELECT * FROM product;












