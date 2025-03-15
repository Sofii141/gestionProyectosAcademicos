package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Student;
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
 * Implementación de la interfaz IStudentRepository para gestionar 
 * la persistencia de estudiantes en una base de datos MariaDB.
 * 
 * Esta clase proporciona métodos para interactuar con la base de datos 
 * y realizar operaciones CRUD relacionadas con los estudiantes.
 * 
 */
public class StudentMariaDBRepository  implements IStudentRepository {
    // onexión a la base de datos MariaDB utilizada para la gestión de estudiantes.
    private Connection conn;

    /**
    * Constructor de la clase StudentMariaDBRepository.
    * 
    * Inicializa la base de datos llamando al método {@code initDatabase()} 
    * para asegurarse de que la estructura necesaria esté creada antes de 
    * realizar operaciones sobre los datos.
    */
    public StudentMariaDBRepository() {
        initDatabase();
    }
    
    /**
    * Inicializa la base de datos creando la tabla Student si no existe.
    */
    private void initDatabase() {
        // SQL para crear la tabla Student
        String sql = "CREATE TABLE IF NOT EXISTS Student (\n"
                   + "    userId VARCHAR(50) NOT NULL,\n"
                   + "    PRIMARY KEY (userId),\n"
                   + "    CONSTRAINT fk_Student_User FOREIGN KEY (userId) REFERENCES User(userId)\n"
                   + ");";

        try {
            // Establecer conexión con la base de datos
            this.connect();
            
            // Crear un objeto Statement para ejecutar la consulta SQL
            Statement stmt = conn.createStatement();
            
            // Ejecutar la sentencia SQL para crear la tabla si no existe
            stmt.execute(sql);
            
            // Cerrar la conexión con la base de datos
            this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
    }
    
    /**
    * Guarda un nuevo estudiante en la base de datos.  
    * 
    * Este método inserta los datos del estudiante en la tabla `User` y, 
    * posteriormente, en la tabla `Student`. Se utiliza una transacción para 
    * garantizar que ambas inserciones se realicen correctamente. Si ocurre un 
    * error en alguna de las inserciones, se revierte la transacción para evitar 
    * datos inconsistentes.
    * 
    * 
    * @param newStudent El objeto `Student` que contiene los datos del nuevo estudiante.
    * @return `true` si la inserción fue exitosa en ambas tablas, `false` en caso contrario.
    */
    @Override
    public boolean save(Student newStudent) {
        // Definir la consulta SQL para insertar un nuevo usuario en la tabla User
        String sqlUser = "INSERT INTO User (userId, userEmail, userPassword) VALUES (?, ?, ?)";
        
        // Definir la consulta SQL para insertar un nuevo estudiante en la tabla Student
        String sqlStudent = "INSERT INTO Student (userId) VALUES (?)";
        
        // Variable para contar las filas afectadas por las inserciones
        int rowsAffected = 0;
        
        try {
            // Establecer la conexión con la base de datos
            this.connect();
            
            // Desactivar el autocommit para manejar la transacción manualmente
            conn.setAutoCommit(false); 
            
            // Preparar la consulta para insertar en la tabla User
            PreparedStatement pstmtUser = conn.prepareStatement(sqlUser);
            
            // Asigna los parametros para la consulta
            pstmtUser.setString(1, newStudent.getUserId());
            pstmtUser.setString(2, newStudent.getUserEmail());
            pstmtUser.setString(3, newStudent.getUserPassword());
            
            // Ejecutar la inserción y sumar filas
            rowsAffected += pstmtUser.executeUpdate();

            // Preparar la consulta para insertar en la tabla Student
            PreparedStatement pstmtStudent = conn.prepareStatement(sqlStudent);
            
            // Asigna los parametros para la consulta
            pstmtStudent.setString(1, newStudent.getUserId());
            
            // Ejecutar la inserción y sumar filas
            rowsAffected += pstmtStudent.executeUpdate();

            // Confirmar la transacción si ambas inserciones fueron exitosas
            conn.commit();
            
            // Desconectar de la base de datos
            this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
            try {
                // Revertir cambios si hay error
                conn.rollback();
            } catch (SQLException rollbackEx) {
                Logger.getLogger(StudentMariaDBRepository.class.getName()).log(Level.SEVERE, null, rollbackEx);
            }
            return false;
        } finally {
            disconnect();
        }
        
        // Retornar verdadero si al menos una fila fue afectada en ambas inserciones
        return rowsAffected > 0;
    }

    /**
    * Recupera la lista de todos los estudiantes registrados en la base de datos.
    * 
    * Este método consulta la tabla `User` y la tabla `Student` para obtener 
    * información sobre los estudiantes registrados. La relación entre ambas 
    * tablas se realiza mediante una cláusula `JOIN` en la consulta SQL.
    * 
    *
    * @return Una lista de objetos `Student` con la información de todos los estudiantes.
    */
    @Override
    public List<Student> listAll() {
        // Crear una lista para almacenar los estudiantes recuperados
        List<Student> students = new ArrayList<>();
        
        // Consulta SQL para seleccionar los datos de los estudiantes
        String sql = "SELECT User.userId, userEmail, userPassword FROM User "
                   + "JOIN Student ON User.userId = Student.userId";
        try {
            // Establecer la conexión con la base de datos
            this.connect();
            
            // Crear un objeto Statement para ejecutar la consulta
            Statement stmt = conn.createStatement();
            
            // Ejecutar la consulta y obtener los resultados en un ResultSet
            ResultSet rs = stmt.executeQuery(sql);
            
            // Iterar sobre los resultados obtenidos
            while (rs.next()) {
                // Crear un nuevo objeto Student con los datos recuperados
                Student student = new Student(
                    rs.getString("userId"),
                    rs.getString("userEmail"),
                    rs.getString("userPassword")
                );
                
                // Agregar el estudiante a la lista
                students.add(student);
            }
            
            // Desconectar de la base de datos
            this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        
        // Retornar la lista de estudiantes recuperados
        return students;
    }
    /**
     * Recupera un estudiante específico de la base de datos según su identificador.
     * 
     * Este método realiza una consulta en la base de datos para obtener la información
     * de un estudiante en función de su `userId`. Utiliza una sentencia preparada
     * para evitar vulnerabilidades como la inyección SQL.
     * 
     *
     * @param userId El identificador único del estudiante a recuperar.
     * @return Un objeto `Student` si el estudiante existe en la base de datos, o `null` si no se encuentra.
     */
    @Override
    public Student getStudent(String userId) {
        // Variable para almacenar el estudiante recuperado
        Student student = null;
        
        // Consulta SQL para obtener los datos de un estudiante en base a su ID
        String sql = "SELECT User.userId, userEmail, userPassword FROM User "
                   + "JOIN Student ON User.userId = Student.userId "
                   + "WHERE User.userId = ?";

        try {
            // Establecer la conexión con la base de datos
            this.connect();
            
            // Preparar la consulta SQL con un parámetro
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // Asignar el valor del parámetro `userId`
            pstmt.setString(1, userId);
            
            // Ejecutar la consulta y obtener los resultados
            ResultSet rs = pstmt.executeQuery();
            
            // Si hay un resultado, crear el objeto Student con los datos obtenidos
            if (rs.next()) {
                student = new Student(
                    rs.getString("userId"),
                    rs.getString("userEmail"),
                    rs.getString("userPassword")
                );
            }
            
            // Desconectar de la base de datos
            this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        
        // Retornar el estudiante encontrado o `null` si no se halló en la base de datos
        return student;
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

}
