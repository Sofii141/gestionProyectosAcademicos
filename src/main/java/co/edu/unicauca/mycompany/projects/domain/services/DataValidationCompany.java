/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.infra.ValidationException;

/**
 *
 * @author USUARIO
 */
public class DataValidationCompany implements IValidation {

    private Company company;

    /**
     * Constructor de la clase que recibe una empresa a validar.
     *
     * @param company La empresa cuyos datos serán validados.
     */
    public DataValidationCompany(Company company) {
        this.company = company;
    }

    /**
     * Valida los datos de la empresa asegurando que los campos requeridos no
     * estén vacíos y que cumplan con los formatos establecidos.
     *
     * @return {@code true} si la empresa es válida.
     * @throws ValidationException Si algún dato no cumple con las reglas
     * establecidas.
     */
    @Override
    public boolean isValid() throws ValidationException {

        String validationStrings = "[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,20}";
        String validationPhone = "\\d{10}";
        String validationPhoneNotAllSameDigits = "(\\d)\\1{9}";

        if (company.getCompanyName().isBlank() || company.getCompanyName() == null) {
            throw new ValidationException("El nombre de la empresa es obligatorio", "companyName");
        } else if (company.getCompanySector() == null || company.getCompanySector().toString().isBlank()) {
            throw new ValidationException("El sector industrial es obligatorio", "companySector");
        } else if (company.getContactName().isBlank() || company.getContactName() == null) {
            throw new ValidationException("El nombre del contacto es obligatorio", "contactName");
        } else if (company.getContactLastName().isBlank() || company.getContactLastName() == null) {
            throw new ValidationException("El apellido del contacto es obligatorio", "contactLastName");
        } else if (company.getContactPhone().isBlank() || company.getContactPhone() == null) {
            throw new ValidationException("El telefono del contacto es obligatorio", "contactPhone");
        } else if (company.getContactPosition().isBlank() || company.getContactPosition() == null) {
            throw new ValidationException("El cargo del contacto es obligatorio", "contactPosition");
        }

        if (company.getCompanyName().length() < 1 || company.getCompanyName().length() > 20) {
            throw new ValidationException("El nombre de la empresa debe tener entre 1 y 20 caractéres", "companyName");
        }
        if (company.getContactName().length() < 1 || company.getContactName().length() > 20) {
            throw new ValidationException("El nombre del contacto debe tener entre 1 y 20 caractéres", "contactName");
        }
        if (company.getContactLastName().length() < 1 || company.getContactLastName().length() > 20) {
            throw new ValidationException("El apellido del contacto debe tener entre 1 y 20 caractéres", "contactLastName");
        }
        if (company.getContactPosition().length() < 1 || company.getContactPosition().length() > 20) {
            throw new ValidationException("El cargo del contacto debe tener entre 1 y 20 caractéres", "contactPosition");
        }

        if (!company.getCompanyName().matches(validationStrings)) {
            throw new ValidationException("El nombre de la empresa solo debe contener solo letras", "companyName");
        }
        if (!company.getContactName().matches(validationStrings)) {
            throw new ValidationException("El nombre del contacto solo debe contener solo letras", "contactName");
        }
        if (!company.getContactLastName().matches(validationStrings)) {
            throw new ValidationException("El apellido del contacto solo debe contener solo letras", "contactLastName");
        }
        if (!company.getContactPosition().matches(validationStrings)) {
            throw new ValidationException("El cargo del contacto solo debe contener solo letras", "contactPosition");
        }
        if (!company.getContactPhone().matches(validationPhone)) {
            throw new ValidationException("El teléfono debe contener exactamente 10 dígitos", "contactPhone");
        }
        if (company.getContactPhone().matches(validationPhoneNotAllSameDigits)) {
            throw new ValidationException("El teléfono no debe contener números repetidos 10 veces", "contactPhone");
        }
        return true;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
