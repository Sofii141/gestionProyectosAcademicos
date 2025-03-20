package co.edu.unicauca.mycompany.projects.domain.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import java.util.List;
import java.util.ArrayList;

/**
 * Pruebas unitarias para la clase Coordinator.
 */
public class CoordinatorTest {
    
    private Coordinator coordinator;

    @BeforeEach
    public void setUp() {
        coordinator = new Coordinator("C001", "coordinator@email.com", "securePass");
    }

    /**
     * Test para verificar que la lista de proyectos es inicializada correctamente.
     */
    @Test
    public void testGetCoordProjects() {
        assertNotNull(coordinator.getCoordProjects(), "La lista de proyectos no debería ser null");
        assertEquals(0, coordinator.getCoordProjects().size(), "La lista de proyectos debería estar vacía al inicio");
    }

    /**
     * Test para verificar la asignación de una nueva lista de proyectos.
     */
    @Test
    public void testSetCoordProjects() {
        List<Project> projects = new ArrayList<>();
        projects.add(Mockito.mock(Project.class));
        projects.add(Mockito.mock(Project.class));

        coordinator.setCoordProjects(projects);
        
        assertEquals(2, coordinator.getCoordProjects().size(), "La lista de proyectos debería contener 2 elementos");
    }

    /**
     * Test para verificar que setCoordProjects maneja una lista nula correctamente.
     */
    @Test
    public void testSetCoordProjectsWithNull() {
        coordinator.setCoordProjects(null);
        assertNotNull(coordinator.getCoordProjects(), "La lista de proyectos no debería ser null después de asignar null");
        assertEquals(0, coordinator.getCoordProjects().size(), "La lista debería estar vacía si se asigna null");
    }

    /**
     * Test para verificar que se puede agregar un proyecto a la lista.
     */
    @Test
    public void testAddProject() {
        Project project = Mockito.mock(Project.class);
        
        coordinator.addProject(project);
        assertEquals(1, coordinator.getCoordProjects().size(), "La lista de proyectos debería contener un solo proyecto");
        assertTrue(coordinator.getCoordProjects().contains(project), "El proyecto debería haber sido agregado correctamente");

        // Prueba para evitar duplicados
        coordinator.addProject(project);
        assertEquals(1, coordinator.getCoordProjects().size(), "No debería permitir proyectos duplicados en la lista");
    }

    /**
     * Test para verificar que se puede eliminar un proyecto de la lista.
     */
    @Test
    public void testRemoveProject() {
        Project project = Mockito.mock(Project.class);
        coordinator.addProject(project);
        assertEquals(1, coordinator.getCoordProjects().size(), "La lista de proyectos debería contener un solo proyecto antes de eliminar");

        coordinator.removeProject(project);
        assertEquals(0, coordinator.getCoordProjects().size(), "La lista de proyectos debería estar vacía después de eliminar");
        assertFalse(coordinator.getCoordProjects().contains(project), "El proyecto no debería estar en la lista después de eliminarlo");
    }

    /**
     * Test para verificar el comportamiento al intentar eliminar un proyecto que no existe.
     */
    @Test
    public void testRemoveNonExistentProject() {
        Project project = Mockito.mock(Project.class);
        assertEquals(0, coordinator.getCoordProjects().size(), "La lista debería estar vacía al inicio");

        coordinator.removeProject(project);
        assertEquals(0, coordinator.getCoordProjects().size(), "Eliminar un proyecto inexistente no debería afectar la lista");
    }
}
