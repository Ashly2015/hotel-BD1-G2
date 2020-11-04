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
<<<<<<< HEAD
import java.util.Calendar;
=======
<<<<<<< HEAD
import java.util.Calendar;
=======
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angel
 */
public class Matenimiento_Inventario extends javax.swing.JInternalFrame {

    /**
     * Creates new form Matenimiento_Inventario
     */
    public void tablas() {
        try {

            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from inventario");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Id Inven.");
            modelo.addColumn("Id Tipo Inven.");
            modelo.addColumn("Id bodega");
            modelo.addColumn("id marca");
            modelo.addColumn("id linea");
            modelo.addColumn("Nombre");
            modelo.addColumn("Estado");
            modelo.addColumn("Precio");
            modelo.addColumn("Costo");
            modelo.addColumn("Existencia");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Fecha Exp.");

            tbl.setModel(modelo);
            String[] dato = new String[12];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(6);
                dato[6] = rss4.getString(7);
                dato[7] = rss4.getString(8);
                dato[8] = rss4.getString(9);
                dato[9] = rss4.getString(10);
                dato[10] = rss4.getString(11);
                dato[11] = rss4.getString(12);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refrescar() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst1 = cn.prepareStatement("select nombre from id_tipo_inventario");
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
            PreparedStatement pst2 = cn.prepareStatement("select nombre from bodega");
            PreparedStatement pst3 = cn.prepareStatement("select nombre from marca");
            PreparedStatement pst4 = cn.prepareStatement("select nombre from linea");

            ResultSet rs1 = pst1.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            ResultSet rs3 = pst3.executeQuery();
            ResultSet rs4 = pst4.executeQuery();

            cbox_tipo_Inventario.removeAllItems();
            cbox_Bodega.removeAllItems();
            cbox_Marca.removeAllItems();
            cbox_Linea.removeAllItems();
            cbox_tipo_Inventario.addItem("Seleccione una opción");
            cbox_Bodega.addItem("Seleccione una opción");
            cbox_Marca.addItem("Seleccione una opción");
            cbox_Linea.addItem("Seleccione una opción");

            while (rs1.next() && rs2.next() && rs3.next() && rs4.next()) {
                cbox_tipo_Inventario.addItem(rs1.getString("nombre"));
                cbox_Bodega.addItem(rs2.getString("nombre"));
                cbox_Marca.addItem(rs3.getString("nombre"));
                cbox_Linea.addItem(rs4.getString("nombre"));
<<<<<<< HEAD
=======
=======
            /*PreparedStatement pst2 = cn.prepareStatement("select nombre from bodega");
            PreparedStatement pst3 = cn.prepareStatement("select nombre from marca");
            PreparedStatement pst4 = cn.prepareStatement("select nombre from linea");*/
            
            ResultSet rs1 = pst1.executeQuery();
            /*ResultSet rs2 = pst2.executeQuery();
            ResultSet rs3 = pst3.executeQuery();
            ResultSet rs4 = pst4.executeQuery();*/

            cbox_tipo_Inventario.removeAllItems();
            /*cbox_tipo_Inventario.addItem("Seleccione una opción");
            cbox_Bodega.addItem("Seleccione una opción");
            cbox_Marca.addItem("Seleccione una opción");
            cbox_Linea.addItem("Seleccione una opción");*/
                    
            while (rs1.next() /*&& rs2.next() && rs3.next() && rs4.next()*/) {
                cbox_tipo_Inventario.addItem(rs1.getString("nombre"));
                /*cbox_Bodega.addItem(rs2.getString("nombre"));
                cbox_Marca.addItem(rs3.getString("nombre"));
                cbox_Linea.addItem(rs4.getString("nombre"));*/
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
            }
            tablas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablas();
    }

    public void iniciar_combo() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst1 = cn.prepareStatement("select nombre from tipo_inventario");
            PreparedStatement pst2 = cn.prepareStatement("select nombre from bodega");
            PreparedStatement pst3 = cn.prepareStatement("select nombre from marca");
            PreparedStatement pst4 = cn.prepareStatement("select nombre from linea");

            ResultSet rs1 = pst1.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            ResultSet rs3 = pst3.executeQuery();
            ResultSet rs4 = pst4.executeQuery();
<<<<<<< HEAD

=======
            
<<<<<<< HEAD
           
=======
            cbox_tipo_Inventario.removeAllItems();
            cbox_Bodega.removeAllItems();
            cbox_Marca.removeAllItems();
            cbox_Linea.removeAllItems();
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
            
>>>>>>> zuzu-ai-master
            cbox_tipo_Inventario.addItem("Seleccione una opción");
            cbox_Bodega.addItem("Seleccione una opción");
            cbox_Marca.addItem("Seleccione una opción");
            cbox_Linea.addItem("Seleccione una opción");

            while (rs1.next() && rs2.next() && rs3.next() && rs4.next()) {

                cbox_tipo_Inventario.addItem(rs1.getString("nombre"));
                cbox_Bodega.addItem(rs2.getString("nombre"));
                cbox_Marca.addItem(rs3.getString("nombre"));
                cbox_Linea.addItem(rs4.getString("nombre"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablas();
    }

    public Matenimiento_Inventario() {
        initComponents();
        tablas();
        iniciar_combo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLimpiar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        label6 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        txt_Existencia = new javax.swing.JTextField();
        txtbuscado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        label2 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        cbox_tipo_Inventario = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        label4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txt_nombre = new javax.swing.JTextField();
        label1 = new javax.swing.JLabel();
        cbox_Bodega = new javax.swing.JComboBox<>();
        label7 = new javax.swing.JLabel();
        cbox_Marca = new javax.swing.JComboBox<>();
        label9 = new javax.swing.JLabel();
        cbox_Linea = new javax.swing.JComboBox<>();
        label10 = new javax.swing.JLabel();
        txt_Descripcion = new javax.swing.JTextField();
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
        txt_FechaExp = new javax.swing.JTextField();
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
        label11 = new javax.swing.JLabel();
        label12 = new javax.swing.JLabel();
        label13 = new javax.swing.JLabel();
        txt_Precio = new javax.swing.JTextField();
        label14 = new javax.swing.JLabel();
        txt_costo = new javax.swing.JTextField();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
<<<<<<< HEAD
        txt_fecha = new com.toedter.calendar.JDateChooser();
        txt_Estado = new javax.swing.JTextField();
        label8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        activo = new javax.swing.JRadioButton();
        inactivo = new javax.swing.JRadioButton();
=======
<<<<<<< HEAD
        txt_fecha = new com.toedter.calendar.JDateChooser();
=======
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setVisible(true);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Existencia:");

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Nombre:");

        txt_Existencia.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_Existencia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_Existencia.setOpaque(false);

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

        label2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label2.setText("Resgistro De Inventarios:");

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        cbox_tipo_Inventario.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_tipo_Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_tipo_InventarioActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("Id Tipo Inventario:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txt_nombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_nombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_nombre.setOpaque(false);

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Inventarios Resgistrados");

        cbox_Bodega.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_Bodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_BodegaActionPerformed(evt);
            }
        });

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Id Bodega:");

        cbox_Marca.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_MarcaActionPerformed(evt);
            }
        });

        label9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label9.setText("Id Marca:");

        cbox_Linea.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_Linea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_LineaActionPerformed(evt);
            }
        });

        label10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label10.setText("Id Linea:");

        txt_Descripcion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_Descripcion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_Descripcion.setOpaque(false);

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
        txt_FechaExp.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_FechaExp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_FechaExp.setOpaque(false);
        txt_FechaExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FechaExpActionPerformed(evt);
            }
        });

