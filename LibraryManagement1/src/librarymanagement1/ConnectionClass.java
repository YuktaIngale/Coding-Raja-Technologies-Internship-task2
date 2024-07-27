
package librarymanagement1;

import java.sql.*;


public class ConnectionClass {

    Connection c; 
    Statement s;
    public ConnectionClass(){
        try {
            c = DriverManager.getConnection("jdbc:mysql:///librarymanagement1","root", "yukta2003");
            s = c.createStatement();
            
        } catch (Exception e) {
            System.out.print(e);
        }
        
        
    }

   
            
    
}

