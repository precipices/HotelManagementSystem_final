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
			request.setAttribute("message", "���֤��Ϊ��!");
		}else if(username.trim().equals("")) {
			request.setAttribute("message", "�û���Ϊ��!");
		}else if(password.trim().equals("")) {
			request.setAttribute("message", "����Ϊ��!");
		}else if(!password.equals(surepassword)) {
			request.setAttribute("message", "������������벻��ͬ!");
		}else if(CustomerModel.checkIdcard(idcard)){
			request.setAttribute("message", "�����֤����ע��!");
		}else {
			//��ʽ��ȷ��������ת
			chain.doFilter(request, response);
			return;
		}
		//��ʽ����ȷ������ע��ҳ��
		request.getRequestDispatcher("register.jsp").forward(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
