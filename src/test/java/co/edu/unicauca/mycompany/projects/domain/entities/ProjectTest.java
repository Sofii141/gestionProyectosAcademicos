package co.edu.unicauca.mycompany.projects.domain.entities;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Pruebas unitarias para la clase Project.
 */
public class ProjectTest {
    
    private Project project;

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        project = new Project("P001", "Proyecto 1", "Descripción del proyecto", "Resumen", 
                              "Objetivos", 30, new Date(), 5000.0, "C001");
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Prueba el constructor de la clase Project y los métodos getters. Se
     * verifica que los valores iniciales asignados sean correctos.
     */
    @Test
    void testProjectConstructorAndGetters() {
        // Fecha de prueba
        Date testDate = new Date();

        // Se crea una instancia de Project con valores de prueba.
        Project projectTest = new Project(
                "P001", "Sistema de Gestión", "Desarrollo de un sistema", "Resumen del proyecto",
                "Automatizar procesos", 30, testDate, 5000.0, "C123"
        );

        // Se validan los valores esperados con los valores obtenidos de los getters.
        assertThat(projectTest.getProId()).isEqualTo("P001");
        assertThat(projectTest.getProTitle()).isEqualTo("Sistema de Gestión");
        assertThat(projectTest.getProDescription()).isEqualTo("Desarrollo de un sistema");
        assertThat(projectTest.getProAbstract()).isEqualTo("Resumen del proyecto");
        assertThat(projectTest.getProGoals()).isEqualTo("Automatizar procesos");
        assertThat(projectTest.getProDeadLine()).isEqualTo(30);
        assertThat(projectTest.getProDate()).isEqualTo(testDate);
        assertThat(projectTest.getProBudget()).isEqualTo(5000.0);
        assertThat(projectTest.getIdcompany()).isEqualTo("C123");
        assertThat(projectTest.getProState()).isEqualTo(enumProjectState.RECIBIDO);
        assertThat(projectTest.getProTeam()).isEmpty();
        assertThat(projectTest.getProPostulates()).isEmpty();
        assertThat(projectTest.getProCoordinator()).isNull();
    }

    /**
     * Prueba los métodos setters de la clase Project. Se verifica que los
     * valores se actualicen correctamente.
     */
    @Test
    void testSetters() {
        // Se crea una instancia de Project con valores iniciales vacíos.
        Project project = new Project("", "", "", "", "", 0, new Date(), 0.0, "");

        // Fecha de prueba
        Date newDate = new Date();

        // Se actualizan los valores usando los setters.
        project.setProId("P002");
        project.setProTitle("Plataforma E-learning");
        project.setProDescription("Desarrollo de plataforma educativa");
        project.setProAbstract("Proyecto de educación en línea");
        project.setProGoals("Facilitar el acceso a educación");
        project.setProDeadLine(60);
        project.setProDate(newDate);
        project.setProBudget(10000.0);
        project.setIdcompany("C456");
        project.setProCoordinator("Coord1");

        List<Student> team = new ArrayList<>();
        List<Student> postulates = new ArrayList<>();
        team.add(new Student("1", "1", "1"));
        postulates.add(new Student("2", "2", "2"));

        project.setProTeam(team);
        project.setProPostulates(postulates);

        // Se validan los valores modificados con los valores esperados.
        assertThat(project.getProId()).isEqualTo("P002");
        assertThat(project.getProTitle()).isEqualTo("Plataforma E-learning");
        assertThat(project.getProDescription()).isEqualTo("Desarrollo de plataforma educativa");
        assertThat(project.getProAbstract()).isEqualTo("Proyecto de educación en línea");
        assertThat(project.getProGoals()).isEqualTo("Facilitar el acceso a educación");
        assertThat(project.getProDeadLine()).isEqualTo(60);
        assertThat(project.getProDate()).isEqualTo(newDate);
        assertThat(project.getProBudget()).isEqualTo(10000.0);
        assertThat(project.getIdcompany()).isEqualTo("C456");
        assertThat(project.getProCoordinator()).isEqualTo("Coord1");
        assertThat(project.getProTeam()).isNotEmpty();
        assertThat(project.getProPostulates()).isNotEmpty();
    }

    /**
     * Test para verificar que la lista de estudiantes del equipo es inicializada correctamente.
     */
    @Test
    public void testGetProTeam() {
        assertNotNull(project.getProTeam(), "La lista de estudiantes no debería ser null");
        assertEquals(0, project.getProTeam().size(), "La lista de estudiantes debería estar vacía al inicio");
    }

    /**
     * Test para verificar la asignación de una nueva lista de estudiantes al equipo.
     */
    @Test
    public void testSetProTeam() {
        List<Student> students = new ArrayList<>();
        students.add(Mockito.mock(Student.class));
        students.add(Mockito.mock(Student.class));

        project.setProTeam(students);
        
        assertEquals(2, project.getProTeam().size(), "La lista de estudiantes debería contener 2 elementos");
    }
    
    /**
     * Test para verificar que se puede agregar un estudiante al equipo del proyecto.
     */
    @Test
    public void testAddStudentToTeam() {
        Student student = Mockito.mock(Student.class);
        
        project.getProTeam().add(student);
        assertEquals(1, project.getProTeam().size(), "La lista de estudiantes debería contener un solo estudiante");
        assertTrue(project.getProTeam().contains(student), "El estudiante debería haber sido agregado correctamente");
    }

    /**
     * Test para verificar que se puede eliminar un estudiante del equipo del proyecto.
     */
    @Test
    public void testRemoveStudentFromTeam() {
        Student student = Mockito.mock(Student.class);
        project.getProTeam().add(student);
        assertEquals(1, project.getProTeam().size(), "La lista de estudiantes debería contener un solo estudiante antes de eliminar");

        project.getProTeam().remove(student);
        assertEquals(0, project.getProTeam().size(), "La lista de estudiantes debería estar vacía después de eliminar");
        assertFalse(project.getProTeam().contains(student), "El estudiante no debería estar en la lista después de eliminarlo");
    }

    /**
     * Test para verificar el comportamiento al intentar eliminar un estudiante que no existe.
     */
    @Test
    public void testRemoveNonExistentStudent() {
        Student student = Mockito.mock(Student.class);
        assertEquals(0, project.getProTeam().size(), "La lista debería estar vacía al inicio");

        project.getProTeam().remove(student);
        assertEquals(0, project.getProTeam().size(), "Eliminar un estudiante inexistente no debería afectar la lista");
    }

    /**
     * Test para verificar que el estado del proyecto cambia correctamente.
     */
    @Test
    public void testChangeProjectState() {
        project.setProState(enumProjectState.ACEPTADO);
        assertEquals(enumProjectState.ACEPTADO, project.getProState(), "El estado del proyecto debería haberse actualizado a ACEPTADO");
    }

/*
    @Test
    void testSaveProject() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.MARCH, 18); // Año, Mes (0 basado), Día
        Date proDate = calendar.getTime();

        Project project = new Project(
                "P001",
                "New Project",
                "This is a new project",
                "Project Abstract",
                "Project Goals",
                30,
                proDate,
                10000.0,
                "C001"
        );

        when(projectService.saveProject(project)).thenReturn(true);

        boolean result = projectService.saveProject(project);

        assertThat(result).isTrue();
        verify(projectService, times(1)).saveProject(project);
    }*/
}
