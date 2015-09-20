package com.amazon.hackathon.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RetrieveResults {
	public ResultSet results() throws ClassNotFoundException, SQLException
	{
		String query="select ID,author,releasedate from book order by releasedate";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB", "root", "");
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery(query);
		con.close();
		return rs;
		

}
}
