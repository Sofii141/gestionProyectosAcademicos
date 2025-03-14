package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.entities.ProjectState;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
        initDatabase();
    }

    @Override
    public boolean save(Project newProject) {
        String sql = "INSERT INTO Project (proId, companyId, proTitle, proDescription, proAbstract, proGoals, proDeadLine, proBudget, proState, proDate) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int rowsAffected;
        try{
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, newProject.getProId());
            pstmt.setString(2, newProject.getIdcompany());
            pstmt.setString(3, newProject.getProTitle());
            pstmt.setString(4, newProject.getProDescription());
            pstmt.setString(5, newProject.getProAbstract());
            pstmt.setString(6, newProject.getProGoals());
            pstmt.setInt(7, newProject.getProDeadLine());
            pstmt.setBigDecimal(8, new BigDecimal(newProject.getProBudget()));
            pstmt.setString(9, newProject.getProState().toString());
            // Insertar fecha actual
            LocalDate fechaActual = LocalDate.now();
            pstmt.setDate(10, Date.valueOf(fechaActual));
          
            rowsAffected = pstmt.executeUpdate();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            disconnect();
        }
        return rowsAffected > 0;
    }

    @Override
    public List<Project> listAll() {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT proId, companyId, proTitle, proDescription, proAbstract, proGoals, proDeadLine, proBudget, proState, proDate FROM Project";
        try{
            this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Project newProject = new Project(
                    rs.getString("proId"),
                    rs.getString("proTitle"),
                    rs.getString("proDescription"),
                    rs.getString("proAbstract"),
                    rs.getString("proGoals"),
                    rs.getInt("proDeadLine"),
                    rs.getBigDecimal("proBudget").doubleValue(),
                    rs.getString("companyId")
                );
                newProject.setProState(ProjectState.valueOf(rs.getString("proState")));
                newProject.setProDate(rs.getDate("proDate"));
                projects.add(newProject);
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            disconnect();
        }
        return projects;
    }

    @Override
    public List<Project> listProjectsAvailable(String studentId){
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT p.proId, p.companyId, p.proTitle, p.proDescription, p.proAbstract, " +
             "p.proGoals, p.proDeadLine, p.proBudget, p.proState, p.proDate " +
             "FROM Project p " +
             "WHERE NOT EXISTS (SELECT 1 FROM Aplicants a WHERE a.proId = p.proId AND a.studentId = ?) " +
             "AND NOT EXISTS (SELECT 1 FROM Develop d WHERE d.proId = p.proId AND d.studentId = ?)";
        try{
            this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentId);
            pstmt.setString(2, studentId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Project newProject = new Project(
                    rs.getString("proId"),
                    rs.getString("proTitle"),
                    rs.getString("proDescription"),
                    rs.getString("proAbstract"),
                    rs.getString("proGoals"),
                    rs.getInt("proDeadLine"),
                    rs.getBigDecimal("proBudget").doubleValue(),
                    rs.getString("companyId")
                );
                newProject.setProState(ProjectState.valueOf(rs.getString("proState")));
                newProject.setProDate(rs.getDate("proDate"));
                projects.add(newProject);
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            disconnect();
        }
        return projects;
    }
    
    @Override
    public Project getProject(String proId) {
        Project project = null;
        String sql = "SELECT proId, companyId, proTitle, proDescription, proAbstract, proGoals, proDeadLine, proBudget, proState, proDate "
               + "FROM Project WHERE proId = ?";
        try{ 
            this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, proId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                project = new Project(
                    rs.getString("proId"),
                    rs.getString("proTitle"),
                    rs.getString("proDescription"),
                    rs.getString("proAbstract"),
                    rs.getString("proGoals"),
                    rs.getInt("proDeadLine"),
                    rs.getBigDecimal("proBudget").doubleValue(),
                    rs.getString("companyId")
                );
                project.setProState(ProjectState.valueOf(rs.getString("proState")));
                project.setProDate(rs.getDate("proDate"));
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            disconnect();
        }
        return project;
    }
        
    @Override
    public boolean apply(String studentId, String projectId) {
        String sql = "INSERT INTO Aplicants (studentId, proId, aplDate) VALUES (?, ?, ?)";
        int rowsAffected;
        LocalDate fechaActual = LocalDate.now();
        try {
            this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentId);
            pstmt.setString(2, projectId);
            pstmt.setDate(3, Date.valueOf(fechaActual));

            rowsAffected = pstmt.executeUpdate();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            disconnect();
        }
        return rowsAffected > 0;
    }
    
    private void initDatabase() {
        // SQL statement for creating the Project table
        String sql = "CREATE TABLE IF NOT EXISTS Project (\n"
                + "    proId VARCHAR(50) NOT NULL,\n"
                + "    companyId VARCHAR(50) NOT NULL,\n"
                + "    proTitle VARCHAR(100) NOT NULL,\n"
                + "    proDescription TEXT NOT NULL,\n"
                + "    proAbstract TEXT NOT NULL,\n"
                + "    proGoals TEXT NOT NULL,\n"
                + "    proDeadLine INT NOT NULL,\n"
                + "    proBudget DECIMAL(10,2),\n"
                + "    proState VARCHAR(20) NOT NULL DEFAULT 'RECIBIDO',\n"
                + "    proDate DATE NOT NULL,\n"
                + "    PRIMARY KEY (proId),\n"
                + "    CONSTRAINT fk_project_UserId FOREIGN KEY (companyId) REFERENCES CompanyContact(userId),\n"
                + "    CONSTRAINT chk_proState CHECK (proState IN ('RECIBIDO', 'ACEPTADO', 'RECHAZADO'))\n"
                + ");";
        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            disconnect();
        }
    }

    public void connect() {
        // URL de conexión para MariaDB
        String url = "jdbc:mariadb://localhost:3306/mydatabase"; 
        String user = "root"; 
        String password = "mariadb";

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
