package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Sector;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;

import static org.mockito.Mockito.*; 
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Libardo, Julio
 */
public class CompanyServiceTest {
    /**
     * Para hacer pruebas unitarias de la clase CompanyService, podemos usar 
     * Mockito para simular (mock) el comportamiento del ICompanyRepository.
     */
    @Mock
    private ICompanyRepository repositoryMock;
    
    private CompanyService companyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // IMPORTANTE: Inicializa los mocks
        companyService = new CompanyService(repositoryMock); // Inyección del mock
    }

    @Test
    void testGetAllCompanies() {
        // Simulación de datos
        List<Company> companies = Arrays.asList(
            new Company("123456", "Empresa A","3434343", "www.mipagina1.com", Sector.SERVICES, "gerente1@gmail.com", "123"),
            new Company("123457", "Empresa B","3434344", "www.mipagina2.com", Sector.SERVICES, "gerente2@gmail.com", "123"),
            new Company("123458", "Empresa C","3434345", "www.mipagina3.com", Sector.SERVICES, "gerente3@gmail.com", "123")

        );

                
        when(repositoryMock.listAll()).thenReturn(companies);

        // Llamado al método
        List<Company> result = companyService.getAllCompanies();

        // Verificación
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Empresa A", result.get(0).getName());
        assertEquals("Empresa B", result.get(1).getName());

        // Verifica que listAll() fue llamado una vez
        verify(repositoryMock, times(1)).listAll();
    }

    @Test
    void testSaveCompany_Success() {
        Company newCompany = new Company("123459", "Empresa D","3434345", "www.mipagina4.com", Sector.SERVICES, "gerente4@gmail.com", "123");

        when(repositoryMock.save(newCompany)).thenReturn(true); // Simula éxito

        boolean result = companyService.saveCompany(newCompany);

        assertTrue(result);
        verify(repositoryMock, times(1)).save(newCompany);
    }

    @Test
    void testSaveCompany_Failure() {
        Company newCompany = new Company("123459", "Empresa D","3434345", "www.mipagina4.com", Sector.SERVICES, "gerente4@gmail.com", "123");

        when(repositoryMock.save(newCompany)).thenReturn(false); // Simula fallo

        boolean result = companyService.saveCompany(newCompany);

        assertFalse(result);
        verify(repositoryMock, times(1)).save(newCompany);
    }

}
