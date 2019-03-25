package com.httpapi.bmy.dao;

import com.httpapi.bmy.model.ResultModel;

import java.util.HashMap;
import java.util.List;

public interface CartDao {
    void addCart(int userid, int shopid);
    List<HashMap<String, Object>> selectCart(int userid);
    void deleteCart(int cid);
    List<HashMap<String, Object>> checkCart(int userid, int shopid);

}
