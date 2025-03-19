/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.access.IProjectRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;
import co.edu.unicauca.mycompany.projects.infra.Messages;
import co.edu.unicauca.mycompany.projects.infra.ValidationException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;

/**
 *
 * @author Ana_Sofia
 */
public class GUIDashboardEmpresa extends javax.swing.JFrame {
    private Company company;
    private CompanyService companyService;
    private ProjectService projectService;
    /**
     * Creates new form inicioSesion
     */
    public GUIDashboardEmpresa(String nit) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        initPlaceHolders();
        
        ICompanyRepository companyRepository = Factory.getInstance().getRepositoryCompany("MARIADB");
        IProjectRepository projectRepository = Factory.getInstance().getRepositoryProject("MARIADB");
        this.projectService = new ProjectService(projectRepository);
        this.companyService = new CompanyService(companyRepository);
        this.company = companyService.getCompany(nit);
        
        initVisual();
        
    }
    /**
     * Configura la apariencia y elementos visuales del dashboard.
     * Hace visible la ventana, la centra en la pantalla y deshabilita la opción de redimensionar.
     */
    public final void initVisual() {
        // Mostrar la ventana
        this.setVisible(true);
        
        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null); 
        
        // Bloquear el cambio de tamaño de la ventana
        setResizable(false);

        // Mostrar el ID del estudiante en el botón de inicio
        lblNameCompany.setText("Compañia " + company.getContactName());

        // Configurar los textos de los labels con la información del estudiante
        lblEmailCompany.setText(company.getUserEmail());
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
        lblNameCompany = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        lblEmailCompany = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAbstractProject = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTitleProject = new javax.swing.JTextField();
        txtDeadLineProject = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtDescriptionProject = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtBudgetProject = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtGoalsProject = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        btnSendProject = new javax.swing.JButton();
        txtProjectId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jPanel4.setBackground(new java.awt.Color(90, 111, 228));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNameCompany.setBackground(new java.awt.Color(255, 255, 255));
        lblNameCompany.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        lblNameCompany.setForeground(new java.awt.Color(255, 255, 255));
        lblNameCompany.setText("Empresa x");
        jPanel4.add(lblNameCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 30));

        jButton3.setBackground(new java.awt.Color(90, 111, 228));
        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Mensajes");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 210, 50));

        jButton4.setBackground(new java.awt.Color(90, 111, 228));
        jButton4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Publicar proyecto");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 210, 50));

        jButton5.setBackground(new java.awt.Color(90, 111, 228));
        jButton5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Solicitudes");
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
        jButton6.setText("Evaluaciones");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 210, 50));

        lblEmailCompany.setForeground(new java.awt.Color(255, 255, 255));
        lblEmailCompany.setText("correoEmpres@gmail.com");
        jPanel4.add(lblEmailCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(38, 42, 65));
        jLabel10.setText("Publicación de proyecto");

        txtAbstractProject.setBackground(new java.awt.Color(227, 230, 235));
        txtAbstractProject.setForeground(new java.awt.Color(130, 134, 140));
        txtAbstractProject.setBorder(null);

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(58, 60, 64));
        jLabel13.setText("*Nombre");

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(58, 60, 64));
        jLabel14.setText("*Resumen");

        txtTitleProject.setBackground(new java.awt.Color(227, 230, 235));
        txtTitleProject.setForeground(new java.awt.Color(130, 134, 140));
        txtTitleProject.setBorder(null);

        txtDeadLineProject.setBackground(new java.awt.Color(227, 230, 235));
        txtDeadLineProject.setForeground(new java.awt.Color(130, 134, 140));
        txtDeadLineProject.setBorder(null);

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(58, 60, 64));
        jLabel15.setText("*Tiempo maximo en meses");

        txtDescriptionProject.setBackground(new java.awt.Color(227, 230, 235));
        txtDescriptionProject.setForeground(new java.awt.Color(130, 134, 140));
        txtDescriptionProject.setBorder(null);

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(58, 60, 64));
        jLabel16.setText("*Descripción");

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(58, 60, 64));
        jLabel17.setText("*Id del proyecto");

        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(58, 60, 64));
        jLabel18.setText("*Objetivos");

        txtBudgetProject.setBackground(new java.awt.Color(227, 230, 235));
        txtBudgetProject.setForeground(new java.awt.Color(130, 134, 140));
        txtBudgetProject.setBorder(null);

        jLabel19.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(58, 60, 64));
        jLabel19.setText("Presupuesto");

        txtGoalsProject.setBackground(new java.awt.Color(227, 230, 235));
        txtGoalsProject.setForeground(new java.awt.Color(130, 134, 140));
        txtGoalsProject.setBorder(null);

        jButton7.setBackground(new java.awt.Color(95, 97, 112));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Cancelar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        btnSendProject.setBackground(new java.awt.Color(41, 64, 211));
        btnSendProject.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSendProject.setForeground(new java.awt.Color(255, 255, 255));
        btnSendProject.setText("Enviar");
        btnSendProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendProjectActionPerformed(evt);
            }
        });

        txtProjectId.setBackground(new java.awt.Color(227, 230, 235));
        txtProjectId.setForeground(new java.awt.Color(130, 134, 140));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAbstractProject, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnSendProject, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDescriptionProject)
                                    .addComponent(jLabel16)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(txtDeadLineProject, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14))
                                        .addGap(103, 103, 103)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel18)
                                            .addComponent(txtBudgetProject, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                            .addComponent(txtGoalsProject, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel17)
                                            .addComponent(txtProjectId))))))
                        .addGap(0, 41, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtTitleProject, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitleProject, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProjectId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDeadLineProject, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBudgetProject, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAbstractProject, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGoalsProject, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescriptionProject, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(btnSendProject))
                .addGap(20, 20, 20))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnSendProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendProjectActionPerformed

        String proId = txtProjectId.getText().trim();
        String proTitle = txtTitleProject.getText().trim();
        String proDescription = txtDescriptionProject.getText().trim();
        String proAbstract = txtAbstractProject.getText().trim();
        String proGoals = txtGoalsProject.getText().trim();
        String proDeadLine = txtDeadLineProject.getText().trim();
        String proBudget = txtBudgetProject.getText().trim();

        String idCompany = company.getUserId();
        // Validar y convertir proDeadLine
        
        int proDeadLineInt = 0;
        double proBudgetDouble = 0.0;
        
        try {
            proDeadLineInt = Integer.parseInt(proDeadLine);
        } catch (NumberFormatException e) {
            Messages.showMessageDialog("El plazo del proyecto debe ser un número válido", "Error");
            txtDeadLineProject.requestFocus();
            return;
        }
        // Validar y convertir proBudget
        
        try {
            proBudgetDouble = Double.parseDouble(proBudget);
        } catch (NumberFormatException e) {
            Messages.showMessageDialog("El presupuesto del proyecto debe ser un número válido", "Error");
            txtBudgetProject.requestFocus();
            return;
        }
        
        // Crear la fecha y hora actuales del proyecto
        Date proDate = new Date(); // Obtiene la fecha y hora actuales

        Project project = new Project(proId, proTitle, proDescription, proAbstract, proGoals, proDeadLineInt, proDate, proBudgetDouble, idCompany);
        // Guardar el proyecto
        // Verificar que el ID del proyecto no exista
        try {
            // Validar los datos del proyecto
            if (projectService.validData(project)) {
                // Verificar que el ID del proyecto no exista
                if (!projectService.existProjectId(proId)) {
                    projectService.saveProject(project);
                    this.dispose();
                    Messages.showMessageDialog("El proyecto se registró exitosamente", "Registro correcto");
                } else {
                    Messages.showMessageDialog("El ID del proyecto ingresado ya se encuentra en uso.", "Atención");
                    txtProjectId.requestFocus();
                    return;
                }
            }
        } catch (ValidationException ve) {
            Messages.showErrorDialog(ve.getMessage(), "Error de validación");

            Map<String, JComponent> mapError = new HashMap<>();
            mapError.put("proId", txtProjectId);
            mapError.put("proTitle", txtTitleProject);
            mapError.put("proDescription", txtDescriptionProject);
            mapError.put("proAbstract", txtAbstractProject);
            mapError.put("proGoals", txtGoalsProject);
            mapError.put("proDeadLine", txtDeadLineProject);
            mapError.put("proBudget", txtBudgetProject);

            JComponent campoError = mapError.get(ve.getAtributoError());
            campoError.requestFocus();
            return;
        } catch (Exception ex) {
            Messages.showErrorDialog(ex.getMessage(), "Error desconocido");
            return;
        }

    }//GEN-LAST:event_btnSendProjectActionPerformed
    
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
            java.util.logging.Logger.getLogger(GUIDashboardEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIDashboardEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIDashboardEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIDashboardEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIDashboardEmpresa("U004").setVisible(true);
            }
        });
    }
    
    
    /**
     * Crea los placeholders para la creacion de la empresa
     */
    private void initPlaceHolders(){
        TextPrompt placeholderName = new TextPrompt("Ingresar nombre:",txtTitleProject);
        TextPrompt placeholderTiempo = new TextPrompt("Ingresar tiempo maximo en meses:",txtDeadLineProject);
        TextPrompt placeholderPresupuesto = new TextPrompt("Ingresar fecha:",txtBudgetProject);
        TextPrompt placeholderResumen = new TextPrompt("Ingresar resumen:",txtAbstractProject);
        TextPrompt placeholderObjetivos = new TextPrompt("Ingresar onjetivos:",txtGoalsProject);
        TextPrompt placeholderDescripcion  = new TextPrompt("Ingrese descripción:",txtDescriptionProject);
        TextPrompt placeholderProId  = new TextPrompt("Ingrese el id del proyecto:",txtProjectId);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendProject;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblEmailCompany;
    private javax.swing.JLabel lblNameCompany;
    private javax.swing.JTextField txtAbstractProject;
    private javax.swing.JTextField txtBudgetProject;
    private javax.swing.JTextField txtDeadLineProject;
    private javax.swing.JTextField txtDescriptionProject;
    private javax.swing.JTextField txtGoalsProject;
    private javax.swing.JTextField txtProjectId;
    private javax.swing.JTextField txtTitleProject;
    // End of variables declaration//GEN-END:variables
}
