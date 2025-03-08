/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.domain.entities;

/**
 *
 * @author paula
 */
public class Student {
    private String id;
    private String nombreStudent;
    private String correo;

    public Student(String id, String nombreStudent, String correo) {
        this.id = id;
        this.nombreStudent = nombreStudent;
        this.correo = correo;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreStudent() {
        return nombreStudent;
    }

    public void setNombreStudent(String nombreStudent) {
        this.nombreStudent = nombreStudent;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
