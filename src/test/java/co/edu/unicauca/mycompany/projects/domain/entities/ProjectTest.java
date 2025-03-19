/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.domain.entities;

import static org.assertj.core.api.Assertions.assertThat;
//import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;
import co.edu.unicauca.mycompany.projects.infra.state.ProjectStatePatron;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author User
 */
public class ProjectTest {
/*  
    @Mock
    private ProjectService projectService;

    @InjectMocks
    private Project project;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProjectConstructorAndGetters() {
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

        assertThat(project.getProId()).isEqualTo("P001");
        assertThat(project.getProTitle()).isEqualTo("New Project");
        assertThat(project.getProDescription()).isEqualTo("This is a new project");
        assertThat(project.getProAbstract()).isEqualTo("Project Abstract");
        assertThat(project.getProGoals()).isEqualTo("Project Goals");
        assertThat(project.getProDeadLine()).isEqualTo(30);
        assertThat(project.getProDate()).isEqualTo(proDate);
        assertThat(project.getProBudget()).isEqualTo(10000.0);
        assertThat(project.getIdcompany()).isEqualTo("C001");
    }

    @Test
    void testSetters() {
        Project project = new Project("", "", "", "", "", 0, new Date(), 0.0, "");

        project.setProId("P002");
        project.setProTitle("Updated Project");
        project.setProDescription("This is an updated project");
        project.setProAbstract("Updated Abstract");
        project.setProGoals("Updated Goals");
        project.setProDeadLine(60);
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.APRIL, 20); // Año, Mes (0 basado), Día
        Date updatedDate = calendar.getTime();
        project.setProDate(updatedDate);
        
        project.setProBudget(20000.0);
        project.setIdcompany("C002");

        assertThat(project.getProId()).isEqualTo("P002");
        assertThat(project.getProTitle()).isEqualTo("Updated Project");
        assertThat(project.getProDescription()).isEqualTo("This is an updated project");
        assertThat(project.getProAbstract()).isEqualTo("Updated Abstract");
        assertThat(project.getProGoals()).isEqualTo("Updated Goals");
        assertThat(project.getProDeadLine()).isEqualTo(60);
        assertThat(project.getProDate()).isEqualTo(updatedDate);
        assertThat(project.getProBudget()).isEqualTo(20000.0);
        assertThat(project.getIdcompany()).isEqualTo("C002");
    }

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
    }
    */
}
