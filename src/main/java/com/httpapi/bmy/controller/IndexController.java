package com.httpapi.bmy.controller;

import com.httpapi.bmy.model.ResultModel;
import com.httpapi.bmy.service.impl.ShopServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import util.MD5Utils;

@RestController
@RequestMapping(value = "/shop")
public class IndexController {

    @Autowired
    private ShopServiceImpl shopservice;

    @ApiOperation(value="根据page获取分页数据", notes="根据page获取分页数据")
    @ApiImplicitParam(name = "page", value = "分页的页码", required = true, dataType = "int",paramType="query")
    @RequestMapping(value="/index",method = RequestMethod.GET)
    public ResultModel index(@RequestParam(value = "page",required = true,defaultValue = "0") int page) {
        ResultModel model=shopservice.showPhones(page);
        return model;
    }


  @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ApiOperation(value="根据id进入商品详情", notes="根据id进入商品详情")
    @ApiImplicitParam(name = "id", value = "商品的id", required = true, dataType = "int",paramType="query")
    public ResultModel info (@RequestParam(value = "id", required = true) int id) {
        return shopservice.getShopInfo(id);
    }

    /*@RequestMapping(value="/class",method = RequestMethod.GET)
    @ApiOperation(value=" 获取商品分类下的具体商品", notes=" 这边传入首页接口中获取到的id参数即可进入详情")
    @ApiImplicitParam(name = "brand ", value = "产品的品牌中文名称，提供的参数如下：", required = true, dataType = "String",paramType="query")
*/
    @RequestMapping(value = "/class",method = RequestMethod.GET)
    @ApiOperation(value="根据品牌分类获取参数", notes="根据品牌分类获取参数")
    @ApiImplicitParam(name = "brand", value = "商品的品牌", required = true, dataType = "String",paramType = "query")
    public ResultModel showShopClass(@RequestParam(value = "brand",required = true) String brand) {

        return shopservice.getShopClass(brand);

    }



}
