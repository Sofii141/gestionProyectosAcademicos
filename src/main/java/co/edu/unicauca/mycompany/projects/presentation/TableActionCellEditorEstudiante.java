package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.entities.Student;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 * @file TableActionCellEditorEstudiante.java
 * @brief Editor personalizado para una celda que contiene un panel con botones.
 *
 * Esta clase extiende `DefaultCellEditor` y permite editar una celda en la tabla
 * mediante un `PanelActionEstudiante`, el cual proporciona acciones interactivas.
 */
public class TableActionCellEditorEstudiante extends DefaultCellEditor {
    /**
     * Estudiante asociado al editor de la celda.
     */
    private Student estudiante;

    /**
     * @brief Constructor de la clase.
     *
     * Se inicializa el editor de celda con un `JCheckBox` para cumplir con la estructura
     * esperada por `DefaultCellEditor`, aunque el `JCheckBox` no es utilizado en la interfaz.
     *
     * @param estudiante Estudiante asociado a la acción de la celda.
     */
    public TableActionCellEditorEstudiante(Student estudiante) {
        super(new JCheckBox()); // Llamada al constructor de DefaultCellEditor con un JCheckBox ficticio
        this.estudiante = estudiante; // Asignación del estudiante recibido al atributo de la clase
    }
    
    /**
     * @brief Proporciona el componente editor para una celda específica de la tabla.
     *
     * @param jtable La tabla donde se encuentra la celda.
     * @param value El valor almacenado en la celda.
     * @param isSelected Indica si la celda está seleccionada.
     * @param row Índice de la fila de la celda.
     * @param column Índice de la columna de la celda.
     * @return Un componente `PanelActionEstudiante` como editor de la celda.
     */
    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object value, boolean isSelected, int row, int column) {
        // Obtener el ID del proyecto desde la primera columna de la fila
        String idPro = (String) jtable.getValueAt(row, 0);
        // Obtener el objeto Proyecto correspondiente al ID
        Project proyecto = obtenerProyecto(idPro);
        
        // Crear un panel de acciones personalizado para el estudiante y el proyecto
        PanelActionEstudiante action = new PanelActionEstudiante(proyecto, estudiante);
        
        // Configurar el color de fondo del editor con el color de selección de la tabla
        action.setBackground(jtable.getSelectionBackground());

        return action; // Devuelve el panel de acción como editor de la celda.
    }
    
    /**
     * @brief Obtiene un objeto `Project` a partir de su ID.
     *
     * Simula la búsqueda en una base de datos y devuelve un proyecto con valores predeterminados.
     *
     * @param idPro ID del proyecto a buscar.
     * @return Un objeto `Project` con la información correspondiente.
     */
    private Project obtenerProyecto(String idPro) {
        // Simulación de búsqueda en base de datos: si el ID está vacío, retorna un proyecto predeterminado
        if (idPro.isEmpty()) {
            return new Project("0", "Sin Título", "Sin Descripción", "", "", 0, 0);
        }
        return new Project("0", "Sin Título", "Sin Descripción", "", "", 0, 0); // Se debe implementar la obtención real del proyecto
    }
}
