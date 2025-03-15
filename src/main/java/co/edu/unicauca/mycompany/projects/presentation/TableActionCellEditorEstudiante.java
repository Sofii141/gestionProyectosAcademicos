package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.IProjectRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.entities.Student;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditorEstudiante extends DefaultCellEditor {

    private final Student estudiante;
    
    private final ProjectService projectService;

    public TableActionCellEditorEstudiante(ProjectService projectService, Student estudiante) {
        super(new JCheckBox()); 
        this.estudiante = estudiante; 
        this.projectService = projectService;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object value, boolean isSelected, int row, int column) {
        String idPro = (String) jtable.getValueAt(row, 0);
        Project proyecto = obtenerProyecto(idPro);
        PanelActionEstudiante action = new PanelActionEstudiante(projectService, proyecto, estudiante);
        action.setBackground(jtable.getSelectionBackground());
        return action; 
    }

    private Project obtenerProyecto(String idProject) {
        return projectService.getProject(idProject);
    }
}
