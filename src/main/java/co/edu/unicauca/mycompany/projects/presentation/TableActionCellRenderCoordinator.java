package co.edu.unicauca.mycompany.projects.presentation;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Renderizador para una celda que contiene un panel con botones.
 */
public class TableActionCellRenderCoordinator extends DefaultTableCellRenderer {

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

        Component com = super.getTableCellRendererComponent(jtable, value, isSelected, hasFocus, row, column);
        
        PanelActionCoordinator action = new PanelActionCoordinator(null, null, null, null);
        
        if(isSelected==false&&row%2==0){
            action.setBackground(Color.WHITE);
        }else{
            action.setBackground(com.getBackground());
        }
         
        return action; 
    }
}
