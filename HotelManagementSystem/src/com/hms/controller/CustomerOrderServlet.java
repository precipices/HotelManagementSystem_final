package com.hms.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.dao.AllTypeOrderDao;
import com.hms.entity.AdvanceRoomOrder;
import com.hms.entity.User;
import com.hms.model.CustomerAdvanceOrderModel;

@WebServlet("/CustomerOrderServlet")
public class CustomerOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�õ����û�����
		User u=(User) request.getSession().getAttribute("user");
		String orderid=AllTypeOrderDao.getNewOrderid();
		String name=u.getCustomer().getName();
		String idcard=u.getCustomer().getIdcard();
		//�õ�������
		String roomtype=request.getParameter("roomtype");
		String floor=request.getParameter("floor");
		String faceto=request.getParameter("faceto");
		String enterStr=request.getParameter("enterdate");
		String leaveStr=request.getParameter("leavedate");
		if(leaveStr.equals("")||leaveStr.equals("")) {
			request.setAttribute("message", "ʱ�䲻��Ϊ��!");
			request.getRequestDispatcher("customerOrder.jsp").forward(request, response);
			return;
		}
		Date enterdate=Date.valueOf(enterStr);
		Date leavedate=Date.valueOf(leaveStr);
		//���ʱ��<=��ס����������ԭ��ҳ��customerMenu.jsp
		if(leavedate.compareTo(enterdate)<=0) {
			request.setAttribute("message", "ʱ�䲻��ȷ!");
			request.getRequestDispatcher("customerOrder.jsp").forward(request, response);
			return;
		}
		//�½���������
		AdvanceRoomOrder order=new AdvanceRoomOrder();
		order.setOrderid(orderid);
		order.setIdcard(idcard);
		order.setName(name);
		order.setRoomtype(roomtype);
		order.setFloor(floor);
		order.setFaceto(faceto);
		order.setEnterdate(enterdate);
		order.setLeavedate(leavedate);
		//�������������ݿ�
		CustomerAdvanceOrderModel.add(order);
		//��ת
		request.setAttribute("message", "�ύ�ɹ�,�ȴ�������!");
		//request.setAttribute("newOrder", order);
		request.getRequestDispatcher("customerOrder.jsp").forward(request, response);
	}

}
