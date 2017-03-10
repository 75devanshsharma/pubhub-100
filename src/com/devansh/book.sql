create table book (
bookId int primary key,
bookName varchar(30),
bookAuthor varchar(30)
);
insert into book values(112,'Compiler Design','Devansh');
insert into book values(122,'Artificial Intelligence','James');
select * from book;