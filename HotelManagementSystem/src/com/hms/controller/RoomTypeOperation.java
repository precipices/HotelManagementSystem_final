package com.hms.controller;

import java.util.Vector;

import com.hms.dao.RoomDao;
import com.hms.dao.RoomTypeDao;
import com.hms.entity.Room;
import com.hms.entity.RoomType;

public class RoomTypeOperation {
	public static String addRoomType(String roomtype)
	{
		Vector<RoomType> roomtypes=RoomTypeDao.getRoomTypes();
		for(int i=0;i<roomtypes.size();i++)
		{
			if(roomtype.equals(roomtypes.get(i).getRoomtype()))return("该客房类型已存在！");
		}
		if(roomtype.trim().equals(""))return("类型不能为空");
		RoomTypeDao.addRoomType(roomtype);
		return("新客房类型添加成功！");
	}
	public static String delRoomType(String roomtype)
	{
		Vector<Room> rooms=RoomDao.getRooms();
		for(int i=0;i<rooms.size();i++)
		{
			if((roomtype.equals(rooms.get(i).getRoomtype()))&&(!rooms.get(i).getStatus().equals("空闲")))return("该客房类型正在使用中，不可删除！");
		}
		RoomTypeDao.deleteRoomType(roomtype);
		return("客房类型删除成功！");
	}
}
