package com.JDBC.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.JDBC.util.JCBCUtil;

public class testJDBC {
  
	public static void main(String[] args) {
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//1.注册驱动，获取连接
			 conn = JCBCUtil.getConn();
			//2.
			st = conn.createStatement();
			
			//3.查询数据库，得到结果集
			String sql="select * from student";
			rs = st.executeQuery(sql);
			
			//
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("usr");
				String password = rs.getString("password");
				int age=rs.getInt("age");
				String email=rs.getString("email");
				System.out.println("id="+id+"===usr="+name+"===age="+age+"===password="+password+"===email="+email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JCBCUtil.release(conn, st, rs);
		}

	}

}
