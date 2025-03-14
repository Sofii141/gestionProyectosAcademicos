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
public class Coordinator extends User{
    private List<Project> coordProjects;

    public Coordinator(String userId, String userEmail, String userPassword) {
        super(userId, userEmail, userPassword);
        this.coordProjects = new ArrayList<>();
    }

    public List<Project> getCoordProjects() {
        return coordProjects;
    }

    public void setCoordProjects(List<Project> coordProjects) {
        this.coordProjects = coordProjects;
    }

}
