package co.edu.unicauca.mycompany.projects.infra.state;

import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;

/**
 * Interfaz que define el comportamiento de los estados dentro del patrón de estado para proyectos.
 * 
 * Cada estado de un proyecto debe implementar esta interfaz para manejar los cambios de estado,
 * notificar a la empresa asociada y actualizar la base de datos.
 */
public interface ProjectStatePatron {
    /**
     * Maneja el cambio de estado de un proyecto.
     * 
     * @param project Proyecto cuyo estado ha cambiado.
     */
    void handleStateChange(Project project);

    /**
     * Notifica a la empresa asociada sobre el cambio de estado del proyecto.
     * 
     * @param project Proyecto cuyo estado ha cambiado.
     */
    void notifyCompany(Project project);

    /**
     * Actualiza el estado del proyecto en la base de datos.
     * 
     * @param project Proyecto que se actualizará.
     * @param projectService Servicio utilizado para actualizar el estado del proyecto.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    boolean updateDatabase(Project project, ProjectService projectService);

}

