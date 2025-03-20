package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.IUserRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.User;

/**
 * Servicio que se encarga inicialmente de iniciar sesion y cerrarla
 *
 * @author spart
 */
public class UserService {

    /**
     * Validador de los datos de los users.
     */
    private IValidation validator;
    /**
     * Repositorio que maneja las operaciones de acceso a datos de users.
     */
    private IUserRepository repository;

    public UserService(IUserRepository prmRepo) {
        repository = prmRepo;
    }


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
