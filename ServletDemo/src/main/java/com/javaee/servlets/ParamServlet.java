package com.javaee.servlets;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		System.out.println(uname);
		//�����ݵ�reqeust����
		req.setAttribute("msg", "��ã����ǰ���Reuqest�����ϵĶ���");
		//ת����el.jsp
		req.getRequestDispatcher("el.jsp").forward(req, resp);
	}
}
