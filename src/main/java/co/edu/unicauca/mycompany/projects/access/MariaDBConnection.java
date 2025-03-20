package co.edu.unicauca.mycompany.projects.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase abstracta que maneja la conexión a una base de datos MariaDB.
 * Proporciona métodos para conectar y desconectar la base de datos.
 */
public abstract class MariaDBConnection {
    
    /**
     * Objeto Connection utilizado para gestionar la conexión con la base de datos.
     */
    protected Connection conn;
    
    /**
     * Se encarga de conectar a la base de datos MariaDB.
     * 
     * @return true si la conexión fue exitosa, false en caso contrario.
     */
    public boolean connect() {
        // URL de conexión para MariaDB
        String url = "jdbc:mariadb://localhost:3306/mydatabase"; 
        String user = "root"; 
        String password = "mariadb"; 

        try {
            conn = DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MariaDBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /**
     * Se encarga de cerrar la conexión con la base de datos.
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