
package co.edu.unicauca.mycompany.projects.main;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.presentation.GUIDashboardCoordinador;
import co.edu.unicauca.mycompany.projects.presentation.GUIMenu;
import co.edu.unicauca.mycompany.projects.presentation.GUIinicioSesion;
import javax.swing.JFrame;


/**
 *
 * @author Libardo Pantoja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GUIDashboardCoordinador instance = new GUIDashboardCoordinador();
        instance.setVisible(true);
    }
    
}
