package com.hms.model;

import java.util.Vector;

import com.hms.dao.AdvanceRoomOrderDao;
import com.hms.entity.AdvanceRoomOrder;

/*
 * 该类为单个客户正在处理尚未结账的订单
 */
public class CustomerAdvanceOrderModel {
	public static Vector<AdvanceRoomOrder> customerAdvanceOrders = new Vector<AdvanceRoomOrder>();

	public static void getData(String idcard) {
		customerAdvanceOrders = AdvanceRoomOrderDao.getAdvanceRoomOrdersByIdcard(idcard);
	}

	public static Vector<AdvanceRoomOrder> getCustomerAdvanceOrders(String idcard) {
		getData(idcard);
		return customerAdvanceOrders;
	}

	public static void add(AdvanceRoomOrder order) {
		AdvanceRoomOrderDao.addAdvanceRoomOrder(order);
		customerAdvanceOrders.add(order);
	}
}
