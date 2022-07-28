/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pack_billete.java_homework.GUI;

import com.pack_billete.java_homework.Billete;
import com.pack_billete.java_homework.Billetera;
import com.pack_billete.java_homework.exceptions.BilleteraVacia;
import com.pack_billete.java_homework.exceptions.ListaVacia;
import com.pack_billete.java_homework.exceptions.PosicionIncorrecta;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Benitez <carlosbenitez@fiuna.edu.py>
 */
public class MainBilletera extends javax.swing.JFrame {

    /**
     * Creates new form MainBilletera
     */
    private Billetera cash_system=new Billetera();
    
    private String [] msg_list_error={
        "Error inesperado en "+Billetera.get_name_file(),
        "Error al asignar posicion",
        "Error, la lista esta vacia",
        "Error, la billetera esta vacia"
    };
    
    
    public MainBilletera() throws PosicionIncorrecta, ListaVacia{
        initComponents();
        jMenuCargar.setAccelerator(KeyStroke.getKeyStroke(
                                    java.awt.event.KeyEvent.VK_I, 
                                    java.awt.Event.CTRL_MASK));
        jMenuExtraer.setAccelerator(KeyStroke.getKeyStroke(
                                    java.awt.event.KeyEvent.VK_O, 
                                    java.awt.Event.CTRL_MASK));
        jMenuSalir.setAccelerator(KeyStroke.getKeyStroke(
                                    java.awt.event.KeyEvent.VK_E, 
                                    java.awt.Event.CTRL_MASK));
        jMenu_about.setAccelerator(KeyStroke.getKeyStroke(
                                    java.awt.event.KeyEvent.VK_Y, 
                                    java.awt.Event.CTRL_MASK));
        this.setLocationRelativeTo(null);
        try {
            cash_system.init();
            cash_system.cargar_billetes();
            update_table();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, msg_list_error[0]);
        }
    }
    //Carga los datos de la lista enlazada a la tabla
    private void update_table(){
        try {
            txt_saldo.setText(String.valueOf(cash_system.total_billetera())+"gs");
            DefaultTableModel model = (DefaultTableModel) table_cash.getModel();
            for(int i = model.getRowCount() -1; i >=0; i--)model.removeRow(i);
            for(int i=1;i<=cash_system.get_cant_billetes();i++){
                add_Table(i,
                          cash_system.ver_billete(i).getValor(),
                          cash_system.ver_billete(i).getDenominacion());
            }
        } catch (PosicionIncorrecta ex) {
            Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, msg_list_error[1]);
        } catch (ListaVacia ex) {
            Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, msg_list_error[2]);
        } catch (BilleteraVacia ex) {
            Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, msg_list_error[3]);
        }
    }
            
    private void add_Table(int pos, int valor,String denominacion){
        DefaultTableModel table=(DefaultTableModel) table_cash.getModel();
        table.addRow(new Object[]{pos,valor,denominacion});
    }
    public void load_cash(int valor,int pos){
        try {
            cash_system.agregar_billete_with_pos(valor, pos);
            cash_system.guardar_billetes();
            update_table();
        } catch (IOException ex) {
                Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, msg_list_error[0]);
        } catch (PosicionIncorrecta ex) {
                Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, msg_list_error[1]);
        } catch (ListaVacia ex) {
                Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, msg_list_error[2]);
        }
    }
    public void remove_cash(int pos){
        try {
            cash_system.quitar_billete_with_pos(pos);
            cash_system.guardar_billetes();
            update_table();
        } catch (IOException ex) {
                Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, msg_list_error[0]);
        } catch (PosicionIncorrecta ex) {
                Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, msg_list_error[1]);
        } catch (ListaVacia ex) {
                Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, msg_list_error[2]);
        } catch (BilleteraVacia ex) {
                Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, msg_list_error[3]);
        }

    }
    public int get_val_blt(int pos){
        try {
            return cash_system.ver_billete(pos).getValor();
        } catch (PosicionIncorrecta | ListaVacia ex) {
            Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BilleteraVacia ex) {
            Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, msg_list_error[3]);
        }
        return 0;
    }
    public int cant_blt(){return cash_system.get_cant_billetes();}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_cash = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txt_saldo = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuCargar = new javax.swing.JMenuItem();
        jMenuExtraer = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenu_help = new javax.swing.JMenu();
        jMenu_about = new javax.swing.JMenuItem();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APP Billetera");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        table_cash.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        table_cash.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posicion", "Valor", "Denominacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_cash);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Total en Billetera");

        txt_saldo.setEditable(false);
        txt_saldo.setFont(new java.awt.Font("Source Sans Pro Light", 0, 18)); // NOI18N
        txt_saldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jMenuBar1.setToolTipText("");

        jMenu1.setText("Opciones");

        jMenuCargar.setText("Cargar / Cambiar");
        jMenuCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCargarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCargar);

        jMenuExtraer.setText("Extraer");
        jMenuExtraer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExtraerActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuExtraer);

        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSalir);

        jMenuBar1.add(jMenu1);

        jMenu_help.setText("Help");
        jMenu_help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_helpActionPerformed(evt);
            }
        });

        jMenu_about.setText("About");
        jMenu_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_aboutActionPerformed(evt);
            }
        });
        jMenu_help.add(jMenu_about);

        jMenuBar1.add(jMenu_help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCargarActionPerformed
        FormCargar form_c=new FormCargar(this);
        form_c.set_cbx_cash(Billete.templates_arraylist());
        try {
                form_c.set_cbx_blltr(cash_system.get_val_with_text());
        } catch (PosicionIncorrecta ex) {
                Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, msg_list_error[1]);
        } catch (ListaVacia ex) {
                Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, msg_list_error[2]);
        }
        this.setEnabled(false);
        form_c.setVisible(true);  
    }//GEN-LAST:event_jMenuCargarActionPerformed

    private void jMenuExtraerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExtraerActionPerformed
        FormExtraccion form_e=new FormExtraccion(this);
        try {
            form_e.set_cbx_blltr(cash_system.get_val_with_text());
        } catch (PosicionIncorrecta ex) {
                Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, msg_list_error[1]);
        } catch (ListaVacia ex) {
                Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, msg_list_error[2]);
        }
        this.setEnabled(false);
        form_e.setVisible(true); 
    }//GEN-LAST:event_jMenuExtraerActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void jMenu_helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_helpActionPerformed

    }//GEN-LAST:event_jMenu_helpActionPerformed

    private void jMenu_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_aboutActionPerformed
        FormAbout form_a=new FormAbout (this);
        this.setEnabled(false);
        form_a.setVisible(true); 
    }//GEN-LAST:event_jMenu_aboutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainBilletera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainBilletera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainBilletera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainBilletera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainBilletera().setVisible(true);
                } catch (PosicionIncorrecta ex) {
                    Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ListaVacia ex) {
                    Logger.getLogger(MainBilletera.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCargar;
    private javax.swing.JMenuItem jMenuExtraer;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JMenuItem jMenu_about;
    private javax.swing.JMenu jMenu_help;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable table_cash;
    private static javax.swing.JTextField txt_saldo;
    // End of variables declaration//GEN-END:variables
}
