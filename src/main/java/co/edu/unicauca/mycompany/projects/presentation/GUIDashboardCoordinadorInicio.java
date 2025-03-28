package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.access.IProjectRepository;
import co.edu.unicauca.mycompany.projects.access.IUserRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Coordinator;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;
import co.edu.unicauca.mycompany.projects.domain.services.UserService;

/**
 * Interfaz gráfica del panel de inicio para coordinadores.
 * Permite la visualización de datos y gráficos relacionados con los proyectos gestionados.
 */
public class GUIDashboardCoordinadorInicio extends javax.swing.JFrame implements Dashboard{

    /**
     * Coordinador que ha iniciado sesión.
     */
    private final Coordinator coordinator;

    /**
     * Constructor del panel de inicio para coordinadores.Inicializa los servicios, obtiene los datos del coordinador y configura la interfaz.
     *
     * @param coordinator Instancia de la clase coordinador
     * @param projectService Instancia servicio de proyectos
     */
    public GUIDashboardCoordinadorInicio(Coordinator coordinator, ProjectService projectService) {
        // Obtener los datos del coordinador a partir del ID proporcionado
        this.coordinator = coordinator;

        // Inicializar los componentes gráficos de la interfaz
        initComponents();

        // Agregar un observador para actualizar la gráfica de proyectos en el panel
        projectService.addObserver(new GraphicProjectsCoordinatorObserver(coordinator, projectService, jPanelGraficoCoordinator));

        // Configurar la apariencia y los datos visuales
        initVisual();
    }

