/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.domain.services.UserService;
import co.edu.unicauca.mycompany.projects.infra.Messages;

/**
 * Controlador de GUIInicioSesion
 * @author spart
 */
public class ControllerInicioSesion {
    private UserService service;
    private GUIinicioSesion view;
    /**
     * Constructor parametrizado de Controller
     * @param prmService Instancia del servicio
     * @param prmView Instancia de la vista a la que va a servir como controller, en este caso GUIinicioSesion
     */
    public ControllerInicioSesion(UserService prmService, GUIinicioSesion prmView){
        view = prmView;
        service = prmService;
    }
    /**
     * Se encarga de redirigir a la pagina correspondiente dependiendo del resultado que devuelva el servicio
     * @param userName Es el nombre de usuario como string
     * @param enteredPassword Es la contraseña como char[]
     */
    public void actionButtomLogin(String userName, char[] enteredPassword){
        int result  = service.iniciarSesion(userName, enteredPassword);
        switch (result){
            case 0:
                Messages.mensajeVario("Usuario o clave incorrecta");
                break;
            case 1: 
                view.setVisible(false);
                GUIDashboardEstudiante instance = new GUIDashboardEstudiante(userName);
                instance.setVisible(true);
                break;
            case 2:
                view.setVisible(false);
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
}
