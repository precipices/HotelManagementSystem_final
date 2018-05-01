package com.hms.model;

import java.util.Vector;

import com.hms.dao.AdvanceRoomOrderDao;
import com.hms.entity.AdvanceRoomOrder;

public class AdvanceRoomOrderModel {
	static Vector<AdvanceRoomOrder> advanceRoomOrders;
	public Vector<AdvanceRoomOrder> findOrderByIdcard(String idcard) {
		Vector<AdvanceRoomOrder> aros = new Vector<AdvanceRoomOrder>();
		advanceRoomOrders=AdvanceRoomOrderDao.getAdvanceRoomOrders();
		if(advanceRoomOrders.size()!=0) {
			for(int i=0;i<advanceRoomOrders.size();i++) {
				if( advanceRoomOrders.get(i).getIdcard().equals(idcard) ){
					aros.add(advanceRoomOrders.get(i));
				}
			}
		}
		return aros;
	}
	public Vector<AdvanceRoomOrder> findOrderByOrderId(String OrderId) {
		Vector<AdvanceRoomOrder> aros = new Vector<AdvanceRoomOrder>();
		advanceRoomOrders=AdvanceRoomOrderDao.getAdvanceRoomOrders();
		if(advanceRoomOrders.size()!=0) {
			for(int i=0;i<advanceRoomOrders.size();i++) {
				if( advanceRoomOrders.get(i).getOrderid().equals(OrderId) ){
					aros.add(advanceRoomOrders.get(i));
					return aros;
				}
			}
		}
		return null;
	}
	public Vector<AdvanceRoomOrder> findAllOrder(){
		advanceRoomOrders=AdvanceRoomOrderDao.getAdvanceRoomOrders();
		if(advanceRoomOrders.size()!=0) {
			return advanceRoomOrders;
		}
		else
			return null;
	}
	public static boolean deleteOrderByIdcard(String OrderId) {
		return AdvanceRoomOrderDao.deleteAdvanceRoomOrderByOrderId(OrderId);
	}
}
