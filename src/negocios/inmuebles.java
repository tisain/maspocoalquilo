/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

import conexion.conexion;
import static conexion.conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class inmuebles extends conexion {
        private int id;
        private String tipo;
        private String lugar;
        private String direccion;
        private int numero;
        private boolean operacion;
        private int precio;

    public inmuebles() {
    }
        
    
        
    //COMBO BOX
    
    public String toString(){
        return id + "-" + tipo;
    }    
        
    //CONSTRUCTOR PARA LEER DATOS, MOSTRAR TABLA Y MODIFICAR

    public inmuebles(int id, String tipo, String lugar, String direccion, int numero, boolean operacion, int precio) {
        this.id = id;
        this.tipo = tipo;
        this.lugar = lugar;
        this.direccion = direccion;
        this.numero = numero;
        this.operacion = operacion;
        this.precio = precio;
    }
        
    //CONSTRUCTOR PARA GUARDAR DATOS

    public inmuebles(String tipo, String lugar, String direccion, int numero, boolean operacion, int precio) {
        this.tipo = tipo;
        this.lugar = lugar;
        this.direccion = direccion;
        this.numero = numero;
        this.operacion = operacion;
        this.precio = precio;
    }
    
    //CONSTRUCTOR PARA ELIMINAR

    public inmuebles(int id) {
        this.id = id;
    }
    
    //METODOS GET

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLugar() {
        return lugar;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOperacion() {
        return operacion;
    }

    public int getPrecio() {
        return precio;
    }
    
    
    
    //METODOS SET

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setOperacion(boolean operacion) {
        this.operacion = operacion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    //REGRESAR LISTA INMUEBLES
    public static ArrayList<inmuebles> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        inmuebles inmueble = null;
        ArrayList inmueblesLista = new ArrayList<>();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement("SELECT id, tipo, lugar, direccion, numero, operacion, precio FROM inmueble");
            rs = conexion.devolverLista(stmt);

            while (rs.next()) {
                int id = rs.getInt("id");
                String tipoInmueble = rs.getString("tipo");
                String lugarInmueble = rs.getString("lugar");
                String direccionInmueble = rs.getString("direccion");
                int numeroInmueble = rs.getInt("numero");
                boolean operacionInmueble = rs.getBoolean("operacion");
                int precioInmueble = rs.getInt("precio");

                inmueble = new inmuebles(id, tipoInmueble, lugarInmueble, direccionInmueble, numeroInmueble, operacionInmueble, precioInmueble);

                inmueblesLista.add(inmueble);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return inmueblesLista;
    }
    
    //METODO PARA AGREGAR
    public static void agregarInmueble(inmuebles inmueble) throws ParseException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            boolean tipooperacion;
            if (inmueble.isOperacion()== true) {
                tipooperacion = true;
            } else {
                tipooperacion = false;
            }

            conn = getConexion();
            stmt = conn.prepareStatement("INSERT INTO inmueble (tipo, lugar, direccion, numero, operacion, precio) VALUES (?,?,?,?,?,?)");

            stmt.setString(1, inmueble.getTipo());
            stmt.setString(2, inmueble.getLugar());
            stmt.setString(3, inmueble.getDireccion());
            stmt.setInt(4, inmueble.getNumero());
            stmt.setBoolean(5, inmueble.isOperacion());
            stmt.setInt(6, inmueble.getPrecio());


            boolean ejecutar = conexion.ejecutar(stmt);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}



