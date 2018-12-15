package com.seu.dao;

import java.util.ArrayList;

public interface UserDao {
	/**
	 * 登录方法
	 */
	 public Student login(String name,String passwordin);
	 
	 /**
	  * 查询所有
	  * @return
	  */
	 public ArrayList<Student> findAll();
	 
	 public int insert(String usr,String password,int age,String email);
	 
	 public int update(int id,String usr);
	 
	 public int delete(int id);
	

}
