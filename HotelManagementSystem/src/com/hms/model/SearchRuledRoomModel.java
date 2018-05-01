package com.hms.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Vector;

import com.hms.dao.RoomDao;
import com.hms.entity.Room;
import com.hms.entity.RoomOrder;

public class SearchRuledRoomModel {
	public static Vector<Room> rooms = new Vector<Room>();
	
	public static Vector<Room> searchRuledRoom(String roomType,String floor,String faceto,Date enterdate,Date leavedate) {
		rooms = RoomDao.getRooms();
		Vector <Room> ruledRoom = new Vector <Room>();
		String str = "«Î—°‘Ò";
		if(roomType.equals(str)&&floor.equals(str)&&faceto.equals(str)) 
			return ruledRoom;
		if(enterdate.equals("")||leavedate.equals(""))
			return ruledRoom;
		else if(floor.equals(str)&& faceto.equals(str)) {
			for(int i = 0 ;i < rooms.size();i++) {
				if(rooms.get(i).getRoomtype().equals(roomType)&&
						(rooms.get(i).getStatus().equals("ø’œ–")||
					(rooms.get(i).getStatus().equals("”–‘§∂©")&&
							SearchRuledRoomModel.isFree(rooms.get(i).getRoomid(),enterdate,leavedate))))
					ruledRoom.add(rooms.get(i));
			}
			return ruledRoom;
		}
		else if(floor.equals(str)){
			for(int i = 0;i < rooms.size();i++) {
				if(rooms.get(i).getRoomtype().equals(roomType)&&
						rooms.get(i).getFaceto().equals(faceto)&&
						(rooms.get(i).getStatus().equals("ø’œ–")||
								(rooms.get(i).getStatus().equals("”–‘§∂©")&&
								SearchRuledRoomModel.isFree(rooms.get(i).getRoomid(),enterdate,leavedate))))
					ruledRoom.add(rooms.get(i));
			}
			return ruledRoom;
		}
		else if(faceto.equals(str)) {
			for(int i = 0;i < rooms.size();i++) {
				if(rooms.get(i).getRoomtype().equals(roomType)&&
						rooms.get(i).getFloor().equals(floor)&&
						(rooms.get(i).getStatus().equals("ø’œ–")||
								(rooms.get(i).getStatus().equals("”–‘§∂©")&&
								SearchRuledRoomModel.isFree(rooms.get(i).getRoomid(),enterdate,leavedate))))
					ruledRoom.add(rooms.get(i));
			}
			return ruledRoom;
		}
		else {
			for(int i = 0;i < rooms.size();i++) {
				if(rooms.get(i).getRoomtype().equals(roomType)&&
						rooms.get(i).getFloor().equals(floor)&&
						rooms.get(i).getFaceto().equals(faceto)&&
						(rooms.get(i).getStatus().equals("ø’œ–")||
								(rooms.get(i).getStatus().equals("”–‘§∂©")&&
								SearchRuledRoomModel.isFree(rooms.get(i).getRoomid(),enterdate,leavedate))))
					ruledRoom.add(rooms.get(i));
			}
		}
		return ruledRoom;
	}
	public static boolean isFree(String roomid,Date enterdate,Date leavedate) {
		Vector<RoomOrder> roomOrders = new Vector<RoomOrder>();
		roomOrders = RoomOrderModel.SearchAllOrder();
		for(int i = 0 ; i < roomOrders.size();i++){
			if(roomOrders.get(i).getRoomid().equals(roomid)) {
				if(roomOrders.get(i).getEnterdate().getTime()<=enterdate.getTime()&&roomOrders.get(i).getLeavedate().getTime()>enterdate.getTime())
					return false;
				else if(roomOrders.get(i).getEnterdate().getTime()<leavedate.getTime()&&roomOrders.get(i).getLeavedate().getTime()>=leavedate.getTime())
					return false;
				else if(roomOrders.get(i).getEnterdate().getTime()>=enterdate.getTime()&&roomOrders.get(i).getLeavedate().getTime()<=leavedate.getTime())
					return false;
			}
		}
		return true;
	}
}
