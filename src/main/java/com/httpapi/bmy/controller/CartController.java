package com.httpapi.bmy.controller;


import com.httpapi.bmy.model.ResultModel;
import com.httpapi.bmy.service.impl.CartServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.MD5Utils;

import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartServiceImpl cartService;

    @ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "userid 从登录接口中获取，用户登录成功后保存用户登录信息", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "shopid", value = "就是进详情后的商品id字段", required = true, dataType = "int", paramType = "query"),
    })
    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    public ResultModel addUser(@RequestBody Map<String, String> cart) {
        ResultModel model = cartService.addCart(Integer.parseInt(cart.get("userid")), Integer.parseInt(cart.get("shopid")));
        return model;
    }


    @ApiOperation(value = " 查找用户的购物车数据", notes = "购物车页面需要的接口，查看用户购物车有多少商品，这里只需要userid参数即可")
    @ApiImplicitParam(name = "userid", value = "userid 用户id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/selectCart", method = RequestMethod.POST)
    public ResultModel selectCart(@RequestBody Map<String, String> cart) {
        ResultModel model = cartService.selectCart(Integer.parseInt(cart.get("userid")));
        return model;
    }

    @ApiOperation(value = " 用户删除购物车中莫条商品时候使用", notes = "用户删除购物车中莫条商品时候使用，传入cid字段")
    @ApiImplicitParam(name = "cid", value = "cid 购物车表的id，前端的cid字段", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/deleteCart", method = RequestMethod.POST)
    public ResultModel deleteCart(@RequestBody Map<String, String> cart) {
        ResultModel model = cartService.deleteCart(Integer.parseInt(cart.get("cid")));
        return model;
    }

    @ApiOperation(value = " 检查商品是否已经被添加过购物车", notes = "检查商品是否已经被添加过购物")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid 用户id", value = "用户id", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "shopid 用户id", value = "商品id", required = true, dataType = "int", paramType = "query")

    })
    @RequestMapping(value = "/checkCart", method = RequestMethod.POST)
    public ResultModel checkCart(@RequestBody Map<String, String> cart) {
        ResultModel model = cartService.checkCart(Integer.parseInt(cart.get("userid")), Integer.parseInt(cart.get("shopid")));
        return model;
    }


}
