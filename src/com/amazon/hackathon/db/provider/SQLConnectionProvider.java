package com.amazon.hackathon.db.provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnectionProvider {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB", "root", "");
	}

	public static ResultSet executeUpdateQuery(String query) throws SQLException, ClassNotFoundException {
		System.out.println("executeUpdateQuery>>query>>"+query);
		Connection conn = getConnection();
		try {
			// create our java preparedstatement using a sql update query
			PreparedStatement ps = conn.prepareStatement(query);

			// call executeUpdate to execute our sql update statement
			ps.executeUpdate();
			ps.close();
		} finally {
			conn.close();
		}
		return null;
	}

	public static void executeInsertQuery(String query) throws ClassNotFoundException, SQLException {
		System.out.println("executeInsertQuery>>query>>"+query);
		Connection conn = getConnection();
		try {

			PreparedStatement st = conn.prepareStatement(query);
			// execute the preparedstatement insert
		    st.executeUpdate();
		    st.close();
			
		} finally {
			conn.close();
		}
	}
	
	public static ResultSet executeSelectQuery(String query) throws ClassNotFoundException, SQLException {
		System.out.println("executeSelectQuery>>query>>"+query);
		Connection conn = getConnection();
		try {

			Statement stmt = conn.createStatement();
			return stmt.executeQuery(query);
			
		} finally {
			conn.close();
		}
	}

}
