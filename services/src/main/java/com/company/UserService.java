package com.company;


import dto.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(UserInterface.class)
public class UserService implements UserInterface {

    public User checkUser(String username) {
        return new User();
    }
}
