package com.httpapi.bmy.service.impl;

import com.httpapi.bmy.dao.UserDao;
import com.httpapi.bmy.model.User;
import com.httpapi.bmy.model.ResultModel;
import com.httpapi.bmy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.ResultUtil;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public ResultModel userLogin(String phone, String pwd) {
        List<User> userInfo = userDao.userLogin(phone,pwd);
        return userInfo.isEmpty() ? ResultUtil.Error("用户名或者密码错误") : ResultUtil.Success(userInfo);

    }

    @Override
    public ResultModel addUser(String phone, String pwd, String nickname) {

        try{
            userDao.addUser(phone,pwd,nickname);
        }catch(Exception e){
            e.printStackTrace();
            return ResultUtil.Error(e.getMessage());
        }
        return ResultUtil.Success(null);
/*

        ResultModel resultModel=new ResultModel();
        resultModel.setStatus(200);
        resultModel.setMessage("null");
        resultModel.setData(null);
*/

    }

    @Override
    public ResultModel setAddress(String truename, String address, int uid) {
        try{
            userDao.setAddress(truename,address,uid);
        }catch(Exception e){
            e.printStackTrace();
            return ResultUtil.Error(e.getMessage());
        }
        return ResultUtil.Success(null);
    }
}
