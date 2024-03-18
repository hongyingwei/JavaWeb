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
	 * �����û����������ѯ�û�
	 */
	@Override
	public Manager queryManager(String name, String password) throws Exception {
//		1.�������ݿ�����
		Manager manager = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
//			2.��дSQL���
			String sql = "select * from t_manager where name =? and password =?";
//			3.ִ��SQL���			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
//			4.��ȡ��ѯ�����
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
//				��װmanger
				manager = new Manager();
                manager.setId(rs.getInt("id"));
                manager.setNickName(rs.getString("nickName"));
                manager.setName(rs.getString("name"));
                manager.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			5.�ر����ݿ�����
			DBUtil.close(conn);
		}
		return manager;
	}

	/**
	 * ����idɾ���û�
	 */
	@Override
	public boolean deleteManager(Integer id) {
//		1.�������ݿ�����
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
//			2.��дSQL���
			String sql = "delete from t_manager where id =?";
//			3.ִ��SQL���
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id.intValue());
//			4.��ȡ��ѯ�����
			int cnt = ps.executeUpdate();
//			5.�ύ�޸�����
			conn.commit();
			return cnt == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			6.�ر����ݿ�����
			DBUtil.close(conn);
		}
		return false;
	}

	/**
	 * ��ѯ�����û�
	 */
	@Override
	public List<Manager> queryListManagers() {
//		1.�������ݿ�����
		Connection conn = null;
		List<Manager> list = new ArrayList<Manager>();
		try {
			conn = DBUtil.getConnection();
//			2.��дSQL���
			String sql = "select * from t_manager";
//			3.ִ��SQL���
			PreparedStatement ps = conn.prepareStatement(sql);
//			4.��ȡ��ѯ�����
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
//			5.�ر����ݿ�����
			DBUtil.close(conn);
		}
		return list;
	}

}
