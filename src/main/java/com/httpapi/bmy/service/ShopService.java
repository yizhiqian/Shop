package com.httpapi.bmy.service;

import com.httpapi.bmy.model.Commodity;
import com.httpapi.bmy.model.ResultModel;
import com.httpapi.bmy.model.User;

import java.util.List;

public interface ShopService {

    ResultModel showPhones(int page);
    ResultModel getShopInfo (int id);
    ResultModel getShopClass(String brand);

}