>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
        label11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label11.setText("Fecha Caducidad:");

        label12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label12.setText("Precio:");

        label13.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label13.setText("Descripcion:");

        txt_Precio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_Precio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_Precio.setOpaque(false);

        label14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label14.setText("Costo:");

        txt_costo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_costo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_costo.setOpaque(false);

        lb1.setForeground(new java.awt.Color(204, 204, 204));

        lb2.setForeground(new java.awt.Color(204, 204, 204));

        lb3.setForeground(new java.awt.Color(204, 204, 204));

        lb4.setForeground(new java.awt.Color(204, 204, 204));

        txt_Estado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Estado.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_Estado.setOpaque(false);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(label2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label6)
                            .addComponent(label13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Existencia, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Descripcion)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(label7)
                                            .addComponent(label9)
                                            .addComponent(label10)
                                            .addComponent(label3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbox_Bodega, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(cbox_Linea, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(lb4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(cbox_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(lb3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(label8)
                                                .addGap(22, 22, 22)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txt_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(label14)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txt_costo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(label12)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txt_Precio)))))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbox_tipo_Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label11)
                        .addGap(18, 18, 18)
<<<<<<< HEAD
                        .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
=======
<<<<<<< HEAD
                        .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
=======
                        .addComponent(txt_FechaExp, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addGap(389, 389, 389))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label2)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbox_tipo_Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4)
                    .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbox_Bodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label7)
