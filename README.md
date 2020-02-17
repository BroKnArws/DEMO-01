# DEMO-01

很简陋的程序，只能够实现简单的注册、自动登录登出功能。
信息校验也做得很简单。

## Servlet
* LoginServlet 负责登录操作，返回md5加密后的密码作为cookie
* CheckServlet 负责查看用户信息
* LogoutServlet 负责登出操作
* RegisterServlet 负责注册操作

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
1. 请使用tomcat（版本：9.0.29）作为web容器，maven导包后，访问/login.jsp，即可进行一系列测试。
2. 请注意，数据库使用mysql(版本： 5.7）,如需修改用于连接数据库的账户密码等基本配置，请前往utils包下的DatabaseUtil类中修改。
3. 此外，已经上传的图片在web目录下的image文件夹内。
