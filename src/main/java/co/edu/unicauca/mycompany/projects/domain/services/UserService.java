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
    
    public boolean iniciarSesion(String prmUserName, char[] prmPassword){
        User newUser = new User(prmUserName, prmPassword);
        return repository.iniciarSesion(newUser);
    }
    
}
