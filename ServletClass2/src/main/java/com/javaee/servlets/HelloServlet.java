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
		// 获取输出流以输出信息到浏览器中
		PrintWriter out = response.getWriter();
//		out.write("我是Servlet服务器发送给浏览器数据：Hello world");
		String name = "张三";
		int age = 10;
		out.write("我是" + name + ",今年" + age + "岁！");
		out.close();

		// ①获取web.xml中配置的上下文参数context-param
		ServletContext context = getServletConfig().getServletContext();
		String username = context.getInitParameter("username");
		System.out.println("username:" + username);
		System.out.println("url:" + context.getInitParameter("password"));
		// ②获取当前的工程路径，格式：/工程路径
		System.out.println("当前工程路径：" + context.getContextPath());
		// ③获取工程部署后在服务器硬盘上的绝对路径
		// / 斜杠被服务器解析地址为：http://ip:port/工程名/ 映射到IDEA代码的web目录
		System.out.println("工程部署的绝对路径：" + context.getRealPath("/"));
	}

}
