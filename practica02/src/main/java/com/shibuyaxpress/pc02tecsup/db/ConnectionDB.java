package com.shibuyaxpress.pc02tecsup.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	public static Connection getConnection() {
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/test_clinica";
		String user="root";
		String password ="cityscape13";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,user,password);
			System.out.println("Connection Completed");
		}catch(SQLException|ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}finally {
			
		}
		return con;
	}
}
