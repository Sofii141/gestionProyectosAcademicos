package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.IUserRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.User;

/**
 * Servicio que se encarga inicialmente de iniciar sesion y cerrarla
 * @author spart
 */
public class UserService {
    private IUserRepository  repository;
    public UserService(IUserRepository prmRepo){
        repository = prmRepo;
    }
    /**
     * Se encarga de llamar al iniciar sesion del repositorio mandandole como instancia el usuario
     * @param prmUserName Nombre de usuario
     * @param prmPassword Contraseña
     * @return el exito de la operacion con enteros segun el repositorio
     */
    public int iniciarSesion(String prmUserName, char[] prmPassword){
        String str_password = new String(prmPassword); 
        return repository.iniciarSesion(prmUserName, prmPassword);
    }
    /**
     * Guarda un nuevo user en el sistema.
     * 
     * @param newUser Objeto User con la información del user a registrar.
     * @return true si el user fue guardado correctamente, false en caso contrario.
     */
    public boolean saveUser(User newUser) {
        return repository.save(newUser);
    }
    
}
