create database bookmarketdb;

use bookmarketdb;

show databases;

create table if not exists book(
	b_id varchar(10) not null,
    b_name varchar(20),
    b_unitPrice integer,
    b_author varchar(20),
    b_description text,
    b_publisher varchar(20),
    b_category varchar(20),
    b_unitInStock long,
    b_releaseDate varchar(20),
    b_condition varchar(20),
    b_filename varchar(20),
    primary key (b_id)
) default charset=utf8;

show tables;
desc book;