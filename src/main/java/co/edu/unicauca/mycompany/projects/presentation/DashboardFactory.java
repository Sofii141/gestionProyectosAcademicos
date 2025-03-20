/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.access.ICoordinatorRepository;
import co.edu.unicauca.mycompany.projects.access.IProjectRepository;
import co.edu.unicauca.mycompany.projects.access.IStudentRepository;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.domain.services.CoordinatorService;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;
import co.edu.unicauca.mycompany.projects.domain.services.StudentService;

/**
 *
 * @author spart
 */
public class DashboardFactory {
    private static DashboardFactory instance;
    private StudentService studentService;
    CoordinatorService coordinatorService;
    CompanyService companyService;
    ProjectService projectService;
    public DashboardFactory(){
        // Obtener instancias de los repositorios a través de la fábrica
        IStudentRepository studentRepository = Factory.getInstance().getRepositoryStudent("MARIADB");
        studentService = new StudentService(studentRepository);
        
        ICoordinatorRepository coordinatorRepository = Factory.getInstance().getRepositoryCoordinator("MARIADB");
        coordinatorService = new CoordinatorService(coordinatorRepository);

        ICompanyRepository companyRepository = Factory.getInstance().getRepositoryCompany("MARIADB");
        companyService = new CompanyService(companyRepository);
        
        IProjectRepository projectRepository = Factory.getInstance().getRepositoryProject("MARIADB");
        projectService = new ProjectService(projectRepository);
    }
    public Dashboard crearDashboard(int result, String idEntity){
        switch(result){
            case 1:
                return new GUIDashboardEstudiante(studentService.getStudent(idEntity),projectService);
            case 2:
                return new GUIDashboardCoordinadorInicio(coordinatorService.getCoordinator(idEntity), projectService);
            case 3:
                return new GUIDashboardEmpresa(companyService.getCompany(idEntity));
            default:
                return null;
        }
    }
    /**
     * Obtiene la instancia única de la fábrica (patrón Singleton).
     * 
     * @return Instancia de Factory.
     */
    public static DashboardFactory getInstance() {
        if (instance == null) {
            instance = new DashboardFactory();
        }
        return instance;
    }
}
