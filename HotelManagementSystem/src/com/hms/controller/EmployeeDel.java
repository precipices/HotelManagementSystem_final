package com.hms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.dao.StaffDao;

@WebServlet(urlPatterns="/EmployeeDel") 
public class EmployeeDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmployeeDel(){super();}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String empID=request.getParameter("empID");
		StaffDao.deleteStaffByStaffid(empID);
		response.getWriter().print("员工账号删除成功");
	}

}
