package com.jsu.loginexample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/**
 * �������ݿ�Ĺ�����
 */
public class DBUtil {
	public static String url = "jdbc:mysql://localhost/demodb?useUnicode=true&characterEncoding=utf8";
	public static String username = "root";
	public static String password = "15874473705hyw";
	
	/*
	 * �������ݿ�
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("��ȡ����ʧ��....");
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * �ر����ݿ�����
	 */
	public static void close(Connection conn) {
		try {
            if(conn!= null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
