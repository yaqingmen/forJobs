package com.seu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.JDBC.util.JCBCUtil;
import com.seu.dao.Student;
import com.seu.dao.UserDao;


public class UserDaoImpl implements UserDao {
	
	@Override
	public Student login(String name, String passwordin) {
		Student stu = null;
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		//1.连接数据库
		try {
			conn = JCBCUtil.getConn();
			String sql="select * from student where usr=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, passwordin);
			rs = ps.executeQuery();
			
		if(rs.next()) {			
			stu=new Student(rs.getInt("id"),rs.getString("usr"),rs.getString("password"),rs.getInt("age"),rs.getString("email"));
			return stu;
			//System.out.println("success");
			}
		else {
			System.out.println("登录失败！");
			return null;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//释放资源；
			JCBCUtil.release(conn, ps, rs);
		}
		return stu;

	}

	@Override
	public ArrayList<Student> findAll() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Student> al=null;
		//1.获得连接对象
		try {
			conn = JCBCUtil.getConn();
			//2.创建preparedStatement对象
			String sql="select * from student";
			ps = conn.prepareStatement(sql);
			//3.执行查询，获得数据集
			rs = ps.executeQuery();
			al = new ArrayList<Student>();
			Student stu=null;
			
			while(rs.next()) {
				stu=new Student(rs.getInt("id"), rs.getString("usr"), rs.getString("password"), rs.getInt("age"), rs.getString("email"));
				al.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JCBCUtil.release(conn, ps, rs);
		}
		return al;

	}

	@Override
	public int insert(String usr, String password, int age, String email) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int res=0;
		//1.获得连接对象
		try {
			conn = JCBCUtil.getConn();
			//2.创建preparedStatement对象
			String sql="insert into student values(null,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usr);
			ps.setString(2, password);
			ps.setInt(3,age);
			ps.setString(4, email);
			//3.执行插入，获得影响的行数
			res = ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JCBCUtil.release(conn, ps, rs);
		}
		return res;
	}

	@Override
	public int update(int id, String usr) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int res=0;
		//1.获得连接对象
		try {
			conn = JCBCUtil.getConn();
			//2.创建preparedStatement对象
			String sql="update student set usr=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usr);
			ps.setInt(2, id);
			//3.执行插入，获得影响的行数
			res = ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JCBCUtil.release(conn, ps, rs);
		}
		return res;
		
	}

	@Override
	public int delete(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int res=0;
		//1.获得连接对象
		try {
			conn = JCBCUtil.getConn();
			//2.创建preparedStatement对象
			String sql="delete from student where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			//3.执行插入，获得影响的行数
			res = ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JCBCUtil.release(conn, ps, rs);
		}
		return res;
		
	}


}
