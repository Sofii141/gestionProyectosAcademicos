package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.domain.entities.User;
import co.edu.unicauca.mycompany.projects.infra.ValidationException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Pruebas unitarias para la clase DataValidationUser.
 */
public class DataValidationUserTest {

    /**
     * Test para verificar que un usuario válido pasa la validación.
     */
    @Test
    public void testValidUser() throws ValidationException {
        User validUser = new User("123456789", "user@example.com", "Secure@1");
        DataValidationUser validator = new DataValidationUser(validUser);
        assertTrue(validator.isValid(), "El usuario válido debería pasar la validación");
    }

    /**
     * Test para verificar que se lanza una excepción si el ID del usuario es nulo o vacío.
     */
    @Test
    public void testInvalidUserId() {
        User invalidUser = new User("", "user@example.com", "Secure@1");
        DataValidationUser validator = new DataValidationUser(invalidUser);
        Exception exception = assertThrows(ValidationException.class, validator::isValid);
        assertEquals("El NIT es obligatorio", exception.getMessage());
    }

    /**
     * Test para verificar que se lanza una excepción si el ID del usuario contiene caracteres no numéricos.
     */
    @Test
    public void testNonNumericUserId() {
        User invalidUser = new User("ABC123", "user@example.com", "Secure@1");
        DataValidationUser validator = new DataValidationUser(invalidUser);
        Exception exception = assertThrows(ValidationException.class, validator::isValid);
        assertEquals("El NIT debe contener solo números", exception.getMessage());
    }

    /**
     * Test para verificar que se lanza una excepción si el email no es válido.
     */
    @Test
    public void testInvalidEmail() {
        User invalidUser = new User("123456789", "invalid-email", "Secure@1");
        DataValidationUser validator = new DataValidationUser(invalidUser);
        Exception exception = assertThrows(ValidationException.class, validator::isValid);
        assertEquals("El correo no es válido", exception.getMessage());
    }

    /**
     * Test para verificar que se lanza una excepción si la contraseña no cumple con los requisitos.
     */
    @Test
    public void testInvalidPassword() {
        User invalidUser = new User("123456789", "user@example.com", "weak");
        DataValidationUser validator = new DataValidationUser(invalidUser);
        Exception exception = assertThrows(ValidationException.class, validator::isValid);
        assertEquals("La contraseña debe tener al menos 6 caracteres, una mayúscula y un carácter especial.", exception.getMessage());
    }
}