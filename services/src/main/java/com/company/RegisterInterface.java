package com.company;

import dto.User;

import javax.ejb.Local;

@Local
public interface RegisterInterface {
    public void createUser(User user);
    public void sendRegistrationMessage(User user);
}
