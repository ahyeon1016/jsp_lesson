
create table member ( 
    id varchar(10) not null,
    password varchar(10) not null,
    name varchar(10) not null,
    gender varchar(4),
    birth  varchar(10),
    mail  varchar(30),
    phone varchar(20),
    address varchar(90),
    regist_day varchar(50),    
    primary key(id) 
) default CHARSET=utf8;
SELECT * FROM board where regist_day;
INSERT INTO board values(311111111,1,1,1,1,2024.12.23,1,1);
DELETE FROM board;
select * from member;
drop table member;
