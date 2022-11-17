
package negocios;

import conexion.conexion;
import static conexion.conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class publicaciones extends conexion{
    private int idPublicacion;
    private String fechaPublicacion;
    private boolean estadoPublicacion;

    public publicaciones() {
    }

    //PARA AGREGAR PUBLICACION
    public publicaciones(String fechaPublicacion, boolean estadoPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
        this.estadoPublicacion = estadoPublicacion;
    }

    public publicaciones(int idPublicacion, String fechaPublicacion, boolean estadoPublicacion) {
        this.idPublicacion = idPublicacion;
        this.fechaPublicacion = fechaPublicacion;
        this.estadoPublicacion = estadoPublicacion;
    }
    
    //METODOS GET PUBLICACIONES
    public int getIdPublicacion() {
        return idPublicacion;
    }
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }
    public boolean isEstadoPublicacion() {
        return estadoPublicacion;
    }
    //METODOS SET PUBLICACIONES
    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public void setEstadoPublicacion(boolean estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }
    
    //METODO PARA AGREGAR MAESTRO PUBLICACION
    public static void agregarMaestroPublicacion(publicaciones publicacion) throws ParseException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            
            String fechaPubli = publicacion.getFechaPublicacion();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilFechaPubli = sdf1.parse(fechaPubli);
            java.sql.Date sqlFechaPubli = new java.sql.Date(utilFechaPubli.getTime());

            conn = getConexion();
            stmt = conn.prepareStatement("INSERT INTO publicacion (fecha,estado) VALUES (?,?)");

            stmt.setDate(1, sqlFechaPubli);
            stmt.setBoolean(2, publicacion.isEstadoPublicacion());

            boolean ejecutar = conexion.ejecutar(stmt);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    //MOSTRAR PUBLICACIONES
    public static ArrayList<publicaciones> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        publicaciones publicacion = null;
        ArrayList publicacionesLista = new ArrayList<>();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement("SELECT id, fecha, estado FROM publicacion");
            rs = conexion.devolverLista(stmt);

            while (rs.next()) {
                int idPublicacion = rs.getInt("id");
                String fechaPubli = rs.getString("fecha");
                boolean estadoPubli = rs.getBoolean("estado");

                publicacion = new publicaciones(idPublicacion, fechaPubli, estadoPubli);

                publicacionesLista.add(publicacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return publicacionesLista;
    }
    
}


