package co.edu.unicauca.mycompany.projects.access;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase Factory que implementa el patrón de diseño Singleton y Factory Method.
 * Proporciona una instancia única de la fábrica y permite obtener repositorios
 * para diferentes entidades como Company, Student, Project, Coordinator y User
 * según el tipo especificado.
 */
public class Factory {
    
    /**
     * Instancia única de la fábrica (patrón Singleton).
     */
    private static Factory instance;
    
    /**
     * Diccionario que almacena los repositorios de compañías según el tipo de almacenamiento.
     */
    private final Map<String, ICompanyRepository> companyDictionary;
    
    /**
     * Diccionario que almacena los repositorios de estudiantes según el tipo de almacenamiento.
     */
    private final Map<String, IStudentRepository> studentDictionary;
    
    /**
     * Diccionario que almacena los repositorios de proyectos según el tipo de almacenamiento.
     */
    private final Map<String, IProjectRepository> projectDictionary;
    
    /**
     * Diccionario que almacena los repositorios de coordinadores según el tipo de almacenamiento.
     */
    private final Map<String, ICoordinatorRepository> coordinatorDictionary;
    
    /**
     * Diccionario que almacena los repositorios de usuarios según el tipo de almacenamiento.
     */
    private final Map<String, IUserRepository> userDictionary;
    
    /**
     * Constructor privado para evitar la instanciación externa.
     * Inicializa los diccionarios y registra las implementaciones disponibles.
     */
    private Factory() {
        // Diccionario para repositorios de compañías
        companyDictionary = new HashMap<>();
        companyDictionary.put("MARIADB", new CompanyMariaDBRepository()); // Agrega repositorio MariaDB
        
        // Diccionario para repositorios de estudiantes
        studentDictionary = new HashMap<>();
        studentDictionary.put("MARIADB", new StudentMariaDBRepository()); // Agrega repositorio MariaDB
        
        // Diccionario para repositorios de proyectos
        projectDictionary = new HashMap<>();
        projectDictionary.put("MARIADB", new ProjectMariaDBRepository()); // Agrega repositorio MariaDB
        
        coordinatorDictionary = new HashMap<>();
        coordinatorDictionary.put("MARIADB", new CoordinatorMariaDBRepository()); // Agrega repositorio MariaDB
        
        userDictionary = new HashMap<>();
        userDictionary.put("MARIADB", new UserMariaDBRepository()); // Agrega repositorio MariaDB
    }
    
    /**
     * Obtiene la instancia única de la fábrica (patrón Singleton).
     * 
     * @return Instancia de Factory.
     */
    public static Factory getInstance() {
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
        return companyDictionary.getOrDefault(repository, null);
    }
    
    /**
     * Obtiene el repositorio de estudiantes según el tipo de almacenamiento.
     * 
     * @param repository Tipo de repositorio (ej. "MARIADB").
     * @return Implementación de IStudentRepository o null si no se encuentra.
     */  
    public IStudentRepository getRepositoryStudent(String repository) {
        return studentDictionary.getOrDefault(repository, null);
    }
    
    /**
     * Obtiene el repositorio de proyectos según el tipo de almacenamiento.
     * 
     * @param repository Tipo de repositorio (ej. "MARIADB").
     * @return Implementación de IProjectRepository o null si no se encuentra.
     */   
    public IProjectRepository getRepositoryProject(String repository) {
        return projectDictionary.getOrDefault(repository, null);
    }
    
    /**
     * Obtiene el repositorio de coordinadores según el tipo de almacenamiento.
     * 
     * @param repository Tipo de repositorio (ej. "MARIADB").
     * @return Implementación de ICoordinatorRepository o null si no se encuentra.
     */  
    public ICoordinatorRepository getRepositoryCoordinator(String repository) {
        return coordinatorDictionary.getOrDefault(repository, null);
    }
    
    /**
     * Obtiene el repositorio de usuarios según el tipo de almacenamiento.
     * 
     * @param repository Tipo de repositorio (ej. "MARIADB").
     * @return Implementación de IUserRepository o null si no se encuentra.
     */  
    public IUserRepository getRepositoryUser(String repository) {
        return userDictionary.getOrDefault(repository, null);
    }
}
