package com.jsu.loginexample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.jsu.loginexample.service.UserService;

public class DestroyUserServlet extends HttpServlet{

	public UserService userService = new UserService();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("����ϵͳ��ע��.....");
		String username = String.valueOf(req.getSession().getAttribute("username"));
		boolean flag = userService.destroyUser(username);
		if(flag) {
			req.getSession().invalidate();
			req.setAttribute("msg", "ע���ɹ���");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "ע��ʧ�ܣ�");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

}
