package com.hms.model;

import java.util.Vector;

import com.hms.dao.RoomTypeDao;
import com.hms.entity.RoomType;

public class CustomerRoomTypeModel {
	public static Vector<String> roomtypes=new Vector<String>();
	public static void getData() {
			Vector<RoomType> types=RoomTypeDao.getRoomTypes();
			roomtypes=new Vector<String>();
			for(int i=0;i<types.size();i++) {
				roomtypes.add(types.get(i).getRoomtype());
			}
	}
	public static Vector<String> getRoomTypes(){
		getData();
		return roomtypes;
	}
}
