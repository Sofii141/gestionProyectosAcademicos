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
    
    @Override
    public boolean existsNit(String nit){
        for (Company company: myArray){
            if (company.getNit().equals(nit)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Company companyInfo(String nit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
