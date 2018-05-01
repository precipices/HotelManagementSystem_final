package com.hms.model;

import java.util.Vector;

import com.hms.dao.RoomDao;
import com.hms.entity.Room;

public class CustomerViewRoomModel {
	public static Vector<Room> rooms = new Vector<Room>();
	public static boolean equalsDb = false;

	public static void getData() {
		if (!equalsDb) {
			rooms = RoomDao.getRooms();
			equalsDb = true;
		}
	}
	public static Vector<Room> getRooms(){
		getData();
		return rooms;
	}
	
}
