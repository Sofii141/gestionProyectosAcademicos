package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.entities.Student;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.infra.Observer;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que implementa un observador para actualizar dinámicamente la tabla de proyectos disponibles.
 * Se actualiza cuando un estudiante se postula a un proyecto.
 */
public class TableProjectsObserver extends JFrame implements Observer {
    private final JTable jTableEstudiante;
    private final JScrollPane jScrollPane1;
    private final ProjectService projectService;
    private final Student student;
    
    /**
     * Constructor de la clase.
     * 
     * @param student Estudiante actual
     * @param projectService Servicio de proyectos
     * @param jTableEstudiante Tabla que muestra los proyectos disponibles
     * @param jScrollPane1 Panel de desplazamiento para la tabla
     */
    public TableProjectsObserver(Student student, ProjectService projectService, JTable jTableEstudiante, JScrollPane jScrollPane1) {
        this.student = student;
        this.jTableEstudiante = jTableEstudiante;
        this.projectService = projectService;
        this.jScrollPane1 = jScrollPane1;
        
        // Dargar datos iniciales
        configurarTabla();
    }

    /**
     * Configura y llena la tabla con los proyectos disponibles para el estudiante.
     */
    private void configurarTabla() {
        // Configurar la tabla y cargar datos iniciales
        initComponents();
        
        // Limpiar la tabla antes de cargar nuevos datos
        DefaultTableModel modelo = (DefaultTableModel) jTableEstudiante.getModel();
        modelo.setRowCount(0);

        // Obtener el servicio de compañías
        ICompanyRepository companyRepository = Factory.getInstance().getRepositoryCompany("MARIADB");
        CompanyService companyService = new CompanyService(companyRepository);
        
        // Obtener la lista de proyectos disponibles
        List<Project> projects = projectService.projectsAvailable(student.getUserId());

        // Agregar cada proyecto a la tabla
        for (Project project : projects) {
            Company company = companyService.getCompany(project.getIdcompany());
            modelo.addRow(new Object[]{
                project.getProId(),
                company.getCompanyName(),
                project.getProTitle(),
                project.getProDate(),
                project.getProAbstract(),
                "Acciones"
            });
        }
    }
    
    /**
     * Configura los componentes de la tabla, incluyendo su diseño y renderizadores.
     */
    private void initComponents(){
        jTableEstudiante.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] { "No", "Nombre Empresa", "Nombre Proyecto", "Fecha", "Resumen", "Acciones" }
        ));

        // Configuración de la apariencia de la tabla
        jTableEstudiante.setGridColor(new java.awt.Color(204, 204, 204));
        jTableEstudiante.setRowHeight(45);
        jTableEstudiante.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTableEstudiante);

        // Configuración de la columna de acciones
        jTableEstudiante.getColumnModel().getColumn(5).setMinWidth(225);
        jTableEstudiante.getColumnModel().getColumn(5).setMaxWidth(225);
        jTableEstudiante.getColumnModel().getColumn(5).setPreferredWidth(225);
        jTableEstudiante.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRenderEstudiante());
        jTableEstudiante.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditorEstudiante(projectService, student));

        // Aplicar renderizador para mostrar múltiples líneas en las celdas de texto
        for (int i = 0; i < jTableEstudiante.getColumnCount() - 1; i++) {
            jTableEstudiante.getColumnModel().getColumn(i).setCellRenderer(new MultiLineCellRenderer());
        }

        jTableEstudiante.setRowHeight(50);
    }

    /**
     * Método que se ejecuta cuando la tabla necesita actualizarse.
     * Limpia la tabla y vuelve a cargar los datos.
     */
    @Override
    public void update() {
        configurarTabla();
    }
}