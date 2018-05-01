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
	//�ж����֤���Ƿ��Ѵ���
	public static boolean checkIdcard(String idcard) {
		getData();
		for(int i=0;i<customers.size();i++) {
			if( customers.get(i).getIdcard().equals(idcard)){
				//���֤�Ŵ���
				return true;
			}
		}
		//���֤�Ų�����
		return false;
	}
	//�ж��û����Ƿ��Ѵ���
	public static boolean checkUsername(String username) {
		getData();
		for(int i=0;i<customers.size();i++) {
			if( customers.get(i).getName().equals(username)){
				//�û�������
				return true;
			}
		}
		//�û���������
		return false;
	}
	public static boolean checkPassword(String username,String password) {
		getData();
		for(int i=0;i<customers.size();i++) {
			if( customers.get(i).getName().equals(username)){
				if(customers.get(i).getPassword().equals(password)) {
					//�û�����Ӧ��������ȷ
					return true;
				}
			}
		}
		//���벻��ȷ���û���������
		return false;
	}
}
