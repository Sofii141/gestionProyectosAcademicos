package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Student;
import java.util.List;

/**
 * Interfaz que define el contrato para el repositorio de estudiantes.
 * 
 * Proporciona métodos para guardar, listar y obtener información de estudiantes.
 * 
 */
public interface IStudentRepository {
    /**
     * Guarda un nuevo estudiante en el repositorio.
     * 
     * @param newStudent Objeto Student con la información del estudiante a guardar.
     * @return true si el estudiante se guardó con éxito, false en caso contrario.
     */
    boolean save(Student newStudent);
    
    /**
     * Obtiene una lista con todos los estudiantes almacenados en el repositorio.
     * 
     * @return Lista de estudiantes registrados.
     */
    List<Student> listAll();
    
    /**
     * Obtiene la información detallada de un estudiante a partir de su identificador.
     * 
     * @param id Identificador único del estudiante.
     * @return Objeto Student con la información del estudiante, o null si no se encuentra.
     */
    Student getStudent(String id);
}
