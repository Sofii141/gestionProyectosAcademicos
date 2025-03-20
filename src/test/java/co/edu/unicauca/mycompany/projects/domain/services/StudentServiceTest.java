package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.IStudentRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 * Pruebas unitarias para la clase StudentService.
 */
public class StudentServiceTest {

    @Mock
    private IStudentRepository repositoryMock;

    /** Instancia del servicio que se probará. */
    private StudentService studentService;

    /**
     * Configuración inicial antes de cada prueba.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        studentService = new StudentService(repositoryMock);
    }

    /**
     * Prueba el método getStudent cuando el estudiante existe.
     */
    @Test
    void testGetStudentExists() {
        Student student = mock(Student.class);
        when(repositoryMock.getStudent("12345")).thenReturn(student);

        Student result = studentService.getStudent("12345");

        assertNotNull(result);
        verify(repositoryMock, times(1)).getStudent("12345");
    }

    /**
     * Prueba el método getStudent cuando el estudiante no existe.
     */
    @Test
    void testGetStudentNotExists() {
        when(repositoryMock.getStudent("99999")).thenReturn(null);

        Student result = studentService.getStudent("99999");

        assertNull(result);
        verify(repositoryMock, times(1)).getStudent("99999");
    }

    /**
     * Prueba el método getStudent con un NIT nulo.
     */
    @Test
    void testGetStudentWithNullNit() {
        Student result = studentService.getStudent(null);

        assertNull(result);
        verify(repositoryMock, never()).getStudent(anyString());
    }
}