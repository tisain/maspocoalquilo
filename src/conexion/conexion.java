/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;


import com.mysql.jdbc.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Santiago
 */
public class conexion {
    private final String base = "login_mpa";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3308/"+base;
    public static Connection con = null;
    
    public Connection getConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex){
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
}
