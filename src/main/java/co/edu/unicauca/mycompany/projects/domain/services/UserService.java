package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.IUserRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.User;

/**
 * Servicio encargado de la gestión de usuarios, incluyendo el inicio y cierre de sesión.
 */
public class UserService {

    /** Validador de los datos de los usuarios. */
    private IValidation validator;

    /** Repositorio que maneja las operaciones de acceso a datos de los usuarios. */
    private IUserRepository repository;

    /**
     * Constructor de la clase UserService.
     * 
     * @param prmRepo Repositorio de usuarios que manejará las operaciones de acceso a datos.
     */
    public UserService(IUserRepository prmRepo) {
        repository = prmRepo;
    }

    /**
     * Inicia sesión en el sistema verificando las credenciales del usuario.
     * 
     * @param prmUserName Nombre de usuario ingresado.
     * @param prmPassword Contraseña ingresada como un array de caracteres.
     * @return Un código de estado que indica el resultado del intento de inicio de sesión.
     */
    public int iniciarSesion(String prmUserName, char[] prmPassword) {
        String str_password = new String(prmPassword);
        return repository.iniciarSesion(prmUserName,prmPassword);
    }

    /**
     * Guarda un nuevo user en el sistema.
     *
     * @param newUser Objeto User con la información del user a registrar.
     * @return true si el user fue guardado correctamente, false en caso
     * contrario.
     */
    public boolean saveUser(User newUser) {
        return repository.save(newUser);
    }

    /**
     * Verifica si un usuario con el ID especificado ya existe en la base de
     * datos.
     *
     * @param userId El identificador único del usuario a verificar.
     * @return true si el ID del usuario ya existe en el repositorio, false en
     * caso contrario.
     */
    public boolean existUserId(String userId) {
        return repository.existId(userId);
    }

    /**
     * Valida los datos de un usuario utilizando la clase DataValidationUser.
     *
     * @param newUser El usuario cuyos datos se desean validar.
     * @return true si los datos del usuario son válidos, false en caso
     * contrario.
     * @throws Exception Si ocurre un error durante la validación.
     */
    public boolean validData(User newUser) throws Exception {
        validator = new DataValidationUser(newUser);
        return validator.isValid();
    }

}
