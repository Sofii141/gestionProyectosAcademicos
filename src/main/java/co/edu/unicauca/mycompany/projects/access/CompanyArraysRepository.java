package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Sector;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del repositorio con Arreglos
 *
 * @author Libardo, Julio
 */
public class CompanyArraysRepository implements ICompanyRepository {

    public static List<Company> myArray;

    public CompanyArraysRepository() {
        myArray = new ArrayList<>();
        myArray.add(new Company("012-12-22", "Lacteos Popayan", "313234123", "www.lacteospopayan.com", Sector.SERVICES, "gerentelacteos@gmail.com", "123"));
        myArray.add(new Company("323-12-56", "Electromillonaria", "314334334", "www.electromillonaria.com", Sector.TECHNOLOGY, "electromillonaria@gmail.com", "123"));
        myArray.add(new Company("867-223-444", "S&P", "3142342344", "www.SP.com", Sector.TECHNOLOGY, "syp@gmail.com", "123"));
        myArray.add(new Company("456-1222-2233", "Solutions", "311454789", "www.solutions.com", Sector.HEALTH, "solutions@gmail.com", "123"));

    }

    @Override
    public boolean save(Company newCompany) {
        if (!existsNit(newCompany.getNit())){
            myArray.add(newCompany);
            return true;
        }
        return false;
    }

    @Override
    public List<Company> listAll() {
        return myArray;
    }
    
    private boolean existsNit(String nit){
        for (Company company: myArray){
            if (company.getNit().equals(nit)){
                return true;
            }
        }
        return false;
    }

}
