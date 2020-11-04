/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SEBAS
 */
public class inf_Mantenimiento_Serie extends javax.swing.JInternalFrame {

    public void tablas() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
            PreparedStatement pstt4 = cn.prepareStatement("select * from serie");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID Serie");
            modelo.addColumn("ID Sucursal");
            modelo.addColumn("ID Caja");
            modelo.addColumn("Tipo");
            
<<<<<<< HEAD
=======
=======
            PreparedStatement pstt4 = cn.prepareStatement("select * from cliente");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID Cliente");
            modelo.addColumn("ID Tipo Cliente");
            modelo.addColumn("Nombre Cliente");
            modelo.addColumn("Correo");
            modelo.addColumn("Telefono");
            modelo.addColumn("Direccion");
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
            tbl.setModel(modelo);
            String[] dato = new String[6];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
<<<<<<< HEAD
                
=======
<<<<<<< HEAD
                
=======
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(6);
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master

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
            PreparedStatement psttt = cn.prepareStatement("select nombre from sucursal ");
            ResultSet rss = psttt.executeQuery();

            PreparedStatement psttt1 = cn.prepareStatement("select nombre from sucursal ");
            ResultSet rss1 = psttt1.executeQuery();
            
            cbox_tipo_sucursal.removeAllItems();
            cbox_tipo_sucursal.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_tipo_sucursal.addItem(rss.getString("nombre"));
            }
            
            cbox_caja.removeAllItems();
            cbox_caja.addItem("Seleccione una opción");
            while (rss1.next()) {
                cbox_caja.addItem(rss.getString("id_caja"));
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
    public void iniciar_combo1() {
        try {
            //Inicializacion de combo box de sucursal
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            
            PreparedStatement psttt = cn.prepareStatement("select nombre from sucursal ");
            ResultSet rss = psttt.executeQuery();

            cbox_tipo_sucursal.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_tipo_sucursal.addItem(rss.getString("nombre"));
            }
<<<<<<< HEAD
            
            
=======
<<<<<<< HEAD
            
            
=======
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master

        } catch (Exception e) {
            e.printStackTrace();
        }
        tablas();
    }

        public void iniciar_combo2() {
        try {
            //Inicializacion de combo box de sucursal
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            
            PreparedStatement psttt = cn.prepareStatement("select id_caja from caja ");
            ResultSet rss = psttt.executeQuery();

            cbox_caja.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_caja.addItem(rss.getString("id_caja"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        tablas();
    }

    /**
     * Creates new form inf_Mantenimiento_Serie
     */
    public inf_Mantenimiento_Serie() {
        initComponents();
        tablas();
        iniciar_combo1();
        iniciar_combo2();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        txt_tipo = new javax.swing.JTextField();
<<<<<<< HEAD
=======
=======
        txt_correo = new javax.swing.JTextField();
        label1 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        label6 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        txtbuscado = new javax.swing.JTextField();
        label7 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
        btnLimpiar = new javax.swing.JButton();
        lb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        cbox_tipo_sucursal = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        label4 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        cbox_caja = new javax.swing.JComboBox<>();
<<<<<<< HEAD
        lb2 = new javax.swing.JLabel();
=======
<<<<<<< HEAD
        lb2 = new javax.swing.JLabel();
=======
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setVisible(true);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Serie");
=======
<<<<<<< HEAD
        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Serie");
=======
        txt_correo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_correo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_correo.setOpaque(false);

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Cliente");

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Correo Cliente:");
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Tipo:");

        txt_tipo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_tipo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_tipo.setOpaque(false);
<<<<<<< HEAD
=======
=======
        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Telefono Cliente:");

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Nombre Cliente:");

        txt_telefono.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_telefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_telefono.setOpaque(false);

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Direccion Cliente:");

        txt_nombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_nombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_nombre.setOpaque(false);

        txt_direccion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_direccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_direccion.setOpaque(false);
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");

        tbl.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Cliente", "ID Tipo Cliente", "Nombre Cliente", "Correo", "Telefono", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        cbox_tipo_sucursal.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_tipo_sucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_tipo_sucursalActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("Tipo Sucursal:");

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("Caja");

        cbox_caja.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_caja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_cajaActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        lb2.setForeground(new java.awt.Color(204, 204, 204));

=======
<<<<<<< HEAD
        lb2.setForeground(new java.awt.Color(204, 204, 204));

=======
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                        .addGap(26, 26, 26)
=======
<<<<<<< HEAD
                        .addGap(26, 26, 26)
=======
                        .addGap(29, 29, 29)
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label3)
                                .addGap(23, 23, 23)
                                .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label4)
                                    .addComponent(label8))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbox_caja, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbox_tipo_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb)
                            .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(label1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
<<<<<<< HEAD
=======
=======
                            .addComponent(label4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label6)
                                        .addComponent(label7))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_telefono)
                                        .addComponent(txt_direccion)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label3)
                                        .addComponent(label5))
                                    .addGap(23, 23, 23)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_correo)
                                        .addComponent(txt_nombre))))
                            .addComponent(label8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbox_caja, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbox_tipo_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 125, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addGap(294, 294, 294))))
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(label1)
                        .addGap(4, 4, 4)
