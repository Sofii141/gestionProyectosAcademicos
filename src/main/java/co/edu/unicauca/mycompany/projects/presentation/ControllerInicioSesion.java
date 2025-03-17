/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.presentation;

import co.edu.unicauca.mycompany.projects.domain.services.UserService;
import co.edu.unicauca.mycompany.projects.infra.Messages;

/**
 *
 * @author spart
 */
public class ControllerInicioSesion {
    private UserService service;
    private GUIinicioSesion view;
    
    public ControllerInicioSesion(UserService prmService, GUIinicioSesion prmView){
        view = prmView;
        service = prmService;
    }
    public void actionButtomLogin(String userName, char[] enteredPassword){
        if (service.iniciarSesion(userName, enteredPassword) == 1){
            view.setVisible(false);
            GUIDashboardEstudiante instance = new GUIDashboardEstudiante(null);
            //GUIDashboardEstudiante instance = new GUIDashboardEstudiante(userName);  Este se prueba cuando haga merge
            instance.setVisible(true);
            
        }
        if (service.iniciarSesion(userName, enteredPassword) == 2){
            view.setVisible(false);
            GUIDashboardCoordinador instance = new GUIDashboardCoordinador();
            instance.setVisible(true);
        }
        if (service.iniciarSesion(userName, enteredPassword) == 3){
            view.setVisible(false);
            GUIDashboardEmpresa instance = new GUIDashboardEmpresa();
            instance.setVisible(true);
        }
        if (service.iniciarSesion(userName, enteredPassword) == 0)
        {
            Messages.showMessageDialog("Usuario o clave incorrecta", "ERROR:");
        }
    }
}
