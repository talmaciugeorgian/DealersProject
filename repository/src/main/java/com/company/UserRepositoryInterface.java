package com.company;

import dto.User;
import entities.UsersEntity;

import javax.ejb.Local;

@Local
public interface UserRepositoryInterface {
    public User getUser(String username);
}
