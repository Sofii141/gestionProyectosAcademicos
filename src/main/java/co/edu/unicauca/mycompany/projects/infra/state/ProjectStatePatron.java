/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.infra.state;

import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.domain.services.ProjectService;

/**
 *
 * @author Ana_Sofia
 */
public interface ProjectStatePatron {
    void handleStateChange(Project project);
    void notifyCompany(Project project);
    boolean updateDatabase(Project project, ProjectService projectService);
}
