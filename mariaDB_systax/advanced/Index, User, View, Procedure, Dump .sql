-- 단일 컬럼 index
CREATE INDEX author_name ON author(name);
 
-- 복합 컬럼 index
CREATE INDEX author_index ON author(name, email);

show index from author;

SELECT User, Host FROM mysql.user;

SHOW GRANTS FOR 'root'@'localhost';
-- GRANT PROXY ON ''@'%' TO 'root'@'localhost' WITH GRANT OPTION
-- GRANT ALL PRIVILEGES ON *.* TO `root`@`localhost` IDENTIFIED VIA mysql_native_password USING '*A4B6157319038724E3560894F7F932C8886EBFCF' OR gssapi USING 'SID:BA' WITH GRANT OPTION

CREATE USER 'testuser'@'localhost' IDENTIFIED BY '1234';

SHOW GRANTS FOR 'testuser'@'localhost';
-- GRANT USAGE ON *.* TO `testuser`@`localhost` IDENTIFIED BY PASSWORD '*A4B6157319038724E3560894F7F932C8886EBFCF'

GRANT INSERT ON board.* TO 'testuser'@'localhost';

flush privileges;

SHOW GRANTS FOR 'testuser'@'localhost';
-- GRANT USAGE ON *.* TO `testuser`@`localhost` IDENTIFIED BY PASSWORD '*A4B6157319038724E3560894F7F932C8886EBFCF'
-- GRANT INSERT ON `board`.* TO `testuser`@`localhost`

REVOKE INSERT ON board.* FROM 'testuser'@'localhost';
-- GRANT USAGE ON *.* TO `testuser`@`localhost` IDENTIFIED BY PASSWORD '*A4B6157319038724E3560894F7F932C8886EBFCF'

GRANT SELECT ON board.author TO 'testuser'@'localhost';
-- GRANT USAGE ON *.* TO `testuser`@`localhost` IDENTIFIED BY PASSWORD '*A4B6157319038724E3560894F7F932C8886EBFCF'
-- GRANT SELECT ON `board`.`author` TO `testuser`@`localhost`

-- 적용
flush privileges;

CREATE USER 'testuser'@'%' IDENTIFIED BY '1234';
GRANT SELECT ON board.author TO 'testuser'@'%';

-- view 생성
CREATE VIEW author_view AS 
SELECT * FROM author;

CREATE VIEW posts_view AS 
SELECT * FROM posts;

-- view 조회
SELECT * FROM author_view;

-- view에 권한 주기
GRANT SELECT ON board.author_view TO 'testuser'@'localhost';

DELIMITER //
CREATE PROCEDURE getuser(in userid int)
BEGIN
	SELECT *
	FROM author
	WHERE id = userid;
END  //
DELIMITER ;

CALL getuser(1);

SHOW CREATE PROCEDURE getuser;

DROP PROCEDURE getuser;

DELIMITER //
CREATE PROCEDURE ADD_POST(
IN id int,
IN auth_id int,
IN TITLE varchar(255),
IN CONTENTS varchar(3000)
)
BEGIN
	INSERT INTO
	posts(id, auth_id, title, content) values(id, auth_id, TITLE , CONTENTS);
END  //
DELIMITER ;

CALL ADD_POST(12,1,'1231231', 'WEIRDSIFHIW');

DROP PROCEDURE ADD_POST;

DELIMITER //
CREATE PROCEDURE MY_PROCEDURE(
	IN IN_auth_id int
)
BEGIN 
DECLARE AVG_price  INT DEFAULT 0;
	SELECT AVG(price)
	INTO AVG_price
	FROM posts
	WHERE auth_id = IN_auth_id;

	IF AVG_price > 2000 THEN 
		SELECT '고액 원고료 작가입니다.' AS MESSAGE;
	ELSE
		SELECT '고액 원고료 작가가 아닙니다.' AS MESSAGE;
	END IF ;
END  //
DELIMITER ;

CALL MY_PROCEDURE(2)

DELIMITER //
CREATE PROCEDURE INSERT_100(
    IN auth_id int
)
BEGIN 
DECLARE A INT DEFAULT 0;
WHILE A<100 DO
    INSERT INTO
	posts(auth_id, title) values(auth_id, CONCAT('WELLO WORLD', A));
    SET A = A+1;
END WHILE;
END  //
DELIMITER ;

CALL INSERT_100(1); 

SELECT * FROM posts;

DROP procedure INSERT_100;

-- 덤프 생성 명령어 (utf8 설정)
mysqldump -u root -p --default-character-set=utf8mb4 board > dumpfile.sql

-- 덤프 입력 명령어 
mysql -u root -p board < dumpfile.sql