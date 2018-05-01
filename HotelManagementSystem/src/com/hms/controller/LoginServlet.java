package com.hms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.entity.User;
import com.hms.model.CustomerRoomTypeModel;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u=new User();
		u.setUsername(username);
		u.setPassword(password);
		String message;
		int verification=u.Verification();
		//得到会话
		HttpSession session=request.getSession();
		if(verification==User.NOTFOUND) {//用户不存在
			message="用户不存在!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}else if(verification==User.PASSWORDERR) {//密码错误
			message="密码错误!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}else if(verification==User.MANAGER) {//经理
			//登陆成功,将当前登录用户放到session中
			session.setAttribute("user", u);
			session.setAttribute("roomtypes", CustomerRoomTypeModel.getRoomTypes());
			request.getRequestDispatcher("managermenu.jsp").forward(request, response);
		}else if(verification==User.RECEPTIONIST) {//前台接待员Receptionist
			session.setAttribute("user", u);
			session.setAttribute("roomtypes", CustomerRoomTypeModel.getRoomTypes());
			request.getRequestDispatcher("receptionistmenu.html").forward(request, response);
		}else if(verification==User.CUSTOMER) {//客户customer
			session.setAttribute("user", u);
			session.setAttribute("roomtypes", CustomerRoomTypeModel.getRoomTypes());
			request.getRequestDispatcher("customerMain.jsp").forward(request, response);
		}else {//未知错误
			message="未知错误";
			request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
	}

}
