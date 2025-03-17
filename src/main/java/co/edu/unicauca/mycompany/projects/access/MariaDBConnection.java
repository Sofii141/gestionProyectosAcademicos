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

    protected void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Project (\n"
                + "    proId VARCHAR(50) NOT NULL,\n"
                + "    proTitle VARCHAR(100) NOT NULL,\n"
                + "    proDescription TEXT,\n"
                + "    proAbstract TEXT,\n"
                + "    proGoals TEXT,\n"
                + "    proDeadLine INT NOT NULL,\n"
                + "    proBudget FLOAT,\n"
                + "    proState VARCHAR(20) NOT NULL,"
                + "    PRIMARY KEY (proId),\n"
                + "    CONSTRAINT chk_proState CHECK (proState IN ('PROPUESTO', 'ASIGNADO', 'FINALIZADO'))\n"
                + ");";
        try {
            if (this.connect()) { // Solo continua si la conexión fue exitosa
                Statement stmt = conn.createStatement();
                stmt.execute(sql);
                this.disconnect();
            } else {
                Logger.getLogger(MariaDBConnection.class.getName()).log(Level.SEVERE, "No se pudo conectar a la base de datos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MariaDBConnection.class.getName()).log(Level.SEVERE, "Error al ejecutar initDatabase", ex);
        }
    }

    public boolean connect() {
        // URL de conexión para MariaDB
        String url = "jdbc:mariadb://localhost:3306/mydatabase"; // Cambia 'mydatabase' por el nombre de tu base de datos
        String user = "root"; // Cambia 'root' por tu usuario de MariaDB
        String password = ""; // Cambia 'password' por tu contraseña de MariaDB

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
