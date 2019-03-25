package com.httpapi.bmy.dao;


import com.httpapi.bmy.model.User;

import java.util.List;

public interface UserDao {

    List<User> userLogin(String phone, String pwd);
    void addUser(String phone,String pwd,String nickname);
    void setAddress(String truename, String address,int uid);

}
