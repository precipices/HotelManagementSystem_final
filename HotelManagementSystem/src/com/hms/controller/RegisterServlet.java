package com.hms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.entity.Customer;
import com.hms.model.CustomerModel;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�й�����RegisterFilter��֤��Ϣ�����ﲻ��Ҫ�ж���Ϣ
		String idcard=request.getParameter("idcard");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Customer c=new Customer();
		c.setIdcard(idcard);
		c.setName(username);
		c.setPassword(password);
		CustomerModel.add(c);
		request.setAttribute("message", "�û�"+username+"ע��ɹ�!��ӭ��½!");
		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

}
