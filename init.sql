-- create initial database
create table users(
       id int primary key,
       email varchar(255) not null,
       password varchar(512) not null
);
