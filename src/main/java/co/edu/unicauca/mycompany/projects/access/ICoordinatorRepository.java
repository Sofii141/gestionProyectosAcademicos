/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Coordinator;
import java.util.List;

/**
 * Interfaz que define las operaciones para gestionar coordinadores en el repositorio.
 */
public interface ICoordinatorRepository {
    /**
     * Guarda un nuevo coordinador en el repositorio.
     * 
     * @param newCoordinator Objeto Coordinator con la información del coordinador a guardar.
     * @return true si el coordinador se guardó con éxito, false en caso contrario.
     */
    boolean save(Coordinator newCoordinator);

    /**
     * Obtiene una lista con todos los coordinadores almacenados en el repositorio.
     * 
     * @return Lista de coordinadores registrados.
     */
    List<Coordinator> listAll();

    /**
     * Obtiene la información detallada de un coordinador a partir de su identificador.
     * 
     * @param id Identificador único del coordinador.
     * @return Objeto Coordinator con la información del coordinador, o null si no se encuentra.
     */
    Coordinator getCoordinator(String id);
}
