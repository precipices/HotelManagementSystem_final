package com.hms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.model.RoomStatusModel;

/**
 * Servlet implementation class ShowRoomStatusImageController
 */
@WebServlet("/ShowRoomStatusImageController")
public class ShowRoomStatusImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowRoomStatusImageController() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String roomType = request.getParameter("roomType");
		String floor = request.getParameter("floor");
		String faceto = request.getParameter("faceto");
		int[] stat = RoomStatusModel.RoomStatusStatisticsByRoomType(roomType, floor, faceto);
		String [] str = new String[4];
		for(int i = 0 ; i < 4 ; i++) {
			str[i] = String.valueOf(stat[i]);
		}
		request.setAttribute("s",str);
		if(!roomType.equals("ÇëÑ¡Ôñ"))
			request.setAttribute("roomType", roomType);
		else
			request.setAttribute("roomType", "");
		if(!floor.equals("ÇëÑ¡Ôñ"))
			request.setAttribute("floor", floor);
		else
			request.setAttribute("floor", "");
		if(!faceto.equals("ÇëÑ¡Ôñ"))
			request.setAttribute("faceto", faceto);
		else
			request.setAttribute("faceto", "");
		request.getRequestDispatcher("ShowStatistics.jsp").forward(request, response);
	}

}
