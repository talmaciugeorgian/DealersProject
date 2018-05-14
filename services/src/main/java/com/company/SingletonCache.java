package com.company;

import dto.User;
import enums.UserType;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;

public class SingletonCache implements Cache {
    //Passed Object as type parameter to fix the warning issue
    private Map<Object, Object> map;

    //Constructor
    private static SingletonCache sc = new SingletonCache();

    //Only once instance is kept during the lifecycle of the application
    public static SingletonCache getInstance()
    {
        return sc;
    }

    //Private constructor to prevent instantiation
    private SingletonCache()
    {
        map = new HashMap<Object, Object>();
        //map.put("admin",new User("admin","admin",UserType.ADMIN));

    }
    //The warning is gone by using object
    //variable parameters in map
    public void put(Object key, Object value)
    {
        map.put(key, value);
    }

    public Object get(Object key)
    {
        return map.get(key);
    }
}