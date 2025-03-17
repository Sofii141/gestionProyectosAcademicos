/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.domain.entities.Coordinator;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Ana_Sofia
 */
public class TableActionCellEditorCoordinator extends DefaultCellEditor{
        
    private final Coordinator coordinator; // Coordinador que interactúa con la tabla
    private final ProjectService projectService; // Servicio de gestión de proyectos
    
    public TableActionCellEditorCoordinator(ProjectService projectService, Coordinator coordinator){
        super(new JCheckBox());
        this.coordinator = coordinator;
        this.projectService = projectService;
    }
    
    
    /**
     * Obtiene el componente de edición de celda para la tabla.
     * 
     * @param jtable Tabla donde se encuentra la celda
     * @param value Valor de la celda (no se usa en este caso)
     * @param isSelected Indica si la celda está seleccionada
     * @param row Fila de la celda
     * @param column Columna de la celda
     * @return Componente que se mostrará en la celda (Panel de acciones del estudiante)
     */
    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object value, boolean isSelected, int row, int column){
        // Se obtiene el ID del proyecto de la primera columna
        String idPro = (String) jtable.getValueAt(row, 0);
        
        // Se obtiene el objeto Project correspondiente
        Project proyecto = obtenerProyecto(idPro);
        
        if (proyecto == null) {
           System.out.println("Advertencia: No se encontró el proyecto con ID: " + idPro);
           return new JCheckBox(); 
        }
        // Se crea el panel de acciones
        PanelActionCoordinator action = new PanelActionCoordinator(projectService, proyecto, coordinator);
        
        // Se ajusta el fondo para mantener la coherencia visual
        action.setBackground(jtable.getSelectionBackground());
        
        return action;
    }
    
    /**
     * Obtiene un objeto Project a partir de su identificador.
     *
     * @param idProject Identificador del proyecto
     * @return Objeto Project correspondiente
     */
    private Project obtenerProyecto(String idProject) {
        return projectService.getProject(idProject);
    }
}
