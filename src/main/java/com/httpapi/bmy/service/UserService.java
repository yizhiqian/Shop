package com.httpapi.bmy.service;

import com.httpapi.bmy.model.ResultModel;

public interface UserService {
    ResultModel userLogin(String phone,String pwd);
    ResultModel addUser(String phone,String pwd,String nickname);
    ResultModel setAddress(String truename, String address, int  uid);

}
