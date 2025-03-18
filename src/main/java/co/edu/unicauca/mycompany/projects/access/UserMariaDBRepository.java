/*
 * Clase UserMariaDBRepository
 * Implementa la interfaz IUserRepository para gestionar usuarios en una base de datos MariaDB.
 */
package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Repositorio para la gestión de usuarios en MariaDB.
 * Extiende MariaDBConnection para manejar la conexión a la base de datos.
 */
public class UserMariaDBRepository extends MariaDBConnection implements IUserRepository {

    /**
     * Constructor por defecto.
     */
    public UserMariaDBRepository() {
    }

    /**
     * Inicia sesión en la aplicación verificando las credenciales del usuario.
     *
     * @param user Usuario con el ID y la contraseña.
     * @return Un entero con el resultado de la autenticación:
     *         - 0 si las credenciales son incorrectas.
     *         - 1 si el inicio de sesión es exitoso.
     *         - -1 en caso de error.
     */
    @Override
    public int iniciarSesion(User user) {
        String sql = "SELECT login(?,?)";
        String userId = user.getUserId();
        String password = user.getUserPassword();
        try {
            if (this.connect()) { // Conectar a la base de datos
                PreparedStatement stmt = conn.prepareStatement(sql);
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
            Logger.getLogger(MariaDBConnection.class.getName()).log(Level.SEVERE, "Error al ejecutar inicio de sesión", ex);
        }
        return -1;
    }

    /**
     * Cierra la sesión del usuario.
     * Actualmente, esta operación no está soportada.
     *
     * @return Excepción no soportada.
     */
    @Override
    public boolean cerrarSesion() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /**
     * Guarda un nuevo usuario en la base de datos.
     *
     * @param newUser Usuario a registrar.
     * @return true si el usuario fue registrado exitosamente, false en caso contrario.
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
            Logger.getLogger(UserMariaDBRepository.class.getName()).log(Level.SEVERE, "Error al guardar usuario", ex);
        }
        return false;
    }

    /**
     * Verifica si un userId ya existe en la base de datos.
     *
     * @param id Identificador del usuario a verificar.
     * @return true si el ID ya existe, false si no existe o en caso de error.
     */
    @Override
    public boolean existId(String id) {
        String sql = "SELECT COUNT(*) FROM User WHERE userId = ?";

        try {
            if (this.connect()) { // Conectar a la base de datos
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, id);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt(1); // Obtener el número de coincidencias
                        return count > 0; // Si es mayor a 0, el ID ya existe
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserMariaDBRepository.class.getName()).log(Level.SEVERE, "Error al verificar existencia de userId", ex);
        } finally {
            this.disconnect(); // Asegurar la desconexión después de la consulta
        }

        return false; // En caso de error, asumimos que no existe
    }
}
