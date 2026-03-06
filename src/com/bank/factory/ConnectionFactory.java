package com.bank.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cdg_hyd_jfs_046";
	private static final String USER = "root";
	private static final String PASSWORD = "Gowtham@05";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
	}
}
