package com.tickets.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class jdbcConnections {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","root123");
	}
	
//	public static void main(String args[]) throws ClassNotFoundException, SQLException {
//		System.out.println(jdbcConnections.getConnection().getClass().getName()+"----");
//	}
	
}
