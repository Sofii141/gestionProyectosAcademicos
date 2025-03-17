/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
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
 * @author USUARIO
 */
public class CompanyMariaDBRepository implements ICompanyRepository {

    @Override
    public boolean save(Company newCompany) {
    try {
        // Validar que los campos obligatorios no sean nulos o vacíos
        if (newCompany == null 
                || newCompany.getComNit().isBlank()
                || newCompany.getComName().isBlank()
                || newCompany.getComEmail().isBlank()
                || newCompany.getComContactName().isBlank()
                || newCompany.getComContactLastName().isBlank()
                || newCompany.getComContactCharge().isBlank()
                || newCompany.getComContactPhone().isBlank()) {
            return false;
        }

        this.connect();

        String sql = "INSERT INTO CompanyContact (userId, comName, comEmail, comContactPhone, comContactName, "
                   + "comContactLastName, comContactCharge, secId) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newCompany.getComNit()); // userId mapeado a comNit
        pstmt.setString(2, newCompany.getComName());
        pstmt.setString(3, newCompany.getComEmail());
        pstmt.setString(4, newCompany.getComContactPhone());
        pstmt.setString(5, newCompany.getComContactName());
        pstmt.setString(6, newCompany.getComContactLastName());
        pstmt.setString(7, newCompany.getComContactCharge());
        pstmt.setString(8, "1"); // secId desde el Sector

        pstmt.executeUpdate();

        this.disconnect();
        return true;
    } catch (SQLException ex) {
        Logger.getLogger(CompanyMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
}


    @Override
    public List<Company> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private Connection conn;

    public CompanyMariaDBRepository() {
        initDatabase();
    }

    private void initDatabase() {
        // SQL statement for creating CompanyContact table
        String sql = "CREATE TABLE IF NOT EXISTS CompanyContact (\n"
                + "    userId VARCHAR(50) NOT NULL,\n"
                + "    comName VARCHAR(100) NOT NULL,\n"
                + "    comEmail VARCHAR(100) NOT NULL,\n"
                + "    comContactPhone VARCHAR(20) NOT NULL,\n"
                + "    comContactName VARCHAR(100) NOT NULL,\n"
                + "    comContactLastName VARCHAR(100) NOT NULL,\n"
                + "    comContactCharge VARCHAR(100) NOT NULL,\n"
                + "    secId VARCHAR(50) NOT NULL,\n"
                + "    PRIMARY KEY (userId),\n"
                + "    CONSTRAINT fk_CompanyContact_User FOREIGN KEY (userId) REFERENCES User(userId),\n"
                + "    CONSTRAINT fk_CompanyContact_Sector FOREIGN KEY (secId) REFERENCES Sector(secId)\n"
                + ");";
        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CompanyMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() {
        // URL de conexión para MariaDB
        String url = "jdbc:mariadb://localhost:3306/mydatabase"; // Cambia 'mydatabase' por el nombre de tu base de datos
        String user = "root"; // Cambia 'root' por tu usuario de MariaDB
        String password = "mariadb"; // Cambia 'password' por tu contraseña de MariaDB

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(CompanyMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
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
