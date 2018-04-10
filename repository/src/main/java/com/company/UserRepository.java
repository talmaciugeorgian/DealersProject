package com.company;

import dto.User;
import entities.UsersEntity;


import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote(UserRepositoryInterface.class)
public class UserRepository implements UserRepositoryInterface {
    @PersistenceContext(unitName = "myapp")
    private EntityManager em;

    public User convert(UsersEntity usersEntity){
        return new User(usersEntity.getId(),usersEntity.getUsername(),usersEntity.getPassword());
    }

    public User getUser(String username) {
        UsersEntity user= (UsersEntity) em.createNamedQuery("UsersEntity.getUsername").setParameter("name",username).getSingleResult();
        User userDto=convert(user);
        return userDto;
    }
}
