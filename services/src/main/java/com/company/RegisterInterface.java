package com.company;

import dto.User;

import javax.ejb.Local;

@Local
public interface RegisterInterface {
    public User createUser(String username,String password);
}
