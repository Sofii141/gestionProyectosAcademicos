/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.IProjectRepository;
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
    
    public int iniciarSesion(String prmUserName, char[] prmPassword){
        String str_password = new String(prmPassword);
        User newUser = new User(prmUserName, str_password);
        return repository.iniciarSesion(newUser);
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
