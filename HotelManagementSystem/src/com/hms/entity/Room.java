package com.hms.entity;

import java.util.Vector;

public class Room {
	private String roomid;
	private String status;//状态只能是'空闲','有预订','入住中','预留'
	private float price;
	private String roomtype;
	private String floor;
	private String faceto;
	private String info;
	public Room() {}
	public Room(Vector<String> room) {
		this.roomid=room.get(0);
		this.status=room.get(1);
		this.price=Float.parseFloat(room.get(2));
		this.roomtype=room.get(3);
		this.floor=room.get(4);
		this.faceto=room.get(5);
		this.info=room.get(6);
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
//--房间表--8个属性
//create table Room
//(
//roomid varchar(10) primary key,	--房间号
//status nvarchar(10)				--房间状态
//check (status in('空闲','已预定','入住中','预留','已超时')) default '空闲',
//price money not null default 100,	--房价
//roomtype nvarchar(20),			--房间类型
//floor nvarchar(10),				--楼层
//faceto nvarchar(10),			--朝向
//info nvarchar(50) default '暂无描述'--房间特征描述
//)