package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import java.sql.Connection;
import java.util.List;

/**
 * Implementación del repositorio con Sqlite
 *
 */
public class CompanySqliteRepository implements ICompanyRepository {

    private Connection conn;

    @Override
    public boolean save(Company newCompany) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Company> listAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean existsNit(String nit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Company companyInfo(String nit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
