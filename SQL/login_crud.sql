create database login_crud;
use login_crud;
create table member(
	id varchar(30) primary key,
    pwd varchar(30),
    age int
);
desc member;

select * from member;