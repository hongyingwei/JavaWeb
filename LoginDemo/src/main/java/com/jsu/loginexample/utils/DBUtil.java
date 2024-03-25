package com.jsu.loginexample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/**
 * 操作数据库的工具类
 */
public class DBUtil {
	public static String url = "jdbc:mysql://localhost/demodb?useUnicode=true&characterEncoding=utf8";
	public static String username = "root";
	public static String password = "15874473705hyw";
	
	/*
	 * 连接数据库
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("获取连接失败....");
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭数据库连接
	 */
	public static void close(Connection conn) {
		try {
            if(conn!= null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
