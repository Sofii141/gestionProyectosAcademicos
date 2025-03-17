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
* Implementación de ICProjectRepository para la gestión de proyectos en MariaDB.
* Proporciona métodos para insertar, listar y obtener información de proyectos,
* así como la gestión de la conexión con la base de datos.
* 
*/
public class ProjectMariaDBRepository implements IProjectRepository {
    // Objeto para manejar la conexión con la base de datos
    private Connection conn;
    

    /**
    * Constructor que inicializa la base de datos.
    */
    public ProjectMariaDBRepository() {
        initDatabase();
    }
    
    /**
    * Guarda un nuevo proyecto en la base de datos.
    * @param newProject El proyecto a guardar.
    * @return true si se guarda correctamente, false en caso contrario.
    */
    @Override
    public boolean save(Project newProject) {
        // Consulta SQL para insertar un nuevo proyecto
        String sql = "INSERT INTO Project (proId, companyId, proTitle, proDescription, proAbstract, proGoals, proDeadLine, proBudget, proState, proDate) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        // Variable para almacenar el número de filas afectadas
        int rowsAffected;
        try{
            // Establece la conexión con la base de datos
            this.connect();
            
            // Prepara la consulta SQL
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // Asigna valores a los parámetros de la consulta SQL
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
            
            // Ejecuta la consulta y obtiene el número de filas afectadas
            rowsAffected = pstmt.executeUpdate();
            
            // Cierra la conexión con la base de datos
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            disconnect();
        }
        
        // Retorna true si al menos una fila fue afectada
        return rowsAffected > 0;
    }

    /**
    * Lista todos los proyectos en la base de datos.
    * @return Lista de proyectos.
    */
    @Override
    public List<Project> listAll() {
        // Lista para almacenar los proyectos recuperados
        List<Project> projects = new ArrayList<>();
        
        // Consulta SQL para seleccionar todos los proyectos
        String sql = "SELECT proId, companyId, proTitle, proDescription, proAbstract, proGoals, proDeadLine, proBudget, proState, proDate FROM Project";
        
        try{
            // Establece la conexión con la base de datos
            this.connect();
            
            // Crea un objeto Statement para ejecutar la consulta
            Statement stmt = conn.createStatement();
            
            // Ejecuta la consulta y almacena el resultado
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            // Itera sobre los resultados
            while (rs.next()) {
                count++;
                // Crea un nuevo objeto Project con los datos obtenidos
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
                // Asigna el estado del proyecto
                newProject.setProState(ProjectState.valueOf(rs.getString("proState")));
                
                // Asigna la fecha del proyecto
                newProject.setProDate(rs.getDate("proDate"));
                
                // Agrega el proyecto a la lista
                projects.add(newProject);
            }
            System.out.println("Proyectos obtenidos de la BD: " + count);
            
            // Cierra la conexión con la base de datos
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            disconnect();
        }
        System.out.println("Proyectos en la lista antes de retornar: " + projects.size());
        // Retorna la lista de proyectos
        return projects;
    }

    /**
    * Lista los proyectos en los que el estudiante no ha aplicado ni está desarrollando.
    * @return Lista de proyectos.
    */
    @Override
    public List<Project> listProjectsAvailable(String studentId){
        // Lista para almacenar los proyectos disponibles
        List<Project> projects = new ArrayList<>();
        
        // Consulta SQL para seleccionar proyectos en los que el estudiante no ha aplicado ni está desarrollando
        String sql = "SELECT p.proId, p.companyId, p.proTitle, p.proDescription, p.proAbstract, " +
             "p.proGoals, p.proDeadLine, p.proBudget, p.proState, p.proDate " +
             "FROM Project p " +
             "WHERE NOT EXISTS (SELECT 1 FROM Aplicants a WHERE a.proId = p.proId AND a.studentId = ?) " +
             "AND NOT EXISTS (SELECT 1 FROM Develop d WHERE d.proId = p.proId AND d.studentId = ?)";
        try{
            // Conectar a la base de datos
            this.connect();
            
            // Prepara la consulta SQL
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // Asigna valores a los parámetros de la consulta SQL
            pstmt.setString(1, studentId);
            pstmt.setString(2, studentId);
            
            // Ejecutar la consulta
            ResultSet rs = pstmt.executeQuery();
            
            // Recorrer los resultados de la consulta
            while (rs.next()) {
                // Crea un nuevo objeto Project con los datos obtenidos
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
                // Establecer estado del proyecto
                newProject.setProState(ProjectState.valueOf(rs.getString("proState")));
                
                // Establecer fecha del proyecto
                newProject.setProDate(rs.getDate("proDate"));
                
                // Agregar proyecto a la lista
                projects.add(newProject);
            }
            
            // Desconectar de la base de datos
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            disconnect();
        }
        
        // Retornar lista de proyectos disponibles
        return projects;
    }
    
