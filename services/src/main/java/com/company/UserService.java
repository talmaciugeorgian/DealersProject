package com.company;

import dto.User;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
public class UserService implements UserInterface {

    @EJB
    private UserRepositoryInterface userRepository;

    public User checkUser(String username) {
        User temp_user=userRepository.getUser(username);
        return temp_user;
    }
}
