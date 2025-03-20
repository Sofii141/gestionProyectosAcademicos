package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;

/**
 * Servicio para la gestión de empresas en el sistema. Proporciona métodos para
 * obtener, guardar y validar empresas.
 */
public class CompanyService {

    /**
     * Validador de los datos de las empresas.
     */
    private IValidation validator;

    /**
     * Repositorio que maneja las operaciones de acceso a datos de empresas.
     */
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
     * Obtiene la información de una empresa específica mediante su NIT.
     *
     * @param nit Número de Identificación Tributaria de la empresa.
     * @return Objeto Company con la información de la empresa, o null si no se
     * encuentra.
     */
    public Company getCompany(String nit) {
        return repository.companyInfo(nit);
    }

    /**
     * Guarda una nueva empresa en el sistema.
     *
     * @param newCompany Objeto Company con la información de la empresa a
     * registrar.
     * @return true si la empresa fue guardada correctamente, false en caso
     * contrario.
     */
    public boolean saveCompany(Company newCompany) {
        return repository.save(newCompany);
    }

    /**
     * Valida los datos de una empresa utilizando la clase
     * DataValidationCompany.
     *
     * @param newCompany La empresa cuyos datos se desean validar.
     * @return true si los datos de la empresa son válidos, false en caso
     * contrario.
     * @throws Exception Si ocurre un error durante la validación.
     */
    public boolean validData(Company newCompany) throws Exception {
        validator = new DataValidationCompany(newCompany);
        return validator.isValid();
    }

}
