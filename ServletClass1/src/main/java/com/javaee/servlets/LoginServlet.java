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
		System.out.println("�����¼ϵͳ.....");
//		1.��ȡǰ�˷��������������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		2.��װUser����
		User user = new User(username, password);
		HttpSession session = request.getSession();
		
//		Cookie cookie = new Cookie("JSESSIONID",session.getId());
//      cookie.setPath(request.getContextPath()+"/");
//      cookie.setMaxAge(30*60);
//      response.addCookie(cookie);
      
//		3.�����û����������У��
//		4.����ҳ����ת
		if("zhangsan".equals(user.getUsername()) && 
			"123456".equals(user.getPassword())){
			request.setAttribute("username", username);
//			session.setAttribute("username", username);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("msg", "�û��������������");
//			session.setAttribute("msg", "�û��������������");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
//		if("zhangsan".equals(user.getUsername()) && 
//				"123456".equals(user.getPassword())){
////				request.setAttribute("username", username);
//				session.setAttribute("username", username);
//				response.sendRedirect("index.jsp");
//			}else {
////				request.setAttribute("msg", "�û��������������");
//				session.setAttribute("msg", "�û��������������");
//				response.sendRedirect("login.jsp");
//			}
	}
}
