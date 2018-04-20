package com.company;

import dto.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Stateless
public class RegisterService implements RegisterInterface {

    @EJB
    private RegisterRepositoryInterface userRegisterRepository;


    public boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public void createUser(User user) {
        try{
            userRegisterRepository.setUser(user);
        }catch(Exception e){
            e.printStackTrace();
        }
        sendRegistrationMessage(user);
    }
    public void sendRegistrationMessage(User user){
        final String username="testmailregapp@gmail.com";
        final String password="1youandme";

        Properties props=new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");

        Session session=Session.getInstance(props,new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        try{
            Message message=new MimeMessage(session);
            ((MimeMessage) message).setFrom(new InternetAddress(username));
            ((MimeMessage) message).setRecipients(Message.RecipientType.TO,InternetAddress.parse(user.getEmail()));
            message.setSubject("Confirm Registration!");
            ((MimeMessage) message).setText("To complete registration click here! http://localhost:8080/web/activation.xhtml?key="+user.getUsername());

            Transport.send(message);
        }catch(MessagingException e){
            e.printStackTrace();
        }
    }
}
