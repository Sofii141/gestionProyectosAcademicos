package co.edu.unicauca.mycompany.projects.presentation;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Renderizador de celdas personalizado para agregar un panel de acciones en la tabla de proyectos disponibles.
 * Este renderizador define cómo se visualizan las celdas de la tabla que contienen acciones para los estudiantes.
 */
public class TableActionCellRenderEstudiante extends DefaultTableCellRenderer {

    /**
     * Método que define cómo se debe renderizar cada celda de la tabla.
     * 
     * @param jtable Tabla donde se encuentra la celda
     * @param value Valor de la celda (no se usa en este caso)
     * @param isSelected Indica si la celda está seleccionada
     * @param hasFocus Indica si la celda tiene el foco
     * @param row Fila de la celda
     * @param column Columna de la celda
     * @return Componente que se mostrará en la celda (Panel de acciones del estudiante)
     */
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Se obtiene el componente base renderizado por DefaultTableCellRenderer
        Component com = super.getTableCellRendererComponent(jtable, value, isSelected, hasFocus, row, column);
        
        // Se crea un panel de acciones vacío (sin funcionalidad en el renderizado)
        PanelActionEstudiante action = new PanelActionEstudiante(null, null, null);

        // Se aplica un color de fondo alternado para mejorar la visualización en la tabla
        if (!isSelected && row % 2 == 0) {
            action.setBackground(Color.WHITE); 
        } else {
            action.setBackground(com.getBackground());
        }
        
        return action; 
    }
}