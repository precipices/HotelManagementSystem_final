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

@WebServlet(urlPatterns="/searchServlet") 
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public searchServlet(){super();}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Vector<Room> data=RoomDao.getRooms();
		Vector<Room> selecteddata=new Vector<Room>();
		Vector<RoomType> roomtypedata=RoomTypeDao.getRoomTypes();
		String roomid=request.getParameter("roomid");
		String roomtype=request.getParameter("roomtype");
		String floor=request.getParameter("floor");
		String faceto=request.getParameter("faceto");
		String status=request.getParameter("status");
		for(int i=0;i<data.size();i++)
		{
			if((roomid.equals("无")||roomid.equals(data.get(i).getRoomid()))&&
			   (roomtype.equals("无")||roomtype.equals(data.get(i).getRoomtype()))&&
			   (floor.equals("无")||floor.equals(data.get(i).getFloor()))&&
			   (faceto.equals("无")||faceto.equals(data.get(i).getFaceto()))&&
			   (status.equals("无")||status.equals(data.get(i).getStatus())))
				selecteddata.add(data.get(i));
		}
		request.setAttribute("data",data);
    	request.setAttribute("selecteddata",selecteddata);
    	request.setAttribute("roomtypedata",roomtypedata);
    	request.getRequestDispatcher("RoomSet.jsp").forward(request,response);
	}

}
