/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *///
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
 * @author SEBAS
 */
public class inf_Diario extends javax.swing.JInternalFrame {
 
 public void iniciar_filtro(){
     cbox_orden.removeAllItems();
     
     cbox_orden.addItem("ID");
     cbox_orden.addItem("Operacion");
     cbox_orden.addItem("Fecha");
     cbox_orden.addItem("Cuenta Cargo");
     cbox_orden.addItem("Cuenta Abono");
     cbox_orden.addItem("Quien Carga");
     cbox_orden.addItem("Quien Abona");
     cbox_orden.addItem("Cantidad");
 }
 public void iniciar_buscar(){
     cbox_filtrado.removeAllItems();
     
     cbox_filtrado.addItem("ID");
     cbox_filtrado.addItem("Operacion");
     cbox_filtrado.addItem("Fecha");
     cbox_filtrado.addItem("Cuenta Cargo");
     cbox_filtrado.addItem("Cuenta Abono");
     cbox_filtrado.addItem("Quien Carga");
     cbox_filtrado.addItem("Quien Abona");
     cbox_filtrado.addItem("Cantidad");
 }
 
 public void ordenID() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable order by codigo");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            modelo.addColumn("Cantidad");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                dato[7] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 public void ordenOperacion() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable order by codigo_operacion");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            modelo.addColumn("Cantidad");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                dato[7] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  public void ordenFecha() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable order by fecha_operacion");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            modelo.addColumn("Cantidad");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                dato[7] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   public void ordenCC() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable order by cuenta_cargo");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            modelo.addColumn("Cantidad");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                dato[7] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ordenCA() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable order by cuenta_abono");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            modelo.addColumn("Cantidad");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                dato[7] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void ordenQC() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable order by quien_carga");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            modelo.addColumn("Cantidad");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                dato[7] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      public void ordenQA() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable order by quien_abona");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            modelo.addColumn("Cantidad");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                dato[7] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       public void ordenCantidad() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable order by cantidad");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            modelo.addColumn("Cantidad");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                dato[7] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       
       public void filtroID() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable where codigo= ? order by codigo");
            pstt4.setString(1,buscar.getText().trim());
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            modelo.addColumn("Cantidad");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                dato[7] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 public void filtroOperacion() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable where codigo_operacion= ? order by codigo_operacion");
            pstt4.setString(1,buscar.getText().trim());
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            modelo.addColumn("Cantidad");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                dato[7] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  public void filtroFecha() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable where fecha_operacion= ? order by fecha_operacion");
            pstt4.setString(1,buscar.getText().trim());
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            modelo.addColumn("Cantidad");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                dato[7] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   public void filtroCC() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable where cuenta_cargo= ? order by cuenta_cargo");
            pstt4.setString(1,buscar.getText().trim());
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            modelo.addColumn("Cantidad");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                dato[7] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void filtroCA() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable where cuenta_abono=? order by cuenta_abono");
            pstt4.setString(1,buscar.getText().trim());
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            modelo.addColumn("Cantidad");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                dato[7] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void filtroQC() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable where quien_carga=? order by quien_carga");
            pstt4.setString(1,buscar.getText().trim());
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            modelo.addColumn("Cantidad");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                dato[7] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      public void filtroQA() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable where quien_abona=? order by quien_abona");
            pstt4.setString(1,buscar.getText().trim());
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            modelo.addColumn("Cantidad");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                dato[7] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       public void filtroCantidad() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from registro_contable where cantidad=? order by cantidad");
            pstt4.setString(1,buscar.getText().trim());
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Operacion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cuenta Cargo");
            modelo.addColumn("Cuenta Abono");
            modelo.addColumn("Quien Carga");
            modelo.addColumn("Quien Abona");
            modelo.addColumn("Cantidad");
            tbl1.setModel(modelo);
            String[] dato = new String[10];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);
                dato[5] = rss4.getString(7);
                dato[6] = rss4.getString(8);
                dato[7] = rss4.getString(6);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Creates new form inf_Transaccion_Compras
     */
    public inf_Diario() {

        initComponents();
        iniciar_filtro();
        iniciar_buscar();
        ordenID();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbox_orden = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbox_filtrado = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        buscar = new javax.swing.JTextField();

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
        setTitle("Libro Diario");
        setVisible(true);

        tbl1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Operacion", "Fecha", "Cuenta Cargo", "Cuenta Abono", "Quien Carga", "Quien Abona", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl1);

        jLabel1.setText("Ordenar por");

        jButton1.setText("Aplicar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Filtrar por");

        jButton2.setText("Aplicar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbox_orden, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbox_filtrado, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbox_filtrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbox_orden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String dato=cbox_orden.getSelectedItem().toString().trim();
        
        if(dato.equals("ID")){
            ordenID();
        }
        else{
            if(dato.equals("Operacion")){
                ordenOperacion();
            }
            else{
                if(dato.equals("Fecha")){
                    ordenFecha();
                }
                else{
                    if(dato.equals("Cuenta Cargo")){
                        ordenCC();
                    }
                    else{
                        if(dato.equals("Cuenta Abono")){
                            ordenCA();
                        }
                        else{
                            if(dato.equals("Quien Carga")){
                                ordenQC();
                            }
                            else{
                                if(dato.equals("Quien Abona")){
                                    ordenQA();
                                }
                                else{
                                    if(dato.equals("Cantidad")){
                                        ordenCantidad();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String dato=cbox_filtrado.getSelectedItem().toString().trim();
        
        if(dato.equals("ID")){
            filtroID();
        }
        else{
            if(dato.equals("Operacion")){
                filtroOperacion();
            }
            else{
                if(dato.equals("Fecha")){
                    filtroFecha();
                }
                else{
                    if(dato.equals("Cuenta Cargo")){
                        filtroCC();
                    }
                    else{
                        if(dato.equals("Cuenta Abono")){
                            filtroCA();
                        }
                        else{
                            if(dato.equals("Quien Carga")){
                                filtroQC();
                            }
                            else{
                                if(dato.equals("Quien Abona")){
                                    filtroQA();
                                }
                                else{
                                    if(dato.equals("Cantidad")){
                                        filtroCantidad();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscar;
    private javax.swing.JComboBox<String> cbox_filtrado;
    private javax.swing.JComboBox<String> cbox_orden;
    private javax.swing.JLabel cliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbventa;
    private javax.swing.JLabel moneda;
    private javax.swing.JLabel pago;
    private javax.swing.JLabel sucursal;
    private javax.swing.JTable tbl1;
    private javax.swing.JLabel tiempo;
    // End of variables declaration//GEN-END:variables
}
