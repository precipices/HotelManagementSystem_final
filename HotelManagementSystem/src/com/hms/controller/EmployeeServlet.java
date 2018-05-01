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

@WebServlet(urlPatterns="/EmployeeServlet") 
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmployeeServlet(){super();}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Vector<Staff> data= StaffDao.getStaffs();
    	request.setAttribute("data",data);
    	request.getRequestDispatcher("EmployeeSet.jsp").forward(request,response);
	}

}
