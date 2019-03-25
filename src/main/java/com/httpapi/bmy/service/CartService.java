package com.httpapi.bmy.service;

import com.httpapi.bmy.model.ResultModel;

public interface CartService {

    ResultModel addCart(int userid, int shopid);

    ResultModel selectCart(int userid);

    ResultModel deleteCart(int cid);

    ResultModel checkCart(int userid, int shopid);

}
