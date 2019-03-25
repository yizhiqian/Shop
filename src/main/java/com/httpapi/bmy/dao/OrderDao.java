package com.httpapi.bmy.dao;

import com.httpapi.bmy.model.Order;

import java.util.HashMap;
import java.util.List;

public interface OrderDao {
    void addShopOrder(List<HashMap> lis ,String timeTemper);
    void delShopCar(int uid);
    void updateMoney(String mon,int uid);

    List<Order> checkOrder(int userid, String status);

}
