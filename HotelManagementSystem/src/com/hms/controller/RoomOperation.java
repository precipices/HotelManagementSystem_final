package com.hms.controller;

import java.util.Vector;

import com.hms.dao.RoomDao;
import com.hms.entity.Room;

public class RoomOperation {
	public static String delRoom(String roomid)
	{
		Vector<Room> rooms=RoomDao.getRooms();
		for(int i=0;i<rooms.size();i++)
		{
			if((roomid.equals(rooms.get(i).getRoomid()))&&(!rooms.get(i).getStatus().equals("����")))return("�ÿͷ�����ʹ���У������޸�!");
		}
		RoomDao.deleteRoomByRoomid(roomid);
		return("�޸ĳɹ�");
	}
	public static void addRoom(String roomid,String roomtype,float price,String floor,String faceto,String status,String roominfo)
	{
		Room room=new Room();
		room.setRoomid(roomid);
		room.setRoomtype(roomtype);
		room.setPrice(price);
		room.setFloor(floor);
		room.setFaceto(faceto);
		room.setStatus(status);
		room.setInfo(roominfo);
		RoomDao.addRoom(room);
	}
}
