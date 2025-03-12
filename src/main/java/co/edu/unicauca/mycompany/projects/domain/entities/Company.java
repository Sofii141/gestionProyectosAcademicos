package co.edu.unicauca.mycompany.projects.domain.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Libardo, Julio
 */
public class Company {

   private String nit;
    private String companyName;
    private String contactName;
    private String contactPhone;
    private String contactLastName;
    private Sector sector;
    private String email;
    private String contactPosition;
    
    private List<Project> companyProyectos;

    public Company(String nit, String nombreEmpresa, String email, String telefonoContacto, String nombreContacto, String apellidoContacto, String cargoContacto, Sector sector) {
        this.nit = nit;
        this.companyName = nombreEmpresa;
        this.contactName = nombreContacto;
        this.contactPhone = telefonoContacto;
        this.contactLastName = apellidoContacto;
        this.sector = sector;
        this.email = email;
        this.contactPosition = cargoContacto;

        this.companyProyectos = new ArrayList<>();
    }
    
    public Company(String nit) {
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPosition() {
        return contactPosition;
    }

    public void setContactPosition(String contactPosition) {
        this.contactPosition = contactPosition;
    }

    public List<Project> getCompanyProyectos() {
        return companyProyectos;
    }

    public void setCompanyProyectos(List<Project> companyProyectos) {
        this.companyProyectos = companyProyectos;
    }
    
    public void agregarProyecto(String proId, String proTitle, String proDescription, String proAbstract, String proGoals, int proDeadLine, float proBudget){
        Project proyecto = new Project(proId, proTitle, proDescription, proAbstract, proGoals, proDeadLine, proBudget);
        proyecto.setCompany(this);
        companyProyectos.add(proyecto);
    }
}

