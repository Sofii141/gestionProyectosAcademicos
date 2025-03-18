/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.domain.entities.Coordinator;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;
import co.edu.unicauca.mycompany.projects.infra.Messages;
import co.edu.unicauca.mycompany.projects.infra.state.AceptadoState;
import co.edu.unicauca.mycompany.projects.infra.state.CerradoState;
import co.edu.unicauca.mycompany.projects.infra.state.EjecucionState;
import co.edu.unicauca.mycompany.projects.infra.state.ProjectStatePatron;
import co.edu.unicauca.mycompany.projects.infra.state.RechazadoState;
import co.edu.unicauca.mycompany.projects.infra.state.RecibidoState;
import javax.mail.Message;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GUIEstado extends javax.swing.JFrame {

    /**
     * Creates new form GUIEstado
     */
    
    private Project proyecto;
    private final Coordinator coordinator; 
    private final ProjectService projectService; // Servicio de proyectos
    private CompanyService companyService;
    
    public GUIEstado(ProjectService projectService, Project proyecto, Coordinator coordinator, CompanyService companyService) {
        this.proyecto = proyecto;
        this.coordinator = coordinator;
        this.projectService = projectService;
        this.companyService = companyService;
                
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        btnCerrado = new javax.swing.JButton();
        btnAceptado = new javax.swing.JButton();
        btnRechazado = new javax.swing.JButton();
        btnEjecucion = new javax.swing.JButton();
        btnRecibido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(38, 42, 65));
        jLabel11.setText("Estado del Proyecto");

        jLabel41.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(130, 134, 140));
        jLabel41.setText("Seleccione una opcion para cambiar de estado");

        btnCerrado.setBackground(new java.awt.Color(123, 125, 134));
        btnCerrado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCerrado.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrado.setText("Cerrado");
        btnCerrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerradoActionPerformed(evt);
            }
        });

        btnAceptado.setBackground(new java.awt.Color(22, 192, 152));
        btnAceptado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAceptado.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptado.setText("Aceptado");
        btnAceptado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptadoActionPerformed(evt);
            }
        });

        btnRechazado.setBackground(new java.awt.Color(220, 71, 71));
        btnRechazado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRechazado.setForeground(new java.awt.Color(255, 255, 255));
        btnRechazado.setText("Rechazado");
        btnRechazado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazadoActionPerformed(evt);
            }
        });

        btnEjecucion.setBackground(new java.awt.Color(41, 64, 211));
        btnEjecucion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEjecucion.setForeground(new java.awt.Color(255, 255, 255));
        btnEjecucion.setText("En ejecución");
        btnEjecucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecucionActionPerformed(evt);
            }
        });

        btnRecibido.setBackground(new java.awt.Color(0, 204, 204));
        btnRecibido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRecibido.setForeground(new java.awt.Color(255, 255, 255));
        btnRecibido.setText("Recibido");
        btnRecibido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecibidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRechazado, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAceptado, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCerrado, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnAceptado, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRechazado, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrado, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptadoActionPerformed
        // TODO add your handling code here:
        // Cambiar estado del proyecto
        ProjectStatePatron estado = new AceptadoState(companyService, projectService);
        estado.handleStateChange(proyecto); // Ahora esto cambia el estado y notifica por correo
        dispose();
        if (estado.updateDatabase(proyecto, projectService)) {
            Messages.mensajeVario("El estado del proyecto ha sido cambiado a Aceptado.");
        } else {
            Messages.mensajeVario("Error al actualizar el estado en la base de datos.");
        }
    }//GEN-LAST:event_btnAceptadoActionPerformed

    private void btnRechazadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazadoActionPerformed
        // TODO add your handling code here:

        // Cambiar estado del proyecto
        ProjectStatePatron estado = new RechazadoState(companyService, projectService);
        estado.handleStateChange(proyecto); // Ahora esto cambia el estado y notifica por correo
        dispose();
        if (estado.updateDatabase(proyecto, projectService)) {
            Messages.mensajeVario("El estado del proyecto ha sido cambiado a Rechazado.");
        } else {
            Messages.mensajeVario("Error al actualizar el estado en la base de datos.");
        }
    }//GEN-LAST:event_btnRechazadoActionPerformed

    private void btnEjecucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecucionActionPerformed
        // TODO add your handling code here:
        
        // Cambiar estado del proyecto
        ProjectStatePatron estado = new EjecucionState(companyService, projectService);
        estado.handleStateChange(proyecto); // Ahora esto cambia el estado y notifica por correo
        dispose();
        if (estado.updateDatabase(proyecto, projectService)) {
            Messages.mensajeVario("El estado del proyecto ha sido cambiado a Ejecucion.");
        } else {
            Messages.mensajeVario("Error al actualizar el estado en la base de datos.");
        }
    }//GEN-LAST:event_btnEjecucionActionPerformed

    private void btnCerradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerradoActionPerformed
        // TODO add your handling code here:

        // Cambiar estado del proyecto
        ProjectStatePatron estado = new CerradoState(companyService, projectService);
        estado.handleStateChange(proyecto); // Ahora esto cambia el estado y notifica por correo
        dispose();
        if (estado.updateDatabase(proyecto, projectService)) {
            Messages.mensajeVario("El estado del proyecto ha sido cambiado a Cerrado.");
        } else {
            Messages.mensajeVario("Error al actualizar el estado en la base de datos.");
        }
    }//GEN-LAST:event_btnCerradoActionPerformed

    private void btnRecibidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecibidoActionPerformed
        // TODO add your handling code here:
        // Cambiar estado del proyecto
        ProjectStatePatron estado = new RecibidoState(companyService, projectService);
        estado.handleStateChange(proyecto); // Ahora esto cambia el estado y notifica por correo
        dispose();
        
        if (estado.updateDatabase(proyecto, projectService)) {
            Messages.mensajeVario("El estado del proyecto ha sido cambiado a Recibido.");
        } else {
            Messages.mensajeVario("Error al actualizar el estado en la base de datos.");
        }
    }//GEN-LAST:event_btnRecibidoActionPerformed

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
            java.util.logging.Logger.getLogger(GUIEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptado;
    private javax.swing.JButton btnCerrado;
    private javax.swing.JButton btnEjecucion;
    private javax.swing.JButton btnRechazado;
    private javax.swing.JButton btnRecibido;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
