package co.edu.unicauca.mycompany.projects.domain.entities;

/**
 *
 * @author Libardo, Julio
 */
public enum Sector {
    TECHNOLOGY, HEALTH, EDUCATION, SERVICES, OTHER;
    
    public static Sector fromString(String secName) {
        try {
            return Sector.valueOf(secName.toUpperCase());
        } catch (IllegalArgumentException e) {
            return OTHER;
        }
    }
}
