package com.agilecrm.util;
import java.sql.*;
public class jdbcConnections {
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
	Class.forName("com.mysql.jdbc.Driver"); 
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","root123");
	return con;
}
}
