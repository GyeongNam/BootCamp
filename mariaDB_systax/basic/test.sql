drop database if exists board;
show databases;

-- mysql -u root -p < test.sql


-- 데베2일차 오전 실습

create database board;

use board;

create table author(
    id int not null, 
    name varchar(255),
    email varchar(255),
    password varchar(255),
    test varchar(255),
    primary key(id)
);

create table posts(
    id int not null, 
    title varchar(255),
    content varchar(255),
    auth_id int,
    primary key(id),
    foreign key(auth_id) references author(id)
);

create table author(
    id int not null, 
    name varchar(100) not null,
    email varchar(255),
    password varchar(255),
    role varchar(255),
    address varchar(255),
    primary key(id)
);

create table posts(
    id int not null, 
    title varchar(255),
    content varchar(3000),
    auth_id int,
    primary key(id),
    foreign key(auth_id) references author(id)
);

insert into author(id, name) values(2, "jgn2");
insert into author(id, name) values(3, "jgn3");
insert into author(id, name) values(4, "jgn4");
insert into author(id, name) values(5, "jgn5");
insert into author(id, name) values(6, "jgn6");

insert into posts(id, auth_id, title ,content ) values(1, 3, '5', "a");
insert into posts(id, auth_id, title ,content) values(2, 3, '4', "b");
insert into posts(id ,title, content) values(3, '2', "d");
insert into posts(id, title, content) values(4, '1', "b");
insert into posts(id, title, content) values(5, '1', "b");

update posts set auth_id = null where auth_id is not null;

delete from author;

select * from posts order by  title asc , content desc limit 3;


-- 데베2일차 오후 실습

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

-- 데베 3일차 
select * from posts;

insert into posts(id) values(11);

select * from posts where date_format(created_tile1, '%Y') = '2023';

select * from posts where created_tile1 like '2023%';

select * from posts where created_tile1 between '2023-01-01' and '2023-12-31';

select * from posts where created_tile1 >= '2023-01-01' and created_tile1 <= '2023-12-31';

select * from posts where date_format(created_tile1, '%Y') = date_format(now(), '%Y');


ALTER TABLE posts modify column title varchar(255) not null;

-- post 테이블에 id 없이 insert
-- insert 한 테이블에 삭제
-- 다시 insert

select * from author;

alter table author modify column id int auto_increment;

show create table posts;

insert into author(name) values('20일gn');
insert into author(id, name) values(15,'20일gn');

delete from author where name = '20일gn';

SET FOREIGN_KEY_CHECKS=0;	-- 외래키 체크 끄기
SET FOREIGN_KEY_CHECKS=1;	-- 외래키 체크 켜기

alter table author modify column email varchar(255) unique;

show index from author;

select * from information_schema.key_column_usage
where table_name = 'author';    -- 제약 조건 검사

alter table author drop constraint email;

alter table author add constraint email2 unique(email);

alter table author modify column email varchar(250);    -- 제약조건은 사라지지 않는다.

-- on update cascade 설정

select * from information_schema.key_column_usage where table_name = 'posts';

alter table posts drop foreign key post_auth_fk;

alter table posts drop index post_auth_fk;

show index from author;

show index from posts;

-- 새롭게 제약 조건 추가

alter table posts add constraint post_auth_fk foreign key(auth_id) references author(id) on update cascade;

-- 테스트 삭제 , 삭제불가 , restrict

update author set id = 29 where id = 26;  -- author 테이블 수정시 posts 테이블도 자동 수정

alter table posts add constraint post_auth_fk foreign key(auth_id) references author(id) on delete set null on update set null;

show create table posts;

-- CREATE TABLE `posts` (
--    `id` int(11) NOT NULL,
--    `title` varchar(255) NOT NULL,
--    `content` varchar(3000) DEFAULT NULL,
--    `auth_id` int(11) DEFAULT NULL,
--    `price` decimal(10,3) DEFAULT NULL,
--    `created_tile1` datetime DEFAULT current_timestamp(),
--    `created_tile2` datetime(6) DEFAULT current_timestamp(6),
--    `created_tile3` datetime DEFAULT current_timestamp(),
--    PRIMARY KEY (`id`),
--    KEY `post_auth_fk` (`auth_id`),
--    CONSTRAINT `post_auth_fk` FOREIGN KEY (`auth_id`) REFERENCES `author` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
--  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

select id title, content, 
(case auth_id
when 1 then 'first_author'
when 2 then 'second_author'
else 'others'
end) as author_type
from posts

-- null 확인

select id title, content, 
(case
when auth_id = 1 then 'first_author'
when auth_id = 2 then 'second_author'
when auth_id is NULL then 'anonymous'
else 'others'
end) as author_type
from posts

select if(0<1, 'yes', 'no');

select id title, content, ifnull(auth_id, 'anonymous') from posts;