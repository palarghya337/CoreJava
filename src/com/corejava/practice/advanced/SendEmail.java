package com.corejava.practice.advanced;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    private static final String FROM = "from@gmail.com";
    private static final String HOST = "smtp.gmail.com";
    private static final String PORT = "465";
    private static final String CONTENT_TYPE_HTML = "text/html";

    public static void main(String[] args) {
        try {
            SendEmail.sendMail("to@gmail.com ",
                    "Test Mail", "<p>Hi, </p><p>This mail I have sent programmatically," +
                            "and does not have any importance. You can ignore this mail.</p>" +
                            "<p><b><i>Thanks & Regards,</i></b><br>Arghya Pal");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public static void sendMail(String sendTo, String subject, String message) throws MessagingException {

        verifyEmail(sendTo);
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", PORT);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, "password");
            }
        });
        MimeMessage mimeMessage = createMessage(sendTo, subject, message, session);
        Transport.send(mimeMessage);
    }

    private static MimeMessage createMessage(
            String sendTo, String subject, String message, Session session) throws MessagingException {

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(FROM));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
            mimeMessage.setSubject(subject);
            mimeMessage.setContent(message, CONTENT_TYPE_HTML);
            return mimeMessage;
    }

    private static void verifyEmail(String sendTo) {

    }
}
