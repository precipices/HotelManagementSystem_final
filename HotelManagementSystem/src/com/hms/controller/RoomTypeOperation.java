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
			if(roomtype.equals(roomtypes.get(i).getRoomtype()))return("�ÿͷ������Ѵ��ڣ�");
		}
		if(roomtype.trim().equals(""))return("���Ͳ���Ϊ��");
		RoomTypeDao.addRoomType(roomtype);
		return("�¿ͷ�������ӳɹ���");
	}
	public static String delRoomType(String roomtype)
	{
		Vector<Room> rooms=RoomDao.getRooms();
		for(int i=0;i<rooms.size();i++)
		{
			if((roomtype.equals(rooms.get(i).getRoomtype()))&&(!rooms.get(i).getStatus().equals("����")))return("�ÿͷ���������ʹ���У�����ɾ����");
		}
		RoomTypeDao.deleteRoomType(roomtype);
		return("�ͷ�����ɾ���ɹ���");
	}
}