    /**
    * Recupera un proyecto específico de la base de datos a partir de su identificador único.
    *
    * @param proId El identificador del proyecto que se desea obtener.
    * @return Un proyecto con los datos del proyecto si existe
    */
    @Override
    public Project getProject(String proId) {
        // Variable para almacenar el proyecto recuperado
        Project project = null;
        
        // Consulta SQL para obtener un proyecto por su ID
        String sql = "SELECT proId, companyId, proTitle, proDescription, proAbstract, proGoals, proDeadLine, proBudget, proState, proDate "
               + "FROM Project WHERE proId = ?";
        try{ 
            // Conectar a la base de datos
            this.connect();
            
            // Prepara la consulta SQL
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // Asigna valores a los parámetros de la consulta SQL
            pstmt.setString(1, proId);
            
            // Ejecutar la consulta
            ResultSet rs = pstmt.executeQuery();
            
            // Si hay un resultado
            if (rs.next()) {
                // Crea un nuevo objeto Project con los datos obtenidos
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
                // Establecer estado del proyecto
                project.setProState(ProjectState.valueOf(rs.getString("proState")));
                
                // Establecer fecha del proyecto
                project.setProDate(rs.getDate("proDate"));
            }
            
            // Desconectar de la base de datos
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            disconnect();
        }
        
        // Retornar el proyecto recuperado
        return project;
    }
        
    /**
    * Registra la aplicación de un estudiante a un proyecto en la base de datos.
    *
    * @param studentId El identificador del estudiante que desea postularse.
    * @param projectId El identificador del proyecto al que el estudiante se postula.
    * @return {@code true} si la postulación se registró correctamente, 
    *         {@code false} en caso de error.
    */
    @Override
    public boolean apply(String studentId, String projectId) {
        // Consulta SQL para registrar la aplicación de un estudiante a un proyecto
        String sql = "INSERT INTO Aplicants (studentId, proId, aplDate) VALUES (?, ?, ?)";
        
        // Cantidad de filas afectadas
        int rowsAffected;
        
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        
        try {
            // Conectar a la base de datos
            this.connect();
            
            // Prepara la consulta SQL
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // Asigna valores a los parámetros de la consulta SQL
            pstmt.setString(1, studentId);
            pstmt.setString(2, projectId);
            pstmt.setDate(3, Date.valueOf(fechaActual));
            
            // Ejecutar inserción
            rowsAffected = pstmt.executeUpdate();
            
            // Desconectar de la base de datos
            this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            disconnect();
        }
        
        // Retornar verdadero si la inserción fue exitosa
        return rowsAffected > 0;
    }
    
