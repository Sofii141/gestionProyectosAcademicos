package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import java.util.List;

/**
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class CompanyService {

    private ICompanyRepository repository;

    public CompanyService(ICompanyRepository repository) {
        this.repository = repository;
    }

    public List<Company> getAllCompanies() {
        return repository.listAll();
    }

    public boolean saveCompany(Company newCompany) {
        return repository.save(newCompany);
    }
        /**
     * Valida que el email ingresado cumpla las reglas de negocio
     * 
     * @param email String ingresado por el usuario
     * @return true si la cadena cumple la expresion regular, false en caso contrario.
     */
    public boolean esEmailValido(String email) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }
     /**
     * Valida que la contraseña cumpla las reglas de negocio
     * 
     * @param password String ingresado por el usuario
     * @return true si la cadena cumple la expresion regular, false en caso contrario.
     */
    public boolean existsNit(String nit) {
        return repository.existsNit(nit);
    }
}
