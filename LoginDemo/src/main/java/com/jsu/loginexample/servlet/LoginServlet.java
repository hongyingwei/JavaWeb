package com.jsu.loginexample.servlet;

import com.jsu.loginexample.dao.UserDao;
import com.jsu.loginexample.dao.UserDaoImpl;
import com.jsu.loginexample.model.User;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String mode = req.getParameter("mode");
        System.out.println("mode: " + mode);
        if (null != mode && mode.equals("1")) {
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
          
            if (checkLoginOk(username, password)) {
                out.write("登录成功");
            }
            else {
                out.write("用户名或密码错误");
            }
            return;
        }

        // 通过request获取session对象
        HttpSession session = req.getSession();
        if (checkLoginOk(username, password)) {
                System.out.println("login ok");
                // 登录成功，将用户数据存储在session对象中
                session.setAttribute("username", username);
                // 重定向到index.jsp
                resp.sendRedirect("index.jsp");
        }
        else {
            System.out.println("bad username");

            // 给出用户提示，但是不用提示是密码错误还是用户名错误
            req.setAttribute("msg", "用户名或密码错误");

            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

//    private boolean checkLoginOk(String username, String password) {
//        if ("zhao".equals(username)) {
//            if ("1".equals(password))  {
//                return true;
//            }
//        }
//        return false;
//    }

    private boolean checkLoginOk(String username, String password) {
        UserDao md = new UserDaoImpl();
        User user = null;
        try {
            user = md.queryUser(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user != null;
    }

    public void destroy() {
    }
}