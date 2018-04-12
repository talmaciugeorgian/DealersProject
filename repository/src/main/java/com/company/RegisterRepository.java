package com.company;

import dto.User;
import entities.UsersEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Stateless
public class RegisterRepository implements RegisterRepositoryInterface{

    @PersistenceContext(unitName = "myapp")
    private EntityManager em;

    public UsersEntity convert(User user){
        return new UsersEntity(user.getUsername(),user.getPassword());
    }

    public User setUser(String username,String password) {
        User temp_user=new User(username,password);
        UsersEntity userDto=convert(temp_user);
        em.persist(userDto);
        em.flush();

        return null;
    }

}
