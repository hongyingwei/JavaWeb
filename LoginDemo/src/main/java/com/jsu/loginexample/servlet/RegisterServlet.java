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
		System.out.println("����ϵͳ��ע�Ṧ��.....");
//		1.�Ȼ�ȡǰ�˵�����
		String name = req.getParameter("username");
		String nickName = req.getParameter("nickName");
		String password = req.getParameter("password");
		if(StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
			req.setAttribute("msg", "������д����");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
			return;
		}
		//2.��װ��User��
		User user = new User();
		user.setNickName(nickName);
		user.setPassword(password);
		user.setUsername(name);
		//3.��ѯ�û���Ϣ�Ƿ��Ѿ�����
		try {
			boolean flag = userService.queryUser(user);
			if(!flag) {
				req.setAttribute("msg", "�û���Ϣ�Ѿ����ڣ�");
				req.getRequestDispatcher("register.jsp").forward(req, resp);
			}else {
				boolean result = userService.registerUser(user);
				if(result) {
					resp.sendRedirect("login.jsp");
				}else {
					req.setAttribute("msg", "ע��ʧ�ܣ�");
                    req.getRequestDispatcher("register.jsp").forward(req, resp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
