package co.edu.unicauca.mycompany.projects.infra;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.LineBorder;


/**
 * Clase utilitaria para mostrar diferentes tipos de mensajes en la interfaz gráfica.
 * Proporciona diálogos de información, confirmación y error, así como un mensaje emergente personalizado.
 */
public class Messages {

    /**
     * Muestra un cuadro de diálogo informativo con el mensaje y título especificados.
     *
     * @param message Mensaje a mostrar en el cuadro de diálogo.
     * @param title   Título del cuadro de diálogo.
     */
    public static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra un cuadro de diálogo de confirmación y devuelve la opción seleccionada por el usuario.
     *
     * @param message Mensaje a mostrar en el cuadro de diálogo.
     * @param title   Título del cuadro de diálogo.
     * @return Un entero que representa la opción seleccionada por el usuario.
     *         Puede ser JOptionPane.YES_OPTION, JOptionPane.NO_OPTION, o JOptionPane.CANCEL_OPTION.
     */
    public static int showConfirmDialog(String message, String title) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra un cuadro de diálogo de error con el mensaje y título especificados.
     *
     * @param message Mensaje de error a mostrar en el cuadro de diálogo.
     * @param title   Título del cuadro de diálogo.
     */
    public static void showErrorDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un mensaje emergente personalizado en una ventana flotante sin bordes.
     * La ventana se cierra automáticamente después de 2 segundos.
     *
     * @param message Mensaje a mostrar en la ventana emergente.
     */
    public static void mensajeVario(String message) {
        // Crear una ventana emergente sin bordes
        JWindow window = new JWindow();

        // Crear una etiqueta con el mensaje de confirmación
        JLabel label = new JLabel(message, JLabel.CENTER);
        // Hacer que la etiqueta tenga un fondo visible
        label.setOpaque(true); 
        // Establecer el fondo en color blanco
        label.setBackground(Color.WHITE); 
        // Establecer un borde azul
        label.setBorder(new LineBorder(new Color(90, 111, 228), 2)); 
        // Color del texto
        label.setForeground(Color.BLACK);
        // Establecer la fuente
        label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14)); 

        // Agregar la etiqueta a la ventana emergente
        window.getContentPane().add(label);
        // Definir el tamaño de la ventana emergente
        window.setSize(500, 50);
        // Posicionar la ventana en la pantalla
        window.setLocation(0,0);

        // Configurar un temporizador para cerrar la ventana emergente automáticamente en 2 segundos
        new Timer(2000, e -> window.dispose()).start();

        // Hacer visible la ventana emergente
        window.setVisible(true);
    }
}
