package co.edu.unicauca.mycompany.projects.presentation;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Renderizador para una celda que contiene un panel con botones.
 */
public class TableActionCellRenderEstudiante extends DefaultTableCellRenderer {


    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component com = super.getTableCellRendererComponent(jtable, value, isSelected, hasFocus, row, column);
        
        PanelActionEstudiante action = new PanelActionEstudiante();
        
        if(isSelected==false&&row%2==0){
            action.setBackground(Color.WHITE);
        }else{
            action.setBackground(com.getBackground());
        }
         
        return action; 
    }
}
