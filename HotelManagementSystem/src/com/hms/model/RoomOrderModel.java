package com.hms.model;

import java.util.Vector;

import com.hms.dao.RoomOrderDao;
import com.hms.entity.RoomOrder;

public class RoomOrderModel {
	public static Vector<RoomOrder> roomOrder;
	public RoomOrderModel() {
	}
	public static Vector<RoomOrder> SearchAllOrder(){
		roomOrder = RoomOrderDao.getRoomOrders();
		return roomOrder;
	}
	public static double CheckOrderChargeByOrderId(String OrderId) {
		for(int i = 0 ; i < roomOrder.size();i++){
			if(roomOrder.get(i).getOrderid().equals(OrderId))
				return roomOrder.get(i).getCharge();
		}
		return 0;
	}
	public static boolean deleteRoomOrderByOrderId(String OrderId) {
		return RoomOrderDao.deleteRoomOrderByOrderId(OrderId);
	}
	public static boolean SearchRuledOrderByOrderId(String OrderId) {
		for(int i = 0 ; i < roomOrder.size();i++) {
			if(roomOrder.get(i).getOrderid().equals(OrderId))
				return true;
		}
		return false;
	}
}
