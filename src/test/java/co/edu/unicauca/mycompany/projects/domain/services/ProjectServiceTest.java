package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.IProjectRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/** Pruebas unitarias para la clase {@code ProjectService}.
 *
 * Se utilizan mocks para simular el comportamiento del repositorio
 * {@code IProjectRepository}, permitiendo probar la lógica del servicio sin
 * depender de una base de datos real.
 */
public class ProjectServiceTest {

    /** Mock del repositorio de proyectos */
    @Mock
    private IProjectRepository repositoryMock;

    /** Instancia del servicio de proyectos a probar */
    private ProjectService projectService;

    /**
     * Configuración inicial antes de cada prueba. Se inicializan los mocks y se
     * inyectan en ProjectService.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        projectService = new ProjectService(repositoryMock);
    }

    /**
     * Prueba el método listProjects() para verificar que devuelve una lista de proyectos.
     */
    @Test
    void testListProjects() {
        Project project1 = mock(Project.class);
        Project project2 = mock(Project.class);
        List<Project> projects = Arrays.asList(project1, project2);
        when(repositoryMock.listAll()).thenReturn(projects);

        List<Project> result = projectService.listProjects();

        assertEquals(2, result.size());
        verify(repositoryMock, times(1)).listAll();
    }

    /**
     * Prueba el método projectsAvailable() para verificar que devuelve una lista de proyectos disponibles.
     */
    @Test
    void testProjectsAvailable() {
        Project project = mock(Project.class);
        List<Project> projects = Arrays.asList(project);
        when(repositoryMock.listProjectsAvailable("student123")).thenReturn(projects);

        List<Project> result = projectService.projectsAvailable("student123");

        assertEquals(1, result.size());
        verify(repositoryMock, times(1)).listProjectsAvailable("student123");
    }

    /**
     * Prueba el método getProject() cuando el proyecto existe.
     */
    @Test
    void testGetProjectExists() {
        Project project = mock(Project.class);
        when(repositoryMock.getProject("12345")).thenReturn(project);

        Project result = projectService.getProject("12345");

        assertNotNull(result);
        verify(repositoryMock, times(1)).getProject("12345");
    }

    /**
     * Prueba el método getProject() cuando el proyecto no existe.
     */
    @Test
    void testGetProjectNotExists() {
        when(repositoryMock.getProject("99999")).thenReturn(null);

        Project result = projectService.getProject("99999");

        assertNull(result);
        verify(repositoryMock, times(1)).getProject("99999");
    }

    /**
     * Prueba el método saveProject()}con un proyecto válido.
     */
    @Test
    void testSaveProjectSuccess() {
        Project project = mock(Project.class);
        when(repositoryMock.save(project)).thenReturn(true);

        boolean result = projectService.saveProject(project);

        assertTrue(result);
        verify(repositoryMock, times(1)).save(project);
    }

    /**
     * Prueba el método saveProject() cuando la inserción falla.
     */
    @Test
    void testSaveProjectFailure() {
        Project project = mock(Project.class);
        when(repositoryMock.save(project)).thenReturn(false);

        boolean result = projectService.saveProject(project);

        assertFalse(result);
        verify(repositoryMock, times(1)).save(project);
    }

    /**
     * Verifica que se obtenga la información de un proyecto existente.
     */
    @Test
    void testGetProject() {
        Project project = mock(Project.class);
        when(repositoryMock.getProject("P001")).thenReturn(project);

        Project result = projectService.getProject("P001");

        assertNotNull(result);
        verify(repositoryMock, times(1)).getProject("P001");
    }

    /**
     * Verifica el guardado de un proyecto.
     */
    @Test
    void testSaveProject() {
        Project project = mock(Project.class);
        when(repositoryMock.save(project)).thenReturn(true);

        boolean result = projectService.saveProject(project);

        assertTrue(result);
        verify(repositoryMock, times(1)).save(project);
    }

    /**
     * Verifica la postulación de un estudiante a un proyecto.
     */
    @Test
    void testApplyStudent() {
        when(repositoryMock.apply("student1", "P001")).thenReturn(true);

        projectService.applyStudent("student1", "P001");

        verify(repositoryMock, times(1)).apply("student1", "P001");
    }

    /**
     * Verifica que se obtienen los datos de gráficos de un estudiante.
     */
    @Test
    void testDataGraphicStudent() {
        List<Integer> data = Arrays.asList(1, 2, 3);
        when(repositoryMock.countProjectsStudent("student1")).thenReturn(data);

        List<Integer> result = projectService.dataGraphicStudent("student1");

        assertEquals(data, result);
        verify(repositoryMock, times(1)).countProjectsStudent("student1");
    }

    /**
     * Verifica que se actualiza el estado de un proyecto correctamente.
     */
    @Test
    void testUpdateProjectStatus() {
        when(repositoryMock.updateProjectStatus("P001", "ACEPTADO")).thenReturn(true);

        boolean result = projectService.updateProjectStatus("P001", "ACEPTADO");

        assertTrue(result);
        verify(repositoryMock, times(1)).updateProjectStatus("P001", "ACEPTADO");
    }

    /**
     * Verifica si un ID de proyecto existe.
     */
    @Test
    void testExistProjectId() {
        when(repositoryMock.existProjectId("P001")).thenReturn(true);

        boolean result = projectService.existProjectId("P001");

        assertTrue(result);
        verify(repositoryMock, times(1)).existProjectId("P001");
    }
    
}