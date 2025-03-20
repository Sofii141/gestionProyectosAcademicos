package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.ICoordinatorRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Coordinator;

/**
 * Servicio para la gestión de coordinadores en el sistema.
 * Proporciona métodos para manejar las operaciones relacionadas con los coordinadores.
 */
public class CoordinatorService {

    /** Repositorio que maneja las operaciones de acceso a datos de coordinadores. */
    private final ICoordinatorRepository repository;

     /**
     * Constructor que inicializa el servicio con un repositorio de coordinadores.
     *
     * @param repository Implementación de ICoordinatorRepository para la gestión de coordinadores.
     */
    public CoordinatorService(ICoordinatorRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtiene la información de un coordinador específico.
     *
     * @param id Identificador del coordinador.
     * @return Objeto Coordinator con la información del coordinador solicitado.
     */
    public Coordinator getCoordinator(String id) {
        return repository.getCoordinator(id);
    }
}

