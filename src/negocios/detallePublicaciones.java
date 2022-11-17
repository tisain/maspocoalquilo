package negocios;

import conexion.conexion;
import static conexion.conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.lang.String;
import static java.lang.String.valueOf;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.management.Query;
import static javax.swing.UIManager.getInt;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Santiago
 */
public class detallePublicaciones {

    private int idDetalle;
    private usuarios nombreUsuarioDetalle;
    private String emailUsuarioDetalle;
    private inmuebles tipoInmuebleDetalle;
    private String lugarInmuebleDetalle;
    private String direccionInmuebleDetalle;
    private int numeroInmuebleDetalle;
    private boolean operacionInmuebleDetalle;
    private int precioInmuebleDetalle;

    public detallePublicaciones() {
    }

    //CONSTRUCTOR AGREGAR DETALLE
    public detallePublicaciones(usuarios nombreUsuarioDetalle, String emailUsuarioDetalle, inmuebles tipoInmuebleDetalle, String lugarInmuebleDetalle, String direccionInmuebleDetalle, int numeroInmuebleDetalle, boolean operacionInmuebleDetalle, int precioInmuebleDetalle) {
        this.nombreUsuarioDetalle = nombreUsuarioDetalle;
        this.emailUsuarioDetalle = emailUsuarioDetalle;
        this.tipoInmuebleDetalle = tipoInmuebleDetalle;
        this.lugarInmuebleDetalle = lugarInmuebleDetalle;
        this.direccionInmuebleDetalle = direccionInmuebleDetalle;
        this.numeroInmuebleDetalle = numeroInmuebleDetalle;
        this.operacionInmuebleDetalle = operacionInmuebleDetalle;
        this.precioInmuebleDetalle = precioInmuebleDetalle;
    }

    //METODOS GET
    public int getIdDetalle() {
        return idDetalle;
    }

    public usuarios getNombreUsuarioDetalle() {
        return nombreUsuarioDetalle;
    }

    public String getEmailUsuarioDetalle() {
        return emailUsuarioDetalle;
    }

    public inmuebles getTipoInmuebleDetalle() {
        return tipoInmuebleDetalle;
    }

    public String getLugarInmuebleDetalle() {
        return lugarInmuebleDetalle;
    }

    public String getDireccionInmuebleDetalle() {
        return direccionInmuebleDetalle;
    }

    public int getNumeroInmuebleDetalle() {
        return numeroInmuebleDetalle;
    }

    public boolean isOperacionInmuebleDetalle() {
        return operacionInmuebleDetalle;
    }

    public int getPrecioInmuebleDetalle() {
        return precioInmuebleDetalle;
    }

    //METODOS SET
    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public void setNombreUsuarioDetalle(usuarios nombreUsuarioDetalle) {
        this.nombreUsuarioDetalle = nombreUsuarioDetalle;
    }

    public void setEmailUsuarioDetalle(String emailUsuarioDetalle) {
        this.emailUsuarioDetalle = emailUsuarioDetalle;
    }

    public void setTipoInmuebleDetalle(inmuebles tipoInmuebleDetalle) {
        this.tipoInmuebleDetalle = tipoInmuebleDetalle;
    }

    public void setLugarInmuebleDetalle(String lugarInmuebleDetalle) {
        this.lugarInmuebleDetalle = lugarInmuebleDetalle;
    }

    public void setDireccionInmuebleDetalle(String direccionInmuebleDetalle) {
        this.direccionInmuebleDetalle = direccionInmuebleDetalle;
    }

    public void setNumeroInmuebleDetalle(int numeroInmuebleDetalle) {
        this.numeroInmuebleDetalle = numeroInmuebleDetalle;
    }

    public void setOperacionInmuebleDetalle(boolean operacionInmuebleDetalle) {
        this.operacionInmuebleDetalle = operacionInmuebleDetalle;
    }

    public void setPrecioInmuebleDetalle(int precioInmuebleDetalle) {
        this.precioInmuebleDetalle = precioInmuebleDetalle;
    }

    public static void agregarDetallePublicacion(detallePublicaciones detallePublicacion) throws ParseException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            conn = getConexion();
            stmt = conn.prepareStatement("INSERT INTO detallepublicacion (publicacion_id,usuarios_nombre,usuarios_email,tipo,inmueble_lugar,inmueble_direccion,inmueble_numero,inmueble_operacion,inmueble_precio) VALUES (?,?,?,?,?,?,?,?,?)");

            ResultSet resultados = null;
            resultados = stmt.executeQuery("SELECT id FROM publicacion");
            if (resultados.next()) {
                resultados.last();
            }

            int idPublicacion = resultados.getInt("id");

            stmt.setInt(1, idPublicacion);
            stmt.setString(2, (valueOf(detallePublicacion.getNombreUsuarioDetalle())));
            stmt.setString(3, detallePublicacion.getEmailUsuarioDetalle());
            stmt.setString(4, (valueOf(detallePublicacion.getTipoInmuebleDetalle())));
            stmt.setString(5, detallePublicacion.getLugarInmuebleDetalle());
            stmt.setString(6, detallePublicacion.getDireccionInmuebleDetalle());
            stmt.setInt(7, detallePublicacion.getNumeroInmuebleDetalle());
            stmt.setBoolean(8, detallePublicacion.isOperacionInmuebleDetalle());
            stmt.setInt(9, detallePublicacion.getPrecioInmuebleDetalle());

            boolean ejecutar = conexion.ejecutar(stmt);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public DefaultTableModel getDetalles(int numero) {

        DefaultTableModel datos = new DefaultTableModel();
        datos.addColumn("Usuario");
        datos.addColumn("Email");
        datos.addColumn("Inmueble");
        datos.addColumn("Lugar");
        datos.addColumn("Direccion");
        datos.addColumn("Numero");
        datos.addColumn("Operacion");
        datos.addColumn("Precio");

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        


        try {
            conn = getConexion();
            stmt = conn.prepareStatement("SELECT * FROM detallepublicacion WHERE publicacion_id = ?");
            stmt.setInt(1, numero);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[8];
                fila[0] = rs.getString("usuarios_nombre");
                fila[1] = rs.getString("usuarios_email");
                fila[2] = rs.getString("tipo");
                fila[3] = rs.getString("inmueble_lugar");
                fila[4] = rs.getString("inmueble_direccion");
                fila[5] = rs.getInt("inmueble_numero");
                
                fila[6] = rs.getBoolean("inmueble_operacion");
                
                
                fila[7] = rs.getInt("inmueble_precio");
                datos.addRow(fila);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return datos;
    }



}
