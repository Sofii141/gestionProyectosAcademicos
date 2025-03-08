package co.edu.unicauca.mycompany.projects.presentation;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @class MultiLineCellRenderer
 * @brief Renderizador personalizado para celdas que soportan texto multilínea en una JTable.
 *
 * Esta clase extiende `DefaultTableCellRenderer` y utiliza un `JTextArea` para permitir
 * que el texto dentro de una celda se ajuste automáticamente en múltiples líneas,
 * mejorando la visualización de información extensa.
 */
public class MultiLineCellRenderer extends DefaultTableCellRenderer {
    
    /**
     * @brief Configura el renderizador para cada celda de la tabla.
     *
     * Este método reemplaza el renderizado predeterminado de una celda,
     * permitiendo que su contenido se ajuste a múltiples líneas dentro de un `JTextArea`.
     *
     * @param table La tabla en la que se encuentra la celda.
     * @param value El valor contenido en la celda.
     * @param isSelected Indica si la celda está seleccionada.
     * @param hasFocus Indica si la celda tiene el foco.
     * @param row Índice de la fila de la celda.
     * @param column Índice de la columna de la celda.
     * @return Un componente `JTextArea` configurado como renderizador de la celda.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JTextArea textArea = new JTextArea();
        textArea.setText(value != null ? value.toString() : ""); // Asigna el valor de la celda al `JTextArea`. 
        textArea.setWrapStyleWord(true); // Activa el ajuste automático en palabras completas. 
        textArea.setLineWrap(true); // Habilita la división de líneas para el texto. 
        textArea.setOpaque(true); // Mantiene el fondo de la celda visible. 

        // Configurar colores en función de la selección de la celda
        if (isSelected) {
            textArea.setBackground(table.getSelectionBackground());
            textArea.setForeground(table.getSelectionForeground());
        } else {
            textArea.setBackground(table.getBackground());
            textArea.setForeground(table.getForeground());
        }

        return textArea; // Devuelve el `JTextArea` como renderizador de la celda.
    }
}
