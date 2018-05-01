package com.hms.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.model.SearchRuledRoomModel;

@WebServlet("/ShowAppointedRoomController")
public class ShowAppointedRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowAppointedRoomController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String RoomType = request.getParameter("roomType");
		String Floor = request.getParameter("floor");
		String FaceTo = request.getParameter("faceto");
		if(!request.getParameter("enterdate").equals("")&&!request.getParameter("leavedate").equals("")) {
			Date enterdate = Date.valueOf(request.getParameter("enterdate"));
			Date leavedate = Date.valueOf(request.getParameter("leavedate"));
			request.getSession().setAttribute("enterdate", enterdate);
			request.getSession().setAttribute("leavedate", leavedate);
			request.setAttribute("RuledRoom", SearchRuledRoomModel.searchRuledRoom(RoomType, Floor, FaceTo,enterdate,leavedate));
		}

		
		request.getSession().setAttribute("RoomType",RoomType);
		request.getSession().setAttribute("Floor",Floor);
		request.getSession().setAttribute("FaceTo",FaceTo);
		request.getRequestDispatcher("RoomAllocation.jsp").forward(request, response);
	//	if(SearchRuledRoomModel.searchRuledRoom(RoomType, Floor, FaceTo).size()==0)
	//	response.sendRedirect("RoomAllocation.jsp");
	}
}
