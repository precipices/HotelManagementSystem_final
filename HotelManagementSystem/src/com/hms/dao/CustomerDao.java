package com.hms.dao;

import java.util.Vector;

import com.hms.entity.Customer;

public class CustomerDao {
	public static Vector<Customer> getCustomers() {
		Vector<Customer> customers=new Vector<Customer>();
		Vector<Vector<String>> rowData;
		rowData=new SqlHelper().query("select * from Customer");
		for(int i=0;i<rowData.size();i++) {
			customers.add(new Customer(rowData.get(i)));
		}
		return customers;
	}
	public static void addCustomer(Customer c) {
		String paras[]= {c.getIdcard(),c.getName(),c.getPassword(),c.getSpend()+"",c.getSpendtime()+"",c.getLivelength()+""};
		new SqlHelper().update("insert into Customer values(?,?,?,?,?,?)",paras);
	}
	public static void deleteCustomerByIdcard(String idcard) {
		String paras[]= {idcard};
		new SqlHelper().update("delete from Customer where idcard = ?",paras);
	}
}
