package com.company;

import dto.User;
import entities.UsersEntity;

import javax.ejb.Local;
import javax.persistence.NoResultException;
import java.util.List;

@Local
public interface UserRepositoryInterface {
    public List<User> getUser(String username);
    public void activateUser(String username);
}
