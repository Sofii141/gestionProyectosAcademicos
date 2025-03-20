package co.edu.unicauca.mycompany.projects.infra;

import java.util.ArrayList;

/**
 * Clase abstracta que representa un sujeto en el patrón de diseño Observer.
 * 
 * Los objetos que heredan de esta clase pueden ser observados por múltiples 
 * instancias de la interfaz Observer. Cuando ocurre un cambio en el estado del sujeto, 
 * se notifica automáticamente a todos los observadores registrados.
 */
public abstract class Subject {

    /** Lista de observadores registrados. */
    private ArrayList<Observer> observers;

    /**
     * Constructor de la clase Subject.
     * Inicializa la lista de observadores.
     */
    public Subject() {
        observers = new ArrayList<>();
    }

    /**
     * Agrega un observador a la lista de observadores.
     *
     * @param obs Observador que será agregado a la lista.
     */
    public void addObserver(Observer obs) {
        if (observers == null) {
            observers = new ArrayList<>();
        }
        observers.add(obs);
    }

    /**
     * Notifica a todos los observadores registrados sobre un cambio en el sujeto.
     */
    public void notifyAllObserves() {
        for (Observer each : observers) {
            each.update();
        }
    }
}

