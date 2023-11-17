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

-- where auth_id is not null 

-- 숫자 타입
-- 정수 : tinyint, int, bigint, unsigned,
-- 실수 : 부동소수점(float, double 오차존재), 고정소수점(decimal(M,D) M=자리수, D=소수부)

-- 문자 타입
-- char(255) : 고정길이의 문자열
-- varchar(255) : 가변길이의 문자열
-- text : 가변길이 문자열, varchar보다 넓은 사이즈 다만 속도가 느림, index 사용의 어려움
-- blob : 바이너리 입력
-- enum : 미리 들어갈수 있는 특정 데이터의 값을 지정
-- enum('데이터 값1', '데이터 값2',...) , not null default 'user'등의 옵션도 추가 가능 

alter table author add column age tinyint unsigned;

describe author;
select * from author;

insert into author(id, name, age) values(1, "jgn", 255);
-- 에러 오버플로우
insert into author(id, name, age) values(2, "jgn", 300);

alter table posts add column price decimal(10,3);

describe posts;
select * from posts;

insert into posts(id, price) values(6, 0.123456789);
update posts set price=1000.1 where id=1;
update posts set price=1000.12 where id=1;
update posts set price=1000.123 where id=1;
--
insert into posts(id, price) values(9, 0.1);

create table table_blob(
	id int,
    img longblob
);

insert into table_blob(id,img) values(1,load_file('C:\\Users\\Playdata\\Documents\\GitHub\\BootCamp\\image.jpeg'));
select hex(img) from table_blob where id = 1;

update author set role = 'user';
alter table author modify column role enum('user','admin') not null default 'user';
insert into author(id, name, role) values(2, "jgn", 'admin');
insert into author(id, name, role) values(3, "jgn", 'super-user');
insert into author(id, name) values(4, "jgn");

-- 날짜와 시간
-- date: yyyy-mm-dd
-- datetime(m) : yyyy-mm-dd hh:mm:ss
-- java의 localdatetime과 sync
-- datetime default current_timestamp : 현재시간을 default로 삽입하는 방식 

alter table posts add column created_tile1 datetime default current_timestamp;
alter table posts add column created_tile2 datetime default now();
insert into posts(id) values(10);

-- 비교 연산자
-- !=, <>
-- <, <==, > , >=
-- is null, is not null
-- between min and max
-- in(), not in()

-- 논리 연산자
-- AND &&
-- OR ||
-- NOT !

select * from author where id not in(1,2,4);
select * from posts where id between 2 and 4;
select * from posts where id >=2 and id<=4;
select * from posts where id = 2 or id = 3 or id = 4;
select * from posts where !(id <2 or id>4);

-- 검색 패턴
-- like : 특정 문자를 찾기 위한 함수 %를 사용
select * from author where name like 'stirng%'; 
select * from author where name like '%stirng%'; 
select * from author where name like '%stirng'; 
-- not like

-- regexp : 정규표현식 토대로 패턴 연산 수행
select * from author where name regexp '[a-z]'; 
select * from author where name regexp '[가-힣]'; 
-- not regexp

-- 타입변환
-- cast : 정수 값을 date 타입으로 변환
select cast(20231117 as date);
-- convert : 문자열날짜/시간으로 변환
select cast('20231117' as date);
-- date_format : 날짜/시간 타입의 데이터를 지정된 형식의 문자열로 변환
select date_format('2020-01-01 17:12:00', '%y-%m-%d');