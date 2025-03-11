
package co.edu.unicauca.mycompany.projects.main;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.access.IUserRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Student;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.domain.services.UserService;
import co.edu.unicauca.mycompany.projects.presentation.GUIDashboardCoordinador;
import co.edu.unicauca.mycompany.projects.presentation.GUIDashboardEstudiante;
import co.edu.unicauca.mycompany.projects.presentation.GUIMenu;
import co.edu.unicauca.mycompany.projects.presentation.GUIProyectosDisponibles;
import co.edu.unicauca.mycompany.projects.presentation.GUIVerDetalles;
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
        //Student estudiante = new Student("11","paula andrea munoz delgado","paula@gmail");
        //GUIDashboardEstudiante instance = new GUIDashboardEstudiante(estudiante);
        
        
        IUserRepository  repository = Factory.getInstance().getRepository("MARIADB", IUserRepository.class);
        UserService service = new UserService(repository);
        GUIinicioSesion instance = new GUIinicioSesion(service);
        instance.setVisible(true);
    }
    
}
