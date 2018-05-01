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
		//得到会话
		HttpSession session = request.getSession();
		//得到当前登陆的客户
		User u=(User) session.getAttribute("user");
		Customer c=u.getCustomer();
		//得到客户身份证号
		String idcard=c.getIdcard();
		//得到客户的所有正在处理的订单
		Vector<AdvanceRoomOrder> advanceOrders=CustomerAdvanceOrderModel.getCustomerAdvanceOrders(idcard);
		//得到客户的所有已完成订单
		Vector<RoomOrder> orders=CustomerOrderModel.getRoomOrders(idcard);
		//提示信息
		//String message="查询成功!共在店消费"+orders.size()+"次!";
//		if(orders.size()==0) {
//			message="成功的订单数为0!";
//		}
		//request.setAttribute("message", message);
		//将订单放入会话中
		session.setAttribute("customerAdvanceOrders", advanceOrders);
		session.setAttribute("customerOrders", orders);
		//跳回查询页面
		
		request.getRequestDispatcher("customerAllOrder.jsp").forward(request, response);
	}

}
