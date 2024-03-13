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
//		1.得到前端发过来的数据
		User user = new User();
//		2.封装到User对象里面
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		HttpSession session = request.getSession();
//		Cookie cookie = new Cookie("JSESSIONID",session.getId());
//        cookie.setPath(request.getContextPath()+"/");
//        cookie.setMaxAge(30*60);
//        response.addCookie(cookie);
        
		System.out.println(user.toString());
//		3.判断用户名和密码是否正确 4.进行页面跳转
//		if("zhangsan".equals(user.getUsername()) &&
//				"123456".equals(user.getPassword())) {
////			进行请求转发
//			request.setAttribute("username", user.getUsername());
////			session.setAttribute("username", user.getUsername());
//			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//			dispatcher.forward(request, response);
//		}else {
//			request.setAttribute("msg", "用户名或者密码错误！");
////			session.setAttribute("msg", "用户名或者密码错误！");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//			dispatcher.forward(request, response);
//		}
		
		if("zhangsan".equals(user.getUsername()) &&
				"123456".equals(user.getPassword())) {
//			进行请求转发
//			request.setAttribute("username", user.getUsername());
			session.setAttribute("username", user.getUsername());
			response.sendRedirect("index.jsp");
		}else {
//			request.setAttribute("msg", "用户名或者密码错误！");
			session.setAttribute("msg", "用户名或者密码错误！");
			response.sendRedirect("login.jsp");
		}
		
	}
}
