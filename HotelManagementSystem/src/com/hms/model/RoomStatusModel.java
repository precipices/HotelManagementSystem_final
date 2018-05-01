package com.hms.model;

import java.util.Vector;

import com.hms.dao.RoomDao;
import com.hms.entity.Room;

public class RoomStatusModel {
	static Vector<Room> room = RoomDao.getRooms(); 
	public RoomStatusModel() {}
	public static int[] RoomStatusStatisticsByRoomType(String roomType,String floor,String faceto) {
		int stat[] = {0,0,0,0};
		String str = "��ѡ��";
		if(roomType.equals(str))
		{
			if(floor.equals(str)) 
			{
				if(faceto.equals(str)) 
				{
					for(int i = 0;i < room.size();i++)
					{
						if(room.get(i).getStatus().equals("����"))
							stat[0]++;
						if(room.get(i).getStatus().equals("��Ԥ��"))
							stat[1]++;
						if(room.get(i).getStatus().equals("��ס��"))
							stat[2]++;
						if(room.get(i).getStatus().equals("�ѳ�ʱ"))
							stat[3]++;
					}
				}
				else
				{
					for(int i = 0;i < room.size();i++)
					{
						if(faceto.equals(room.get(i).getFaceto())) 
						{
							if(room.get(i).getStatus().equals("����"))
								stat[0]++;
							if(room.get(i).getStatus().equals("��Ԥ��"))
								stat[1]++;
							if(room.get(i).getStatus().equals("��ס��"))
								stat[2]++;
							if(room.get(i).getStatus().equals("�ѳ�ʱ"))
								stat[3]++;
						}
					}
				}
			}
			else 
			{
				if(faceto.equals(str)) 
				{
					for(int i = 0;i < room.size();i++)
					{
						if(floor.equals(room.get(i).getFloor())) 
						{
							if(room.get(i).getStatus().equals("����"))
								stat[0]++;
							if(room.get(i).getStatus().equals("��Ԥ��"))
								stat[1]++;
							if(room.get(i).getStatus().equals("��ס��"))
								stat[2]++;
							if(room.get(i).getStatus().equals("�ѳ�ʱ"))
								stat[3]++;
						}
					}
				}
				else
				{
					for(int i = 0;i < room.size();i++)
					{
						if(faceto.equals(room.get(i).getFaceto())&&floor.equals(room.get(i).getFloor())) 
						{
							if(room.get(i).getStatus().equals("����"))
								stat[0]++;
							if(room.get(i).getStatus().equals("��Ԥ��"))
								stat[1]++;
							if(room.get(i).getStatus().equals("��ס��"))
								stat[2]++;
							if(room.get(i).getStatus().equals("�ѳ�ʱ"))
								stat[3]++;
						}
					}
				}
			}
		}
		else
		{
			if(floor.equals(str)) 
			{
				if(faceto.equals(str)) 
				{
					for(int i = 0;i < room.size();i++)
					{
						if(roomType.equals(room.get(i).getRoomtype()))
						{
							if(room.get(i).getStatus().equals("����"))
								stat[0]++;
							if(room.get(i).getStatus().equals("��Ԥ��"))
								stat[1]++;
							if(room.get(i).getStatus().equals("��ס��"))
								stat[2]++;
							if(room.get(i).getStatus().equals("�ѳ�ʱ"))
								stat[3]++;
						}
					}
				}
				else
				{
					for(int i = 0;i < room.size();i++)
					{
						if(faceto.equals(room.get(i).getFaceto())&&roomType.equals(room.get(i).getRoomtype())) 
						{
							if(room.get(i).getStatus().equals("����"))
								stat[0]++;
							if(room.get(i).getStatus().equals("��Ԥ��"))
								stat[1]++;
							if(room.get(i).getStatus().equals("��ס��"))
								stat[2]++;
							if(room.get(i).getStatus().equals("�ѳ�ʱ"))
								stat[3]++;
						}
					}
				}
			}
			else 
			{
				if(faceto.equals(str)) 
				{
					for(int i = 0;i < room.size();i++)
					{
						if(roomType.equals(room.get(i).getRoomtype())&&floor.equals(room.get(i).getFloor())) 
						{
							if(room.get(i).getStatus().equals("����"))
								stat[0]++;
							if(room.get(i).getStatus().equals("��Ԥ��"))
								stat[1]++;
							if(room.get(i).getStatus().equals("��ס��"))
								stat[2]++;
							if(room.get(i).getStatus().equals("�ѳ�ʱ"))
								stat[3]++;
						}
					}
				}
				else
				{
					for(int i = 0;i < room.size();i++)
					{
						if(roomType.equals(room.get(i).getRoomtype())&&faceto.equals(room.get(i).getFaceto())&&floor.equals(room.get(i).getFloor())) 
						{
							if(room.get(i).getStatus().equals("����"))
								stat[0]++;
							if(room.get(i).getStatus().equals("��Ԥ��"))
								stat[1]++;
							if(room.get(i).getStatus().equals("��ס��"))
								stat[2]++;
							if(room.get(i).getStatus().equals("�ѳ�ʱ"))
								stat[3]++;
						}
					}
				}
			}
		}	
		return stat;
	}
}