    /**
     * Configura la apariencia y elementos visuales del dashboard.
     * Hace visible la ventana, la centra en la pantalla y deshabilita la opción de redimensionar.
     */
    public final void initVisual() {
        this.setVisible(true);
        setLocationRelativeTo(null); 
        setResizable(false);
        btnCoordiName.setText("Coordinador " + coordinator.getUserId());
        lbCoordinatorTitle.setText("Bienvenido Coordinador " + coordinator.getUserId());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCoordinador = new javax.swing.JTable();
        labelCoordiName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnProyectos = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnCerrarSesión = new javax.swing.JButton();
        lblCoordinatorCorreo = new javax.swing.JLabel();
        btnCoordiName = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        lbCoordinatorTitle = new javax.swing.JLabel();
        jPanelGraficoCoordinator = new javax.swing.JPanel();

        jTableCoordinador.setForeground(new java.awt.Color(255, 255, 255));
        jTableCoordinador.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableCoordinador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableCoordinador.setGridColor(new java.awt.Color(204, 204, 204));
        jTableCoordinador.setRowHeight(45);
        jTableCoordinador.setSelectionBackground(new java.awt.Color(90, 111, 228));
        jTableCoordinador.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableCoordinador.setShowGrid(true);
        jScrollPane1.setViewportView(jTableCoordinador);
        jTableCoordinador.getAccessibleContext().setAccessibleDescription("");

        labelCoordiName.setBackground(new java.awt.Color(255, 255, 255));
        labelCoordiName.setFont(new java.awt.Font("Segoe UI Semibold", 1, 22)); // NOI18N
        labelCoordiName.setForeground(new java.awt.Color(255, 255, 255));
        labelCoordiName.setText("Coordinador x");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jPanel4.setBackground(new java.awt.Color(90, 111, 228));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProyectos.setBackground(new java.awt.Color(90, 111, 228));
        btnProyectos.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnProyectos.setForeground(new java.awt.Color(186, 195, 241));
        btnProyectos.setText("Proyectos");
        btnProyectos.setBorder(null);
        btnProyectos.setFocusable(false);
        btnProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyectosActionPerformed(evt);
            }
        });
        jPanel4.add(btnProyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 210, 50));

        jButton5.setBackground(new java.awt.Color(90, 111, 228));
        jButton5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(186, 195, 241));
        jButton5.setText("Proyectos en espera");
        jButton5.setBorder(null);
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 210, 50));

        btnCerrarSesión.setBackground(new java.awt.Color(90, 111, 228));
        btnCerrarSesión.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnCerrarSesión.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesión.setText("Cerrar Sesión");
        btnCerrarSesión.setBorder(null);
        btnCerrarSesión.setFocusable(false);
        btnCerrarSesión.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesiónActionPerformed(evt);
            }
        });
        jPanel4.add(btnCerrarSesión, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 210, 50));

        lblCoordinatorCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCoordinatorCorreo.setText("tuCoordinador@gmail.com");
        jPanel4.add(lblCoordinatorCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        btnCoordiName.setBackground(new java.awt.Color(90, 111, 228));
        btnCoordiName.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        btnCoordiName.setForeground(new java.awt.Color(255, 255, 255));
        btnCoordiName.setText("Coordinador x");
        btnCoordiName.setBorder(null);
        btnCoordiName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCoordiName.setFocusable(false);
        btnCoordiName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoordiNameActionPerformed(evt);
            }
        });
        jPanel4.add(btnCoordiName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 210, 50));

        jButton7.setBackground(new java.awt.Color(90, 111, 228));
        jButton7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(186, 195, 241));
        jButton7.setText("Proyectos en curso");
        jButton7.setBorder(null);
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 210, 50));

        lbCoordinatorTitle.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        lbCoordinatorTitle.setForeground(new java.awt.Color(38, 42, 65));
        lbCoordinatorTitle.setText("Bienvenido Coordinador x");

        jPanelGraficoCoordinator.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelGraficoCoordinatorLayout = new javax.swing.GroupLayout(jPanelGraficoCoordinator);
        jPanelGraficoCoordinator.setLayout(jPanelGraficoCoordinatorLayout);
        jPanelGraficoCoordinatorLayout.setHorizontalGroup(
            jPanelGraficoCoordinatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 782, Short.MAX_VALUE)
        );
        jPanelGraficoCoordinatorLayout.setVerticalGroup(
            jPanelGraficoCoordinatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCoordinatorTitle)
                    .addComponent(jPanelGraficoCoordinator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 72, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbCoordinatorTitle)
                .addGap(18, 18, 18)
                .addComponent(jPanelGraficoCoordinator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    /**
     * Maneja el evento cuando el usuario presiona el botón "Proyectos".
     * Abre la ventana del dashboard del coordinador y cierra la ventana actual.
     *
     * @param evt Evento de acción generado al presionar el botón.
     */
    private void btnProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProyectosActionPerformed
        IProjectRepository projectRepository = Factory.getInstance().getRepositoryProject("MARIADB");
        ICompanyRepository companyRepository = Factory.getInstance().getRepositoryCompany("MARIADB");
        
        GUIDashboardCoordinador gui = new GUIDashboardCoordinador(coordinator, new ProjectService(projectRepository), new CompanyService(companyRepository), btnProyectos);
        gui.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnProyectosActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnCerrarSesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesiónActionPerformed
        IUserRepository repositoryUser = Factory.getInstance().getRepositoryUser("MARIADB");
        
        GUIinicioSesion instance = new GUIinicioSesion(new UserService(repositoryUser));
        instance.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesiónActionPerformed

    /**
     * Maneja el evento cuando el usuario presiona el botón con el nombre del coordinador.
     * Abre la ventana del dashboard inicial del coordinador y cierra la ventana actual.
     *
     * @param evt Evento de acción generado al presionar el botón.
     */
    private void btnCoordiNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoordiNameActionPerformed
        
    }//GEN-LAST:event_btnCoordiNameActionPerformed

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
            java.util.logging.Logger.getLogger(GUIDashboardCoordinadorInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIDashboardCoordinadorInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIDashboardCoordinadorInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIDashboardCoordinadorInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JButton btnCerrarSesión;
    private javax.swing.JButton btnCoordiName;
    private javax.swing.JButton btnProyectos;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelGraficoCoordinator;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCoordinador;
    private javax.swing.JLabel labelCoordiName;
    private javax.swing.JLabel lbCoordinatorTitle;
    private javax.swing.JLabel lblCoordinatorCorreo;
    // End of variables declaration//GEN-END:variables
    /**
     * Se encarga de mostrar la interfaz, se hace para poder utilizar la fabrica y el principio abierto cerrado
     */
    @Override
    public void mostrar() {
        this.setVisible(true);
    }
}
