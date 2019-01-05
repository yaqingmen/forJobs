package com.seu.Dao;

public interface UserDao {
	/*
	 * 查询数据库，判断客户端登录是否成功
	 * @param username:用户名 
	 * @param password:密码
	 */
	boolean login(String username,String password);

}
