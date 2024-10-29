create database JSPBook;
use JSPBook;
show databases;

create table if not exists book(
	bookId varchar(20) not null,
    name varchar(20),
    unitPrice int,
    author varchar(20),
    description text,
    publisher varchar(20),
    category varchar(20),
    unitsInStock long,
    releaseDate varchar(20),
    condition1 varchar(100),
    filename varchar(100),
    primary key(bookId)
);
ALTER TABLE book
MODIFY COLUMN description text;
show tables;
DESCRIBE book;

select * from member where id='admin';
update member set pwd='1231231ㅣ44ㅣ14', name='아앙ㅇㄴ이' where id='admin';
insert into member values('admin', '1234', '안강현');
insert into member values('id', 'pwd', 'name');
delete from member where id='admin';
delete from book;
insert into book values('a23','a',20,'a','a','a','a',100,'a','a','a');
select * from book;