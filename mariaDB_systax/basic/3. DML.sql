-- insert, select, update, delete

-- 새로운 레코드 추가
insert into author(id, name, email) values(1, "jgn", "jgn@naver.com");

-- 레코드 조회
select * from author;
select name from author;
select * from author where id = 1;
select * from author where id > 10;
select * from author where id > 10 and name = "abc";

-- 컬럼 정보 상세조회
select full columns from author

-- 테이블 제약조건 조회
select * from information_schema.key_column_usage
where table_name = 'posts';

-- 레코드 수정
update author set email="abc@naver.com" where id=1;

-- '='의 쓰임새 2가지
-- where문 뒤에 나오는 비교문을 java 기준으로 '=='
-- 어떤 값을 set 할때도 '=' 사용하여 대입 (java '=' 과 동일)

-- 레코드 삭제
delete from author where auth_id=5;

-- 이름 중복제거하고 조회
select distinct name from author;

-- order by 먼저 쓴 속성의 우선순위가 있으며, asc/desc 생략시 asc 적용
select * from author order by name desc;

select * from author order by name desc, email desc;

-- 반한할 행의 최대 수를 지정
select * from author order by id desc limit 2; 

--별칭 alias (as는 생략 가능)
select name AS '컬럼별칭' from author;
select * from author AS '테이블이름 별칭';