package co.edu.unicauca.mycompany.projects.domain.entities;

import co.edu.unicauca.mycompany.projects.domain.services.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Project {
    private String proId; //primary key
    private String proTitle;
    private String proDescription;
    private String proAbstract;
    private String proGoals;
    private int proDeadLine; 
    private float proBudget; //Puede recibir null
    private ProjectState proState;

    private List<Student> proTeam;
    private List<Student> proPostulates;
    private Coordinator proCoordinator;
    private Company company;
    
    /**
     * Constructor de la clase Project.
     * 
     * @param proId
     * @param proTitle
     * @param proDescription
     * @param proAbstract
     * @param proGoals
     * @param proDeadLine
     * @param proBudget
     */
    public Project(String proId, String proTitle, String proDescription, String proAbstract, String proGoals, int proDeadLine, float proBudget) {    
        this.proId = proId;
        this.proTitle = proTitle;
        this.proDescription = proDescription;
        this.proAbstract = proAbstract;
        this.proGoals = proGoals;
        this.proDeadLine = proDeadLine;
        this.proBudget = proBudget;
        this.proState = ProjectState.PROPUESTO;
        this.proTeam = new ArrayList<>();
        this.proPostulates = new ArrayList<>();
        
    }

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

    public float getProBudget() {
        return proBudget;
    }
    
    public int getProDeadLine() {
        return proDeadLine;
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

    public void setProBudget(float proBudget) {
        this.proBudget = proBudget;
    }

    public void setProGoals(String proGoals) {
        this.proGoals = proGoals;
    }
    

    public void setProDeadLine(int proDeadLine) {
        this.proDeadLine = proDeadLine;
    }

    public List<Student> getProTeam() {
        return proTeam;
    }

    public void setProTeam(List<Student> proTeam) {
        this.proTeam = proTeam;
    }

    public List<Student> getProPostulates() {
        return proPostulates;
    }

    public void setProPostulates(List<Student> proPostulates) {
        this.proPostulates = proPostulates;
    }

    public Coordinator getProCoordinator() {
        return proCoordinator;
    }

    public void setProCoordinator(Coordinator proCoordinator) {
        this.proCoordinator = proCoordinator;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ProjectState getProState() {
        return proState;
    }

    public void setProState(ProjectState proState) {
        this.proState = proState;
    }
    
}
