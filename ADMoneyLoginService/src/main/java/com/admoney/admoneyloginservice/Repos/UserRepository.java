package com.admoney.admoneyloginservice.Repos;

import com.admoney.admoneyloginservice.models.User;
import com.admoney.admoneyloginservice.models.Status;

import java.util.HashMap;

public class UserRepository {
    private HashMap<String, User> repo=new HashMap<String,User>();

    public boolean addOrUpdateUser(User user){
        repo.put(user.getMobileNum(),user);
        return true;
    }

    public boolean isValidUser(String mobileNum){
        if(repo.containsKey(mobileNum) && repo.get(mobileNum).getStatus()== Status.SUCCESS)
            return true;
        return false;
    }
}
