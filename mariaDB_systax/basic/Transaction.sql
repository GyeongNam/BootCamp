-- 트랜잭션
insert into author(name, email) values('test', 'test@naver,com');
insert into posts(id, title, content, auth_id) values('20','hello', 'hello is', 1);
select * from author;
select * from posts;

-- commit;
-- rollback;
select * from author;

-- 정리
insert into author(name, email) values('test', 'test@naver,com');
commit;
insert into author(name, email) values('test', 'test@naver,com');
insert into posts(id, title, content, auth_id) values('20','hello', 'hello is', 1);
rollback;