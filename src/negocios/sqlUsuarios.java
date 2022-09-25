package negocios;

import com.mysql.jdbc.ResultSet;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pantalla.homeAdm;
import pantalla.homeAgente;
import pantalla.homeCliente;
import static pantalla.registro.comoTipo;
import static pantalla.registro.emailTxt;
import static pantalla.registro.nameTxt;
import static pantalla.registro.pwRegTxt;
import static pantalla.registro.surnameTxt;
import static pantalla.registro.userRegTxt;


public class sqlUsuarios extends conexion.conexion {

    //metodo para insertar
    public static void leerDatosPersonaAgregar() {
        sqlUsuarios modSql = new sqlUsuarios();
        usuarios mod = new usuarios();

        if (userRegTxt.getText().equals("") || surnameTxt.getText().equals("") || pwRegTxt.getText().equals("") || nameTxt.getText().equals("") || emailTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Hay campos vacios");
        } else {
            
                
                mod.setUsuario(userRegTxt.getText());
                mod.setContrasena(pwRegTxt.getText());
                mod.setNombre(nameTxt.getText());
                mod.setApellido(surnameTxt.getText());
                mod.setEmail(emailTxt.getText());
                mod.setTipousuario(comoTipo.getSelectedIndex());
                
                if (modSql.registrar(mod)) {
                    JOptionPane.showMessageDialog(null, "Registro guardado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                }


        }
    }

    public boolean registrar(usuarios usr) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO usuarios (usuario, contrasena, nombre, apellido, email, tipo_usuario) VALUES (?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getContrasena());
            ps.setString(3, usr.getNombre());
            ps.setString(4, usr.getApellido());
            ps.setString(5, usr.getEmail());
            ps.setInt(6, usr.getTipousuario());

            ps.execute();

            return true;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(sqlUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

            return false;
        }
    }

    //validacion usuario ya agregado
    public int existeUsuario(String usuario) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT count (id) FROM usuarios WHERE usuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = (ResultSet) ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 1;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(sqlUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

            return 1;
        }
    }

    //verificar inicio de sesion
    public boolean login(usuarios usr) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT id, usuario, contrasena, nombre, tipo_usuario FROM usuarios WHERE usuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = (ResultSet) ps.executeQuery();

            if (rs.next()) {

                if (usr.getContrasena().equals(rs.getString(3))) {

                    usr.setId(rs.getInt(1));
                    usr.setNombre(rs.getString(4));
                    usr.setTipousuario(rs.getInt(5));

                    return true;

                } else {
                    return false;
                }
            }

            return false;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(sqlUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

            return false;
        }
    }

    public static void inicioSesion() {
        sqlUsuarios modSql = new sqlUsuarios();
        usuarios mod = new usuarios();

        if (!pantalla.inicio.userTxt.getText().equals("") && !pantalla.inicio.pwTxt.getText().equals("")) {

            mod.setUsuario(pantalla.inicio.userTxt.getText());
            mod.setContrasena(pantalla.inicio.pwTxt.getText());

            if (modSql.login(mod)) {

                if (mod.getTipousuario() == 1) {
                    homeAgente inicioHome = new homeAgente();
                    inicioHome.setVisible(true);
                } else if (mod.getTipousuario() == 2) {
                    homeCliente inicioHome = new homeCliente();
                    inicioHome.setVisible(true);
                } else if (mod.getTipousuario() == 3) {
                    homeAdm inicioHome = new homeAdm();
                    inicioHome.setVisible(true);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar sus datos");
        }

    }

}
