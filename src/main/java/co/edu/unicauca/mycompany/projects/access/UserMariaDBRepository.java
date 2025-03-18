/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author spart
 */
public class UserMariaDBRepository extends MariaDBConnection implements IUserRepository {

    public UserMariaDBRepository() {
    }

    @Override
    public int iniciarSesion(User user) {
        String sql = "SELECT login(?,?)";
        String userId = user.getUserId();
        String password = user.getUserPassword();
        try {
            if (this.connect()) { // Solo continua si la conexión fue exitosa
                PreparedStatement stmt = conn.prepareStatement(sql);
                // Pasar parámetros a la función
                stmt.setString(1, userId);
                stmt.setString(2, password);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int result = rs.getInt(1); // Obtener el resultado de la función
                        return result;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MariaDBConnection.class.getName()).log(Level.SEVERE, "Error al ejecutar initDatabase", ex);
        }
        return -1;
    }
    

    @Override
    public boolean cerrarSesion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean save(User newUser) {
        try {
            // Validar que los campos obligatorios no sean nulos o vacíos
            if (newUser == null
                    || newUser.getUserId().isBlank()
                    || newUser.getUserEmail().isBlank()
                    || newUser.getUserPassword().isBlank()) {
                return false;
            }

            this.connect();

            String sql = "INSERT INTO User (userId, userEmail, userPassword) VALUES (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getUserId());
            pstmt.setString(2, newUser.getUserEmail());
            pstmt.setString(3, newUser.getUserPassword());

            pstmt.executeUpdate();

            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
