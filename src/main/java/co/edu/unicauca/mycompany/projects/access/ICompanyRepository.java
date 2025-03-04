
package co.edu.unicauca.mycompany.projects.access;


import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import java.util.List;

/**
 *
 * @author Libardo, Julio
 */
public interface ICompanyRepository {
    boolean save(Company newCompany);

    List<Company> listAll();
}
