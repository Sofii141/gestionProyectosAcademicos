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

    /**
     * Convierte una cadena de texto en un valor de la enumeración ProjectState.
     * 
     * @param state Cadena de texto que representa el estado del proyecto.
     * @return El estado correspondiente de la enumeración ProjectState.
     * @throws IllegalArgumentException Si el estado proporcionado no es válido.
     */
    public static enumProjectState fromString(String state) {
        try {
            return enumProjectState.valueOf(state.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Estado de proyecto inválido: " + state);
        }
    }
}
