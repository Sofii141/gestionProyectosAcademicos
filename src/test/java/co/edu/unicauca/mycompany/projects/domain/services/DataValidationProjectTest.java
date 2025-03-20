package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.infra.ValidationException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase DataValidationProject.
 */
public class DataValidationProjectTest {
    
    private Project validProject;
    
    @BeforeEach
    public void setUp() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date validDate = sdf.parse("10/03/2025");
        
        validProject = new Project("P001", "Proyecto Test", "Descripción válida", 
                                   "Resumen válido", "Objetivos válidos", 12, validDate, 
                                   50000.0, "C123");
    }

    /**
     * Test para verificar que un proyecto válido pasa la validación sin excepciones.
     */
    @Test
    public void testValidProject() throws Exception {
        DataValidationProject validation = new DataValidationProject(validProject);
        assertTrue(validation.isValid(), "El proyecto válido debería pasar la validación");
    }

    /**
     * Test para verificar que se lanza una excepción si el ID del proyecto es nulo o vacío.
     */
    @Test
    public void testInvalidProjectId() {
        validProject.setProId("");
        DataValidationProject validation = new DataValidationProject(validProject);
        Exception exception = assertThrows(ValidationException.class, validation::isValid);
        assertEquals("El ID del proyecto es obligatorio", exception.getMessage());
    }

    /**
     * Test para verificar que se lanza una excepción si el título no cumple con las reglas.
     */
    @Test
    public void testInvalidTitle() {
        validProject.setProTitle("12345");
        DataValidationProject validation = new DataValidationProject(validProject);
        Exception exception = assertThrows(ValidationException.class, validation::isValid);
        assertEquals("El título del proyecto debe contener solo letras", exception.getMessage());
    }
    
    /**
     * Test para verificar que el presupuesto no sea negativo.
     */
    @Test
    public void testNegativeBudget() {
        validProject.setProBudget(-10000.0);
        DataValidationProject validation = new DataValidationProject(validProject);
        Exception exception = assertThrows(ValidationException.class, validation::isValid);
        assertEquals("El presupuesto del proyecto debe ser un número positivo", exception.getMessage());
    }
    
    /**
     * Test para verificar que el plazo del proyecto sea mayor a 0 y dentro del rango permitido.
     */
    @Test
    public void testInvalidProjectDeadLine() {
        validProject.setProDeadLine(0);
        DataValidationProject validation = new DataValidationProject(validProject);
        Exception exception = assertThrows(ValidationException.class, validation::isValid);
        assertEquals("El plazo del proyecto debe ser mayor  a 0", exception.getMessage());
    }
}