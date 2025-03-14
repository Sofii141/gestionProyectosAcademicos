package co.edu.unicauca.mycompany.projects.main;

import co.edu.unicauca.mycompany.projects.presentation.GUIDashboardEstudiante;

/**
 *
 * @author Libardo Pantoja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUIDashboardEstudiante instance = new GUIDashboardEstudiante("U001");

        instance.setVisible(true);
    }
    
}
