package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.enumSector;
import co.edu.unicauca.mycompany.projects.infra.ValidationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase DataValidationCompany.
 */
public class DataValidationCompanyTest {
    
    private DataValidationCompany validator;
    
    @BeforeEach
    void setUp() {
        Company validCompany = new Company("Empresa", "ContactoNombre", "ContactoApellido",
                "3121234567", "ContactoCargo", enumSector.OTHER,
                "123", "prueba@gmail.com", "Pass_word1");
        validator = new DataValidationCompany(validCompany);
    }
    
    /**
     * Prueba para validar datos correctos.
     */
    @Test
    void testValidCompany() throws ValidationException {
        assertTrue(validator.isValid());
    }
    
    /**
     * Prueba para verificar que se lanza una excepción cuando el nombre de la empresa está vacío.
     */
    @Test
    void testEmptyCompanyName() {
        validator.setCompany(new Company("", "ContactoNombre", "ContactoApellido", "3121234567", "ContactoCargo", enumSector.OTHER, "123", "prueba@gmail.com", "Pass_word1"));
        Exception exception = assertThrows(ValidationException.class, validator::isValid);
        assertEquals("El nombre de la empresa es obligatorio", exception.getMessage());
    }
    
    /**
     * Prueba para verificar que se lanza una excepción cuando el teléfono no tiene 10 dígitos.
     */
    @Test
    void testInvalidPhoneNumber() {
        validator.setCompany(new Company("Empresa", "ContactoNombre", "ContactoApellido", "12345", "ContactoCargo", enumSector.OTHER, "123", "prueba@gmail.com", "Pass_word1"));
        Exception exception = assertThrows(ValidationException.class, validator::isValid);
        assertEquals("El teléfono debe contener exactamente 10 dígitos", exception.getMessage());
    }
    
    /**
     * Prueba para verificar que se lanza una excepción cuando el teléfono contiene todos los dígitos iguales.
     */
    @Test
    void testPhoneWithRepeatedDigits() {
        validator.setCompany(new Company("Empresa", "ContactoNombre", "ContactoApellido", "1111111111", "ContactoCargo", enumSector.OTHER, "123", "prueba@gmail.com", "Pass_word1"));
        Exception exception = assertThrows(ValidationException.class, validator::isValid);
        assertEquals("El teléfono no debe contener números repetidos 10 veces", exception.getMessage());
    }
    
    /**
     * Prueba para verificar que se lanza una excepción cuando el nombre del contacto contiene números.
     */
    @Test
    void testInvalidContactName() {
        validator.setCompany(new Company("Empresa", "Contacto123", "ContactoApellido", "3121234567", "ContactoCargo", enumSector.OTHER, "123", "prueba@gmail.com", "Pass_word1"));
        Exception exception = assertThrows(ValidationException.class, validator::isValid);
        assertEquals("El nombre del contacto solo debe contener solo letras", exception.getMessage());
    }
    
    /**
     * Prueba para verificar que se lanza una excepción cuando el cargo del contacto contiene números.
     */
    @Test
    void testInvalidContactPosition() {
        validator.setCompany(new Company("Empresa", "ContactoNombre", "ContactoApellido", "3121234567", "Cargo123", enumSector.OTHER, "123", "prueba@gmail.com", "Pass_word1"));
        Exception exception = assertThrows(ValidationException.class, validator::isValid);
        assertEquals("El cargo del contacto solo debe contener solo letras", exception.getMessage());
    }
}