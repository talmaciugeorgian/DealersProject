package com.company;

import dto.User;

import javax.ejb.Local;

@Local
public interface UserInterface {
    public User checkUser(String username);
}
