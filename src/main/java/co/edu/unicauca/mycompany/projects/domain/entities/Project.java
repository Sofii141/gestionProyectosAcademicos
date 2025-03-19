package co.edu.unicauca.mycompany.projects.domain.entities;

import co.edu.unicauca.mycompany.projects.infra.state.ProjectStatePatron;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Representa un proyecto dentro del sistema.
 * 
 * Un proyecto tiene un identificador, título, descripción, objetivos, presupuesto,
 * estado y fechas clave. Además, puede tener un equipo de desarrollo, postulantes,
 * un coordinador y una empresa asociada.
 * 
 */
public class Project {

    private String proId; // Identificador único del proyecto
    private String proTitle; // Título del proyecto
    private String proDescription; // Descripción detallada del proyecto
    private String proAbstract; // Resumen del proyecto
    private String proGoals; // Objetivos del proyecto
    private Date proDate; // Fecha de creación del proyecto
    private int proDeadLine; // Plazo del proyecto en días
    private double proBudget; // Presupuesto asignado al proyecto
    private String idcompany; // Identificador de la empresa asociada
    
    private enumProjectState proState; // Estado actual del proyecto (Ej: RECIBIDO, ACEPTADO)
    
    private ProjectStatePatron proStatePatron;
    
    private List<Student> proTeam; // Lista de estudiantes asignados al proyecto
    private List<Student> proPostulates; // Lista de estudiantes que postulan al proyecto
    private String proCoordinator; // Coordinador del proyecto
    
    
    /**
     * Constructor de la clase Project.
     *
     * @param proId Identificador único del proyecto.
     * @param proTitle Título del proyecto.
     * @param proDescription Descripción del proyecto.
     * @param proAbstract Resumen del proyecto.
     * @param proGoals Objetivos del proyecto.
     * @param proDeadLine Plazo del proyecto en días.
     * @param proDate
     * @param proBudget Presupuesto del proyecto.
     * @param idcompany Identificador de la empresa asociada.
     */
    public Project(String proId, String proTitle, String proDescription, String proAbstract,
                   String proGoals, int proDeadLine, Date proDate, double proBudget, String idcompany) {
        this.proId = proId;
        this.proTitle = proTitle;
        this.proDescription = proDescription;
        this.proAbstract = proAbstract;
        this.proGoals = proGoals;
        this.proDeadLine = proDeadLine;
        this.proDate = proDate; 
        this.proBudget = proBudget;
        this.proState = enumProjectState.RECIBIDO; 
        this.proTeam = new ArrayList<>(); 
        this.proPostulates = new ArrayList<>(); 
        this.proCoordinator = null; 
        this.idcompany = idcompany;
        this.proStatePatron = proStatePatron;
    }

   
    /**
     * Obtiene el identificador del proyecto.
     *
     * @return Identificador del proyecto.
     */
    public String getProId() {
        return proId;
    }

