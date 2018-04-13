package com.company;

import dto.Address;
import dto.User;
import entities.AddressEntity;
import entities.UsersEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RegisterRepository implements RegisterRepositoryInterface{

    @PersistenceContext(unitName = "myapp")
    private EntityManager em;

    public AddressEntity convertAddr(Address address){
        return new AddressEntity(address.getStreet(),address.getPostalCode(),address.getCity(),address.getPhone());
    }

    public UsersEntity convert(User user){
        AddressEntity temp_address=convertAddr(user.getAddress());
        return new UsersEntity(user.getUsername(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getEmail(),temp_address);
    }

    public void setUser(User user) {
        UsersEntity userDto=convert(user);
        em.persist(userDto);
        em.flush();
    }
}