<<<<<<< HEAD
=======
=======
                .addComponent(label1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbox_tipo_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4)
                            .addComponent(lb))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbox_caja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
                            .addComponent(label8)
                            .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3))
                        .addGap(53, 53, 53)
<<<<<<< HEAD
=======
=======
                            .addComponent(label8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnEliminar)
                            .addComponent(btnModificar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(btnLimpiar))))
<<<<<<< HEAD
                .addContainerGap(100, Short.MAX_VALUE))
=======
<<<<<<< HEAD
                .addContainerGap(100, Short.MAX_VALUE))
=======
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String buscar = txtbuscado.getText().trim();
        if (buscar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡No se ingreso el campo de busqueda!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
            //Tipo sucursal
            PreparedStatement pst = cn.prepareStatement("select * from serie where id_serie =?");
            pst.setString(1, txtbuscado.getText().trim());
            
          

            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                lb.setText(rs.getString("id_sucursal"));
                 lb2.setText(rs.getString("id_caja"));
                txt_tipo.setText(rs.getString("tipo"));
<<<<<<< HEAD
=======
=======
            PreparedStatement pst = cn.prepareStatement("select * from cliente where id_cliente =?");
            pst.setString(1, txtbuscado.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lb.setText(rs.getString("id_tipo_cliente"));
                txt_nombre.setText(rs.getString("nombre_cliente"));

                txt_correo.setText(rs.getString("correo"));
                txt_telefono.setText(rs.getString("telefono"));
                txt_direccion.setText(rs.getString("direccion"));
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master

                btnModificar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnRegistrar.setEnabled(false);
                tablas();

            } else {
                JOptionPane.showMessageDialog(null, "Cliente no registrado.");
            }

        } catch (Exception e) {

        }

        // tablas();
        // bitacora_busqueda();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {
            String ID = txtbuscado.getText().trim();

            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
            PreparedStatement pst = cn.prepareStatement("update serie set id_sucursal =?, id_caja = ?,tipo = ? where id_serie =" + ID);

            pst.setString(1, lb.getText());
            pst.setString(2, lb2.getText());
            pst.setString(3, txt_tipo.getText());
          
