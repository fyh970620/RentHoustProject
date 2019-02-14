create database zufang;
select * from house;
select * from housetype;
select * from street;
select * from users;
select * from Users where username='cs_username' and password='cs';
delete from Users where id = 1;
select * from District;
select * from street;
delete from house where id=14

select district.id,district.name,street.name
		from district
		left join street
		on district.id=street.district_id
		where district.id=1004


--------------------------------------------------------------------------------------
--用户表
create table USERS
(
  ID        int primary key auto_increment,        
  NAME      VARCHAR(50),          
  PASSWORD  VARCHAR(50),          
  TELEPHONE VARCHAR(15),        
  USERNAME  VARCHAR(50),          
  ISADMIN   VARCHAR(5)             
);
--地区表
create table DISTRICT 
(
  ID   int primary key,          
  NAME VARCHAR(50) 
);
--街道表
create table STREET
(
  ID        int primary key,      
  NAME        VARCHAR(50),        
  DISTRICT_ID int               
);
--房屋类型表
create table housetype
(
  ID    int primary key auto_increment,            
  NAME VARCHAR(20) 
)
--房屋信息表
create table HOUSE
(
  ID          int primary key auto_increment,                
  USER_ID     int,                
  TYPE_ID     int,                 
  TITLE       NVARCHAR(50),          
  DESCRIPTION text,       
  PRICE       double,              
  PUBDATE     DATE,        
  FLOORAGE    int,            
  CONTACT     VARCHAR(100),   
  STREET_ID   int            
);
--地区表插入
insert into DISTRICT (ID, NAME)
values (1001, '东城');
insert into DISTRICT (ID, NAME)
values (1002, '西城');
insert into DISTRICT (ID, NAME)
values (1003, '石景山');
insert into DISTRICT (ID, NAME)
values (1006, '朝阳');
insert into DISTRICT (ID, NAME)
values (1000, '丰台');
insert into DISTRICT (ID, NAME)
values (1004, '海淀');
--街道表插入
insert into STREET (ID, NAME, DISTRICT_ID)
values (1000, '知春路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1001, '中关村大街', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1002, '学院路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1003, '朝阳路', 1006);
--房屋类型插入
insert into housetype ( NAME)
values ('一室一厅');
insert into housetype ( NAME)
values ('一室两厅');
insert into housetype ( NAME)
values ( '两室一厅');
insert into housetype ( NAME)
values ( '两室两厅');
insert into housetype ( NAME)
values ('三室一厅');
insert into housetype ( NAME)
values ( '三室两厅');
insert into housetype (NAME)
values ( '四室一厅');
insert into housetype ( NAME)
values ( '四室两厅');
insert into housetype ( NAME)
values ( '四十三厅');
--用户插入
insert into USERS ( NAME,password,telephone,username,isadmin)
values ( 'yc','a','1234433','a','1');



