package com.hms.entity;

import java.sql.Date;
import java.util.Vector;

/*
 * 该类为已结束的订单,从数据库中取出
 */
public class RoomOrder {
	private String orderid;
	private String roomid;
	private String idcard;
	private Date enterdate;
	private Date leavedate;
	private float charge;
	public RoomOrder() {}
	public RoomOrder(Vector<String> roomorder) {
		this.orderid=roomorder.get(0);
		this.roomid=roomorder.get(1);
		this.idcard=roomorder.get(2);
		this.enterdate=Date.valueOf(roomorder.get(3));
		this.leavedate=Date.valueOf(roomorder.get(4));
		this.charge=Float.parseFloat(roomorder.get(5));
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public Date getEnterdate() {
		return enterdate;
	}
	public void setEnterdate(Date enterdate) {
		this.enterdate = enterdate;
	}
	public Date getLeavedate() {
		return leavedate;
	}
	public void setLeavedate(Date leavedate) {
		this.leavedate = leavedate;
	}
	public float getCharge() {
		return charge;
	}
	public void setCharge(float charge) {
		this.charge = charge;
	}
}
//--订单表
//create table RoomOrder
//(
//orderid varchar(20) primary key,		--订单号
//roomid varchar(10) foreign key references Room(roomid),	--房间号
//idcard varchar(18) not null,			--客户身份证号(因为有未注册的客户,所以不能设置外键)
//enterdate date not null,				--入住日期
//leavedate date not null,				--离店日期
//charge money not null					--收费
//)