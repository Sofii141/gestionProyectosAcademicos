/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.enumSector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class CompanyMariaDBRepository extends MariaDBConnection implements ICompanyRepository {


    public CompanyMariaDBRepository() {
        initDatabase();
    }

    @Override
    public boolean save(Company newCompany) {
        try {
            // Validar que los campos obligatorios no sean nulos o vacíos
            if (newCompany == null
                    || newCompany.getUserId().isBlank()
                    || newCompany.getCompanyName().isBlank()
                    || newCompany.getUserEmail().isBlank()
                    || newCompany.getContactName().isBlank()
                    || newCompany.getContactLastName().isBlank()
                    || newCompany.getContactPosition().isBlank()
                    || newCompany.getContactPhone().isBlank()) {
                return false;
            }

            this.connect();

            String sql = "INSERT INTO CompanyContact (userId, comName, comEmail, comContactPhone, comContactName, "
                    + "comContactLastName, comContactCharge, secId) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newCompany.getUserId());
            pstmt.setString(2, newCompany.getCompanyName());
            pstmt.setString(3, newCompany.getUserEmail());
            pstmt.setString(4, newCompany.getContactPhone());
            pstmt.setString(5, newCompany.getContactName());
            pstmt.setString(6, newCompany.getContactLastName());
            pstmt.setString(7, newCompany.getContactPosition());
            pstmt.setString(8, "1"); // secId desde el Sector

            pstmt.executeUpdate();

            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CompanyMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Método companyInfo de la rama master (manteniendo compatibilidad con Diego)
    private void initDatabase() {
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

    @Override
    public List<Company> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existsNit(String nit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Company companyInfo(String nit) {
        // Consulta SQL
        String sql = "SELECT cc.userId, cc.comName, cc.comContactPhone, cc.comContactName, "
                + "cc.comContactLastName, cc.comContactCharge, s.secName, u.userEmail "
                + "FROM CompanyContact cc "
                + "JOIN Sector s ON cc.secId = s.secId "
                + "JOIN User u ON u.userId = cc.userId "
                + "WHERE cc.userId = ?";

        // Compañia a retornar
        Company company = null;

        try {
            // Establecer conexión con la base de datos
            this.connect();

            // Objeto para ejecutar consultas con parametros
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Asignar valores a la consulta preparada
            stmt.setString(1, nit);

            // Ejecutar la consulta
            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los resultados y crear el objeto objeto Company
            if (rs.next()) {
                company = new Company(
                        rs.getString("comName"),
                        rs.getString("comContactName"),
                        rs.getString("comContactLastName"),
                        rs.getString("comContactPhone"),
                        rs.getString("comContactCharge"),
                        enumSector.valueOf(rs.getString("secName")),
                        rs.getString("userId"),
                        rs.getString("userEmail"),
                        null // No return password
                );
            }
        } catch (SQLException e) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, "Error al obtener los datos.", e);
        } finally {
            disconnect();
        }
        return company;
    }
}
