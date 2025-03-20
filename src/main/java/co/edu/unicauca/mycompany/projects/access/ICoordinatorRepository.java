package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Coordinator;

/**
 * Interfaz que define las operaciones para gestionar coordinadores en el repositorio.
 */
public interface ICoordinatorRepository {
    /**
     * Obtiene la información detallada de un coordinador a partir de su identificador.
     * 
     * @param id Identificador único del coordinador.
     * @return Objeto Coordinator con la información del coordinador, o null si no se encuentra.
     */
    Coordinator getCoordinator(String id);
}
