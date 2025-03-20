package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.entities.Student;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;

/**
 * Clase que representa un panel de acciones para el estudiante en la interfaz gráfica.
 * Este panel permite al estudiante interactuar con un proyecto específico.
 */
public class PanelActionEstudiante extends javax.swing.JPanel {
    
    /** Proyecto asociado al panel. */
    private final Project proyecto;
    
    /** Estudiante que interactúa con el panel. */
    private final Student estudiante;
    
    /** Servicio de gestión de proyectos. */
    private final ProjectService projectService;

    /**
     * Constructor de la clase PanelActionEstudiante.
     * 
     * @param projectService Servicio de gestión de proyectos.
     * @param proyecto Proyecto sobre el cual se realizarán acciones.
     * @param estudiante Estudiante que interactúa con el proyecto.
     */
    public PanelActionEstudiante(ProjectService projectService, Project proyecto, Student estudiante) {
        this.proyecto = proyecto;
        this.estudiante = estudiante;
        this.projectService = projectService;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnPostularse = new javax.swing.JButton();
        btnDetallesEst = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnPostularse.setBackground(new java.awt.Color(22, 192, 152));
        btnPostularse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPostularse.setForeground(new java.awt.Color(255, 255, 255));
        btnPostularse.setText("Postularse");
        btnPostularse.setFocusPainted(false);
        btnPostularse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostularseActionPerformed(evt);
            }
        });

        btnDetallesEst.setBackground(new java.awt.Color(41, 64, 211));
        btnDetallesEst.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDetallesEst.setForeground(new java.awt.Color(255, 255, 255));
        btnDetallesEst.setText("Detalles");
        btnDetallesEst.setFocusPainted(false);
        btnDetallesEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesEstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDetallesEst, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPostularse)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetallesEst)
                    .addComponent(btnPostularse))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Método invocado al presionar el botón de detalles.
    * Abre una ventana con la información detallada del proyecto.
    * 
    * @param evt Evento de acción generado por el botón.
    */
    private void btnDetallesEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesEstActionPerformed
        GUIVerDetalles detallesFrame = new GUIVerDetalles(proyecto);
        detallesFrame.setVisible(true);
    }//GEN-LAST:event_btnDetallesEstActionPerformed

    /**
    * Método invocado al presionar el botón para postularse a un proyecto.
    * Abre una ventana donde el estudiante puede completar su postulación.
    * 
    * @param evt Evento de acción generado por el botón.
    */
    private void btnPostularseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostularseActionPerformed
        GUIPostularse objpostularse = new GUIPostularse(projectService, proyecto, estudiante);
        objpostularse.setVisible(true);
    }//GEN-LAST:event_btnPostularseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetallesEst;
    private javax.swing.JButton btnPostularse;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
