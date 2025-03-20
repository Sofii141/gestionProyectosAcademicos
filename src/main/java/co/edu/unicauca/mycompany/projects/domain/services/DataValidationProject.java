/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.domain.entities.Project;
import co.edu.unicauca.mycompany.projects.infra.ValidationException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class DataValidationProject implements IValidation {

    
    private Project project;

    /**
     * Constructor de la clase que recibe un proyecto a validar.
     *
     * @param project El proyecto cuyos datos serán validados.
     */
    public DataValidationProject(Project project) {
        this.project = project;
    }

    /**
     * Valida los datos del proyecto asegurando que los campos requeridos no
     * estén vacíos y que cumplan con los formatos establecidos.
     *
     * @return {@code true} si el proyecto es válido.
     * @throws ValidationException Si algún dato no cumple con las reglas
     * establecidas.
     */
    @Override
    public boolean isValid() throws ValidationException {

        String validationStrings = "[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+";
        String validationId = "[a-zA-Z0-9]{1,10}";
        String validationDate = "\\d{2}/\\d{2}/\\d{4}";
        String validationBudget = "\\d+(\\.\\d{1,2})?";

        // Validaciones de campos obligatorios
        if (project.getProId().isBlank() || project.getProId() == null) {
            throw new ValidationException("El ID del proyecto es obligatorio", "proId");
        } else if (project.getProTitle().isBlank() || project.getProTitle() == null) {
            throw new ValidationException("El título del proyecto es obligatorio", "proTitle");
        } else if (project.getProDescription().isBlank() || project.getProDescription() == null) {
            throw new ValidationException("La descripción del proyecto es obligatoria", "proDescription");
        } else if (project.getProAbstract().isBlank() || project.getProAbstract() == null) {
            throw new ValidationException("El resumen del proyecto es obligatorio", "proAbstract");
        } else if (project.getProGoals().isBlank() || project.getProGoals() == null) {
            throw new ValidationException("Los objetivos del proyecto son obligatorios", "proGoals");
        } else if (project.getProDate() == null) {
            throw new ValidationException("La fecha del proyecto es obligatoria", "proDate");
        } else if (project.getProDeadLine() <= 0) {
            throw new ValidationException("El plazo del proyecto debe ser mayor  a 0", "proDeadLine");
        } else if (project.getProBudget() < 0) {
            throw new ValidationException("El presupuesto del proyecto debe ser un número positivo", "proBudget");
        } else if (project.getIdcompany().isBlank() || project.getIdcompany() == null) {
            throw new ValidationException("El ID de la empresa es obligatorio", "idcompany");
        }

        // Validaciones de formato y longitud
        if (!project.getProId().matches(validationId)) {
            throw new ValidationException("El ID del proyecto debe contener solo letras y números, y tener entre 1 y 10 caracteres", "proId");
        }
        if (!project.getProTitle().matches(validationStrings)) {
            throw new ValidationException("El título del proyecto debe contener solo letras", "proTitle");
        }
        if (project.getProTitle().length() < 1 || project.getProTitle().length() > 20) {
            throw new ValidationException("El título del proyecto debe tener entre 1 y 20 caracteres", "proTitle");
        }
        if (project.getProAbstract().length() < 50 || project.getProAbstract().length() > 300) {
            throw new ValidationException("El resumen debe tener entre 50 y 300 caracteres", "proAbstract");
        }
        if (project.getProGoals().length() < 50 || project.getProGoals().length() > 500) {
            throw new ValidationException("Los objetivos deben tener entre 50 y 500 caracteres", "proGoals");
        }
        if (project.getProDescription().length() < 100 || project.getProDescription().length() > 1000) {
            throw new ValidationException("La descripción debe tener entre 100 y 1000 caracteres", "proDescription");
        }
        if (project.getProDeadLine() <= 0 || project.getProDeadLine() > 36) {
            throw new ValidationException("El plazo del proyecto debe estar entre 1 y 36 meses", "proDeadLine");
        }
        //System.out.println(String.valueOf(String.format("%.0f", project.getProBudget())));
        if (!String.valueOf(String.format("%.0f", project.getProBudget())).matches(validationBudget)) {
            throw new ValidationException("El presupuesto debe ser un número entero positivo con hasta 2 decimales", "proBudget");
        }
        if (project.getProBudget() < 0 || project.getProBudget() > 1000000000) {
            throw new ValidationException("El presupuesto debe estar entre 0 y 1'000.000.000 de pesos", "proBudget");
        }
        if (!new SimpleDateFormat("dd/MM/yyyy").format(project.getProDate()).matches(validationDate)) {
            throw new ValidationException("La fecha no tiene el formato dd/MM/yyyy", "proDate");
        }

        return true;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    
}
