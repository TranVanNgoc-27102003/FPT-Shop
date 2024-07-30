create database ASM_java6;
use ASM_java6;
drop database ASM_java6;
create table Account (
AcountId int Identity(1,1) primary key,
Email nvarchar(50) ,
PassWord varchar(30),
FullName nvarchar(50),
Address nvarchar(100),
PhoneNumber varchar(20),
Role bit default 0,
);
insert into Account values 

('ngoctvps27622@fpt.edu.vn','123',N'Trần Văn Ngọc',N'Lâm Đồng ,Việt Nam','013245621',0),
('huongpv27622@fpt.edu.vn','123',N'Phạm Văn Hưởng ',N'Hà Nam ,Việt Nam','013245621',1

create table Products(
ProductId int identity(1,1) primary key,
ProductName nvarchar(100),
Image varchar(100),
Category nvarchar(50),
Price float ,
Discount float,
Quantity int,
Color varchar(30),
);
insert into Products values 

('iPhone 15 128GB','iphone15.jpg',N'Điện thoại',22990000.0,19990000.0,1545,'blue'),
('iPhone 15 Pro 128GB','iphone2.PNG',N'Điện thoại',28990000.0,24990000.0,1545,'blue'),
('iPhone 15 Pro Max 256GB','iphone3.jpg',N'Điện thoại',34990000.0,29990000.0,1545,'blue'),
('iPhone 14 128GB','iphone4.PNG',N'Điện thoại',21990000.0,17990000.0,1545,'blue'),
('Samsung Galaxy Z Flip6 5G 256GB','samSung1.1.PNG',N'Điện thoại',28990000.0,27990000.0,1545,'blue'),
('Samsung Galaxy M55 5G 256GB','samSung2.PNG',N'Điện thoại',10990000.0,9990000.0,1545,'blue'),
('Samsung Galaxy S24 Ultra 5G 256GB','samSung1.PNG',N'Điện thoại',29990000.0,28990000.0,1545,'blue'),
('Samsung Galaxy A55 5G 128GB','samSung4.jpg',N'Điện thoại',9990000.0,8990000.0,1545,'blue'),

('iPhone 15 128GB','iphone15.jpg',N'Điện thoại',22990000.0,19990000.0,1545,'blue'),
('Macbook Air M2 13 2022 8CPU 8GPU 8GB 256Gb','LapTOPBanChay.webp',N'Máy tính',24500000.0,24000000.0,110,'red'),
('Asus Vivibook E1404FE-NK1864G R5 7250U','LaptopBanChay2.webp',N'Máy tính',20100000.0,20000000.0,124,'red'),
('lennovo Ipad 1 15ALC7 R5 5550U (82R400)','LapTOPBanChay3.webp',N'Máy tính',26500000.0,26000000.0,110,'red'),
('Bravo 15 Air M2 13 2022 8CPU 8GPU 8GB 256Gb','LapTOPBanChay4.webp',N'Máy tính',25500000.0,24000000.0,10,'red'),
('Samsung G13 2022 8CPU 8GPU 8GB 126Gb','LapTOPBanChay5.webp',N'Máy tính',24500000.0,24000000.0,110,'red'),
('Lennovo Air M2 13 2022 8CPU 8GPU 8GB 256Gb','LapTOPBanChay6.webp',N'Máy tính',28500000.0,28000000.0,210,'red'),
('huawai Air M2 13 2024 10CPU 8GPU 8GB 256Gb','LapTOPBanChay7.webp',N'Máy tính',29500000.0,29000000.0,350,'red'),
('Del Air M2 13 2022 8CPU 8GPU 8GB 156Gb','LapTOPBanChay8.webp',N'Máy tính',34500000.0,30000000.0,10010,'red')

select * from Products where Category  = 'Phone'
create table Orders(
OrderId int Identity(1,1) primary key,
OrderDate date,
AcountId int foreign key references Account(AcountId),
TotalAmount float,
);
insert into Orders values
('2024/10/10',1,1.365E8)
('2024/10/10',1,24000000)
create table OrderDetails(
OrderDetailId int Identity(1,1) Primary key,
OrderId int foreign key references Orders(OrderId),
ProductId int foreign key references Products(ProductId),
Quantity int,
Total float
);
insert into OrderDetails values 
(1,2,2,1422114)
create table cart(
CartId int Identity(1,1) primary key,
ProductId int foreign key references Products(ProductId),
AccountId int foreign key references Account(AcountId),
Quantity int
);
insert into OrderDetails values 
(1,1,3,24000000)
select * from Account
select * from Products
select * from OrderDetails
select * from  Orders
select * from cart
SELECT COUNT(*) AS total_items 
FROM cart;
SELECT SUM(Products.Price * Cart.Quantity) AS TotalAmount
FROM Cart
INNER JOIN Products ON Cart.ProductId = Products.ProductId;

select OrderId,ProductId,Quantity,ToTal  from OrderDetails   group by OrderId,ProductId,Quantity,ToTal

