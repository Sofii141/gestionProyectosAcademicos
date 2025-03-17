package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
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
 * Implementación de ICompanyRepository para la gestión de compañías en MariaDB.
 * Proporciona métodos para insertar, listar y obtener información de compañías,
 * así como la gestión de la conexión con la base de datos.
 * 
 */
public class CompanyMariaDBRepository extends MariaDBConnection implements ICompanyRepository{
    
    /**
     * Constructor de la clase. Inicializa la base de datos.
     */
    public CompanyMariaDBRepository() {
    }
    
    /**
     * Guarda una nueva compañía en la base de datos.
     * 
     * @param newCompany Objeto de tipo Company con la información a almacenar.
     * @return true si la inserción fue exitosa, false en caso contrario.
     */
    @Override
    public boolean save(Company newCompany) {
        // Consulta SQL
        String sql = "INSERT INTO CompanyContact (userId, comName, comEmail, comContactPhone, comContactName, "
                + "comContactLastName, comContactCharge, secId) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int rowsAffected;
        try {
            // Establecer conexión con la base de datos
            this.connect();
            
            // Objeto para ejecutar consultas con parametros
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // Asignar valores a la consulta preparada
            pstmt.setString(1, newCompany.getCompanyNit());
            pstmt.setString(2, newCompany.getCompanyName());
            pstmt.setString(3, newCompany.getCompanyEmail());
            pstmt.setString(4, newCompany.getContactPhone());
            pstmt.setString(5, newCompany.getContactName());
            pstmt.setString(6, newCompany.getContactLastName());
            pstmt.setString(7, newCompany.getContactPosition());
            pstmt.setString(8, newCompany.getCompanySector().toString());
            
            // Ejecutar la inserción
            rowsAffected = pstmt.executeUpdate();
            
            // Cerrar la conexión
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            disconnect();
        }
        
        return rowsAffected > 0;
    }
    
    /**
     * Obtiene una lista con todas las compañías almacenadas en la base de datos.
     * 
     * @return Lista de objetos Company con la información de las compañías.
     */
    @Override
    public List<Company> listAll() {
        // Lista de todas las compañias de la base de datos
        List<Company> companies = new ArrayList<>();
        
        // Consulta SQL
        String sql = "SELECT userId, comName, comEmail, comContactPhone, comContactName, "
                   + "comContactLastName, comContactCharge, secId FROM CompanyContact";
        try {
            // Establecer conexión con la base de datos
            this.connect();
            
            // Objeto para ejecutar consultas sin parametros
            Statement stmt = conn.createStatement();
            
            // Ejecutar la consulta
            ResultSet rs = stmt.executeQuery(sql);
            
            // Iterar sobre los resultados y crear objetos Company
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
            // Cerrar conexión con la base de datos
            this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(CompanyMariaDBRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return companies;
    }
    

    
    /**
     * Verifica si una compañía con el NIT especificado existe en la base de datos.
     * 
     * @param nit Número de identificación tributaria de la compañía.
     * @return true si la compañía existe, false en caso contrario.
     */
    @Override
    public boolean existsNit(String nit) {
        return true;
    }
    
    /**
     * Obtiene la información de una compañía específica a partir de su NIT.
     * 
     * @param nit Número de identificación tributaria de la compañía.
     * @return Objeto Company con la información de la compañía si existe, null en caso contrario.
     */
    @Override
    public Company companyInfo(String nit) {
        // Consulta SQL
        String sql = "SELECT cc.userId, cc.comName, cc.comEmail, cc.comContactPhone, cc.comContactName, "
               + "cc.comContactLastName, cc.comContactCharge, s.secName "
               + "FROM CompanyContact cc "
               + "JOIN Sector s ON cc.secId = s.secId "
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
}
