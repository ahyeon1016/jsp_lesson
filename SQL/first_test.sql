-- Step 1 : 데이터 베이스 생성(DDL) 
create database hello;
-- Step 1 : 생성확인(DDL)
show databases;
-- 데이터 베이스 사용
use hello; 

-- Step 2 : 테이블 생성 (DDL) 
create table hyeon(
	id varchar(10), 
    pw varchar(10), 
    age int
);
show tables;
desc hyeon;

-- 데이터 삽입(DML)
insert into hyeon(id,pw,age) value("a","1234",10);
insert into hyeon value("a","1234",19);
insert into hyeon value("b","1234",199);
insert into hyeon value("c","1234",1999);
-- 확인 
select id,pw,age from hyeon;
select * from hyeon;
select * from hyeon where id="b";
select * from hyeon where pw="1234";
select * from hyeon where age="199";

update hyeon set age="19999" where age="19";

delete from hyeon where id="c";
select * from hyeon;

