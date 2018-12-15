package com.seu.test;

import java.util.ArrayList;

import org.junit.Test;

import com.seu.dao.Student;
import com.seu.dao.UserDao;
import com.seu.dao.impl.UserDaoImpl;

public class TestDAO {
	
	@Test
	public void testLogin() {
		UserDao dao = new UserDaoImpl();
		Student stu = dao.login("zhangsan", "100300");
		//System.out.print("age="+stu.getAge()+"\nemail="+stu.getEmail());
		System.out.println(stu);
	}
	@Test
	public void testFindAll() {
		UserDao dao = new UserDaoImpl();
		ArrayList<Student> al = dao.findAll();
		//打印Arraylist
		for(Student stu:al) {
			System.out.println(stu);
		}
	}
	@Test
	public void testInsert() {
		UserDao dao = new UserDaoImpl();
		int res = dao.insert("lihuachu", "shazi", 25, "123@123.com");
		System.out.println(res);
	}
	@Test
	public void testUpdate() {
		UserDao dao = new UserDaoImpl();
		int res = dao.update(3, "mmy");
		System.out.println(res);
	}
	@Test
	public void testDelete() {
		UserDao dao = new UserDaoImpl();
		int res = dao.delete(9);
		System.out.println(res);
	}
}
