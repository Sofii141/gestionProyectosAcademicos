package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.EnumProjectState;
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
public class ProjectMariaDBRepository implements IProjectRepository {
    
    private Connection conn;

    public ProjectMariaDBRepository() {
    }
    @Override
    public boolean save(Project newProject) {
        
        // Validate product
        if (newProject == null || newProject.getCompanyNit().isBlank() || newProject.getProId().isBlank() || newProject.getProTitle().isBlank() || 
            newProject.getProDescription().isBlank() || newProject.getProGoals().isBlank() || newProject.getProAbstract().isBlank() ||
            newProject.getProDeadLine() <= 0){
            return false;
        }
        int rowsAffected = 0;
        try {
            this.connect();

            String sql = "INSERT INTO Project (proId, proTitle, proDescription, proAbstract, proGoals ,proDeadLine, proBudget, companyId) "
                    + "VALUES (?,?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, newProject.getProId());
            pstmt.setString(2, newProject.getProTitle());
            pstmt.setString(3, newProject.getProDescription());
            pstmt.setString(4, newProject.getProAbstract());
            pstmt.setString(5, newProject.getProGoals());
            pstmt.setString(6, Integer.toString(newProject.getProDeadLine()));
            pstmt.setString(7, Double.toString(newProject.getProBudget()));
            pstmt.setString(8, newProject.getCompanyNit());
            
            rowsAffected = pstmt.executeUpdate();

            this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsAffected > 0;
    }

    @Override
    public List<Project> listAll() {
        List<Project> projects = new ArrayList<>();
        try {
            this.connect();

            String sql = "SELECT companyId,proId, proTitle, proDescription, proAbstract, proGoals ,proDeadLine, proBudget, proState FROM Project";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Project newProject = new Project(
                                                rs.getString("proId"),
                                                rs.getString("proTitle"),
                                                rs.getString("proDescription"),
                                                rs.getString("proAbstract"),
                                                rs.getString("proGoals"),
                                                Integer.decode(rs.getString("proDeadLine")),
                                                Double.parseDouble(rs.getString("proBudget")),
                                                rs.getString("companyId"));
                // Asigna el estado del proyecto
                newProject.setProState(EnumProjectState.valueOf(rs.getString("proState")));
                
                projects.add(newProject);
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projects;
    }


    public void connect() {
        // URL de conexión para MariaDB
        String url = "jdbc:mariadb://localhost:3306/mydatabase"; // Cambia 'mydatabase' por el nombre de tu base de datos
        String user = "root"; // Cambia 'root' por tu usuario de MariaDB
        String password = "password"; // Cambia 'password' por tu contraseña de MariaDB

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
