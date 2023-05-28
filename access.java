
package pkgfor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class For {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/workers?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "pass1234");

            String query = "SELECT * FROM infos";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                System.out.println(name + " " + age + " " + address);
            }
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}








         
           
             
       
        
      
      
    
    

