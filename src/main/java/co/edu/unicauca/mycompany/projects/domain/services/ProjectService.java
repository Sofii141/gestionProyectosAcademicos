/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.IProjectRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import java.util.List;

/**
 *
 * @author User
 */
public class ProjectService {
    
    private IProjectRepository repository;

    public ProjectService(IProjectRepository repository) {
        this.repository = repository;
    }

    //Coordinator
    public List<Project> getAllProjects() {
        return repository.listAll();
    }

    public boolean saveProject(Project newProject) {
        return repository.save(newProject);
    }
    /*-----------------REGLAS DE NEGOCIO---------------*/
    /**
     * Valida que el id del proyecto no exista en el sistema.
     *
     * @param proId String ingresado por el usuario
     * @param existingproIds Lista de NITs existentes en el sistema
     * @return true si el NIT no existe, false en caso contrario.
     */
    public boolean isproIdUnique(String proId, List<String> existingproIds) {
        return !existingproIds.contains(proId);
    }

    /**
     * Valida que el proId del proyecto solo contenga caracteres numéricos.
     *
     * @param proId String ingresado por el usuario
     * @return true si el proId solo contiene dígitos, false en caso contrario.
     */
    public boolean isproIdNumeric(String proId) {
        return proId.matches("\\d+");
    }

    /**
     * Valida que el proId tenga entre 2 y 20 dígitos.
     *
     * @param proId String ingresado por el usuario
     * @return true si la longitud está dentro del rango permitido, false en
     * caso contrario.
     */
    public boolean isproIdLengthValid(String proId) {
        return proId.length() >= 2 && proId.length() <= 20;
    }

    /**
     * Valida que el nombre, apellido o cargo del contacto solo contengan
     * caracteres alfabéticos y tengan una longitud válida.
     *
     * @param text String ingresado por el usuario
     * @return true si es válido, false en caso contrario.
     */
    public boolean isStringValid(String text) {
        return text.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,20}");
    }

  
    
}