<<<<<<< HEAD
=======
=======
            PreparedStatement pst = cn.prepareStatement("update serie set  id_tipo_cliente = ?,nombre_cliente =?, correo = ?,telefono = ?, direccion = ? where id_cliente =" + ID);

            pst.setString(1, lb.getText());
            pst.setString(2, txt_nombre.getText());
            pst.setString(3, txt_correo.getText());
            pst.setString(4, txt_telefono.getText());
            pst.setString(5, txt_direccion.getText());
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master

            pst.executeUpdate();

            //bitacora_modificar();
            JOptionPane.showMessageDialog(this, "¡MODIFICACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
<<<<<<< HEAD
            txt_tipo.setText("");

=======
<<<<<<< HEAD
            txt_tipo.setText("");

=======
            txt_nombre.setText("");
            txt_correo.setText("");
            txt_telefono.setText("");
            txt_direccion.setText("");
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master

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
<<<<<<< HEAD
        txt_tipo.setText("");
   
=======
<<<<<<< HEAD
        txt_tipo.setText("");
   
=======
        txt_nombre.setText("");
        txt_correo.setText("");
        txt_telefono.setText("");
        txt_direccion.setText("");
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
        cbox_tipo_sucursal.setSelectedIndex(0);
        txtbuscado.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
<<<<<<< HEAD
            PreparedStatement pst = cn.prepareStatement("delete from serie where id_serie = ?");
=======
<<<<<<< HEAD
            PreparedStatement pst = cn.prepareStatement("delete from serie where id_serie = ?");
=======
            PreparedStatement pst = cn.prepareStatement("delete from cliente where id_cliente = ?");
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master

            pst.setString(1, txtbuscado.getText().trim());
            pst.executeUpdate();

            // bitacora_eliminar();
            JOptionPane.showMessageDialog(this, "¡ELIMINACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
            txt_tipo.setText("");

            cbox_tipo_sucursal.setSelectedIndex(0);
     
<<<<<<< HEAD
=======
=======
            txt_nombre.setText("");

            cbox_tipo_sucursal.setSelectedIndex(0);
            txt_correo.setText("");
            txt_telefono.setText("");
            txt_direccion.setText("");
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
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

    private void cbox_tipo_sucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_tipo_sucursalActionPerformed

        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

<<<<<<< HEAD
            PreparedStatement pst2 = cn.prepareStatement("select id_sucursal from sucursal where nombre = ?");
=======
<<<<<<< HEAD
            PreparedStatement pst2 = cn.prepareStatement("select id_sucursal from sucursal where nombre = ?");
=======
            PreparedStatement pst2 = cn.prepareStatement("select id_tipo_cliente from tipo_cliente where nombre = ?");
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
            pst2.setString(1, cbox_tipo_sucursal.getSelectedItem().toString());
            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
                lb.setText(rs2.getString("id_sucursal"));

            } else {
                if (cbox_tipo_sucursal.getSelectedItem().toString().contains("Seleccione una opción")) {
                    //txt_tipo.setText("");
                    
<<<<<<< HEAD
=======
=======
                lb.setText(rs2.getString("id_tipo_cliente"));

            } else {
                if (cbox_tipo_sucursal.getSelectedItem().toString().contains("Seleccione una opción")) {
                    txt_nombre.setText("");
                    txt_correo.setText("");
                    txt_telefono.setText("");
                    txt_direccion.setText("");
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_tipo_sucursalActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
            PreparedStatement pst = cn.prepareStatement("insert into serie values(?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, lb.getText().trim());
            pst.setString(3, lb2.getText().trim());
            pst.setString(4, txt_tipo.getText());
           
<<<<<<< HEAD
=======
=======
            PreparedStatement pst = cn.prepareStatement("insert into cliente values(?,?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, lb.getText());
            pst.setString(3, txt_nombre.getText());
            pst.setString(4, txt_correo.getText());
            pst.setString(5, txt_telefono.getText());
            pst.setString(6, txt_direccion.getText());
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master

            //bitacora_guardar();
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
            txt_tipo.setText("");
            lb.setText("");
            lb2.setText("");
            txtbuscado.setText("");
            
            tablas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
<<<<<<< HEAD
=======
=======
            txt_nombre.setText("");
            txt_correo.setText("");
            txt_telefono.setText("");
            txt_direccion.setText("");

            txtbuscado.setText("");
            txt_correo.setText("");
            tablas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
        }
        refrescar();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cbox_cajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_cajaActionPerformed
        // TODO add your handling code here:
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
        
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst1 = cn.prepareStatement("select id_caja from caja where id_caja = ?");
            pst1.setString(1, cbox_caja.getSelectedItem().toString());
            ResultSet rs1 = pst1.executeQuery();

            if (rs1.next()) {
                lb2.setText(rs1.getString("id_caja"));
                

            } else {
                if (cbox_caja.getSelectedItem().toString().contains("Seleccione una opción")) {
                    //txt_tipo.setText("");
                    
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

<<<<<<< HEAD
=======
=======
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
    }//GEN-LAST:event_cbox_cajaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbox_caja;
    private javax.swing.JComboBox<String> cbox_tipo_sucursal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
    private javax.swing.JLabel label8;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txt_tipo;
<<<<<<< HEAD
=======
=======
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel lb;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
