package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.IProjectRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.infra.Messages;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paula
 */
public class ProjectService{
    
    private IProjectRepository repository;
    private List<Observer> observers;

    public ProjectService(IProjectRepository repository) {
        this.repository = repository;
        this.observers = new ArrayList<>();
    }

    public List<Project> listProjects(){
        return repository.listAll();
    }
    
    public List<Project> projectsAvailable(String studentId){
        return repository.listProjectsAvailable(studentId);
    }
    
    public Project getProject(String nit){
        return repository.getProject(nit);
    }
    
    public void applyStudent(String studentId, String projectId){
        if (repository.apply(studentId, projectId)){
            Messages.mensajeVario("Postulación enviada al proyect: "+projectId);
        }
        else{
            Messages.showErrorDialog("No se pudo enviar la solicitud","Error");
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
    public List<Integer> dataGraphicStudent(String studentId){
        return repository.countProjectsStudent(studentId);
    }

    public void notifyObserversApply() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    
}
