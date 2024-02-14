package org.example.org.example;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Datos de tu cuenta de Gmail
        String username = "javamailmedac@gmail.com";
        String password = "pvni pjbe xsuk xtfe";

        // Dirección de correo electrónico del destinatario
        String to = "diegorosillosevillista@gmail.com";

        // Propiedades para la sesión de correo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Configuración para confiar en todos los certificados SSL (NO recomendado para producción)
        props.put("mail.smtp.ssl.trust", "*");

        // Autenticación
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Crear un mensaje de correo electrónico
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); // Dirección de correo del remitente
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); // Dirección de correo del destinatario
            message.setSubject("¡Hola desde JavaMail!"); // Asunto del correo
            message.setText("Hola,\n\nEste es un correo electrónico enviado desde una aplicación Java utilizando JavaMail.");

            // Enviar el correo electrónico
            Transport.send(message);

            System.out.println("¡Correo electrónico enviado con éxito!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

