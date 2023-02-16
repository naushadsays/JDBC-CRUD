package com.jsp.helper;

import java.sql.*;

public class ConnectPro {

	static Connection con = null;

	public static Connection conCreate() {

		try {
			// loading Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create connection

			String url = "jdbc:mysql://localhost:3306/testdb";
			String user = "root";
			String pw = "root";

			con = DriverManager.getConnection(url, user, pw);

		} catch (ClassNotFoundException e1) {
			System.out.println("*************Problem in Connection Class*****************");
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
