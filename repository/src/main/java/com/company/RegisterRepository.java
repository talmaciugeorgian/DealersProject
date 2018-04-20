package com.company;

import conversion.DtoToEntity;
import dto.Address;
import dto.User;
import entities.AddressEntity;
import entities.UsersEntity;
import enums.AccountType;
import enums.UserType;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RegisterRepository implements RegisterRepositoryInterface {

    @PersistenceContext(unitName = "myapp")
    private EntityManager em;

    public void setUser(User user) {
        UsersEntity userDto = DtoToEntity.convert(user);
        em.persist(userDto);
        em.flush();
    }
}
