/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Project;

import java.awt.Component;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ANSHIKA
 */
public class Database {
    
    static Connection connection;
    static String role;
    
    public static boolean connectDatabse(Component parent, String username, String password) {
        
        String url = "jdbc:mysql://localhost:3306/REAL_ESTATE";
        
        try {
            Database.connection = DriverManager.getConnection(url, username, password);
            PreparedStatement st = Database.connection.prepareStatement("Select role from Role where username = ?");
            st.setString(1, username);
            ResultSet res = st.executeQuery();
            res.next();
            Database.role = res.getString(1);
            return true;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(parent, "Incorrect username or password");
            return false;
//            System.out.println("SQL Exception: " + e);
//            System.exit(0);
        }
    }
    
}
