package co.edu.unicauca.mycompany.projects.domain.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un coordinador dentro del sistema, que es un tipo de usuario con 
 * la capacidad de gestionar proyectos.
 * 
 * Un coordinador tiene una lista de proyectos asociados que puede supervisar o administrar.
 * 
 */
public class Coordinator extends User {

    // Lista de proyectos asignados al coordinador
    private List<Project> coordProjects;

    /**
     * Constructor que inicializa un coordinador con su información de usuario.
     *
     * @param userId Identificador único del coordinador.
     * @param userEmail Correo electrónico del coordinador.
     * @param userPassword Contraseña del coordinador.
     */
    public Coordinator(String userId, String userEmail, String userPassword) {
        super(userId, userEmail, userPassword);
        this.coordProjects = new ArrayList<>(); // Inicializa la lista de proyectos
    }

    /**
     * Obtiene la lista de proyectos asociados al coordinador.
     *
     * @return Lista de proyectos del coordinador.
     */
    public List<Project> getCoordProjects() {
        return coordProjects;
    }

    /**
     * Establece la lista de proyectos que el coordinador gestionará.
     *
     * @param coordProjects Lista de proyectos a asignar al coordinador. 
     *                      Si es null, se asignará una lista vacía.
     */
    public void setCoordProjects(List<Project> coordProjects) {
        if (coordProjects == null) {
            this.coordProjects = new ArrayList<>(); // Evita asignar null
        } else {
            this.coordProjects = coordProjects;
        }
    }
    
    /**
     * Agrega un proyecto a la lista de proyectos que el coordinador gestiona.
     *
     * @param project Proyecto a añadir.
     */
    public void addProject(Project project) {
        if (!coordProjects.contains(project)) {
            coordProjects.add(project);
        }
    }

    /**
     * Elimina un proyecto de la lista de proyectos del coordinador.
     *
     * @param project Proyecto a eliminar.
     */
    public void removeProject(Project project) {
        coordProjects.remove(project);
    }
}
