package com.httpapi.bmy.dao;

import com.httpapi.bmy.model.Commodity;
import com.httpapi.bmy.model.User;

import java.util.List;

public interface ShopDao {

    List<Commodity> showPhones(int StartPage, int TotalPage);
    List<Commodity> getShopInfo(int id);
    List<Commodity> getShopClass(String brand);

}
