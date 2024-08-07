
package librarymanagement1;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AddBook extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,l4,l5,l6;
    JButton bt1,bt2;
    JPanel p1,p2;
    JTextField tf1,tf2,tf3,tf4,tf5;
    Font f,f1;
    
    AddBook(){
        
        super("Add Librarian");
        setLocation(450,400);
        setSize(650,400);
        
         f = new Font("Arial", Font.BOLD, 25);
        f1 = new Font("Arial", Font.BOLD, 20);
        
         
        l1 = new JLabel("Add Book");
        l2 = new JLabel("Book NO");
        l3 = new JLabel("Book Name");
        l4 = new JLabel("Author");
        l5 = new JLabel("Publisher");
        l6 = new JLabel("Quantity");

        
        tf1= new JTextField();
        tf2= new JTextField();
        tf3= new JTextField();
        tf4= new JTextField();
        tf5= new JTextField();
        
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);

        
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        
        
        bt1 = new JButton("Add Book");
        bt2 = new JButton("Cancel");
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
         l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.WHITE);
        
        p1= new JPanel ();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);
        p1.setBackground(Color.BLUE);
        
        p2= new JPanel ();
        p2.setLayout(new GridLayout(6, 2, 10, 10));
       
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(l4);
        p2.add(tf3);
        p2.add(l5);
        p2.add(tf4);
        p2.add(l6);
        p2.add(tf5);
        p2.add(bt1);
        p2.add(bt2);
        
        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "Center");
        
    }
    public void actionPerformed(ActionEvent ae) {
        
     String date= new java.util.Date().toString();   
     String bookno= tf1.getText();
     String bookn= tf2.getText();
     String author= tf3.getText();
     String publisher= tf4.getText();
     String quantity= tf5.getText();
     
     
      if(ae.getSource() == bt1) {
         
          try {
                
                 ConnectionClass conn = new ConnectionClass();
                 String query = "insert into book (date,bookno,BookName,Author,Publisher,Quantity) value('"+date+"','"+bookno+"', '"+bookn+"', '"+author+"', '"+publisher+"', '"+quantity+"')";    
                 int aa = conn.s.executeUpdate(query); 
                 if (aa==1){
                     
                     JOptionPane.showMessageDialog(null, "your data is successfully inserted");
                     this.setVisible(false);
                     
                 }
                 else {
                     JOptionPane.showMessageDialog(null, "please, Fill all details carefully");
                     this.setVisible(true);
                 }
                    
                }
                catch (Exception e){
                
                e.printStackTrace();
               
            } 
                
            }
         
     if(ae.getSource() == bt2) {
         
         this.setVisible(false);
         new LibrarianSection().setVisible(true);
         
     }
        
    }
    public static void main (String[] args) {
      
        new AddBook().setVisible(true);
  }  
    
}
