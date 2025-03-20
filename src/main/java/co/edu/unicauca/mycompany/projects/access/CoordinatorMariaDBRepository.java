package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Coordinator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que maneja la persistencia de los coordinadores en la base de datos MariaDB.
 * Implementa la interfaz ICoordinatorRepository y extiende MariaDBConnection.
 */
public class CoordinatorMariaDBRepository extends MariaDBConnection implements ICoordinatorRepository {

    /**
     * Constructor por defecto.
     */
    public CoordinatorMariaDBRepository() {
    }

    /**
     * Guarda un nuevo coordinador en la base de datos.
     * 
     * @param newCoordinator El objeto Coordinator a guardar.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    @Override
    public boolean save(Coordinator newCoordinator) {
        String sqlUser = "INSERT INTO User (userId, userEmail, userPassword) VALUES (?, ?, ?)";
        String sqlCoordinator = "INSERT INTO Coordinator (userId) VALUES (?)";
        int rowsAffected = 0;
        try {
            this.connect();
            conn.setAutoCommit(false);
            PreparedStatement pstmtUser = conn.prepareStatement(sqlUser);
            pstmtUser.setString(1, newCoordinator.getUserId());
            pstmtUser.setString(2, newCoordinator.getUserEmail());
            pstmtUser.setString(3, newCoordinator.getUserPassword());
            rowsAffected += pstmtUser.executeUpdate();
            PreparedStatement pstmtCoordinator = conn.prepareStatement(sqlCoordinator);
            pstmtCoordinator.setString(1, newCoordinator.getUserId());
            rowsAffected += pstmtCoordinator.executeUpdate();
            conn.commit();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CoordinatorMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.rollback();
            } catch (SQLException rollbackEx) {
                Logger.getLogger(CoordinatorMariaDBRepository.class.getName()).log(Level.SEVERE, null, rollbackEx);
            }
            return false;
        } finally {
            disconnect();
        }
        return rowsAffected > 0;
    }

    /**
     * Lista todos los coordinadores almacenados en la base de datos.
     * 
     * @return Lista de objetos Coordinator.
     */
    @Override
    public List<Coordinator> listAll() {
        List<Coordinator> coordinators = new ArrayList<>();
        String sql = "SELECT User.userId, userEmail, userPassword FROM User "
                   + "JOIN Coordinator ON User.userId = Coordinator.userId";
        try {
            this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Coordinator coordinator = new Coordinator(
                    rs.getString("userId"),
                    rs.getString("userEmail"),
                    rs.getString("userPassword")
                );
                coordinators.add(coordinator);
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CoordinatorMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return coordinators;
    }

    /**
     * Obtiene un coordinador específico basado en su ID de usuario.
     * 
     * @param userId El ID del usuario a buscar.
     * @return Un objeto Coordinator si se encuentra, null en caso contrario.
     */
    @Override
    public Coordinator getCoordinator(String userId) {
        Coordinator coordinator = null;
        String sql = "SELECT User.userId, userEmail, userPassword FROM User "
                   + "JOIN Coordinator ON User.userId = Coordinator.userId "
                   + "WHERE User.userId = ?";
        try {
            this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                coordinator = new Coordinator(
                    rs.getString("userId"),
                    rs.getString("userEmail"),
                    rs.getString("userPassword")
                );
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CoordinatorMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return coordinator;
    }
}
