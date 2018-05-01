package com.hms.dao;

import java.util.Vector;

import com.hms.entity.Staff;

public class StaffDao {
	public static Vector<Staff> getStaffs() {
		Vector<Staff> staffs = new Vector<Staff>();
		Vector<Vector<String>> rowData;
		rowData = new SqlHelper().query("select * from staff");
		for (int i = 0; i < rowData.size(); i++) {
			staffs.add(new Staff(rowData.get(i)));
		}
		return staffs;
	}
	public static void addStaff(Staff s) {
		String paras[]= {s.getStaffid(),s.getPosition(),s.getName(),s.getPassword()};
		new SqlHelper().update("insert into Staff(staffid,position,name,password) values(?,?,?,?)",paras);
	}
	public static void deleteStaffByStaffid(String staffid) {
		String paras[]= {staffid};
		new SqlHelper().update("delete from Staff where staffid = ?",paras);
	}
}
