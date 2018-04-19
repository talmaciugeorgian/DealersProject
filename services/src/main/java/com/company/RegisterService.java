package com.company;

import dto.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

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
        userRegisterRepository.setUser(user);
    }
}
