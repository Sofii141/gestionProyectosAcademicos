/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author spart
 */
public class UserMariaDBRepository extends MariaDBConnection implements IUserRepository {

    public UserMariaDBRepository() {
    }
    /**
     * se encarga de verificar si se inicia sesion correctamente mediante una funcion almacenada,
     * borra el valor de password imnediatamente despues de hacer la verificación
     * @param userId el nombre de usuario
     * @param passwordCharArray la contraseña
     * @return 1:inicio Estudiante, 2:inicio coordinador, 3:inicio empresa
     */
    public int iniciarSesion(String userId, char[] passwordCharArray) {
        String sql = "SELECT login(?,?)";

        // Convertir char[] a String temporalmente
        String password = new String(passwordCharArray);

        try {
            if (this.connect()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, userId);
                stmt.setString(2, password);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int result = rs.getInt(1);
                        return result;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MariaDBConnection.class.getName()).log(Level.SEVERE, "Error al ejecutar initDatabase", ex);
        } finally {
            // Sobrescribir la contraseña para reducir el tiempo de exposición en memoria
            Arrays.fill(passwordCharArray, '\0'); // Borra el char[]
        }

        return -1;
    }

    
    /**
     * Cierra sesion
     * @return retorna el exito de la operacion 
     */
    @Override
    public boolean cerrarSesion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    /**
     * Se encarga de hacer una nueva insercion de usuario
     * @param newUser Objeto Usuario 
     * @return True: Exito de operacion, False: Fracaso de operacion
     */
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
