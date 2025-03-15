package co.edu.unicauca.mycompany.projects.domain.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una empresa que puede registrar proyectos en el sistema.
 */
public class Company {

    private String companyNit; // Identificador único (NIT) de la empresa
    private String companyName; // Nombre de la empresa
    private String contactName; // Nombre de la persona de contacto
    private String contactLastName; // Apellido de la persona de contacto
    private String contactPhone; // Teléfono de contacto
    private String companyEmail; // Correo electrónico de la empresa
    private String contactPosition; // Cargo de la persona de contacto
    private Sector companySector; // Sector al que pertenece la empresa

    private List<Project> companyProjects; // Lista de proyectos asociados a la empresa

    /**
     * Constructor de la clase Company con todos los atributos.
     * 
     * @param nit             NIT de la empresa.
     * @param companyName     Nombre de la empresa.
     * @param email           Correo electrónico de la empresa.
     * @param contactPhone    Teléfono de contacto.
     * @param contactName     Nombre del contacto.
     * @param contactLastName Apellido del contacto.
     * @param contactPosition Cargo del contacto.
     * @param sector          Sector empresarial.
     */
    public Company(String nit, String companyName, String email, String contactPhone, 
                   String contactName, String contactLastName, String contactPosition, Sector sector) {
        this.companyNit = nit;
        this.companyName = companyName;
        this.companyEmail = email;
        this.contactPhone = contactPhone;
        this.contactName = contactName;
        this.contactLastName = contactLastName;
        this.contactPosition = contactPosition;
        this.companySector = sector;
        this.companyProjects = new ArrayList<>();
    }

    /**
     * Constructor de la clase Company que solo recibe el NIT.
     * 
     * @param nit NIT de la empresa.
     */
    public Company(String nit) {
        this.companyNit = nit;
        this.companyProjects = new ArrayList<>();
    }

    /**
     * Obtiene el NIT de la empresa.
     * 
     * @return NIT de la empresa.
     */
    public String getCompanyNit() {
        return companyNit;
    }

    /**
     * Establece el NIT de la empresa.
     * 
     * @param companyNit Nuevo NIT de la empresa.
     */
    public void setCompanyNit(String companyNit) {
        this.companyNit = companyNit;
    }

    /**
     * Obtiene el nombre de la empresa.
     * 
     * @return Nombre de la empresa.
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Establece el nombre de la empresa.
     * 
     * @param companyName Nuevo nombre de la empresa.
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Obtiene el nombre de la persona de contacto de la empresa.
     * 
     * @return Nombre de la persona de contacto.
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Establece el nombre de la persona de contacto de la empresa.
     * 
     * @param contactName Nuevo nombre de la persona de contacto.
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * Obtiene el apellido de la persona de contacto de la empresa.
     * 
     * @return Apellido de la persona de contacto.
     */
    public String getContactLastName() {
        return contactLastName;
    }

    /**
     * Establece el apellido de la persona de contacto de la empresa.
     * 
     * @param contactLastName Nuevo apellido de la persona de contacto.
     */
    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    /**
     * Obtiene el teléfono de contacto de la empresa.
     * 
     * @return Teléfono de contacto de la empresa.
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * Establece el teléfono de contacto de la empresa.
     * 
     * @param contactPhone Nuevo teléfono de contacto de la empresa.
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     * Obtiene el correo electrónico de la empresa.
     * 
     * @return Correo electrónico de la empresa.
     */
    public String getCompanyEmail() {
        return companyEmail;
    }

    /**
     * Establece el correo electrónico de la empresa.
     * 
     * @param companyEmail Nuevo correo electrónico de la empresa.
     */
    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    /**
     * Obtiene el cargo de la persona de contacto de la empresa.
     * 
     * @return Cargo de la persona de contacto de la empresa.
     */
    public String getContactPosition() {
        return contactPosition;
    }

    /**
     * Establece el cargo de la persona de contacto de la empresa.
     * 
     * @param contactPosition Nuevo cargo de la persona de contacto de la empresa.
     */
    public void setContactPosition(String contactPosition) {
        this.contactPosition = contactPosition;
    }

    /**
     * Obtiene el sector de la empresa.
     * 
     * @return Sector de la empresa.
     */
    public Sector getCompanySector() {
        return companySector;
    }

    /**
     * Establece el sector de la empresa.
     * 
     * @param companySector Nuevo sector de la empresa.
     */
    public void setCompanySector(Sector companySector) {
        this.companySector = companySector;
    }

    /**
     * Obtiene la lista de proyectos asociados a la empresa.
     * 
     * @return Lista de proyectos de la empresa.
     */
    public List<Project> getCompanyProjects() {
        return companyProjects;
    }

    /**
     * Establece la lista de proyectos asociados a la empresa.
     * 
     * @param companyProjects Nueva lista de proyectos de la empresa.
     */
    public void setCompanyProjects(List<Project> companyProjects) {
        this.companyProjects = companyProjects;
    }

    /**
     * Agrega un nuevo proyecto a la empresa.
     * 
     * @param proId          Identificador único del proyecto.
     * @param proTitle       Título del proyecto.
     * @param proDescription Descripción del proyecto.
     * @param proAbstract    Resumen del proyecto.
     * @param proGoals       Objetivos del proyecto.
     * @param proDeadLine    Plazo del proyecto en días.
     * @param proBudget      Presupuesto del proyecto.
     */
    public void addProject(String proId, String proTitle, String proDescription, String proAbstract,
                           String proGoals, int proDeadLine, double proBudget) {
        Project project = new Project(proId, proTitle, proDescription, proAbstract, proGoals, 
                                      proDeadLine, proBudget, this.companyNit);
        companyProjects.add(project);
    }
}