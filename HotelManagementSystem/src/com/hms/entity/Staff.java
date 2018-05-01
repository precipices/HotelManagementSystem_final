package com.hms.entity;

import java.util.Vector;

public class Staff {//共八个数据
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
//staffid varchar(18) primary key,--员工号
//position nvarchar(20) not null,	--职位
//name nvarchar(20) not null,		--姓名
//password varchar(20)not null,	--密码
//salary int,						--工资
//sex nchar(1) check (sex in('男','女')) default '男',--性别
//age int,						--年龄
//employdate date				--入职日期
//)