package com.seu.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seu.Dao.StuDao;
import com.seu.Domain.Student;
import com.seu.Util.JDBCUtil;

public class StuDaoImpl implements StuDao {

	@Override
	public List<Student> findAll() {
		// 
		List<Student> stus=new ArrayList<>();
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try {
			//1.获取连接对象
			 conn = JDBCUtil.getConn();
			//2.创建prepareStatement对象，
			String sql="select * from t_stus";
			ps = conn.prepareStatement(sql);
			//给sql赋值
			//ps.setString(1, username);
			//ps.setString(2, password);
			//3.执行查询
			rs = ps.executeQuery();
			
		while(rs.next()) {
			Student stu=new Student();
			stu.setId(rs.getInt("id"));
			stu.setName(rs.getString("name"));
			stu.setAge(rs.getInt("age"));
			stu.setAddress(rs.getString("address"));
			stu.setGender(rs.getString("gender"));
			stus.add(stu);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps, rs);
		}
		return stus;
	}

}
