package com.hms.entity;

import java.util.Vector;

public class Customer {
	private String idcard;
	private String name;
	private String password;
	private float spend;
	private int spendtime;
	private int livelength;
	public Customer() {}
	public Customer(Vector<String> customer) {
		this.idcard=customer.get(0);
		this.name=customer.get(1);
		this.password=customer.get(2);
		this.spend=Float.parseFloat(customer.get(3));
		this.spendtime=Integer.parseInt(customer.get(4));
		this.livelength=Integer.parseInt(customer.get(5));
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " idcard="+idcard+" name="+name+" password"+password
				+" spend="+spend+" spendtime="+spendtime+" livelength="+livelength;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
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
	public float getSpend() {
		return spend;
	}
	public void setSpend(float spend) {
		this.spend = spend;
	}
	public int getSpendtime() {
		return spendtime;
	}
	public void setSpendtime(int spendtime) {
		this.spendtime = spendtime;
	}
	public int getLivelength() {
		return livelength;
	}
	public void setLivelength(int livelength) {
		this.livelength = livelength;
	}
}
//--客户表
//create table Customer
//(
//idcard varchar(18) primary key,	--身份证号
//name nvarchar(20) not null,		--姓名
//password varchar(20)not null,	--密码
//spend money default 0,			--总计消费(元)
//spendtime int default 0,		--消费次数(笔)
//livelength int default 0		--入住总时长(天)
//)