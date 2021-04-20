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
    
    public static boolean connectDatabse(Component parent, String username, String password, String role) {
        
        String url = "jdbc:mysql://localhost:3306";
        
        try {
            Database.connection = DriverManager.getConnection(url, username, password);
            
//            System.out.println("came here");
            
            PreparedStatement st = Database.connection.prepareStatement("set role ?");
            st.setString(1, role);
            ResultSet res = st.executeQuery();
            
            System.out.println("came here");
            
            st = Database.connection.prepareStatement("use real_estate");
            
            Database.role = role;
            return true;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(parent, e.getMessage());
            
            return false;
        }
    }
    
}
