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

public class LoginServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("进入登录系统......");
//		1.获取前端发给来的请求数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		2.封装User对象
		User user = new User(username, password);
		HttpSession session = request.getSession();
		
//		Cookie cookie = new Cookie("JSESSIONID",session.getId());
//		cookie.setPath(request.getContextPath()+"/");
//		cookie.setMaxAge(30*60);
//		response.addCookie(cookie);
		
//		3.进行数据校验
//		4.进行页面跳转
		if("zhangsan".equals(user.getUsername()) &&
				"123456".equals(user.getPassword())) {
//			request.setAttribute("username", user.getUsername());
			session.setAttribute("username", user.getUsername());
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
//			response.sendRedirect("index.jsp");
		}else {
//			request.setAttribute("msg", "用户名或密码错误，请重新输入！");
			session.setAttribute("msg", "用户名或密码错误，请重新输入！");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
//			response.sendRedirect("login.jsp");
		}
		
	}
}
