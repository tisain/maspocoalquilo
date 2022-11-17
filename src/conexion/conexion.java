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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Santiago
 */
public class conexion {

    private static final String base = "maspocoalquilo";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3308/" + base;
    public static Connection con;
    
    
    //METODO CONEXION
    public static Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }
    
    //METODO EJECUTAR - AGREGA, MODIFICA Y ELIMINA
    public static boolean ejecutar(PreparedStatement stmt) throws SQLException {
        stmt.executeUpdate();
        return true;
    }
    
    //METODO MOSTRAR LISTA
    public static ResultSet devolverLista (PreparedStatement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery();
        return rs;
    }
    
    
    
}
