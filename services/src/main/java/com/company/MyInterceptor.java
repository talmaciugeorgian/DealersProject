package com.company;

import dto.User;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.List;

public class MyInterceptor {
    @EJB
    private UserRepositoryInterface userRepository;

    @AroundInvoke
    public Object checkCache(InvocationContext context){
        try {
            Object[] parameters = context.getParameters();
            User user=(User)parameters[0];
            SingletonCache sc=SingletonCache.getInstance();

            User temp=(User)sc.get(user.getUsername());
            if(temp!=null){
                parameters[0]=temp;
                context.setParameters(parameters);
                return context.proceed();
            }else{
                List<User> tempList=userRepository.getUser(user.getUsername());
                sc.put(tempList.iterator().next().getUsername(),tempList.iterator().next());
                parameters[0]=tempList.iterator().next();
                context.setParameters(parameters);
                return context.proceed();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
