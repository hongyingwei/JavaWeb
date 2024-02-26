package com.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 第一个servlet
 * @author Administrator
 *
 */
public class HelloServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		response.setContentType("text/html;charst=utf-8");
		response.setCharacterEncoding("utf-8");
		//获取输出流以输出信息到浏览器中
		PrintWriter out = response.getWriter();
//		out.write("我是Servlet服务器发送给浏览器数据：Hello world");
		String name = "张三";
		int age = 10;
		out.write("我是"+name+",今年"+age+"岁！");
		out.close();
	}
}
