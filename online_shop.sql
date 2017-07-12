drop database online_shop_db;

CREATE DATABASE IF NOT EXISTS online_shop_db CHARACTER SET utf8 COLLATE utf8_general_ci;

use online_shop_db;


CREATE TABLE staff (
    staff_id nvarchar(10) not null primary key,
    staff_name nvarchar(100) not null,
    s_password nvarchar(500) not null,
    email nvarchar(100)
);

CREATE TABLE manager (
	userName nvarchar(10) not null primary key,
    s_password nvarchar(500) not null
);

CREATE TABLE device (
	deviceId nvarchar(10) not null primary key,
    device_name nvarchar(100) not null,
    origin nvarchar(100) not null,
    branch nvarchar(100),
    description nvarchar(1000),
    price int
);

/*CREATE TABLE parameters (
	number_weeks int
);*/


insert into manager values (N'admin', 'admin');

insert into staff values (N'1',N'Trương Ngọc Nghĩa', N'1412346',N'nghiatruongngoc22@gmail.com');
insert into staff values (N'2',N'Phạm Moony', N'14123100', N'abc@gmail.com');
insert into staff values (N'3',N'Doraemon', N'14123900', N'abcdrm@gmail.com');

insert into device values (N'1', N'IPhone 8', N'Apple', N'China', N'You dont have to use headphone anymore!', '1000');
insert into device values (N'2', N'Samsung Galaxy S8', N'Samsung', N'Korea', N'Dont believe and pay for the one from democrazy US', '1100');

select *from staff;
select *from manager;
select *from device;
