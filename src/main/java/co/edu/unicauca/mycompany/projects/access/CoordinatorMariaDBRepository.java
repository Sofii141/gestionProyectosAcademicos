/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Coordinator;
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
 * @author Ana_Sofia
 */
public class CoordinatorMariaDBRepository extends MariaDBConnection implements ICoordinatorRepository{


    public CoordinatorMariaDBRepository() {
    }


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
