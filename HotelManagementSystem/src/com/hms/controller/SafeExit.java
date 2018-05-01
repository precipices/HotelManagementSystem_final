package com.hms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SafeExit")
public class SafeExit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SafeExit() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		request.setAttribute("message", "你已安全退出！");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		request.setAttribute("message", "你已安全退出！");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
