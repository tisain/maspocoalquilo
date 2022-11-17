package pantalla;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import negocios.detallePublicaciones;
import negocios.inmuebles;
import negocios.publicaciones;
import negocios.usuarios;

/**
 *
 * @author Santiago
 */
public class homeAdm extends javax.swing.JFrame {

    private void imprimirTablaUsuarios(ArrayList<usuarios> usuariosLista) {
        usuariosLista.forEach(usuario -> {
            DefaultTableModel tablita = (DefaultTableModel) jtUsuarios.getModel();
            String tipo;
            if (usuario.isTipoUsuario() == true) {
                tipo = "Agente";
            } else {
                tipo = "Cliente";
            }
            tablita.addRow(new Object[]{usuario.getId(), usuario.getUsuario(), usuario.getNombreUsuario(), usuario.getDniUsuario(), usuario.getEmailUsuario(), usuario.getLocalidadUsuario(), usuario.getCpUsuario(), tipo});
        });
    }
    
    private void imprimirTablaInmuebles(ArrayList<inmuebles> inmueblesLista) {
        inmueblesLista.forEach(inmueble -> {
            DefaultTableModel tablitaInm = (DefaultTableModel) jtInmuebles.getModel();
            String tipo;
            if (inmueble.isOperacion() == true) {
                tipo = "Venta";
            } else {
                tipo = "Alquila";
            }
            tablitaInm.addRow(new Object[]{inmueble.getId(),inmueble.getTipo(),inmueble.getLugar(),inmueble.getDireccion(),inmueble.getNumero(),tipo,inmueble.getPrecio()});
        });
    }
    
    private void imprimirTablaPublicaciones(ArrayList<publicaciones> publicacionesLista) {
        publicacionesLista.forEach(publicacion -> {
            DefaultTableModel tablitaPub = (DefaultTableModel) jtMaestro.getModel();
            String estado;
            if (publicacion.isEstadoPublicacion() == true) {
                estado = "Disponible";
            } else {
                estado = "No disponible";
            }
            tablitaPub.addRow(new Object[]{publicacion.getIdPublicacion(),publicacion.getFechaPublicacion(),estado});
        });
    }

    private void vaciarTablaUsuarios() {
        DefaultTableModel tablita = (DefaultTableModel) jtUsuarios.getModel();
        tablita.setRowCount(0);
    }
    
    private void vaciarTablaInmuebles() {
        DefaultTableModel tablitaInm = (DefaultTableModel) jtInmuebles.getModel();
        tablitaInm.setRowCount(0);
    }
    
    private void vaciarTablaPublicaciones(){
        DefaultTableModel tablitaPub = (DefaultTableModel) jtMaestro.getModel();
        tablitaPub.setRowCount(0);
    }
    
    private void llenarUsuarios(){
        usuarios user = new usuarios();
        ArrayList <usuarios> listaNombre = usuarios.seleccionar();
        
        cbxNombre.removeAllItems();
        
        for(int i = 0; i < listaNombre.size(); i++){
            cbxNombre.addItem(new usuarios(listaNombre.get(i).getId(),listaNombre.get(i).getNombreUsuario(),listaNombre.get(i).getEmailUsuario()));
        }
    }
    
    private void llenadoCampos(){
        String correo = cbxNombre.getItemAt(cbxNombre.getSelectedIndex()).getEmailUsuario();
        campoEmailPubli.setText(correo);
    }
    
    private void llenarInmuebles(){
        inmuebles inm = new inmuebles();
        ArrayList <inmuebles> listaInmuebles = inmuebles.seleccionar();
        
        cbxInmueble.removeAllItems();
        
        for(int i=0;i<listaInmuebles.size();i++){
            cbxInmueble.addItem(new inmuebles(listaInmuebles.get(i).getId(),listaInmuebles.get(i).getTipo(),listaInmuebles.get(i).getLugar(),listaInmuebles.get(i).getDireccion(),listaInmuebles.get(i).getNumero(),listaInmuebles.get(i).isOperacion(),listaInmuebles.get(i).getPrecio()));
        }
    }
    
