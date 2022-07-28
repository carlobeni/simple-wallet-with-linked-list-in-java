/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pack_billete.java_homework.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Benitez <carlosbenitez@fiuna.edu.py>
 */
public class FormCargar extends javax.swing.JFrame {

    /**
     * Creates new form FormCargar
     */
    private MainBilletera back;
    public FormCargar(MainBilletera back) {
        this.back=back;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(0);
    }
    public void set_cbx_cash(ArrayList values){
        for(int i=0;i<values.size();i++)cbx_cash.addItem(values.get(i)+"gs");
        cbx_cash.setSelectedIndex(0);
    }
    public void set_cbx_blltr(ArrayList money){
        for(int i=0;i<money.size();i++) cbx_blltr.addItem("["+String.valueOf(i+1)+"] "+money.get(i));
        cbx_blltr.addItem("["+String.valueOf(money.size()+1)+"] Nuevo billete");
        cbx_blltr.setSelectedIndex(cbx_blltr.getItemCount()-1);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbx_cash = new javax.swing.JComboBox<>();
        cbx_blltr = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_save = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel de Carga");

        cbx_cash.setToolTipText("Seleccione el billete a cambiar o depositar");
        cbx_cash.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                cbx_cashComponentRemoved(evt);
            }
        });
        cbx_cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_cashActionPerformed(evt);
            }
        });

        cbx_blltr.setToolTipText("Para agregar un billete nuevo seleccione \"Nuevo Billete\",\\npara cambiar un billete existente seleccionelo");
        cbx_blltr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_blltrActionPerformed(evt);
            }
        });

        jLabel1.setText("Billete");

        jLabel2.setText("Billetera");

        btn_save.setText("Cambiar");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_exit.setText("Cerrar");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbx_blltr, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbx_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_cash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_blltr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_exit))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbx_cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_cashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_cashActionPerformed

    private void cbx_cashComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_cbx_cashComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_cashComponentRemoved

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
         String val_str=(String)cbx_cash.getSelectedItem();
         int valor=Integer.parseInt(val_str.replaceAll("gs",""));
         int pos=cbx_blltr.getSelectedIndex()+1;
         back.load_cash(valor, pos);
         back.setEnabled(true);
         this.dispose();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        back.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_btn_exitActionPerformed

    private void cbx_blltrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_blltrActionPerformed
            cbx_blltr.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                int pos=cbx_blltr.getSelectedIndex()+1;
                if(pos==back.cant_blt()+1) btn_save.setText("Agregar");
                else btn_save.setText("Cambiar");
            }});
    }//GEN-LAST:event_cbx_blltrActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> cbx_blltr;
    private javax.swing.JComboBox<String> cbx_cash;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

