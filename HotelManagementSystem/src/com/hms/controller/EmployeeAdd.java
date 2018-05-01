package com.hms.controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.dao.StaffDao;
import com.hms.entity.Staff;

@WebServlet(urlPatterns="/EmployeeAdd") 
public class EmployeeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmployeeAdd(){super();}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String position=request.getParameter("position");
		String empID=request.getParameter("empID");
		String empname=request.getParameter("empname");
		String emppw=request.getParameter("emppw");
		String emppwcheck=request.getParameter("emppwcheck");
		Vector<String> staff=new Vector<String>();
		Vector<Staff> staffs=StaffDao.getStaffs();
		for(int i=0;i<staffs.size();i++)
		{
			if(staffs.get(i).getStaffid().equals(empID))
			{
				response.getWriter().print("Ա�����ظ�");
				return;
			}
		}
		if(empID.length()<5||empID.length()>18)
		{
			response.getWriter().print("Ա���ų��ȴ���10~18��");
			return;
		}
		if(empname.trim().equals(""))
		{
			response.getWriter().print("��������Ϊ��");
			return;
		}
		if(emppw.trim().equals(""))
		{
			response.getWriter().print("���벻��Ϊ��");
			return;
		}
		if(!emppw.equals(emppwcheck))
		{
			response.getWriter().print("�������벻һ��");
			return;
		}
		staff.add(empID);
		staff.add(position);
		staff.add(empname);
		staff.add(emppw);
		StaffDao.addStaff(new Staff(staff));
		response.getWriter().print("Ա���˺���ӳɹ�");
	}

}
