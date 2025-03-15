package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import java.util.List;

/**
 *
 * @author User
 */
public interface IProjectRepository {
    boolean save(Project newProject);
    List<Project> listAll();
    List<Project> listProjectsAvailable(String studentId);
    Project getProject(String id);
    boolean apply(String studentId,String projectId);
    List<Integer> countProjectsStudent(String studentId);
}
    
