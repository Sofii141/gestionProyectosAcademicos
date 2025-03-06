/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.presentation;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Ana_Sofia
 */
public class TableActionCellEditor extends DefaultCellEditor{
        
    public TableActionCellEditor(){
        super(new JCheckBox());
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object value, boolean isSelected, int row, int column){
        PanelAction action = new PanelAction();
        action.setBackground(jtable.getSelectionBackground());
        
        return action;
    }
}
