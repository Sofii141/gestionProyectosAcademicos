package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Coordinator;
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
public class TableProjectsCoordinatorObserver extends JFrame implements Observer {
    private final JTable jTableCoordinator;
    private final JScrollPane jScrollPane1;
    private final ProjectService projectService;
    private final Coordinator coordinator;
    
    /**
     * Constructor de la clase.
     * 
     * @param coordinator Estudiante actual
     * @param projectService Servicio de proyectos
     * @param jTableCoordinator Tabla que muestra los proyectos disponibles
     * @param jScrollPane1 Panel de desplazamiento para la tabla
     */
    public TableProjectsCoordinatorObserver(Coordinator coordinator, ProjectService projectService, JTable jTableCoordinator, JScrollPane jScrollPane1) {
        this.coordinator = coordinator;
        this.jTableCoordinator = jTableCoordinator;
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

        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) jTableCoordinator.getModel();

        // Limpiar la tabla antes de cargar nuevos datos
        modelo.setRowCount(0);

        // Obtener el servicio de compañías
        ICompanyRepository companyRepository = Factory.getInstance().getRepositoryCompany("MARIADB");
        CompanyService companyService = new CompanyService(companyRepository);

        // Obtener la lista de proyectos
        List<Project> projects = projectService.listProjects();
        
        // Agregar cada proyecto a la tabla
        for (Project project : projects) {
            Company company = companyService.getCompany(project.getIdcompany());
            modelo.addRow(new Object[]{
                project.getProId(),
                company.getCompanyNit(),
                company.getCompanyName(),
                project.getProTitle(),
                project.getProDate(),
                "Acciones"
            });
        }
           
        modelo.fireTableDataChanged();
    }
    
    /**
     * Configura los componentes de la tabla, incluyendo su diseño y renderizadores.
     */
    private void initComponents(){
        jTableCoordinator.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] { "Id" ,"NIT Empresa", "Nombre Empresa", "Nombre Proyecto", "Fecha", "Acciones" }
        ));

        // Configuración de la apariencia de la tabla
        jTableCoordinator.setGridColor(new java.awt.Color(204, 204, 204));
        jTableCoordinator.setRowHeight(45);
        jTableCoordinator.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTableCoordinator);

        // Configuración de la columna de acciones
        jTableCoordinator.getColumnModel().getColumn(5).setMinWidth(325);
        jTableCoordinator.getColumnModel().getColumn(5).setMaxWidth(325);
        jTableCoordinator.getColumnModel().getColumn(5).setPreferredWidth(325);
        jTableCoordinator.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRenderCoordinator());
        jTableCoordinator.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditorCoordinator(projectService, coordinator));

        // Aplicar renderizador para mostrar múltiples líneas en las celdas de texto
        for (int i = 0; i < jTableCoordinator.getColumnCount() - 1; i++) {
            jTableCoordinator.getColumnModel().getColumn(i).setCellRenderer(new MultiLineCellRenderer());
        }

        jTableCoordinator.setRowHeight(50);
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