<<<<<<< HEAD
                    .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
=======
<<<<<<< HEAD
                    .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
=======
                    .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbox_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label9)
                    .addComponent(lb3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbox_Linea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label10)
                    .addComponent(lb4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label3)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(label8))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label12)
                    .addComponent(txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label14)
                    .addComponent(txt_costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_Existencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label11)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
<<<<<<< HEAD
=======
=======
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label11)
                    .addComponent(txt_FechaExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
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
                    .addComponent(btnLimpiar))
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        cbox_tipo_Inventario.setSelectedIndex(0);
        cbox_Bodega.setSelectedIndex(0);
        cbox_Marca.setSelectedIndex(0);
        cbox_Linea.setSelectedIndex(0);
        txt_nombre.setText("");
        txt_Estado.setText("");
        txt_Existencia.setText("");
        txt_Precio.setText("");
        txt_costo.setText("");
        txt_Descripcion.setText("");
<<<<<<< HEAD
        inactivo.setSelected(false);
        activo.setSelected(false);
        txt_fecha.setDate(null);
=======
<<<<<<< HEAD
        txt_fecha.setDate(null);
=======
        txt_FechaExp.setText("");
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtbuscado.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);

        refrescar();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {
            String ID = txtbuscado.getText().trim();

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> zuzu-ai-master
            int mes, dia, año;
            dia = txt_fecha.getCalendar().get(Calendar.DAY_OF_MONTH);
            mes = txt_fecha.getCalendar().get(Calendar.MONTH);
            año = txt_fecha.getCalendar().get(Calendar.YEAR);
            String fecha;
<<<<<<< HEAD
            fecha = año + "/" + mes + "/" + dia;

=======
            fecha = año + "/"+mes+"/"+dia;
            
=======
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("update inventario set id_tipo_inventario = ?, id_bodega = ?,id_marca = ?, id_linea = ?,nombre = ?,estatus = ?, precio = ?,costo = ?, existencia = ?,descripcion = ?, fecha_vencimiento = ? where id_inventario = " + ID);

            pst.setString(1, lb1.getText());
            pst.setString(2, lb2.getText());
            pst.setString(3, lb3.getText());
            pst.setString(4, lb4.getText());
            pst.setString(5, txt_nombre.getText());
            String mensaje = "";
             if (activo.isSelected()) {
                mensaje = "A";
            } else if (inactivo.isSelected()) {
                mensaje = "I";

            }
            pst.setString(6, mensaje);
            pst.setString(7, txt_Precio.getText());
            pst.setString(8, txt_costo.getText());
            pst.setString(9, txt_Existencia.getText());
            pst.setString(10, txt_Descripcion.getText());
<<<<<<< HEAD
            pst.setString(11, fecha);

=======
<<<<<<< HEAD
            pst.setString(11, fecha);
=======
            pst.setString(11, txt_FechaExp.getText());
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
            
>>>>>>> zuzu-ai-master
            pst.executeUpdate();

            //bitacora_modificar();
            JOptionPane.showMessageDialog(this, "¡MODIFICACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

            txt_nombre.setText("");
            txt_Estado.setText("");
            txt_Precio.setText("");
            txt_costo.setText("");
            txt_Existencia.setText("");
            txt_Descripcion.setText("");
<<<<<<< HEAD
            txt_fecha.setDate(null);
=======
<<<<<<< HEAD
            txt_fecha.setDate(null);
=======
            txt_FechaExp.setText("");
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
            txtbuscado.setText("");
            inactivo.setSelected(false);
            activo.setSelected(false);
            btnRegistrar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            tablas();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en Modificacion", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        refrescar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("delete from inventario where id_inventario = ?");

            pst.setString(1, txtbuscado.getText().trim());
            pst.executeUpdate();

            // bitacora_eliminar();
            JOptionPane.showMessageDialog(this, "¡ELIMINACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

            txt_nombre.setText("");
            txt_Estado.setText("");
            txt_Precio.setText("");
            txt_costo.setText("");
            txt_Existencia.setText("");
            txt_Descripcion.setText("");
<<<<<<< HEAD
            txt_fecha.setDate(null);
            inactivo.setSelected(false);
            activo.setSelected(false);
=======
<<<<<<< HEAD
            txt_fecha.setDate(null);
=======
            txt_FechaExp.setText("");
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
            txtbuscado.setText("");
            btnRegistrar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            tablas();
            refrescar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en Eliminacion", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cbox_tipo_InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_tipo_InventarioActionPerformed
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select id_tipo_inventario from tipo_inventario where nombre = ?");
            pst2.setString(1, cbox_tipo_Inventario.getSelectedItem().toString());
            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                lb1.setText(rs2.getString("id_tipo_inventario"));

            } else {
                if (cbox_tipo_Inventario.getSelectedItem().toString().contains("Seleccione una opción")) {
                    txt_nombre.setText("");
                    txt_Estado.setText("");
                    txt_Existencia.setText("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_tipo_InventarioActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        try {
<<<<<<< HEAD

=======
<<<<<<< HEAD
            
>>>>>>> zuzu-ai-master
            int mes, dia, año;
            dia = txt_fecha.getCalendar().get(Calendar.DAY_OF_MONTH);
            mes = txt_fecha.getCalendar().get(Calendar.MONTH);
            año = txt_fecha.getCalendar().get(Calendar.YEAR);
            String fecha;
<<<<<<< HEAD
            fecha = año + "/" + mes + "/" + dia;

=======
            fecha = año + "/"+mes+"/"+dia;
            
=======
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into inventario values(?,?,?,?,?,?,?,?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, lb1.getText());
            pst.setString(3, lb2.getText());
            pst.setString(4, lb3.getText());
            pst.setString(5, lb4.getText());
            pst.setString(6, txt_nombre.getText());
            pst.setString(7, "A");
            pst.setString(8, txt_Precio.getText());
            pst.setString(9, txt_costo.getText());
            pst.setString(10, txt_Existencia.getText());
            pst.setString(11, txt_Descripcion.getText());
<<<<<<< HEAD
            pst.setString(12, fecha);

=======
<<<<<<< HEAD
            pst.setString(12, fecha);
=======
            pst.setString(12, txt_FechaExp.getText());
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
            
>>>>>>> zuzu-ai-master
            //bitacora_guardar();
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
<<<<<<< HEAD

            cbox_tipo_Inventario.setSelectedIndex(0);
            cbox_Bodega.setSelectedIndex(0);
            cbox_Marca.setSelectedIndex(0);
            cbox_Linea.setSelectedIndex(0);
            txt_nombre.setText("");
            txt_Estado.setText("");
            txt_Existencia.setText("");
            txt_Precio.setText("");
            txt_costo.setText("");
            inactivo.setSelected(false);
            activo.setSelected(false);
            txt_Descripcion.setText("");
            txt_fecha.setDate(null);
=======
        
        cbox_tipo_Inventario.setSelectedIndex(0);
        cbox_Bodega.setSelectedIndex(0);
        cbox_Marca.setSelectedIndex(0);
        cbox_Linea.setSelectedIndex(0);
        txt_nombre.setText("");
        txt_Estado.setText("");
        txt_Existencia.setText("");
        txt_Precio.setText("");
        txt_costo.setText("");
        txt_Descripcion.setText("");
<<<<<<< HEAD
        txt_fecha.setDate(null);
=======
        txt_FechaExp.setText("");
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
            txtbuscado.setText("");
            txt_Estado.setText("");
            tablas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
<<<<<<< HEAD

=======
<<<<<<< HEAD
            
=======
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from inventario where id_inventario = ?");
            pst.setString(1, txtbuscado.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
<<<<<<< HEAD

=======
<<<<<<< HEAD
                                
=======

>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
                lb1.setText(rs.getString("id_tipo_inventario"));
                lb2.setText(rs.getString("id_bodega"));
                lb3.setText(rs.getString("id_marca"));
                lb4.setText(rs.getString("id_linea"));
                txt_nombre.setText(rs.getString("nombre"));
                txt_Estado.setText(rs.getString("estatus"));
                txt_Precio.setText(rs.getString("precio"));
                txt_costo.setText(rs.getString("costo"));
                txt_Existencia.setText(rs.getString("existencia"));
                txt_Descripcion.setText(rs.getString("descripcion"));
<<<<<<< HEAD
                txt_fecha.setDate(rs.getDate("fecha_vencimiento"));
=======
<<<<<<< HEAD
=======
                txt_FechaExp.setText(rs.getString("fecha_vencimiento"));
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
                btnModificar.setEnabled(true);
                txt_Descripcion.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnRegistrar.setEnabled(false);
                tablas();

            } else {
                JOptionPane.showMessageDialog(null, "Inventario no registrado.");
            }

        } catch (Exception e) {

        }

        // tablas();
        // bitacora_busqueda();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbox_BodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_BodegaActionPerformed
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select id_bodega from bodega where nombre = ?");
            pst2.setString(1, cbox_Bodega.getSelectedItem().toString());
            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                lb2.setText(rs2.getString("id_bodega"));

            } else {
                if (cbox_Bodega.getSelectedItem().toString().contains("Seleccione una opción")) {
                    txt_nombre.setText("");
                    txt_Estado.setText("");
                    txt_Existencia.setText("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_cbox_BodegaActionPerformed

    private void cbox_MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_MarcaActionPerformed
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select id_marca from marca where nombre = ?");
            pst2.setString(1, cbox_Marca.getSelectedItem().toString());
            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                lb3.setText(rs2.getString("id_marca"));

            } else {
                if (cbox_Marca.getSelectedItem().toString().contains("Seleccione una opción")) {
                    txt_nombre.setText("");
                    txt_Estado.setText("");
                    txt_Existencia.setText("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbox_MarcaActionPerformed

    private void cbox_LineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_LineaActionPerformed
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select id_linea from linea where nombre = ?");
            pst2.setString(1, cbox_Linea.getSelectedItem().toString());
            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                lb4.setText(rs2.getString("id_linea"));

            } else {
                if (cbox_Linea.getSelectedItem().toString().contains("Seleccione una opción")) {
                    txt_nombre.setText("");
                    txt_Estado.setText("");
                    txt_Existencia.setText("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbox_LineaActionPerformed

<<<<<<< HEAD
    private void activoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activoActionPerformed
        if(activo.isSelected()){

            txt_Estado.setText("A");
            inactivo.setSelected(false);
        }
=======
<<<<<<< HEAD
=======
    private void txt_FechaExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FechaExpActionPerformed
>>>>>>> zuzu-ai-master
        // TODO add your handling code here:
    }//GEN-LAST:event_activoActionPerformed

    private void inactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inactivoActionPerformed
        if(inactivo.isSelected()){

<<<<<<< HEAD
            txt_Estado.setText("I");
            activo.setSelected(false);
        }
=======
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
    private void txt_EstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_EstadoActionPerformed
>>>>>>> zuzu-ai-master
        // TODO add your handling code here:
    }//GEN-LAST:event_inactivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton activo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbox_Bodega;
    private javax.swing.JComboBox<String> cbox_Linea;
    private javax.swing.JComboBox<String> cbox_Marca;
    private javax.swing.JComboBox<String> cbox_tipo_Inventario;
    private javax.swing.JRadioButton inactivo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label13;
    private javax.swing.JLabel label14;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txt_Descripcion;
    private javax.swing.JTextField txt_Estado;
    private javax.swing.JTextField txt_Existencia;
<<<<<<< HEAD
    private javax.swing.JTextField txt_Precio;
    private javax.swing.JTextField txt_costo;
    private com.toedter.calendar.JDateChooser txt_fecha;
=======
<<<<<<< HEAD
    private javax.swing.JTextField txt_Precio;
    private javax.swing.JTextField txt_costo;
    private com.toedter.calendar.JDateChooser txt_fecha;
=======
    private javax.swing.JTextField txt_FechaExp;
    private javax.swing.JTextField txt_Precio;
    private javax.swing.JTextField txt_costo;
>>>>>>> 95cc82cc3e3e9947518f06cd9bee57cb60a4e61a
>>>>>>> zuzu-ai-master
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
