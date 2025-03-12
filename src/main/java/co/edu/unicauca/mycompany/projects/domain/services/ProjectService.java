/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.domain.services;
import co.edu.unicauca.mycompany.projects.access.CompanyArraysRepository;
import co.edu.unicauca.mycompany.projects.access.CompanyMariaDBRepository;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.access.IProjectRepository;
import co.edu.unicauca.mycompany.projects.access.ProjectMariaDBRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paula
 */
public class ProjectService {
    
    private IProjectRepository repository;
    private List<Observer> observers; // lista de observadores

    public ProjectService() {
        this.repository = new ProjectMariaDBRepository();
        this.observers = new ArrayList<>();
    }
/*
    // Agregar un observador a la lista
    public void agregarObservador(Observer observador) {
        observadores.add(observador);
    }

    // Eliminar un observador de la lista
    public void eliminarObservador(Observer observador) {
        observadores.remove(observador);
    }

    // Notificar a todos los observadores sobre un cambio
    public void cambiarEstadoProyecto() {
        for (Observer observador : observadores) {
            observador.cambiarEstado();
        }
    }
*/    
    public List<Project> listProjects(){
        return repository.listAll();
    }
    
    public Project getProject(String nit){
        return repository.getProject(nit);
    }
}
