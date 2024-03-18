package com.utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import com.mysql.jdbc.Driver;

/**
 * �������ݿ�Ĺ�����
 */
public class DBUtil {
	public static String url = "jdbc:mysql://localhost/lflsys?useUnicode=true&characterEncoding=utf8";
	public static String username = "root";
	public static String password = "123456";
	/*
	 * �������ݿ�
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Driver driver = new com.mysql.jdbc.Driver();
//			System.out.println("driver ver: " + driver.getMajorVersion() + "." + driver.getMinorVersion());
//			System.out.println("driver path: " + driver.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());

			DriverManager.registerDriver(driver);
			// Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("��ȡ����ʧ��....");
			e.printStackTrace();
		}
		return conn;
	}
	/*
	 * �ر����ݿ�
	 */
	public static void close(Connection conn){
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��������
	 */
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		System.out.println("connection created: " + conn.getCatalog());
    }
}
