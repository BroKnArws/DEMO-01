package com.strutnut.servlet;

import com.strutnut.service.ILogsService;
import com.strutnut.service.IUserService;
import com.strutnut.service.impl.LogsServiceImpl;
import com.strutnut.service.impl.UserServiceImpl;
import com.strutnut.utils.DateUtil;
import com.strutnut.utils.md5Util;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static IUserService userService;
    private static ILogsService logsService;

    static {
        userService = new UserServiceImpl();
        logsService = new LogsServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String encryptedPassword = md5Util.stringTomd5(password);
        String logintime = DateUtil.getCurrentTime();

        //登录验证
        if (userService.checkUser(account, encryptedPassword)) {
            //添加登录状态
            logsService.deleteLogs(account);
            logsService.addLogs(account, "undefined", logintime);

            //如果在5分钟内关闭浏览器再次进入网页，依旧自动登录。
            Cookie accountCookie = new Cookie("account", account);
            Cookie passwordCookie = new Cookie("id", encryptedPassword);
            accountCookie.setMaxAge(24 * 60 * 60);
            passwordCookie.setMaxAge(24 * 60 * 60);

            resp.addCookie(accountCookie);
            resp.addCookie(passwordCookie);
            resp.sendRedirect("index.html");
        }
        //用户名或密码错误
        else {
            resp.getWriter().write("YOUR PASSWORD OR ACCOUNT IS NOT RIGHT . TRY AGAIN ?");
        }
    }
}
