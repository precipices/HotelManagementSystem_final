package com.hms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/RoomChange") 
public class RoomChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RoomChange(){super();}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String roomid=request.getParameter("roomid");
		String roomtype=request.getParameter("roomtype");
		float price=Float.parseFloat(request.getParameter("price"));
		String floor=request.getParameter("floor");
		String faceto=request.getParameter("faceto");
		String status=request.getParameter("status");
		String roominfo=request.getParameter("roominfo");
		response.getWriter().print(RoomOperation.delRoom(roomid));
		RoomOperation.addRoom(roomid, roomtype, price, floor, faceto, status, roominfo);
	}

}