    /**
    * Cuenta los proyectos asociados a un estudiante en distintas categorías:
    * - Total de proyectos en la base de datos.
    * - Proyectos en los que el estudiante ha postulado.
    * - Proyectos en los que el estudiante está desarrollando.
    *
    * @param studentId El identificador del estudiante.
    * @return Una lista de tres valores enteros en el siguiente orden:
    *         [Total de proyectos, Proyectos postulados, Proyectos en desarrollo].
    *         Retorna {@code null} en caso de error.
    */
    @Override
    public List<Integer> countProjectsStudent(String studentId) {
        // Consultas SQL para contar diferentes tipos de proyectos
        String sql1 = "SELECT COUNT(distinct(project.proId)) AS sumTotal FROM project ";
        String sql2 = "SELECT COUNT(DISTINCT(p.proId)) AS sumPostulated\n" +
                    "FROM project p\n" +
                    "INNER JOIN aplicants a\n" +
                    "ON p.proId = a.proId\n" +
                    "WHERE a.studentId = ?";
        String sql3 = "SELECT COUNT(DISTINCT(p.proId)) AS sumDevelop\n" +
                    "FROM project p\n" +
                    "INNER JOIN develop d\n" +
                    "ON p.proId = d.proId\n" +
                    "WHERE d.studentId = ?";
        
        // Lista para almacenar los resultados
        List<Integer> valores = new ArrayList<>();
        try {
            // Conectar a la base de datos
            this.connect();
            
            // Prepara la consulta SQL
            PreparedStatement pstmt = conn.prepareStatement(sql1);
            
            // Ejecutar la consulta
            ResultSet rs = pstmt.executeQuery();
            
            // Si hay un resultado lo añade a la lista
            if (rs.next()) {
                valores.add(rs.getInt("sumTotal"));
            }
            
            // Prepara la consulta SQL
            pstmt = conn.prepareStatement(sql2);
            
            // Asigna valores a los parámetros de la consulta SQL
            pstmt.setString(1, studentId);
            
            // Ejecutar la consulta
            rs = pstmt.executeQuery();
            
            // Si hay un resultado lo añade a la lista
            if (rs.next()) {
                valores.add(rs.getInt("sumPostulated"));
            }
            
            // Prepara la consulta SQL
            pstmt = conn.prepareStatement(sql3);
            
            // Asigna valores a los parámetros de la consulta SQL
            pstmt.setString(1, studentId);
            
            // Ejecutar la consulta
            rs = pstmt.executeQuery();
            
            // Si hay un resultado lo añade a la lista
            if (rs.next()) {
                valores.add(rs.getInt("sumDevelop"));
            }
            
            // Desconectar de la base de datos
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            disconnect();
        }
        
        // Retorna los valores recolectados
        return valores;
    }
    
    /**
    * Inicializa la base de datos creando la tabla "Project" si no existe.
    */
    private void initDatabase() {
        // Sentencia SQL para crear la tabla "Project" si no existe
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
            // Establece la conexión con la base de datos
            this.connect();
            
            // Crea un objeto Statement para ejecutar la consulta
            Statement stmt = conn.createStatement();
            
            // Ejecuta la sentencia SQL para crear la tabla si no existe
            stmt.execute(sql);
            
            // Cierra la conexión a la base de datos
            this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            disconnect();
        }
    }

    /**
    * Establece la conexión con la base de datos.
    */
    public void connect() {
        String url = "jdbc:mariadb://localhost:3306/mydatabase"; 
        String user = "root"; 
        String password = "mariadb";

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
    * Cierra la conexión con la base de datos.
    */
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public int countByStatus(String status) {
        String sql = "SELECT COUNT(*) FROM Project WHERE proState = ?";
        int count = 0;

        try {
            this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, status);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return count;
    }

    @Override
    public int countTotalProjects() {
        String sql = "SELECT COUNT(*) FROM Project"; // Eliminamos la condición de filtrado
        int total = 0;
        
        try {
            this.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

        return total;
    }
    
    @Override
    public boolean updateProjectStatus(String projectId, String newStatus) {
        System.out.println("Estado recibido: " + newStatus);
        String sql = "UPDATE Project SET proState = ? WHERE proId = ?";
        boolean success = false;

        try {
            this.connect(); // Conectar a la base de datos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, newStatus);
            stmt.setString(2, projectId); // Ahora usamos setString en lugar de setInt

            int rowsAffected = stmt.executeUpdate();
            success = rowsAffected > 0; // Si al menos una fila fue afectada, la actualización fue exitosa
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.disconnect(); // Cerrar la conexión
        }

        return success; // Devuelve si se realizó la actualización
    }
    
}
