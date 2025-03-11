/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.domain.entities;

/**
 * entidad Usuario
 * @author spart
 */
public class User {
    private String nombre;
    private char[] password; //Se usa char[] por cuestiones de seguridad en el jPasswordField de Swing
    private String id;
    private String email;

    /**
     * constructor vacio
     */
    public User() {
    }
    /**
     * constructor de usuario para inicio de sesion
     * @param nombre
     * @param password 
     */
    public User(String nombre, char[] password) {
        this.nombre = nombre;
        this.password = password;
    }
    /**
     * Constructor parametrizado
     * @param nombre
     * @param password
     * @param id
     * @param email 
     */
    public User(String nombre, char[] password, String id, String email) {
        this.nombre = nombre;
        this.password = password;
        this.id = id;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
