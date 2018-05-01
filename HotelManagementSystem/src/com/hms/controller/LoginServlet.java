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
		//�õ��Ự
		HttpSession session=request.getSession();
		if(verification==User.NOTFOUND) {//�û�������
			message="�û�������!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}else if(verification==User.PASSWORDERR) {//�������
			message="�������!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}else if(verification==User.MANAGER) {//����
			//��½�ɹ�,����ǰ��¼�û��ŵ�session��
			session.setAttribute("user", u);
			session.setAttribute("roomtypes", CustomerRoomTypeModel.getRoomTypes());
			request.getRequestDispatcher("managermenu.jsp").forward(request, response);
		}else if(verification==User.RECEPTIONIST) {//ǰ̨�Ӵ�ԱReceptionist
			session.setAttribute("user", u);
			session.setAttribute("roomtypes", CustomerRoomTypeModel.getRoomTypes());
			request.getRequestDispatcher("receptionistmenu.html").forward(request, response);
		}else if(verification==User.CUSTOMER) {//�ͻ�customer
			session.setAttribute("user", u);
			session.setAttribute("roomtypes", CustomerRoomTypeModel.getRoomTypes());
			request.getRequestDispatcher("customerMain.jsp").forward(request, response);
		}else {//δ֪����
			message="δ֪����";
			request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
	}

}
