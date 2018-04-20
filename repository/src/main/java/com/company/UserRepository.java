package com.company;

import conversion.EntityToDto;
import dto.User;
import entities.UsersEntity;
import enums.AccountType;


import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class UserRepository implements UserRepositoryInterface {

    @PersistenceContext(unitName = "myapp")

    private EntityManager em;

    public List<User> getUser(String username){
        List<UsersEntity> user = (List<UsersEntity>) em.createNamedQuery("UsersEntity.getUsername").setParameter("name", username).getResultList();
        List<User> userDto = EntityToDto.convertUsersList(user);
        return userDto;
    }

    public void activateUser(String username) {
        UsersEntity user = (UsersEntity) em.createNamedQuery("UsersEntity.getUsername").setParameter("name", username).getSingleResult();
        user.setAccountType(AccountType.ACTIVE);
        em.merge(user);
    }
}
