package co.edu.unicauca.mycompany.projects.domain.entities;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Libardo, Julio
 */
public class CompanyTest {

    @Test
    void testCompanyConstructorAndGetters() {
        Company company = new Company(
                "123456789",
                "Tech Solutions",
                "555-1234",
                "www.techsolutions.com",
                Sector.TECHNOLOGY,
                "contact@techsolutions.com",
                "securepassword"
        );

        assertThat(company.getNit()).isEqualTo("123456789");
        assertThat(company.getName()).isEqualTo("Tech Solutions");
        assertThat(company.getPhone()).isEqualTo("555-1234");
        assertThat(company.getPageWeb()).isEqualTo("www.techsolutions.com");
        assertThat(company.getSector()).isEqualTo(Sector.TECHNOLOGY);
        assertThat(company.getEmail()).isEqualTo("contact@techsolutions.com");
        assertThat(company.getPassword()).isEqualTo("securepassword");
    }

    @Test
    void testSetters() {
        Company company = new Company("", "", "", "", Sector.OTHER, "", "");

        company.setNit("987654321");
        company.setName("Health Corp");
        company.setPhone("555-5678");
        company.setPageWeb("www.healthcorp.com");
        company.setSector(Sector.HEALTH);
        company.setEmail("info@healthcorp.com");
        company.setPassword("newpassword");

        assertThat(company.getNit()).isEqualTo("987654321");
        assertThat(company.getName()).isEqualTo("Health Corp");
        assertThat(company.getPhone()).isEqualTo("555-5678");
        assertThat(company.getPageWeb()).isEqualTo("www.healthcorp.com");
        assertThat(company.getSector()).isEqualTo(Sector.HEALTH);
        assertThat(company.getEmail()).isEqualTo("info@healthcorp.com");
        assertThat(company.getPassword()).isEqualTo("newpassword");
    }

}
