package co.edu.unicauca.mycompany.projects.infra.state;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.domain.services.EmailService;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;
import co.edu.unicauca.mycompany.projects.infra.Messages;


/**
 * Clase que representa el estado "ACEPTADO" dentro del patrón de estado para proyectos.
 * 
 * Cuando un proyecto cambia a este estado, se notifica a la empresa asociada
 * y se actualiza el estado en la base de datos.
 */
public class AceptadoState implements ProjectStatePatron {

    /** Servicio para gestionar operaciones relacionadas con empresas. */
    private CompanyService companyService;

    /**
     * Constructor que inicializa el estado "ACEPTADO" con los servicios necesarios.
     * 
     * @param companyService Servicio para la gestión de empresas.
     */
    public AceptadoState(CompanyService companyService) {
        this.companyService = companyService;
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
            String mensaje = Messages.mensajeCambioEstado(company.getCompanyName(), project.getProTitle(), "ACEPTADO");
            
            EmailService.sendEmail(company.getUserEmail(), "Notificación de Cambio de Estado en Proyecto de Software", mensaje);
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