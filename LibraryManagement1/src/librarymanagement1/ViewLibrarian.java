
package librarymanagement1;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewLibrarian extends JFrame  {
    
    String x []={"Id","name","email","password","contact","address","city"} ;
        JButton bt;
        String y [][]= new String [20][7];
        int i=0,j=0;
        JTable t;
        Font f,f1;

    ViewLibrarian() {
        
        super("Librarian Information");
        setLocation(1,1);
        setSize(1000,400);
        
        f = new Font("Arial", Font.BOLD, 15);
        
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select * from librarian";
            ResultSet rs=obj.s.executeQuery(q);
            
             if(rs.next()){
                 
                 y[i][j++] = rs.getString("Lid");
                 y[i][j++] = rs.getString("name");
                 y[i][j++] = rs.getString("password");
                 y[i][j++] = rs.getString("email");
                 y[i][j++] = rs.getString("contact");
                 y[i][j++] = rs.getString("address");
                 y[i][j++] = rs.getString("city");
                 
                 i++;
                 j=0;
                 
             }
             t=new JTable(y,x);
             t.setFont(f);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        JScrollPane sp= new JScrollPane(t);
        add(sp);

}
  
    
    public static void main (String[] args) {
      
        new ViewLibrarian().setVisible(true);
  }
}
