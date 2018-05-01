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
		//有过滤器RegisterFilter验证信息，这里不需要判断信息
		String idcard=request.getParameter("idcard");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Customer c=new Customer();
		c.setIdcard(idcard);
		c.setName(username);
		c.setPassword(password);
		CustomerModel.add(c);
		request.setAttribute("message", "用户"+username+"注册成功!欢迎登陆!");
		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

}
