package com.amazon.hackathon.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RetrieveLatest {
	public ResultSet retrieveLatest() throws ClassNotFoundException, SQLException
	{
		String query="select ID,author,releasedate from book order by ReleaseDate";
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:amazon");
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;

}

}