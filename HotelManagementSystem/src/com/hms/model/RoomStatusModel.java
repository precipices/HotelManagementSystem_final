package com.hms.model;

import java.util.Vector;

import com.hms.dao.RoomDao;
import com.hms.entity.Room;

public class RoomStatusModel {
	static Vector<Room> room = RoomDao.getRooms(); 
	public RoomStatusModel() {}
	public static int[] RoomStatusStatisticsByRoomType(String roomType,String floor,String faceto) {
		int stat[] = {0,0,0,0};
		String str = "请选择";
		if(roomType.equals(str))
		{
			if(floor.equals(str)) 
			{
				if(faceto.equals(str)) 
				{
					for(int i = 0;i < room.size();i++)
					{
						if(room.get(i).getStatus().equals("空闲"))
							stat[0]++;
						if(room.get(i).getStatus().equals("有预订"))
							stat[1]++;
						if(room.get(i).getStatus().equals("入住中"))
							stat[2]++;
						if(room.get(i).getStatus().equals("已超时"))
							stat[3]++;
					}
				}
				else
				{
					for(int i = 0;i < room.size();i++)
					{
						if(faceto.equals(room.get(i).getFaceto())) 
						{
							if(room.get(i).getStatus().equals("空闲"))
								stat[0]++;
							if(room.get(i).getStatus().equals("有预订"))
								stat[1]++;
							if(room.get(i).getStatus().equals("入住中"))
								stat[2]++;
							if(room.get(i).getStatus().equals("已超时"))
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
							if(room.get(i).getStatus().equals("空闲"))
								stat[0]++;
							if(room.get(i).getStatus().equals("有预订"))
								stat[1]++;
							if(room.get(i).getStatus().equals("入住中"))
								stat[2]++;
							if(room.get(i).getStatus().equals("已超时"))
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
							if(room.get(i).getStatus().equals("空闲"))
								stat[0]++;
							if(room.get(i).getStatus().equals("有预订"))
								stat[1]++;
							if(room.get(i).getStatus().equals("入住中"))
								stat[2]++;
							if(room.get(i).getStatus().equals("已超时"))
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
							if(room.get(i).getStatus().equals("空闲"))
								stat[0]++;
							if(room.get(i).getStatus().equals("有预订"))
								stat[1]++;
							if(room.get(i).getStatus().equals("入住中"))
								stat[2]++;
							if(room.get(i).getStatus().equals("已超时"))
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
							if(room.get(i).getStatus().equals("空闲"))
								stat[0]++;
							if(room.get(i).getStatus().equals("有预订"))
								stat[1]++;
							if(room.get(i).getStatus().equals("入住中"))
								stat[2]++;
							if(room.get(i).getStatus().equals("已超时"))
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
							if(room.get(i).getStatus().equals("空闲"))
								stat[0]++;
							if(room.get(i).getStatus().equals("有预订"))
								stat[1]++;
							if(room.get(i).getStatus().equals("入住中"))
								stat[2]++;
							if(room.get(i).getStatus().equals("已超时"))
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
							if(room.get(i).getStatus().equals("空闲"))
								stat[0]++;
							if(room.get(i).getStatus().equals("有预定"))
								stat[1]++;
							if(room.get(i).getStatus().equals("入住中"))
								stat[2]++;
							if(room.get(i).getStatus().equals("已超时"))
								stat[3]++;
						}
					}
				}
			}
		}	
		return stat;
	}
}
