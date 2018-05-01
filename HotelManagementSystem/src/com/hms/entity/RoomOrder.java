package com.hms.entity;

import java.sql.Date;
import java.util.Vector;

/*
 * ����Ϊ�ѽ����Ķ���,�����ݿ���ȡ��
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
//--������
//create table RoomOrder
//(
//orderid varchar(20) primary key,		--������
//roomid varchar(10) foreign key references Room(roomid),	--�����
//idcard varchar(18) not null,			--�ͻ����֤��(��Ϊ��δע��Ŀͻ�,���Բ����������)
//enterdate date not null,				--��ס����
//leavedate date not null,				--�������
//charge money not null					--�շ�
//)