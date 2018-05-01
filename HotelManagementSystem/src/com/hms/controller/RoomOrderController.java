package com.hms.controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.entity.RoomOrder;
import com.hms.model.RoomOrderModel;

@WebServlet("/RoomOrderController")
public class RoomOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RoomOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Vector<RoomOrder> rm = RoomOrderModel.SearchAllOrder();
		if(rm.size()!= 0) {
			request.getSession().setAttribute("RoomOrder", RoomOrderModel.SearchAllOrder());
			request.getRequestDispatcher("RoomOrder.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("NoRoomOrder.jsp").forward(request, response);
		}
	}

}
