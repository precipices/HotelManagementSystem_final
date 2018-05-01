package com.hms.dao;

import java.util.Vector;

import com.hms.dao.SqlHelper;
import com.hms.entity.RoomOrder;

public class RoomOrderDao {
	public static Vector<RoomOrder> getRoomOrders() {
		Vector<RoomOrder> roomOrders=new Vector<RoomOrder>();
		Vector<Vector<String>> rowData;
		rowData=new SqlHelper().query("select * from RoomOrder");
		for(int i=0;i<rowData.size();i++) {
			roomOrders.add(new RoomOrder(rowData.get(i)));
		}
		return roomOrders;
	}
	public static Vector<RoomOrder> getRoomOrdersByIdcard(String idcard) {
		Vector<RoomOrder> roomOrders=new Vector<RoomOrder>();
		Vector<Vector<String>> rowData;
		String[] paras={idcard};
		rowData=new SqlHelper().query("select * from RoomOrder where idcard = ?",paras);
		for(int i=0;i<rowData.size();i++) {
			roomOrders.add(new RoomOrder(rowData.get(i)));
		}
		return roomOrders;
	}
	public static void addRoomOrder(RoomOrder ro) {
		String paras[]= {ro.getOrderid(),ro.getRoomid(),ro.getIdcard(),ro.getEnterdate()+"",ro.getLeavedate()+"",ro.getCharge()+""};
		new SqlHelper().update("insert into RoomOrder values(?,?,?,?,?,?)",paras);
	}
	public static boolean deleteRoomOrderByOrderId(String OrderId) {
		String paras[] = {OrderId};
		return new SqlHelper().update("delete from RoomOrder where OrderId = ?",paras);
	}
}
