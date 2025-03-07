/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.domain.entities.Project;

/**
 *
 * @author Ana_Sofia
 */
public class PanelAction extends javax.swing.JPanel {
    private Project proyecto;
    
    /**
     * Creates new form PanelAction
     */
    public PanelAction() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDetalles = new javax.swing.JButton();
        btnEstado = new javax.swing.JButton();
        btnComentario = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        btnDetalles.setBackground(new java.awt.Color(41, 64, 211));
        btnDetalles.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDetalles.setForeground(new java.awt.Color(255, 255, 255));
        btnDetalles.setText("Detalles");
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });

        btnEstado.setBackground(new java.awt.Color(22, 192, 152));
        btnEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEstado.setForeground(new java.awt.Color(255, 255, 255));
        btnEstado.setText("Estado");
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });

        btnComentario.setBackground(new java.awt.Color(230, 11, 11));
        btnComentario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnComentario.setForeground(new java.awt.Color(255, 255, 255));
        btnComentario.setText("Comentario");
        btnComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComentarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnComentario)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetalles)
                    .addComponent(btnEstado)
                    .addComponent(btnComentario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        // TODO add your handling code here:
        System.out.println("Botón Detalles presionado"); 
        GUIVerDetalles detallesFrame = new GUIVerDetalles(proyecto);
        detallesFrame.setVisible(true);
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        // TODO add your handling code here:
        GUIEstado estadoFrame = new GUIEstado();
        estadoFrame.setVisible(true);
    }//GEN-LAST:event_btnEstadoActionPerformed

    private void btnComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComentarioActionPerformed
        // TODO add your handling code here:
        GUIComentarios comentariosFrame = new GUIComentarios();
        comentariosFrame.setVisible(true);
    }//GEN-LAST:event_btnComentarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComentario;
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnEstado;
    // End of variables declaration//GEN-END:variables
}
