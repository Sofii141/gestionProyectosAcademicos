package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.domain.services.UserService;
import co.edu.unicauca.mycompany.projects.infra.Messages;

/**
 * Controlador para la vista de inicio de sesión.
 * Gestiona la autenticación de usuarios y la redirección a la vista correspondiente.
 */
public class ControllerInicioSesion {
    /**
     * Servicio de usuario para manejar la autenticación.
     */
    private UserService service;
    
    /**
     * Vista de inicio de sesión a la que este controlador da soporte.
     */
    private GUIinicioSesion view;

    /**
     * Constructor parametrizado de Controller
     *
     * @param prmService Instancia del servicio
     * @param prmView Instancia de la vista a la que va a servir como
     * controller, en este caso GUIinicioSesion
     */
    public ControllerInicioSesion(UserService prmService, GUIinicioSesion prmView) {
        view = prmView;
        service = prmService;
    }

    /**
     * Se encarga de redirigir a la pagina correspondiente dependiendo del
     * resultado que devuelva el servicio
     *
     * @param userName Es el nombre de usuario como string
     * @param enteredPassword Es la contraseña como char[]
     */
    public void actionButtomLogin(String userName, char[] enteredPassword) {
        int result = service.iniciarSesion(userName, enteredPassword);
        switch (result) {
            case 0:
                Messages.mensajeVario("Usuario o clave incorrecta");
                break;
            case 1:
                view.dispose();
                GUIDashboardEstudiante instance = new GUIDashboardEstudiante(userName);
                instance.setVisible(true);
                break;
            case 2:
                view.dispose();
                GUIDashboardCoordinadorInicio instancee = new GUIDashboardCoordinadorInicio(userName);
                instancee.setVisible(true);
                break;
            case 3:
                view.setVisible(false);
                GUIDashboardEmpresa instanceee = new GUIDashboardEmpresa(userName); 
                instanceee.setVisible(true);
                break;
            default:
                Messages.mensajeVario("ERROR EN BASE DE DATOS");
                break;
        }
    }

    void actionButtomRegister() {
        view.dispose();
        ICompanyRepository repositoryCompany = Factory.getInstance().getRepositoryCompany("MARIADB");
        CompanyService companyService = new CompanyService(repositoryCompany);
        GUIregistrarEmpresa instance = new GUIregistrarEmpresa(companyService, this.service);
        instance.setVisible(true);

    }
}
