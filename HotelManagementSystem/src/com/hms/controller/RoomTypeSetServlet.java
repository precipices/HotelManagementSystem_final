package com.hms.controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.dao.RoomTypeDao;
import com.hms.entity.RoomType;

@WebServlet(urlPatterns="/RoomTypeSetServlet") 
public class RoomTypeSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public RoomTypeSetServlet(){super();}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	Vector<RoomType> data= RoomTypeDao.getRoomTypes();
    	request.setAttribute("data",data);
    	request.getRequestDispatcher("RoomTypeSet.jsp").forward(request,response);
	}
}
