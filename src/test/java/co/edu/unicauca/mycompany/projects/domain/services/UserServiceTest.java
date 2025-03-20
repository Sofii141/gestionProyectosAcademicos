/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.IUserRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.User;
import co.edu.unicauca.mycompany.projects.infra.ValidationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author spart
 */
public class UserServiceTest {

    @Mock
    private IUserRepository repositoryMock;

    private UserService userService;

    public UserServiceTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // IMPORTANTE: Inicializa los mocks
        userService = new UserService(repositoryMock); // Inyección del mock
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test para verificar un inicio de sesion de estudiante
     */
    @Test
    public void iniciarSesionEstudianteTest() {
        String userName = "user1";
        char[] pwd = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        //Simula que el repositorio encontro ese usuario como estudiante
        when(repositoryMock.iniciarSesion(userName, pwd)).thenReturn(1);

        //Llama al metodo iniciar sesion
        int result = userService.iniciarSesion(userName, pwd);
        assertNotNull(result);
        assertEquals(1, result);
        verify(repositoryMock, times(1)).iniciarSesion(userName, pwd);
    }

    /**
     * Test para verificar un inicio de sesion de coordinador
     */
    @Test
    void iniciarSesionCoordinadorTest() {
        String userName = "coordinator1";
        char[] pwd = {'c', 'o', 'o', 'r', 'd', 'p', 'a', 's', 's'};

        when(repositoryMock.iniciarSesion(userName, pwd)).thenReturn(2);

        int result = userService.iniciarSesion(userName, pwd);

        assertNotNull(result);
        assertEquals(2, result);
        verify(repositoryMock, times(1)).iniciarSesion(userName, pwd);
    }

    /**
     * Test para verificar un inicio de sesion de empresa
     */
    @Test
    void iniciarSesionEmpresaTest() {
        String userName = "company1";
        char[] pwd = {'c', 'o', 'm', 'p', 'a', 's', 's'};

        when(repositoryMock.iniciarSesion(userName, pwd)).thenReturn(3);

        int result = userService.iniciarSesion(userName, pwd);

        assertNotNull(result);
        assertEquals(3, result);
        verify(repositoryMock, times(1)).iniciarSesion(userName, pwd);
    }

    /**
     * Test para verificar un inicio de sesion incorrecto
     */
    @Test
    void iniciarSesionCredencialesIncorrectasTest() {
        String userName = "wrongUser";
        char[] pwd = {'w', 'r', 'o', 'n', 'g', 'p', 'a', 's', 's'};

        when(repositoryMock.iniciarSesion(userName, pwd)).thenReturn(0);

        int result = userService.iniciarSesion(userName, pwd);

        assertNotNull(result);
        assertEquals(0, result);
        verify(repositoryMock, times(1)).iniciarSesion(userName, pwd);
    }

    /**
     * Test para verificar que un usuario se guarda correctamente en el sistema.
     */
    @Test
    void saveUserTest() {
        User newUser = new User("12345", "user@email.com", "Pass@123");

        when(repositoryMock.save(newUser)).thenReturn(true);

        boolean result = userService.saveUser(newUser);

        assertTrue(result);
        verify(repositoryMock, times(1)).save(newUser);
    }

    /**
     * Test para verificar cuando el guardado del usuario falla.
     */
    @Test
    void saveUserFailTest() {
        User newUser = new User("12345", "user@email.com", "Pass@123");

        when(repositoryMock.save(newUser)).thenReturn(false);

        boolean result = userService.saveUser(newUser);

        assertFalse(result);
        verify(repositoryMock, times(1)).save(newUser);
    }

    /**
     * Test para verificar si un usuario con un ID específico existe en la base
     * de datos.
     */
    @Test
    void existUserIdTest() {
        String userId = "12345";

        when(repositoryMock.existId(userId)).thenReturn(true);

        boolean result = userService.existUserId(userId);

        assertTrue(result);
        verify(repositoryMock, times(1)).existId(userId);
    }

    /**
     * Test para verificar cuando un usuario no existe en la base de datos.
     */
    @Test
    void existUserIdNotFoundTest() {
        String userId = "54321";

        when(repositoryMock.existId(userId)).thenReturn(false);

        boolean result = userService.existUserId(userId);

        assertFalse(result);
        verify(repositoryMock, times(1)).existId(userId);
    }

    /**
     * Test para verificar la validación de datos con un usuario válido.
     */
    @Test
    void validDataTest() throws Exception {
        User validUser = new User("12345", "user@email.com", "Pass@123");

        boolean result = userService.validData(validUser);

        assertTrue(result);
    }

    /**
     * Test para verificar la validación de datos cuando el usuario tiene datos
     * incorrectos.
     */
    @Test
    void invalidDataTest() {
        User invalidUser = new User("", "invalid-email", "123");

        Exception exception = assertThrows(ValidationException.class, () -> {
            userService.validData(invalidUser);
        });

        assertNotNull(exception);
    }
}
