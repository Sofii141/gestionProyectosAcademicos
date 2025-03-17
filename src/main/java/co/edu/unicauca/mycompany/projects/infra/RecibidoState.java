/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.infra;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.domain.services.EmailService;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;

/**
 *
 * @author Ana_Sofia
 */
/**
 *
 * @author Ana_Sofia
 */
public class RecibidoState implements ProjectStatePatron {
     private CompanyService companyService;

    public RecibidoState(CompanyService companyService) {
        this.companyService = companyService;
    }
    
    public RecibidoState() {
    }
    
    @Override
    public void handleStateChange(Project project) {
        project.setProStatePatron(this);
        System.out.println("El proyecto ha sido RECIBIDO.");
    }

     @Override
    public void notifyCompany(Project project) {
        Company company = companyService.getCompany(project.getIdcompany()); // Buscar empresa
        if (company != null) {
            EmailService.sendEmail(company.getCompanyEmail(), "Estado actualizado", 
                "El proyecto ha sido cambiado a RECIBIDO.");
        } else {
            System.out.println("Error: No se encontró la empresa asociada al proyecto.");
        }
    }

    @Override
    public String toString() {
        return "RECIBIDO";
    }

    @Override
    public boolean updateDatabase(Project project, ProjectService projectService) {
        return projectService.updateProjectStatus(project.getProId(), "RECIBIDO"); // Usamos el servicio
    }
}