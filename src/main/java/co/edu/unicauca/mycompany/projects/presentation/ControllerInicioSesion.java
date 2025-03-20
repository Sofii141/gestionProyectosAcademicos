/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.domain.services.UserService;
import co.edu.unicauca.mycompany.projects.infra.Messages;

/**
 * Controlador de GUIInicioSesion
 *
 * @author spart
 */
public class ControllerInicioSesion {

    private UserService service;
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
        if(userName.isEmpty() || enteredPassword.length == 0){
            Messages.mensajeVario("Ambos campos son obligatorios");
            return;
        }
        int result = service.iniciarSesion(userName, enteredPassword);
        if (result == 0) {
            Messages.mensajeVario("Usuario o clave incorrecta");
            return;
        }

        Dashboard dashboard = DashboardFactory.crearDashboard(result, userName);

        if (dashboard != null) {
            view.dispose();
            dashboard.mostrar();
        } else {
            Messages.mensajeVario("ERROR EN BASE DE DATOS");
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
