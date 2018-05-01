package com.hms.dao;

import java.util.Vector;

import com.hms.entity.RoomType;

public class RoomTypeDao {
	public static Vector<RoomType> getRoomTypes() {
		Vector<RoomType> roomTypes=new Vector<RoomType>();
		Vector<Vector<String>> rowData;
		rowData=new SqlHelper().query("select * from RoomType");
		for(int i=0;i<rowData.size();i++) {
			roomTypes.add(new RoomType(rowData.get(i)));
		}
		return roomTypes;
	}	
	public static void addRoomType(String roomtype) {
		String paras[]= {roomtype};
		new SqlHelper().update("insert into RoomType values(?)",paras);
	}
	public static void deleteRoomType(String roomtype) {
		String paras[]= {roomtype};
		new SqlHelper().update("delete from RoomType where roomtype = ?",paras);
	}
}
