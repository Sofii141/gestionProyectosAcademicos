package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.entities.Student;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.domain.services.Observer;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProjectsTable extends JFrame implements Observer {
    private final JTable jTableEstudiante;
    private final JScrollPane jScrollPane1;
    private final ProjectService projectService;
    private final Student student;
    
    public ProjectsTable(Student student,ProjectService projectService, JTable jTableEstudiante, JScrollPane jScrollPane1) {
        this.student = student;
        this.jTableEstudiante = jTableEstudiante;
        this.projectService = projectService;
        this.jScrollPane1 = jScrollPane1;
        configurarTabla();
    }

    private void configurarTabla() {
        initComponents();
        
        ICompanyRepository companySepository = Factory.getInstance().getRepositoryCompany("MARIADB");
        CompanyService companyService = new CompanyService(companySepository);
        
        DefaultTableModel modelo = (DefaultTableModel) jTableEstudiante.getModel();
        List<Project> projects = projectService.projectsAvailable(student.getUserId());

        for (Project project : projects) {
            Company company = companyService.getCompany(project.getIdcompany());
            modelo.addRow(new Object[]{
                project.getProId(),
                company.getCompanyName(),
                project.getProTitle(),
                project.getProDeadLine(),
                project.getProAbstract(),
                "Acciones"
            });
        }
    }
    
    private void initComponents(){
        jTableEstudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nombre Empresa", "Nombre Proyecto", "Fecha", "Resumen", "Acciones"
            }
        ));
        jTableEstudiante.setGridColor(new java.awt.Color(204, 204, 204));
        jTableEstudiante.setRowHeight(45);
        jTableEstudiante.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTableEstudiante);
        jTableEstudiante.getAccessibleContext().setAccessibleDescription("");
        
        jTableEstudiante.getColumnModel().getColumn(5).setMinWidth(225);
        jTableEstudiante.getColumnModel().getColumn(5).setMaxWidth(225);
        jTableEstudiante.getColumnModel().getColumn(5).setPreferredWidth(225);
        jTableEstudiante.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRenderEstudiante());
        jTableEstudiante.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditorEstudiante(projectService, student));

        for (int i = 0; i < jTableEstudiante.getColumnCount() - 1; i++) {
            jTableEstudiante.getColumnModel().getColumn(i).setCellRenderer(new MultiLineCellRenderer());
        }
        jTableEstudiante.setRowHeight(50);
    }

    @Override
    public void update() {
        configurarTabla();
    }
    
}
