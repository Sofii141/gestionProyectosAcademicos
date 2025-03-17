package co.edu.unicauca.mycompany.projects.domain.entities;

/**
 * Enumeración que representa los diferentes sectores en los que puede operar una empresa.
 */
public enum Sector {
    /** Sector tecnológico. */
    TECHNOLOGY,

    /** Sector de la salud. */
    HEALTH,

    /** Sector educativo. */
    EDUCATION,

    /** Sector de servicios. */
    SERVICES,

    /** Sector no especificado u otro. */
    OTHER;

    /**
     * Convierte una cadena de texto en un valor de la enumeración Sector.
     * Si la cadena no coincide con ninguno de los valores existentes, devuelve OTHER.
     * 
     * @param secName Cadena de texto que representa el sector.
     * @return El sector correspondiente de la enumeración Sector o OTHER si no es válido.
     */
    public static Sector fromString(String secName) {
        try {
            return Sector.valueOf(secName.toUpperCase());
        } catch (IllegalArgumentException e) {
            return OTHER;
        }
    }
}
