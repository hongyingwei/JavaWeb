package com.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��һ��servlet
 * @author Administrator
 *
 */
public class HelloServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		response.setContentType("text/html;charst=utf-8");
		response.setCharacterEncoding("utf-8");
		//��ȡ������������Ϣ���������
		PrintWriter out = response.getWriter();
//		out.write("����Servlet���������͸���������ݣ�Hello world");
		String name = "����";
		int age = 10;
		out.write("����"+name+",����"+age+"�꣡");
		out.close();
	}
}
