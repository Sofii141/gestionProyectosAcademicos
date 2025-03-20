package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.IStudentRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Student;

/**
 * Servicio que gestiona la lógica de negocio relacionada con los estudiantes.
 * Se encarga de interactuar con el repositorio de estudiantes para obtener información.
 */
public class StudentService {
    
    /** Repositorio que maneja las operaciones de acceso a datos de estudiantes. */
    private final IStudentRepository repository;

    /**
     * Constructor que inicializa el servicio con un repositorio de estudiantes.
     *
     * @param repository Implementación de IStudentRepository para la gestión de estudiantes.
     */
    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtiene la información de un estudiante específico.
     *
     * @param nit Identificador del estudiante.
     * @return Objeto Student con la información del estudiante solicitado.
     */
    public Student getStudent(String nit) {
        return repository.getStudent(nit);
    }
}

