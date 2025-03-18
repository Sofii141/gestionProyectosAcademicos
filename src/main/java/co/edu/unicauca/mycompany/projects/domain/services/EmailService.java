/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

public class EmailService {
    
    public static void sendEmail(String recipient, String subject, String body) {
        //final String senderEmail = System.getenv("EMAIL_USER");
        //final String senderPassword = System.getenv("EMAIL_PASS");
        final String senderEmail = "sofiaarango141@gmail.com";
        final String senderPassword = "zmswzgudkjoazdrq"; 
        
        System.out.println(System.getenv("EMAIL_USER"));
        System.out.println(System.getenv("EMAIL_PASS"));
        
        if (senderEmail == null || senderPassword == null) {
            System.out.println("Error: Las variables de entorno EMAIL_USER o EMAIL_PASS no están definidas.");
            return;
        }

        if (recipient == null || recipient.trim().isEmpty()) {
            System.out.println("Error: El destinatario del correo es nulo o vacío.");
            return;
        }

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Cambiar a Gmail
        properties.put("mail.smtp.port", "587"); // Puerto de Gmail

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("✅ Correo enviado correctamente a " + recipient);
        } catch (MessagingException e) {
            System.out.println("❌ Error al enviar el correo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

