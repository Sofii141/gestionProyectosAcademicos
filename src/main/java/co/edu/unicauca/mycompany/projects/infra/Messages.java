package co.edu.unicauca.mycompany.projects.infra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
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

        JLabel label = new JLabel(message, JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setBorder(new LineBorder(new Color(90, 111, 228), 2));
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));

        // Añadir márgenes dentro del label
        label.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(90, 111, 228), 2), // Borde azul
                BorderFactory.createEmptyBorder(20, 30, 20, 30) // Espaciado interno
        ));

        // Agregar la etiqueta a la ventana
        window.getContentPane().add(label);
        window.pack(); // Ajusta el tamaño automáticamente

        // Obtener tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - window.getWidth()) / 2;
        int y = (screenSize.height - window.getHeight()) / 2;
        window.setLocation(x, y); // Centrar la ventana en la pantalla

        // Temporizador para cerrar la ventana automáticamente
        new Timer(2000, e -> window.dispose()).start();

        // Mostrar la ventana emergente
        window.setVisible(true);
    }
    
    public static String mensajeCambioEstado(String nombreCompany,String nombreProyecto, String estado){
    return "Estimado/a "+ nombreCompany +",\n" +
            "\n" +
            "Nos permitimos informarle que el estado de su proyecto "+ nombreProyecto +" ha sido actualizado en el sistema de gestión de proyectos de software.\n" +
            "\n" +
            "Detalles del Proyecto:\n" +
            "Empresa: "+ nombreCompany +"\n" +
            "Estado: "+ estado +"\n" +
            "\n" +
            "Este cambio ha sido realizado como parte del proceso de evaluación del proyecto por parte del coordinador académico. Si tiene alguna inquietud o desea más información sobre este cambio, no dude en ponerse en contacto con nosotros. Agradecemos su participación y colaboración en el desarrollo de proyectos para la comunidad académica.\n" +
            "\n" +
            "Cordialmente,\n" +
            "\n" +
            "Coordinación de Proyectos de Software\n" +
            "Universidad del Cauca ";
    }
}
