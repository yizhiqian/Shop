package com.httpapi.bmy.service;

import com.httpapi.bmy.model.ResultModel;
import springfox.documentation.spring.web.json.Json;

import java.util.HashMap;
import java.util.List;

public interface OrderService {
    ResultModel addShopOrder( List<HashMap> lis, String orderTotal, String money);


    ResultModel checkOrder(int userid, String status);

}
