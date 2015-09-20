package com.amazon.hackathon.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PublishersList
 */
public class PublishersList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishersList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RetrievePublisher rRes= new RetrievePublisher();
		ResultSet rs=null;
		try {
			 rs=rRes.retrievePublisher();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter ps= response.getWriter();
		ps.println("<html>");
		ps.println("<head>");
		ps.println("<html><head>");
		ps.println("</head>");
		ps.println("<body style='background-color:#c8c8c8;'>");
		ps.println("<select name='list' id='list' accesskey='target'>");
		ps.println("<table border='0'>");
		try {
			while(rs.next())
			{
				
			String author=rs.getString("author");
			String book=rs.getString("book");
			String publisher= rs.getString("publisher");
			ps.println("<th>");
			ps.println("AuthorName");
			ps.println("</th>");
			ps.println("<th>");
			ps.println("Book");
			ps.println("</th>");
			ps.println("<th>");
			ps.println("Publisher");
			ps.println("</th>");
			ps.println("<tr>");
			ps.println("<td>");
			ps.println(author);
			ps.println("</td>");
			ps.println("<td>");
			ps.println(book);
			ps.println("</td>");
			ps.println("<td>");
			ps.println(publisher);
			ps.println("</td>");
			ps.println("</tr>");
			ps.println("</table>");
			ps.println("</body>");
			ps.println("</html>");
			
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}