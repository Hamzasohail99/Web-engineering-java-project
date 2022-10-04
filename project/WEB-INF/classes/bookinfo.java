public class bookinfo {
    
    String name;
    String id;
    public bookinfo(String n, String mid) {
         
        name = n;
        id = mid;
    } 

public String toString(){ 
    return "Name: " + " \t  " + name + "\t\t\t\t | " + "status:" + "  \t " + id; 
}
    
}
