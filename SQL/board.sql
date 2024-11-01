CREATE TABLE board (
       num int not null auto_increment,
       id varchar(10) not null,
       name varchar(10) not null,
       subject varchar(100) not null,
       content text not null,
       regist_day varchar(30),
       hit int,
       ip varchar(20),
       PRIMARY KEY (num)
)default CHARSET=utf8;
INSERT INTO board(id, name, subject, content, regist_day, hit, ip) VALUES('15','15','15','15','2025-12-1','15','15');
delete from board;
select * from board;
desc board;
drop table board;
SELECT * FROM board;
