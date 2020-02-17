package com.strutnut.servlet;

import com.strutnut.service.IUserService;
import com.strutnut.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/check")
public class CheckServlet extends HttpServlet {

    private static IUserService userService;

    static {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        Cookie[] cookies = req.getCookies();
        String account = null;
        for (Cookie c : cookies) {
            if ("account".equals(c.getName())) {
                account = c.getValue();
            }
        }
        ResultSet result = userService.findUserByAccount(account);
        try {
            while (result.next()) {
                String sex = "on".equals(result.getString("sex")) ? "男" : "女";
                String imagePath = result.getString("avatar");
                resp.getWriter().print(
                        " 用户名: " + result.getString("account") + "<br>"
                                + " 姓名: " + result.getString("name") + "<br>"
                                + " 年龄: " + result.getString("age") + "<br>"
                                + " 性别: " + sex + "<br>"
                                + " 个性签名: " + result.getString("signature") + "<br>");
                resp.getWriter().println(" 头像: " + "<image src=\"" + imagePath + "\"></image>" + "<br>");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
