package com.utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import com.mysql.jdbc.Driver;

/**
 * 连接数据库的工具类
 */
public class DBUtil {
	public static String url = "jdbc:mysql://localhost/lflsys?useUnicode=true&characterEncoding=utf8";
	public static String username = "root";
	public static String password = "123456";
	/*
	 * 连接数据库
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
			System.out.println("获取连接失败....");
			e.printStackTrace();
		}
		return conn;
	}
	/*
	 * 关闭数据库
	 */
	public static void close(Connection conn){
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 测试连接
	 */
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		System.out.println("connection created: " + conn.getCatalog());
    }
}
