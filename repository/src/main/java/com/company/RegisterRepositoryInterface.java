package com.company;

import dto.User;

import javax.ejb.Local;

@Local
public interface RegisterRepositoryInterface {
    public User setUser(String username, String password, String firstName, String lastName, String email);
}
