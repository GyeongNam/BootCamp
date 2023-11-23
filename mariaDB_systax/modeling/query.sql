create database board;

show tables;

CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('user','admin') NOT NULL DEFAULT 'user',
  `address` varchar(255) DEFAULT NULL,
  `age` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` varchar(3000) DEFAULT NULL,
  `auth_id` int(11) DEFAULT NULL,
  `price` decimal(10,3) DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  FOREIGN KEY (`auth_id`) REFERENCES `author` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
  );

create table post_order(
    id int PRIMARY KEY AUTO_INCREMENT,
    post_id int,
    auth_id int,
    foreign key(auth_id) references author(id),
    foreign key(post_id) references post(id)
);

create table author_address(
	id int PRIMARY KEY AUTO_INCREMENT,
    county  varchar(255),
    stete  varchar(255),
    city  varchar(255),
	detalis  varchar(255),
	zip_code  varchar(255),
	phone_nunber varchar(255),
    auth_id int,
    foreign key(auth_id) references author(id) ON DELETE CASCADE ,
    UNIQUE(auth_id)
);



-- [실습2] 주문 관리 서비스 설계
-- 테이블 컬럼 자유설계
-- 주문관리 서비스
-- 모든 테이블 자유 설계
-- ORDER SYSTEM 데이트 베이스 생성
-- 해당 서비스에서는 회원가입이 가능
-- MEMEBERS
-- USER, ADMIN, SELLER 로 구성
-- 회원은 상품과 재고 수량을 등록
-- ITEMS
-- 상품명, 상품가격, 재고
-- 누가 등록했는지에 대한 정보가 남아야 함에 유의
-- 회원이 여러 상품을 한꺼번에 주문 가능

CREATE Database ORDER_SYSTEM;

create table MEMEBERS(
    MEMEBERS_id BIGINT PRIMARY KEY AUTO_INCREMENT,  -- ID
    MEMEBERS_role enum('USER', 'ADMIN', 'SELLER') NOT NULL DEFAULT 'USER',   -- USER 종류
    MEMEBERS_NAME varchar(255) NOT NULL,     -- USER 이름
    MEMEBERS_PHONE varchar(255) NOT NULL,    -- USER 종류
    MEMEBERS_EMAIL varchar(255) NOT NULL     -- USER 메일
);

create table ITEMS(
    ITEMS_id BIGINT PRIMARY KEY AUTO_INCREMENT,     -- ID
    ITEMS_NAME VARCHAR(255)  NOT NULL,    -- 상품 이름
    ITEMS_PRICE BIGINT NOT NULL,     -- 상품 가격
    ITEMS_COUNT INT,        -- 상품 재고 수
    SELLER_id BIGINT NOT NULL,       -- 판매자 ID
    FOREIGN KEY(SELLER_id) REFERENCES MEMEBERS(MEMEBERS_id) ON DELETE CASCADE
);

create table ORDERS(
    ORDER_id BIGINT PRIMARY KEY AUTO_INCREMENT,     -- 기본키
    USER_id BIGINT NOT NULL,     -- 주문한 사람의 id
    MEMEBERS_ADDRESS_id BIGINT NOT NULL, -- 배송지
    ORDERS_Progress enum('구매요청', '상품 준비중', '배송중', '배송완료') NOT NULL DEFAULT '구매요청',   -- 주문 상태
    FOREIGN KEY(USER_id) REFERENCES MEMEBERS(MEMEBERS_id),
    FOREIGN KEY(MEMEBERS_ADDRESS_id) REFERENCES MEMEBERS_ADDRESS(MEMEBERS_ADDRESS_id) 
);

create table ORDER_DETAILS(
    ORDER_DETAILS_id BIGINT PRIMARY KEY AUTO_INCREMENT, -- 기본키
    ORDER_ITEM_COUNT INT NOT NULL,    -- 구매 갯수
    ORDER_id BIGINT NOT NULL,    -- 주문 id
    ITEMS_id BIGINT NOT NULL,    -- 상품 id
    FOREIGN KEY(ORDER_id) REFERENCES ORDERS(ORDER_id),
    FOREIGN KEY(ITEMS_id) REFERENCES MEMEBERS(MEMEBERS_id)
);

create table MEMEBERS_ADDRESS(      -- 배송지가 여러 곳일 가능성
    MEMEBERS_ADDRESS_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    MEMEBERS_SI VARCHAR(255) NOT NULL,
    MEMEBERS_DO VARCHAR(255) NOT NULL,
    MEMEBERS_DETAIL VARCHAR(255) NOT NULL,
    MEMEBERS_id BIGINT NOT NULL,
    FOREIGN KEY(MEMEBERS_id) REFERENCES MEMEBERS(MEMEBERS_id) ON DELETE CASCADE
);

-- 회원가입 (판매자)    : MEMEBERS INSERT
-- 회원가입 (구매자)    : MEMEBERS INSERT

-- 상품등록 (판매자)    : ITEMS INSERT 
-- 상품구매 (구매자)
    -- 배송지 입력         : MEMEBERS_ADDRESS INSERT
    -- 구매내용 등록       : ORDERS INSERT
    -- 구매상새 내용 등록   : ORDER_DETAILS INSERT
    -- 상품 재고 수정       : ITEMS UPDATE