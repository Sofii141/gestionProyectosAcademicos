package co.edu.unicauca.mycompany.projects.access;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase Factory que implementa el patrón de diseño Singleton y Factory Method.
 * Proporciona una instancia única de la fábrica y permite obtener repositorios
 * para diferentes entidades como Company, Student y Project según el tipo especificado.
 * 
 */
public class Factory {
    // Instancia única de la fábrica (patrón Singleton)
    private static Factory instance;
    
    // Diccionarios que almacenan los repositorios según el tipo de almacenamiento
    private final Map<String, ICompanyRepository> companyDictionary;
    private final Map<String, IStudentRepository> StudentDictionary;
    private final Map<String, IProjectRepository> projectDictionary;

    /**
     * Constructor privado para evitar la instanciación externa.
     * Inicializa los diccionarios y registra las implementaciones disponibles.
     */
    private Factory() {
        // Diccionario para repositorios de compañías
        companyDictionary = new HashMap<>();
        companyDictionary.put("MARIADB", new CompanyMariaDBRepository()); // Agrega repositorio MariaDB
        
        // Diccionario para repositorios de estudiantes
        StudentDictionary = new HashMap<>();
        StudentDictionary.put("MARIADB", new StudentMariaDBRepository()); // Agrega repositorio MariaDB
        
        // Diccionario para repositorios de proyectos
        projectDictionary = new HashMap<>();
        projectDictionary.put("MARIADB", new ProjectMariaDBRepository()); // Agrega repositorio MariaDB
    }
    
    /**
     * Obtiene la instancia única de la fábrica (patrón Singleton).
     * 
     * @return Instancia de Factory
     */
    public static Factory getInstance() {
        // Si la instancia aún no ha sido creada crea una
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }
    
    /**
     * Obtiene el repositorio de compañías según el tipo de almacenamiento.
     * 
     * @param repository Tipo de repositorio (ej. "MARIADB").
     * @return Implementación de ICompanyRepository o null si no se encuentra.
     */
    public ICompanyRepository getRepositoryCompany(String repository) {
        ICompanyRepository result = null;
        // Verifica si el repositorio existe
        if (companyDictionary.containsKey(repository)) {
            // Obtiene la implementación correspondiente
            result = companyDictionary.get(repository);
        }
        return result;
    }
    
    /**
     * Obtiene el repositorio de estudiantes según el tipo de almacenamiento.
     * 
     * @param repository Tipo de repositorio (ej. "MARIADB").
     * @return Implementación de IStudentRepository o null si no se encuentra.
     */  
    public IStudentRepository getRepositoryStudent(String repository) {
        IStudentRepository result = null;
        // Verifica si el repositorio existe
        if (StudentDictionary.containsKey(repository)) {
            // Obtiene la implementación correspondiente
            result = StudentDictionary.get(repository);
        }
        return result;
    }
    
    /**
     * Obtiene el repositorio de proyectos según el tipo de almacenamiento.
     * 
     * @param repository Tipo de repositorio (ej. "MARIADB").
     * @return Implementación de IProjectRepository o null si no se encuentra.
     */   
    public IProjectRepository getRepositoryProject(String repository) {
        IProjectRepository result = null;
        // Verifica si el repositorio existe
        if (projectDictionary.containsKey(repository)) {
            // Obtiene la implementación correspondiente
            result = projectDictionary.get(repository);
        }
        return result;
    }
}
