package com.httpapi.bmy.service.impl;


import com.httpapi.bmy.dao.ShopDao;
import com.httpapi.bmy.model.Commodity;
import com.httpapi.bmy.model.ResultModel;
import com.httpapi.bmy.model.User;
import com.httpapi.bmy.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.ResultUtil;

import java.util.List;

@Service("shopservice")
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;


    @Override
    public ResultModel showPhones(int page) {

        List<Commodity> ShopList = shopDao.showPhones(page*15,15);
        return ShopList.isEmpty() ? ResultUtil.Error("数据为空") : ResultUtil.Success(ShopList);

    }

    @Override
    public ResultModel getShopInfo(int id) {
        List<Commodity> infoList = shopDao.getShopInfo(id);
        return infoList.isEmpty() ? ResultUtil.Error("数据为空") : ResultUtil.Success(infoList);
    }

    @Override
    public ResultModel getShopClass(String brand) {
        List<Commodity> classinfoList = shopDao.getShopClass(brand);
        return classinfoList.isEmpty() ? ResultUtil.Error("无此类型手机") : ResultUtil.Success(classinfoList);
    }



}
