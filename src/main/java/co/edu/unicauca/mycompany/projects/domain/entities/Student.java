package co.edu.unicauca.mycompany.projects.domain.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un estudiante en el sistema.
 * Un estudiante es un usuario que puede participar en proyectos y postularse a ellos.
 */
public class Student extends User {
    
    // Lista de proyectos en los que el estudiante está participando activamente. 
    private List<Project> myProjects;
    
    // Lista de proyectos a los que el estudiante se ha postulado.
    private List<Project> myPostulations;

    /**
     * Constructor de la clase Student.
     * 
     * @param userId Identificador único del estudiante.
     * @param userEmail Correo electrónico del estudiante.
     * @param userPassword Contraseña del estudiante.
     */
    public Student(String userId, String userEmail, String userPassword) {
        super(userId, userEmail, userPassword);
        this.myProjects = new ArrayList<>();
        this.myPostulations = new ArrayList<>();
    }

    /**
     * Obtiene la lista de proyectos en los que el estudiante participa.
     * 
     * @return Lista de proyectos activos del estudiante.
     */
    public List<Project> getMyProjects() {
        return myProjects;
    }

    /**
     * Establece la lista de proyectos en los que el estudiante participa.
     * 
     * @param myProjects Lista de proyectos en los que el estudiante está participando.
     */
    public void setMyProjects(List<Project> myProjects) {
        this.myProjects = myProjects;
    }

    /**
     * Obtiene la lista de proyectos a los que el estudiante se ha postulado.
     * 
     * @return Lista de proyectos en los que el estudiante ha enviado una postulación.
     */
    public List<Project> getMyPostulations() {
        return myPostulations;
    }

    /**
     * Establece la lista de postulaciones del estudiante.
     * 
     * @param myPostulations Lista de proyectos a los que el estudiante se ha postulado.
     */
    public void setMyPostulations(List<Project> myPostulations) {
        this.myPostulations = myPostulations;
    }
}
