-- author 데이터 5개 추가 address 는 넣지 말것
-- post 데이터 5개 추가
--  2개는 저자가 있는데이터
--  2개는 저자가 비어있는 테이터 -> author_id에 not null 조견없다는 사실 확인
--  1개는 저자가 author 테이블에 없는 데이터 추가 -> 에러 발생 확인하기;
insert into author(id, name, email) values(2, "jgn", "jgn@naver.com");
insert into author(id, name, email) values(3, "jgn", "jgn@naver.com");
insert into author(id, name, email) values(4, "jgn", "jgn@naver.com");
insert into author(id, name, email) values(5, "jgn", "jgn@naver.com");
insert into author(id, name, email) values(6, "jgn", "jgn@naver.com");


insert into post(id, auth_id ) values(1, 1);
insert into post(id, auth_id ) values(2, 2);
insert into post(id) values(3);
insert into post(id) values(4);
insert into post(id, auth_id ) values(5, 10);

-- author 데이터 중 id가 4인 데이터를 email을 abc@naver.com, name을 abc로 변경
-- post에 글쓴적이 없는 author 데이터 1개 삭제
-- post에 글쓴적이 있는 author 데이터 1개 삭제 -> 에러 -> 조치 후 삭제

update author set name="abc", email="abc@naver.com" where id = 4;
-- delete from post where id = (
--     select id from post where  auth_id!=null
-- );

delete from author where id = 5;

-- 방법 1
delete from post where auth_id = 2;
delete from author where id = 2;

-- 방법 2
update post set auth_id = null where auth_id = 2;
delete from author where id = 2;

