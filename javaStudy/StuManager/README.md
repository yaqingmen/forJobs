## 学生管理系统

* 实现的功能：
> 用户登录，登录成功后跳转到数据库中所有的学生信息页面，登录失败直接输出用户名或密码错误


* 思维导图


![icon](img/img02.png)


* 根据所画思维导图，从左至右实现功能。

1. 创建login.jsp，实现用户登录界面，form表单中action=LoginServlet
2. 创建数据库t_user，即用户相关的数据库
3. 创建LoginServlet,获取客户端传来的用户名和密码
4. 继续编写LoginServlet：


* 用JDBC连接数据库，并判断客户端用户是否登录成功
 
失败，直接输出用户名或密码错误 
成功，需要做三件事:
 	 
1. 获取所有的学生信息集合
2. 将学生信息集合存储到作用域session中
3. 跳转界面到stu_list.jsp
	

* 根据登录成功要做的三件事：

1. 创建t_stus	
2. 获取所有的用户信息集合stus=findAll();
3. 创建stu_list.jsp并使用EL+JSTL来遍历stus，输出到浏览器界面
