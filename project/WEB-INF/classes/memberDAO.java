
import java.sql.*; 
import java.util.ArrayList;

public class memberDAO { 

public int addmember(String mname, String mrollno, String mid){ 

    int rs = 0;
    try { 

	    //System.out.println(lname);
	    Class.forName("com.mysql.jdbc.Driver"); 
	    String url = "jdbc:mysql://127.0.0.1/project"; 
	    Connection con = DriverManager.getConnection(url, "root", "root"); 
	    String sql = "INSERT INTO members (name, rollno, membershipnumber) VALUES(?, ?, ?)"; 
	    PreparedStatement pst = con.prepareStatement(sql); 
	    pst.setString(1, mname);
        pst.setString(2, mrollno);
        pst.setString(3, mid);
    
        rs = pst.executeUpdate(); 
	
        
	    con.close(); 
	}
    catch(Exception ex){ 
		System.out.println(ex); 
	} 

return rs; 
}
public int deletemember(String mid){ 
    //librarianinfo librarian = null;
    int rs = 0;
    try { 

	    //System.out.println(lname);
	    Class.forName("com.mysql.jdbc.Driver"); 
	    String url = "jdbc:mysql://127.0.0.1/project"; 
	    Connection con = DriverManager.getConnection(url, "root", "root"); 
	    String sql = "DELETE FROM members WHERE membershipnumber = ?"; 
	    PreparedStatement pst = con.prepareStatement(sql); 
	    pst.setString(1, mid);
       
    
        rs = pst.executeUpdate(); 
	
        
	    con.close(); 
	}
    catch(Exception ex){ 
		System.out.println(ex); 
	} 

return rs; 
}
public int updatemember(String mname, String mrollno, String mid){ 
    int rs = 0;
    try {
	    Class.forName("com.mysql.jdbc.Driver"); 
	    String url = "jdbc:mysql://127.0.0.1/project"; 
	    Connection con = DriverManager.getConnection(url, "root", "root"); 
	    String sql = "UPDATE members SET name = ?, rollno = ? WHERE membershipnumber = ?"; 
	    PreparedStatement pst = con.prepareStatement(sql); 
	    pst.setString(1, mname);
        pst.setString(2, mrollno);
        pst.setString(3, mid);
        
        rs = pst.executeUpdate(); 
	
	    con.close(); 
	}
    catch(Exception ex){ 
		System.out.println(ex); 
	} 

return rs; 
} 

public memberinfo viewmember(String mid){ 
    memberinfo member = null; 
    try { 
 
     //System.out.println(sName);
        Class.forName("com.mysql.jdbc.Driver"); 
        String url = "jdbc:mysql://127.0.0.1/project"; 
        Connection con = DriverManager.getConnection(url, "root", "root"); 
        String sql = "SELECT * FROM members WHERE membershipnumber = ?"; 
        PreparedStatement pStmt = con.prepareStatement(sql); 
        pStmt.setString(1, mid); 
        ResultSet rs = pStmt.executeQuery(); 
        if (rs.next( ) ) { 
            String name = rs.getString("name"); 
            String rollno = rs.getString("rollno"); 
            String id = rs.getString("membershipnumber"); 
            member = new memberinfo(name, rollno, id); 
        }   
        con.close(); 
        }
        catch(Exception ex){ 
            System.out.println(ex); 
        } 
 
   return member; 
  }
public ArrayList<memberinfo> viewmembers(){
    ArrayList<memberinfo> stlist = new ArrayList<>();
    try {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1/project"; 
        Connection con = DriverManager.getConnection(url, "root", "root"); 
        String sql = "SELECT * FROM members";
        PreparedStatement pStmt = con.prepareStatement(sql); 
        pStmt = con.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();

        
        while (rs.next()) {
            
            String name = rs.getString("name");
            String rollno = rs.getString("rollNo");
            String id = rs.getString("membershipnumber");
            memberinfo member = new memberinfo(name, rollno, id);
            stlist.add(member);

        }

        con.close();

    } catch (Exception e) {
        System.out.println(e);
    }

    return stlist;
}
}