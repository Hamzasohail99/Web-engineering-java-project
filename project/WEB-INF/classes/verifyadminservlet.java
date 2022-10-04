import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.http.HttpSession;
import java.sql.*;
import javax.swing.*;

public class verifyadminservlet extends HttpServlet { 

public void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter(); 

	String name=request.getParameter("name");
    String password = request.getParameter("pass");
	
	// creating PersonDAO object, and calling searchPerson() method 
	adminDAO adminDAO = new adminDAO(); 
	admininfo admin = adminDAO.searchadmin(name, password); 

	out.println("<html>"); 
	out.println("<body>"); 
	out.println("<h1>Search Results</h1>");

	if (admin != null){ 
		HttpSession session = request.getSession(true);
		int type = admin.type;
		session.setAttribute("usertype", type);
		response.sendRedirect("adminoption.html");
		//out.println("<h3> admin login </h3>" ); 
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
