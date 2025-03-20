package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.domain.entities.User;
import co.edu.unicauca.mycompany.projects.infra.ValidationException;

/**
 * Clase que valida los datos de una user.
 * 
 * Implementa la interfaz IValidation para proporcionar reglas de validación específicas
 * para los datos de una empresa dentro del sistema.
 */
public class DataValidationUser implements IValidation {

    /** User cuyos datos serán validados. */
    private User user;

    /**
     * Constructor de la clase que recibe un user a validar.
     *
     * @param user El user cuyos datos serán validados.
     */
    public DataValidationUser(User user) {
        this.user = user;
    }

    /**
     * Valida los datos del user asegurando que los campos requeridos no estén
     * vacíos y que cumplan con los formatos establecidos.
     *
     * @return {@code true} si la empresa es válida.
     * @throws ValidationException Si algún dato no cumple con las reglas
     * establecidas.
     */
    @Override
    public boolean isValid() throws ValidationException {
        String validationEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        String validationPassword = "^(?=.*[A-Z])(?=.*[!@#$%^&*\\-_.]).{6,}$";
        String validationId = "\\d+";

        if (user.getUserId().isBlank() || user.getUserId() == null) {
            throw new ValidationException("El NIT es obligatorio", "userId");
        } else if (user.getUserEmail().isBlank() || user.getUserEmail() == null) {
            throw new ValidationException("El email es obligatorio", "userEmail");
        } else if (user.getUserPassword().isBlank() || user.getUserPassword() == null) {
            throw new ValidationException("La contraseña es obligatoria", "userPassword");
        }
        if (user.getUserId().length() < 2 || user.getUserId().length() > 20) {
            throw new ValidationException("El NIT debe tener entre 2 y 20 dígitos", "userId");
        }
        if (!user.getUserEmail().matches(validationEmail)) {
            throw new ValidationException("El correo no es válido", "userEmail");
        }
        if (!user.getUserPassword().matches(validationPassword)) {
            throw new ValidationException("La contraseña debe tener al menos 6 caracteres, una mayúscula y un carácter especial.", "userPassword");
        }
        if (!user.getUserId().matches(validationId)) {
            throw new ValidationException("El NIT debe contener solo números", "userId");
        }
        return true;
    }
}
