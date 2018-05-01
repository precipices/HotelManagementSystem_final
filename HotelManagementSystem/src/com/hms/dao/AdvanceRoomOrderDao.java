package com.hms.dao;

import java.util.Vector;

import com.hms.entity.AdvanceRoomOrder;

public class AdvanceRoomOrderDao {
	public static Vector<AdvanceRoomOrder> getAdvanceRoomOrders() {
		Vector<AdvanceRoomOrder> advanceRoomOrders = new Vector<AdvanceRoomOrder>();
		Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		SqlHelper sq = new SqlHelper();
		rowData = sq.query("Select * from AdvanceRoomOrder ");
		for (int i = 0; i < rowData.size(); i++) {
			advanceRoomOrders.add(new AdvanceRoomOrder(rowData.get(i)));
		}
		return advanceRoomOrders;
	}

	public static Vector<AdvanceRoomOrder> getAdvanceRoomOrdersByIdcard(String idcard) {
		Vector<AdvanceRoomOrder> advanceRoomOrders = new Vector<AdvanceRoomOrder>();
		Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		SqlHelper sq = new SqlHelper();
		String[] paras = { idcard };
		rowData = sq.query("Select * from AdvanceRoomOrder where idcard=?", paras);
		for (int i = 0; i < rowData.size(); i++) {
			advanceRoomOrders.add(new AdvanceRoomOrder(rowData.get(i)));
		}
		return advanceRoomOrders;
	}

	public static void addAdvanceRoomOrder(AdvanceRoomOrder a) {
		String paras[] = { a.getOrderid(), a.getIdcard(), a.getName(), a.getRoomtype(), a.getFloor(), a.getFaceto(),
				a.getEnterdate() + "", a.getLeavedate() + "" };
		new SqlHelper().update("insert into AdvanceRoomOrder values(?,?,?,?,?,?,?,?)", paras);
	}

	public static boolean deleteAdvanceRoomOrderByIdcard(String idcard) {
		String paras[] = { idcard };
		return new SqlHelper().update("delete AdvanceRoomOrder where idcard = ?", paras);
	}

	public static boolean deleteAdvanceRoomOrderByOrderId(String OrderId) {
		SqlHelper sq = new SqlHelper();
		String paras[] = new String[] { OrderId };
		return sq.update("delete AdvanceRoomOrder where orderid = ?", paras);
	}
}
