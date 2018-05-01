package com.hms.controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.dao.RoomDao;
import com.hms.dao.RoomTypeDao;
import com.hms.entity.Room;
import com.hms.entity.RoomType;

@WebServlet(urlPatterns="/RoomSetServlet") 
public class RoomSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RoomSetServlet(){super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Vector<Room> data=RoomDao.getRooms();
		Vector<Room> selecteddata=RoomDao.getRooms();
		Vector<RoomType> roomtypedata=RoomTypeDao.getRoomTypes();
    	request.setAttribute("data",data);
    	request.setAttribute("selecteddata",selecteddata);
    	request.setAttribute("roomtypedata",roomtypedata);
    	request.getRequestDispatcher("RoomSet.jsp").forward(request,response);
	}

}
