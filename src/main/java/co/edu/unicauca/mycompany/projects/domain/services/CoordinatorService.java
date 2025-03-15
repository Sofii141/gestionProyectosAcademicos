package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;

/**
 * Servicio para la gestión de coordinadores en el sistema.
 * Proporciona métodos para manejar las operaciones relacionadas con los coordinadores.
 */
public class CoordinatorService {

    /** Repositorio que maneja las operaciones de acceso a datos de coordinadores. */
    private ICompanyRepository repository;

    /**
     * Constructor vacío de la clase CoordinatorService.
     * Se recomienda inyectar un repositorio antes de utilizar los métodos de esta clase.
     */
    public CoordinatorService() {
    }
}

