package com.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charst=utf-8"); 
		response.setCharacterEncoding("utf-8");
		// ��ȡ������������Ϣ���������
		PrintWriter out = response.getWriter();
//		out.write("����Servlet���������͸���������ݣ�Hello world");
		String name = "����";
		int age = 10;
		out.write("����" + name + ",����" + age + "�꣡");
		out.close();

		// �ٻ�ȡweb.xml�����õ������Ĳ���context-param
		ServletContext context = getServletConfig().getServletContext();
		String username = context.getInitParameter("username");
		System.out.println("username:" + username);
		System.out.println("url:" + context.getInitParameter("password"));
		// �ڻ�ȡ��ǰ�Ĺ���·������ʽ��/����·��
		System.out.println("��ǰ����·����" + context.getContextPath());
		// �ۻ�ȡ���̲�����ڷ�����Ӳ���ϵľ���·��
		// / б�ܱ�������������ַΪ��http://ip:port/������/ ӳ�䵽IDEA�����webĿ¼
		System.out.println("���̲���ľ���·����" + context.getRealPath("/"));
	}

}
