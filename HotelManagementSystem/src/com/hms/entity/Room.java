package com.hms.entity;

import java.util.Vector;

public class Room {
	private String roomid;
	private String status;//״ֻ̬����'����','��Ԥ��','��ס��','Ԥ��'
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
//--�����--8������
//create table Room
//(
//roomid varchar(10) primary key,	--�����
//status nvarchar(10)				--����״̬
//check (status in('����','��Ԥ��','��ס��','Ԥ��','�ѳ�ʱ')) default '����',
//price money not null default 100,	--����
//roomtype nvarchar(20),			--��������
//floor nvarchar(10),				--¥��
//faceto nvarchar(10),			--����
//info nvarchar(50) default '��������'--������������
//)