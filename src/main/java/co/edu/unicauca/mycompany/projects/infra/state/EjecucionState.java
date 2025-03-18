/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.infra.state;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.domain.services.EmailService;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;

/**
 *
 * @author Ana_Sofia
 */
public class EjecucionState implements ProjectStatePatron {
    private CompanyService companyService; // Guardamos el servicio como atributo
    private ProjectService projectService; // Repositorio de proyectos
    

    public EjecucionState(CompanyService companyService, ProjectService projectService) {
        ICompanyRepository companyRepository = Factory.getInstance().getRepositoryCompany("MARIADB"); 
        this.companyService = new CompanyService(companyRepository); // Se inicializa correctamente
        this.projectService = projectService;
    }
    
    public EjecucionState() {
       
    }
    
    @Override
    public void handleStateChange(Project project) {
        project.setProStatePatron(this);
        notifyCompany(project);
    }

     @Override
    public void notifyCompany(Project project) {
        Company company = companyService.getCompany(project.getIdcompany()); // Buscar empresa

        if (company != null) {
        // Imprimir el objeto para verificar su contenido
        System.out.println("Empresa encontrada: " + company);

        // También imprimir el correo para asegurarte de que no es null
        System.out.println("Correo de la empresa: " + company.getUserEmail());

        EmailService.sendEmail(company.getUserEmail(), "Estado actualizado", 
            "Se le informa que su proyecto esta en EJECUCION.");
        } else {
            System.out.println("Error: No se encontró la empresa asociada al proyecto.");
            System.out.println("ID de la empresa buscada: " + project.getIdcompany());
        }
    }

    @Override
    public String toString() {
        return "EJECUCION";
    }

    @Override
    public boolean updateDatabase(Project project, ProjectService projectService) {
        return projectService.updateProjectStatus(project.getProId(), "EJECUCION"); // Usamos el servicio
    }
}

