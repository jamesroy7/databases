
package login_system;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class MyFrame extends JFrame implements ActionListener{
    
    
    
    
    JLabel user_lbl,pass_lbl;
    JTextField userF,passF;
    JButton okB,backB;
    
    
    
    
    
    
    MyFrame(){
        
       user_lbl = new JLabel("USERNAME:");
       userF = new JTextField();
       userF.setPreferredSize(new Dimension(100,20));
        
       
          
       pass_lbl = new JLabel("PASSWORD:");
       passF = new JTextField();
       passF.setPreferredSize(new Dimension(100,20));
       
       okB = new JButton("OK");
       okB.addActionListener(this);
       
       backB = new JButton("BACK");
       backB.addActionListener(this);
       
       
        
        
        
        
        
        
        
        
        
        
        
        
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setTitle("mydb");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(user_lbl);
        this.add(userF);
         this.add(pass_lbl);
        this.add(passF);
       this.add(okB);
       this.add(backB);
       
       
    
    
    
    }

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==okB){
        
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/login_system?zeroDateTimeBehavior=CONVERT_TO_NULL";
                String username = "administrator";
                String password= "pass1234";
                Connection con = DriverManager.getConnection(url,username,password);
                String move = "INSERT INTO info(username,pass) VALUES(?,?)";
                PreparedStatement pst =con.prepareStatement(move);
                pst.setString(1,userF.getText());
                pst.setString(2,passF.getText());
                
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(null, "INSERTION SUCCESSFUL");
                  con.close();
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "INSERTION UNSUCCESSFUL");
            }
            
            if(e.getSource()== backB){
             JOptionPane.showMessageDialog(null, "YOU PRESS BACK");
             this.dispose();
            }
        }
    }
    
}