    /**
     * Establece el identificador del proyecto.
     *
     * @param proId Nuevo identificador del proyecto.
     */
    public void setProId(String proId) {
        this.proId = proId;
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
     * Establece el título del proyecto.
     *
     * @param proTitle Nuevo título del proyecto.
     */
    public void setProTitle(String proTitle) {
        this.proTitle = proTitle;
    }

    /**
     * Obtiene la descripción del proyecto.
     *
     * @return Descripción del proyecto.
     */
    public String getProDescription() {
        return proDescription;
    }

    /**
     * Establece la descripción del proyecto.
     *
     * @param proDescription Nueva descripción del proyecto.
     */
    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    /**
     * Obtiene el resumen del proyecto.
     *
     * @return Resumen del proyecto.
     */
    public String getProAbstract() {
        return proAbstract;
    }

    /**
     * Establece el resumen del proyecto.
     *
     * @param proAbstract Nuevo resumen del proyecto.
     */
    public void setProAbstract(String proAbstract) {
        this.proAbstract = proAbstract;
    }

    /**
     * Obtiene los objetivos del proyecto.
     *
     * @return Objetivos del proyecto.
     */
    public String getProGoals() {
        return proGoals;
    }

    /**
     * Establece los objetivos del proyecto.
     *
     * @param proGoals Nuevos objetivos del proyecto.
     */
    public void setProGoals(String proGoals) {
        this.proGoals = proGoals;
    }

    /**
     * Obtiene la fecha de creación del proyecto.
     *
     * @return Fecha del proyecto.
     */
    public Date getProDate() {
        return proDate;
    }

    /**
     * Establece la fecha de creación del proyecto.
     *
     * @param proDate Nueva fecha del proyecto.
     */
    public void setProDate(Date proDate) {
        this.proDate = proDate;
    }

    /**
     * Obtiene el plazo del proyecto en días.
     *
     * @return Plazo del proyecto.
     */
    public int getProDeadLine() {
        return proDeadLine;
    }

    /**
     * Establece el plazo del proyecto en días.
     *
     * @param proDeadLine Nuevo plazo del proyecto.
     */
    public void setProDeadLine(int proDeadLine) {
        this.proDeadLine = proDeadLine;
    }

    /**
     * Obtiene el presupuesto del proyecto.
     *
     * @return Presupuesto del proyecto.
     */
    public double getProBudget() {
        return proBudget;
    }

    /**
     * Establece el presupuesto del proyecto.
     *
     * @param proBudget Nuevo presupuesto del proyecto.
     */
    public void setProBudget(double proBudget) {
        this.proBudget = proBudget;
    }

    /**
     * Obtiene el estado actual del proyecto.
     *
     * @return Estado del proyecto.
     */
    public enumProjectState getProState() {
        return proState;
    }

    /**
     * Establece el estado actual del proyecto.
     *
     * @param proState Nuevo estado del proyecto.
     */
    public void setProState(enumProjectState proState) {
        this.proState = proState;
    }

    public void setProStatePatron(ProjectStatePatron proStatePatron) {
        this.proStatePatron = proStatePatron;  
        this.proState = enumProjectState.valueOf(proStatePatron.toString()); 
    }


    /**
     * Obtiene la lista de estudiantes asignados al proyecto.
     *
     * @return Lista de estudiantes en el equipo del proyecto.
     */
    public List<Student> getProTeam() {
        return proTeam;
    }

    /**
     * Asigna una lista de estudiantes al equipo del proyecto.
     *
     * @param proTeam Lista de estudiantes a asignar.
     */
    public void setProTeam(List<Student> proTeam) {
        this.proTeam = proTeam;
    }

    /**
     * Obtiene la lista de estudiantes que postulan al proyecto.
     *
     * @return Lista de estudiantes postulantes.
     */
    public List<Student> getProPostulates() {
        return proPostulates;
    }

    /**
     * Asigna una lista de estudiantes postulantes al proyecto.
     *
     * @param proPostulates Lista de estudiantes postulantes.
     */
    public void setProPostulates(List<Student> proPostulates) {
        this.proPostulates = proPostulates;
    }

    /**
     * Obtiene el identificador de la empresa asociada al proyecto.
     *
     * @return Identificador de la empresa.
     */
    public String getIdcompany() {
        return idcompany;
    }

    /**
     * Establece el identificador de la empresa asociada al proyecto.
     *
     * @param idcompany Nuevo identificador de la empresa.
     */
    public void setIdcompany(String idcompany) {
        this.idcompany = idcompany;
    }

    /**
     * Obtiene el coordinador asignado al proyecto.
     *
     * @return Identificador del coordinador del proyecto.
     */
    public String getProCoordinator() {
        return proCoordinator;
    }

    /**
     * Asigna un coordinador al proyecto.
     *
     * @param proCoordinator Identificador del coordinador.
     */
    public void setProCoordinator(String proCoordinator) {
        this.proCoordinator = proCoordinator;
    }
}