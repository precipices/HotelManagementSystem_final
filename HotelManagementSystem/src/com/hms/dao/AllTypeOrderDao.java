package com.hms.dao;

import java.util.Vector;

public class AllTypeOrderDao {
	public static String getNewOrderid() {
		Vector<Vector<String>> rowData=new SqlHelper().query("select top 1 * from (select orderid from RoomOrder union select orderid from AdvanceRoomOrder) temp order by orderid desc");
		String max;
		if(rowData.size()==0) {
			max="ro000000";
		}else {
			max=rowData.get(0).get(0);
		}
		int id=Integer.parseInt(max.substring(2));
		id++;
		String newId="ro"+String.format("%06d", id);
		return newId;
	}
}
