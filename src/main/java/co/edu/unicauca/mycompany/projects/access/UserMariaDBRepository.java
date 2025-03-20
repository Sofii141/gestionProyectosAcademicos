package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
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
     * se encarga de verificar si se inicia sesion correctamente mediante una funcion almacenada,
     * borra el valor de password imnediatamente despues de hacer la verificación
     * @param userId el nombre de usuario
     * @param passwordCharArray la contraseña
     * @return 1:inicio Estudiante, 2:inicio coordinador, 3:inicio empresa
     */
    @Override
    public int iniciarSesion(String userId, char[] passwordCharArray) {
        String sql = "SELECT login(?,?)";

        // Convertir char[] a String temporalmente
        String password = new String(passwordCharArray);

        try {

            if (this.connect()) { // Conectar a la base de datos
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

            // Insertar usuario en la tabla User
            String sqlUser = "INSERT INTO User (userId, userEmail, userPassword) VALUES (?, ?, ?)";
            PreparedStatement pstmtUser = conn.prepareStatement(sqlUser);
            pstmtUser.setString(1, newUser.getUserId());
            pstmtUser.setString(2, newUser.getUserEmail());
            pstmtUser.setString(3, newUser.getUserPassword());
            pstmtUser.executeUpdate();

            // Insertar rol en la tabla Rol
            String sqlRol = "INSERT INTO Rol (userId, rolName) VALUES (?, ?)";
            PreparedStatement pstmtRol = conn.prepareStatement(sqlRol);
            pstmtRol.setString(1, newUser.getUserId());
            pstmtRol.setString(2, "CONTACTO EMPRESA");
            pstmtRol.executeUpdate();

            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserMariaDBRepository.class.getName()).log(Level.SEVERE, "Error al guardar usuario y rol", ex);
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
