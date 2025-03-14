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
 *
 * @author paula
 */
public class StudentMariaDBRepository  implements IStudentRepository {
    private Connection conn;

    public StudentMariaDBRepository() {
        initDatabase();
    }
    
    private void initDatabase() {
        // SQL para crear la tabla Student
        String sql = "CREATE TABLE IF NOT EXISTS Student (\n"
                   + "    userId VARCHAR(50) NOT NULL,\n"
                   + "    PRIMARY KEY (userId),\n"
                   + "    CONSTRAINT fk_Student_User FOREIGN KEY (userId) REFERENCES User(userId)\n"
                   + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(StudentMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
    }
    
    @Override
    public boolean save(Student newStudent) {
        String sqlUser = "INSERT INTO User (userId, userEmail, userPassword) VALUES (?, ?, ?)";
        String sqlStudent = "INSERT INTO Student (userId) VALUES (?)";

        int rowsAffected = 0;
        try {
            this.connect();
            conn.setAutoCommit(false); // Iniciar transacción

            // Insertar en la tabla User
            PreparedStatement pstmtUser = conn.prepareStatement(sqlUser);
            pstmtUser.setString(1, newStudent.getUserId());
            pstmtUser.setString(2, newStudent.getUserEmail());
            pstmtUser.setString(3, newStudent.getUserPassword());
            rowsAffected += pstmtUser.executeUpdate();

            // Insertar en la tabla Student
            PreparedStatement pstmtStudent = conn.prepareStatement(sqlStudent);
            pstmtStudent.setString(1, newStudent.getUserId());
            rowsAffected += pstmtStudent.executeUpdate();

            conn.commit(); // Confirmar la transacción
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(StudentMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.rollback(); // Revertir cambios si hay error
            } catch (SQLException rollbackEx) {
                Logger.getLogger(StudentMariaDBRepository.class.getName()).log(Level.SEVERE, null, rollbackEx);
            }
            return false;
        } finally {
            disconnect();
        }
        return rowsAffected > 0;
    }

    @Override
    public List<Student> listAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT User.userId, userEmail, userPassword FROM User "
                   + "JOIN Student ON User.userId = Student.userId";
        try {
            this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Student student = new Student(
                    rs.getString("userId"),
                    rs.getString("userEmail"),
                    rs.getString("userPassword")
                );
                students.add(student);
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(StudentMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return students;
    }

    @Override
    public Student getStudent(String userId) {
        Student student = null;
        String sql = "SELECT User.userId, userEmail, userPassword FROM User "
                   + "JOIN Student ON User.userId = Student.userId "
                   + "WHERE User.userId = ?";

        try {
            this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                student = new Student(
                    rs.getString("userId"),
                    rs.getString("userEmail"),
                    rs.getString("userPassword")
                );
            }

            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(StudentMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return student;
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
