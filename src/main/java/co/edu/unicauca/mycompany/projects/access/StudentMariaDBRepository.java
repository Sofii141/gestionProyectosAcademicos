package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Student;
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
public class StudentMariaDBRepository extends MariaDBConnection implements IStudentRepository {
    // onexión a la base de datos MariaDB utilizada para la gestión de estudiantes.

    /**
    * Constructor de la clase StudentMariaDBRepository.
    * 
    * Inicializa la base de datos llamando al método {@code initDatabase()} 
    * para asegurarse de que la estructura necesaria esté creada antes de 
    * realizar operaciones sobre los datos.
    */
    public StudentMariaDBRepository() {
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
}
