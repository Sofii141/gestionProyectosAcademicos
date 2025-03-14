package co.edu.unicauca.mycompany.projects.infra;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Messages {

    public static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static int showConfirmDialog(String message, String title) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showErrorDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mensajeVario(String message){
        // Crear una ventana emergente sin bordes
        JWindow window = new JWindow();
        
        // Crear una etiqueta con el mensaje de confirmación
        JLabel label = new JLabel(message, JLabel.CENTER);
        label.setOpaque(true); // Hacer que la etiqueta tenga un fondo visible
        label.setBackground(Color.WHITE); // Establecer el fondo en color blanco
        label.setBorder(new LineBorder(new Color(90, 111, 228), 2)); // Establecer un borde azul
        label.setForeground(Color.BLACK); // Color del texto
        label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14)); // Establecer la fuente

        // Agregar la etiqueta a la ventana emergente
        window.getContentPane().add(label);
        // Definir el tamaño de la ventana emergente
        window.setSize(500, 50);
        // Posicionar la ventana en la pantalla
        window.setLocation(600,670);
        
        // Configurar un temporizador para cerrar la ventana emergente automáticamente en 2 segundos
        new Timer(2000, e -> window.dispose()).start();
        
        // Hacer visible la ventana emergente
        window.setVisible(true);
    }

}
