package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @file TableActionCellRenderEstudiante.java
 * @brief Renderizador personalizado para una celda que contiene un panel con botones.
 *
 * Esta clase extiende `DefaultTableCellRenderer` y permite mostrar un `PanelActionEstudiante`
 * dentro de una celda de la tabla, ajustando su apariencia en función de la selección y el índice de la fila.
 */
public class TableActionCellRenderEstudiante extends DefaultTableCellRenderer {
    /**
     * @brief Personaliza la apariencia de la celda en la tabla.
     * 
     * @param jtable La tabla donde se encuentra la celda.
     * @param value El valor que contiene la celda.
     * @param isSelected Indica si la celda está seleccionada.
     * @param hasFocus Indica si la celda tiene el foco.
     * @param row Índice de la fila de la celda.
     * @param column Índice de la columna de la celda.
     * @return Un componente que representa la celda renderizada.
     */
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Obtener la representación por defecto de la celda
        Component com = super.getTableCellRendererComponent(jtable, value, isSelected, hasFocus, row, column);
        
        // Crear un panel de acciones personalizado
        PanelActionEstudiante action = new PanelActionEstudiante(null, null, null);
        
        // Configurar el color de fondo del panel de la celda.
        // Si la celda no está seleccionada y la fila es par, se establece el fondo en blanco
        // En caso contrario, mantiene el fondo original de la celda.
        if (!isSelected && row % 2 == 0) {
            action.setBackground(Color.WHITE);
        } else {
            action.setBackground(com.getBackground());
        }
        
        return action; // Devuelve el panel de acción como renderizador de la celda.
    }
}
