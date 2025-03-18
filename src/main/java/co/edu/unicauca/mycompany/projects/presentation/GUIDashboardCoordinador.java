/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.domain.entities.Coordinator;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;
import javax.swing.JButton;

/**
 *
 * @author Ana_Sofia
 */
public class GUIDashboardCoordinador extends javax.swing.JFrame {

    /**
     * Creates new form inicioSesion
     */
    
    private final Coordinator coordinator;
    private final JButton btnProyectosInicio;
    private CompanyService companyService;
    
    public GUIDashboardCoordinador(Coordinator coordinator, ProjectService projectService, CompanyService companyService, JButton btnProyectosInicio) {
        
        this.coordinator = coordinator;
        this.btnProyectosInicio = btnProyectosInicio;

        // Inicializar los componentes gráficos de la interfaz
        initComponents();

        // Configurar la apariencia y datos visuales
        initVisual();

        // Agregar un observador para actualizar la tabla de proyectos disponibles
        projectService.addObserver(new TableProjectsCoordinatorObserver(coordinator, projectService, jTableCoordinator, jScrollPane1, companyService));

        /*
        this.jTableCoordinator.getColumnModel().getColumn(4).setMinWidth(325);
        this.jTableCoordinator.getColumnModel().getColumn(4).setMaxWidth(325);
        this.jTableCoordinator.getColumnModel().getColumn(4).setPreferredWidth(325);
        
        
        // Aplicar el renderizador de botones a la última columna
        this.jTableCoordinator.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRenderCoordinator());
        this.jTableCoordinator.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditorCoordinator(projectService, coordinator));
*/
    }
    
    public final void initVisual() {
        
        // Mostrar la ventana
        this.setVisible(true); 
        
        // Bloquear el cambio de tamaño de la ventana
        setResizable(false); 
        
        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null); 

        // Mostrar el ID del estudiante en el botón de inicio
        btnCoordiName.setText("Coordinador " + coordinator.getUserId());

        // Configurar el texto del label con el correo del estudiante
        lblCoordinatorCorreo.setText(coordinator.getUserEmail());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCoordiName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnCoordiName = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        lblCoordinatorCorreo = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCoordinator = new javax.swing.JTable();

        labelCoordiName.setBackground(new java.awt.Color(255, 255, 255));
        labelCoordiName.setFont(new java.awt.Font("Segoe UI Semibold", 1, 22)); // NOI18N
        labelCoordiName.setForeground(new java.awt.Color(255, 255, 255));
        labelCoordiName.setText("Coordinador x");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jPanel4.setBackground(new java.awt.Color(90, 111, 228));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCoordiName.setBackground(new java.awt.Color(90, 111, 228));
        btnCoordiName.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        btnCoordiName.setForeground(new java.awt.Color(255, 255, 255));
        btnCoordiName.setText("Coordinador x");
        btnCoordiName.setBorder(null);
        btnCoordiName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoordiNameActionPerformed(evt);
            }
        });
        jPanel4.add(btnCoordiName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 210, 50));

        jButton5.setBackground(new java.awt.Color(90, 111, 228));
        jButton5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Proyectos en espera");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 210, 50));

        jButton6.setBackground(new java.awt.Color(90, 111, 228));
        jButton6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Proyectos en curso");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 210, 50));

        lblCoordinatorCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCoordinatorCorreo.setText("tuCoordinador@gmail.com");
        jPanel4.add(lblCoordinatorCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jButton7.setBackground(new java.awt.Color(90, 111, 228));
        jButton7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Proyectos");
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 210, 50));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(38, 42, 65));
        jLabel10.setText("Solicitudes de Proyecto");

        jTableCoordinator.setForeground(new java.awt.Color(38, 42, 65));
        jTableCoordinator.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nit Empresa", "Nombre Empresa", "Nombre Proyecto", "Fecha", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCoordinator.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableCoordinator.setGridColor(new java.awt.Color(204, 204, 204));
        jTableCoordinator.setRowHeight(45);
        jTableCoordinator.setSelectionBackground(new java.awt.Color(90, 111, 228));
        jTableCoordinator.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableCoordinator.setShowGrid(true);
        jScrollPane1.setViewportView(jTableCoordinator);
        jTableCoordinator.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCoordiNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoordiNameActionPerformed
        // TODO add your handling code here:
        GUIDashboardCoordinadorInicio gui = new GUIDashboardCoordinadorInicio(coordinator.getUserId());
        gui.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCoordiNameActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(GUIDashboardCoordinador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIDashboardCoordinador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIDashboardCoordinador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIDashboardCoordinador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCoordiName;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCoordinator;
    private javax.swing.JLabel labelCoordiName;
    private javax.swing.JLabel lblCoordinatorCorreo;
    // End of variables declaration//GEN-END:variables
}
