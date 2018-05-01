package com.hms.controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.entity.Room;
import com.hms.model.CustomerViewRoomModel;

@WebServlet("/CustomerViewServlet")
public class CustomerViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CustomerViewServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Vector<Room> rooms=CustomerViewRoomModel.getRooms();
		HttpSession session=request.getSession();
		session.setAttribute("rooms", rooms);
		//System.out.println(rooms.size());
		session.setAttribute("show", 0);
		request.getRequestDispatcher("customerView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		int show=(int) request.getSession().getAttribute("show");
		if(request.getParameter("lastPage")!=null) {
			if(show>0)
				show--;
		}else if(request.getParameter("nextPage")!=null) {
			if(show<9)
				show++;
		}
		request.getSession().setAttribute("show", show);
		request.getRequestDispatcher("customerView.jsp").forward(request, response);
	}

}
