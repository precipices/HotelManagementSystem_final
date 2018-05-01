package com.hms.model;

import java.util.Vector;

import com.hms.dao.RoomOrderDao;
import com.hms.entity.RoomOrder;

public class CustomerOrderModel {
	public static Vector<RoomOrder> roomOrders = new Vector<RoomOrder>();

	public static void getData(String idcard) {
		roomOrders = RoomOrderDao.getRoomOrdersByIdcard(idcard);
	}

	public static Vector<RoomOrder> getRoomOrders(String idcard) {
		getData(idcard);
		return roomOrders;
	}
}
