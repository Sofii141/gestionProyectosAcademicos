package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.User;

/**
 * Interfaz que define las operaciones para gestionar usuarios en el sistema.
 */
public interface IUserRepository {
    
    /**
     * Inicia sesión en el sistema con las credenciales proporcionadas.
     * 
     * @param usuario Nombre de usuario o identificador.
     * @param pwd Contraseña del usuario.
     * @return Un código de estado indicando el resultado del inicio de sesión.
     */
    int iniciarSesion(String usuario, char[] pwd);
    
    /**
     * Cierra la sesión del usuario actual.
     * 
     * @return true si la sesión se cerró correctamente, false en caso contrario.
     */
    boolean cerrarSesion();
    
    /**
     * Guarda un nuevo usuario en el repositorio.
     * 
     * @param newUser Objeto User con la información del usuario a registrar.
     * @return true si el usuario se guardó con éxito, false en caso contrario.
     */
    boolean save(User newUser);
    
    /**
     * Verifica si un usuario con el ID especificado existe en el repositorio.
     * 
     * @param id Identificador del usuario.
     * @return true si el usuario existe, false en caso contrario.
     */
    boolean existId(String id);
}
