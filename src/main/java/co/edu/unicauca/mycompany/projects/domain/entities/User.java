package co.edu.unicauca.mycompany.projects.domain.entities;

/**
 * Clase que representa un usuario en el sistema.
 * Un usuario tiene un identificador, un correo electrónico y una contraseña.
 */
public class User {
    
    // Identificador único del usuario.
    private String userId;
    
    // Correo electrónico del usuario.
    private String userEmail;
    
    // Contraseña del usuario.
    private String userPassword;

    /**
     * Constructor de la clase User.
     * 
     * @param userId Identificador único del usuario.
     * @param userEmail Correo electrónico del usuario.
     * @param userPassword Contraseña del usuario.
     */
    public User(String userId, String userEmail, String userPassword) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
    
    /**
     * Obtiene el identificador del usuario.
     * 
     * @return Identificador único del usuario.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Establece el identificador del usuario.
     * 
     * @param userId Nuevo identificador del usuario.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * 
     * @return Correo electrónico del usuario.
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Establece el correo electrónico del usuario.
     * 
     * @param userEmail Nuevo correo electrónico del usuario.
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return Contraseña del usuario.
     */
    public String getUserPassword() {
        return userPassword;
    }
    
    /**
     * Establece la contraseña del usuario.
     * 
     * @param userPassword Nueva contraseña del usuario.
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
