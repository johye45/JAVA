SELECT * FROM PRODUCT WHERE PRODUCT_NAME LIKE '%가%';
SELECT * FROM PRODUCT WHERE BRAND LIKE '%톰%';

SELECT * FROM TOPCATEGORY ;
SELECT * FROM WHERE topcategory_id = (유저가 선택한 subcategory_id 의 topcategory_id);

SELECT * FROM TOPCATEGORY t  WHERE TOPCATEGORY_ID = (SELECT TOPCATEGORY_ID FROM SUBCATEGORY WHERE SUBCATEGORY_ID = 15);

SELECT * FROM TOPCATEGORY t  WHERE TOPCATEGORY_ID = (SELECT TOPCATEGORY_ID FROM SUBCATEGORY WHERE SUBCATEGORY_ID =6);

SELECT * FROM SUBCATEGORY s  WHERE SUBCATEGORY_ID = SUBCATEGORY_ID ;