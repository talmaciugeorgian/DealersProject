package com.company;

import dto.User;
import entities.UsersEntity;

public interface UserRepositoryInterface {
    public User getUser(String username);
}
