import java.sql.*; 
public class adminDAO { 
// method searchPerson 
public admininfo searchadmin(String sname,String spassword){ 
    admininfo admin = null; 
    try { 

	    System.out.println(sname);
	    Class.forName("com.mysql.jdbc.Driver"); 
	    String url = "jdbc:mysql://127.0.0.1/project"; 
	    Connection con = DriverManager.getConnection(url, "root", "root"); 
	    String sql = "SELECT * FROM admin WHERE username = ? and password = ?"; 
	    PreparedStatement pst = con.prepareStatement(sql); 
	    pst.setString(1, sname);
        pst.setString(2, spassword);

	    ResultSet rs = pst.executeQuery(); 
	    if (rs.next( ) ) { 
			
		    int type = rs.getInt("usertype"); 
		    
		    admin = new admininfo(type); 
	    } 
	    con.close(); 
	}
    catch(Exception ex){ 
		System.out.println(ex); 
	} 

return admin; 
}
}