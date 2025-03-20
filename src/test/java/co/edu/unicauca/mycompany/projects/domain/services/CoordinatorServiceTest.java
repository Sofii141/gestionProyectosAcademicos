package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.ICoordinatorRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Coordinator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Pruebas unitarias para la clase CoordinatorService.
 */
public class CoordinatorServiceTest {
    
    /**
     * Test para verificar que el constructor inicializa correctamente el servicio con un repositorio válido.
     */
    @Test
    public void testConstructor() {
        ICoordinatorRepository mockRepository = mock(ICoordinatorRepository.class);
        CoordinatorService service = new CoordinatorService(mockRepository);
        assertNotNull(service, "El servicio no debería ser null después de la inicialización");
    }

    /**
     * Test para verificar que getCoordinator devuelve un coordinador existente.
     */
    @Test
    public void testGetCoordinatorExisting() {
        // Crear un repositorio mock
        ICoordinatorRepository mockRepository = mock(ICoordinatorRepository.class);
        Coordinator expectedCoordinator = new Coordinator("C001", "coordinator@email.com", "securePass");

        // Definir comportamiento del mock
        when(mockRepository.getCoordinator("C001")).thenReturn(expectedCoordinator);

        // Crear servicio con el mock
        CoordinatorService service = new CoordinatorService(mockRepository);
        Coordinator result = service.getCoordinator("C001");

        // Verificar que el resultado es el esperado
        assertNotNull(result, "El coordinador no debería ser null");
        assertEquals("C001", result.getUserId(), "El ID del coordinador no coincide");
        assertEquals("coordinator@email.com", result.getUserEmail(), "El email del coordinador no coincide");
        
        // Verificar que se llamó al método del repositorio exactamente una vez
        verify(mockRepository, times(1)).getCoordinator("C001");
    }

    /**
     * Test para verificar que getCoordinator devuelve null cuando el coordinador no existe.
     */
    @Test
    public void testGetCoordinatorNotFound() {
        // Crear un repositorio mock
        ICoordinatorRepository mockRepository = mock(ICoordinatorRepository.class);

        // Definir comportamiento del mock
        when(mockRepository.getCoordinator("C999")).thenReturn(null);

        // Crear servicio con el mock
        CoordinatorService service = new CoordinatorService(mockRepository);
        Coordinator result = service.getCoordinator("C999");

        // Verificar que el resultado es null
        assertNull(result, "Cuando el coordinador no existe, el resultado debería ser null");
        
        // Verificar que se llamó al método del repositorio exactamente una vez
        verify(mockRepository, times(1)).getCoordinator("C999");
    }

    /**
     * Test para verificar que getCoordinator maneja un ID nulo correctamente.
     */
    @Test
    public void testGetCoordinatorWithNullId() {
        // Crear un repositorio mock
        ICoordinatorRepository mockRepository = mock(ICoordinatorRepository.class);

        // Definir comportamiento del mock
        when(mockRepository.getCoordinator(null)).thenReturn(null);

        // Crear servicio con el mock
        CoordinatorService service = new CoordinatorService(mockRepository);
        Coordinator result = service.getCoordinator(null);

        // Verificar que el resultado es null
        assertNull(result, "Cuando el ID es null, el resultado debería ser null");
    }
    
    /**
     * Test para verificar que getCoordinator maneja un ID vacío correctamente.
     */
    @Test
    public void testGetCoordinatorWithEmptyId() {
        // Crear un repositorio mock
        ICoordinatorRepository mockRepository = mock(ICoordinatorRepository.class);

        // Definir comportamiento del mock
        when(mockRepository.getCoordinator("")).thenReturn(null);

        // Crear servicio con el mock
        CoordinatorService service = new CoordinatorService(mockRepository);
        Coordinator result = service.getCoordinator("");

        // Verificar que el resultado es null
        assertNull(result, "Cuando el ID está vacío, el resultado debería ser null");
    }

    /**
     * Test para verificar que getCoordinator maneja un ID con espacios correctamente.
     */
    @Test
    public void testGetCoordinatorWithSpaces() {
        // Crear un repositorio mock
        ICoordinatorRepository mockRepository = mock(ICoordinatorRepository.class);

        // Definir comportamiento del mock
        when(mockRepository.getCoordinator("   ")).thenReturn(null);

        // Crear servicio con el mock
        CoordinatorService service = new CoordinatorService(mockRepository);
        Coordinator result = service.getCoordinator("   ");

        // Verificar que el resultado es null
        assertNull(result, "Cuando el ID contiene solo espacios, el resultado debería ser null");
    }

    /**
     * Test para verificar que getCoordinator maneja IDs con diferentes capitalizaciones.
     */
    @Test
    public void testGetCoordinatorCaseInsensitive() {
        // Crear un repositorio mock
        ICoordinatorRepository mockRepository = mock(ICoordinatorRepository.class);
        Coordinator expectedCoordinator = new Coordinator("C001", "coordinator@email.com", "securePass");

        // Definir comportamiento del mock
        when(mockRepository.getCoordinator("c001")).thenReturn(expectedCoordinator);

        // Crear servicio con el mock
        CoordinatorService service = new CoordinatorService(mockRepository);
        Coordinator result = service.getCoordinator("c001");

        // Verificar que el resultado es el esperado
        assertNotNull(result, "El coordinador no debería ser null");
        assertEquals("C001", result.getUserId(), "El ID del coordinador debería coincidir sin importar mayúsculas o minúsculas");
    }
}

