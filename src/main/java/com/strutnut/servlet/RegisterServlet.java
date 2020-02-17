package com.strutnut.servlet;

import com.strutnut.bean.User;
import com.strutnut.service.IUserService;
import com.strutnut.service.impl.UserServiceImpl;
import com.strutnut.utils.md5Util;



import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/register")
@MultipartConfig
public class RegisterServlet extends HttpServlet {

    private static IUserService userService;

    static {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");

        Part part = req.getPart("avatar");
        String imageName = part.getSubmittedFileName();
        String serverPath = req.getServletContext().getRealPath("images");
        File file = new File(serverPath);
        //目录不存在就创建
        if (!file.exists()) {
            if (!file.mkdir()) {
                System.out.println("目录创建失败");
            }
        }

        String filePath = (serverPath + "\\" + imageName).replace("\\","/");

        User user = new User(req.getParameter("account"), md5Util.stringTomd5(req.getParameter("password")), req.getParameter("name"),
                req.getParameter("age"), req.getParameter("sex"), filePath, req.getParameter("signature"));

        //下载上传的图片
        if (imageName != null) {
            FileOutputStream fos = new FileOutputStream(filePath);
            InputStream sis = part.getInputStream();

            int len;
            byte[] bytes = new byte[1024];
            while ((len = sis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

            fos.close();
            sis.close();
        }

        if (!userService.addUser(user)) {
            resp.getWriter().println("<h1>注册失败，可能是用户名重复，也有可能是有没填写的表单~");
        } else {
            resp.sendRedirect("login.jsp");
        }


    }
}
