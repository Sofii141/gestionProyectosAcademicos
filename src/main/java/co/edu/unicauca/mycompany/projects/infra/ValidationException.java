/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.infra;

/**
 *
 * @author USUARIO
 */
public class ValidationException extends Exception {

    private final String atributoError;

    /**
     * Crea una nueva instancia de {@code ValidationException} con un mensaje de
     * error y el nombre del atributo que causó la excepción.
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
