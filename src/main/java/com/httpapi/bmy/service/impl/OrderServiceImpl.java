package com.httpapi.bmy.service.impl;

import com.httpapi.bmy.dao.OrderDao;
import com.httpapi.bmy.model.Order;
import com.httpapi.bmy.model.ResultModel;
import com.httpapi.bmy.service.OrderService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.ResultUtil;

import java.util.HashMap;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private  OrderDao orderDao;

    @Override
    public ResultModel addShopOrder(List<HashMap> lis, String orderTotal, String money) {
        String timeTemper= System.currentTimeMillis()+"";
        int m=Integer.parseInt(money)-Integer.parseInt(orderTotal);
        String mon = String.valueOf(m);
        int uid= (int) lis.get(0).get("uid");
        try{
            orderDao.addShopOrder(lis,timeTemper);
            orderDao.delShopCar(uid);
            orderDao.updateMoney(mon,uid);
        }catch (Exception e){
            return ResultUtil.Error(e.getMessage());
        }

        return ResultUtil.Success(timeTemper);


    }

    @Override
    public ResultModel checkOrder(int userid, String status) {
        List<Order> list=orderDao.checkOrder(userid,status);
        return list.isEmpty()?ResultUtil.Error("没有订单"):ResultUtil.Success(list);
    }


}
