package com.company;

import dto.User;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Stateless
public class UserService implements UserInterface {

    @EJB
    private UserRepositoryInterface userRepository;

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

    public User checkUser(String username) {
        User temp_user = userRepository.getUser(username);
        return temp_user;
    }
}
