package com.httpapi.bmy.controller;

import com.httpapi.bmy.model.ResultModel;
import com.httpapi.bmy.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.MD5Utils;

import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value="用户登录接口，登录成功后会返回账号的基本信息，请前端自己保存基本信息后面需要用到", notes="用户登录接口，登录成功后会返回账号的基本信息，请前端自己保存基本信息后面需要用到")
    @ApiImplicitParams({
       @ApiImplicitParam(name = "phone", value = " 手机号(前端自己验证手机号合法性)", required = true, dataType = "String",paramType="query"),
       @ApiImplicitParam(name = "pwd ", value = " 用户密码", required = true, dataType = "String",paramType="query")

    })
     @RequestMapping(value="/login",method = RequestMethod.POST)
    public ResultModel index(@RequestBody Map<String,String> user ) {
        //System.out.println(MD5Utils.encode(user.get("pwd")));
        ResultModel model=userService.userLogin(user.get("phone"), MD5Utils.encode(user.get("pwd")));
        return model;
    }

    @ApiOperation(value="注册一个新账号", notes="注册一个新账号")
    @ApiImplicitParams({
         @ApiImplicitParam(name = "phone", value = " 手机号(前端自己验证手机号合法性)", required = true, dataType = "String",paramType="query"),
         @ApiImplicitParam(name = "pwd ", value = " 用户密码", required = true, dataType = "String",paramType="query"),
         @ApiImplicitParam(name = "nickname", value = "  昵称(显示在我的页面上)", required = true, dataType = "String",paramType="query")

    })
    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    public ResultModel addUser(@RequestBody Map<String,String> user ) {
        System.out.println(user.get("phone"));
        ResultModel model=userService.addUser(user.get("phone"), MD5Utils.encode(user.get("pwd")),user.get("nickname"));
        return model;
    }

    @ApiOperation(value=" 保存用户收货地址", notes=" 保存用户收货地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "truename", value = "用户真实姓名", required = true, dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "address", value = "收货地址", required = true, dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "uid", value = "用户id", required = true, dataType = "int",paramType="query")
    })
    @RequestMapping(value="/setAddress",method = RequestMethod.POST)
    public ResultModel setAddress(@RequestBody Map<String,String> user ) {
        int uid =Integer.parseInt(user.get("uid"));
        ResultModel model=userService.setAddress(user.get("truename"),user.get("address"),uid);
        return model;
    }




}
