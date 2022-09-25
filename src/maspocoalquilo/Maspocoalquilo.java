
package maspocoalquilo;


import conexion.conexion;
import java.sql.Connection;
import java.sql.SQLException;
import pantalla.inicio;


public class Maspocoalquilo {

    public static void main(String[] args) throws SQLException{
        inicio login = new inicio();
        login.setVisible(true);
        
        conexion cn= new conexion();
        Connection con = cn.getConexion();
    }
}