package com.httpapi.bmy.service.impl;

import com.httpapi.bmy.dao.CartDao;
import com.httpapi.bmy.model.ResultModel;
import com.httpapi.bmy.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.ResultUtil;

import java.util.HashMap;
import java.util.List;

@Service("carService")
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Override
    public ResultModel addCart(int userid, int shopid) {
        try {
            cartDao.addCart(userid,shopid);
        }catch (Exception e){
            return ResultUtil.Error(e.getMessage());
        }

        return ResultUtil.Success("添加购物车成功");
    }

    @Override
    public ResultModel selectCart(int userid) {
        List<HashMap<String,Object>> list= cartDao.selectCart(userid);
        return list.isEmpty()?ResultUtil.Error("购物车为空"):ResultUtil.Success(list);
    }

    @Override
    public ResultModel deleteCart(int cid) {
        try {
            cartDao.deleteCart(cid);
        }catch (Exception e){
            return ResultUtil.Error(e.getMessage());
        }

        return ResultUtil.Success("删除商品成功");
    }

    @Override
    public ResultModel checkCart(int userid, int shopid) {
        List<HashMap<String,Object>> list= cartDao.checkCart(userid,shopid);
        return list.isEmpty()?ResultUtil.Error("商品已存在"):ResultUtil.Success(list);
    }
}
