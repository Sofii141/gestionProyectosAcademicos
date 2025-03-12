/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.domain.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paula
 */
public class Student extends User{
    
    private List<Project> misproyectos;
    private List<Project> postulaciones;
    
    public Student(String userId, String userEmail, String userPassword) {
        super(userId, userEmail, userPassword);
        this.misproyectos = new ArrayList<>();
        this.postulaciones = new ArrayList<>();
    }

    public List<Project> getMisproyectos() {
        return misproyectos;
    }

    public void setMisproyectos(List<Project> misproyectos) {
        this.misproyectos = misproyectos;
    }

    public List<Project> getPostulaciones() {
        return postulaciones;
    }

    public void setPostulaciones(List<Project> postulaciones) {
        this.postulaciones = postulaciones;
    }

}
