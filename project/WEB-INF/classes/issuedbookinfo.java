
public class issuedbookinfo {
    
    String name;
    String id;
    // public memberinfo(String t) { 
    //     id = t; 
        
    // } 
    public issuedbookinfo(String n, String mid) {
         
        name = n;
        id = mid;
    } 

public String toString(){ 
    return "Name: " + " \t  " + name + "\t\t\t\t | " + "memberid:" + "  \t " + id; 
}
    
}