
package librarymanagement1;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AdminSection extends JFrame implements ActionListener {
    
    JLabel l1;
    JButton bt1;
    JPanel p1, p2;
    Font f, f1;
    JMenuItem me1,me2,me3,me4;
     
     
    AdminSection(){
        
        super("Admin Page");
        setLocation(0,0);
        setSize(1500,800);
        
        
        f = new Font("Arial", Font.BOLD, 25);
        f1 = new Font("Arial", Font.BOLD, 20);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon1/admin.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1 = new JLabel(i3);
        
        JMenuBar m1= new JMenuBar();
        JMenu mm1 = new JMenu("Add Info");
         me1= new JMenuItem("add Librarian");
        
        JMenu mm2 = new JMenu("View Info");
         me2= new JMenuItem("View Librarian");
        
        JMenu mm3 = new JMenu("Delete Info");
         me3= new JMenuItem("Delete Librarian");
         
        JMenu mm4 = new JMenu("Exit");
         me4= new JMenuItem("Log Out");
        
        
        mm1.add(me1);
        mm2.add(me2);
        mm3.add(me3);
        mm4.add(me4);
        
        m1.add(mm1);
        m1.add(mm2);
        m1.add(mm3);
        m1.add(mm4);
        
        
        mm1.setFont(f1);
        mm2.setFont(f1);
        mm3.setFont(f1);
        mm4.setFont(f1);
        
        me1.setFont(f);
        me2.setFont(f);
        me3.setFont(f);
        me4.setFont(f);
        
        me1.addActionListener(this);
        me2.addActionListener(this);
        me3.addActionListener(this);
        me4.addActionListener(this);
        
        setJMenuBar(m1);
        add(l1);
    }
    
  public void actionPerformed(ActionEvent ae){

      String comd = ae.getActionCommand();
      if(ae.getSource() == me1){
           this.setVisible(false);
        new AddLibrarian().setVisible(true);
          
      }
      else if(ae.getSource() == me2) {
          new ViewLibrarian().setVisible(true);
      }
      else if(ae.getSource() == me3) {
          new DeleteLibrarian().setVisible(true);
      }
      else if(ae.getSource() == me4) {
          System.exit(0);
      }
  }
  
  public static void main (String[] args) {
      
        new AdminSection().setVisible(true);
  }     
    
}
