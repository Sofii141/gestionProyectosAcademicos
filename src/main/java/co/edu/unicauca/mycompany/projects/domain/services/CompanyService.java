package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import java.util.List;

/**
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class CompanyService {

    private ICompanyRepository repository;

    public CompanyService(ICompanyRepository repository) {
        this.repository = repository;
    }

    public List<Company> getAllCompanies() {
        return repository.listAll();
    }

    public boolean saveCompany(Company newCompany) {
        return repository.save(newCompany);
    }
    /*-----------------REGLAS DE NEGOCIO---------------*/
    /**
     * Valida que el email ingresado cumpla las reglas de negocio
     * 
     * @param email String ingresado por el usuario
     * @return true si la cadena cumple la expresion regular, false en caso contrario.
     */
    public boolean isValidEmail(String email) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }
    /**
     * Valida que el NIT de la empresa no exista en el sistema.
     *
     * @param nit String ingresado por el usuario
     * @param existingNITs Lista de NITs existentes en el sistema
     * @return true si el NIT no existe, false en caso contrario.
     */
    public boolean isNITUnique(String nit, List<String> existingNITs) {
        return !existingNITs.contains(nit);
    }

    /**
     * Valida que el NIT de la empresa solo contenga caracteres numéricos.
     *
     * @param nit String ingresado por el usuario
     * @return true si el NIT solo contiene dígitos, false en caso contrario.
     */
    public boolean isNITNumeric(String nit) {
        return nit.matches("\\d+");
    }

    /**
     * Valida que el NIT tenga entre 2 y 20 dígitos.
     *
     * @param nit String ingresado por el usuario
     * @return true si la longitud está dentro del rango permitido, false en
     * caso contrario.
     */
    public boolean isNITLengthValid(String nit) {
        return nit.length() >= 2 && nit.length() <= 20;
    }

    /**
     * Valida que el nombre solo contenga caracteres alfabéticos y tenga una
     * longitud válida.
     *
     * @param name String ingresado por el usuario
     * @return true si es válido, false en caso contrario.
     */
    public boolean isCompanyNameValid(String name) {
        return name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,20}");
    }

    /**
     * Valida que el teléfono de contacto tenga exactamente 10 dígitos.
     *
     * @param phone String ingresado por el usuario
     * @return true si el teléfono tiene exactamente 10 dígitos, false en caso
     * contrario.
     */
    public boolean isPhoneValid(String phone) {
        return phone.matches("\\d{10}");
    }

    /**
     * Valida que el teléfono de contacto no contenga todos los dígitos iguales.
     *
     * @param phone String ingresado por el usuario
     * @return true si el teléfono no contiene todos los dígitos iguales, false
     * en caso contrario.
     */
    public boolean isPhoneNotAllSameDigits(String phone) {
        return !phone.matches("(\\d)\\1{9}");
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

    /**
     * Valida que las contraseñas ingresadas sean iguales.
     *
     * @param password String de la contraseña ingresada por el usuario
     * @param confirmPassword String de la confirmación de la contraseña
     * ingresada por el usuario
     * @return true si ambas contraseñas son iguales, false en caso contrario.
     */
    public boolean arePasswordsMatching(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

}
