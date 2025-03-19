package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.IProjectRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.infra.Messages;
import co.edu.unicauca.mycompany.projects.infra.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que gestiona la lógica de negocio relacionada con los proyectos.
 * Se encarga de interactuar con el repositorio de proyectos y de notificar a los observadores
 * cuando ocurren cambios relevantes en los proyectos.
 */
public class ProjectService extends Subject{

    private final IProjectRepository repository;
    
    /**
     * Validador de los datos de las empresas.
     */
    private IValidation validator;

    /**
     * Constructor que inicializa el servicio con un repositorio de proyectos.
     *
     * @param repository Implementación de IProjectRepository para la gestión de proyectos.
     */
    public ProjectService(IProjectRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtiene la lista de todos los proyectos registrados.
     *
     * @return Lista de proyectos disponibles en el repositorio.
     */
    public List<Project> listProjects() {
        return repository.listAll();
    }

    /**
     * Obtiene la lista de proyectos disponibles para un estudiante específico.
     *
     * @param studentId Identificador del estudiante.
     * @return Lista de proyectos a los que el estudiante puede postularse.
     */
    public List<Project> projectsAvailable(String studentId) {
        return repository.listProjectsAvailable(studentId);
    }

    /**
     * Obtiene la información de un proyecto específico.
     *
     * @param nit Identificador del proyecto.
     * @return Objeto Project con la información del proyecto solicitado.
     */
    public Project getProject(String nit) {
        return repository.getProject(nit);
    }
    /**
     * Guarda un Proyecto en el sistema.
     *
     * @param newProject Objeto Project con la información del proyect de la empresa.
     * @return true si el proyecto fue guardado correctamente, false en caso
     * contrario.
     */
    public boolean saveProject(Project newProject) {
        return repository.save(newProject);
    }

    /**
     * Permite que un estudiante se postule a un proyecto.
     * Si la postulación es exitosa, muestra un mensaje de confirmación.
     * En caso contrario, muestra un mensaje de error.
     *
     * @param studentId Identificador del estudiante.
     * @param projectId Identificador del proyecto.
     */
    public void applyStudent(String studentId, String projectId) {
        if (repository.apply(studentId, projectId)) {
            Messages.mensajeVario("Postulación enviada al proyecto: " + projectId);
        } else {
            Messages.showErrorDialog("No se pudo enviar la solicitud", "Error");
        }
    }
    
    /**
     * Obtiene estadísticas de los proyectos de un estudiante para su visualización en gráficos.
     *
     * @param studentId Identificador del estudiante.
     * @return Lista de enteros representando los datos estadísticos de los proyectos del estudiante.
     */
    public List<Integer> dataGraphicStudent(String studentId) {
        return repository.countProjectsStudent(studentId);
    }
    
    public List<Integer> dataGraphicCoordinator() {
        List<Integer> data = new ArrayList<>();

        data.add(repository.countByStatus("RECIBIDO"));
        data.add(repository.countByStatus("ACEPTADO"));
        data.add(repository.countByStatus("RECHAZADO"));
        data.add(repository.countByStatus("EJECUCION"));
        data.add(repository.countByStatus("CERRADO"));
        data.add(repository.countTotalProjects());

        return data;
    }
    
    public boolean updateProjectStatus(String projectId, String newStatus) {
        boolean success = repository.updateProjectStatus(projectId, newStatus);

        if (success) {
            notifyAllObserves(); // Notificar a los observadores que hubo un cambio
        }

        return success;
    }
    
    /**
     * Verifica si un usuario con el ID especificado ya existe en la base de datos.
     *
     * @param userId El identificador único del usuario a verificar.
     * @return true si el ID del usuario ya existe en el repositorio, false en caso contrario.
     */
    public boolean existProjectId(String projectId) {
        return repository.existProjectId(projectId);
    }
    
    /**
     * Valida los datos de un proyecto utilizando la clase
     * DataValidationProject.
     *
     * @param newProject El proyecto cuyos datos se desean validar.
     * @return true si los datos del proyecto son válidos, false en caso
     * contrario.
     * @throws Exception Si ocurre un error durante la validación.
     */
    public boolean validData(Project newProject) throws Exception {
        validator = new DataValidationProject(newProject);
        return validator.isValid();
    }
    
}

    


