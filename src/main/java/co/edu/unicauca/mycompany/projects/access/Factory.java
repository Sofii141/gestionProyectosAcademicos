package co.edu.unicauca.mycompany.projects.access;

import java.util.HashMap;
import java.util.Map;

/**
 * Fabrica que se encarga de instanciar una interfaz de repositorio que necesitemos para
 * un servicio, por ejemplo para el login IUserRepository
 *
 * @author Libardo, Julio
 */
public class Factory {

    /**
     * Singleton
     */
    private static Factory instance;

    private Map<String, Map<Class<?>, Object>> dictionary;

    private Factory() {
        dictionary = new HashMap<>();

        // Repositorios de MariaDB
        Map<Class<?>, Object> mariaDBRepos = new HashMap<>();
        mariaDBRepos.put(IProjectRepository.class, new ProjectMariaDBRepository());
        mariaDBRepos.put(IUserRepository.class, new UserMariaDBRepository());

        // Otros repositorios
        //...
        

        // Agregar los repositorios a la fábrica
        dictionary.put("MARIADB", mariaDBRepos);
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
     * Método que crea una instancia concreta de la jerarquia de repositorios
     *
     * @param <T> Tipos de repositorios
     * @param dbType cadena que indica a qué tipo de mapa de repositorios queremos acceder para un repositorio, osea el tipo de base de datos
     * @param repoType indica el repositorio que queremos recuperar
     * @return una clase hija de la abstracción IProductRepository
     */
    public <T> T getRepository(String dbType, Class<T> repoType) {
        if (dictionary.containsKey(dbType) && dictionary.get(dbType).containsKey(repoType)) {
            return (T) dictionary.get(dbType).get(repoType);
        }
        throw new IllegalArgumentException("No repository found for " + dbType + " and type " + repoType.getSimpleName());
    }
}
