package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.access.IProjectRepository;
import co.edu.unicauca.mycompany.projects.access.IUserRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Student;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;
import co.edu.unicauca.mycompany.projects.domain.services.UserService;

/**
 * Clase que representa el panel principal (dashboard) de un estudiante en la interfaz gráfica.
 * Permite visualizar información del estudiante, proyectos disponibles y gráficos relacionados.
 */
public class GUIDashboardEstudiante extends javax.swing.JFrame implements Dashboard{

    /**
     * Estudiante que ha iniciado sesión en el sistema.
     */
    private final Student student;
    
    /**
     * Proyecto que guarda los observers.
     */
    ProjectService projectService;

    /**
     * Constructor del panel de inicio para estudiantes.Inicializa los servicios de estudiante y proyectos, 
     * recupera la información del estudiante y configura la interfaz gráfica.
     *
     * @param student Instancia del estudiante que inició sesión.
     * @param projectService Instancia servicio de proyectos.
     */
    public GUIDashboardEstudiante(Student student, ProjectService projectService) {
        this.student = student;
        this.projectService = projectService;

        // Inicializar los componentes gráficos de la interfaz
        initComponents();
        
        // Agregar un observador para actualizar la gráfica de proyectos en el panel
        projectService.addObserver(new GraphicProjectsObserver(student, projectService, jPanelGrafico));

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
        btnInicio.setText("Estudiante " + student.getUserId());
        lblTitulo.setText("Bienvenido estudiante " + student.getUserId());
        lblCorreo.setText(student.getUserEmail());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblCorreo = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        btnCerrarSesión = new javax.swing.JButton();
        btnPostular = new javax.swing.JButton();
        btnProyectos1 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jPanelGrafico = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jPanel4.setBackground(new java.awt.Color(90, 111, 228));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorreo.setText("tuEstudiante@gmail.com");
        jPanel4.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 150, 190, -1));

        btnInicio.setBackground(new java.awt.Color(90, 111, 228));
        btnInicio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setText("Estudiante X");
        btnInicio.setBorder(null);
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.setFocusPainted(false);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        jPanel4.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 210, 50));

        btnCerrarSesión.setBackground(new java.awt.Color(90, 111, 228));
        btnCerrarSesión.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnCerrarSesión.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesión.setText("Cerrar Sesión");
        btnCerrarSesión.setBorder(null);
        btnCerrarSesión.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesión.setFocusPainted(false);
        btnCerrarSesión.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesiónActionPerformed(evt);
            }
        });
        jPanel4.add(btnCerrarSesión, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 210, 50));

        btnPostular.setBackground(new java.awt.Color(90, 111, 228));
        btnPostular.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnPostular.setForeground(new java.awt.Color(186, 195, 241));
        btnPostular.setText("Postularme");
        btnPostular.setBorder(null);
        btnPostular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPostular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostularActionPerformed(evt);
            }
        });
        jPanel4.add(btnPostular, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 210, 50));

        btnProyectos1.setBackground(new java.awt.Color(90, 111, 228));
        btnProyectos1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnProyectos1.setForeground(new java.awt.Color(186, 195, 241));
        btnProyectos1.setText("Mis proyectos");
        btnProyectos1.setBorder(null);
        btnProyectos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProyectos1.setFocusPainted(false);
        btnProyectos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyectos1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnProyectos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 210, 50));

        lblTitulo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(38, 42, 65));
        lblTitulo.setText("Bienvenido Estudiante X");

        jPanelGrafico.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelGraficoLayout = new javax.swing.GroupLayout(jPanelGrafico);
        jPanelGrafico.setLayout(jPanelGraficoLayout);
        jPanelGraficoLayout.setHorizontalGroup(
            jPanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 782, Short.MAX_VALUE)
        );
        jPanelGraficoLayout.setVerticalGroup(
            jPanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(lblTitulo)
                    .addComponent(jPanelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitulo)
                .addGap(26, 26, 26)
                .addComponent(jPanelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnCerrarSesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesiónActionPerformed
        IUserRepository repositoryUser = Factory.getInstance().getRepositoryUser("MARIADB");
        
        GUIinicioSesion instance = new GUIinicioSesion(new UserService(repositoryUser));
        
        this.dispose();
        instance.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesiónActionPerformed

    /**
     * Maneja el evento cuando el usuario presiona el botón "Postular".
     * Abre la ventana de proyectos disponibles y oculta el botón de postulación.
     *
     * @param evt Evento de acción generado al presionar el botón.
     */
    private void btnPostularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostularActionPerformed
        ICompanyRepository companyRepository = Factory.getInstance().getRepositoryCompany("MARIADB");
        
        GUIProyectosDisponibles gui = new GUIProyectosDisponibles(student, projectService, new CompanyService(companyRepository), btnPostular);
        gui.setVisible(true);
        
        btnPostular.setVisible(false);
    }//GEN-LAST:event_btnPostularActionPerformed

    private void btnProyectos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProyectos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProyectos1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesión;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnPostular;
    private javax.swing.JButton btnProyectos1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelGrafico;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
    /**
     * Se encarga de mostrar la interfaz, se hace para poder utilizar la fabrica y el principio abierto cerrado
     */
    @Override
    public void mostrar() {
        this.setVisible(true);
    }
}
