package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.entities.Student;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 * Editor de celdas personalizado para agregar un panel de acciones en la tabla de proyectos disponibles.
 * Este editor permite a los estudiantes interactuar con los proyectos en la tabla mediante un panel de acciones.
 */
public class TableActionCellEditorEstudiante extends DefaultCellEditor {

    /** Estudiante que interactúa con la tabla */
    private final Student estudiante;

    /** Servicio de gestión de proyectos */
    private final ProjectService projectService;

    /**
     * Constructor de la clase.
     * 
     * @param projectService Servicio de gestión de proyectos.
     * @param estudiante Estudiante que interactúa con la tabla.
     */
    public TableActionCellEditorEstudiante(ProjectService projectService, Student estudiante) {
        super(new JCheckBox()); // Se usa un JCheckBox como editor base (no se muestra)
        this.estudiante = estudiante;
        this.projectService = projectService;
    }

    /**
     * Obtiene el componente de edición de celda para la tabla.
     * Se encarga de obtener el proyecto correspondiente y mostrar un panel de acciones.
     * 
     * @param jtable Tabla donde se encuentra la celda.
     * @param value Valor de la celda (no se usa en este caso).
     * @param isSelected Indica si la celda está seleccionada.
     * @param row Fila de la celda.
     * @param column Columna de la celda.
     * @return Componente que se mostrará en la celda (Panel de acciones del estudiante).
     */
    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object value, boolean isSelected, int row, int column) {
        // Se obtiene el ID del proyecto de la primera columna
        String idPro = (String) jtable.getValueAt(row, 0);

        // Se obtiene el objeto Project correspondiente
        Project proyecto = obtenerProyecto(idPro);

        if (proyecto == null) {
            System.out.println("Advertencia: No se encontró el proyecto con ID: " + idPro);
            return new JCheckBox();
        }

        // Se crea el panel de acciones para el estudiante
        PanelActionEstudiante action = new PanelActionEstudiante(projectService, proyecto, estudiante);

        // Se ajusta el fondo para mantener la coherencia visual
        action.setBackground(jtable.getSelectionBackground());

        return action;
    }

    /**
     * Obtiene un objeto Project a partir de su identificador.
     * 
     * @param idProject Identificador del proyecto.
     * @return Objeto Project correspondiente o {@code null} si no se encuentra.
     */
    private Project obtenerProyecto(String idProject) {
        return projectService.getProject(idProject);
    }
}