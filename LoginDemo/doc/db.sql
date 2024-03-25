DROP DATABASE IF EXISTS demodb;
CREATE DATABASE demodb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
-- DROP USER 'springuser'@'%';
-- CREATE USER 'springuser'@'%' IDENTIFIED BY '12345678';
-- GRANT ALL ON demodb.* TO 'springuser'@'%';
-- SHOW CREATE DATABASE demodb;
-- SHOW CREATE TABLE user;
-- SOURCE d:\db.sql

USE demodb;

CREATE TABLE user
(
    id INT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    username VARCHAR(30) NULL DEFAULT NULL COMMENT '用户名',
    nickName VARCHAR(30) NULL DEFAULT NULL COMMENT '昵称',
    password VARCHAR(20) NULL DEFAULT NULL COMMENT '密码',
    PRIMARY KEY (id)
);

INSERT INTO user (username, nickName, password) VALUES
                 ("zhao", "赵", "1"),
                 ("qian", "钱", "1"),
                 ("sun", "孙", "1"),
                 ("li", "李", "1"),
                 ("zhou", "周", "1");

SELECT * from user;