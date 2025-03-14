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
    private List<Project> myProjects;
    private List<Project> myPostulations;
    
    public Student(String userId, String userEmail, String userPassword) {
        super(userId, userEmail, userPassword);
        this.myProjects = new ArrayList<>();
        this.myPostulations = new ArrayList<>();
    }

    public List<Project> getMyProjects() {
        return myProjects;
    }

    public void setMyProjects(List<Project> myProjects) {
        this.myProjects = myProjects;
    }

    public List<Project> getMyPostulations() {
        return myPostulations;
    }

    public void setMyPostulations(List<Project> myPostulations) {
        this.myPostulations = myPostulations;
    }

}
