SELECT *
FROM AUTHOR AS A
JOIN POSTS AS B
ON A.ID = B.AUTH_ID;

SELECT *
FROM AUTHOR AS A
LEFT JOIN POSTS AS B
ON A.ID = B.AUTH_ID;

SELECT A.NAME , B.TITLE
FROM AUTHOR AS A
JOIN POSTS AS B
ON A.ID = B.AUTH_ID;

SELECT A.NAME , B.TITLE
FROM AUTHOR AS A
LEFT JOIN POSTS AS B
ON A.ID = B.AUTH_ID;

SELECT A.NAME , B.TITLE
FROM AUTHOR AS A
LEFT JOIN POSTS AS B
ON A.ID = B.AUTH_ID
WHERE A.AGE>=25;

SELECT NAME, EMAIL FROM AUTHOR UNION SELECT TITLE, CONTENT FROM POSTS;

SELECT 
count(*) AS 'COUNT',
round( avg(price) ) AS 'AVG',
MIN(price) AS 'MIN',
MAX(price) AS 'MAX',
SUM(price) AS 'SUM'
FROM POSTS;

SELECT 
AUTH_ID,
count(*) AS 'COUNT',
round( avg(price) ) AS 'AVG',
MIN(price) AS 'MIN',
MAX(price) AS 'MAX',
SUM(price) AS 'SUM'
FROM POSTS
group by AUTH_ID;

SELECT 
AUTH_ID,
round( avg(price) ) AS 'AVG'
FROM POSTS
WHERE price>2000
group by AUTH_ID;

SELECT 
AUTH_ID,
round( avg(price) ) AS 'AVG'
FROM POSTS
group by AUTH_ID
HAVING avg(price)>2000;

SELECT 
AUTH_ID,
round( avg(price) ) AS 'AVG'
FROM POSTS
WHERE price>2000
group by AUTH_ID
HAVING avg(price)>2000

-- 프로그래머스 문제 풀이

-- 없어진 기록 찾기
-- 조건에 맞는 도서와 저자리스트 출력하기
-- 입양 시각 구하기(1)
-- 성분으로 구분한 아이스크림 총 주문량
-- 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
-- 재 구매가 일어난 상품과 회원 리스트 구허기

WITH RECURSIVE NUMBER_SEQ(HOUR) AS (
    SELECT 0
    UNION ALL
    SELECT HOUR + 1 
    FROM NUMBER_SEQ 
    WHERE HOUR < 23
)
SELECT HOUR, 0 AS COUNT 
FROM NUMBER_SEQ
WHERE HOUR NOT IN(
    SELECT CAST(date_format(DATETIME, '%H') AS SIGINED) AS HOUR
    FROM  ANIMAL_OUTS 
)