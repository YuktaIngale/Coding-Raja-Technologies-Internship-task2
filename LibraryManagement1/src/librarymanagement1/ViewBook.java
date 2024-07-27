
package librarymanagement1;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewBook extends JFrame  {
    
    String x []={"Id","date","bookno","BookName","Author","Publisher","Quantity"} ;
        JButton bt;
        String y [][]= new String [20][7];
        int i=0,j=0;
        JTable t;
        Font f,f1;
    
    ViewBook(){
         super("Book Information");
        setLocation(1,1);
        setSize(1000,400);
        
        f = new Font("Arial", Font.BOLD, 15);
        
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select * from book";
            ResultSet rs=obj.s.executeQuery(q);
            
             if(rs.next()){
                 
                 y[i][j++] = rs.getString("Lid");
                 y[i][j++] = rs.getString("date");
                 y[i][j++] = rs.getString("bookno");
                 y[i][j++] = rs.getString("BookName");
                 y[i][j++] = rs.getString("Author");
                 y[i][j++] = rs.getString("Publisher");
                 y[i][j++] = rs.getString("Quantity");
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
      
        new ViewBook().setVisible(true);
  }  
}
