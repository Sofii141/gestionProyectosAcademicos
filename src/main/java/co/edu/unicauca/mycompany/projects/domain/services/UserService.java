package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Student;

/**
 *
 * @author paula
 */
public class UserService {
    private ICompanyRepository repository;

    public UserService(ICompanyRepository repository) {
        this.repository = repository;
    }
}
