
package librarymanagement1;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;


public class LibrarianSection extends JFrame implements ActionListener {
    
     JLabel l1;
    JButton bt1;
    JPanel p1, p2;
    Font f, f1;
    JMenuItem me1,me2,me3,me4,me5,me6;
    
    LibrarianSection(){
        
        super("Librarian Page");
        setLocation(0,0);
        setSize(1500,800);
        
        f = new Font("Arial", Font.BOLD, 25);
        f1 = new Font("Arial", Font.BOLD, 20);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon1/librarian.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1 = new JLabel(i3);
        
        JMenuBar m1= new JMenuBar();
        JMenu mm1 = new JMenu("Add Info");
         me1= new JMenuItem("add Book");
        
        JMenu mm2 = new JMenu("View Info");
         me2= new JMenuItem("View Book");
         me3= new JMenuItem("View issue Book");
        
        JMenu mm3 = new JMenu("issue Info");
         me4= new JMenuItem("issue Book");
         
        JMenu mm4 = new JMenu("Return Book");
         me5= new JMenuItem("Return Book");
         
        JMenu mm5 = new JMenu("Exit");
         me6= new JMenuItem("Log Out");
         
        mm1.add(me1);
        mm2.add(me2);
        mm2.add(me3);
        mm3.add(me4);
        mm4.add(me5);
        mm5.add(me6);
        
        m1.add(mm1);
        m1.add(mm2);
        m1.add(mm3);
        m1.add(mm4);
        m1.add(mm5);
        
        
        mm1.setFont(f1);
        mm2.setFont(f1);
        mm3.setFont(f1);
        mm4.setFont(f1);
        mm5.setFont(f1);
        
        me1.setFont(f);
        me2.setFont(f);
        me3.setFont(f);
        me4.setFont(f);
        me5.setFont(f);
        me6.setFont(f);
        
        me1.addActionListener(this);
        me2.addActionListener(this);
        me3.addActionListener(this);
        me4.addActionListener(this);
        me5.addActionListener(this);
        me6.addActionListener(this);
        
        setJMenuBar(m1);
        add(l1);
        
    }
    public void actionPerformed(ActionEvent ae) {
        
        String comd = ae.getActionCommand();
      if(ae.getSource() == me1){
           this.setVisible(false);
        new AddBook().setVisible(true);
          
      }
      else if(ae.getSource() == me2) {
        new ViewBook().setVisible(true);
         
      }
     
      else if(ae.getSource() == me4) {
        new IssueBook().setVisible(true);
          
      }
      else if(ae.getSource() == me5) {
        new ReturnBook().setVisible(true);
          
      }
      else if(ae.getSource() == me6) {
          System.exit(0);
      }
        
    }
    public static void main (String[] args) {
      
        new LibrarianSection().setVisible(true);
  }     
    
}
