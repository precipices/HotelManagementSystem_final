package com.hms.entity;

import java.util.Vector;

import com.hms.dao.RoomDao;

public class RoomType {
	private String roomtype;
	
	public RoomType() {}
	public RoomType(Vector<String> roomtype) {
		this.roomtype=roomtype.get(0);
	}
	
	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public int getNumber() {
		Vector<Room> rooms=RoomDao.getRooms();
		int num=0;
		for(int i=0;i<rooms.size();i++)
		{
			if(roomtype.equals(rooms.get(i).getRoomtype()))num++;
		}
		return num;
	}
}
