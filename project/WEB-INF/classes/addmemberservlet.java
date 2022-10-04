import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.http.HttpSession;
import java.sql.*;
import javax.swing.*;

public class addmemberservlet extends HttpServlet { 

public void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
	
	HttpSession session = request.getSession(false);
	if(session == null){
		response.sendRedirect("librarianlogin.html");
	}
	int usertype =  (int)session.getAttribute("usertype");

	if(usertype != 1){
		response.sendRedirect("librarianlogin.html");
	}
	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter(); 

	String name=request.getParameter("name");
	String rollno = request.getParameter("rollno");
	String memberid = request.getParameter("membershipnumber");

	// creating PersonDAO object, and calling searchPerson() method 
	memberDAO memberDAO = new memberDAO(); 
	//int member = memberDAO.addmember(name, rollno, memberid); 

	out.println("<html>"); 
	out.println("<body>"); 
	out.println("<h1>Search Results</h1>");

	int s = memberDAO.addmember(name, rollno, memberid);

	if (s == 1){ 
		
		response.sendRedirect("librarianoption.html");
		//out.println("<h3> member added </h3>" ); 
		} 
	else{ 
		out.println("<h3>member not added</h3>" ); 
		}
		 
	out.println("</body>"); 
	out.println("</html>");
	out.close(); 
	} 
	

// Handles the HTTP GET method.
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException { 
		processRequest(request, response);
	} 

// Handles the HTTP POST method 
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
		processRequest(request, response); 
	} 
}


