/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.User;

/**
 *
 * @author spart
 */
public class UserMariaDBRepository extends MariaDBConnection implements IUserRepository{

    public UserMariaDBRepository() {
    }

    @Override
    public boolean iniciarSesion(User user) {
        return connect();
    }

    @Override
    public boolean cerrarSesion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
