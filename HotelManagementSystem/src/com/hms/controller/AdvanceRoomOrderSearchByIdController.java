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

@WebServlet("/AdvanceOrderSearchByIdController")
public class AdvanceRoomOrderSearchByIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdvanceRoomOrderSearchByIdController() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		Vector <AdvanceRoomOrder> aro = new Vector <AdvanceRoomOrder>();
		aro = new AdvanceRoomOrderModel().findOrderByIdcard(userId);
	//	AdvanceRoomOrder aro = new AdvanceRoomOrderModel().findOrderByIdcard(userId);
		if(aro==null){
			String message = "找不到该用户！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("AdvanceOrderSearchById.jsp").forward(request, response);
		}
		else{
			request.setAttribute("userId", userId);
			request.getSession().setAttribute("AdvanceRoomOrder", aro);
			request.getRequestDispatcher("AdvanceOrder.jsp").forward(request, response);
		}
	}

}
