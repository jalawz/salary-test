package com.discount.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String PORT = "3306";
	private static final String DATABASE = "teste";
	private static final String USER = "root";
	private static final String PASS = "root";
	
	private ConnectionFactory() {
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(String.format("jdbc:mysql://localhost:%s/%s", PORT, DATABASE), USER, PASS);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
