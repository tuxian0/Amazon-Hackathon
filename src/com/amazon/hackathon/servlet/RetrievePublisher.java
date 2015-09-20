package com.amazon.hackathon.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RetrievePublisher {
	public ResultSet retrievePublisher() throws ClassNotFoundException, SQLException
	{
		String query="select ID,author,publisher from book order by publisher";
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:amazon");
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;

}


}