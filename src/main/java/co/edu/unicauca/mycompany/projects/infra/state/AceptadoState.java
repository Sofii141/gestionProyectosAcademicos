package co.edu.unicauca.mycompany.projects.infra.state;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.domain.services.EmailService;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;


/**
 * Clase que representa el estado "ACEPTADO" dentro del patrón de estado para proyectos.
 * 
 * Cuando un proyecto cambia a este estado, se notifica a la empresa asociada
 * y se actualiza el estado en la base de datos.
 */
public class AceptadoState implements ProjectStatePatron {

    /** Servicio para gestionar operaciones relacionadas con empresas. */
    private CompanyService companyService;

    /** Servicio para gestionar operaciones relacionadas con proyectos. */
    private ProjectService projectService;

    /**
     * Constructor que inicializa el estado "ACEPTADO" con los servicios necesarios.
     * 
     * @param companyService Servicio para la gestión de empresas.
     * @param projectService Servicio para la gestión de proyectos.
     */
    public AceptadoState(CompanyService companyService, ProjectService projectService) {
        ICompanyRepository companyRepository = Factory.getInstance().getRepositoryCompany("MARIADB"); 
        this.companyService = new CompanyService(companyRepository); // Se inicializa correctamente
        this.projectService = projectService;
    }

    /** Constructor vacío. */
    public AceptadoState() { 
    }

    /**
     * Maneja el cambio de estado de un proyecto al estado "ACEPTADO".
     * 
     * @param project Proyecto cuyo estado ha cambiado.
     */
    @Override
    public void handleStateChange(Project project) {
        project.setProStatePatron(this);
        notifyCompany(project);
    }

    /**
     * Notifica a la empresa asociada al proyecto que el estado ha cambiado a "ACEPTADO".
     * 
     * @param project Proyecto cuyo estado ha cambiado.
     */
    @Override
    public void notifyCompany(Project project) {
        Company company = companyService.getCompany(project.getIdcompany()); // Buscar empresa

        if (company != null) {
            // Imprimir el objeto para verificar su contenido
            System.out.println("Empresa encontrada: " + company);

            // También imprimir el correo para asegurarse de que no es null
            System.out.println("Correo de la empresa: " + company.getUserEmail());

            EmailService.sendEmail(company.getUserEmail(), "Estado actualizado", 
                "Se le informa que su proyecto ha sido cambiado a ACEPTADO.");
        } else {
            System.out.println("Error: No se encontró la empresa asociada al proyecto.");
            System.out.println("ID de la empresa buscada: " + project.getIdcompany());
        }
    }

    /**
     * Actualiza el estado del proyecto en la base de datos.
     * 
     * @param project Proyecto que se actualizará.
     * @param projectService Servicio utilizado para actualizar el estado del proyecto.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    @Override
    public boolean updateDatabase(Project project, ProjectService projectService) {
        return projectService.updateProjectStatus(project.getProId(), "ACEPTADO"); // Usamos el servicio
    }

    /**
     * Devuelve una representación en cadena del estado.
     * 
     * @return "ACEPTADO".
     */
    @Override
    public String toString() {
        return "ACEPTADO";
    }
}