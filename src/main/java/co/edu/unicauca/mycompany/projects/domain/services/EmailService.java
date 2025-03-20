package co.edu.unicauca.mycompany.projects.domain.services;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Servicio para el envío de correos electrónicos.
 * 
 * Esta clase proporciona un método estático para enviar correos electrónicos 
 * utilizando el protocolo SMTP con autenticación y cifrado TLS.
 */
public class EmailService {
    
    /**
     * Envía un correo electrónico a un destinatario específico.
     * 
     * @param recipient Dirección de correo electrónico del destinatario.
     * @param subject   Asunto del correo electrónico.
     * @param body Cuerpo de mensaje.
     */
    public static void sendEmail(String recipient, String subject, String body) {
        
        
        final String senderEmail = System.getenv("EMAIL_USER"); // Correo del remitente
        final String senderPassword = System.getenv("EMAIL_PASS"); // Contraseña del remitente
        
        System.out.println(System.getenv("EMAIL_USER"));
        System.out.println(System.getenv("EMAIL_PASS"));
        
        // Verifica que las credenciales de envío estén configuradas
        if (senderEmail == null || senderPassword == null) {
            System.out.println("Error: Las variables de entorno EMAIL_USER o EMAIL_PASS no están definidas.");
            return;
        }

        // Verifica que el destinatario sea válido
        if (recipient == null || recipient.trim().isEmpty()) {
            System.out.println("Error: El destinatario del correo es nulo o vacío.");
            return;
        }

        // Configuración de las propiedades del servidor SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Servidor SMTP de Gmail
        properties.put("mail.smtp.port", "587"); // Puerto de Gmail

        // Autenticación de la sesión con las credenciales del remitente
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Creación del mensaje de correo electrónico
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);

            // Envío del mensaje
            Transport.send(message);
            System.out.println("Correo enviado correctamente a " + recipient);
        } catch (MessagingException e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}