package co.edu.unicauca.mycompany.projects.main;

import co.edu.unicauca.mycompany.projects.presentation.GUIDashboardCoordinador;
import co.edu.unicauca.mycompany.projects.presentation.GUIDashboardCoordinadorInicio;
import co.edu.unicauca.mycompany.projects.presentation.GUIDashboardEstudiante;

public class Main {

    public static void main(String[] args) {
        GUIDashboardCoordinadorInicio instance = new GUIDashboardCoordinadorInicio("U003");
        instance.setVisible(true);
    }
    
}
