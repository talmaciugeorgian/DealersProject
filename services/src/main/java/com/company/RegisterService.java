package com.company;

import dto.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class RegisterService implements RegisterInterface {

    @EJB
    private RegisterRepositoryInterface userRegisterRepository;

    public User createUser(String username, String password, String firstName, String lastName, String email) {
        User temp_user=userRegisterRepository.setUser(username,password,firstName,lastName,email);
        return temp_user;
    }
}
