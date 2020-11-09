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
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ranbr
 */
public class inf_RegistroPartida extends javax.swing.JInternalFrame {

    public void tablas() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(6);
                dato[6] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public void get_fecha(){
        Calendar c1 = Calendar.getInstance();
                date_fecha.setCalendar(c1);
    }
    
    
    public void iniciar_cboxoperacion() {
            
            //cbox_operacion.removeAllItems();

            cbox_operacion.addItem("Seleccione una opción");

                cbox_operacion.addItem("Cargo");
                cbox_operacion.addItem("Abono");
    }
    
    public void iniciar_cbox() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario,mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select nombre_cuenta from cuenta_contable");
            ResultSet rs = pst.executeQuery();
            
            //cbox_cargo.removeAllItems();
            //cbox_abono.removeAllItems();

            cbox_cargo.addItem("Seleccione una opción");
            cbox_abono.addItem("Seleccione una opción");
            while (rs.next()) {
                cbox_cargo.addItem(rs.getString("nombre_cuenta"));
                cbox_abono.addItem(rs.getString("nombre_cuenta"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void iniciar_cboxquienc() {
        String tabla=cbox_cargo.getSelectedItem().toString();
        String dato="nombre_"+tabla;
        try {
                cbox_quienc.removeAllItems();
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario,mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select"+dato+" from "+tabla);       
            ResultSet rs = pst.executeQuery();
            cbox_quienc.addItem("Seleccione una opción");
            
           
            while (rs.next()) {
                cbox_quienc.addItem(rs.getString(dato));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void iniciar_cboxquiena() {
        
        String tabla=cbox_abono.getSelectedItem().toString().trim();
        String dato="nombre_"+tabla;

        
        try {
                cbox_quiena.removeAllItems();
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario,mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select "+dato+" from "+ tabla);
            
            ResultSet rs = pst.executeQuery();
            

            cbox_quiena.addItem("Seleccione una opción");
            while (rs.next()) {
                cbox_quiena.addItem(rs.getString(dato));
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void comprobar_desigualdad(){
        String cuenta_c=cbox_quienc.getSelectedItem().toString();
        String cuenta_a=cbox_quiena.getSelectedItem().toString();
        
        if(cuenta_c.equals(cuenta_a)){
            JOptionPane.showMessageDialog(this, "Las cuentas en cargo y abono no pueden ser iguales", "Warning", JOptionPane.WARNING_MESSAGE);
        
    }
    }
    
    public void remover(){
        cbox_quiena.removeAllItems();
        cbox_quienc.removeAllItems();
        
    }
    
    public void buscar_nombrecc(){
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select nombre_cuenta from cuenta_contable where id_cuenta = ?");

            pst.setString(1, lb2.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                cc.setText(rs.getString("nombre_cuenta"));
                String cuenta = cc.getText();

                cbox_cargo.setSelectedItem(cuenta);

            }

        } catch (Exception e) {

        }
    
    }
                
    public void buscar_nombreca(){
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select nombre_cuenta from cuenta_contable where id_cuenta = ?");

            pst.setString(1, lb3.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                ca.setText(rs.getString("nombre_cuenta"));
                String cuenta = ca.getText();

                cbox_abono.setSelectedItem(cuenta);

            }

        } catch (Exception e) {

        }
    }
                
    public void buscar_nombreqc(){
        try {
            String nombre_tabla=cbox_cargo.getSelectedItem().toString();
            String dato="nombre_"+nombre_tabla;
            String val="id_"+nombre_tabla;

            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select "+dato+" from "+nombre_tabla+" where"+val+"= ?");

            pst.setString(1, label.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                cbox_quienc.setSelectedItem(rs.getString(dato));


            }

        } catch (Exception e) {

        }
    }
                
    public void buscar_nombreqa(){
        try {
            String nombre_tabla=cbox_abono.getSelectedItem().toString();
            String dato="nombre_"+nombre_tabla;
            String val="id_"+nombre_tabla;
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select "+dato+" from "+nombre_tabla+" where"+val+" = ?");

            pst.setString(1, lb5.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                cbox_quiena.setSelectedItem(rs.getString(dato));

            }

        } catch (Exception e) {

        }
    }
    
    public void buscar_operacion(){
        String codigo=lb1.getText();
        if(codigo.equals("1")){
            cbox_operacion.setSelectedIndex(1);
        }
        else{
            if(codigo.equals("2")){
                cbox_operacion.setSelectedIndex(2);
            }
            else{
                cbox_operacion.setSelectedIndex(0);
            }
        }
    }
    
    public void iniciar_busquedac() {
        String tabla=cbox_cargo.getSelectedItem().toString();
        String dato="nombre_"+tabla;
        try {
                cbox_quienc.removeAllItems();
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario,mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select "+dato+" from "+tabla);       
            ResultSet rs = pst.executeQuery();
            cbox_quienc.addItem("Seleccione una opción");
            
           
            while (rs.next()) {
                cbox_quienc.addItem(rs.getString(dato));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        buscar_nombreqc();
    }
    public void iniciar_busquedaa() {
        
        String tabla=cbox_abono.getSelectedItem().toString().trim();
        String dato="nombre_"+tabla;

        
        try {
                cbox_quiena.removeAllItems();
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario,mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select "+dato+" from "+ tabla);
            
            ResultSet rs = pst.executeQuery();
            

            cbox_quiena.addItem("Seleccione una opción");
            while (rs.next()) {
                cbox_quiena.addItem(rs.getString(dato));
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        buscar_nombreqa();
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
   

    /**
     * Creates new form inf_Mantenimiento_Cliente
     */
    public inf_RegistroPartida() {
        initComponents();
        tablas();
        get_fecha();
        iniciar_cboxoperacion();
        iniciar_cbox();
        
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
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
        qa = new javax.swing.JLabel();
        cc = new javax.swing.JLabel();
        ca = new javax.swing.JLabel();
        qc = new javax.swing.JLabel();
        oper = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        cbox_quienc = new javax.swing.JComboBox<>();
        carga = new javax.swing.JLabel();
        cbox_quiena = new javax.swing.JComboBox<>();
        abona = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbox_operacion = new javax.swing.JComboBox<>();
        buscar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        date_fecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        cbox_cargo = new javax.swing.JComboBox<>();
        cbox_abono = new javax.swing.JComboBox<>();
        lb3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        label = new javax.swing.JLabel();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        qa.setText("jLabel6");

        cc.setText("jLabel6");

        ca.setText("jLabel6");

        qc.setText("jLabel6");

        oper.setText("jLabel6");

        lb5.setText("jLabel6");

        lb6.setText("jLabel10");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro de Partidas Libro Diario");
        setVisible(true);

        cbox_quienc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_quiencActionPerformed(evt);
            }
        });

        cbox_quiena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_quienaActionPerformed(evt);
            }
        });

        jLabel7.setText("Quién");

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("TIPO DE OPERACION");

        cbox_operacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_operacionActionPerformed(evt);
            }
        });

        jLabel9.setText("Cantidad En Numeros");

        jLabel2.setText("Fecha");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("MOVIMIENTO CONTABLE");

        jLabel4.setText("Cargo");

        jLabel8.setText("Cuentas");

        jLabel5.setText("Abono");

        cbox_cargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_cargoActionPerformed(evt);
            }
        });

        cbox_abono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_abonoActionPerformed(evt);
            }
        });

        tbl1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Operacion", "Fecha", "Cuenta Cargo", "Cuenta Abono", "Quien Carga", "Quien Abona"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegistrar)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar)
                                .addGap(30, 30, 30)
                                .addComponent(btnEliminar)
                                .addGap(33, 33, 33)
                                .addComponent(btnLimpiar)
                                .addGap(26, 26, 26)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(281, 281, 281)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(67, 67, 67)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(cbox_operacion, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel4)
                                                        .addGap(199, 199, 199)
                                                        .addComponent(jLabel5))
                                                    .addComponent(jLabel3))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGap(12, 12, 12)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addComponent(jLabel2)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(date_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(220, 220, 220))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(145, 145, 145))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addComponent(jLabel8)
                                                            .addGap(257, 257, 257)))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cbox_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lb3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbox_abono, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cbox_quienc, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(carga, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(82, 82, 82)
                                                .addComponent(cbox_quiena, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(abona, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbox_operacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(date_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbox_cargo)
                                .addComponent(cbox_abono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lb3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbox_quienc)
                                .addComponent(cbox_quiena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(abona, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(carga, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar)
                    .addComponent(btnRegistrar)
                    .addComponent(btnBuscar)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbox_quiencActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_quiencActionPerformed
        // TODO add your handling code here:
        String tabla=cbox_cargo.getSelectedItem().toString();
        String dato="id_"+tabla;
        String val="nombre_"+tabla;
        try {

            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst = cn.prepareStatement("select"+dato+" from "+tabla+" where "+val+"= ?");
            pst.setString(1, cbox_quienc.getSelectedItem().toString().trim());
            ResultSet rs2 = pst.executeQuery();

            if (rs2.next()) {
                carga.setText(rs2.getString(dato));

            } else {
                if (cbox_quienc.getSelectedItem().toString().contains("Seleccione una opción")) {

                    carga.setText("");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbox_quiencActionPerformed

    private void cbox_quienaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_quienaActionPerformed
        // TODO add your handling code here:

        String tabla=cbox_abono.getSelectedItem().toString();
        String dato="id_"+tabla;
        String val="nombre_"+tabla;
        try {

            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst = cn.prepareStatement("select"+dato+" from "+tabla+" where "+val+"= ?");
            pst.setString(1, cbox_quiena.getSelectedItem().toString().trim());
            ResultSet rs2 = pst.executeQuery();

            if (rs2.next()) {
                abona.setText(rs2.getString(dato));

            } else {
                if (cbox_quiena.getSelectedItem().toString().contains("Seleccione una opción")) {

                    abona.setText("");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbox_quienaActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        cbox_operacion.setSelectedIndex(0);
        cbox_cargo.setSelectedIndex(0);
        cbox_abono.setSelectedIndex(0);
        get_fecha();

        remover();

        lb1.setText("");
        lb2.setText("");
        lb3.setText("");
        carga.setText("");
        abona.setText("");
        txt_cantidad.setText("");
        buscar.setText("");

        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from registro_contable where codigo = ?");

            pst.setString(1,buscar.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lb1.setText(rs.getString("codigo"));
                date_fecha.setDate(rs.getDate("fecha_operacion"));
                lb2.setText(rs.getString("cuenta_cargo"));
                lb3.setText(rs.getString("cuenta_abono"));
                txt_cantidad.setText(rs.getString("cantidad"));
                label.setText(rs.getString("quien_carga"));
                lb5.setText(rs.getString("quien_abona"));

                buscar_operacion();
                buscar_nombrecc();
                buscar_nombreca();
                iniciar_busquedac();
                iniciar_busquedaa();

                //bitacora_busqueda();

                btnEliminar.setEnabled(true);
                btnModificar.setEnabled(true);
                btnRegistrar.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(this, "Ajuste no registrado", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst2 = cn.prepareStatement("delete from registro_contable where codigo = ?");

            pst2.setString(1, buscar.getText().trim());
            pst2.executeUpdate();

            cbox_operacion.setSelectedIndex(0);
            get_fecha();
            cbox_cargo.setSelectedIndex(0);
            cbox_abono.setSelectedIndex(0);
            remover();
            lb1.setText("");
            lb2.setText("");
            lb3.setText("");
            carga.setText("");
            abona.setText("");
            txt_cantidad.setText("");
            buscar.setText("");

            btnRegistrar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);

            JOptionPane.showMessageDialog(this, "¡ELIMINACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en eliminación", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        java.util.Date fechaN = date_fecha.getDate();
        long fecha = fechaN.getTime();
        java.sql.Date dateN = new java.sql.Date(fecha);

        try {
            String ID = buscar.getText().trim();
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("update registro_contable set codigo = ?, fecha_operacion = ?, cuenta_cargo = ?, cuenta_abono=?, cantidad=?, quien_carga=?, quien_abona=? where codigo=" + ID);

            pst2.setString(1, lb1.getText());
            pst2.setString(2, dateN.toString());
            pst2.setString(3, lb2.getText());
            pst2.setString(4, lb3.getText());
            pst2.setString(5, txt_cantidad.getText());
            pst2.setString(6, carga.getText());
            pst2.setString(7, abona.getText());

            pst2.executeUpdate();

            //bitacora_modificar();
            cbox_operacion.setSelectedIndex(0);
            cbox_cargo.setSelectedIndex(0);
            cbox_abono.setSelectedIndex(0);
            remover();
            get_fecha();
            txt_cantidad.setText("");
            lb1.setText("");
            lb2.setText("");
            lb3.setText("");
            carga.setText("");
            abona.setText("");
            buscar.setText("");

            btnRegistrar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);

            JOptionPane.showMessageDialog(this, "¡MODIFICACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en modificación", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        java.util.Date fechaN = date_fecha.getDate();
        long fecha = fechaN.getTime();
        java.sql.Date dateN = new java.sql.Date(fecha);

        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD,mdi_Principal.Usuario,mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("insert into registro_contable values(?,?,?,?,?,?,?,?)");

            pst2.setString(1, "0");
            pst2.setString(2, lb1.getText());
            pst2.setString(3, dateN.toString());
            pst2.setString(4, lb2.getText());
            pst2.setString(5, lb3.getText());
            pst2.setString(6, txt_cantidad.getText());
            pst2.setString(7, carga.getText().trim());
            pst2.setString(8, abona.getText().trim());

            pst2.executeUpdate();

            //bitacora_guardar();
            cbox_operacion.setSelectedIndex(0);
            cbox_cargo.setSelectedIndex(0);
            cbox_abono.setSelectedIndex(0);
            remover();
            get_fecha();
            txt_cantidad.setText("");
            lb1.setText("");
            lb2.setText("");
            lb3.setText("");
            carga.setText("");
            abona.setText("");
            buscar.setText("");

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cbox_operacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_operacionActionPerformed
        // TODO add your handling code here:
        String seleccion=cbox_operacion.getSelectedItem().toString();

        if (seleccion.equals("Cargo")) {
            lb1.setText("1");

        } else{
            if(cbox_operacion.getSelectedItem().toString().contains("Abono")) {

                lb1.setText("2");
            }
        }
        if(cbox_operacion.getSelectedItem().toString().contains("Seleccione una opción")){
            lb1.setText("");
        }
    }//GEN-LAST:event_cbox_operacionActionPerformed

    private void cbox_cargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_cargoActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst = cn.prepareStatement("select id_cuenta from cuenta_contable where nombre_cuenta= ?");
            pst.setString(1, cbox_cargo.getSelectedItem().toString().trim());
            ResultSet rs2 = pst.executeQuery();

            if (rs2.next()) {
                lb3.setText(rs2.getString("id_cuenta"));

            } else {
                if (cbox_cargo.getSelectedItem().toString().contains("Seleccione una opción")) {

                    lb3.setText("");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        iniciar_cboxquienc();

    }//GEN-LAST:event_cbox_cargoActionPerformed

    private void cbox_abonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_abonoActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst = cn.prepareStatement("select codigo_cuenta from cuenta_contable where nombre_cuenta= ?");
            pst.setString(1, cbox_abono.getSelectedItem().toString());
            ResultSet rs2 = pst.executeQuery();

            if (rs2.next()) {
                label.setText(rs2.getString("id_cuenta"));

            } else {
                if (cbox_abono.getSelectedItem().toString().contains("Seleccione una opción")) {

                    label.setText("");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        iniciar_cboxquiena();
    }//GEN-LAST:event_cbox_abonoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel abona;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JTextField buscar;
    private javax.swing.JLabel ca;
    private javax.swing.JLabel carga;
    private javax.swing.JComboBox<String> cbox_abono;
    private javax.swing.JComboBox<String> cbox_cargo;
    private javax.swing.JComboBox<String> cbox_operacion;
    private javax.swing.JComboBox<String> cbox_quiena;
    private javax.swing.JComboBox<String> cbox_quienc;
    private javax.swing.JLabel cc;
    private com.toedter.calendar.JDateChooser date_fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel oper;
    private javax.swing.JLabel qa;
    private javax.swing.JLabel qc;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txt_cantidad;
    // End of variables declaration//GEN-END:variables
}
