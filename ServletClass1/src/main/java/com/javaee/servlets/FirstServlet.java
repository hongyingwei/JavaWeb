package com.javaee.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("servlet�N����");
	}
	/**
	 * �ٿ��Ի�ȡServlet����ı���servlet-name��ֵ

       �ڻ�ȡ��ʼ������init-param

       �ۻ�ȡServletContext����
	 */
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

        System.out.println("2 ��ʼ������");
 
//      ���Ի�ȡServlet����ı���servlet-name��ֵ
        System.out.println("������"+config.getServletName());
 
//      ��ȡ��ʼ������init-para
        System.out.println("init-param��ʼ������username��ֵ�ǣ�"+config.getInitParameter("username"));
        System.out.println("init-param��ʼ������url��ֵ�ǣ�"+config.getInitParameter("url"));
		// TODO Auto-generated method stub
		System.out.println("servlet���г�ʼ����");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("����ִ��servlet.......");
	}

}
