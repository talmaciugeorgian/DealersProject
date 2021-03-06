package com.company;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.interceptor.Interceptors;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.util.NoSuchElementException;

import com.company.util.SessionUtils;
import dto.User;
import enums.UserType;

@ManagedBean(name = "loginBean", eager = true)
@SessionScoped
public class LoginBean {
    private String username;
    private String password;
    private User user;
    private boolean admin = false;

    @EJB
    private UserInterface userService;

    @Interceptors(MyInterceptor.class)
    public String validateUsernamePassword(User user){
        User checkUser=new User(username,password,UserType.USER);
        user=userService.checkUser(checkUser);
        if (user == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Password", "Please enter correct username and Password "));
            return "login";
        } else {
            if (user.getPassword().equals(password)) {
                if (user.getUserType().equals(UserType.ADMIN)) {
                    admin = true;
                } else {
                    admin = false;
                }
                return "userHomePage";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Password", "Please enter correct username and Password "));
                return "login";
            }
        }
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void checkActivation() {
    }

    public String login() {
        return "logout";
    }

    public String logout() {
        return "login";
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

}
