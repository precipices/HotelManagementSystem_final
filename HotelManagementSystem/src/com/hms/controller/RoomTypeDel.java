package com.hms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/RoomTypeDel") 
public class RoomTypeDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RoomTypeDel(){super();}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String roomtype=request.getParameter("roomtype");
		response.getWriter().print(RoomTypeOperation.delRoomType(roomtype));
	}

}
