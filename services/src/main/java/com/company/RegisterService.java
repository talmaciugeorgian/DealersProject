package com.company;

import dto.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class RegisterService implements RegisterInterface {

    @EJB
    private RegisterRepositoryInterface userRegisterRepository;

    public void createUser(User user) {
        userRegisterRepository.setUser(user);
    }
}
