package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author User
 */
public class ProjectMariaDBRepository extends MariaDBConnection implements IProjectRepository {

    public ProjectMariaDBRepository() {
        initDatabase();
    }

    @Override
    public boolean save(Project newProject) {
        try {
            // Validate product
            if (newProject == null || newProject.getProId().isBlank() || newProject.getProTitle().isBlank() || 
                newProject.getProDescription().isBlank() || newProject.getProGoals().isBlank() || newProject.getProAbstract().isBlank() ||
                newProject.getProDeadLine() < 0){
                return false;
            }
            this.connect();

            String sql = "INSERT INTO Project (proId, proTitle, proDescription, proAbstract, proGoals ,proDeadLine, proBudget) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newProject.getProId());
            pstmt.setString(2, newProject.getProTitle());
            pstmt.setString(3, newProject.getProDescription());
            pstmt.setString(4, newProject.getProGoals());
            pstmt.setString(5, newProject.getProAbstract());
            pstmt.setString(6, Integer.toString(newProject.getProDeadLine()));
            pstmt.setString(7, Float.toString(newProject.getProBudget()));
            pstmt.executeUpdate();

            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Project> listAll() {
        List<Project> projects = new ArrayList<>();
        try {
            this.connect();

            String sql = "SELECT proId, proTitle, proDescription, proAbstract, proGoals ,proDeadLine, proBudget FROM Project";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Project newProject = new Project(rs.getString("proId"), rs.getString("proTitle"), rs.getString("proDescription"),
                        rs.getString("proAbstract"), rs.getString("proGoals"), Integer.decode(rs.getString("proDeadLine")),Float.parseFloat(rs.getString("proBudget")));

                projects.add(newProject);
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projects;
    }
}
