
package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.entities.Student;
import java.util.List;

/**
 *
 * @author paula
 */
public interface IStudentRepository {
    boolean save(Student newStudent);
    List<Student> listAll();
    Student getStudent(String id);
}
