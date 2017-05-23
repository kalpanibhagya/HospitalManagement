
package secure;

import java.sql.*;
import javax.swing.*;
    

public class MySqlConnect {
    Connection conn = null;
    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms?zeroDateTimeBehavior=convertToNull","root","");
            //JOptionPane.showMessageDialog(null, "Connected to Database");
            return conn;
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
}


