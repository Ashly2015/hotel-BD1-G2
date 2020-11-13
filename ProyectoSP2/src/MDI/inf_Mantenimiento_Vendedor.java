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
public class inf_Mantenimiento_Vendedor extends javax.swing.JInternalFrame {

    public void tablas() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from vendedor");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID Vendedor");
            modelo.addColumn("ID Empleado");
            modelo.addColumn("Correo");
            modelo.addColumn("Telefono");
            modelo.addColumn("Direccion");
            modelo.addColumn("Porcentaje");
            modelo.addColumn("Comision");
            tbl.setModel(modelo);
            String[] dato = new String[7];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(6);
                dato[6] = rss4.getString(7);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void buscar_empleado() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select id_empleado from empleado_contratado where id_empleado = ?");

            pst.setString(1, lb.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                lb2.setText(rs.getString("id_empleado"));
                String pc = lb2.getText();
                cbox_empleado.setSelectedItem(pc);

            } else {

            }

        } catch (Exception e) {

        }
    }

    /**
     *
     * Funcion para actualizar los combobox
     */

    /**
     *
     * Funcion para poblar el combobox con la informacion correspondiente segun
     * la base de datos
     */
    public void iniciar_combo() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select id_empleado from empleado_contratado ");
            ResultSet rss = psttt.executeQuery();

            cbox_empleado.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_empleado.addItem(rss.getString("id_empleado"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablas();
    }

    /**
     * Creates new form inf_Mantenimiento_Cliente
     */
    
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
        String prov=cbox_empleado.getSelectedItem().toString();
        String descrip="Registró al empleado "+prov+" como vendedor";
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
        String prov=cbox_empleado.getSelectedItem().toString();
        String descrip="Modificó al vendedor "+prov;
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
       String prov=cbox_empleado.getSelectedItem().toString();
        String descrip="Eliminó al vendedor "+prov;
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
        String prov=cbox_empleado.getSelectedItem().toString();
        String descrip="Buscó al vendedor "+prov;
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
    
    public inf_Mantenimiento_Vendedor() {
        initComponents();
        tablas();
        iniciar_combo();
        get_usuario();
        get_fecha();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        lbusu = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        cbox_empleado = new javax.swing.JComboBox<>();
        label4 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        lb = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        txt_porcentaje = new javax.swing.JTextField();
        label8 = new javax.swing.JLabel();
        txt_comision = new javax.swing.JTextField();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Vendedor");
        setVisible(true);

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Vendedor");

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Correo:");

        txt_correo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_correo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_correo.setOpaque(false);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tbl.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Vendedor", "ID Empleado", "Correo", "Telefono", "Direccion", "Porcentaje", "Comision"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl);

        cbox_empleado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_empleadoActionPerformed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("Empleado:");

        txt_telefono.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_telefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_telefono.setOpaque(false);

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Teléfono:");

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Dirección:");

        txt_direccion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_direccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_direccion.setOpaque(false);

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Porcentaje:");

        txt_porcentaje.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_porcentaje.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_porcentaje.setOpaque(false);

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("Comisión:");

        txt_comision.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_comision.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_comision.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label7)
                                .addGap(78, 78, 78)
                                .addComponent(txt_porcentaje, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label8)
                                .addGap(78, 78, 78)
                                .addComponent(txt_comision, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
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
                                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label6)
                                    .addGap(78, 78, 78)
                                    .addComponent(txt_direccion, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label3)
                                    .addComponent(label5)
                                    .addComponent(label4))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_telefono)
                                    .addComponent(txt_correo)
                                    .addComponent(cbox_empleado, 0, 263, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addGap(294, 294, 294))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label6)
                                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbox_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4)
                                .addComponent(lb)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label7)
                            .addComponent(txt_porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label8)
                            .addComponent(txt_comision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnEliminar)
                            .addComponent(btnModificar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(btnLimpiar))))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("delete from vendedor where id_vendedor = ?");

            pst.setString(1, txtbuscado.getText().trim());
            pst.executeUpdate();

             bitacora_eliminar();
            JOptionPane.showMessageDialog(this, "¡ELIMINACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txt_correo.setText("");

            cbox_empleado.setSelectedIndex(0);
            txt_correo.setText("");
            txt_telefono.setText("");
            txt_direccion.setText("");
            txt_porcentaje.setText("");
            txt_comision.setText("");
            txtbuscado.setText("");
            
            btnRegistrar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            tablas();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en Eliminacion", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into vendedor values(?,?,?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, cbox_empleado.getSelectedItem().toString());
            pst.setString(3, txt_correo.getText());
            pst.setString(4, txt_telefono.getText());
            pst.setString(5, txt_direccion.getText());
            pst.setString(6, txt_porcentaje.getText());
            pst.setString(7, txt_comision.getText());
            bitacora_guardar();
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            cbox_empleado.setSelectedIndex(0);
            txt_correo.setText("");
            txt_telefono.setText("");
            txt_direccion.setText("");
            txt_porcentaje.setText("");
            txt_comision.setText("");
            txtbuscado.setText("");

    
            tablas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from vendedor where id_vendedor =?");
            pst.setString(1, txtbuscado.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lb.setText(rs.getString("id_empleado"));
                txt_correo.setText(rs.getString("correo"));

                txt_telefono.setText(rs.getString("telefono"));
                txt_direccion.setText(rs.getString("direccion"));
                txt_porcentaje.setText(rs.getString("porcentaje"));
                txt_comision.setText(rs.getString("comision"));

                btnModificar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnRegistrar.setEnabled(false);
                tablas();

            } else {
                JOptionPane.showMessageDialog(null, "Vendedor no registrado.");
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
            PreparedStatement pst = cn.prepareStatement("update vendedor set  id_empleado = ?,correo =?, telefono = ?,direccion = ?, porcentaje = ?, comision = ? where id_vendedor =" + ID);

            pst.setString(1, lb.getText());
            pst.setString(2, txt_correo.getText());
            pst.setString(3, txt_telefono.getText());
            pst.setString(4, txt_direccion.getText());
            pst.setString(5, txt_porcentaje.getText());
            pst.setString(6, txt_comision.getText());

            pst.executeUpdate();

            bitacora_modificar();
            JOptionPane.showMessageDialog(this, "¡MODIFICACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            cbox_empleado.setSelectedIndex(0);
            txt_correo.setText("");
            txt_telefono.setText("");
            txt_direccion.setText("");
            txt_porcentaje.setText("");
            txt_comision.setText("");
            txtbuscado.setText("");

            txtbuscado.setText("");
            btnRegistrar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            tablas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en Modificacion", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cbox_empleado.setSelectedIndex(0);
            txt_correo.setText("");
            txt_telefono.setText("");
            txt_direccion.setText("");
            txt_porcentaje.setText("");
            txt_comision.setText("");
            txtbuscado.setText("");
        txtbuscado.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cbox_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_empleadoActionPerformed
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select id_empleado from empleado_contratado where id_empleado= ?");
            pst2.setString(1, cbox_empleado.getSelectedItem().toString());
            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                lb.setText(rs2.getString("id_empleado"));

            } else {
                if (cbox_empleado.getSelectedItem().toString().contains("Seleccione una opción")) {
                    txt_correo.setText("");
                    txt_telefono.setText("");
                    txt_direccion.setText("");
                    txt_telefono.setText("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_empleadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbox_empleado;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txt_comision;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_porcentaje;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
