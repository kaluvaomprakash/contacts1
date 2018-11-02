package com.agilecrm.util;
import java.sql.*;
public class connections {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.jdbc.Driver"); 
	return DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","root123");
}
}
