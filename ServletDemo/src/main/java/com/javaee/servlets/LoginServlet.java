package com.javaee.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaee.entity.User;

public class LoginServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
//		1.�õ�ǰ�˷�����������
		User user = new User();
//		2.��װ��User��������
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		HttpSession session = request.getSession();
//		Cookie cookie = new Cookie("JSESSIONID",session.getId());
//        cookie.setPath(request.getContextPath()+"/");
//        cookie.setMaxAge(30*60);
//        response.addCookie(cookie);
        
		System.out.println(user.toString());
//		3.�ж��û����������Ƿ���ȷ 4.����ҳ����ת
//		if("zhangsan".equals(user.getUsername()) &&
//				"123456".equals(user.getPassword())) {
////			��������ת��
//			request.setAttribute("username", user.getUsername());
////			session.setAttribute("username", user.getUsername());
//			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//			dispatcher.forward(request, response);
//		}else {
//			request.setAttribute("msg", "�û��������������");
////			session.setAttribute("msg", "�û��������������");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//			dispatcher.forward(request, response);
//		}
		
		if("zhangsan".equals(user.getUsername()) &&
				"123456".equals(user.getPassword())) {
//			��������ת��
//			request.setAttribute("username", user.getUsername());
			session.setAttribute("username", user.getUsername());
			response.sendRedirect("index.jsp");
		}else {
//			request.setAttribute("msg", "�û��������������");
			session.setAttribute("msg", "�û��������������");
			response.sendRedirect("login.jsp");
		}
		
	}
}
