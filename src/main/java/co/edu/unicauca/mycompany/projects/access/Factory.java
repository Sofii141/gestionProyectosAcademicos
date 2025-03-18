package co.edu.unicauca.mycompany.projects.access;

import java.util.HashMap;
import java.util.Map;

/**
 * Fabrica que se encarga de instanciar ProductRepository o cualquier otro que
 * se cree en el futuro.
 *
 * @author Libardo, Julio
 */
public class Factory {

    /**
     * Singleton
     */
    private static Factory instance;

    private Map<String, IProjectRepository> projectDictionary;

    private Factory() {
        projectDictionary = new HashMap<>();
        projectDictionary.put("MARIADB", new ProjectMariaDBRepository());
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia ICompanyRepository
     *
     * @param repository cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IProductRepository
     */
    public IProjectRepository getRepository(String repository) {

        IProjectRepository result = null;

        if (projectDictionary.containsKey(repository)) {
            result = projectDictionary.get(repository);
        }

        return result;

    }
}
