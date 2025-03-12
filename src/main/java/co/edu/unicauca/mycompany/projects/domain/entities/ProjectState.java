/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.domain.entities;

/**
 *
 * @author paula
 */
public enum ProjectState {
    PROPUESTO,
    ASIGNADO,
    FINALIZADO;

    public static ProjectState fromString(String state) {
        try {
            return ProjectState.valueOf(state.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Estado de proyecto inválido: " + state);
        }
    }
}