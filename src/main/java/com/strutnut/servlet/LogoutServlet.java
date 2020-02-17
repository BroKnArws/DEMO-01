package com.strutnut.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("loginAccount")) {
                //删除登录状态
                Cookie cookie = new Cookie(c.getName(), null);
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
                break;
            }
        }
        System.out.println("已经登出");
        resp.sendRedirect("login.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
