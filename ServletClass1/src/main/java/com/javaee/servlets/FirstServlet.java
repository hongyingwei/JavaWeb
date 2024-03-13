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
		System.out.println("servlet銷毀了");
	}
	/**
	 * ①可以获取Servlet程序的别名servlet-name的值

       ②获取初始化参数init-param

       ③获取ServletContext对象·
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

        System.out.println("2 初始化方法");
 
//      可以获取Servlet程序的别名servlet-name的值
        System.out.println("别名："+config.getServletName());
 
//      获取初始化参数init-para
        System.out.println("init-param初始化参数username的值是："+config.getInitParameter("username"));
        System.out.println("init-param初始化参数url的值是："+config.getInitParameter("url"));
		// TODO Auto-generated method stub
		System.out.println("servlet进行初始化了");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("正在执行servlet.......");
	}

}
