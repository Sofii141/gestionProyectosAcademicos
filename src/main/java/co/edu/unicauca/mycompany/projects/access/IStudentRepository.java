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
     * Obtiene la información detallada de un estudiante a partir de su identificador.
     * 
     * @param id Identificador único del estudiante.
     * @return Objeto Student con la información del estudiante, o null si no se encuentra.
     */
    Student getStudent(String id);
}
