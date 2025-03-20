package co.edu.unicauca.mycompany.projects.infra.state;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.domain.services.EmailService;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;

/**
 * Representa el estado "RECHAZADO" de un proyecto dentro del sistema.
 * 
 * En este estado, el proyecto ha sido rechazado y se notifica a la empresa asociada.
 * Además, se actualiza su estado en la base de datos.
 */
public class RechazadoState implements ProjectStatePatron {
    
    /**
     * Servicio para gestionar la información de las empresas.
     */
    private CompanyService companyService;

    /**
     * Servicio para gestionar la información de los proyectos.
     */
    private ProjectService projectService;

    /**
     * Constructor que inicializa los servicios necesarios para la gestión de proyectos y empresas.
     * 
     * @param companyService Servicio que gestiona la empresa asociada al proyecto.
     * @param projectService Servicio que permite actualizar el estado del proyecto.
     */
    public RechazadoState(CompanyService companyService, ProjectService projectService) {
        ICompanyRepository companyRepository = Factory.getInstance().getRepositoryCompany("MARIADB"); 
        this.companyService = new CompanyService(companyRepository); // Inicialización del servicio de empresa
        this.projectService = projectService;
    }

    /**
     * Constructor vacío. Se recomienda utilizar el constructor con parámetros
     * para asegurar la correcta inicialización de los servicios.
     */
    public RechazadoState() {
    }
    
    /**
     * Maneja el cambio de estado del proyecto a "RECHAZADO".
     * 
     * @param project Proyecto cuyo estado ha cambiado.
     */
    @Override
    public void handleStateChange(Project project) {
        project.setProStatePatron(this);
        notifyCompany(project);
    }

    /**
     * Notifica a la empresa asociada que el proyecto ha sido rechazado mediante un correo electrónico.
     * 
     * @param project Proyecto cuyo estado ha cambiado.
     */
    @Override
    public void notifyCompany(Project project) {
        Company company = companyService.getCompany(project.getIdcompany()); // Buscar empresa asociada

        if (company != null) {
            // Imprimir información de depuración
            System.out.println("Empresa encontrada: " + company);
            System.out.println("Correo de la empresa: " + company.getUserEmail());

            // Enviar notificación por correo
            EmailService.sendEmail(company.getUserEmail(), "Estado actualizado", 
                "Se le informa que su proyecto ha sido cambiado a RECHAZADO.");
        } else {
            System.out.println("Error: No se encontró la empresa asociada al proyecto.");
            System.out.println("ID de la empresa buscada: " + project.getIdcompany());
        }
    }

    /**
     * Devuelve una representación en cadena del estado.
     * 
     * @return Nombre del estado "RECHAZADO".
     */
    @Override
    public String toString() {
        return "RECHAZADO";
    }

    /**
     * Actualiza el estado del proyecto a "RECHAZADO" en la base de datos.
     * 
     * @param project Proyecto que se actualizará.
     * @param projectService Servicio utilizado para actualizar el estado del proyecto.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    @Override
    public boolean updateDatabase(Project project, ProjectService projectService) {
        return projectService.updateProjectStatus(project.getProId(), "RECHAZADO");
    }
}
