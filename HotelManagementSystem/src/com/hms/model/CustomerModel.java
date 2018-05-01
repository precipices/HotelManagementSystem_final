package com.hms.model;

import java.util.Vector;

import com.hms.dao.CustomerDao;
import com.hms.entity.Customer;

public class CustomerModel {
	public static Vector<Customer> customers=new Vector<Customer>();
	public static boolean equalsDb=false;
	public static void getData() {
		if(!equalsDb) {
			customers=CustomerDao.getCustomers();
			equalsDb=true;
		}
	}
	public static Vector<Customer> getCustomers(){
		getData();
		return customers;
	}
	public static void add(Customer customer) {
		CustomerDao.addCustomer(customer);
		customers.add(customer);
	}
	public static Customer findStaffById(String idcard) {
		getData();
		for(int i=0;i<customers.size();i++) {
			if( customers.get(i).getIdcard().equals(idcard) ){
				return customers.get(i);
			}
		}
		return null;
	}
	//判断身份证号是否已存在
	public static boolean checkIdcard(String idcard) {
		getData();
		for(int i=0;i<customers.size();i++) {
			if( customers.get(i).getIdcard().equals(idcard)){
				//身份证号存在
				return true;
			}
		}
		//身份证号不存在
		return false;
	}
	//判断用户名是否已存在
	public static boolean checkUsername(String username) {
		getData();
		for(int i=0;i<customers.size();i++) {
			if( customers.get(i).getName().equals(username)){
				//用户名存在
				return true;
			}
		}
		//用户名不存在
		return false;
	}
	public static boolean checkPassword(String username,String password) {
		getData();
		for(int i=0;i<customers.size();i++) {
			if( customers.get(i).getName().equals(username)){
				if(customers.get(i).getPassword().equals(password)) {
					//用户名对应的密码正确
					return true;
				}
			}
		}
		//密码不正确或用户名不存在
		return false;
	}
}
