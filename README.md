# DEMO-01

很简陋的程序，只能够实现简单的注册、自动登录登出功能。

## Servlet
* LoginServlet 负责登录操作，返回md5加密后的密码作为cookie
* CheckServlet 负责查看用户信息
* LogoutServlet 登出操作
* RegisterServlet 注册操作

## Filter
* LoginFilter 目标资源是login.jsp，登录过期或未曾登录的，予以放行，否则请求转发至index.html

## 网页
* index.html 主页
* login.jsp 登录页面
* register.html 注册页面

## 表
分为logs和user。
* logs表保留用户登录账号、登录状态、登录时间、ip等。
* user表是用户的信息。

## 测试
访问/login.jsp，即可进行一系列测试。
