package com.hms.dao;

import java.util.Vector;

import com.hms.entity.Room;

public class RoomDao {
	public static Vector<Room> getRooms() {
		Vector<Room> rooms=new Vector<Room>();
		Vector<Vector<String>> rowData;
		rowData=new SqlHelper().query("select * from Room");
		for(int i=0;i<rowData.size();i++) {
			rooms.add(new Room(rowData.get(i)));
		}
		return rooms;
	}
	public static boolean updateRoomStatus(String roomId,String newStatus) {
		SqlHelper sq = new SqlHelper();
		String paras[] = {newStatus,roomId};
		return sq.update("update Room set Status = ? where roomid = ?",paras);
	}
	public static void addRoom(Room r) {
		String paras[]= {r.getRoomid(),r.getStatus(),r.getPrice()+"",r.getRoomtype(),r.getFloor(),r.getFaceto(),r.getInfo()};
		new SqlHelper().update("insert into Room values(?,?,?,?,?,?,?)",paras);
	}
	public static void deleteRoomByRoomid(String roomid) {
		String paras[]= {roomid};
		new SqlHelper().update("delete from Room where roomid = ?",paras);
	}
}
