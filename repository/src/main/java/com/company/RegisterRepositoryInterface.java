package com.company;

import dto.User;

import javax.ejb.Local;

@Local
public interface RegisterRepositoryInterface {
    public void setUser(User user);
}
