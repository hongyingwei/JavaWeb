package com.jsu.loginexample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.jsu.loginexample.model.User;
import com.jsu.loginexample.service.UserService;

public class RegisterServlet extends HttpServlet{
	
	public UserService userService = new UserService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("进入系统的注册功能.....");
//		1.先获取前端的数据
		String name = req.getParameter("username");
		String nickName = req.getParameter("nickName");
		String password = req.getParameter("password");
		if(StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
			req.setAttribute("msg", "参数填写有误！");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
			return;
		}
		//2.封装到User类
		User user = new User();
		user.setNickName(nickName);
		user.setPassword(password);
		user.setUsername(name);
		//3.查询用户信息是否已经存在
		try {
			boolean flag = userService.queryUser(user);
			if(!flag) {
				req.setAttribute("msg", "用户信息已经存在！");
				req.getRequestDispatcher("register.jsp").forward(req, resp);
			}else {
				boolean result = userService.registerUser(user);
				if(result) {
					resp.sendRedirect("login.jsp");
				}else {
					req.setAttribute("msg", "注册失败！");
                    req.getRequestDispatcher("register.jsp").forward(req, resp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
