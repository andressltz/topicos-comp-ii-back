package br.feevale.bolao.service;

import br.feevale.bolao.model.User;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class MailService {
    private static final String MAIL_ADDRESS = "bolao.feevale@gmail.com";
    private static final String MAIL_PASSWORD = "meda10sandra";

    public void sendMailChangePassword(User user) {
        String url = "http://localhost:8080/senha/" + user.getToken();

        StringBuilder sb = new StringBuilder();

        sb.append("<html><head><title>Bolão Feevale</title></head>");
        sb.append("<body>");
        sb.append("<h2>Bolão Feevale</h2>");
        sb.append("<h3>Cadastrar senha</h3>");
        sb.append("<p>Oi, ").append(user.getName()).append("</p>");
        sb.append("<p>Para cadastrar sua senha, acesse: ").append(url).append("</p>");
        sb.append("<br/><br/>");
        sb.append("</body></html>");

        sendMail(user.getEmail(), "Bolão Feevale - Senha", sb.toString());
    }

    private void sendMail(String to, String subject, String body) {
        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.socketFactory.port", "465");
            prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(MAIL_ADDRESS, MAIL_PASSWORD);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Bolao Feevale <noreply@bolaofeevale.com.br>"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setContent(body, "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
