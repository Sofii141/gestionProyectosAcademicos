package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.ProjectState;
import co.edu.unicauca.mycompany.projects.domain.entities.Sector;
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
 * @author paula
 */
public class CompanyMariaDBRepository implements ICompanyRepository {
    private Connection conn;

    public CompanyMariaDBRepository() {
        initDatabase();
    }

    @Override
    public boolean save(Company newCompany) {
        String sql = "INSERT INTO CompanyContact (userId, comName, comEmail, comContactPhone, comContactName, "
                + "comContactLastName, comContactCharge, secId) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int rowsAffected;
        try {
            this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, newCompany.getCompanyNit());
            pstmt.setString(2, newCompany.getCompanyName());
            pstmt.setString(3, newCompany.getCompanyEmail());
            pstmt.setString(4, newCompany.getContactPhone());
            pstmt.setString(5, newCompany.getContactName());
            pstmt.setString(6, newCompany.getContactLastName());
            pstmt.setString(7, newCompany.getContactPosition());
            pstmt.setString(8, newCompany.getCompanySector().toString());

            rowsAffected = pstmt.executeUpdate();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            disconnect();
        }

        return rowsAffected > 0;
    }

    @Override
    public List<Company> listAll() {
        List<Company> companies = new ArrayList<>();
        String sql = "SELECT userId, comName, comEmail, comContactPhone, comContactName, "
                   + "comContactLastName, comContactCharge, secId FROM CompanyContact";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Company company = new Company(
                    rs.getString("userId"),
                    rs.getString("comName"),
                    rs.getString("comEmail"),
                    rs.getString("comContactPhone"),
                    rs.getString("comContactName"),
                    rs.getString("comContactLastName"),
                    rs.getString("comContactCharge"),
                    Sector.valueOf(rs.getString("secId"))
                );
                companies.add(company);
            }

            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return companies;
    }

    private void initDatabase() {
        // SQL statement for creating the CompanyContact table
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
        } finally {
            disconnect();
        }
    }

    @Override
    public boolean existsNit(String nit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Company companyInfo(String nit) {
        this.connect();
        String sql = "SELECT cc.userId, cc.comName, cc.comEmail, cc.comContactPhone, cc.comContactName, "
               + "cc.comContactLastName, cc.comContactCharge, s.secName "
               + "FROM CompanyContact cc "
               + "JOIN Sector s ON cc.secId = s.secId "
               + "WHERE cc.userId = ?";
        Company company = null;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nit);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                company = new Company(
                    rs.getString("userId"),
                    rs.getString("comName"),
                    rs.getString("comEmail"),
                    rs.getString("comContactPhone"),
                    rs.getString("comContactName"),
                    rs.getString("comContactLastName"),
                    rs.getString("comContactCharge"),
                    Sector.valueOf(rs.getString("secName"))
                );
            }
        } catch (SQLException e) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, "Error al obtener los datos.", e);
        } finally {
            disconnect();
        }
        return company;
    }
    
    public void connect() {
        // URL de conexión para MariaDB
        String url = "jdbc:mariadb://localhost:3306/mydatabase"; // Cambia 'mydatabase' por el nombre de tu base de datos
        String user = "root"; // Cambia 'root' por tu usuario de MariaDB
        String password = "mariadb"; // Cambia 'password' por tu contraseña de MariaDB

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
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
