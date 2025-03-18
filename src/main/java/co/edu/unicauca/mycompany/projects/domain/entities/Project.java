package co.edu.unicauca.mycompany.projects.domain.entities;

//import co.edu.unicauca.mycompany.projects.domain.entities.EnumProjectState;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;

/**
 * Representa un proyecto dentro del sistema.
 * 
 * Un proyecto tiene un identificador, título, descripción, objetivos, presupuesto,
 * estado y fechas clave. Además, puede tener un equipo de desarrollo, postulantes,
 * un coordinador y una empresa asociada.
 * 
 */
public class Project {
    
    private String proId; //Identificador del Proyecto
    private String proTitle; //Título del proyecto 
    private String proDescription; //Descripción detallada del proyecto
    private String proAbstract; //Resumen del Proyecto
    private String proGoals; //Objetivos del Proyecto
    private int proDeadLine;  // Plazo en meses del proyecto
    private double proBudget; // Presupuesto del Proyecto - En la BD puede recibir null
    private EnumProjectState proState; // Estado del proyecto: "PROPUESTO", "ACEPTADO", "ASIGNADO", "FINALIZADO"

    private String companyNit;
    
    /**
     * Constructor de la clase Project.
     * @param proId
     * @param proTitle
     * @param proDescription
     * @param proAbstract
     * @param proGoals
     * @param proDeadLine
     * @param proBudget
     * @param companyNit
     */
    public Project(String proId, String proTitle, String proDescription, String proAbstract, String proGoals, int proDeadLine, double proBudget, String companyNit) {    
        this.companyNit = companyNit;
        this.proId = proId;
        this.proTitle = proTitle;
        this.proDescription = proDescription;
        this.proAbstract = proAbstract;
        this.proGoals = proGoals;
        this.proDeadLine = proDeadLine;
        this.proBudget = proBudget;
        this.proState = EnumProjectState.PROPUESTO;
    }
    
//Getter & Setter
    
    public String getProId() {
        return proId;
    }
    
    /**
     * Obtiene el título del proyecto.
     * 
     * @return Título del proyecto.
     */
    public String getProTitle() {    
        return proTitle;
    }

    /**
     * Obtiene la descripción del proyecto.
     * 
     * @return Descripción del proyecto.
     */
    public String getProDescription() {    
        return proDescription;
    }

    public String getProAbstract() {
        return proAbstract;
    }
    
    public String getProGoals() {
        return proGoals;
    }

    public double getProBudget() {
        return proBudget;
    }
    
    public int getProDeadLine() {
        return proDeadLine;
    }
    
    /**
     * Obtiene el estado actual del proyecto.
     * 
     * @return Estado del proyecto.
     */
    
    public EnumProjectState getProState() {
        return proState;
    }

    
    public String getCompanyNit() {
        return companyNit;
    }
    
    public void setProId(String proId) {
        this.proId = proId;
    }

    public void setProTitle(String proTitle) {
        this.proTitle = proTitle;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    public void setProAbstract(String proAbstract) {
        this.proAbstract = proAbstract;
    }

    public void setProBudget(double proBudget) {
        this.proBudget = proBudget;
    }

    public void setProGoals(String proGoals) {
        this.proGoals = proGoals;
    }
    

    public void setProDeadLine(int proDeadLine) {
        this.proDeadLine = proDeadLine;
    }

    public void setProState(EnumProjectState proState) {
        this.proState = proState;
    }
    
    public void setCompanyNit(String companyNit) {
        this.companyNit = companyNit;
    }

}
