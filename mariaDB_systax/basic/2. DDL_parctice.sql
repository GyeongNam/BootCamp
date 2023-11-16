-- post 테이블의 contens 컬럼 글자수 3000으로 변경
-- author 테이블에 address 컬럼 varchar 255로 추가
-- post 테이블 생성문 미리 확인 -> post테이블 삭제 -> post 테이블 다시 생성

alter table post modify content varchar(3000);
alter table author add column address varchar(255);
show create table post;

-- CREATE TABLE `post` (
--    `id` int(11) NOT NULL,
--    `title` varchar(255) DEFAULT NULL,
--    `content` varchar(3000) DEFAULT NULL,
--    `auth_id` int(11) DEFAULT NULL,
--    PRIMARY KEY (`id`),
--    KEY `auth_id` (`auth_id`),
--    CONSTRAINT `post_ibfk_1` FOREIGN KEY (`auth_id`) REFERENCES `author` (`id`)
--  ) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci

drop table post;