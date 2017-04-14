package com.oldw.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtils {

	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/oldw?characterEncoding=utf8&useSSL=true";
	private static final String USER = "root";
	private static final String PASSWORD = "521007";
	
	
	private static Connection conn = null;
	
	static{

		try {
			//加载驱动文件
			Class.forName("com.mysql.jdbc.Driver");
			
			//链接到数据库
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return conn;
	}
	
}
