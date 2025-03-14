package co.edu.unicauca.mycompany.projects.access;

import java.util.HashMap;
import java.util.Map;

public class Factory {

    private static Factory instance;

    private Map<String, ICompanyRepository> companyDictionary;
    private Map<String, IStudentRepository> StudentDictionary;
    private Map<String, IProjectRepository> projectDictionary;

    private Factory() {
        companyDictionary = new HashMap<>();
        companyDictionary.put("MARIADB", new CompanyMariaDBRepository());
        
        StudentDictionary = new HashMap<>();
        StudentDictionary.put("MARIADB", new StudentMariaDBRepository());
        
        projectDictionary = new HashMap<>();
        projectDictionary.put("MARIADB", new ProjectMariaDBRepository());
    }

    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    public ICompanyRepository getRepositoryCompany(String repository) {
        ICompanyRepository result = null;
        if (companyDictionary.containsKey(repository)) {
            result = companyDictionary.get(repository);
        }
        return result;

    }
    
    public IStudentRepository getRepositoryStudent(String repository) {
        IStudentRepository result = null;
        if (StudentDictionary.containsKey(repository)) {
            result = StudentDictionary.get(repository);
        }
        return result;

    }
    
    public IProjectRepository getRepositoryProject(String repository) {
        IProjectRepository result = null;
        if (projectDictionary.containsKey(repository)) {
            result = projectDictionary.get(repository);
        }
        return result;
    }
}
