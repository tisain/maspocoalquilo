/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

import conexion.conexion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class usuarios extends conexion {

    private int id;
    private String usuario;
    private String contrasena;
    private String nombreUsuario;
    private int dniUsuario;
    private String emailUsuario;
    private String localidadUsuario;
    private int cpUsuario;
    private boolean tipoUsuario;
    
    
    //CONSTRUCTOR

    public usuarios() {
    }
    
    //COMBO BOX

    public usuarios(int id, String nombreUsuario, String emailUsuario) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
    }

    public String toString(){
        return id + "-" + nombreUsuario;
    }


    
    
    
    //CONSTRUCTOR PARA LEER DATOS
    public usuarios(int id, String usuario, String contrasena, String nombreUsuario, int dniUsuario, String emailUsuario, String localidadUsuario, int cpUsuario, String fechaRegistroUsuario, boolean tipoUsuario) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
        this.dniUsuario = dniUsuario;
        this.emailUsuario = emailUsuario;
        this.localidadUsuario = localidadUsuario;
        this.cpUsuario = cpUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    //CONSTRUCTOR PARA MOSTRAR TABLA Y MODIFICAR
    public usuarios(int id, String usuario, String nombreUsuario, int dniUsuario, String emailUsuario, String localidadUsuario, int cpUsuario, boolean tipoUsuario) {
        this.id = id;
        this.usuario = usuario;
        this.nombreUsuario = nombreUsuario;
        this.dniUsuario = dniUsuario;
        this.emailUsuario = emailUsuario;
        this.localidadUsuario = localidadUsuario;
        this.cpUsuario = cpUsuario;
        this.tipoUsuario = tipoUsuario;
    }
    

    //CONSTRUCTOR PARA CARGAR
    public usuarios(String usuario, String contrasena, String nombreUsuario, int dniUsuario, String emailUsuario, String localidadUsuario, int cpUsuario, boolean tipoUsuario) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
        this.dniUsuario = dniUsuario;
        this.emailUsuario = emailUsuario;
        this.localidadUsuario = localidadUsuario;
        this.cpUsuario = cpUsuario;
        this.tipoUsuario = tipoUsuario;
    }
    
    //CONSTRUCTOR PARA ELIMINAR
    public usuarios(int id) {
        this.id = id;
    }
    

    //METODOS GET
    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getDniUsuario() {
        return dniUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public String getLocalidadUsuario() {
        return localidadUsuario;
    }

    public int getCpUsuario() {
        return cpUsuario;
    }

    public boolean isTipoUsuario() {
        return tipoUsuario;
    }

    //METODOS SET
    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setDniUsuario(int dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public void setLocalidadUsuario(String localidadUsuario) {
        this.localidadUsuario = localidadUsuario;
    }

    public void setCpUsuario(int cpUsuario) {
        this.cpUsuario = cpUsuario;
    }

    public void setTipoUsuario(boolean tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    //REGRESAR LISTA USUARIOS
    public static ArrayList<usuarios> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        usuarios user = null;
        ArrayList usuariosLista = new ArrayList<>();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement("SELECT id, user, nombre, dni, email, localidad, cp, tipo FROM usuarios");
            rs = conexion.devolverLista(stmt);

            while (rs.next()) {
                int id = rs.getInt("id");
                String usuario = rs.getString("user");
                String nombreUsuario = rs.getString("nombre");
                int dniUsuario = rs.getInt("dni");
                String emailUsuario = rs.getString("email");
                String localidadUsuario = rs.getString("localidad");
                int cpUsuario = rs.getInt("cp");
                boolean tipoUsuario = rs.getBoolean("tipo");

                user = new usuarios(id, usuario, nombreUsuario, dniUsuario, emailUsuario, localidadUsuario, cpUsuario, tipoUsuario);

                usuariosLista.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return usuariosLista;
    }

    //METODO PARA AGREGAR
    public static void agregarUsuario(usuarios usuario) throws ParseException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            boolean tipousuario;
            if (usuario.isTipoUsuario() == true) {
                tipousuario = true;
            } else {
                tipousuario = false;
            }

            conn = getConexion();
            stmt = conn.prepareStatement("INSERT INTO usuarios (user, contrasena, nombre, dni, email, localidad, cp, tipo) VALUES (?,?,?,?,?,?,?,?)");

            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContrasena());
            stmt.setString(3, usuario.getNombreUsuario());
            stmt.setInt(4, usuario.getDniUsuario());
            stmt.setString(5, usuario.getEmailUsuario());
            stmt.setString(6, usuario.getLocalidadUsuario());
            stmt.setInt(7, usuario.getCpUsuario());
            stmt.setBoolean(8, tipousuario);

            boolean ejecutar = conexion.ejecutar(stmt);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //METODO PARA MODIFICAR
    public static void modificarUsuario(usuarios usuario) throws ParseException, SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            boolean tipousuario;
            if (usuario.isTipoUsuario() == true) {
                tipousuario = true;
            } else {
                tipousuario = false;
            }
            conn = getConexion();
            stmt = conn.prepareStatement("UPDATE usuarios SET user = ?, nombre = ?, dni = ?, email = ?, localidad = ?, cp = ?, tipo = ? WHERE id = ?");

            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getNombreUsuario());
            stmt.setInt(3, usuario.getDniUsuario());
            stmt.setString(4, usuario.getEmailUsuario());
            stmt.setString(5, usuario.getLocalidadUsuario());
            stmt.setInt(6, usuario.getCpUsuario());
            stmt.setBoolean(7, tipousuario);
            stmt.setInt(8, usuario.getId());

            boolean ejecutar = conexion.ejecutar(stmt);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    //ELIMINAR USUARIO  
    public static void eliminar(usuarios usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConexion();
            stmt = conn.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            stmt.setInt(1, usuario.getId());
            
            boolean ejecutar = conexion.ejecutar(stmt);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
