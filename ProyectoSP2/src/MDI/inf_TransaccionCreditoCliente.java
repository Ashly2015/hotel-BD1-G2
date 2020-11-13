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
 * @author SEBAS
 */
public class inf_TransaccionCreditoCliente extends javax.swing.JInternalFrame {

     
     DefaultTableModel model = new DefaultTableModel();
    String subtotal;
    
 public void tablas() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from credito_cliente");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Cliente");
            modelo.addColumn("Sucursal");
            modelo.addColumn("Venta");
            modelo.addColumn("Moneda");
            modelo.addColumn("Porcentaje");
            modelo.addColumn("Interes");
            modelo.addColumn("Cuota");
            modelo.addColumn("Pago Acumulado");
            modelo.addColumn("Tiempo Pago");
            modelo.addColumn("Tipo Tiempo");
            modelo.addColumn("Forma Pago");
            modelo.addColumn("Total");
            modelo.addColumn("Fecha Inicio");
            modelo.addColumn("Fecha Final");
            
            tbl1.setModel(modelo);
            String[] dato = new String[20];
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
                dato[12] = rss4.getString(13);
                dato[13] = rss4.getString(14);
                dato[14] = rss4.getString(15);
                

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void iniciar_cboxcliente() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select * from cliente");
            ResultSet rss = psttt.executeQuery();

            cbox_cliente.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_cliente.addItem(rss.getString("nombre_cliente"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
        
 public void iniciar_cboxsucursal() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select * from sucursal");
            ResultSet rss = psttt.executeQuery();

            cbox_sucursal.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_sucursal.addItem(rss.getString("nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
  public void iniciar_cboxventa() {
        try {
            cbox_venta.removeAllItems();
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select * from venta_encabezado where id_cliente=?");
            psttt.setString(1,lb1.getText());
            ResultSet rss = psttt.executeQuery();

            cbox_venta.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_venta.addItem(rss.getString("id_ventaE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void iniciar_cboxmoneda() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select * from moneda");
            ResultSet rss = psttt.executeQuery();

            cbox_moneda.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_moneda.addItem(rss.getString("nombre_moneda"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    
    public void iniciar_cboxpago() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select * from tipo_pago_credito");
            ResultSet rss = psttt.executeQuery();

            cbox_formapago.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_formapago.addItem(rss.getString("nombre_tipo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    
    public void iniciar_cboxtiempo() {

        cbox_tipotiempo.removeAllItems();
            cbox_tipotiempo.addItem("Seleccione una opción");
                cbox_tipotiempo.addItem("meses");
                cbox_tipotiempo.addItem("años");
                
    }
    
    public void buscar_nombrecliente(){
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select nombre_cliente from cliente where id_cliente = ?");

            pst.setString(1, lb1.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                cliente.setText(rs.getString("nombre_cliente"));
                String c = cliente.getText();

                cbox_cliente.setSelectedItem(c);

            }

        } catch (Exception e) {

        }
    }
    
    public void buscar_nombresucursal(){
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select nombre from sucursal where id_sucursal = ?");

            pst.setString(1, lb2.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                sucursal.setText(rs.getString("nombre"));
                String s = sucursal.getText();

                cbox_sucursal.setSelectedItem(s);

            }

        } catch (Exception e) {

        }
    }
    
    public void buscar_venta(){
        
                String v = lbventa.getText();

                cbox_venta.setSelectedItem(v);


    }
    
    public void buscar_nombremoneda(){
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select nombre_moneda from moneda where id_moneda = ?");

            pst.setString(1, lb4.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                moneda.setText(rs.getString("nombre_moneda"));
                String m = moneda.getText();

                cbox_moneda.setSelectedItem(m);

            }

        } catch (Exception e) {

        }
    }
    public void buscar_nombrepago(){
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select nombre_tipo from tipo_pago_credito where id_tipo = ?");

            pst.setString(1, lb5.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                pago.setText(rs.getString("nombre_tipo"));
                String p = pago.getText();

                cbox_formapago.setSelectedItem(p);

            }

        } catch (Exception e) {

        }
    }
                
    public void buscar_nombretipo(){
        String time=tiempo.getText();
        
        if(time.equals("1")){
            cbox_tipotiempo.setSelectedItem("meses");
        }
        else{
            if(time.equals("2")){
            cbox_tipotiempo.setSelectedItem("años");    
            }
            else{
                cbox_tipotiempo.setSelectedItem("Seleccione una opción");
            }
        }
    }
    /**
     * Creates new form inf_Transaccion_Compras
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
        String prov=cbox_cliente.getSelectedItem().toString();
        String descrip="Registró un crédito para el cliente "+prov;
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
        String prov=cbox_cliente.getSelectedItem().toString();
        String num=buscar.getText();
        String descrip="Modificó el crédito número "+num+" del cliente "+prov;
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
       String prov=cbox_cliente.getSelectedItem().toString();
        String num=buscar.getText();
        String descrip="Eliminó el crédito número "+num+" del cliente "+prov;
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
        String prov=cbox_cliente.getSelectedItem().toString();
        String num=buscar.getText();
        String descrip="Buscó el crédito número "+num+" del cliente "+prov;
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
    
    public inf_TransaccionCreditoCliente() {

        initComponents();
        tablas();
        iniciar_cboxcliente();
        iniciar_cboxsucursal();
        iniciar_cboxmoneda();
        iniciar_cboxpago();
        iniciar_cboxtiempo();
        cbox_venta.removeAllItems();
        txt_interes.setEnabled(false);
        txt_total.setEnabled(false);
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

        lbventa = new javax.swing.JLabel();
        cliente = new javax.swing.JLabel();
        sucursal = new javax.swing.JLabel();
        moneda = new javax.swing.JLabel();
        pago = new javax.swing.JLabel();
        tiempo = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        lbusu = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbox_cliente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbox_sucursal = new javax.swing.JComboBox<>();
        lb2 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbox_venta = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbox_moneda = new javax.swing.JComboBox<>();
        lb4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_porcentaje = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_interes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_cuota = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_pagoacum = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_tiempopago = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbox_formapago = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        date_inicio = new com.toedter.calendar.JDateChooser();
        date_final = new com.toedter.calendar.JDateChooser();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        lb5 = new javax.swing.JLabel();
        cbox_tipotiempo = new javax.swing.JComboBox<>();
        lb6 = new javax.swing.JLabel();
        btnTotal = new javax.swing.JButton();

        lbventa.setText("jLabel15");

        cliente.setText("jLabel15");

        sucursal.setText("jLabel15");

        moneda.setText("jLabel15");

        pago.setText("jLabel15");

        tiempo.setText("jLabel15");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Transaccion Credito-Cliente");
        setVisible(true);

        jLabel4.setText("Cliente");

        cbox_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_clienteActionPerformed(evt);
            }
        });

        jLabel5.setText("Sucursal");

        cbox_sucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_sucursalActionPerformed(evt);
            }
        });

        jLabel6.setText("ID Venta");

        cbox_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_ventaActionPerformed(evt);
            }
        });

        jLabel7.setText("Moneda");

        cbox_moneda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_monedaActionPerformed(evt);
            }
        });

        jLabel1.setText("Porcentaje");

        txt_porcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_porcentajeActionPerformed(evt);
            }
        });

        jLabel2.setText("Interés");

        txt_interes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_interesActionPerformed(evt);
            }
        });

        jLabel3.setText("Cuota");

        txt_cuota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cuotaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cuotaKeyTyped(evt);
            }
        });

        jLabel8.setText("Pago Acumulado");

        jLabel9.setText("Tiempo");

        txt_tiempopago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tiempopagoKeyPressed(evt);
            }
        });

        jLabel10.setText("en");

        jLabel11.setText("Forma Pago");

        cbox_formapago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_formapagoActionPerformed(evt);
            }
        });

        jLabel12.setText("Total");

        jLabel13.setText("Fecha Inicio");

        jLabel14.setText("Fecha Final");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

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

        tbl1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Sucursal", "Venta", "Moneda", "Porcentaje", "Interes", "Cuota", "Pago Acumulado", "Tiempo Pago", "Tipo Tiempo", "Forma Pago", "Total", "Fecha Inicio", "Fecha Final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl1);

        cbox_tipotiempo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbox_tipotiempoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbox_tipotiempoMousePressed(evt);
            }
        });
        cbox_tipotiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_tipotiempoActionPerformed(evt);
            }
        });
        cbox_tipotiempo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbox_tipotiempoKeyPressed(evt);
            }
        });

        btnTotal.setText("Calcular Total");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_interes)
                                            .addComponent(txt_porcentaje, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_cuota)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(txt_pagoacum, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(57, 57, 57))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbox_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbox_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_tiempopago, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbox_tipotiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cbox_moneda, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbox_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(lb4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbox_formapago, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lb5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 7, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date_final, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(btnTotal)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
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
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cbox_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cbox_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbox_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(cbox_moneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_interes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_cuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_pagoacum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_tiempopago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(cbox_tipotiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(cbox_formapago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lb5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTotal))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13))
                    .addComponent(date_inicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(date_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar)
                    .addComponent(btnRegistrar)
                    .addComponent(btnBuscar)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        java.util.Date fechaI = date_inicio.getDate();
        long fecha_inicio = fechaI.getTime();
        java.sql.Date dateI = new java.sql.Date(fecha_inicio);
        
        java.util.Date fechaF = date_final.getDate();
        long fecha_final = fechaF.getTime();
        java.sql.Date dateF = new java.sql.Date(fecha_final);

        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD,mdi_Principal.Usuario,mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("insert into credito_cliente values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pst2.setString(1,"0");
            pst2.setString(2, lb1.getText());
            pst2.setString(3, lb2.getText());
            pst2.setString(4, cbox_venta.getSelectedItem().toString().trim());
            pst2.setString(5, lb4.getText());
            pst2.setString(6, txt_porcentaje.getText());
            pst2.setString(7, txt_interes.getText());
            pst2.setString(8, txt_cuota.getText());
            pst2.setString(9, txt_pagoacum.getText());
            pst2.setString(10, txt_tiempopago.getText());
            pst2.setString(11, lb6.getText());
            pst2.setString(12, lb5.getText());
            pst2.setString(13, txt_total.getText());
            pst2.setString(14, dateI.toString());
            pst2.setString(15, dateF.toString());

            pst2.executeUpdate();

            bitacora_guardar();
            lb1.setText("");
            lb2.setText("");
            cbox_cliente.setSelectedIndex(0);
            cbox_sucursal.setSelectedIndex(0);
            cbox_venta.setSelectedIndex(0);
            lb4.setText("");
            cbox_moneda.setSelectedIndex(0);
            txt_porcentaje.setText("");
            txt_interes.setText("");
            txt_cuota.setText("");
            txt_pagoacum.setText("");
            txt_tiempopago.setText("");
            cbox_tipotiempo.setSelectedIndex(0);
            cbox_formapago.setSelectedIndex(0);
            txt_total.setText("");
            date_inicio.setDate(null);
            date_final.setDate(null);
            buscar.setText("");

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        java.util.Date fechaI = date_inicio.getDate();
        long fecha_inicio = fechaI.getTime();
        java.sql.Date dateI = new java.sql.Date(fecha_inicio);
        
        java.util.Date fechaF = date_final.getDate();
        long fecha_final = fechaF.getTime();
        java.sql.Date dateF = new java.sql.Date(fecha_final);

        try {
            String ID = buscar.getText().trim();
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("update credito_cliente set id_cliente = ?, id_sucursal = ?, id_ventaE = ?, id_moneda=?, porcentaje=?, interes=?, cuota=?, pago_acumulado=?, tiempo_pago=?, tipo_tiempo=?, forma_pago=?, total=?, fecha_inicio=?, fecha_final=? where id_credito_cliente=" + ID);
            
            pst2.setString(1, lb1.getText());
            pst2.setString(2, lb2.getText());
            pst2.setString(3, cbox_venta.getSelectedItem().toString().trim());
            pst2.setString(4, lb4.getText());
            pst2.setString(5, txt_porcentaje.getText());
            pst2.setString(6, txt_interes.getText());
            pst2.setString(7, txt_cuota.getText());
            pst2.setString(8, txt_pagoacum.getText());
            pst2.setString(9, txt_tiempopago.getText());
            pst2.setString(10, lb6.getText());
            pst2.setString(11, lb5.getText());
            pst2.setString(12, txt_total.getText());
            pst2.setString(13, dateI.toString());
            pst2.setString(14, dateF.toString());

            pst2.executeUpdate();

            bitacora_modificar();
            lb1.setText("");
            lb2.setText("");
            cbox_cliente.setSelectedIndex(0);
            cbox_sucursal.setSelectedIndex(0);
            cbox_venta.setSelectedIndex(0);
            lb4.setText("");
            cbox_moneda.setSelectedIndex(0);
            txt_porcentaje.setText("");
            txt_interes.setText("");
            txt_cuota.setText("");
            txt_pagoacum.setText("");
            txt_tiempopago.setText("");
            cbox_tipotiempo.setSelectedIndex(0);
            cbox_formapago.setSelectedIndex(0);
            txt_total.setText("");
            date_inicio.setDate(null);
            date_final.setDate(null);
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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst2 = cn.prepareStatement("delete from credito_cliente where id_credito_cliente = ?");

            pst2.setString(1, buscar.getText().trim());
            pst2.executeUpdate();
            bitacora_eliminar();

            lb1.setText("");
            lb2.setText("");
            cbox_cliente.setSelectedIndex(0);
            cbox_sucursal.setSelectedIndex(0);
            cbox_venta.setSelectedIndex(0);
            lb4.setText("");
            cbox_moneda.setSelectedIndex(0);
            txt_porcentaje.setText("");
            txt_interes.setText("");
            txt_cuota.setText("");
            txt_pagoacum.setText("");
            txt_tiempopago.setText("");
            cbox_tipotiempo.setSelectedIndex(0);
            cbox_formapago.setSelectedIndex(0);
            txt_total.setText("");
            date_inicio.setDate(null);
            date_final.setDate(null);
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

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        lb1.setText("");
            lb2.setText("");
            cbox_cliente.setSelectedIndex(0);
            cbox_sucursal.setSelectedIndex(0);
            cbox_venta.setSelectedIndex(0);
            lb4.setText("");
            cbox_moneda.setSelectedIndex(0);
            txt_porcentaje.setText("");
            txt_interes.setText("");
            txt_cuota.setText("");
            txt_pagoacum.setText("");
            txt_tiempopago.setText("");
            cbox_tipotiempo.setSelectedIndex(0);
            cbox_formapago.setSelectedIndex(0);
            txt_total.setText("");
            date_inicio.setDate(null);
            date_final.setDate(null);
            buscar.setText("");

        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from credito_cliente where id_credito_cliente = ?");

            pst.setString(1,buscar.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lb1.setText(rs.getString("id_cliente"));
                lb2.setText(rs.getString("id_sucursal"));
                lbventa.setText(rs.getString("id_ventaE"));
                lb4.setText(rs.getString("id_moneda"));
                txt_porcentaje.setText(rs.getString("porcentaje"));
                txt_interes.setText(rs.getString("interes"));
                txt_cuota.setText(rs.getString("cuota"));
                txt_pagoacum.setText(rs.getString("pago_acumulado"));
                txt_tiempopago.setText(rs.getString("tiempo_pago"));
                tiempo.setText(rs.getString("tipo_tiempo"));
                lb5.setText(rs.getString("forma_pago"));
                txt_total.setText(rs.getString("total"));
                date_inicio.setDate(rs.getDate("fecha_inicio"));
                date_final.setDate(rs.getDate("fecha_final"));

                bitacora_buscar();
                
                buscar_nombrecliente();
                buscar_nombresucursal();
                buscar_venta();
                buscar_nombremoneda();
                buscar_nombrepago();
                buscar_nombretipo();

                btnEliminar.setEnabled(true);
                btnModificar.setEnabled(true);
                btnRegistrar.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(this, "Credito no registrado", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbox_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_clienteActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst = cn.prepareStatement("select id_cliente from cliente where nombre_cliente= ?");
            pst.setString(1, cbox_cliente.getSelectedItem().toString().trim());
            ResultSet rs2 = pst.executeQuery();

            if (rs2.next()) {
                lb1.setText(rs2.getString("id_cliente"));

            } else {
                if (cbox_cliente.getSelectedItem().toString().contains("Seleccione una opción")) {

                    lb1.setText("");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        iniciar_cboxventa();
    }//GEN-LAST:event_cbox_clienteActionPerformed

    private void cbox_sucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_sucursalActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst = cn.prepareStatement("select id_sucursal from sucursal where nombre= ?");
            pst.setString(1, cbox_sucursal.getSelectedItem().toString().trim());
            ResultSet rs2 = pst.executeQuery();

            if (rs2.next()) {
                lb2.setText(rs2.getString("id_sucursal"));

            } else {
                if (cbox_sucursal.getSelectedItem().toString().contains("Seleccione una opción")) {

                    lb2.setText("");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbox_sucursalActionPerformed

    private void cbox_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_ventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_ventaActionPerformed

    private void cbox_monedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_monedaActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst = cn.prepareStatement("select id_moneda from moneda where nombre_moneda= ?");
            pst.setString(1, cbox_moneda.getSelectedItem().toString().trim());
            ResultSet rs2 = pst.executeQuery();

            if (rs2.next()) {
                lb4.setText(rs2.getString("id_moneda"));

            } else {
                if (cbox_moneda.getSelectedItem().toString().contains("Seleccione una opción")) {

                    lb4.setText("");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbox_monedaActionPerformed

    private void txt_interesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_interesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_interesActionPerformed

    private void txt_porcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_porcentajeActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_porcentajeActionPerformed

    private void txt_cuotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cuotaKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_cuotaKeyTyped

    private void txt_cuotaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cuotaKeyPressed
        // TODO add your handling code here:
        String cuo=txt_cuota.getText();
        String porcent=txt_porcentaje.getText();
        double cuota=Double.parseDouble(cuo);
        double porcentaje=Double.parseDouble(porcent);
        double calculo=cuota-(porcentaje/100);
        String interes=String.valueOf(calculo);
        txt_interes.setText(interes);
    }//GEN-LAST:event_txt_cuotaKeyPressed

    private void cbox_formapagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_formapagoActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);

            PreparedStatement pst = cn.prepareStatement("select id_tipo from tipo_pago_credito where nombre_tipo= ?");
            pst.setString(1, cbox_formapago.getSelectedItem().toString().trim());
            ResultSet rs2 = pst.executeQuery();

            if (rs2.next()) {
                lb5.setText(rs2.getString("id_tipo"));

            } else {
                if (cbox_formapago.getSelectedItem().toString().contains("Seleccione una opción")) {

                    lb5.setText("");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbox_formapagoActionPerformed

    private void txt_tiempopagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tiempopagoKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_tiempopagoKeyPressed

    private void cbox_tipotiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_tipotiempoActionPerformed
        // TODO add your handling code here:
         String seleccion=cbox_tipotiempo.getSelectedItem().toString();
        if(seleccion.equals("meses")){
            lb6.setText("1");
        }
        else{
            if(seleccion.equals("años")){
            lb6.setText("2");
        }
            else{
            lb6.setText("");
        }
        }
    }//GEN-LAST:event_cbox_tipotiempoActionPerformed

    private void cbox_tipotiempoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbox_tipotiempoKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbox_tipotiempoKeyPressed

    private void cbox_tipotiempoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbox_tipotiempoMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbox_tipotiempoMousePressed

    private void cbox_tipotiempoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbox_tipotiempoMouseClicked
        // TODO add your handling code here:
        
    
    }//GEN-LAST:event_cbox_tipotiempoMouseClicked

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        // TODO add your handling code here:
        String seleccion=lb6.getText();
        
                String cuo=txt_cuota.getText();
        String tie=txt_tiempopago.getText();
        
        double cuota=Double.parseDouble(cuo);
        double tiempo=Double.parseDouble(tie);
        
        
        if(seleccion.equals("2")){
            double calculot=tiempo*12;
                double calculo=cuota*calculot;
            String interes=String.valueOf(calculo);
        txt_total.setText(interes);            
        }
        else{
            if(seleccion.equals("1")){
            double calculo=cuota*tiempo;
            String interes=String.valueOf(calculo);
        txt_total.setText(interes);    
        }
        }
    }//GEN-LAST:event_btnTotalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnTotal;
    private javax.swing.JTextField buscar;
    private javax.swing.JComboBox<String> cbox_cliente;
    private javax.swing.JComboBox<String> cbox_formapago;
    private javax.swing.JComboBox<String> cbox_moneda;
    private javax.swing.JComboBox<String> cbox_sucursal;
    private javax.swing.JComboBox<String> cbox_tipotiempo;
    private javax.swing.JComboBox<String> cbox_venta;
    private javax.swing.JLabel cliente;
    private com.toedter.calendar.JDateChooser date_final;
    private com.toedter.calendar.JDateChooser date_inicio;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lbusu;
    private javax.swing.JLabel lbventa;
    private javax.swing.JLabel moneda;
    private javax.swing.JLabel pago;
    private javax.swing.JLabel sucursal;
    private javax.swing.JTable tbl1;
    private javax.swing.JLabel tiempo;
    private javax.swing.JTextField txt_cuota;
    private javax.swing.JTextField txt_interes;
    private javax.swing.JTextField txt_pagoacum;
    private javax.swing.JTextField txt_porcentaje;
    private javax.swing.JTextField txt_tiempopago;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
