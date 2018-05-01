package com.hms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.model.RoomModel;
import com.hms.model.RoomOrderModel;

@WebServlet("/CheckOutRoomController")
public class CheckOutRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CheckOutRoomController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String orderId = request.getParameter("x");
		String roomId = request.getParameter("y");
		if(RoomOrderModel.deleteRoomOrderByOrderId(orderId)) {
			RoomModel.updateRoomStatus(roomId, "����");
			String message = "�˷��ɹ����˷����Ϊ:"+RoomOrderModel.CheckOrderChargeByOrderId(orderId);
			request.setAttribute("mes", message);
			request.getSession().setAttribute("RoomOrder", RoomOrderModel.SearchAllOrder());
		}
		else {
			String message = "�˷�ʧ�ܣ�";
			request.setAttribute("mes", message);
		}
		
		request.getRequestDispatcher("RoomOrder.jsp").forward(request, response);

	}

}
