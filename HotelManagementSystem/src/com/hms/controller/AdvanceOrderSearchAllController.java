package com.hms.controller;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.entity.AdvanceRoomOrder;
import com.hms.model.AdvanceRoomOrderModel;

@WebServlet("/AdvanceOrderSearchAllController")
public class AdvanceOrderSearchAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdvanceOrderSearchAllController() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Vector<AdvanceRoomOrder> aros = new AdvanceRoomOrderModel().findAllOrder();
		request.getSession().setAttribute("AdvanceRoomOrder", aros);
		request.getRequestDispatcher("AdvanceOrder.jsp").forward(request, response);
		
	}

}
