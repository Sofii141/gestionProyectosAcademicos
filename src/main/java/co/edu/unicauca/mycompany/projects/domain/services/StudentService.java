package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.IStudentRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Student;

/**
 *
 * @author paula
 */
public class StudentService {
    private IStudentRepository repository;

    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }
    
    public Student getStudent(String nit){
        return repository.getStudent(nit);
    }
}
