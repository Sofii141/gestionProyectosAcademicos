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
public class CerradoState implements ProjectStatePatron {
    private  CompanyService companyService;

    public CerradoState(CompanyService companyService) {
        this.companyService = companyService;
    }
    
    public CerradoState() {
        
    }
    
    @Override
    public void handleStateChange(Project project) {
        project.setProStatePatron(this);
        System.out.println("El proyecto ha sido cerrado.");
    }

     @Override
    public void notifyCompany(Project project) {
        Company company = companyService.getCompany(project.getIdcompany()); // Buscar empresa
        if (company != null) {
            EmailService.sendEmail(company.getCompanyEmail(), "Estado actualizado", 
                "El proyecto ha sido cambiado a CERRADO.");
        } else {
            System.out.println("Error: No se encontró la empresa asociada al proyecto.");
        }
    }

    @Override
    public String toString() {
        return "CERRADO";
    }

    @Override
    public boolean updateDatabase(Project project, ProjectService projectService) {
        return projectService.updateProjectStatus(project.getProId(), "CERRADO"); // Usamos el servicio
    }
}

