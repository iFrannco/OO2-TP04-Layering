package ar.unrn.tp4.ejercicio2.service;

import ar.unrn.tp4.ejercicio2.model.Notificador;
import ar.unrn.tp4.ejercicio2.model.Persona;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class NotificadorEmail implements Notificador {
    private final String USERNAME = "372a3b3cd6da45";
    private final String PASSWORD = "0454bf60332399";
    private final String HOST = "sandbox.smtp.mailtrap.io";
    private String emisor;

    public NotificadorEmail(String from) {
        this.emisor = from;
    }

    public void saludarCumpleaños(Persona persona, String mensaje) {
        // configure SMTP details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", "587");

        // create the mail Session object
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });

        try {
            // create a MimeMessage object
            Message message = new MimeMessage(session);
            // set From email field
            message.setFrom(new InternetAddress(this.emisor));
            // set To email field
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(persona.getCorreo()));
            message.setSubject("Feliz cumpleaños");
            message.setText(mensaje + persona.obtenerNombre());

            // send the email message
            Transport.send(message);

            System.out.println("Email Message Sent Successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException("Error al notificar por email", e);
        }
    }


}



