package com.seu.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.seu.Dao.UserDao;
import com.seu.Util.JDBCUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean login(String username, String password) {
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try {
			//1.获取连接对象
			 conn = JDBCUtil.getConn();
			//2.创建prepareStatement对象，
			String sql="select * from t_user where username=? and password=? ";
			ps = conn.prepareStatement(sql);
			//给sql赋值并查询数据库
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps, rs);
		}

		return false;
	}

}
