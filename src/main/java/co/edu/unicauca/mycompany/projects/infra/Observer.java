package co.edu.unicauca.mycompany.projects.infra;

/**
 * Interfaz que define el patrón de diseño Observer.
 * Las clases que implementen esta interfaz deben proporcionar una implementación del método update()
 * para recibir notificaciones de cambios en el estado del objeto observado.
 */
public interface Observer {

    /**
     * Método que se ejecuta cuando el objeto observado notifica un cambio.
     * Cada clase que implemente esta interfaz debe definir su propio comportamiento ante la actualización.
     */
    void update();
}

