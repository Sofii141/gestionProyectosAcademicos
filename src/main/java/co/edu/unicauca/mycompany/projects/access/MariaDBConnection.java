/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author spart
 */
public abstract class MariaDBConnection {
    
    protected Connection conn;

    public boolean connect() {
        // URL de conexión para MariaDB
        String url = "jdbc:mariadb://localhost:3306/mydatabase"; // Cambia 'mydatabase' por el nombre de tu base de datos
        String user = "root"; // Cambia 'root' por tu usuario de MariaDB
        String password = "mariadb"; // Cambia 'password' por tu contraseña de MariaDB

        try {
            conn = DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MariaDBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
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
