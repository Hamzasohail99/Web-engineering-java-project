public class memberinfo {
    
    String name;
    String rollno; 
    String mid; 
    public memberinfo(String n, String rno, String id) {
         
        name = n;
        rollno = rno;
        mid = id;
    } 

    public String toString(){ 
        return "Name: " + " \t  " + name +  " | " + "\t" + "\t" + "\t" + "rollno:" + " \t  " + rollno + "  \t\t\t\t "+"| " + "memberid:" + "   " + mid; 
    }
}
