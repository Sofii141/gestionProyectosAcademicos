/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.domain.entities;

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
    private String proState; // "PROPUESTO", "ASIGNADO", "FINALIZADO"

    /**
     * Constructor de la clase Project.
     * 
     * @param titulo     Título del proyecto.
     * @param descripcion Descripción del proyecto.
     * 
     */
    public Project(String proId, String proTitle, String proDescription, String proAbstract, String proGoals, int proDeadLine, float proBudget) {    
        this.proId = proId;
        this.proTitle = proTitle;
        this.proDescription = proDescription;
        this.proAbstract = proAbstract;
        this.proGoals = proGoals;
        this.proDeadLine = proDeadLine;
        this.proBudget = proBudget;
        this.proState = "PROPUESTO"; //Default
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
    
    /**
     * Obtiene el estado actual del proyecto.
     * 
     * @return Estado del proyecto.
     */
    public String getProState() {
        return proState;
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

    
    public void setProState(String proState) {
        this.proState = proState;
    }
    
    
}
