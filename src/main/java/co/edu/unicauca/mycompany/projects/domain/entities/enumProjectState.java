package co.edu.unicauca.mycompany.projects.domain.entities;

/**
 * Enumeración que representa los posibles estados de un proyecto.
 */
public enum enumProjectState {
    /** Estado cuando el proyecto ha sido recibido pero aún no evaluado. */
    RECIBIDO,

    /** Estado cuando el proyecto ha sido aceptado. */
    ACEPTADO,

    /** Estado cuando el proyecto ha sido rechazado. */
    RECHAZADO,
    
    /** Estado cuando el proyecto se esta ejecutando. */
    EJECUCION,
    
    /** Estado cuando el proyecto ha sido cerrado. */
    CERRADO;

}
