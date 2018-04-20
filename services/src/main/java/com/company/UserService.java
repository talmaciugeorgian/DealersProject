package com.company;

import dto.User;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.NoSuchElementException;

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

    public User checkUser(String username) throws  NoSuchElementException{
        List<User> temp_user = userRepository.getUser(username);
        try{
            return temp_user.iterator().next();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public void activateUser(String username) {
        userRepository.activateUser(username);
    }
}
