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
import javax.swing.JFrame;


/**
 * Clase que representa la interfaz gráfica para visualizar el estado de un proyecto.
 * Permite a los coordinadores gestionar la información de los proyectos asignados.
 */
public class GUIEstado extends javax.swing.JFrame {

    /**
     * Proyecto asociado a la vista.
     */
    private Project proyecto;

    /**
     * Coordinador que interactúa con la interfaz.
     */
    private final Coordinator coordinator; 

    /**
     * Servicio para la gestión de proyectos.
     */
    private final ProjectService projectService;

    /**
     * Servicio para la gestión de empresas.
     */
    private CompanyService companyService;
    
    /**
     * Constructor de la clase GUIEstado.
     * Inicializa los servicios y datos necesarios para mostrar la información del proyecto.
     *
     * @param projectService Servicio para gestionar los proyectos.
     * @param proyecto Proyecto que será visualizado en la interfaz.
     * @param coordinator Coordinador que gestiona el proyecto.
     * @param companyService Servicio para la gestión de empresas.
     */
    public GUIEstado(ProjectService projectService, Project proyecto, Coordinator coordinator, CompanyService companyService) {
        this.proyecto = proyecto;
        this.coordinator = coordinator;
        this.projectService = projectService;
        this.companyService = companyService;
                
        // Inicializar componentes gráficos
        initComponents();
        
        // Configurar propiedades de la ventana
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

        btnRecibido = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        btnCerrado = new javax.swing.JButton();
        btnAceptado = new javax.swing.JButton();
        btnRechazado = new javax.swing.JButton();
        btnEjecucion = new javax.swing.JButton();

        btnRecibido.setBackground(new java.awt.Color(0, 204, 204));
        btnRecibido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRecibido.setForeground(new java.awt.Color(255, 255, 255));
        btnRecibido.setText("Recibido");
        btnRecibido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecibidoActionPerformed(evt);
            }
        });

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
                            .addComponent(btnCerrado, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnAceptado, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRechazado, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCerrado, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
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

    /**
     * Maneja el evento cuando el usuario presiona el botón "Aceptar".
     * Cambia el estado del proyecto a "Aceptado", actualiza la base de datos y notifica por correo.
     *
     * @param evt Evento de acción generado al presionar el botón.
     */
    private void btnAceptadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptadoActionPerformed
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

    /**
     * Maneja el evento cuando el usuario presiona el botón "Rechazar".
     * Cambia el estado del proyecto a "Rechazado", actualiza la base de datos y notifica por correo.
     *
     * @param evt Evento de acción generado al presionar el botón.
     */
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

    /**
     * Maneja el evento cuando el usuario presiona el botón "Ejecución".
     * Cambia el estado del proyecto a "En Ejecución", actualiza la base de datos y notifica por correo.
     *
     * @param evt Evento de acción generado al presionar el botón.
     */
    private void btnEjecucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecucionActionPerformed
        ProjectStatePatron estado = new EjecucionState(companyService, projectService);
        estado.handleStateChange(proyecto); // Ahora esto cambia el estado y notifica por correo
        dispose();
        if (estado.updateDatabase(proyecto, projectService)) {
            Messages.mensajeVario("El estado del proyecto ha sido cambiado a Ejecucion.");
        } else {
            Messages.mensajeVario("Error al actualizar el estado en la base de datos.");
        }
    }//GEN-LAST:event_btnEjecucionActionPerformed

     /**
     * Maneja el evento cuando el usuario presiona el botón "Cerrado".
     * Cambia el estado del proyecto a "Cerrado", actualiza la base de datos y notifica por correo.
     *
     * @param evt Evento de acción generado al presionar el botón.
     */
    private void btnCerradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerradoActionPerformed
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
