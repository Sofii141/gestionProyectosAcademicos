/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.access.ProjectMariaDBRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import javax.swing.JFrame;

/**
 *
 * @author Ana_Sofia
 */
public class GUIVerDetalles extends javax.swing.JFrame {
    private Project project;
    private Company company;

    /**
     * Creates new form GUIVerDetalles
     * @param project
     */
    public GUIVerDetalles(Project project) {
        this.project = project;
        CompanyService companyService = new CompanyService();
        this.company = companyService.getCompany(project.getCompany().getNit());
        // Inicializar los componentes
        initComponents();
        // No cierra la aplicacion al cerrar el frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Configurar el frame en el centro
        setLocationRelativeTo(null);
        // Configurar el frame para que no se pueda modificar
        setResizable(false);
        // Establecer componentes
        obtenerDatos();
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
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        lblNit = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblGmail = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        lblSector = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblNombreEmpresa = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblCargoPersona = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblNombrePersona = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lblApellidosPersona = new javax.swing.JLabel();
        lblNombreProyecto = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lblResumenProyecto = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lblPresupuesto = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lblObjetivosProyecto = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lblDescripcionProyecto = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        lblTiempoProyecto = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        lblFechaProyecto = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        lblEstadoProyecto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(38, 42, 65));
        jLabel10.setText("Proyecto");

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(84, 84, 84));
        jLabel14.setText("Email:");

        lblNit.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblNit.setForeground(new java.awt.Color(130, 134, 140));
        lblNit.setText("10203023");

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(84, 84, 84));
        jLabel16.setText("Nit:");

        lblGmail.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblGmail.setForeground(new java.awt.Color(130, 134, 140));
        lblGmail.setText("empresa@gmail.com");

        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(84, 84, 84));
        jLabel18.setText("Sector:");

        lblSector.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblSector.setForeground(new java.awt.Color(130, 134, 140));
        lblSector.setText("Tecnologia");

        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(84, 84, 84));
        jLabel20.setText("Telefono:");

        lblTelefono.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(130, 134, 140));
        lblTelefono.setText("3106683378");

        jLabel22.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(84, 84, 84));
        jLabel22.setText("Empresa:");

        lblNombreEmpresa.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblNombreEmpresa.setForeground(new java.awt.Color(130, 134, 140));
        lblNombreEmpresa.setText("Nombre empresa");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(38, 42, 65));
        jLabel11.setText("Informacion de la Empresa");

        lblCargoPersona.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblCargoPersona.setForeground(new java.awt.Color(130, 134, 140));
        lblCargoPersona.setText("Cargo de la persona");

        jLabel26.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(84, 84, 84));
        jLabel26.setText("Cargo del contacto:");

        jLabel27.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(84, 84, 84));
        jLabel27.setText("Nombre del contacto:");

        lblNombrePersona.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblNombrePersona.setForeground(new java.awt.Color(130, 134, 140));
        lblNombrePersona.setText("Nombre de la Persona");

        jLabel29.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(84, 84, 84));
        jLabel29.setText("Apellidos del contacto:");

        lblApellidosPersona.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblApellidosPersona.setForeground(new java.awt.Color(130, 134, 140));
        lblApellidosPersona.setText("Apellidos de la persona");

        lblNombreProyecto.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblNombreProyecto.setForeground(new java.awt.Color(130, 134, 140));
        lblNombreProyecto.setText("Nombre del proyecto");

        jLabel32.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(84, 84, 84));
        jLabel32.setText("Objetivos:");

        jLabel33.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(84, 84, 84));
        jLabel33.setText("Presupuesto:");

        lblResumenProyecto.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblResumenProyecto.setForeground(new java.awt.Color(130, 134, 140));
        lblResumenProyecto.setText("Resumen del proyecto, se escribe aqui");

        jLabel35.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(84, 84, 84));
        jLabel35.setText("Nombre:");

        lblPresupuesto.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblPresupuesto.setForeground(new java.awt.Color(130, 134, 140));
        lblPresupuesto.setText("100");

        jLabel37.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(84, 84, 84));
        jLabel37.setText("Resumen:");

        lblObjetivosProyecto.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblObjetivosProyecto.setForeground(new java.awt.Color(130, 134, 140));
        lblObjetivosProyecto.setText("Objetivos del proyecto, se escribe aqui");

        jLabel39.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(84, 84, 84));
        jLabel39.setText("Descripción:");

        lblDescripcionProyecto.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblDescripcionProyecto.setForeground(new java.awt.Color(130, 134, 140));
        lblDescripcionProyecto.setText("La descripción del proyecto se escribe aqui, no debe ser muy detallada");

        jLabel41.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(111, 155, 221));
        jLabel41.setText("Tiempo maximo en meses:");

        lblTiempoProyecto.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblTiempoProyecto.setForeground(new java.awt.Color(111, 155, 221));
        lblTiempoProyecto.setText("Cantidad en meses");

        jLabel43.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(111, 155, 221));
        jLabel43.setText("Fecha:");

        lblFechaProyecto.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblFechaProyecto.setForeground(new java.awt.Color(111, 155, 221));
        lblFechaProyecto.setText("dd/mm/yyyy");

        jLabel45.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(111, 155, 221));
        jLabel45.setText("Estado:");

        lblEstadoProyecto.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblEstadoProyecto.setForeground(new java.awt.Color(111, 155, 221));
        lblEstadoProyecto.setText("Recibido/Aceptado...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblNit))
                                            .addComponent(jLabel22))
                                        .addGap(154, 154, 154)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblNombrePersona)
                                            .addComponent(jLabel27)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblNombreEmpresa)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblTelefono))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblGmail))
                                            .addComponent(jLabel18)
                                            .addComponent(lblSector))
                                        .addGap(98, 98, 98)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblApellidosPersona)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel26)
                                            .addComponent(lblCargoPersona)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32)
                                    .addComponent(lblResumenProyecto)
                                    .addComponent(jLabel37)
                                    .addComponent(lblObjetivosProyecto)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNombreProyecto)
                                        .addGap(63, 63, 63)
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblPresupuesto))
                                    .addComponent(jLabel39)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel43)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblFechaProyecto)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel45)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblEstadoProyecto))
                                    .addComponent(lblDescripcionProyecto)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel41)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTiempoProyecto)))))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(lblNit)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombrePersona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellidosPersona)
                            .addComponent(jLabel18)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreEmpresa)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblSector)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(lblGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCargoPersona)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(lblTelefono))))
                .addGap(26, 26, 26)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(lblNombreProyecto)
                    .addComponent(jLabel33)
                    .addComponent(lblPresupuesto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResumenProyecto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblObjetivosProyecto)
                .addGap(18, 18, 18)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescripcionProyecto)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(lblTiempoProyecto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(lblEstadoProyecto)
                    .addComponent(jLabel43)
                    .addComponent(lblFechaProyecto))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void obtenerDatos(){
        lblApellidosPersona.setText(company.getContactLastName());
        lblCargoPersona.setText(company.getContactPosition());
        lblDescripcionProyecto.setText(project.getProDescription());
        lblEstadoProyecto.setText(project.getProState().toString());
        /// nohayy
        lblFechaProyecto.setText("nohay");
        lblGmail.setText(company.getEmail());
        lblNit.setText(company.getNit());
        lblNombreEmpresa.setText(company.getCompanyName());
        lblNombrePersona.setText(company.getContactName());
        lblNombreProyecto.setText(project.getProTitle());
        lblObjetivosProyecto.setText(project.getProGoals());
        lblPresupuesto.setText(String.valueOf(project.getProBudget()));
        lblResumenProyecto.setText(project.getProAbstract());
        lblSector.setText(company.getSector().toString());
        lblTelefono.setText(company.getContactPhone());
        lblTiempoProyecto.setText(String.valueOf(project.getProDeadLine()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblApellidosPersona;
    private javax.swing.JLabel lblCargoPersona;
    private javax.swing.JLabel lblDescripcionProyecto;
    private javax.swing.JLabel lblEstadoProyecto;
    private javax.swing.JLabel lblFechaProyecto;
    private javax.swing.JLabel lblGmail;
    private javax.swing.JLabel lblNit;
    private javax.swing.JLabel lblNombreEmpresa;
    private javax.swing.JLabel lblNombrePersona;
    private javax.swing.JLabel lblNombreProyecto;
    private javax.swing.JLabel lblObjetivosProyecto;
    private javax.swing.JLabel lblPresupuesto;
    private javax.swing.JLabel lblResumenProyecto;
    private javax.swing.JLabel lblSector;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTiempoProyecto;
    // End of variables declaration//GEN-END:variables
}
