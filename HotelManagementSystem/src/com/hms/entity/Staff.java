package com.hms.entity;

import java.util.Vector;

public class Staff {//���˸�����
	private String staffid;
	private String position;
	private String name;
	private String password;
	public Staff() {}
	public Staff(Vector<String> staff) {
		this.staffid=staff.get(0);
		this.position=staff.get(1);
		this.name=staff.get(2);
		this.password=staff.get(3);
	}
	public String getStaffid() {
		return staffid;
	}
	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
//create table staff
//(
//staffid varchar(18) primary key,--Ա����
//position nvarchar(20) not null,	--ְλ
//name nvarchar(20) not null,		--����
//password varchar(20)not null,	--����
//salary int,						--����
//sex nchar(1) check (sex in('��','Ů')) default '��',--�Ա�
//age int,						--����
//employdate date				--��ְ����
//)