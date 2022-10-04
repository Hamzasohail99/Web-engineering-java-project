import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.http.HttpSession;
import java.sql.*;
import javax.swing.*;

public class deletelibrarianservlet extends HttpServlet { 

public void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
	
	HttpSession session = request.getSession(false);
	if(session == null){
		response.sendRedirect("adminlogin.html");
	}
	int usertype =  (int)session.getAttribute("usertype");

	if(usertype != 0){
		response.sendRedirect("adminlogin.html");
	}

	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter(); 

	String name=request.getParameter("name");
    
	// creating PersonDAO object, and calling searchPerson() method 
	librarianDAO librarianDAO = new librarianDAO(); 
	//int librarian = librarianDAO.deletelibrarian(name); 

	out.println("<html>"); 
	out.println("<body>"); 
	out.println("<h1>Search Results</h1>");

	int s = librarianDAO.deletelibrarian(name);

	if (s == 1){ 
		
		response.sendRedirect("adminoption.html");
		//out.println("<h3> librarian deleted </h3>" ); 
			} 
	else{ 
		out.println("<h3>Sorry! No records found</h3>" ); 
	} 
	out.println("</body>"); 
	out.println("</html>");
	out.close(); 
	} 

// Handles the HTTP GET method.
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException { 
		processRequest(request, response);} 

// Handles the HTTP POST method 
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
		processRequest(request, response); 
 } 

}
