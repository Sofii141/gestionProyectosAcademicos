package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Sector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return false;
    }

    @Override
    public List<Company> listAll() {
        List<Company> companies = new ArrayList<>();
        return companies;
    }

    private void initDatabase() {
    }

    @Override
    public boolean existsNit(String nit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Company companyInfo(String nit) {
        this.connect();
        String sql = "SELECT cc.userId, cc.comName, cc.comEmail, cc.comPhone, cc.comContactName, " +
                     "cc.comContactLastName, cc.comContactCharge, s.secName " +
                     "FROM CompanyContact cc " +
                     "JOIN Sector s ON cc.secId = s.secId " +
                     "WHERE cc.userId = ?";
        Company company = null;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nit);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                company = new Company(
                    rs.getString("userId"),
                    rs.getString("comName"),
                    rs.getString("comEmail"),
                    rs.getString("comPhone"),
                    rs.getString("comContactName"),
                    rs.getString("comContactLastName"),
                    rs.getString("comContactCharge"),
                    Sector.fromString(rs.getString("secName")) 
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
