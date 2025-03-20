package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;

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
     * Obtiene la información detallada de una compañía a partir de su NIT.
     * 
     * @param nit Número de Identificación Tributaria (NIT) de la compañía.
     * @return Objeto Company con la información de la compañía, o null si no se encuentra.
     */
    Company companyInfo (String nit);
    
    /**
     * Obtiene el identificador único de un sector según su nombre.
     *
     * @param sectorName Nombre del sector a buscar.
     * @return Identificador único del sector si existe, de lo contrario retorna null.
     */
    String getSectorIdByName(String sectorName);
}
