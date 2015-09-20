package com.amazon.hackathon.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubscriptionSystemServlet
 */
public class SubscriptionSystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubscriptionSystemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("userID");
		PrintWriter ps= response.getWriter();
		ps.println("<html>");
		ps.println("<head>");
		ps.println("<html><head>");
		ps.println("<script type='text/javascript'>");
		
	    ps.println("function goToNewPage()");
	    ps.println("{");
	    ps.println(" var url = document.getElementById('list').value;");
	    ps.println("if(url != 'none') {");
	    ps.println(" window.location = url;");
	     ps.println("}");
	    ps.println("}");
	ps.println("</script>");
		ps.println("</head>");
		ps.println("<body style='background-color:#c8c8c8;'>");
		ps.println("welcome"+name);
		ps.println("<select name='list' id='list' accesskey='target'>");
		ps.println("<option value='none' selected>Choose a view</option>");
		ps.println("<option value='/SubsriptionSystem/AuthorsList' method='get'>Authors</option>");
		ps.println("<option value='/SubsriptionSystem/LatestList'>Publications</option>");
		ps.println("<option value='/SubsriptionSystem/PublishersList'>New Arrivals</option>");
	    ps.println("<select>");
	    ps.println("<input type='button' value='Go' onclick='goToNewPage()' />");
		ps.println("</body>");
		ps.println("</html>");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}