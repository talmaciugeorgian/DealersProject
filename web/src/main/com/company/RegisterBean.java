package com.company;


import dto.Address;
import dto.User;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "registerBean", eager = true)
@RequestScoped
public class RegisterBean {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String postal_code;
    private String city;
    private String phone;

    private Address address;
    private User user;

    @EJB
    private UserInterface userService;

    @EJB
    private RegisterInterface registerService;

    public String validateUser(){
     //   user= userService.checkUser(username);
     //   if(user.getUsername().equals(username)) {
      //      return "failed";
       // }else {
        address=new Address(street,postal_code,city,phone);
        user=new User(username,password,firstName,lastName,email,address);
        registerService.createUser(user);
        return "userPage";
     //   }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
