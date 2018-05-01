package com.hms.model;

import java.util.Vector;

import com.hms.dao.RoomDao;
import com.hms.entity.Room;

public class RoomModel {
	static Vector<Room> room = new Vector<Room>();
	public RoomModel() {}
	public static Vector<Room> getRooms(){
		room = RoomDao.getRooms();
		return room;
	}
	public static double checkPriceByRoomId(String roomid) {
		RoomModel.getRooms();
		for(int i = 0;i < room.size();i++) {
			if(room.get(i).getRoomid().equals(roomid))
				return room.get(i).getPrice();
		}
		return 0;
	}
	public static boolean updateRoomStatus(String roomId,String newStatus) {
		return RoomDao.updateRoomStatus(roomId, newStatus);
	}
}
