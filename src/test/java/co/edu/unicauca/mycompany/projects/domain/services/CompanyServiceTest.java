package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.enumSector;
import co.edu.unicauca.mycompany.projects.infra.ValidationException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 * Pruebas unitarias para la clase {@code CompanyService}.
 *
 * Se utilizan mocks para simular el comportamiento del repositorio
 * {@code ICompanyRepository}, permitiendo probar la lógica del servicio sin
 * depender de una base de datos real.
 */
public class CompanyServiceTest {

    /**
     * Mock de {@code ICompanyRepository} utilizado para simular el acceso a
     * datos.
     */
    @Mock
    private ICompanyRepository repositoryMock;

    /**
     * Instancia de {@code CompanyService} que se probará.
     */
    private CompanyService companyService;

    /**
     * Configuración inicial antes de cada prueba. Se inicializan los mocks y se
     * inyectan en {@code CompanyService}.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
        companyService = new CompanyService(repositoryMock); // Inyección del mock en el servicio
    }

    /**
     * Prueba el método {@code getAllCompanies()} de {@code CompanyService}.
     *
     * Se verifica que el método devuelva una lista con las empresas registradas
     * en el repositorio.
     */
    @Test
    void testGetAllCompanies() {
        Company company1 = mock(Company.class);
        Company company2 = mock(Company.class);
        List<Company> companies = Arrays.asList(company1, company2);

        when(repositoryMock.listAll()).thenReturn(companies);

        List<Company> result = companyService.getAllCompanies();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(repositoryMock, times(1)).listAll();
    }

    /**
     * Prueba el método {@code getCompany()} cuando la empresa existe.
     *
     * Se verifica que el servicio retorne la empresa correcta al buscar por su
     * ID.
     */
    @Test
    void testGetCompanyExists() {
        Company company = mock(Company.class);
        when(repositoryMock.companyInfo("12345")).thenReturn(company);

        Company result = companyService.getCompany("12345");

        assertNotNull(result);
        verify(repositoryMock, times(1)).companyInfo("12345");
    }

    /**
     * Prueba el método {@code getCompany()} cuando la empresa no existe.
     *
     * Se verifica que el servicio retorne {@code null} si la empresa no se
     * encuentra en el repositorio.
     */
    @Test
    void testGetCompanyNotExists() {
        when(repositoryMock.companyInfo("99999")).thenReturn(null);

        Company result = companyService.getCompany("99999");

        assertNull(result);
        verify(repositoryMock, times(1)).companyInfo("99999");
    }

    /**
     * Prueba el método {@code saveCompany()}.
     *
     * Se verifica que una empresa se pueda guardar correctamente en el
     * repositorio.
     */
    @Test
    void testSaveCompany() {
        Company company = mock(Company.class);
        when(repositoryMock.save(company)).thenReturn(true);

        boolean result = companyService.saveCompany(company);

        assertTrue(result);
        verify(repositoryMock, times(1)).save(company);
    }

    /**
     * Prueba la validación de datos con una empresa válida.
     *
     * Se verifica que el método {@code validData()} retorne {@code true} cuando
     * la empresa tiene datos correctos.
     */
    @Test
    void validDataTest() throws Exception {
        Company validCompany = new Company(
                "Empresa", "ContactoNombre", "ContactoApellido",
                "3121234567", "ContactoCargo", enumSector.OTHER,
                "123", "prueba@gmail.com", "Pass_word1"
        );

        boolean result = companyService.validData(validCompany);

        assertTrue(result);
    }

    /**
     * Prueba la validación de datos con una empresa inválida.
     *
     * Se verifica que el método {@code validData()} lance una excepción cuando
     * la empresa tiene datos vacíos o inválidos.
     */
    @Test
    void invalidDataTest() {
        Company invalidCompany = new Company("", "", "", "", "", enumSector.OTHER, "", "", "");

        Exception exception = assertThrows(ValidationException.class, () -> {
            companyService.validData(invalidCompany);
        });

        assertNotNull(exception);
    }
}
