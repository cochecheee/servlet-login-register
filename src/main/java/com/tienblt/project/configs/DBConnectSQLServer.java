package com.tienblt.project.configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectSQLServer {
	private final String serverName = "COCHECHE";
	private final String dbName = "ltwc2";
	private final String portNumber = "1433";
	private final String userID = "sa";
	private final String password = "123456";
	
	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}

	// Test chương trình. Kích phải chuột chọn run as->java application
	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectSQLServer().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
