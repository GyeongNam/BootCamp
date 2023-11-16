
-- 데이터 베이스 생성
create database board;

-- 데이터베이스 선택
use board;

-- 테이블 신규 생성 (author)
create table author(
    id int not null, 
    name varchar(255),
    email varchar(255),
    password varchar(255),
    test varchar(255),
    primary key(id)
);

-- 테이블 컬럼 조회
describe author;

-- 테이블 목록 조회
show table;

-- 테이블 신규 생성 (post)
create table posts(
    id int not null, 
    title varchar(255),
    content varchar(255),
    auth_id int,
    primary key(id),
    foreign key(auth_id) references author(id)
);

-- 테이블 컬렴 조회
show full columns from author;

-- 테이블 생성문 조회
show create table posts;

-- CREATE TABLE `posts` (
--    `id` int(11) NOT NULL,
--    `title` varchar(255) DEFAULT NULL,
--    `content` varchar(255) DEFAULT NULL,
--    `auth_id` int(11) DEFAULT NULL,
--    PRIMARY KEY (`id`),
--    KEY `auth_id` (`auth_id`),
--    CONSTRAINT `post_ibfk_1` FOREIGN KEY (`auth_id`) REFERENCES `author` (`id`)
--  ) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci

-- 테이블 제약조건 조회
select * from information_schema.key_column_usage
where table_name = 'posts';

-- 테이블 인덱스 조회
show index from posts;

-- 테이블 이름 변경
alter table posts rename post;

-- 컬럼 추가 add
alter table author add column roles varchar(50);

-- 필드 타입 변경 modify (덮어쓰기)
alter table author modify column name varchar(100) not null;

-- 컬럼 이름 변경
alter table post change column content contents;

-- 컬럼 삭제
alter table author drop column test;

-- CREATE TABLE `author` (
--    `id` int(11) NOT NULL,
--    `name` varchar(100) NOT NULL,
--    `email` varchar(255) DEFAULT NULL,
--    `password` varchar(255) DEFAULT NULL,
--    `roles` varchar(50) DEFAULT NULL,
--    PRIMARY KEY (`id`)
--  ) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci

-- CREATE TABLE `post` (
--    `id` int(11) NOT NULL,
--    `title` varchar(255) DEFAULT NULL,
--    `content` varchar(255) DEFAULT NULL,
--    `auth_id` int(11) DEFAULT NULL,
--    PRIMARY KEY (`id`),
--    KEY `auth_id` (`auth_id`),
--    CONSTRAINT `post_ibfk_1` FOREIGN KEY (`auth_id`) REFERENCES `author` (`id`)
--  ) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci

-- 테이블 삭제
drop table table_name;

-- 특정 객체가 존재하는 경우에만 명령어 실행
drop database if exists