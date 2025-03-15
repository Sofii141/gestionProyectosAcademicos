package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import java.util.List;

/**
 * Servicio para la gestión de empresas en el sistema.
 * Proporciona métodos para obtener, guardar y validar empresas.
 */
public class CompanyService {

    /** Repositorio que maneja las operaciones de acceso a datos de empresas. */
    private ICompanyRepository repository;

    /**
     * Constructor de la clase CompanyService.
     * 
     * @param repository Implementación del repositorio de empresas.
     */
    public CompanyService(ICompanyRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtiene la lista de todas las empresas registradas en el sistema.
     * 
     * @return Lista de objetos Company.
     */
    public List<Company> getAllCompanies() {
        return repository.listAll();
    }

    /**
     * Obtiene la información de una empresa específica mediante su NIT.
     * 
     * @param nit Número de Identificación Tributaria de la empresa.
     * @return Objeto Company con la información de la empresa, o null si no se encuentra.
     */
    public Company getCompany(String nit) {
        return repository.companyInfo(nit);
    }

    /**
     * Guarda una nueva empresa en el sistema.
     * 
     * @param newCompany Objeto Company con la información de la empresa a registrar.
     * @return true si la empresa fue guardada correctamente, false en caso contrario.
     */
    public boolean saveCompany(Company newCompany) {
        return repository.save(newCompany);
    }

    /**
     * Valida que el email ingresado cumpla las reglas de negocio.
     * 
     * @param email Dirección de correo electrónico a validar.
     * @return true si la cadena cumple la expresión regular, false en caso contrario.
     */
    public boolean esEmailValido(String email) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }

    /**
     * Valida que la contraseña cumpla las reglas de negocio
     * 
     * @param nit
     * @return true si la cadena cumple la expresion regular, false en caso contrario.
     */
    public boolean existsNit(String nit) {
        return repository.existsNit(nit);
    }
}
