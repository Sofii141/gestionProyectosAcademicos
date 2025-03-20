package co.edu.unicauca.mycompany.projects.domain.entities;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

/**
 * Pruebas unitarias para la clase Student.
 */
public class StudentTest {
    
    private Student student;

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        student = new Student("S001", "student@email.com", "password123");
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test para verificar que la lista de proyectos activos es inicializada correctamente.
     */
    @Test
    public void testGetMyProjects() {
        assertNotNull(student.getMyProjects(), "La lista de proyectos no debería ser null");
        assertEquals(0, student.getMyProjects().size(), "La lista de proyectos debería estar vacía al inicio");
    }

    /**
     * Test para verificar la asignación de una nueva lista de proyectos activos.
     */
    @Test
    public void testSetMyProjects() {
        List<Project> projects = new ArrayList<>();
        projects.add(Mockito.mock(Project.class));
        projects.add(Mockito.mock(Project.class));

        student.setMyProjects(projects);
        
        assertEquals(2, student.getMyProjects().size(), "La lista de proyectos debería contener 2 elementos");
    }

    /**
     * Test para verificar que la lista de postulaciones es inicializada correctamente.
     */
    @Test
    public void testGetMyPostulations() {
        assertNotNull(student.getMyPostulations(), "La lista de postulaciones no debería ser null");
        assertEquals(0, student.getMyPostulations().size(), "La lista de postulaciones debería estar vacía al inicio");
    }

    /**
     * Test para verificar la asignación de una nueva lista de postulaciones.
     */
    @Test
    public void testSetMyPostulations() {
        List<Project> postulations = new ArrayList<>();
        postulations.add(Mockito.mock(Project.class));
        postulations.add(Mockito.mock(Project.class));

        student.setMyPostulations(postulations);
        
        assertEquals(2, student.getMyPostulations().size(), "La lista de postulaciones debería contener 2 elementos");
    }

    /**
     * Test para verificar que se puede agregar un proyecto a la lista de proyectos activos.
     */
    @Test
    public void testAddProjectToMyProjects() {
        Project project = Mockito.mock(Project.class);
        
        student.getMyProjects().add(project);
        assertEquals(1, student.getMyProjects().size(), "La lista de proyectos debería contener un solo proyecto");
        assertTrue(student.getMyProjects().contains(project), "El proyecto debería haber sido agregado correctamente");
    }

    /**
     * Test para verificar que se puede agregar un proyecto a la lista de postulaciones.
     */
    @Test
    public void testAddProjectToMyPostulations() {
        Project project = Mockito.mock(Project.class);
        
        student.getMyPostulations().add(project);
        assertEquals(1, student.getMyPostulations().size(), "La lista de postulaciones debería contener un solo proyecto");
        assertTrue(student.getMyPostulations().contains(project), "El proyecto debería haber sido agregado correctamente");
    }

    /**
     * Test para verificar que se puede eliminar un proyecto de la lista de proyectos activos.
     */
    @Test
    public void testRemoveProjectFromMyProjects() {
        Project project = Mockito.mock(Project.class);
        student.getMyProjects().add(project);
        assertEquals(1, student.getMyProjects().size(), "La lista de proyectos debería contener un solo proyecto antes de eliminar");

        student.getMyProjects().remove(project);
        assertEquals(0, student.getMyProjects().size(), "La lista de proyectos debería estar vacía después de eliminar");
        assertFalse(student.getMyProjects().contains(project), "El proyecto no debería estar en la lista después de eliminarlo");
    }

    /**
     * Test para verificar que se puede eliminar un proyecto de la lista de postulaciones.
     */
    @Test
    public void testRemoveProjectFromMyPostulations() {
        Project project = Mockito.mock(Project.class);
        student.getMyPostulations().add(project);
        assertEquals(1, student.getMyPostulations().size(), "La lista de postulaciones debería contener un solo proyecto antes de eliminar");

        student.getMyPostulations().remove(project);
        assertEquals(0, student.getMyPostulations().size(), "La lista de postulaciones debería estar vacía después de eliminar");
        assertFalse(student.getMyPostulations().contains(project), "El proyecto no debería estar en la lista después de eliminarlo");
    }

    /**
     * Test para verificar el comportamiento al intentar eliminar un proyecto que no existe de la lista de proyectos activos.
     */
    @Test
    public void testRemoveNonExistentProjectFromMyProjects() {
        Project project = Mockito.mock(Project.class);
        assertEquals(0, student.getMyProjects().size(), "La lista debería estar vacía al inicio");

        student.getMyProjects().remove(project);
        assertEquals(0, student.getMyProjects().size(), "Eliminar un proyecto inexistente no debería afectar la lista");
    }

    /**
     * Test para verificar el comportamiento al intentar eliminar un proyecto que no existe de la lista de postulaciones.
     */
    @Test
    public void testRemoveNonExistentProjectFromMyPostulations() {
        Project project = Mockito.mock(Project.class);
        assertEquals(0, student.getMyPostulations().size(), "La lista debería estar vacía al inicio");

        student.getMyPostulations().remove(project);
        assertEquals(0, student.getMyPostulations().size(), "Eliminar un proyecto inexistente no debería afectar la lista");
    }
}
