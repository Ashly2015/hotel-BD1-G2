/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDI;

import static MDI.mdi_Principal.labelusuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ranbr
 */
public class inf_Mantenimiento_Tipo_Precio extends javax.swing.JInternalFrame {

    public void tablas() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from tipo_precio");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID Tipo Precio");
            modelo.addColumn("ID Moneda");
            modelo.addColumn("Nombre Tipo Precio");
            modelo.addColumn("Estatus");

            tbl.setModel(modelo);
            String[] dato = new String[4];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * Funcion para actualizar los combobox
     */
    public void refrescar() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select nombre_moneda from moneda ");
            ResultSet rss = psttt.executeQuery();

            cbox_tipo_precio.removeAllItems();
            cbox_tipo_precio.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_tipo_precio.addItem(rss.getString("nombre_moneda"));
            }
            tablas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablas();
    }

    /**
     *
     * Funcion para poblar el combobox con la informacion correspondiente segun
     * la base de datos
     */
    public void iniciar_combo() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select nombre_moneda from moneda ");
            ResultSet rss = psttt.executeQuery();

            cbox_tipo_precio.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_tipo_precio.addItem(rss.getString("nombre_moneda"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablas();
    }
    public void get_fecha(){
        //Obtenemos la fecha
        Calendar c1 = Calendar.getInstance();
                fecha.setCalendar(c1);
    }
    
    public void get_usuario(){
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from usuario_hoteleria where nombre_usuario = ?");
            pst.setString(1, labelusuario.getText().trim()); 

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                lbusu.setText(rs.getString("id_usuario"));
                


        }
        }catch (Exception e) {

        
        }
    }
    
    public void bitacora_guardar(){
        String prov=txt_nombre.getText();
        String descrip="Registró el tipo de precio "+prov;
       //Desciframos la fecha
        java.util.Date fechaN = fecha.getDate();
        long fecha = fechaN.getTime();
        java.sql.Date dateN = new java.sql.Date(fecha);
        
        
        //Obtenemos la hora
                Calendar timec = Calendar.getInstance();
                
                int hora = timec.get(Calendar.HOUR_OF_DAY);
                int minutos = timec.get(Calendar.MINUTE);
                int segundos = timec.get(Calendar.SECOND);
                
                String time=hora+":"+minutos+":"+segundos;
                
        
        try {
            
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, lbusu.getText().trim());
            pst.setString(3, descrip);
            pst.setString(4,dateN.toString().trim() );
            pst.setString(5, time.trim());
            
            pst.executeUpdate();

        } catch (SQLException e) {
        }
    }
    public void bitacora_modificar(){
        String prov=txt_nombre.getText();
        String descrip="Modificó el tipo de precio "+prov;
       //Desciframos la fecha
        java.util.Date fechaN = fecha.getDate();
        long fecha = fechaN.getTime();
        java.sql.Date dateN = new java.sql.Date(fecha);
        
        
        //Obtenemos la hora
                Calendar timec = Calendar.getInstance();
                
                int hora = timec.get(Calendar.HOUR_OF_DAY);
                int minutos = timec.get(Calendar.MINUTE);
                int segundos = timec.get(Calendar.SECOND);
                
                String time=hora+":"+minutos+":"+segundos;
                
        
        try {
            
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, lbusu.getText().trim());
            pst.setString(3, descrip);
            pst.setString(4,dateN.toString().trim() );
            pst.setString(5, time.trim());
            
            pst.executeUpdate();

        } catch (SQLException e) {
        }
    }
    public void bitacora_eliminar(){
       String prov=txt_nombre.getText();
        String descrip="Eliminó el tipo de precio "+prov;
       //Desciframos la fecha
        java.util.Date fechaN = fecha.getDate();
        long fecha = fechaN.getTime();
        java.sql.Date dateN = new java.sql.Date(fecha);
        
        
        //Obtenemos la hora
                Calendar timec = Calendar.getInstance();
                
                int hora = timec.get(Calendar.HOUR_OF_DAY);
                int minutos = timec.get(Calendar.MINUTE);
                int segundos = timec.get(Calendar.SECOND);
                
                String time=hora+":"+minutos+":"+segundos;
                
        
        try {
            
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, lbusu.getText().trim());
            pst.setString(3, descrip);
            pst.setString(4,dateN.toString().trim() );
            pst.setString(5, time.trim());
            
            pst.executeUpdate();

        } catch (SQLException e) {
        }
    }
    public void bitacora_buscar(){
        String prov=txt_nombre.getText();
        String descrip="Buscó el tipo de precio "+prov;
       //Desciframos la fecha
        java.util.Date fechaN = fecha.getDate();
        long fecha = fechaN.getTime();
        java.sql.Date dateN = new java.sql.Date(fecha);
        
        
        //Obtenemos la hora
                Calendar timec = Calendar.getInstance();
                
                int hora = timec.get(Calendar.HOUR_OF_DAY);
                int minutos = timec.get(Calendar.MINUTE);
                int segundos = timec.get(Calendar.SECOND);
                
                String time=hora+":"+minutos+":"+segundos;
                
        
        try {
            
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, lbusu.getText().trim());
            pst.setString(3, descrip);
            pst.setString(4,dateN.toString().trim() );
            pst.setString(5, time.trim());
            
            pst.executeUpdate();

        } catch (SQLException e) {
        }
    }

    /**
     * Creates new form inf_Mantenimiento_Tipo_Precio
     */
    public inf_Mantenimiento_Tipo_Precio() {
        initComponents();
        tablas();
        iniciar_combo();
        get_fecha();
        get_usuario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fecha = new com.toedter.calendar.JDateChooser();
        lbusu = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        cbox_tipo_precio = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        label4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        lb = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        activo = new javax.swing.JRadioButton();
        inactivo = new javax.swing.JRadioButton();
        txt_estado = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Mantenimiento Tipo Precio");
        setVisible(true);

        tbl.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Tipo Precio", "ID Moneda", "Nombre ", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl);

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        cbox_tipo_precio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_tipo_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_tipo_precioActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("Moneda");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Tipo Precio");

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Nombre Tipo Precio:");

        txt_nombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_nombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_nombre.setOpaque(false);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("Estado:");

        jPanel1.setOpaque(false);

        activo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        activo.setText("Activo");
        activo.setOpaque(false);
        activo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activoActionPerformed(evt);
            }
        });

        inactivo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        inactivo.setText("Inactivo");
        inactivo.setOpaque(false);
        inactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(activo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(inactivo)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activo)
                    .addComponent(inactivo)))
        );

        txt_estado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_estado.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_estado.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label3)
                            .addComponent(label4))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nombre)
                            .addComponent(cbox_tipo_precio, 0, 263, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(label8)
                        .addGap(22, 22, 22)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label1)
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbox_tipo_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4)
                                .addComponent(lb)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(label8))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_estado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnEliminar)
                            .addComponent(btnModificar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(btnLimpiar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("delete from tipo_precio where id_tipo_precio = ?");

            pst.setString(1, txtbuscado.getText().trim());
            pst.executeUpdate();

             bitacora_eliminar();
            JOptionPane.showMessageDialog(this, "¡ELIMINACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txt_nombre.setText("");

            cbox_tipo_precio.setSelectedIndex(0);
            txt_estado.setText("");
            txtbuscado.setText("");
            btnRegistrar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            tablas();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en Eliminacion", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        refrescar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cbox_tipo_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_tipo_precioActionPerformed

        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select id_moneda from moneda where nombre_moneda = ?");
            pst2.setString(1, cbox_tipo_precio.getSelectedItem().toString());
            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                lb.setText(rs2.getString("id_moneda"));

            } else {
                if (cbox_tipo_precio.getSelectedItem().toString().contains("Seleccione una opción")) {
                    txt_nombre.setText("");
                    txt_estado.setText("");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_tipo_precioActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into tipo_precio values(?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, lb.getText());
            pst.setString(3, txt_nombre.getText());            
            pst.setString(4, txt_estado.getText());

            bitacora_guardar();
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txt_nombre.setText("");
            inactivo.setSelected(false);
            activo.setSelected(false);
            txtbuscado.setText("");
            txt_estado.setText("");
            tablas();
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        refrescar();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String buscar = txtbuscado.getText().trim();
        if (buscar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡No se ingreso el campo de busqueda!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from tipo_precio where id_tipo_precio =?");
            pst.setString(1, txtbuscado.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lb.setText(rs.getString("id_moneda"));
                txt_nombre.setText(rs.getString("nombre"));
                txt_estado.setText(rs.getString("estatus"));
                btnModificar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnRegistrar.setEnabled(false);
                tablas();

            } else {
                JOptionPane.showMessageDialog(null, "Tipo Precio no registrado.");
            }

        } catch (Exception e) {

        }

        // tablas();
         bitacora_buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {
            String ID = txtbuscado.getText().trim();

            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("update tipo_precio set  id_moneda = ?,nombre =?, estatus = ? where id_tipo_precio =" + ID);
            String mensaje = "";
            pst.setString(1, lb.getText());
            pst.setString(2, txt_nombre.getText());
            pst.setString(3, txt_estado.getText());

            pst.executeUpdate();

            //bitacora_modificar();
            JOptionPane.showMessageDialog(this, "¡MODIFICACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txt_nombre.setText("");
            txt_estado.setText("");
            

            txtbuscado.setText("");
            btnRegistrar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            tablas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en Modificacion", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        refrescar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txt_nombre.setText("");
        txt_estado.setText("");
        inactivo.setSelected(false);
        activo.setSelected(false);
        cbox_tipo_precio.setSelectedIndex(0);
        txtbuscado.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void activoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activoActionPerformed
        if(activo.isSelected()){
            
            txt_estado.setText("A");
                inactivo.setSelected(false);
            }
    }//GEN-LAST:event_activoActionPerformed

    private void inactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inactivoActionPerformed
        if(inactivo.isSelected()){
            
            txt_estado.setText("I");
        activo.setSelected(false);
            }
    }//GEN-LAST:event_inactivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton activo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbox_tipo_precio;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JRadioButton inactivo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txt_estado;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
