/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantalla;

/**
 *
 * @author Santiago
 */
public class homeAdm extends javax.swing.JFrame {

    /**
     * Creates new form homeAdm
     */
    public homeAdm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        userRegTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pwRegTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        APELLIDO = new javax.swing.JLabel();
        surnameTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        comoTipo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("USUARIOS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaUsuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, 480));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("USUARIO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 60, 20));

        userRegTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userRegTxtActionPerformed(evt);
            }
        });
        jPanel1.add(userRegTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 170, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("CONTRASENA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));
        jPanel1.add(pwRegTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 170, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("NOMBRE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 20));
        jPanel1.add(nameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 170, -1));

        APELLIDO.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        APELLIDO.setText("APELLIDO");
        jPanel1.add(APELLIDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 20));
        jPanel1.add(surnameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("EMAIL");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 20));

        emailTxt.setToolTipText("");
        jPanel1.add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 170, -1));

        comoTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Agente Inmobiliario", "Cliente" }));
        comoTipo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TIPO DE USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        comoTipo.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        comoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comoTipoActionPerformed(evt);
            }
        });
        jPanel1.add(comoTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 220, 60));

        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jButton2.setText("MODIFICAR");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jButton3.setText("ELIMINAR");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userRegTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userRegTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userRegTxtActionPerformed

    private void comoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comoTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comoTipoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        negocios.crud.guardarDatosPersonaAgregar();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel APELLIDO;
    public static javax.swing.JComboBox<String> comoTipo;
    public static javax.swing.JTextField emailTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField nameTxt;
    public static javax.swing.JTextField pwRegTxt;
    public static javax.swing.JTextField surnameTxt;
    public static javax.swing.JTable tablaUsuarios;
    public static javax.swing.JTextField userRegTxt;
    // End of variables declaration//GEN-END:variables
}