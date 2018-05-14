package com.company;

import dto.User;

import javax.ejb.Local;
import javax.persistence.NoResultException;

@Local
public interface UserInterface {
    public User checkUser(User user);
    public void activateUser(String username);
}
