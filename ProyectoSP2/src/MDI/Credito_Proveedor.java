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

/**
 *
 * @author ranbr
 */
public class Credito_Proveedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form Credito_Proveedor
     */
    
    /**
     *
     * Funcion para actualizar los combobox
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
        String compra=cbox_compra.getSelectedItem().toString();
        String descrip="Ingresó un credito para la compra "+compra;
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
        String compra=cbox_compra.getSelectedItem().toString().trim();
        String descrip="Modificó el credito de la compra "+compra;;
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
        String compra=cbox_compra.getSelectedItem().toString().trim();
        String descrip="Eliminó el credito de la compra "+compra;
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
        String compra=cbox_compra.getSelectedItem().toString().trim();
        String descrip="Buscó el credito para la compra "+compra;
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
    public void refrescar() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select nombre from proveedor ");
            ResultSet rss = psttt.executeQuery();

            cbox_proveedor.removeAllItems();
            cbox_proveedor.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_proveedor.addItem(rss.getString("nombre"));
            }
            
            PreparedStatement pstt = cn.prepareStatement("select nombre from sucursal ");
            ResultSet rs = pstt.executeQuery();

            cbox_sucursal.removeAllItems();
            cbox_sucursal.addItem("Seleccione una opción");
            while (rs.next()) {
                cbox_sucursal.addItem(rs.getString("nombre"));
            }
            
            PreparedStatement pstttt = cn.prepareStatement("select id_compraE from compra_encabezado ");
            ResultSet rsss = pstttt.executeQuery();

            cbox_compra.removeAllItems();
            cbox_compra.addItem("Seleccione una opción");
            while (rsss.next()) {
                cbox_compra.addItem(rsss.getString("id_compraE"));
            }
            
            PreparedStatement ps = cn.prepareStatement("select nombre_moneda from moneda ");
            ResultSet r = ps.executeQuery();

            cbox_moneda.removeAllItems();
            cbox_moneda.addItem("Seleccione una opción");
            while (r.next()) {
                cbox_moneda.addItem(r.getString("nombre_moneda"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     *
     * Funcion para poblar el combobox con la informacion correspondiente segun
     * la base de datos
     */
    public void iniciar_combo() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select nombre from proveedor ");
            ResultSet rss = psttt.executeQuery();

            cbox_proveedor.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_proveedor.addItem(rss.getString("nombre"));
            }
            
            PreparedStatement pstt = cn.prepareStatement("select nombre from sucursal ");
            ResultSet rs = pstt.executeQuery();

            
            cbox_sucursal.addItem("Seleccione una opción");
            while (rs.next()) {
                cbox_sucursal.addItem(rs.getString("nombre"));
            }
            
            PreparedStatement pstttt = cn.prepareStatement("select id_compraE from compra_encabezado ");
            ResultSet rsss = pstttt.executeQuery();

            
            cbox_compra.addItem("Seleccione una opción");
            while (rsss.next()) {
                cbox_compra.addItem(rsss.getString("id_compraE"));
            }
            
            PreparedStatement ps = cn.prepareStatement("select nombre_moneda from moneda ");
            ResultSet r = ps.executeQuery();

           
            cbox_moneda.addItem("Seleccione una opción");
            while (r.next()) {
                cbox_moneda.addItem(r.getString("nombre_moneda"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public Credito_Proveedor() {
        initComponents();
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

        label5 = new javax.swing.JLabel();
        txt_nombre3 = new javax.swing.JTextField();
        lbusu = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        cbox_proveedor = new javax.swing.JComboBox<>();
        label6 = new javax.swing.JLabel();
        cbox_sucursal = new javax.swing.JComboBox<>();
        label7 = new javax.swing.JLabel();
        cbox_compra = new javax.swing.JComboBox<>();
        label8 = new javax.swing.JLabel();
        cbox_moneda = new javax.swing.JComboBox<>();
        label9 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        txt_porcentaje = new javax.swing.JTextField();
        label4 = new javax.swing.JLabel();
        txt_interes = new javax.swing.JTextField();
        txt_cuota = new javax.swing.JTextField();
        label10 = new javax.swing.JLabel();
        label11 = new javax.swing.JLabel();
        txt_acumulado = new javax.swing.JTextField();
        label12 = new javax.swing.JLabel();
        txt_tiempo = new javax.swing.JTextField();
        cbox_tiempo = new javax.swing.JComboBox<>();
        label13 = new javax.swing.JLabel();
        cbox_moneda1 = new javax.swing.JComboBox<>();
        label14 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        txt_fecha_inicio = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txt_fecha_final = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Interes");

        txt_nombre3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_nombre3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_nombre3.setOpaque(false);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Credito Porveedor");
        setVisible(true);

        cbox_proveedor.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_proveedorActionPerformed(evt);
            }
        });

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Proveedor");

        cbox_sucursal.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_sucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_sucursalActionPerformed(evt);
            }
        });

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Sucursal");

        cbox_compra.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_compraActionPerformed(evt);
            }
        });

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("Compra Encabezado");

        cbox_moneda.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_moneda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_monedaActionPerformed(evt);
            }
        });

        label9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label9.setText("Moneda");

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Porcentaje");

        txt_porcentaje.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_porcentaje.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_porcentaje.setOpaque(false);

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("Interes");

        txt_interes.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_interes.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_interes.setOpaque(false);

        txt_cuota.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_cuota.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_cuota.setOpaque(false);

        label10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label10.setText("Cuota");

        label11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label11.setText("Pago Acumulado");

        txt_acumulado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_acumulado.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_acumulado.setOpaque(false);

        label12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label12.setText("Tiempo");

        txt_tiempo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_tiempo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_tiempo.setOpaque(false);

        cbox_tiempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dias", "meses", "años" }));

        label13.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label13.setText("Forma de pago");

        cbox_moneda1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        label14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label14.setText("Total");

        txt_total.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_total.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_total.setOpaque(false);

        jLabel6.setText("Fecha Inicio");

        jLabel7.setText("Fecha Final");

        lb.setText(".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(txt_fecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(txt_fecha_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label3)
                                .addGap(18, 18, 18)
                                .addComponent(txt_porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label9)
                                .addGap(28, 28, 28)
                                .addComponent(cbox_moneda, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label7)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbox_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_interes, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(label10)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_cuota, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(label11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_acumulado, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label13)
                                .addGap(18, 18, 18)
                                .addComponent(cbox_moneda1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label14)
                                .addGap(34, 34, 34)
                                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label12)
                                .addGap(18, 18, 18)
                                .addComponent(txt_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbox_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label6)
                        .addGap(18, 18, 18)
                        .addComponent(cbox_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(254, 254, 254)
                        .addComponent(label8)
                        .addGap(18, 18, 18)
                        .addComponent(cbox_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label6)
                    .addComponent(cbox_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label7)
                    .addComponent(cbox_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label8)
                    .addComponent(cbox_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label3)
                    .addComponent(txt_porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4)
                    .addComponent(txt_interes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label10)
                    .addComponent(txt_cuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label11)
                    .addComponent(txt_acumulado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label9)
                    .addComponent(cbox_moneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label13)
                    .addComponent(cbox_moneda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label12)
                    .addComponent(txt_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbox_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label14)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_fecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_fecha_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbox_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_proveedorActionPerformed
 try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select id_proveedor from proveedor where nombre = ?");
            pst2.setString(1, cbox_proveedor.getSelectedItem().toString());
            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                lb.setText(rs2.getString("id_proveedor"));

            } else {
                if (cbox_proveedor.getSelectedItem().toString().contains("Seleccione una opción")) {
                    txt_porcentaje.setText("");
                    txt_interes.setText("");
                    txt_cuota.setText("");
                    txt_acumulado.setText("");
                    txt_tiempo.setText("");
                    txt_total.setText("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
 // TODO add your handling code here:
    }//GEN-LAST:event_cbox_proveedorActionPerformed

    private void cbox_sucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_sucursalActionPerformed
try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select id_sucursal from sucursal where nombre = ?");
            pst2.setString(1, cbox_sucursal.getSelectedItem().toString());
            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                lb.setText(rs2.getString("id_sucursal"));

            } else {
                if (cbox_proveedor.getSelectedItem().toString().contains("Seleccione una opción")) {
                    txt_porcentaje.setText("");
                    txt_interes.setText("");
                    txt_cuota.setText("");
                    txt_acumulado.setText("");
                    txt_tiempo.setText("");
                    txt_total.setText("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_cbox_sucursalActionPerformed

    private void cbox_compraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_compraActionPerformed
try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select id_compraE from compra_encabezado where id_compraE = ?");
            pst2.setString(1, cbox_compra.getSelectedItem().toString());
            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                lb.setText(rs2.getString("id_compraE"));

            } else {
                if (cbox_proveedor.getSelectedItem().toString().contains("Seleccione una opción")) {
                    txt_porcentaje.setText("");
                    txt_interes.setText("");
                    txt_cuota.setText("");
                    txt_acumulado.setText("");
                    txt_tiempo.setText("");
                    txt_total.setText("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_cbox_compraActionPerformed

    private void cbox_monedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_monedaActionPerformed
try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select id_moneda from moneda where nombre_moneda = ?");
            pst2.setString(1, cbox_moneda.getSelectedItem().toString());
            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                lb.setText(rs2.getString("id_moneda"));

            } else {
                if (cbox_proveedor.getSelectedItem().toString().contains("Seleccione una opción")) {
                  
                    txt_tiempo.setText("");
                    txt_total.setText("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_cbox_monedaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbox_compra;
    private javax.swing.JComboBox<String> cbox_moneda;
    private javax.swing.JComboBox<String> cbox_moneda1;
    private javax.swing.JComboBox<String> cbox_proveedor;
    private javax.swing.JComboBox<String> cbox_sucursal;
    private javax.swing.JComboBox<String> cbox_tiempo;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label13;
    private javax.swing.JLabel label14;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTextField txt_acumulado;
    private javax.swing.JTextField txt_cuota;
    private com.toedter.calendar.JDateChooser txt_fecha_final;
    private com.toedter.calendar.JDateChooser txt_fecha_inicio;
    private javax.swing.JTextField txt_interes;
    private javax.swing.JTextField txt_nombre3;
    private javax.swing.JTextField txt_porcentaje;
    private javax.swing.JTextField txt_tiempo;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
