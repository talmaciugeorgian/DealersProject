package com.company;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "activateBean")
@RequestScoped
public class ActivateBean {

    @ManagedProperty(value="#{param.key}")
    private String key;

    private boolean enabled=false;

    @EJB
    private UserInterface userService;

    @PostConstruct
    public void activate() {
        try{
            userService.activateUser(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        enabled=true;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