    private void llenadoCamposInm(){
        campoLugarPubli.setText(cbxInmueble.getItemAt(cbxInmueble.getSelectedIndex()).getLugar());
        campoDirePubli.setText(cbxInmueble.getItemAt(cbxInmueble.getSelectedIndex()).getDireccion());
        campoNumeroPubli.setText(String.valueOf(cbxInmueble.getItemAt(cbxInmueble.getSelectedIndex()).getNumero()));
        String tipoOperacion = (String.valueOf(cbxInmueble.getItemAt(cbxInmueble.getSelectedIndex()).isOperacion()));
        if (tipoOperacion == "true"){
            campoOperacionPubli.setText("Venta");
        } else {
            campoOperacionPubli.setText("Alquila");
        }
        campoPrecioPubli.setText(String.valueOf(cbxInmueble.getItemAt(cbxInmueble.getSelectedIndex()).getPrecio()));   
    }

    public homeAdm() {
        initComponents();
        imprimirTablaUsuarios(usuarios.seleccionar());
        imprimirTablaInmuebles(inmuebles.seleccionar());
        imprimirTablaPublicaciones(publicaciones.seleccionar());
        llenarUsuarios();
        llenarInmuebles();
        campoFechaPublicacion.setText((LocalDate.now()).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        favicon = new javax.swing.JLabel();
        campoUser = new javax.swing.JTextField();
        campoContrasena = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        campoDni = new javax.swing.JTextField();
        campoEmail = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtUsuarios = new javax.swing.JTable();
        userRegLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pwRegLabel = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        nameLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        surnameLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        emailLabel = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        emailLabel1 = new javax.swing.JLabel();
        campoLocalidad = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        emailLabel2 = new javax.swing.JLabel();
        campoCp = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        campoTipoUsuario = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        favicon1 = new javax.swing.JLabel();
        userRegLabel1 = new javax.swing.JLabel();
        campoLugar = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        campoOperacion = new javax.swing.JComboBox<>();
        userRegLabel2 = new javax.swing.JLabel();
        campoDireccion = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        userRegLabel3 = new javax.swing.JLabel();
        campoNumero = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        campoTipoInmueble = new javax.swing.JComboBox<>();
        userRegLabel4 = new javax.swing.JLabel();
        campoPrecio = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        btnAgregarInm = new javax.swing.JButton();
        btnModificarInm = new javax.swing.JButton();
        btnGuardarInm = new javax.swing.JButton();
        btnEliminarInm = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtInmuebles = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        favicon2 = new javax.swing.JLabel();
        userRegLabel5 = new javax.swing.JLabel();
        userRegLabel6 = new javax.swing.JLabel();
        campoFechaPublicacion = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        cbxInmueble = new javax.swing.JComboBox<>();
        userRegLabel7 = new javax.swing.JLabel();
        campoEstadoPublicacion = new javax.swing.JComboBox<>();
        userRegLabel8 = new javax.swing.JLabel();
        campoEmailPubli = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        cbxNombre = new javax.swing.JComboBox<>();
        jSeparator14 = new javax.swing.JSeparator();
        userRegLabel10 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        campoLugarPubli = new javax.swing.JTextField();
        userRegLabel11 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        campoDirePubli = new javax.swing.JTextField();
        userRegLabel12 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        campoNumeroPubli = new javax.swing.JTextField();
        userRegLabel13 = new javax.swing.JLabel();
        campoOperacionPubli = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        campoPrecioPubli = new javax.swing.JTextField();
        userRegLabel14 = new javax.swing.JLabel();
        jSeparator20 = new javax.swing.JSeparator();
        btnLlenadoInm = new javax.swing.JButton();
        btnLlenadoUser1 = new javax.swing.JButton();
        cargarPubli = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        favicon3 = new javax.swing.JLabel();
        userRegLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtMaestro = new javax.swing.JTable();
        userRegLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtDetalle = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        favicon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Santiago\\Desktop\\favicon.png")); // NOI18N
        favicon.setText("MAS POCO ALQUILO - USUARIOS");
        jPanel1.add(favicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 350, 30));

        campoUser.setBorder(null);
        campoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoUserActionPerformed(evt);
            }
        });
        jPanel1.add(campoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 300, 30));

        campoContrasena.setBorder(null);
        jPanel1.add(campoContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 300, 30));

        campoNombre.setBorder(null);
        jPanel1.add(campoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 300, 30));

        campoDni.setBorder(null);
        jPanel1.add(campoDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 300, 30));

        campoEmail.setToolTipText("");
        campoEmail.setBorder(null);
        jPanel1.add(campoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 300, 30));

        jtUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Usuario", "Nombre", "DNI", "Email", "Localidad", "CP", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtUsuarios);
        if (jtUsuarios.getColumnModel().getColumnCount() > 0) {
            jtUsuarios.getColumnModel().getColumn(0).setMinWidth(25);
            jtUsuarios.getColumnModel().getColumn(0).setMaxWidth(25);
            jtUsuarios.getColumnModel().getColumn(1).setMinWidth(80);
            jtUsuarios.getColumnModel().getColumn(1).setMaxWidth(80);
            jtUsuarios.getColumnModel().getColumn(2).setMinWidth(120);
            jtUsuarios.getColumnModel().getColumn(2).setMaxWidth(120);
            jtUsuarios.getColumnModel().getColumn(3).setMinWidth(65);
            jtUsuarios.getColumnModel().getColumn(3).setMaxWidth(65);
            jtUsuarios.getColumnModel().getColumn(5).setMinWidth(65);
            jtUsuarios.getColumnModel().getColumn(5).setMaxWidth(65);
            jtUsuarios.getColumnModel().getColumn(6).setMinWidth(40);
            jtUsuarios.getColumnModel().getColumn(6).setMaxWidth(40);
            jtUsuarios.getColumnModel().getColumn(7).setMinWidth(50);
            jtUsuarios.getColumnModel().getColumn(7).setMaxWidth(50);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 620, 450));

        userRegLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userRegLabel.setText("USUARIO");
        jPanel1.add(userRegLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 300, 10));

        pwRegLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pwRegLabel.setText("CONTRASENA");
        jPanel1.add(pwRegLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jSeparator6.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 300, 10));

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameLabel.setText("NOMBRE");
        jPanel1.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 300, 20));

        surnameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        surnameLabel.setText("DNI");
        jPanel1.add(surnameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 300, 20));

        emailLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        emailLabel.setText("EMAIL");
        jPanel1.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 300, 20));

        emailLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        emailLabel1.setText("LOCALIDAD");
        jPanel1.add(emailLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        campoLocalidad.setToolTipText("");
        campoLocalidad.setBorder(null);
        jPanel1.add(campoLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 170, 30));

        jSeparator5.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 170, 20));

        emailLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        emailLabel2.setText("CODIGO POSTAL");
        jPanel1.add(emailLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 120, -1));

        campoCp.setToolTipText("");
        campoCp.setBorder(null);
        jPanel1.add(campoCp, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 110, 30));

        jSeparator7.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 110, 20));

        campoTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agente Inmobiliario", "Cliente" }));
        campoTipoUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TIPO DE USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        campoTipoUsuario.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        jPanel1.add(campoTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 220, 50));

        btnGuardar.setBackground(new java.awt.Color(0, 134, 190));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 120, 40));

        btnAgregar.setBackground(new java.awt.Color(0, 134, 190));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 130, 40));

        btnEliminar.setBackground(new java.awt.Color(0, 134, 190));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 510, 120, 40));

        btnModificar.setBackground(new java.awt.Color(0, 134, 190));
        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 120, 40));

        jTabbedPane1.addTab("Usuarios", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        favicon1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        favicon1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Santiago\\Desktop\\favicon.png")); // NOI18N
        favicon1.setText("MAS POCO ALQUILO - INMUEBLE");
        jPanel2.add(favicon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 29, 350, 30));

        userRegLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userRegLabel1.setText("LUGAR");
        jPanel2.add(userRegLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        campoLugar.setBorder(null);
        campoLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoLugarActionPerformed(evt);
            }
        });
        jPanel2.add(campoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 300, 30));

        jSeparator8.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 300, 10));

        campoOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Venta", "Alquiler" }));
        campoOperacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPERACION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        campoOperacion.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        campoOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoOperacionActionPerformed(evt);
            }
        });
        jPanel2.add(campoOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 220, 50));

        userRegLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userRegLabel2.setText("DIRECCION");
        jPanel2.add(userRegLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        campoDireccion.setBorder(null);
        campoDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDireccionActionPerformed(evt);
            }
        });
        jPanel2.add(campoDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 300, 30));

        jSeparator9.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 300, 10));

        userRegLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userRegLabel3.setText("NUMERO");
        jPanel2.add(userRegLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        campoNumero.setBorder(null);
        campoNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNumeroActionPerformed(evt);
            }
        });
        jPanel2.add(campoNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 300, 30));

        jSeparator10.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 300, 10));

        campoTipoInmueble.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casa", "Departamento" }));
        campoTipoInmueble.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TIPO DE INMUEBLE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        campoTipoInmueble.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        campoTipoInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTipoInmuebleActionPerformed(evt);
            }
        });
        jPanel2.add(campoTipoInmueble, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 220, 50));

        userRegLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userRegLabel4.setText("PRECIO");
        jPanel2.add(userRegLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        campoPrecio.setBorder(null);
        campoPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPrecioActionPerformed(evt);
            }
        });
        jPanel2.add(campoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 300, 30));

        jSeparator11.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 300, 10));

        btnAgregarInm.setBackground(new java.awt.Color(0, 134, 190));
        btnAgregarInm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarInm.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarInm.setText("AGREGAR");
        btnAgregarInm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarInmActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarInm, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 130, 40));

        btnModificarInm.setBackground(new java.awt.Color(0, 134, 190));
        btnModificarInm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModificarInm.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarInm.setText("MODIFICAR");
        btnModificarInm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarInmActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificarInm, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 120, 40));

        btnGuardarInm.setBackground(new java.awt.Color(0, 134, 190));
        btnGuardarInm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardarInm.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarInm.setText("GUARDAR");
        btnGuardarInm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarInmActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardarInm, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 500, 120, 40));

        btnEliminarInm.setBackground(new java.awt.Color(0, 134, 190));
        btnEliminarInm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminarInm.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarInm.setText("ELIMINAR");
        btnEliminarInm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarInmActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarInm, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 500, 120, 40));

        jtInmuebles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tipo", "Lugar", "Direccion", "Numero", "Operacion", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtInmuebles);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 530, -1));

        jTabbedPane1.addTab("Inmueble", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        favicon2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        favicon2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Santiago\\Desktop\\favicon.png")); // NOI18N
        favicon2.setText("MAS POCO ALQUILO - GENERAR PUBLICACIONES");
        jPanel3.add(favicon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 29, 430, 30));

        userRegLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        userRegLabel5.setText("DETALLE DE PUBLICACION");
        jPanel3.add(userRegLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        userRegLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userRegLabel6.setText("FECHA");
        jPanel3.add(userRegLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        campoFechaPublicacion.setBorder(null);
        campoFechaPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoFechaPublicacionActionPerformed(evt);
            }
        });
        jPanel3.add(campoFechaPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 300, 30));

        jSeparator12.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 300, 10));

        cbxInmueble.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID INMUEBLE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        cbxInmueble.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        cbxInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxInmuebleActionPerformed(evt);
            }
        });
        jPanel3.add(cbxInmueble, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 270, 50));

        userRegLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        userRegLabel7.setText("PUBLICACION");
        jPanel3.add(userRegLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        campoEstadoPublicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "No disponible" }));
        campoEstadoPublicacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ESTADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        campoEstadoPublicacion.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        campoEstadoPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEstadoPublicacionActionPerformed(evt);
            }
        });
        jPanel3.add(campoEstadoPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 220, 50));

        userRegLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userRegLabel8.setText("EMAIL");
        jPanel3.add(userRegLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, -1, -1));

        campoEmailPubli.setBorder(null);
        campoEmailPubli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEmailPubliActionPerformed(evt);
            }
        });
        jPanel3.add(campoEmailPubli, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 300, 30));

        jSeparator13.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 300, 10));

        cbxNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOMBRE AGENTE INMOBILIARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        cbxNombre.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        cbxNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNombreActionPerformed(evt);
            }
        });
        jPanel3.add(cbxNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 270, 50));

        jSeparator14.setForeground(new java.awt.Color(204, 204, 204));
        jPanel3.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 920, 10));

        userRegLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userRegLabel10.setText("LUGAR");
        jPanel3.add(userRegLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, -1));

        jSeparator16.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 300, 10));

        campoLugarPubli.setBorder(null);
        campoLugarPubli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoLugarPubliActionPerformed(evt);
            }
        });
        jPanel3.add(campoLugarPubli, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 300, 30));

        userRegLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userRegLabel11.setText("DIRECCION");
        jPanel3.add(userRegLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, -1, -1));

        jSeparator17.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 160, 10));

        campoDirePubli.setBorder(null);
        campoDirePubli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDirePubliActionPerformed(evt);
            }
        });
        jPanel3.add(campoDirePubli, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 160, 30));

        userRegLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userRegLabel12.setText("NUMERO");
        jPanel3.add(userRegLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, -1, -1));

        jSeparator18.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 160, 10));

        campoNumeroPubli.setBorder(null);
        campoNumeroPubli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNumeroPubliActionPerformed(evt);
            }
        });
        jPanel3.add(campoNumeroPubli, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 160, 30));

        userRegLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userRegLabel13.setText("OPERACION");
        jPanel3.add(userRegLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, -1, -1));

        campoOperacionPubli.setBorder(null);
        campoOperacionPubli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoOperacionPubliActionPerformed(evt);
            }
        });
        jPanel3.add(campoOperacionPubli, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 160, 30));

        jSeparator19.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, 160, 10));

        campoPrecioPubli.setBorder(null);
        campoPrecioPubli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPrecioPubliActionPerformed(evt);
            }
        });
        jPanel3.add(campoPrecioPubli, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, 160, 30));

        userRegLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userRegLabel14.setText("PRECIO");
        jPanel3.add(userRegLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, -1, -1));

        jSeparator20.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 160, 10));

        btnLlenadoInm.setBackground(new java.awt.Color(0, 134, 190));
        btnLlenadoInm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLlenadoInm.setForeground(new java.awt.Color(255, 255, 255));
        btnLlenadoInm.setText("COMPLETAR");
        btnLlenadoInm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlenadoInmActionPerformed(evt);
            }
        });
        jPanel3.add(btnLlenadoInm, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 230, 130, 40));

        btnLlenadoUser1.setBackground(new java.awt.Color(0, 134, 190));
        btnLlenadoUser1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLlenadoUser1.setForeground(new java.awt.Color(255, 255, 255));
        btnLlenadoUser1.setText("COMPLETAR");
        btnLlenadoUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlenadoUser1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnLlenadoUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 440, 130, 40));

        cargarPubli.setBackground(new java.awt.Color(0, 134, 190));
        cargarPubli.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cargarPubli.setForeground(new java.awt.Color(255, 255, 255));
        cargarPubli.setText("CARGAR PUBLICACION");
        cargarPubli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarPubliActionPerformed(evt);
            }
        });
        jPanel3.add(cargarPubli, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, 280, 40));

        jTabbedPane1.addTab("Generar Publicacion", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        favicon3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        favicon3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Santiago\\Desktop\\favicon.png")); // NOI18N
        favicon3.setText("MAS POCO ALQUILO - PUBLICACIONES");
        jPanel4.add(favicon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 29, 430, 30));

        userRegLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        userRegLabel15.setText("DETALLE");
        jPanel4.add(userRegLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        jtMaestro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtMaestro.setOpaque(false);
        jtMaestro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMaestroMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtMaestro);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 240, 370));

        userRegLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        userRegLabel16.setText("PUBLICACION");
        jPanel4.add(userRegLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jtDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Agente", "Email", "Tipo", "Lugar", "Direccion", "Numero", "Operacion", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jtDetalle);

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 590, 370));

        jTabbedPane1.addTab("Publicaciones", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 992, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int filaSeleccionada = jtUsuarios.getSelectedRow();
        campoUser.setText((String) jtUsuarios.getValueAt(filaSeleccionada, 1));
        campoNombre.setText((String) jtUsuarios.getValueAt(filaSeleccionada, 2));
        campoDni.setText(String.valueOf(jtUsuarios.getValueAt(filaSeleccionada, 3)));
        campoEmail.setText((String) jtUsuarios.getValueAt(filaSeleccionada, 4));
        campoLocalidad.setText((String) jtUsuarios.getValueAt(filaSeleccionada, 5));
        campoCp.setText(String.valueOf(jtUsuarios.getValueAt(filaSeleccionada, 6)));
        campoTipoUsuario.setSelectedItem(jtUsuarios.getValueAt(filaSeleccionada, 7));

        btnAgregar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        jtUsuarios.setEnabled(false);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = jtUsuarios.getSelectedRow();
        int id = (int) jtUsuarios.getValueAt(filaSeleccionada, 0);

        usuarios user = new usuarios(id);
        usuarios.eliminar(user);

        //IMPRIMO TABLA
        vaciarTablaUsuarios();
        imprimirTablaUsuarios(usuarios.seleccionar());
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        //RECOLECCION DE DATOS
        String usuario = campoUser.getText();
        String contrasena = campoContrasena.getText();
        String nombreUsuario = campoNombre.getText();
        int dniUsuario = Integer.parseInt(campoDni.getText());
        String emailUsuario = campoEmail.getText();
        String localidadUsuario = campoLocalidad.getText();
        int cpUsuario = Integer.parseInt(campoCp.getText());
        String tipo = (String) campoTipoUsuario.getSelectedItem();
        boolean tipoUsuario;
        if (tipo == "Agente Inmobiliario") {
            tipoUsuario = true;
        } else {
            tipoUsuario = false;
        }

        //EJECUTAR AGREGAR
        usuarios user = new usuarios(usuario, contrasena, nombreUsuario, dniUsuario, emailUsuario, localidadUsuario, cpUsuario, tipoUsuario);

        try {
            usuarios.agregarUsuario(user);
        } catch (ParseException ex) {
            Logger.getLogger(homeAdm.class.getName()).log(Level.SEVERE, null, ex);
        }

        //IMPRIMO TABLA
        vaciarTablaUsuarios();
        imprimirTablaUsuarios(usuarios.seleccionar());
        llenarUsuarios();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int filaSeleccionada = jtUsuarios.getSelectedRow();
        int id = (int) jtUsuarios.getValueAt(filaSeleccionada, 0);
        String usuario = campoUser.getText();
        String nombreUsuario = campoNombre.getText();
        int dniUsuario = Integer.parseInt(campoDni.getText());
        String emailUsuario = campoEmail.getText();
        String localidadUsuario = campoLocalidad.getText();
        int cpUsuario = Integer.parseInt(campoCp.getText());
        String tipo = (String) campoTipoUsuario.getSelectedItem();
        boolean tipoUsuario;
        if (tipo == "Agente Inmobiliario") {
            tipoUsuario = true;
        } else {
            tipoUsuario = false;
        }

        usuarios user = new usuarios(id, usuario, nombreUsuario, dniUsuario, emailUsuario, localidadUsuario, cpUsuario, tipoUsuario);

        try {
            usuarios.modificarUsuario(user);
        } catch (ParseException ex) {
            Logger.getLogger(homeAdm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(homeAdm.class.getName()).log(Level.SEVERE, null, ex);
        }

        //IMPRIMO TABLA
        vaciarTablaUsuarios();
        imprimirTablaUsuarios(usuarios.seleccionar());

        //ACTIVO BOTONES
        btnAgregar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnModificar.setEnabled(true);
        jtUsuarios.setEnabled(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void campoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoUserActionPerformed

    private void campoLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoLugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoLugarActionPerformed

    private void campoOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoOperacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoOperacionActionPerformed

    private void campoDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDireccionActionPerformed

    private void campoNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNumeroActionPerformed

    private void campoTipoInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTipoInmuebleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTipoInmuebleActionPerformed

    private void campoPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPrecioActionPerformed

    private void btnAgregarInmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarInmActionPerformed
    //RECOLECCION DE DATOS
        String tipo = (String)campoTipoInmueble.getSelectedItem();
        String lugar = campoLugar.getText();
        String direccion = campoDireccion.getText();
        int numero = Integer.parseInt(campoNumero.getText());
        String operacion = (String)campoOperacion.getSelectedItem();
        boolean tipoOperacion;
        if (operacion == "Venta"){
            tipoOperacion = true;
        } else{
            tipoOperacion = false;
        }
        int precio = Integer.parseInt(campoPrecio.getText());

        //EJECUTAR AGREGAR
        inmuebles inm = new inmuebles(tipo, lugar, direccion, numero, tipoOperacion, precio);

        try {
            inmuebles.agregarInmueble(inm);
        } catch (ParseException ex) {
            Logger.getLogger(homeAdm.class.getName()).log(Level.SEVERE, null, ex);
        }

        //IMPRIMO TABLA
        vaciarTablaInmuebles();
        imprimirTablaInmuebles(inmuebles.seleccionar());
        llenarInmuebles();
    }//GEN-LAST:event_btnAgregarInmActionPerformed

    private void btnModificarInmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarInmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarInmActionPerformed

    private void btnGuardarInmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarInmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarInmActionPerformed

    private void btnEliminarInmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarInmActionPerformed

    private void campoFechaPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoFechaPublicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoFechaPublicacionActionPerformed

    private void cbxInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxInmuebleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxInmuebleActionPerformed

    private void campoEstadoPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEstadoPublicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEstadoPublicacionActionPerformed

    private void campoEmailPubliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEmailPubliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEmailPubliActionPerformed

    private void cbxNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNombreActionPerformed

    private void campoLugarPubliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoLugarPubliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoLugarPubliActionPerformed

    private void campoDirePubliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDirePubliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDirePubliActionPerformed

    private void campoNumeroPubliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNumeroPubliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNumeroPubliActionPerformed

    private void campoOperacionPubliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoOperacionPubliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoOperacionPubliActionPerformed

    private void campoPrecioPubliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPrecioPubliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPrecioPubliActionPerformed

    private void btnLlenadoInmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLlenadoInmActionPerformed
        llenadoCampos();
    }//GEN-LAST:event_btnLlenadoInmActionPerformed

    private void btnLlenadoUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLlenadoUser1ActionPerformed
        llenadoCamposInm();
    }//GEN-LAST:event_btnLlenadoUser1ActionPerformed

    private void cargarPubliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarPubliActionPerformed
        //RECOLECCION DE DATOS MAESTRO
        String fechaPublicacion = campoFechaPublicacion.getText();
        String estadoPublicacion = (String)campoEstadoPublicacion.getSelectedItem();
        boolean estado;
        if(estadoPublicacion == "Disponible"){
            estado = true;
        } else{
            estado=false;
        }
        
        publicaciones publicacion = new publicaciones(fechaPublicacion,estado);
        
        
        //RECOLECCION DE DATOS DETALLE
        usuarios nombreUsuarioDetalle = (usuarios) cbxNombre.getSelectedItem();
        String emailUsuarioDetalle = campoEmailPubli.getText();
        inmuebles tipoInmuebleDetalle = (inmuebles)cbxInmueble.getSelectedItem();
        String lugarInmuebleDetalle = campoLugarPubli.getText();
        String direccionInmuebleDetalle = campoDirePubli.getText();
        int numeroInmuebleDetalle = Integer.parseInt(campoNumeroPubli.getText());
        String operacionInmueble = campoOperacionPubli.getText();
        boolean operacionInmuebleDetalle;
        if(operacionInmueble=="Venta"){
            operacionInmuebleDetalle = true;
        } else{
            operacionInmuebleDetalle = false;
        }
        int precioInmuebleDetalle = Integer.parseInt(campoPrecioPubli.getText());
        
        detallePublicaciones detallePublicacion = new detallePublicaciones(nombreUsuarioDetalle,emailUsuarioDetalle,tipoInmuebleDetalle,lugarInmuebleDetalle,direccionInmuebleDetalle,numeroInmuebleDetalle,operacionInmuebleDetalle,precioInmuebleDetalle);
        
        try {
            publicaciones.agregarMaestroPublicacion(publicacion);
            detallePublicaciones.agregarDetallePublicacion(detallePublicacion);
        } catch (ParseException ex) {
            Logger.getLogger(homeAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        imprimirTablaPublicaciones(publicaciones.seleccionar());
    }//GEN-LAST:event_cargarPubliActionPerformed

    private void jtMaestroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMaestroMouseClicked
        
        int fila = jtMaestro.getSelectedRow();
        int numero = (int) jtMaestro.getValueAt(fila, 0);
                
        jtDetalle.setModel(new detallePublicaciones().getDetalles(numero));
        
        
    }//GEN-LAST:event_jtMaestroMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAgregar;
    public static javax.swing.JButton btnAgregarInm;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarInm;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarInm;
    public static javax.swing.JButton btnLlenadoInm;
    public static javax.swing.JButton btnLlenadoUser1;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificarInm;
    public static javax.swing.JTextField campoContrasena;
    public static javax.swing.JTextField campoCp;
    public static javax.swing.JTextField campoDirePubli;
    public static javax.swing.JTextField campoDireccion;
    public static javax.swing.JTextField campoDni;
    public static javax.swing.JTextField campoEmail;
    public static javax.swing.JTextField campoEmailPubli;
    public static javax.swing.JComboBox<String> campoEstadoPublicacion;
    public static javax.swing.JTextField campoFechaPublicacion;
    public static javax.swing.JTextField campoLocalidad;
    public static javax.swing.JTextField campoLugar;
    public static javax.swing.JTextField campoLugarPubli;
    public static javax.swing.JTextField campoNombre;
    public static javax.swing.JTextField campoNumero;
    public static javax.swing.JTextField campoNumeroPubli;
    public static javax.swing.JComboBox<String> campoOperacion;
    public static javax.swing.JTextField campoOperacionPubli;
    public static javax.swing.JTextField campoPrecio;
    public static javax.swing.JTextField campoPrecioPubli;
    public static javax.swing.JComboBox<String> campoTipoInmueble;
    public static javax.swing.JComboBox<String> campoTipoUsuario;
    public static javax.swing.JTextField campoUser;
    public static javax.swing.JButton cargarPubli;
    public static javax.swing.JComboBox<inmuebles> cbxInmueble;
    public static javax.swing.JComboBox<usuarios> cbxNombre;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailLabel1;
    private javax.swing.JLabel emailLabel2;
    private javax.swing.JLabel favicon;
    private javax.swing.JLabel favicon1;
    private javax.swing.JLabel favicon2;
    private javax.swing.JLabel favicon3;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable jtDetalle;
    public static javax.swing.JTable jtInmuebles;
    public static javax.swing.JTable jtMaestro;
    public static javax.swing.JTable jtUsuarios;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel pwRegLabel;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel userRegLabel;
    private javax.swing.JLabel userRegLabel1;
    private javax.swing.JLabel userRegLabel10;
    private javax.swing.JLabel userRegLabel11;
    private javax.swing.JLabel userRegLabel12;
    private javax.swing.JLabel userRegLabel13;
    private javax.swing.JLabel userRegLabel14;
    private javax.swing.JLabel userRegLabel15;
    private javax.swing.JLabel userRegLabel16;
    private javax.swing.JLabel userRegLabel2;
    private javax.swing.JLabel userRegLabel3;
    private javax.swing.JLabel userRegLabel4;
    private javax.swing.JLabel userRegLabel5;
    private javax.swing.JLabel userRegLabel6;
    private javax.swing.JLabel userRegLabel7;
    private javax.swing.JLabel userRegLabel8;
    // End of variables declaration//GEN-END:variables
}
