package com.hms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class SqlHelper {
	//定义数据库需要的东西
	String username="sa";
	String password="sa";
	String database="jdbc:sqlserver://127.0.0.1:1433;databaseName=hms";
	Connection ct;
	PreparedStatement ps;
	ResultSet rs;
	public SqlHelper() {}
	public Vector<Vector<String>> query(String sql) {
		String[] paras=null;
		return query(sql,paras);
	}
	public void close() {
		try {
			if(rs!=null) {rs.close();}
			if(ps!=null) {ps.close();}
			if(ct!=null) {ct.close();}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	public Vector<Vector<String>> query(String sql,String[] paras) {
		Vector<Vector<String>> rowData=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection(database,username,password);
			if(paras==null)
				ps=ct.prepareStatement(sql);
			else {
				ps=ct.prepareStatement(sql);
				for(int i=0;i<paras.length;i++) {
					ps.setString(i+1, paras[i]);
				}
			}
			rs=ps.executeQuery();
			rowData=new Vector<Vector<String>>();
			while(rs.next()) {
				Vector<String> hang=new Vector<String>();
				for(int i=1;i<=rs.getMetaData().getColumnCount();i++) {
					hang.add(rs.getString(i));
				}
				rowData.add(hang);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(ps!=null) {ps.close();}
				if(ct!=null) {ct.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rowData;
	}
	public boolean update(String sql,String[] paras) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection(database,username,password);
			ps=ct.prepareStatement(sql);
			for(int i=0;i<paras.length;i++) {
				ps.setString(i+1, paras[i]);
			}

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(ps!=null) {ps.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}
}
