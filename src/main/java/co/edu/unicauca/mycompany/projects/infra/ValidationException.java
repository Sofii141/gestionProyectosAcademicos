package co.edu.unicauca.mycompany.projects.infra;

/**
 * Excepción personalizada utilizada para representar errores de validación en el sistema.
 * 
 * Esta excepción se lanza cuando un atributo no cumple con los criterios de validación 
 * definidos en la aplicación.
 */
public class ValidationException extends Exception {

    /** Nombre del atributo que no pasó la validación. */
    private final String atributoError;

    /**
     * Crea una nueva instancia de {@code ValidationException} con un mensaje de error
     * y el nombre del atributo que causó la excepción.
     *
     * @param msg Mensaje detallado del error.
     * @param atributoError Nombre del atributo que no pasó la validación.
     */
    public ValidationException(String msg, String atributoError) {
        super(msg);
        this.atributoError = atributoError;
    }

    /**
     * Obtiene el nombre del atributo que causó la excepción.
     *
     * @return Nombre del atributo con error.
     */
    public String getAtributoError() {
        return atributoError;
    }
}