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

r