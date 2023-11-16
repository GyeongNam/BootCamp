-- insert, select, update, delete

-- 새로운 레코드 추가
insert into author(id, name, email) values(1, "jgn", "jgn@naver.com");

-- 레코드 조회
select * from author;
select name from author;
select * from author where id = 1;
select * from author where id > 10;
select * from author where id > 10 and name = "abc";

-- 레코드 수정
update author set email="abc@naver.com" where id=1;

-- '='의 쓰임새 2가지
-- where문 뒤에 나오는 비교문을 java 기준으로 '=='
-- 어떤 값을 set 할때도 '=' 사용하여 대입 (java '=' 과 동일)

-- 레코드 삭제
delete from author where auth_id=5;