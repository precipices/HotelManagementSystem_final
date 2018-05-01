Create database hms
On
(name='hms_data',
Filename='D:\database\hms.mdf', --����database�ļ��б����Ѵ��ڣ���Ȼ�ᷢ������
Size=5MB,
Maxsize=20MB,
Filegrowth=10%)

log on
(name='hms_log',
filename='D:\database\hms.ldf',
size=2MB,
maxsize=5MB,
filegrowth=1MB)

use hms
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
--�����--7������
--Room roomid(K),status,price,roomtype,floor,faceto,info
insert into Room values('101','����','100','���˼�','1¥','��','��������')
insert into Room values('102','����','100','���˼�','1¥','��','��������')
insert into Room values('103','����','100','���˼�','1¥','��','��������')
insert into Room values('104','����','100','���˼�','1¥','��','��������')
insert into Room values('105','����','100','���˼�','1¥','��','��������')
insert into Room values('106','����','100','���˼�','1¥','��','��������')
insert into Room values('107','����','100','���˼�','1¥','��','��������')
insert into Room values('108','����','100','���˼�','1¥','��','��������')
insert into Room values('109','����','100','���˼�','1¥','��','��������')
insert into Room values('110','����','100','���˼�','1¥','��','��������')

insert into Room values('201','����','100','���˼�','2¥','��','��������')
insert into Room values('202','����','100','���˼�','2¥','��','��������')
insert into Room values('203','����','100','���˼�','2¥','��','��������')
insert into Room values('204','����','100','���˼�','2¥','��','��������')
insert into Room values('205','����','100','���˼�','2¥','��','��������')
insert into Room values('206','����','100','���˼�','2¥','��','��������')
insert into Room values('207','����','100','���˼�','2¥','��','��������')
insert into Room values('208','����','100','���˼�','2¥','��','��������')
insert into Room values('209','����','100','���˼�','2¥','��','��������')
insert into Room values('210','����','100','���˼�','2¥','��','��������')

insert into Room values('301','����','100','���˼�','3¥','��','��������')
insert into Room values('302','����','100','���˼�','3¥','��','��������')
insert into Room values('303','����','100','���˼�','3¥','��','��������')
insert into Room values('304','����','100','���˼�','3¥','��','��������')
insert into Room values('305','����','100','���˼�','3¥','��','��������')
insert into Room values('306','����','100','���˼�','3¥','��','��������')
insert into Room values('307','����','100','���˼�','3¥','��','��������')
insert into Room values('308','����','100','���˼�','3¥','��','��������')
insert into Room values('309','����','100','���˼�','3¥','��','��������')
insert into Room values('310','����','100','���˼�','3¥','��','��������')

insert into Room values('401','����','100','���˼�','4¥','��','��������')
insert into Room values('402','����','100','���˼�','4¥','��','��������')
insert into Room values('403','����','100','���˼�','4¥','��','��������')
insert into Room values('404','����','100','���˼�','4¥','��','��������')
insert into Room values('405','����','100','���˼�','4¥','��','��������')
insert into Room values('406','����','100','���˼�','4¥','��','��������')
insert into Room values('407','����','100','���˼�','4¥','��','��������')
insert into Room values('408','����','100','���˼�','4¥','��','��������')
insert into Room values('409','����','100','���˼�','4¥','��','��������')
insert into Room values('410','����','100','���˼�','4¥','��','��������')

insert into Room values('501','����','100','˫�˼�','5¥','��','��������')
insert into Room values('502','����','100','˫�˼�','5¥','��','��������')
insert into Room values('503','����','100','˫�˼�','5¥','��','��������')
insert into Room values('504','����','100','˫�˼�','5¥','��','��������')
insert into Room values('505','����','100','˫�˼�','5¥','��','��������')
insert into Room values('506','����','100','˫�˼�','5¥','��','��������')
insert into Room values('507','����','100','˫�˼�','5¥','��','��������')
insert into Room values('508','����','100','˫�˼�','5¥','��','��������')
insert into Room values('509','����','100','˫�˼�','5¥','��','��������')
insert into Room values('510','����','100','˫�˼�','5¥','��','��������')
