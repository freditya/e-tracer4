/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Relion31
 */
@RestController
@RequestMapping("/email")
public class EmailController {
    
//    @GetMapping("/send/{email}")
//    public String index(@PathVariable String email) throws UnsupportedEncodingException {
//        String result = "email gagal terkirim";
//
//        if (sendEmailBoolean(email, "Lupa Password", "Test")) {
//            result = "email terkirim";
//        }
//        return result;
//    }
//
//    public boolean sendEmailBoolean(String email, String subject, String message) throws UnsupportedEncodingException {
//        try {
//            Message msg = new MimeMessage(session());
//            msg.setFrom(new InternetAddress("okalanang.project@gmail.com", "E-TRACER"));
//
//            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
//            msg.setSubject(subject);
////        msg.setContent("Tutorials point email", "text/html");
//            msg.setSentDate(new Date());
//
//            MimeBodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setContent(message, "text/html");
//
////        Multipart multipart = new MimeMultipart();
////        multipart.addBodyPart(messageBodyPart);
////        MimeBodyPart attachPart = new MimeBodyPart();
////
////        attachPart.attachFile("/var/tmp/image19.png");
////        multipart.addBodyPart(attachPart);
////        msg.setContent(multipart);
//            Transport.send(msg);
//            return true;
//        } catch (MessagingException ex) {
//            return false;
//        }
//    }
//
//    public Session session() {
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("upnormal.bootcamp@gmail.com", "dan54bugi-bugi");
//            }
//        });
//
//        return session;
//    }
}
