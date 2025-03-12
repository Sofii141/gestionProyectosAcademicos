package co.edu.unicauca.mycompany.projects.domain.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Libardo, Julio
 */
public class Company {

    private String nit;
    private String nombreEmpresa;
    private String nombreContacto;
    private String telefonoContacto;
    private String apellidoContacto;
    private Sector sector;
    private String email;
    private String cargoContacto;
    
    private List<Project> companyProyectos;

    public Company(String nit, String nombreEmpresa, String nombreContacto, String telefonoContacto, String apellidoContacto, Sector sector, String email, String cargoContacto) {
        this.nit = nit;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreContacto = nombreContacto;
        this.telefonoContacto = telefonoContacto;
        this.apellidoContacto = apellidoContacto;
        this.sector = sector;
        this.email = email;
        this.cargoContacto = cargoContacto;

        this.companyProyectos = new ArrayList<>();
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getApellidoContacto() {
        return apellidoContacto;
    }

    public void setApellidoContacto(String apellidoContacto) {
        this.apellidoContacto = apellidoContacto;
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

    public String getCargoContacto() {
        return cargoContacto;
    }

    public void setCargoContacto(String cargoContacto) {
        this.cargoContacto = cargoContacto;
    }

    public List<Project> getCompanyProyectos() {
        return companyProyectos;
    }

    public void setCompanyProyectos(List<Project> companyProyectos) {
        this.companyProyectos = companyProyectos;
    }   
    
    public void agregarProyecto(String proId, String proTitle, String proDescription, String proAbstract, String proGoals, int proDeadLine, float proBudget){
        Project proyecto = new Project(proId, proTitle, proDescription, proAbstract, proGoals, proDeadLine, proBudget);
        proyecto.setCompania(this);
        companyProyectos.add(proyecto);
    }
}

