package librarymanagement1;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;


    public class DeleteLibrarian extends JFrame implements ActionListener {

        String x []={"Id","name","email","password","contact","address","city"} ;
        JButton bt;
        String y [][]= new String [20][7];
        int i=0,j=0;
        JTable t;
        Font f,f1;
        JTextField tf1;
        JPanel p1;
        JLabel l1;
        
        
    DeleteLibrarian() {
        
        super("Delete Librarian");
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
        l1= new JLabel("Delete Librarian");
        tf1= new JTextField();
        bt= new JButton("Delete");
        bt.addActionListener(this);
        
        
        l1.setFont(f);
        tf1.setFont(f);
        bt.setFont(f);
        
        p1= new JPanel();
        p1.setLayout(new GridLayout(1,3,10,10) );
        p1.add(l1);
        p1.add(tf1);
        p1.add(bt);
        
        setLayout(new BorderLayout(10, 10));
        add(sp, "Center");
        add(p1, "South");
                

}
  
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == bt) {
            
            int id= Integer.parseInt(tf1.getText());
            try {
                
            ConnectionClass conn = new ConnectionClass();
            String q = "delete  from librarian where Lid= '"+id+"'";
            int rs=  conn.s.executeUpdate(q);
            if (rs==1) {
                
                JOptionPane.showMessageDialog(null, "Your data is successfully deleted");
                this.setVisible(false);
                new DeleteLibrarian().setVisible(true);
                
            }
            else {
               JOptionPane.showMessageDialog(null, "Your data is not successfully deleted"); 
            }
                
            } catch (Exception e){
              e.printStackTrace();
            }
            
        }

}
    
    public static void main (String[] args) {
      
        new DeleteLibrarian().setVisible(true);
  }
}

    

