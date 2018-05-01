package com.hms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.hms.model.CustomerModel;

@WebFilter(filterName="/RegisterFilter",
		urlPatterns= {"/RegisterServlet"}
		)
public class RegisterFilter implements Filter {
    public RegisterFilter() {
    }
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String idcard=request.getParameter("idcard");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String surepassword=request.getParameter("surepassword");
		if(idcard.trim().equals("")) {
			request.setAttribute("message", "身份证号为空!");
		}else if(username.trim().equals("")) {
			request.setAttribute("message", "用户名为空!");
		}else if(password.trim().equals("")) {
			request.setAttribute("message", "密码为空!");
		}else if(!password.equals(surepassword)) {
			request.setAttribute("message", "两次输入的密码不相同!");
		}else if(CustomerModel.checkIdcard(idcard)){
			request.setAttribute("message", "该身份证号已注册!");
		}else {
			//格式正确，允许跳转
			chain.doFilter(request, response);
			return;
		}
		//格式不正确，跳回注册页面
		request.getRequestDispatcher("register.jsp").forward(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
