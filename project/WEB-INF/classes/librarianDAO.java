import java.sql.*; 
public class librarianDAO { 
// method searchPerson 
public int addlibrarian(String lname, String lpassword){ 
    //librarianinfo librarian = null;
    int rs = 0;
    try { 

	    System.out.println(lname);
	    Class.forName("com.mysql.jdbc.Driver"); 
	    String url = "jdbc:mysql://127.0.0.1/project"; 
	    Connection con = DriverManager.getConnection(url, "root", "root"); 
	    String sql = "INSERT INTO librarian (username, password, usertype) VALUES(?, ?, ?)"; 
	    PreparedStatement pst = con.prepareStatement(sql); 
	    pst.setString(1, lname);
        pst.setString(2, lpassword);
        pst.setString(3, "1");
    
        rs = pst.executeUpdate(); 
	
        
	    con.close(); 
	}
    catch(Exception ex){ 
		System.out.println(ex); 
	} 

return rs; 
}
public int deletelibrarian(String lname){ 
    //librarianinfo librarian = null;
    int rs = 0;
    try { 

	    System.out.println(lname);
	    Class.forName("com.mysql.jdbc.Driver"); 
	    String url = "jdbc:mysql://127.0.0.1/project"; 
	    Connection con = DriverManager.getConnection(url, "root", "root"); 
	    String sql = "DELETE FROM librarian WHERE username = ?"; 
	    PreparedStatement pst = con.prepareStatement(sql); 
	    pst.setString(1, lname);
       
    
        rs = pst.executeUpdate(); 
	
        
	    con.close(); 
	}
    catch(Exception ex){ 
		System.out.println(ex); 
	} 

return rs; 
} 
public librarianinfo searchlibrarian(String lname, String lpassword){ 
    //librarianinfo librarian = null;
    librarianinfo librarian = null;
    try { 

	    System.out.println(lname);
	    Class.forName("com.mysql.jdbc.Driver"); 
	    String url = "jdbc:mysql://127.0.0.1/project"; 
	    Connection con = DriverManager.getConnection(url, "root", "root"); 
	    String sql = "SELECT * FROM librarian WHERE username = ? AND password = ? "; 
	    PreparedStatement pst = con.prepareStatement(sql); 
	    pst.setString(1, lname);
        pst.setString(2, lpassword);
        ResultSet rs = pst.executeQuery(); 
		
	    if (rs.next( ) ) { 
			
		    int type = rs.getInt("usertype"); 
		    
		    librarian = new librarianinfo(type); 
	    } 
        
	    con.close(); 
	}
    catch(Exception ex){ 
		System.out.println(ex); 
	} 

return librarian; 
}
}