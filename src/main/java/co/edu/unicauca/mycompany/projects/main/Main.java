
package co.edu.unicauca.mycompany.projects.main;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.presentation.GUIMenu;
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
        
        // Hacia futuro el tipo de repositorio lo podemos leer de un archivo plano
        // setup.properties, asi no tendriamos que recompilar la aplicación
        ICompanyRepository repository = Factory.getInstance().getRepository("ARRAYS");// Podria ir SQLITE
        CompanyService service = new CompanyService(repository);
        
        GUIMenu instance = new GUIMenu(service);
        instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
        instance.setVisible(true);
    }
    
}
