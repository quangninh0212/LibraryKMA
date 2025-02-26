/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author admin
 */
import java.sql.Connection;
import java.sql.DriverManager;


public class DAO {
    protected static Connection con;
    
    public DAO() {
        String url = "";
        String username = "";
        String password = "";
        
        if(con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, username, password);
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
