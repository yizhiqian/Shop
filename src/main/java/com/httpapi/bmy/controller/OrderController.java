package com.httpapi.bmy.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.httpapi.bmy.model.ResultModel;
import com.httpapi.bmy.service.impl.OrderServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @ApiOperation(value = "提交订单", notes = "用户填写完收货地址后，提交订单。order 参数是一个数组，里面存放着购物车中的商品信息，注意这些信息需要前端开发者自己计算并拼接字符串组成。")
    @ApiImplicitParams({
      @ApiImplicitParam(name = "order", value = "订单信息<数组>", required = true, dataType = "array", paramType = "query"),
      @ApiImplicitParam(name = "orderTotal", value = "购物车所有商品总价", required = true, dataType = "String", paramType = "query"),
      @ApiImplicitParam(name = "money ", value = "用户账户余额", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public ResultModel addOrder(@RequestBody Map<String, String> order) {
        //为order表增加购买数据
        //为cart表减去已经购买的商品
        // 减少用户表余额
        String str=order.get("order");
        List<HashMap> orderlist= JSONArray.parseArray(str,HashMap.class);     /*String转为List<Hashmap>*/
         return orderService.addShopOrder(orderlist,order.get("orderTotal"),order.get("money"));

    }

    @ApiOperation(value = "查看订单状态", notes = "查看用户订单状态，status 需要查看的状态，前端传：0: 未付款，1：订单完成，userid用户id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid ", value = "用户id", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "status ", value = " 订单状态", required = true, dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/checkOrder", method = RequestMethod.POST)
    public ResultModel checkOrder(@RequestBody Map<String, String> order) {
        return orderService.checkOrder(Integer.parseInt(order.get("userid")),order.get("status"));

    }

}
