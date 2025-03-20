/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.presentation;

/**
 *
 * @author spart
 */
public class DashboardFactory {
    public static Dashboard crearDashboard(int result, String idEntity){
        switch(result){
            case 1:
                return new GUIDashboardEstudiante(idEntity);
            case 2:
                return new GUIDashboardCoordinadorInicio(idEntity);
            case 3:
                return new GUIDashboardEmpresa(idEntity);
            default:
                return null;
        }
    }
}
