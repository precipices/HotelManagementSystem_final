package com.hms.entity;

import java.sql.Date;
import java.util.Vector;

//正在处理的房间订单
public class AdvanceRoomOrder {
	private String orderid;
	private String idcard;
	private String name;
	private String roomtype;
	private String floor;
	private String faceto;
	private Date enterdate;
	private Date leavedate;
	public AdvanceRoomOrder() {}
	public AdvanceRoomOrder(Vector<String> advanceroomorder) {
		this.orderid=advanceroomorder.get(0);
		this.idcard=advanceroomorder.get(1);
		this.name=advanceroomorder.get(2);
		this.roomtype=advanceroomorder.get(3);
		this.floor=advanceroomorder.get(4);
		this.faceto=advanceroomorder.get(5);
		this.enterdate=Date.valueOf(advanceroomorder.get(6));
		this.leavedate=Date.valueOf(advanceroomorder.get(7));
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
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
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getFaceto() {
		return faceto;
	}
	public void setFaceto(String faceto) {
		this.faceto = faceto;
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
	
}
