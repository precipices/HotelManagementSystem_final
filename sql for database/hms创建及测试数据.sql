--�ͻ���--6������
--Customer idcard(K),name,password,spend,spendtime,livelength
create table Customer
(
idcard varchar(18) primary key,	--���֤��
name nvarchar(20) not null,		--����
password varchar(20)not null,	--����
spend money default 0,			--�ܼ�����(Ԫ)
spendtime int default 0,		--���Ѵ���(��)
livelength int default 0		--��ס��ʱ��(��)
)
--�����--7������
--Room roomid(K),status,price,roomtype,floor,faceto,info
create table Room
(
roomid varchar(10) primary key,	--�����
status nvarchar(10) check (status in('����','��Ԥ��','��ס��','Ԥ��','�ѳ�ʱ')) default '����' not null,
								--����״̬
price money not null default 100,	--����
roomtype nvarchar(20),			--��������
floor nvarchar(10),				--¥��
faceto nvarchar(10),			--����
info nvarchar(50) default '��������'--������������
)
--Ա����--8������
--Staff:staffid(K),position,name,password,salary,sex,age,employdate
create table Staff
(
staffid varchar(18) primary key,--Ա����
position nvarchar(20)check (position in ('����','ǰ̨�Ӵ�Ա')) not null,
								--ְλ
name nvarchar(20) not null,		--����
password varchar(20)not null,	--����
salary int,						--����
sex nchar(1) check (sex in('��','Ů')) default '��',
								--�Ա�
age int default 0,				--����
employdate date					--��ְ����
)

insert into staff (staffid,position,name,password) values('s0004','ǰ̨�Ӵ�Ա','��3','123')
select * from Staff
--������--6
--RoomOrder:orderid(K),roomid,idcard,enterdate,leavedate,charge
create table RoomOrder
(
orderid varchar(20) primary key,		--������
roomid varchar(10) not null,	--�����
idcard varchar(18) not null,			--�ͻ����֤��(��Ϊ��δע��Ŀͻ�,���Բ����������)
enterdate varchar(30) not null,				--��ס����
leavedate varchar(30) not null,				--�������
charge money not null					--�շ�
)
--���ڴ���Ķ�����--8
--AdvanceRoomOrder:orderid(K),idcard,name,roomtype,floor,faceto,enterdate,leavedate
create table AdvanceRoomOrder(
orderid varchar(20) primary key,		--������
idcard varchar(18) not null,			--�ͻ����֤��
name nvarchar(20) not null,				--����
roomtype nvarchar(20),					--��������
floor nvarchar(10),						--¥��
faceto nvarchar(10),					--����
enterdate varchar(30) not null,				--��ס����
leavedate varchar(30) not null,				--�������
)
--�������ͱ�--1
--RoomType:roomtype(K)
create table RoomType(
roomtype nvarchar(20) primary key,			--��������
)


--Customer idcard(K),name,password,spend,spendtime,livelength
insert into Customer values('4211','��1','123','0','0','0')
insert into Customer values('4212','��2','123','0','0','0')
insert into Customer values('4213','��3','123','0','0','0')
insert into Customer values('4214','��4','123','0','0','0')
insert into Customer values('4215','��5','123','0','0','0')
insert into Customer values('4216','��6','123','0','0','0')
insert into Customer values('4217','��7','123','0','0','0')
insert into Customer values('4218','��8','123','0','0','0')
insert into Customer values('4219','��9','123','0','0','0')
insert into Customer values('4220','��10','123','0','0','0')
--Staff:staffid(K),position,name,password,salary,sex,age,employdate
insert into staff values('s0001','����','��1','123','10000','��','30','1970-8-8')
insert into staff values('s0002','ǰ̨�Ӵ�Ա','��2','123','5000','Ů','30','1970-8-8')
insert into staff values('s0003','ǰ̨�Ӵ�Ա','��3','123','5000','Ů','30','1970-8-8')
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
insert into RoomType values('���˼�')
insert into RoomType values('˫�˼�')


--Customer idcard(K),name,password,spend,spendtime,livelength
--Room roomid(K),status,price,roomtype,floor,faceto,info
--Staff:staffid(K),position,name,password,salary,sex,age,employdate
--RoomOrder:orderid(K),roomid,idcard,enterdate,leavedate,charge
--AdvanceRoomOrder:orderid(K),idcard,name,roomtype,floor,faceto,enterdate,leavedate
--RoomType:roomtype(K)


--ɾ�����б�����
drop table Customer
drop table Staff
drop table RoomOrder
drop table AdvanceRoomOrder
drop table Room
drop table Roomtype
--ɾ�����б������,��ɾ��
delete from Customer
delete from Staff
delete from RoomOrder
delete from AdvanceRoomOrder
delete from Room
delete from Roomtype
--�鿴���б�����
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
--��������id��
select top 1 * from (
select orderid from RoomOrder union
select orderid from AdvanceRoomOrder
) temp 
order by orderid desc