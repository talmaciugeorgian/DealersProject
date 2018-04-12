package com.company;

import dto.User;
import entities.UsersEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RegisterRepository implements RegisterRepositoryInterface{

    @PersistenceContext(unitName = "myapp")
    private EntityManager em;

    public UsersEntity convert(User user){
        return new UsersEntity(user.getUsername(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getEmail());
    }

    public User setUser(String username, String password, String firstName, String lastName, String email) {
        User temp_user=new User(username,password,firstName,lastName,email);
        UsersEntity userDto=convert(temp_user);
        em.persist(userDto);
        em.flush();
        return temp_user;
    }
}
