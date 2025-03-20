package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.enumSector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa el repositorio de empresas utilizando MariaDB. Extiende
 * la clase de conexión a la base de datos MariaDBConnection.
 */
public class CompanyMariaDBRepository extends MariaDBConnection implements ICompanyRepository {

    /**
     * Constructor de la clase.
     */
    public CompanyMariaDBRepository() {
    }

    /**
     * Guarda una nueva empresa en la base de datos.
     *
     * @param newCompany Objeto que representa la empresa a guardar.
     * @return Verdadero si la empresa se guardó correctamente, falso en caso
     * contrario.
     */
    @Override
    public boolean save(Company newCompany) {
        try {
            // Validar que los campos obligatorios no sean nulos o vacíos
            if (newCompany == null
                    || newCompany.getUserId().isBlank()
                    || newCompany.getCompanyName().isBlank()
                    || newCompany.getContactName().isBlank()
                    || newCompany.getContactLastName().isBlank()
                    || newCompany.getContactPosition().isBlank()
                    || newCompany.getContactPhone().isBlank()) {
                return false;
            }

            this.connect();

            String sql = "INSERT INTO CompanyContact (userId, comName, comContactPhone, comContactName, "
                    + "comContactLastName, comContactCharge, secId) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newCompany.getUserId());
            pstmt.setString(2, newCompany.getCompanyName());
            pstmt.setString(3, newCompany.getContactPhone());
            pstmt.setString(4, newCompany.getContactName());
            pstmt.setString(5, newCompany.getContactLastName());
            pstmt.setString(6, newCompany.getContactPosition());
            pstmt.setString(7, getSectorIdByName(newCompany.getCompanySector().toString()));

            pstmt.executeUpdate();

            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CompanyMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Obtiene la información de una empresa según su identificador.
     *
     * @param nit Identificador único de la empresa.
     * @return Objeto que representa la empresa encontrada o null si no existe.
     */
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

    /**
     * Obtiene el identificador único de un sector según su nombre.
     *
     * @param sectorName Nombre del sector a buscar.
     * @return Identificador único del sector si existe, de lo contrario retorna
     * null.
     */
    @Override
    public String getSectorIdByName(String sectorName) {
        String sql = "SELECT secId FROM Sector WHERE secName = ?";
        String sectorId = null;

        try {
            this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sectorName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                sectorId = rs.getString("secId");
            }

            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyMariaDBRepository.class.getName()).log(Level.SEVERE, "Error al obtener secId del sector", ex);
        }
        return sectorId;
    }

}
