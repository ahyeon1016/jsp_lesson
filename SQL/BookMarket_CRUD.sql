create database BookMarket_CRUD;
use BookMarket_CRUD;
show databases;

create table if not exists book(
	bookId varchar(20) not null,
    bookname varchar(20),
    unitPrice int,
    author varchar(20),
    bookdescription text,
    publisher varchar(20),
    category varchar(20),
    unitsInStock long,
    releaseDate varchar(20),
    bookcondition varchar(100),
    filename varchar(100),
    primary key(bookId)
);