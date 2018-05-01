package com.hms.model;

import java.util.Vector;

import com.hms.dao.StaffDao;
import com.hms.entity.Staff;

public class StaffModel {
	// private StaffModel() {}//不允许创建实体
	public static Vector<Staff> staffs = new Vector<Staff>();
	public static boolean equalsDb=false;
	public static void getData() {
		if(!equalsDb) {
			staffs=StaffDao.getStaffs();
			equalsDb=true;
		}
	}
	public static Vector<Staff> getStaffs() {
		getData();
		return staffs;
	}

}
