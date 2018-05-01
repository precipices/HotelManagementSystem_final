package com.hms.controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.entity.AdvanceRoomOrder;
import com.hms.entity.Customer;
import com.hms.entity.RoomOrder;
import com.hms.entity.User;
import com.hms.model.CustomerAdvanceOrderModel;
import com.hms.model.CustomerOrderModel;
@WebServlet("/OrderSelectServlet")
public class OrderSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public OrderSelectServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�õ��Ự
		HttpSession session = request.getSession();
		//�õ���ǰ��½�Ŀͻ�
		User u=(User) session.getAttribute("user");
		Customer c=u.getCustomer();
		//�õ��ͻ����֤��
		String idcard=c.getIdcard();
		//�õ��ͻ����������ڴ���Ķ���
		Vector<AdvanceRoomOrder> advanceOrders=CustomerAdvanceOrderModel.getCustomerAdvanceOrders(idcard);
		//�õ��ͻ�����������ɶ���
		Vector<RoomOrder> orders=CustomerOrderModel.getRoomOrders(idcard);
		//��ʾ��Ϣ
		//String message="��ѯ�ɹ�!���ڵ�����"+orders.size()+"��!";
//		if(orders.size()==0) {
//			message="�ɹ��Ķ�����Ϊ0!";
//		}
		//request.setAttribute("message", message);
		//����������Ự��
		session.setAttribute("customerAdvanceOrders", advanceOrders);
		session.setAttribute("customerOrders", orders);
		//���ز�ѯҳ��
		
		request.getRequestDispatcher("customerAllOrder.jsp").forward(request, response);
	}

}
