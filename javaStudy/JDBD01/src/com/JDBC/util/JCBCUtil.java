//package com.JDBC.util;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Connection;
////import java.sql.Driver;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Properties;
//
//public class JCBCUtil {
//	static String driverClass=null;
//	static String url=null;
//	static String user=null;
//	static String password=null;
//	
//	//静态代码块，读取属性文件
//	static {
//		//创建一个属性配置对象
//		Properties properties = new Properties();
//		//使用类加载器，读取src下的属性文件为文件流
//		InputStream is;
//		try {
//			is = new FileInputStream("JDBC.properties");
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		//InputStream is=JCBCUtil.class.getClassLoader().getResourceAsStream("JDBC.properties");
//		
//		//加载属性流
//		try {
//			properties.load(is);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//读取属性
//		driverClass = properties.getProperty(driverClass);
//		url=properties.getProperty(url);
//		user=properties.getProperty(user);
//		password=properties.getProperty(password);
//	}
//	
//
//	/**
//	 * 获取连接对象
//	 * @return
//	 */
//	public static Connection getConn() {
//		Connection conn=null;
//		try {
//			//1.注册驱动
//			Class.forName(driverClass);
//			
//			//2.建立连接
//			
//			//DriverManager.getConnection("jdbc:mysql://localhost/test?user=monty&password=greatsqldb")
//			 conn = DriverManager.getConnection(url, user, password);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//			
//	}
//	
//	public static void release(Connection conn,Statement st,ResultSet rs) {
//		closeRs(rs);
//		closeSt(st);
//		closeConn(conn);
//	}
//	
//	public static void closeRs(ResultSet rs) {
//		if(rs!=null) {
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally {
//				rs=null;
//			}
//		}
//	}
//	
//	public static void closeSt(Statement st) {
//		if(st!=null) {
//			try {
//				st.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally {
//				st=null;
//			}
//		}
//	}
//	
//	public static void closeConn(Connection conn) {
//		if(conn!=null) {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally {
//				conn=null;
//			}
//		}
//	}
//	
//}
package com.JDBC.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.PreparedStatement;

public class JCBCUtil {
	
	static String driverClass = null;
	static String url = null;
	static String usr = null;
	static String password= null;
	
	static{
		try {
			//1. 创建一个属性配置对象
			Properties properties = new Properties();
			
			//2.使用两种方法将属性文件变成文件流
			//方法一：将属性文件放到工程根目录下，用new FileInputStream
			
			//InputStream is = new FileInputStream("JDBC.properties");
			//方法二：将属性文件放到src目录下，使用类加载器，去读取src底下的资源文件。 后面在servlet
			InputStream is = JCBCUtil.class.getClassLoader().getResourceAsStream("JDBC.properties");
			//导入输入流。
			properties.load(is);
			
			//读取属性
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			usr = properties.getProperty("usr");
			password = properties.getProperty("password");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接对象
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName(driverClass);
			//静态代码块 ---> 类加载了，就执行。 java.sql.DriverManager.registerDriver(new Driver());
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//DriverManager.getConnection("jdbc:mysql://localhost/test?user=monty&password=greatsqldb");
			//2. 建立连接 参数一： 协议 + 访问的数据库 ， 参数二： 用户名 ， 参数三： 密码。
			conn = DriverManager.getConnection(url, usr, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 释放资源
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void release(Connection conn , Statement st , ResultSet rs){
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	public static void release(Connection conn , PreparedStatement ps , ResultSet rs){
		closeRs(rs);
		closePs(ps);
		closeConn(conn);
	}
	
	private static void closeRs(ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			rs = null;
		}
	}
	
	private static void closeSt(Statement st){
		try {
			if(st != null){
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			st = null;
		}
	}
	
	private static void closePs(Statement ps){
		try {
			if(ps != null){
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ps = null;
		}
	}
	private static void closeConn(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}
}
