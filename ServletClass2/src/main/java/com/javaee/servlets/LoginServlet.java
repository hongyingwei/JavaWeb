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
//		1.获取请求发送的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		2.封装到User对象里
		User user = new User(username, password);
		
//		3.进行数据校验
//		4.进行页面跳转
//		if("zhangsan".equals(user.getUsername()) && 
//				"123456".equals(user.getPassword())) {
//			request.setAttribute("username", user.getUsername());
//			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//			dispatcher.forward(request, response);
//		}else {
//			request.setAttribute("msg", "用户名或者密码错误！");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//			dispatcher.forward(request, response);
//		}
		HttpSession session = request.getSession();
//		
//		Cookie cookie = new Cookie("JSESSIONID",session.getId());
//      cookie.setPath(request.getContextPath()+"/");
//      cookie.setMaxAge(30*60);
//      response.addCookie(cookie);
		
		if("zhangsan".equals(user.getUsername()) && 
				"123456".equals(user.getPassword())) {
//			request.setAttribute("username", user.getUsername());
			session.setAttribute("username", user.getUsername());
			response.sendRedirect("index.jsp");
		}else {
//			request.setAttribute("msg", "用户名或者密码错误！");
			session.setAttribute("msg", "用户名或者密码错误！");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			response.sendRedirect("login.jsp");
		}
	}
}
