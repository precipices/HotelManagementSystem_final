package com.hms.controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.entity.AdvanceRoomOrder;
import com.hms.model.AdvanceRoomOrderModel;

@WebServlet("/RoomAllocationController")
public class RoomAllocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RoomAllocationController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String orderId = (String) request.getParameter("x");
		Vector<AdvanceRoomOrder> aro = new AdvanceRoomOrderModel().findOrderByOrderId(orderId);
		//AdvanceRoomOrderModel arom = new AdvanceRoomOrderModel();
		//aro = arom.findOrderByOrderId(orderId);
		request.getSession().setAttribute("aro", aro);
		//request.getRequestDispatcher("RoomAllocation.jsp").forward(request, response);
		response.sendRedirect("RoomAllocation.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
