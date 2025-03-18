package co.edu.unicauca.mycompany.projects.main;


import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.access.ICoordinatorRepository;
import co.edu.unicauca.mycompany.projects.access.IProjectRepository;
import co.edu.unicauca.mycompany.projects.access.IStudentRepository;
import co.edu.unicauca.mycompany.projects.access.IUserRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Student;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.domain.services.UserService;
import co.edu.unicauca.mycompany.projects.presentation.GUIDashboardCoordinador;
import co.edu.unicauca.mycompany.projects.presentation.GUIDashboardCoordinadorInicio;
import co.edu.unicauca.mycompany.projects.presentation.GUIDashboardEstudiante;
import co.edu.unicauca.mycompany.projects.presentation.GUIProyectosDisponibles;
import co.edu.unicauca.mycompany.projects.presentation.GUIVerDetalles;
import co.edu.unicauca.mycompany.projects.presentation.GUIinicioSesion;

public class Main {

    public static void main(String[] args) {
        //GUIDashboardCoordinadorInicio instance = new GUIDashboardCoordinadorInicio("U003");
        //Student estudiante = new Student("11","paula andrea munoz delgado","paula@gmail");
        //GUIDashboardEstudiante instance = new GUIDashboardEstudiante(estudiante);
        
        
        //IUserRepository  repository = Factory.getInstance().getRepository("MARIADB", IUserRepository.class); //TODO: generalizar esta mierda
        IUserRepository repositoryUser = Factory.getInstance().getRepositoryUSer("MARIADB");
        ICompanyRepository repositoryCompany = Factory.getInstance().getRepositoryCompany("MARIADB");
        IStudentRepository repositoryStudent = Factory.getInstance().getRepositoryStudent("MARIADB");
        ICoordinatorRepository repositoryProject = Factory.getInstance().getRepositoryCoordinator("MARIADB");

        UserService service = new UserService(repositoryUser);
        GUIinicioSesion instance = new GUIinicioSesion(service);
        instance.setVisible(true);
    }
    
}
