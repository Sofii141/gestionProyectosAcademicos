package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import java.util.List;

/**
 * Interfaz que define el contrato para el repositorio de proyectos.
 * 
 * Proporciona métodos para guardar, listar, obtener y gestionar proyectos,
 * así como la posibilidad de aplicar a ellos.
 * 
 */
public interface IProjectRepository {
    /**
     * Guarda un nuevo proyecto en el repositorio.
     * 
     * @param newProject Objeto Project con la información del proyecto a guardar.
     * @return true si el proyecto se guardó con éxito, false en caso contrario.
     */
    boolean save(Project newProject);
    
    /**
     * Obtiene una lista con todos los proyectos almacenados en el repositorio.
     * 
     * @return Lista de proyectos registrados.
     */
    List<Project> listAll();
    
    /**
     * Obtiene una lista de proyectos disponibles para un estudiante específico.
     * 
     * @param studentId Identificador del estudiante.
     * @return Lista de proyectos disponibles para el estudiante.
     */
    List<Project> listProjectsAvailable(String studentId);
    
    /**
     * Obtiene la información detallada de un proyecto a partir de su identificador.
     * 
     * @param id Identificador único del proyecto.
     * @return Objeto Project con la información del proyecto, o null si no se encuentra.
     */
    Project getProject(String id);
    
    /**
     * Permite que un estudiante aplique a un proyecto específico.
     * 
     * @param studentId Identificador del estudiante.
     * @param projectId Identificador del proyecto al que se desea aplicar.
     * @return true si la aplicación fue exitosa, false en caso contrario.
     */
    boolean apply(String studentId,String projectId);
    
    /**
     * Cuenta la cantidad de proyectos en los que un estudiante está involucrado
     * 
     * @param studentId Identificador del estudiante.
     * @return Lista de enteros donde cada valor representa una cantidad específica
     *         de proyectos según su estado.
     */
    List<Integer> countProjectsStudent(String studentId);
}
    
