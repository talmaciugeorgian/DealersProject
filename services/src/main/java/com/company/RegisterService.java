package com.company;

import dto.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class RegisterService implements RegisterInterface {

    @EJB
    private RegisterRepositoryInterface userRegisterRepository;

    public User createUser(String username, String password) {
        User temp_user=userRegisterRepository.setUser(username,password);
        return temp_user;
    }
}
