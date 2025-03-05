package co.edu.unicauca.mycompany.projects.presentation;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Renderizador para una celda que contiene un panel con botones.
 */
public class TableActionCellRender implements TableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Retornar el JPanel que contiene los botones
        return new PanelAction(); // Asegúrate de que este panel tiene los botones correctamente diseñados
    }
}
