package com.work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Manager;
import com.utils.DBUtil;

public class ManagerDaoImpl implements ManagerDao{

	/**
	 * 根据用户名和密码查询用户
	 */
	@Override
	public Manager queryManager(String name, String password) throws Exception {
//		1.建立数据库连接
		Manager manager = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
//			2.编写SQL语句
			String sql = "select * from t_manager where name =? and password =?";
//			3.执行SQL语句			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
//			4.获取查询结果集
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
//				封装manger
				manager = new Manager();
                manager.setId(rs.getInt("id"));
                manager.setNickName(rs.getString("nickName"));
                manager.setName(rs.getString("name"));
                manager.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			5.关闭数据库连接
			DBUtil.close(conn);
		}
		return manager;
	}

	/**
	 * 根据id删除用户
	 */
	@Override
	public boolean deleteManager(Integer id) {
//		1.建立数据库连接
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
//			2.编写SQL语句
			String sql = "delete from t_manager where id =?";
//			3.执行SQL语句
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id.intValue());
//			4.获取查询结果集
			int cnt = ps.executeUpdate();
//			5.提交修改事务
			conn.commit();
			return cnt == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			6.关闭数据库连接
			DBUtil.close(conn);
		}
		return false;
	}

	/**
	 * 查询所有用户
	 */
	@Override
	public List<Manager> queryListManagers() {
//		1.建立数据库连接
		Connection conn = null;
		List<Manager> list = new ArrayList<Manager>();
		try {
			conn = DBUtil.getConnection();
//			2.编写SQL语句
			String sql = "select * from t_manager";
//			3.执行SQL语句
			PreparedStatement ps = conn.prepareStatement(sql);
//			4.获取查询结果集
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Manager manager = new Manager();
                manager.setId(rs.getInt("id"));
                manager.setNickName(rs.getString("nickName"));
                manager.setName(rs.getString("name"));
                manager.setPassword(rs.getString("password"));
                
                list.add(manager);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
//			5.关闭数据库连接
			DBUtil.close(conn);
		}
		return list;
	}

}
