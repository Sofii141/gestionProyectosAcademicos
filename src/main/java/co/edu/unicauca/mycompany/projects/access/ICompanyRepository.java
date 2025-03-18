package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import java.util.List;

/**
 * Interface que define el contrato para el repositorio de compañías.
 * 
 * Proporciona métodos para guardar, listar, verificar la existencia y obtener
 * información de una compañía.
 * 
 */
public interface ICompanyRepository {
    /**
     * Guarda una nueva compañía en el repositorio.
     * 
     * @param newCompany Objeto Company con la información de la compañía a guardar.
     * @return true si la compañía se guardó con éxito, false en caso contrario.
     */
    boolean save(Company newCompany);
    
    /**
     * Obtiene una lista con todas las compañías almacenadas en el repositorio.
     * 
     * @return Lista de compañías registradas.
     */
    List<Company> listAll();


    /**
     * Obtiene la información detallada de una compañía a partir de su NIT.
     * 
     * @param nit Número de Identificación Tributaria (NIT) de la compañía.
     * @return Objeto Company con la información de la compañía, o null si no se encuentra.
     */
    Company companyInfo (String nit);
    
}
