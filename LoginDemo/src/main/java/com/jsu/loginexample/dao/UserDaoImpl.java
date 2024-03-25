package com.jsu.loginexample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsu.loginexample.model.User;
import com.jsu.loginexample.utils.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User queryUser(String name, String password) throws SQLException {
		User user = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = " select * from user where username=? and password=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// 用户合法
				user = getUser(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// 处理异常
			throw e;
		} finally {
			DBUtil.close(conn);
		}
		return user;
	}

	private User getUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setNickName(rs.getString("nickName"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		return user;
	}

	@Override
	public User queryUserByUserName(String name) throws Exception {
		User user = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from user where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = getUser(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(conn);
		}
		return user;
	}

	public boolean insertUser(User user) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into user(username,nickName,password) values(?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getNickName());
			ps.setString(3, user.getPassword());
			int rs = ps.executeUpdate();
			conn.commit();
			return rs == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return false;
	}

	@Override
	public boolean deleteUser(String username) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from user where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			int i = ps.executeUpdate();
			conn.commit();
			return i == 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return false;
	}
}
