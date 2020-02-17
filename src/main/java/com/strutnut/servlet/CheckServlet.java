package com.strutnut.servlet;

import com.strutnut.service.IUserService;
import com.strutnut.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
                String sex = "on".equals(result.getString("sex")) ? "fale" : "female";
                resp.getWriter().write(
                        " 用户名: " + result.getString("account")
                                + " 姓名: " + result.getString("name")
                                + " 年龄: " + result.getString("age")
                                + " 性别: " + sex
                                + " 个性签名: " + result.getString("signature")
                );
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
