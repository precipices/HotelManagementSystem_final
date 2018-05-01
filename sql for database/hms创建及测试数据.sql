--客户表--6个属性
--Customer idcard(K),name,password,spend,spendtime,livelength
create table Customer
(
idcard varchar(18) primary key,	--身份证号
name nvarchar(20) not null,		--姓名
password varchar(20)not null,	--密码
spend money default 0,			--总计消费(元)
spendtime int default 0,		--消费次数(笔)
livelength int default 0		--入住总时长(天)
)
--房间表--7个属性
--Room roomid(K),status,price,roomtype,floor,faceto,info
create table Room
(
roomid varchar(10) primary key,	--房间号
status nvarchar(10) check (status in('空闲','有预订','入住中','预留','已超时')) default '空闲' not null,
								--房间状态
price money not null default 100,	--房价
roomtype nvarchar(20),			--房间类型
floor nvarchar(10),				--楼层
faceto nvarchar(10),			--朝向
info nvarchar(50) default '暂无描述'--房间特征描述
)
--员工表--8个属性
--Staff:staffid(K),position,name,password,salary,sex,age,employdate
create table Staff
(
staffid varchar(18) primary key,--员工号
position nvarchar(20)check (position in ('经理','前台接待员')) not null,
								--职位
name nvarchar(20) not null,		--姓名
password varchar(20)not null,	--密码
salary int,						--工资
sex nchar(1) check (sex in('男','女')) default '男',
								--性别
age int default 0,				--年龄
employdate date					--入职日期
)

insert into staff (staffid,position,name,password) values('s0004','前台接待员','李3','123')
select * from Staff
--订单表--6
--RoomOrder:orderid(K),roomid,idcard,enterdate,leavedate,charge
create table RoomOrder
(
orderid varchar(20) primary key,		--订单号
roomid varchar(10) not null,	--房间号
idcard varchar(18) not null,			--客户身份证号(因为有未注册的客户,所以不能设置外键)
enterdate varchar(30) not null,				--入住日期
leavedate varchar(30) not null,				--离店日期
charge money not null					--收费
)
--正在处理的订单表--8
--AdvanceRoomOrder:orderid(K),idcard,name,roomtype,floor,faceto,enterdate,leavedate
create table AdvanceRoomOrder(
orderid varchar(20) primary key,		--订单号
idcard varchar(18) not null,			--客户身份证号
name nvarchar(20) not null,				--姓名
roomtype nvarchar(20),					--房间类型
floor nvarchar(10),						--楼层
faceto nvarchar(10),					--朝向
enterdate varchar(30) not null,				--入住日期
leavedate varchar(30) not null,				--离店日期
)
--房间类型表--1
--RoomType:roomtype(K)
create table RoomType(
roomtype nvarchar(20) primary key,			--房间类型
)


--Customer idcard(K),name,password,spend,spendtime,livelength
insert into Customer values('4211','张1','123','0','0','0')
insert into Customer values('4212','张2','123','0','0','0')
insert into Customer values('4213','张3','123','0','0','0')
insert into Customer values('4214','张4','123','0','0','0')
insert into Customer values('4215','张5','123','0','0','0')
insert into Customer values('4216','张6','123','0','0','0')
insert into Customer values('4217','张7','123','0','0','0')
insert into Customer values('4218','张8','123','0','0','0')
insert into Customer values('4219','张9','123','0','0','0')
insert into Customer values('4220','张10','123','0','0','0')
--Staff:staffid(K),position,name,password,salary,sex,age,employdate
insert into staff values('s0001','经理','李1','123','10000','男','30','1970-8-8')
insert into staff values('s0002','前台接待员','李2','123','5000','女','30','1970-8-8')
insert into staff values('s0003','前台接待员','李3','123','5000','女','30','1970-8-8')
--RoomOrder:orderid(K),roomid,idcard,enterdate,leavedate,charge
insert into RoomOrder values('ro000001','101','4211','1977-1-1','1977-1-5','400')
insert into RoomOrder values('ro000002','201','4211','1977-2-1','1977-2-5','400')
insert into RoomOrder values('ro000003','301','4211','1977-3-1','1977-3-5','400')
insert into RoomOrder values('ro000004','401','4212','1977-4-1','1977-4-5','400')
insert into RoomOrder values('ro000005','501','4212','1977-5-1','1977-5-5','400')
insert into RoomOrder values('ro000006','102','4212','1977-6-1','1977-6-5','400')
insert into RoomOrder values('ro000007','103','4213','1977-7-1','1977-7-5','400')
insert into RoomOrder values('ro000008','104','4213','1977-8-1','1977-8-5','400')
insert into RoomOrder values('ro000009','105','4214','1977-9-1','1977-9-5','400')
insert into RoomOrder values('ro000010','106','4215','1977-10-1','1977-10-5','400')
--RoomType:roomtype(K)
insert into RoomType values('单人间')
insert into RoomType values('双人间')


--Customer idcard(K),name,password,spend,spendtime,livelength
--Room roomid(K),status,price,roomtype,floor,faceto,info
--Staff:staffid(K),position,name,password,salary,sex,age,employdate
--RoomOrder:orderid(K),roomid,idcard,enterdate,leavedate,charge
--AdvanceRoomOrder:orderid(K),idcard,name,roomtype,floor,faceto,enterdate,leavedate
--RoomType:roomtype(K)


--删除所有表及数据
drop table Customer
drop table Staff
drop table RoomOrder
drop table AdvanceRoomOrder
drop table Room
drop table Roomtype
--删除所有表的数据,不删表
delete from Customer
delete from Staff
delete from RoomOrder
delete from AdvanceRoomOrder
delete from Room
delete from Roomtype
--查看所有表数据
select * from Customer
select * from Room
select * from Staff
select * from RoomOrder
select * from AdvanceRoomOrder
select * from Roomtype

select top 1 orderid from RoomOrder Order by orderid desc
select top 1 orderid from AdvanceRoomOrder order by orderid desc

select orderid from RoomOrder union
select orderid from AdvanceRoomOrder
--查找最大的id号
select top 1 * from (
select orderid from RoomOrder union
select orderid from AdvanceRoomOrder
) temp 
order by orderid desc