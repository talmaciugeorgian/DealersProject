package com.company;


import dto.User;


import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(UserInterface.class)
public class UserService implements UserInterface {

    @EJB
    private UserRepositoryInterface userRepository;

    public User checkUser(String username) {
        return userRepository.getUser(username);
    }
}
