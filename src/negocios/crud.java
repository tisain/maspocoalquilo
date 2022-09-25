/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static pantalla.homeAdm.comoTipo;
import static pantalla.homeAdm.emailTxt;
import static pantalla.homeAdm.nameTxt;
import static pantalla.homeAdm.pwRegTxt;
import static pantalla.homeAdm.surnameTxt;
import static pantalla.homeAdm.userRegTxt;


public class crud extends conexion.conexion {
    //metodo para insertar
    public static void guardarDatosPersonaAgregar() {
        crud modSql = new crud();
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
    
}
