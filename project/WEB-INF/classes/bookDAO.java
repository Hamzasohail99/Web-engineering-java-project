import java.sql.*;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result; 
public class bookDAO { 
public int issuebook(String bname, String mid){
	
	int rs2 = 0; 
    
    try { 

	
	    Class.forName("com.mysql.jdbc.Driver"); 
	    String url = "jdbc:mysql://127.0.0.1/project"; 
	    Connection con = DriverManager.getConnection(url, "root", "root"); 
	    String sql = "SELECT * FROM booksrecord WHERE bookname = ? AND reserved = ?";
		 
	    PreparedStatement pst = con.prepareStatement(sql); 
		
	    pst.setString(1, bname);
		pst.setString(2, "notreserved");
		System.out.println(sql);
        ResultSet rs = pst.executeQuery(); 
		
	    if (rs.next( ) ) { 
			String sql3 = "SELECT * FROM members WHERE membershipnumber = ?";
			PreparedStatement pst3 = con.prepareStatement(sql3);
			pst3.setString(1, mid);
			ResultSet rs3 = pst3.executeQuery();
			if(rs3.next()){
			
            	String sql1 = "INSERT INTO issuedbook (bookname, memberid) VALUES (?, ?)";
			
            	PreparedStatement pst1 = con.prepareStatement(sql1);
            	pst1.setString(1, bname);
        	    pst1.setString(2, mid);
				System.out.println(sql1);
            	int rs1 = pst1.executeUpdate();
				
		    	if(rs1 == 1){
					String sql2 = "UPDATE booksrecord SET reserved = ? WHERE bookname = ?";
					PreparedStatement pst2 = con.prepareStatement(sql2);
					pst2.setString(1, "reserved");
					pst2.setString(2, bname);
					rs2 = pst2.executeUpdate();

				}
		}

		     
	    } 
        
	    con.close(); 
	}
    catch(Exception ex){ 
		System.out.println(ex); 
	} 
	return rs2;
	}
public int addbook(String bname){
	
	int rs = 0; 
	
	try { 
		Class.forName("com.mysql.jdbc.Driver"); 
		String url = "jdbc:mysql://127.0.0.1/project"; 
		Connection con = DriverManager.getConnection(url, "root", "root"); 
		String sql = "INSERT INTO booksrecord (bookname, reserved) VALUES(?, ?)";
		 
		PreparedStatement pst = con.prepareStatement(sql); 
		
		pst.setString(1, bname);
		pst.setString(2, "notreserved");
		System.out.println(sql);
		rs = pst.executeUpdate(); 
		
			
			con.close(); 
		}
		catch(Exception ex){ 
			System.out.println(ex); 
		} 
	return rs;
	}
public int deletebook(String bname){

	int rs = 0; 
	
	try { 
	
		
		Class.forName("com.mysql.jdbc.Driver"); 
		String url = "jdbc:mysql://127.0.0.1/project"; 
		Connection con = DriverManager.getConnection(url, "root", "root"); 
		String sql = "DELETE FROM booksrecord WHERE bookname = ? AND reserved = ?";
		 
		PreparedStatement pst = con.prepareStatement(sql); 
		
		pst.setString(1, bname);
		pst.setString(2, "notreserved");
		System.out.println(sql);
		rs = pst.executeUpdate(); 
	 
			
		con.close(); 
	}
	catch(Exception ex){ 
		System.out.println(ex); 
	} 
	return rs;
}
public int returnbook(String bname, String mid){
	
	int rs2 = 0; 
	
	try { 
			
		Class.forName("com.mysql.jdbc.Driver"); 
		String url = "jdbc:mysql://127.0.0.1/project"; 
		Connection con = DriverManager.getConnection(url, "root", "root"); 
		String sql = "SELECT * FROM issuedbook WHERE bookname = ? AND memberid = ?";
		 
		PreparedStatement pst = con.prepareStatement(sql); 
		
		pst.setString(1, bname);
		pst.setString(2, mid);
		System.out.println(sql);
		ResultSet rs = pst.executeQuery(); 
		
		if (rs.next()) { 
			//String bookname = rs.getString("bookname");
			//String memberid = rs.getString("memberid");
			
			String sql1 = "DELETE FROM issuedbook WHERE bookname = ? AND memberid = ? ";
				
			PreparedStatement pst1 = con.prepareStatement(sql1);
			pst1.setString(1, bname);
			pst1.setString(2, mid);
			System.out.println(sql1);
			int rs1 = pst1.executeUpdate();
		   
			if(rs1 == 1){
				String sql2 = "UPDATE booksrecord SET reserved = ? WHERE bookname = ?";
				PreparedStatement pst2 = con.prepareStatement(sql2);
				pst2.setString(1, "notreserved");
				pst2.setString(2, bname);
				rs2 = pst2.executeUpdate();
				}
	
		} 
			
		con.close(); 
	}
	catch(Exception ex){ 
		System.out.println(ex); 
	} 
	return rs2;
	}
public ArrayList<issuedbookinfo> viewissuedbooks(){
	ArrayList<issuedbookinfo> booklist = new ArrayList<>();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1/project"; 
		Connection con = DriverManager.getConnection(url, "root", "root"); 
		String sql = "SELECT * FROM issuedbook";
		PreparedStatement pStmt = con.prepareStatement(sql); 
		pStmt = con.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();

		
		while (rs.next()) {
			
			String bname = rs.getString("bookname");
			String memberid = rs.getString("memberid");
			issuedbookinfo book = new issuedbookinfo(bname, memberid);
			booklist.add(book);

		}

		con.close();

	} catch (Exception e) {	
		System.out.println(e);
	}

	return booklist;
}
public ArrayList<bookinfo> viewallbooks(){
	ArrayList<bookinfo> booklist = new ArrayList<>();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1/project"; 
		Connection con = DriverManager.getConnection(url, "root", "root"); 
		String sql = "SELECT * FROM booksrecord";
		PreparedStatement pStmt = con.prepareStatement(sql); 
		pStmt = con.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();

		
		while (rs.next()) {
			
			String bname = rs.getString("bookname");
			String reservness = rs.getString("reserved");
			bookinfo book = new bookinfo(bname, reservness);
			booklist.add(book);

		}

		con.close();

	} catch (Exception e) {	
		System.out.println(e);
	}

	return booklist;
}
}