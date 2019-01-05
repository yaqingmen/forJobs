package com.seu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seu.Dao.StuDao;
import com.seu.Dao.UserDao;
import com.seu.Domain.Student;
import com.seu.Impl.StuDaoImpl;
import com.seu.Impl.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//客户端提交数据有中文
		request.setCharacterEncoding("UTF-8");
		//服务器给客户端的信息有中文
		response.setContentType("text/html;charset=utf-8");
		
		//1.获取客户端发送的用户登录信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//2.查询数据库，判断是否登录成功
		UserDao dao=new UserDaoImpl();
		boolean isSuccess=dao.login(username, password);
		
		//3.如果成功，就做三件事
		/*
		 * 1.查询所有的学生信息
		 * 2.将这个所有学生的集合存储到作用域中
		 * 3.跳转到stu_list.jsp
		 */
		if(isSuccess) {
			//1.查询所有的学生信息
			StuDao Daos=new StuDaoImpl();
			List<Student> stus=Daos.findAll();
			
			//2.将学生集合存储到作用域
			request.getSession().setAttribute("stus_list", stus);
			
			//3.跳转到stu_list.jsp
			response.sendRedirect("stu_list.jsp");
			//response.getWriter().write("登录成功！欢迎您，"+username);
			
		}else {
			response.getWriter().write("用户名或密码错误！");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
