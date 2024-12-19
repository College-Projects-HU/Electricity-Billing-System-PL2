package com.example.electricity_billing_system.Utils;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class EmailUtil {
    // Method to send an email
    public static void sendEmail(String recipient, String subject, String messageBody) {
        // Email properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); // Enable authentication
        props.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS
        props.put("mail.smtp.host", "smtp.gmail.com"); // Gmail's SMTP server
        props.put("mail.smtp.port", "587"); // Gmail SMTP port

        // Authentication credentials
        final String username = ""; // Sender's email address
        final String password = ""; // Sender's email password

        // Create a session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        session.setDebug(true);

        try {
            // Compose the email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); // Set sender's email
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient)); // Set recipient's email
            message.setSubject(subject); // Set email subject
            message.setText(messageBody); // Set email body

            // Send the email
            Transport.send(message);


            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            System.err.println("Failed to send email: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
