package com.strutnut.filter;

import com.strutnut.service.ILogsService;
import com.strutnut.service.IUserService;
import com.strutnut.service.impl.LogsServiceImpl;
import com.strutnut.service.impl.UserServiceImpl;
import com.strutnut.utils.DateUtil;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 拦截请求用以做出是否登录状态是否过期的判断
 *
 * @author strutnut
 * @date 2020/2/15
 */

@WebFilter("*.jsp")
public class LoginFilter extends HttpFilter {

    private static ILogsService logsService;
    private static IUserService userService;

    static {
        logsService = new LogsServiceImpl();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        String logintime = DateUtil.getCurrentTime();

        Cookie[] cookies = req.getCookies();

        String password = null;
        String account = null;

        for (Cookie c : cookies) {
            if ("password".equals(c.getName())) {
                password = c.getValue();
            }
            if ("account".equals(c.getName())) {
                account = c.getValue();
            }
        }

        if (password != null) {
            //检查上回登录时间和密码
            if (logsService.checkLogs(password, logintime) && userService.checkUser(account, password)) {
                //登录
                logsService.updateLoginTime(account, logintime);
                req.getRequestDispatcher("index.html").forward(req, resp);
            } else {
                //删除过时记录
                Cookie passwordCookie = new Cookie("id", null);
                Cookie accountCookie = new Cookie("account", null);
                accountCookie.setMaxAge(0);
                passwordCookie.setMaxAge(0);
                resp.addCookie(passwordCookie);
                resp.addCookie(accountCookie);
            }
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
