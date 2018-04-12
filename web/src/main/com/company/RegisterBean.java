package com.company;


import dto.User;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "registerBean", eager = true)
@RequestScoped
public class RegisterBean {
    private String username;
    private String password;

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
            registerService.createUser(username,password);
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
}
